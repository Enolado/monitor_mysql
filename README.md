# mysqlMonitor

#### 介绍
MySQL监控系统（前端基于Vue3.0，使用了Element-PlusUI框架/后端基于SpringBoot）

#### 安装教程
直接执行startMonitor文件夹下的run程序即可启动程序,然后打开浏览器访问http://localhost:20015即可使用该程序

#### 使用说明
1.  由于该版本整合了前后端,所以不支持修改端口
2.  在使用SQL语句测试,访问表时,请标识数据库,如db.table
3.  该版本为了简化使用流程,前端代码进行了打包,若想查看前端VUE代码实现,请看[前后端初始代码](https://gitee.com/lwlspace/mysql-monitor)

#### 项目展示
![输入图片说明](https://images.gitee.com/uploads/images/2021/1123/112950_c20aa910_9450095.png "060ccb260fa8b89ff1635a0ef1457d7.png")

#### 设计思路
该项目是由MySQL5版本新增后的数据库模块Performance_schema性能板块监控为基础开发的
我整理的一些思路碎片放在这：<br>
MySQL5.7关于Performance_schema的简单介绍和注意事项:[笔记](https://blog.csdn.net/killbibi/article/details/121489697)<br>
[MySQL5.7关于Performance_schema官方文档介绍-中文](https://www.docs4dev.com/docs/zh/mysql/5.7/reference/performance-schema-table-index.html)<br>
由于该中文版本对一些概念翻译的不是很到位，这里放上官方介绍
[MySQL5.7关于Performance_schema官方文档介绍-英文原版](https://dev.mysql.com/doc/refman/5.7/en/performance-schema-threads-table.html)


#### 后言
该项目前后端构思开发测试由我完成，若存在Bug或不足，可告知我，谢谢~
微信号:L2574308236