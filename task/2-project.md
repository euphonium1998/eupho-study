## 本文进行后续学习的开源项目介绍
### 前端
请clone该仓库代码<https://github.com/PanJiaChen/vue-element-admin>

clone之后按照官方网站<https://panjiachen.gitee.io/vue-element-admin-site/zh/guide/#%E5%AE%89%E8%A3%85>的指南进行项目安装，做到可以在windows本地跑起来代码即可。保证npm可以正常下载代码即可。项目将计划与七月末开始学习。

推荐使用`npm install --registry=https://registry.npm.taobao.org`指令进行安装，并且在WebStrom的terminal输入指令。
### 后端
1.请clone该仓库代码<https://github.com/xkcoding/spring-boot-demo>

该仓库代码主要以demo的形式进行springboot框架的各个常用工具，便于基础学习。该仓库将在七月初开始学习。

2.请clone该仓库代码<https://github.com/elunez/eladmin>

该仓库为springboot开源项目，请按照官网<https://el-admin.vip/guide/ksks.html>进行后端配置即可，保证maven下载包正常，`pom.xml`文件没有出现红字出错即可。该仓库将在掌握springboot框架基础之后进行学习。

由于该后端仓库需要配置相关的数据库和缓存信息，在官网的教程中在本地配置，需要各位下载MySQL和Redis。为了节省大家配置的时间。上述两个软件将由本人进行统一部署，各位只需要修改下方提到的代码即可。

将`eladmin-system/src/main/resources/config/application.yml`第24-31行做如下修改：（由于目前的策略会存在安全隐患，后续还需要修改）
```
  redis:
    #数据库索引
    database: ${REDIS_DB:0}
    host: ${REDIS_HOST:hitszices.redis.rds.aliyuncs.com}
    port: ${REDIS_PORT:6379}
    password: ${REDIS_PWD:hitsz_2021}
    #连接超时时间
    timeout: 5000
```
将`eladmin-system/src/main/resources/config/application-dev.yml`和`eladmin-system/src/main/resources/config/application-prod.yml`第7行和第9行都做如下修改：
```
url: jdbc:log4jdbc:mysql://${DB_HOST:120.24.22.88}:${DB_PORT:3306}/${DB_NAME:eladmin}?serverTimezone=Asia/Shanghai&characterEncoding=utf8&useSSL=false
```
```
password: ${DB_PWD:icesCosine2020.}
```
修改完文件之后按照官网指引，在IDEA中直接运行`AppRun`观察是否报错即可。推荐将项目的前端仓库代码也下载下来，然后按照指引在本地启动前端和后端项目，如果登录界面可以进行登录加载到主界面就行了。下载前端项目需要预先安装node的环境编辑器可以选择WebStorm(推荐)或者直接用VS Code也行。因为各位负责后端的同学只要启动项目即可。

针对前端项目安装过程npm的部分错误解决请见下文：

Q1：`npm ERR! D:\Program Files\Git\cmd\git.EXE ls-remote -h -t https://github.com/nhn/raphael.git`

A1：查看`git --global --list`不要有多余的设定比如http.sslveirfy等。git只要保有user的设定即可。




