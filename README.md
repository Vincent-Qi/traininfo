<h1 id="火车票信息查询">火车票信息查询</h1>

<blockquote>
  <p>主要提供余票,车次,历史订单,联系人信息,个人信息的查询</p>
</blockquote>



<h2 id="documents">Documents</h2>

<p>只提供接口(<strong>Ilaunch</strong>) <br>
使用方法：</p>

<pre><code>Ilaunch iaun=new Launch();
</code></pre>

<p><em>每个方法对应返回有实体和实体的toString字符串，使用实体的话可以自己处理返回的信息.</em></p>



<h4 id="获取联系人信息"><i class="icon-file"></i>获取联系人信息</h4>

<pre><code>iaun.queryMyContentAsString()
</code></pre>

<table>
<thead>
<tr>
  <th>姓名</th>
  <th>证件类型</th>
  <th>证件号码</th>
  <th>手机/电话</th>
  <th>旅客类型</th>
  <th>核验状态</th>
</tr>
</thead>
<tbody><tr>
  <td>韩*</td>
  <td>二代身份证</td>
  <td>3412211*******757</td>
  <td></td>
  <td>成人</td>
  <td>已核验</td>
</tr>
<tr>
  <td>祁*</td>
  <td>二代身份证</td>
  <td>3412211*******797</td>
  <td>18520***756</td>
  <td>成人</td>
  <td>已核验</td>
</tr>
<tr>
  <td>任*</td>
  <td>二代身份证</td>
  <td>3412211*******727</td>
  <td></td>
  <td>成人</td>
  <td>已核验</td>
</tr>
<tr>
  <td>王*</td>
  <td>二代身份证</td>
  <td>3412211*******737</td>
  <td></td>
  <td>成人</td>
  <td>已核验</td>
</tr>
</tbody></table>


<h4 id="获取个人注册信息"><i class="icon-file"></i>获取个人注册信息</h4>

<pre><code>iaun.querySelfCountAsString()
</code></pre>

<table>
<thead>
<tr>
  <th>用户名</th>
  <th>姓名</th>
  <th>证件类型</th>
  <th>证件号码</th>
  <th>性别</th>
  <th>国家</th>
  <th>出生日期</th>
  <th>手机号码</th>
  <th>电子邮件</th>
</tr>
</thead>
<tbody><tr>
  <td>vincentQi</td>
  <td>祁*</td>
  <td>二代身份证</td>
  <td>3412211**070</td>
  <td>男</td>
  <td>中国CHINA</td>
  <td>1992-10-01</td>
  <td>185206786</td>
  <td>463349267@qq.com</td>
</tr>
</tbody></table>


<h4 id="车次途径站信息"><i class="icon-file"></i>车次途径站信息</h4>

<pre><code>iaun.queryTrainInfoAsString("k8554", "阜阳", "合肥")
</code></pre>

<table>
<thead>
<tr>
  <th>站序</th>
  <th>站名</th>
  <th>到站时间</th>
  <th>出发时间</th>
  <th>停留时间</th>
</tr>
</thead>
<tbody><tr>
  <td>01</td>
  <td>池州</td>
  <td>–</td>
  <td>11:00</td>
  <td>–</td>
</tr>
<tr>
  <td>02</td>
  <td>铜陵</td>
  <td>12:08</td>
  <td>12:13</td>
  <td>5分钟</td>
</tr>
<tr>
  <td>03</td>
  <td>芜湖</td>
  <td>13:40</td>
  <td>13:46</td>
  <td>6分钟</td>
</tr>
<tr>
  <td>04</td>
  <td>巢湖</td>
  <td>14:44</td>
  <td>14:47</td>
  <td>3分钟</td>
</tr>
<tr>
  <td>05</td>
  <td>合肥</td>
  <td>15:46</td>
  <td>16:01</td>
  <td>15分钟</td>
</tr>
<tr>
  <td>06</td>
  <td>淮南</td>
  <td>17:13</td>
  <td>17:16</td>
  <td>3分钟</td>
</tr>
<tr>
  <td>07</td>
  <td>阜阳</td>
  <td>18:56</td>
  <td>18:56</td>
  <td>–</td>
</tr>
</tbody></table>


<h4 id="获取余票信息"><i class="icon-file"></i>获取余票信息</h4>

<pre><code>iaun.querySeatsLeftAsString("成人", "2015-02-04", "阜阳", "合肥")
</code></pre>

<table>
<thead>
<tr>
  <th>车次</th>
  <th>出发站</th>
  <th>到达站</th>
  <th>出发时间</th>
  <th>到达时间</th>
  <th>历时</th>
  <th>商务座</th>
  <th>特等座</th>
  <th>一等座</th>
  <th>二等座</th>
  <th>高级软卧</th>
  <th>软卧</th>
  <th>硬卧</th>
  <th>软座</th>
  <th>硬座</th>
  <th>无座</th>
  <th>其他</th>
</tr>
</thead>
<tbody><tr>
  <td>K8411</td>
  <td>阜阳</td>
  <td>合肥</td>
  <td>17:11</td>
  <td>20:00</td>
  <td>02:49</td>
  <td>–</td>
  <td>–</td>
  <td>–</td>
  <td>–</td>
  <td>–</td>
  <td>–</td>
  <td>–</td>
  <td>–</td>
  <td>828</td>
  <td>750</td>
  <td>–</td>
