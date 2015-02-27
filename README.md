火车票信息查询
===================

> 主要提供余票,车次,历史订单,联系人信息,个人信息的查询

Documents
----------

只提供接口(**Ilaunch**)
使用方法：

    Ilaunch iaun=new Launch();

*每个方法对应返回有实体和实体的toString字符串，使用实体的话可以自己处理返回的信息.*
 1. 获取联系人信息

    iaun.queryMyContentAsString()
*姓名 证件类型 证件号码 手机/电话 旅客类型 核验状态
韩*  二代身份证 3412211*******757 成人 已核验
刘* 二代身份证 3412021*******919 成人 已核验
祁* 二代身份证 3412211*******70 185206786 成人 已核验
任* 二代身份证 3412821*******824 成人 未核验
王* 二代身份证 3412211*******56 学生 已核验*

 2. 获取个人注册信息

    iaun.querySelfCountAsString()

*用户名：--->vincentQi
姓名：--->祁
证件类型：--->二代身份证
证件号码：--->3412211******070
性别：--->男
国家：--->中国CHINA
出生日期：--->1992-10-01
手机号码：--->185206786
电子邮件：--->463349267@qq.com*
 3. 车次途径站信息

    iaun.queryTrainInfoAsString("k8554", "阜阳", "合肥")

*站序 站名 到站时间 出发时间 停留时间
01 池州 ---- 11:00 ----
02 铜陵 12:08 12:13 5分钟
03 芜湖 13:40 13:46 6分钟
04 巢湖 14:44 14:47 3分钟
05 合肥 15:46 16:01 15分钟
06 淮南 17:13 17:16 3分钟
07 阜阳 18:56 18:56 ----*
 4. 获取余票信息

    iaun.querySeatsLeftAsString("成人", "2015-02-04", "阜阳", "合肥")

*车次 出发站 到达站 出发时间 到达时间 历时 商务座 特等座 一等座 二等座 高级软卧 软卧 硬卧 软座 硬座 无座 其他
K8411 阜阳 合肥 17:11 20:00 02:49 -- -- -- -- -- -- -- -- 828 750 --
K4073 阜阳 合肥 17:17 21:29 04:12 -- -- -- -- -- -- 无 -- 1000 1000 --
K8361 阜阳 合肥 17:28 21:01 03:33 -- -- -- -- -- -- 无 -- 10 无 --
K1237 阜阳 合肥 17:36 20:14 02:38 -- -- -- -- -- 4 20 -- 132 334 --
K8499 阜阳 合肥 17:52 20:35 02:43 -- -- -- -- -- 1 55 -- 无 无 --
K8563 阜阳 合肥 20:33 23:10 02:37 -- -- -- -- -- 4 9 -- 无 无 --
L297 阜阳 合肥 21:30 00:35 03:05 -- -- -- -- -- -- -- 25 1000 956 --
K8555 阜阳 合肥 22:04 00:42 02:38 -- -- -- -- -- 37 130 -- 430 158 --
T325 阜阳 合肥 23:30 02:12 02:42 -- -- -- -- -- 1 3 -- 100 248 --*
 5. 获取历史订单信息

    iaun.queryOrdersAsString("2014-10-02", "2015-02-03", "")
*订单号: 订单日期： 车次信息： 席位信息 旅客信息 票款金额 车票状态
E384519949 2015-01-17 10:37:17 2015-01-19 09:48K8412合肥->阜阳 14车厢 ^03d号^硬卧代硬座 任^二代身份证 成人票^37.5 已出票
E387371982 2015-01-14 15:29:34 2015-01-15 13:40K8421阜阳->合肥 04车厢 ^004号^硬座 任^二代身份证 成人票^37.5 已出票
E380221316 2015-01-04 21:18:15 2015-01-06 17:11K8411阜阳->合肥 03车厢 ^114号^硬座 任*^二代身份证 成人票^37.5 已退票(业务流水号:2E380221316001001112426913)*
