
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link type="text/css" rel="stylesheet" href="css/style.css" />
    <script type="text/javascript" src="scripts/function.js"></script>
</head>
<body>
<div id="header" class="wrap">
    <div id="logo"><img src="images/logo.gif" /></div>
    <div class="help"><a href="#" class="shopping">购物车</a><a href="login.jsp">登录</a><a href="register.jsp">注册</a></div>
    <div class="navbar">
        <ul class="clearfix">
            <li class="current"><a href="#">首页</a></li>
            <li><a href="#">图书</a></li>
            <li><a href="#">百货</a></li>
            <li><a href="#">品牌</a></li>
            <li><a href="#">促销</a></li>
        </ul>
    </div>
</div>
<div id="childNav">
    <div class="wrap">
        <ul class="clearfix">
            <li class="first"><a href="#">音乐</a></li>
            <li><a href="#">影视</a></li>
            <li><a href="#">少儿</a></li>
            <li><a href="#">动漫</a></li>
            <li><a href="#">小说</a></li>
            <li><a href="#">外语</a></li>
            <li><a href="#">数码相机</a></li>
            <li><a href="#">笔记本</a></li>
            <li><a href="#">羽绒服</a></li>
            <li><a href="#">秋冬靴</a></li>
            <li><a href="#">运动鞋</a></li>
            <li><a href="#">美容护肤</a></li>
            <li><a href="#">家纺用品</a></li>
            <li><a href="#">婴幼奶粉</a></li>
            <li><a href="#">饰品</a></li>
            <li class="last"><a href="#">Investor Relations</a></li>
        </ul>
    </div>
</div>
<div id="position" class="wrap">
    您现在的位置：<a href="index.jsp">易买网</a> &gt; 订单查看
</div>
<div class="wrap">
    <div id="shopping">
        <div>
            <table>
                <tr>
                    <th width="5%" nowrap="nowrap">序号</th>
                    <th width="30%" nowrap="nowrap">订单编号</th>
                    <th width="10%" nowrap="nowrap">提交时间</th>
                    <th width="10%" nowrap="nowrap">订单操作</th>
                    <th width="35%" nowrap="nowrap">商品信息</th>
                    <th width="10%">订单状态</th>
                </tr>
                <tr valign="middle"  align="center">
                    <td><span style="font-size:16px;">1</span></td>
                    <td><h1>2016082500002468</h1></td>
                    <td>2016-08-24</td>
                    <td>
                        <span>已发货</span><br />
                        <a href="#">确认收货</a><br />
                        <a href="#">取消订单</a>
                    </td>
                    <td>
                        <p style="font-size:16px;"><img src="images/product/3.jpg" height="100" width="100" style="vertical-align:middle" /> × 3</P>
                        <p style="font-size:16px;"><img src="images/product/4.jpg" height="100" width="100" style="vertical-align:middle" /> × 3</P>
                        <p style="font-size:16px;"><img src="images/product/5.jpg" height="100" width="100" style="vertical-align:middle" /> × 3</P>
                    </td>
                    <td>交易中</td>
                </tr>
                <tr valign="middle"  align="center">
                    <td width="5%"><span style="font-size:16px;">2</span></td>
                    <td width="30%"><h1>2016082500002468</h1></td>
                    <td>2016-08-24</td>
                    <td>
                        <span>已发货</span><br />
                        <span>已确认收货</span><br />
                        <a href="#">退货</a>
                    </td>
                    <td>
                        <p style="font-size:16px;"><img src="images/product/1.jpg" height="100" width="100" style="vertical-align:middle" /> × 3</P>
                        <p style="font-size:16px;"><img src="images/product/2.jpg" height="100" width="100" style="vertical-align:middle" /> × 1</P>
                    </td>
                    <td>已完成</td>
                </tr>
            </table>
        </div>



    </div>
    <script type="text/javascript">
        document.write("Cookie中记录的购物车商品ID："+ getCookie("product") + "，可以在动态页面中进行读取");
    </script>
</div>
<div id="footer">
    Copyright &copy; 2010 北大青鸟 All Rights Reserved. 京ICP证1000001号
</div>
</body>
</html>
