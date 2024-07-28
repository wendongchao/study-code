Ruoyi-cloud-plus文档

https://plus-doc.dromara.org/#/ruoyi-cloud-plus/quickstart/deploy

准备服务器（咸鱼上买）

在服务器上安装centos，

安装Docker：https://cloud.tencent.com/developer/article/1701451

本地Docker文档：/Users/wendongchao/study/ruoyi-docker

# 前端

前端项目：https://gitee.com/JavaLionLi/plus-ui

没有使用NGINX的话，前端修改文件.env.development

![image-20240728220514448](/Users/wendongchao/code/idea/study-code/项目/RuoYi-Cloud-Plus.assets/image-20240728220514448.png)

# 后端

服务器已经安装好Docker后，idea设置ssh,sftp，并通过Docker-ca使idea连接服务器上的Docker

设置docker-compose：查看本地Docker文档

设置ssh,sftp：查看若依文档

设置Docker-ca：notion中的Docker

把项目中的/docker 文件夹上传到服务器上，并赋予全部权限

```chmod -R 777 /docker```

查看docker-compose.yml中的信息拉取镜像，MySQL，Redis

配置项目中的服务器地址信息：查看若依文档

本地构建nacos镜像并上传到服务器

在nacos的Dockerfile文件中引用```FROM openjdk:17```其他的不能启动nacos

启动Docker中的镜像根据docker-compose命令，MySQL，Redis，nacos，

导入数据到MySQL：查看若依文档

把项目中/configs下的文件复制到nacos中并修改服务器地址信息：查看若依文档

修改项目pom.xml中服务器地址

启动项目gateway，Auth，system测试下，启动成功后，启动前端项目：查看若依文档

配置elk：查看若依文档















