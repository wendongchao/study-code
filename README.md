# 学习编码总结

参考资料：https://www.cnblogs.com/jajian/p/11833179.html

# Java基础

## 基础



* [学会反射后，我被录取了（干货）](https://juejin.cn/post/6864324335654404104#heading-7)
* [泛型系统学习](https://github.com/hanchao5272/mygenerics)







## 集合

* [面渣逆袭：Java集合连环三十问](https://juejin.cn/post/7040997503247843365?utm_source=gold_browser_extension)

- [周末我把HashMap源码又过了一遍](https://www.cnblogs.com/jajian/p/13965678.html)
- [Java7 和 Java8 中的 ConcurrentHashMap 原理解析](https://www.cnblogs.com/jajian/p/10385377.html)



## JVM

- [Java对象的内存布局](https://www.cnblogs.com/jajian/p/13681781.html)
- [MapStruct 解了对象映射的毒](https://www.cnblogs.com/jajian/p/13937897.html)

- [Java中自定义注解](https://www.cnblogs.com/jajian/p/9576466.html)
- [Java函数式编程和lambda表达式](https://www.cnblogs.com/jajian/p/9757350.html)
- [程序员你为什么这么累 | 编码规范](https://www.cnblogs.com/jajian/p/9861527.html#autoid-2-6-0)
- [一个正则表达式引发的血案](https://www.cnblogs.com/jajian/p/9900477.html)
- [全解史上最快的JOSN解析库 - alibaba Fastjson](https://www.cnblogs.com/jajian/p/10051901.html)
- 深入分析 Java SPI 机制和原理
- [对Java中HashCode方法的深入思考](https://www.cnblogs.com/jajian/p/11306471.html)
- [通俗易懂讲布隆过滤器](https://www.cnblogs.com/jajian/articles/12749928.html)



# 计算机网络

- [TCP三次握手原理，你真的了解吗？](https://www.cnblogs.com/jajian/p/9783809.html)
- [“三次握手，四次挥手”你真的懂吗？](https://www.cnblogs.com/jajian/p/10306629.html)



# 数据库

## Redis

* [16张图带你吃透Redis架构演进](https://zhuanlan.zhihu.com/p/349241304)
* [把Redis当作队列来用，真的合适吗？](https://zhuanlan.zhihu.com/p/372548326)
* [Redis为什么变慢了？一文讲透如何排查Redis性能问题 | 万字长文](https://zhuanlan.zhihu.com/p/346302897)
* [Redis最佳实践：7个维度+43条使用规范，带你彻底玩转Redis | 附最佳实践清单](https://zhuanlan.zhihu.com/p/354486475)

* [颠覆认知——Redis会遇到的15个「坑」，你踩过几个？](https://zhuanlan.zhihu.com/p/360971755)



## MySQL

* [MySQL实战45讲](https://time.geekbang.org/column/intro/100020801)



# 设计模式

- [Template模板模式](https://www.cnblogs.com/jajian/p/9729939.html)
- [Decorator装饰模式](https://www.cnblogs.com/jajian/p/9729989.html)
- [Adapter适器模式](https://www.cnblogs.com/jajian/p/9736164.html)
- [Proxy代理模式](https://www.cnblogs.com/jajian/p/9691221.html)
- [Strategy策略模式](https://www.cnblogs.com/jajian/p/9740271.html)
- [责任链模式](https://www.cnblogs.com/jajian/p/9743922.html)
- [Observer观察者模式](https://www.cnblogs.com/jajian/p/9746433.html)
- [Builder建造者模式](https://www.cnblogs.com/jajian/p/9749138.html)



# 并发编程

## Executors线程池

- [线程池其实看懂了也很简单](https://www.cnblogs.com/jajian/p/11442929.html)
- [线程数究竟设多少合理](https://www.cnblogs.com/jajian/p/10862365.html)

## 并发编程 Lock 锁

- Lock
- 可重入锁Reetrantlock
- 可重入读写锁ReetrantReadWriteLock
- Condition
- ReadWriteLock
- LockSupport

## 并发类编程工具

- CountDownLatch
- CyclicBarrier
- Semaphore
- Exchange

## 并发编程容器collections

- 并发Queue：BlockingQueue
- Map：ConcurrentHashMap、HashMap、HashTable
- 并发List Set：CopyOnWriteArrayList、CopyOnWriteArraySet、
- ArrayList、 LinkedList
- ConcurrentHashMap为何如此优秀?

## 内存模型

- Condition
- 简单却强大的 CAS
- AQS的原理浅析
- 重排序、可见性、顺序一致性
- happens-before详解
- Synchronized详解
- Volatile详解
- ThreadLocal详解

# 分布式

## 分布式协调Zookeeper

- Zookeeper快速上手使用
- Zookeeper集群部署
- Zookeeper应用场景深入分析
- Zookeeper的znode watcher ACL、
- 客户端API详解
- Zookeeper客户端源码分析
- Zookeeper的日志与监控
- 搭建3个节点的Zookeeper集群
- 深入分析Zookeeper在Disconf配置中心的应用
- 基于Zookeeper的分布式锁解决方案
- Zookeeper Watcher核心机制深入源代码分析
- Zookeeper 集群升级、迁移
- 基于Zookeeper实现分布式服务器动态上下线感知
- 深入分析Zookeeper Zab协议及选举机制源代码

## 分布式框架Dubbo

- Dubbo管理中心及监控平台安装部署
- Dubbo分布式服务器模块划分（领域驱动）
- 基于Dubbo的分布式系统架构实战
- Dubbo负载均衡策略分析
- Dubbo服务调试之服务只订阅及服务只注册配置
- Dubbo服务接口的设计原理
- Dubbo设计原理及源代码分析
- 基于Dubbo构建大型分布式电商平台实战雏形
- Dubbo容错机制及高扩展性分析

## 分布式消息队列 - RabbitMQ

- RabbitMQ快速上手使用
- RabbitMQ消息发送机制详解
- RabbitMQ消息路由机制分析
- RabbitMQ消息确认机制分析
- RabbitMQ高可用集群部署实践
- [互联网面试必杀：如何保证消息中间件全链路数据100%不丢失：第一篇](https://www.cnblogs.com/jajian/p/10257555.html)
- [互联网面试必杀：如何保证消息中间件全链路数据100%不丢失：第二篇](https://www.cnblogs.com/jajian/p/10293093.html)
- [互联网面试必杀：如何保证消息中间件全链路数据100%不丢失：第三篇](https://www.cnblogs.com/jajian/p/10293391.html)
- [互联网面试必杀：如何保证消息中间件全链路数据100%不丢失：第四篇](https://www.cnblogs.com/jajian/p/10293422.html)

## 分布式消息队列 - Kafka

- Kafka基于Zookeeper搭建高可用集群实战
- Kafka消息处理过程剖析
- Java客户端实现Kafka生产者与消费者实例
- Kafka的副本机制及选举原理剖析
- 基于Kafka实现应用日志实时上报统计分析

## 分布式消息队列 - RocketMq

- 待定

## 分布式缓存Redis

- 缓存击穿、穿透、雪崩预防策略
- 精通Redis的数据结构
- Redis主从复制原理及无磁盘复制分析
- Redis管道模式详解
- Redis缓存与数据库一致性解决方案
- 基于Redis实现分布式锁
- Redis中AOF和RDB持久化策略原理
- Redis读写分离架构
- Redis哨兵架构及数据丢失问题分析
- Redis Cluster数据分布算法之Hash Slot
- Redis使用常见问题及性能优化
- Redis高可用及高伸缩架构实战
- Redis批量查询优化
- Redis高性能集群之Twemproxy Or Codis

## 搜索引擎 - Elasticsearch

- [全文搜索引擎 ElasticSearch 还是 Solr？](https://www.cnblogs.com/jajian/p/9801154.html)
- [Elasticsearch 技术分析（一）： 基础入门](https://www.cnblogs.com/jajian/p/9976900.html)
- [Elasticsearch 技术分析（二）： 索引映射Mapping问题](https://www.cnblogs.com/jajian/p/10134164.html)
- [Elasticsearch 技术分析（三）： 索引别名Aliases问题](https://www.cnblogs.com/jajian/p/10152681.html)
- [Elasticsearch 技术分析（四）： 分布式工作原理](https://www.cnblogs.com/jajian/p/10176604.html)
- [Elasticsearch 技术分析（五）：如何通过SQL查询Elasticsearch](https://www.cnblogs.com/jajian/p/10053504.html)
- [Elasticsearch 技术分析（六）： 自动发现机制 - Zen Discoveryedit](https://www.cnblogs.com/jajian/p/10176707.html)
- [Elasticsearch 技术分析（七）： Elasticsearch 的性能优化](https://www.cnblogs.com/jajian/p/10465519.html)
- [Elasticsearch 技术分析（八）：剖析 Elasticsearch 的索引原理](https://www.cnblogs.com/jajian/p/10737373.html)
- [Elasticsearch 技术分析（九）：Elasticsearch基础和原理总结](https://www.cnblogs.com/jajian/p/11223992.html)

## 分布式数据扩容 - MyCat

- Mycat读写分离
- Mycat水平切分
- Mycat垂直切分
- 基于Mycat分库分表策略剖析
- Mycat全局序列号
- Mycat全局表 ER表 分片策略分析
- Mycat高可用架构方案实践
- 数据库中间件初始Mycat
- 基于Mycat实现mysql数据库读写分离
- 基于Mycat实战之数据库切分策略剖析
- Mycat全局表、Er表、分片策略分析
- Sharding-jdbc

## 数据存储

- Nosql简介及Mongodb基本概念
- MongoDB支持的数据类型分析
- MongoDB可视化客户端及Java api实践
- 手写基于MongoDB的Orm框架
- MongoDB企业级集群解决方案
- MongoDB聚合、索引及基本执行命令
- MongoDB数据分片、转存及恢复策略
- Mysql主从复制及读写分离
- Mysql+Keepalived实战双主高可用方案实践
- Mysql高性能解决方案之分库分表
- [必须掌握的Mysql优化指南](https://www.cnblogs.com/jajian/p/9758192.html)
- 理解Mysql底层B+树机制
- SQL执行计划详解
- 索引优化详解
- SQL语句优化

## 后台服务

- 基于Openresty部署应用层Nginx及Nginx+Lua实践
- Nginx反向代理服务器及负载均衡服务器配置实战
- 利用Keepalived+Nginx实践Nginx高可用方案
- 基于Nginx实现访问控制、连接限制
- Nginx动静分离实战
- Nginx Location、Rewrite等语法配置及原理分析
- Nginx提供Https服务
- 基于Nginx+Lua完成访问流量是实时上报Kafka实战

## 高性能Nio框架

- IO的基本概念，Nio、Aio、Bio深入分析
- Nio的核心设计思想
- Netty产生的背景及应用场景分析
- 基于Netty实现高性能IM聊天
- 基于Netty实现dubbo多协议通信支持
- Netty无锁化串行设计及高并发处理机制
- 手写实现多协议Rpc框架
- [Netty、Kafka中的零拷贝技术到底有多牛?](https://www.cnblogs.com/jajian/articles/12844821.html)

## 分布式解决方案

- [分布式全局ID生成方案](https://www.cnblogs.com/jajian/p/11101213.html)
- 分布式事务解决方案实战
- 基于分布式架构下分布式锁的解决方案
- 高并发下的服务降级、限流实战
- 分布式架构下实现分布式定时调度
- [分布式系统中session一致性问题](https://www.cnblogs.com/jajian/p/10962989.html)
- [分布式系统中一致性哈希算法](https://www.cnblogs.com/jajian/p/10896624.html)
- [分布式系统中接口的幂等性](https://www.cnblogs.com/jajian/p/10926681.html)
- [终于有人把“TCC分布式事务”实现原理讲明白了!](https://www.cnblogs.com/jajian/p/10014145.html)

# 微服务

## 漫谈微服务架构

* [CAP 定理的含义](https://www.ruanyifeng.com/blog/2018/07/cap.html)

- SOA架构和微服务架构之间的区别和联系
- 如何设计微服务及其设计原则
- 解惑Spring Boot流行因素及能够解决什么问题
- 什么是Spring Cloud，为何要选择Spring Cloud
- [从单体架构升级到微服务，在代码层面应注意的一些问题](https://www.cnblogs.com/jajian/p/11101196.html)
- [什么是链路追踪？分布式系统如何实现链路追踪？](https://zhuanlan.zhihu.com/p/344020712)

## SpringBoot框架

- Springboot与微服务之间的关系
- Springboot热部署
- SpringBoot快速上手应用
- SpringBoot核心配置详解
- SpringBoot集成MyBatis Redis ActiveMQ、
- RabbitMQ Dubbo等
- SpringBoot计策模板引擎Thymeleaf Freemarker
- SpringBoot核心注解详解
- Spring启动器starter原理深入分析
- Springboot集成Mybatis实现多数据源路由实战
- Springboot集成Dubbo
- Springboot集成Redis缓存
- Springboot集成Swagger2构建Api管理及测试体系
- Springboot实现多环境配置动态解析

## Spring Cloud组件

- [拜托！面试请不要再问我Spring Cloud底层原理](https://www.cnblogs.com/jajian/p/9973555.html)
- Eureka注册中心
- Ribbon集成REST实现负债均衡
- Fegion声明式服务调用
- Hystrix服务熔断降级方式
- Zuul实现微服务网关
- Config分布式统一配置中心
- Sleuth调用链路跟踪
- Bus消息总线
- 基于Hystrix实现接口降级实战
- Springboot集成Spring Cloud实现统一整合方案

## Docker虚拟化

- Docker的镜像、仓库、容器
- Docker File 构建LNMP环境部署个人博客WordPress
- Docker网络组成、路由互联、Openvswitch
- 基于Swarn构建Docker集群实战
- Kubernetes简介
- [idea连接Docker](./微服务/Docker/Docker.md)

# 性能优化

## JVM调优

- JVM内存模型
- GC方法
- GC收集器及使用场景
- 理解GC日志
- 实战MAT分析dump文件
- [系统运行缓慢，CPU 100%，以及Full GC次数过多问题的排查思路](https://www.cnblogs.com/jajian/p/10578628.html)

## Tomcat调优

- 探查Tomcat的运行机制及框架
- 分析Tomcat线程模型
- Tomcat体系结构解读
- Tomcat启动流程分析
- Tomcat对Http请求的处理流程分析
- Tomcat核心组件认识
- Tomcat性能调优
- Tomcat连接并发参数解读
- Tomcat server.xml详解

# 大数据处理

## 流框架Flink

- Flink架构、原理与部署测试

# 源码分析

## Spring5

- IOC/DI
- IOC容器设计原理及高级特性
- AOP设计原理
- FactoryBean与BeanFactory
- Spring Bean的生命周期
- Spring事务处理机制
- [Spring事务失效的 8 大原因](https://www.cnblogs.com/jajian/articles/12844069.html)
- [面试中被问Spring循环依赖的三种方式！！!](https://www.cnblogs.com/jajian/p/10241932.html)
- [Spring如何在一个事务中开启另一个事务](https://www.cnblogs.com/jajian/articles/12836743.html)
- 手写SpringMVC框架

## Mybatis

- [Mybatis 批量更新遇到的小问题](https://www.cnblogs.com/jajian/p/13949968.html)
- 代码自动生成器：Generateor
- Mybatis关联查询，嵌套查询
- 一级缓存、二级缓存使用场景及选择策略
- 分析Mybatis的动态代理的真正实现

# 项目实例



# 数据结构&算法

* 滑动窗口算法

# Go语言

- 待定

# 区块链

- 待定

# 机器学习

- 待定

# 工程化与工具

## Maven

- 生成可执行jar、理解scope生成最精确的jar
- 类冲突、包依赖NoClassDefFoundError问题定位及解决
- 架构师必备之Maven生成Archetype
- Nexus使用、上传、配置
- 对比Gradle

## Git

- 什么是Git以及Git工作原理
- Git常用命令(避坑教学)
- Git冲突怎么引起的，如何解决
- 架构师的职责：Git Flow规范团队Git使用规范

## Jekins

- 搭建Jenkins自动部署环境
- Jenkins集成maven、git实现自动部署
- test/pre/pro 多环境发布
- Jenkins多环境配置、权限管理及插件使用

## IntelliJ IDEA

* [IDEA激活码](https://www.ajihuo.com)
* [常用插件](./工具/IDEA.md)

- [通过IDEA快速定位和排除依赖冲突](https://www.cnblogs.com/jajian/p/11002521.html)

## canal

## GitHub

[搜集的链接](./工具/GitHub.md)



## Arthas

[github地址](https://github.com/alibaba/arthas)





# 随笔杂文

