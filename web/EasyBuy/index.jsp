
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Title</title>
    <link type="text/css" rel="stylesheet" href="css/style.css" />
    <link rel="stylesheet" href="css/index.css">
    <script type="text/javascript" src="scripts/jquery-1.12.4.js"></script>
    <script type="text/javascript" src="scripts/index.js"></script>
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
<div id="main" class="wrap">
    <div class="lefter">
        <div class="box">
            <h2>商品分类</h2>
            <dl>
                <dt>图书音像</dt>
                <dd><a href="product-list.jsp">图书</a></dd>
                <dd><a href="product-list.jsp">音乐</a></dd>
                <dt>百货</dt>
                <dd><a href="product-list.jsp">运动健康</a></dd>
                <dd><a href="product-list.jsp">服装</a></dd>
                <dd><a href="product-list.jsp">家居</a></dd>
                <dd><a href="product-list.jsp">美妆</a></dd>
                <dd><a href="product-list.jsp">母婴</a></dd>
                <dd><a href="product-list.jsp">食品</a></dd>
                <dd><a href="product-list.jsp">手机数码</a></dd>
                <dd><a href="product-list.jsp">家具首饰</a></dd>
                <dd><a href="product-list.jsp">手表饰品</a></dd>
                <dd><a href="product-list.jsp">鞋包</a></dd>
                <dd><a href="product-list.jsp">家电</a></dd>
                <dd><a href="product-list.jsp">电脑办公</a></dd>
                <dd><a href="product-list.jsp">玩具文具</a></dd>
                <dd><a href="product-list.jsp">汽车用品</a></dd>
            </dl>
        </div>
        <div class="spacer"></div>
        <div class="last-view">
            <h2>最近浏览</h2>
            <dl class="clearfix">
                <dt><img src="images/product/0_tiny.gif" /></dt>
                <dd><a href="product-view.jsp">法国德菲丝松露精品巧克力500g/盒</a></dd>
                <dt><img src="images/product/0_tiny.gif" /></dt>
                <dd><a href="product-view.jsp">法国德菲丝松露精品巧克力500g/盒</a></dd>
            </dl>
        </div>
    </div>
    <div class="main">

        <%--  图片轮播  520w 400h    --%>

        <div class="price-off" id="content" >
            <h2 style="margin-top: 10px">今日特价</h2>
            <ul id="scroll_img">
                <li><img src="scroll-01.jpg" height="360px" width="520px"/></li>
                <li><img src="scroll-02.jpg" height="360px" width="520px"/></li>
                <li><img src="scroll-03.jpg" height="360px" width="520px"/></li>
                <li><img src="scroll-04.jpg" height="360px" width="520px"/></li>
            </ul>
            <ul id="scroll_number">
                <li>1</li>
                <li>2</li>
                <li>3</li>
                <li>4</li>
            </ul>
        </div>


        <div class="side">
            <div class="news-list">
                <h4>最新公告</h4>
                <ul>
                    <li><a href="news-view.jsp" target="_blank">抢钱啦</a></li>
                    <li><a href="news-view.jsp" target="_blank">抢钱啦</a></li>
                    <li><a href="news-view.jsp" target="_blank">抢钱啦</a></li>
                    <li><a href="news-view.jsp" target="_blank">抢钱啦</a></li>
                    <li><a href="news-view.jsp" target="_blank">抢钱啦</a></li>
                    <li><a href="news-view.jsp" target="_blank">抢钱啦</a></li>
                    <li><a href="news-view.jsp" target="_blank">抢钱啦</a></li>
                </ul>
            </div>
            <div class="spacer"></div>
            <div class="news-list">
                <h4>新闻动态</h4>
                <ul>
                    <li><a href="news-view.jsp" target="_blank">抢钱啦</a></li>
                    <li><a href="news-view.jsp" target="_blank">抢钱啦</a></li>
                    <li><a href="news-view.jsp" target="_blank">抢钱啦</a></li>
                    <li><a href="news-view.jsp" target="_blank">抢钱啦</a></li>
                    <li><a href="news-view.jsp" target="_blank">抢钱啦</a></li>
                    <li><a href="news-view.jsp" target="_blank">抢钱啦</a></li>
                    <li><a href="news-view.jsp" target="_blank">抢钱啦</a></li>
                </ul>
            </div>
        </div>
        <div class="spacer clear"></div>
        <div class="hot">
            <h2>热卖推荐</h2>
            <ul class="product clearfix">
                <!--<li>
                    <dl>
                        <dt><a href="product-view.jsp" target="_blank"><img src="images/product/1.jpg" /></a></dt>
                        <dd class="title"><a href="product-view.jsp" target="_blank">法国德菲丝松露精品巧克力500g/盒</a></dd>
                        <dd class="price">￥108.0</dd>
                    </dl>
                </li>-->
                <c:forEach items="" var="i" >
                    <li>
                        <dl>
                            <dt><a href="product-view.jsp" target="_blank"><img src="" /></a></dt>
                            <dd class="title"><a href="product-view.jsp" target="_blank"></a></dd>
                            <dd class="price">￥69.90</dd>
                        </dl>
                    </li>
                </c:forEach>
            </ul>
        </div>
    </div>
    <div class="clear"></div>
</div>
<div id="footer">
    Copyright &copy; 2010 北大青鸟 All Rights Reserved. 京ICP证1000001号
</div>
</body>
</html>
