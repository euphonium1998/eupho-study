## 本文为暑期学习的8月详细计划

### 前端
各位在七月学习完前端基础后，八月将进行Vue框架学习和实践。同时针对重点业务进行理解

第一周：为后端部分编写的服务编写前端页面。不要求页面美观，只要清楚完成功能即可。需要在这一周学习掌握使用Vue、elementUI、axios和vue-router的基础使用。

第二周至第四周：分析具体业务场景的前端部分编写。具体业务以及代码由前一周分享会后给出。

### 后端
各位在七月末完成最简单demo搭建之后，将在这个demo的基础上学习使用常见的中间件以及理解后端部分重点业务的业务逻辑处理。

第一周：学习使用将数据库查询结果分页以及打日志

第二周：学习登录权限判断逻辑

第三周~第四周：待定

### 8.1后端部分搭建demo

详细demo见仓库src/demo。跑通这个springboot程序，确保可以连接数据库，明白开放的两个接口应该如何请求。同时我将会在周四晚上前提供六个接口需要各位进行编码。负责后端的同学每个人编写两个接口并根据之前的git上传合并的方法上传到github我们周天统一进行讲解。

任务分配如下：1~2李萌负责。3~4王浩睿负责。5~6王恺存负责。

1. 返回products表格中价格不低于x的product_name和product_desc。x为输入，输入类型为字符串（注意数据库的price是用decimal这个类型存储上网搜索一下如何转换）

2. 往customers表格中插入一条新的数据。输入为新数据的json格式通过post方法传递给后端。

3. 查询order_num为x的cust_name和cust_city。x为前端输入类型为int

4. 删除orderitems表格中order_num为x，order_item为y的那一行数据。其中x, y为输入参数，类型皆为int

5. 查询prod_id为x的vendor_name和vendor_address。输入x类型为int

6. 将productnotes表格中note_id为x的那一行的note_text修改为y。其中x和y均为输入。x为int，y为string

数据库中的数据在个人学习测试更新之后，要跑一下resources/db下的两个脚本。重新格式化数据。

前端部分的同学也要抓紧学习了，这两周时间要理解vue/axios/elementUI/vue-router。也不用慌，因为除了vue是基础外剩下部分并不难。看模板基本都会写，我会在周天晚上前提供前端部分的模板。各位前端同学用一周时间跟后端同学对接即可。