</tr>
<tr>
  <td>K4073</td>
  <td>阜阳</td>
  <td>合肥</td>
  <td>17:17</td>
  <td>21:29</td>
  <td>04:12</td>
  <td>–</td>
  <td>–</td>
  <td>–</td>
  <td>–</td>
  <td>–</td>
  <td>–</td>
  <td>无</td>
  <td>–</td>
  <td>10</td>
  <td>无</td>
  <td>–</td>
</tr>
<tr>
  <td>K8361</td>
  <td>阜阳</td>
  <td>合肥</td>
  <td>17:28</td>
  <td>21:01</td>
  <td>03:33</td>
  <td>–</td>
  <td>–</td>
  <td>–</td>
  <td>–</td>
  <td>–</td>
  <td>–</td>
  <td>无</td>
  <td>–</td>
  <td>10</td>
  <td>无</td>
  <td>–</td>
</tr>
<tr>
  <td>K1237</td>
  <td>阜阳</td>
  <td>合肥</td>
  <td>17:36</td>
  <td>20:14</td>
  <td>02:38</td>
  <td>–</td>
  <td>–</td>
  <td>–</td>
  <td>–</td>
  <td>–</td>
  <td>4</td>
  <td>20</td>
  <td>–</td>
  <td>132</td>
  <td>334</td>
  <td>–</td>
</tr>
<tr>
  <td>K8499</td>
  <td>阜阳</td>
  <td>合肥</td>
  <td>17:52</td>
  <td>20:35</td>
  <td>02:43</td>
  <td>–</td>
  <td>–</td>
  <td>–</td>
  <td>–</td>
  <td>–</td>
  <td>1</td>
  <td>55</td>
  <td>–</td>
  <td>无</td>
  <td>无</td>
  <td>–</td>
</tr>
<tr>
  <td>K8563</td>
  <td>阜阳</td>
  <td>合肥</td>
  <td>20:33</td>
  <td>23:10</td>
  <td>02:37</td>
  <td>–</td>
  <td>–</td>
  <td>–</td>
  <td>–</td>
  <td>–</td>
  <td>4</td>
  <td>9</td>
  <td>–</td>
  <td>无</td>
  <td>无</td>
  <td>–</td>
</tr>
<tr>
  <td>L297</td>
  <td>阜阳</td>
  <td>合肥</td>
  <td>21:30</td>
  <td>00:35</td>
  <td>03:05</td>
  <td>–</td>
  <td>–</td>
  <td>–</td>
  <td>–</td>
  <td>–</td>
  <td>–</td>
  <td>–</td>
  <td>25</td>
  <td>1000</td>
  <td>956</td>
  <td>–</td>
</tr>
<tr>
  <td>K8555</td>
  <td>阜阳</td>
  <td>合肥</td>
  <td>22:04</td>
  <td>00:42</td>
  <td>02:38</td>
  <td>–</td>
  <td>–</td>
  <td>–</td>
  <td>–</td>
  <td>–</td>
  <td>37</td>
  <td>130</td>
  <td>–</td>
  <td>430</td>
  <td>158</td>
  <td>–</td>
</tr>
<tr>
  <td>T325</td>
  <td>阜阳</td>
  <td>合肥</td>
  <td>23:30</td>
  <td>02:12</td>
  <td>02:42</td>
  <td>–</td>
  <td>–</td>
  <td>–</td>
  <td>–</td>
  <td>–</td>
  <td>1</td>
  <td>3</td>
  <td>–</td>
  <td>100</td>
  <td>248</td>
  <td>–</td>
</tr>
</tbody></table>


<h4 id="获取历史订单信息"><i class="icon-file"></i>获取历史订单信息</h4>

<pre><code>iaun.queryOrdersAsString("2014-10-02", "2015-02-03", "")
</code></pre>

<table>
<thead>
<tr>
  <th align="left">订单号</th>
  <th align="left">订单日期</th>
  <th align="center">车次信息</th>
  <th align="center">席位信息</th>
  <th align="center">旅客信息</th>
  <th align="center">票款金额</th>
  <th align="center">车票状态</th>
</tr>
</thead>
<tbody><tr>
  <td align="left">E384519949</td>
  <td align="left">2015-01-17 10:37:17</td>
  <td align="center">2015-01-19 09:48 K8412合肥-&gt;阜阳</td>
  <td align="center">14车厢 ^03d号^硬卧代硬座</td>
  <td align="center">任^二代身份证</td>
  <td align="center">成人票^37.5</td>
  <td align="center">已出票</td>
</tr>
<tr>
  <td align="left">E387371982</td>
  <td align="left">2015-01-14 15:29:34</td>
  <td align="center">2015-01-15 13:40 K8421阜阳-&gt;合肥</td>
  <td align="center">04车厢 ^004号^硬座</td>
  <td align="center">任^二代身份证</td>
  <td align="center">成人票^37.5</td>
  <td align="center">已出票</td>
</tr>
<tr>
  <td align="left">E380221316</td>
  <td align="left">2015-01-04 21:18:15</td>
  <td align="center">2015-01-06 17:11 K8411阜阳-&gt;合肥</td>
  <td align="center">03车厢 ^114号^硬座</td>
  <td align="center">任*^二代身份证</td>
  <td align="center">成人票^37.5</td>
  <td align="center">已退票(业务流水号:2E380221316001001112426913)</td>
</tr>
</tbody></table>