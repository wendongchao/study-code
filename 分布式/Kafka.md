# 是什么？

## 1、概述

kafka是一个消息队列中间件

具有以下特性：

* 高吞吐量，低延迟：每秒处理几十万消息，延迟最低几毫秒
* 分布式架构：多台机器分布式部署，具有良好的容错性和扩展性
* 持久化，可靠性：消息持久化到本地磁盘
* 高并发：支持上千客户端同时读写

## 2、重要概念

![在这里插入图片描述](/Users/wendongchao/code/idea/study-code/分布式/Kafka.assets/大概结构图.png)

* Producer：消息生产者

* Kafka Cluster：kafka集群，包含多个实例节点broker

* broker：是kafka实例，每台服务器上有一个或多个kafka实例，姑且认为每个broker对应一个服务器，kafka集群中每个broker都有不同的编号

* Topic：消息的主题，可以理解为消息的分类，kafka的数据保存在Topic中。一个broker中可以创建多个Topic

* partition：Topic的分区，每个Topic可以有多个分区，分区的作用是做负载，提高kafka的吞吐量，同一个Topic中不同分区的数据是不重复的，partition表现形式是一个个文件夹。

* replication：每个分区有多个副本，其中一个是leader（主），其他是follower（副），leader出现问题，kafka会从follower中选一个成为leader，kafka中默认分区的副本最多10个，且副本的数量不大于broker数量（均匀分布），同一个broker同一个Topic中不能同时存在一个分区的2个副本

* Consumer Group：消费组，可以将多个消费者组成一个消费组，kafka中同一分区的消息只能被同一消费组中一个消费者消费，如果想被多个Consumer消费，那么Consumer需要在不同组

* Consumer：消息消费者

* zookeeper：kafka依赖zookeeper存储集群的元数据信息，保证系统的可用性

* message：kafka中一条消息主体

![image-20240523164040434](/Users/wendongchao/code/idea/study-code/分布式/Kafka.assets/大概结构图02.png)

> 一个服务器中可以有多个broker，一个broker中有多个消息主题Topic，一个Topic中有多个分区partition，同一分区分为多个副本，副本有一个leader和多个follower，同一个broker中不能同时存在同一分区的多个副本（例如：broker中不能同时存在partition 0的leader和follower，即使在不同Topic中）



## 3、流程操作

> kafka在发送数据与消费数据时，只找leader分区

### 1）、发送数据

![在这里插入图片描述](/Users/wendongchao/code/idea/study-code/分布式/Kafka.assets/发送数据.png)

消息写入leader后，follower主动从leader进行同步数据，

producer采用push模式将数据写入到分区中，每条消息是追加到分区中并**顺序写入磁盘**，所以保证同一分区内的数据是有序的。

![在这里插入图片描述](/Users/wendongchao/code/idea/study-code/分布式/Kafka.assets/分区写数.png)

分区的作用：

1. 方便扩展：一个Topic有多个分区，通过增加机器创建分区来应对日益增长的数据量
2. 提高并发：以partition为读写单位，可以多个消费者同时消费，提高消息的处理效率

Topic中有多个分区，producer发送数据时应该往哪个分区发送呢，kafka提供了以下几种原则：

1. 发送时如果有指定partition，那么就写入对应的partition
2. 如果没有指定partition，但是设置了数据的key，那么会根据key的hash值选一个partition
3. 如果这些都没有，那么会轮询选一个partition

producer向kafka写入消息时，怎么保证消息的不丢失？

kafka通过ack应答机制，保证producer写入队列中的数据不丢失，可以从上图步骤6可以看出，这个ack应答机制可以配置，具体如下：

* 0：producer只要把消息发送到leader就行了，也就是只进行到步骤2，不保证消息发送成功，安全性最低单效率最高
* 1：producer把消息发送到leader后，只需要leader进行ack确认，就可以发送下一条数据
* -1：producer把消息发送到leader后，需要所有副本都ack确认，才能发送下一条数据

> 如果往不存在的Topic中发送数据，kafka会自动创建Topic，分区和副本的数量默认为1



### 2）、保存数据

producer把消息写入到kafka后，kafka会把数据顺序保存到磁盘中，这里看下数据的保存结构

**partition结构**

![在这里插入图片描述](/Users/wendongchao/code/idea/study-code/分布式/Kafka.assets/分区结构.png)

partition在服务器上表现形式是一个文件夹，文件夹下会有多组segment文件，每组segment文件包含3个部分

* index：索引信息
* log：存储message的地方，以**信息块**存储，每个信息块包含message，多个信息块
* timeindex：索引信息

segment中log文件默认大小1G，但是存储message数量不同（每个message大小不一样），文件的命名是该segment最小偏移量offset来命名的，（例如：000.index存储的偏移量offset0~368795的消息）kafka就是通过分段+索引的方式来解决查找效率的问题

**信息块**

log中存储message，message是以信息块存储的，信息块的包含消息体，消息大小，offset，压缩类型...等等，这里主要介绍3个

* offset：占8byte，是一个有序ID，可以唯一确定消息所在分区的位置
* 消息大小：占4byte，描述消息大小
* 消息体：实际消息数据（被压缩）

![image-20240523181434364](/Users/wendongchao/code/idea/study-code/分布式/Kafka.assets/信息块.png)

**删除策略**

kafka会保留所有消息，不论这个消息会不会消费，但是时间长了数据太多，磁盘就存不下了，这里kafka提供了2种删除策略

1. 基于时间：默认配置168小时（7天），删除7天之前的日志
2. 基于文件大小：默认配置1073741824，保留最后1073741824数据，删除其余数据

这里删除文件不会影响kafka读取文件的性能，因为是通过索引文件快速定位到特定消息，不需要遍历整个分区partition（时间复杂度为O(1)）



### 3）、消费数据

kafka在操作消息队列时使用订阅模式，消费者订阅对应的分区partition，并主动从leader拉取消息

![在这里插入图片描述](/Users/wendongchao/code/idea/study-code/分布式/Kafka.assets/消费数据.png)

消费者的数量建议与partition分区数量一致

如果查找offset=368801的message怎么找

![image-20240524140113654](/Users/wendongchao/code/idea/study-code/分布式/Kafka.assets/查找数据.png)

1、先根据二分查找，找到segment2，从segment2的index文件开始

2、index存储的格式是稀疏索引，第一位是偏移量，第二位是物理地址，368801-368796=5，根据二分查找小于等于偏移量offset的位置，查找到偏移量4，物理地址256，打开文件从256地方顺序扫描，找到offset位368801的message。

这套机制是建立在offset有序的基础上的，利用segment+有序offset+稀疏索引+二分查找+顺序查找等多种手段来高效的差找数据



# 怎么用？

## 1、Demo流程



# 原理深入（为什么这么设计）









# 实例应用







# 总结

# 附录

参考链接：https://blog.csdn.net/weixin_45366499/article/details/106943229

高质量链接：https://layne.blog.csdn.net/article/details/120477108?spm=1001.2014.3001.5502





