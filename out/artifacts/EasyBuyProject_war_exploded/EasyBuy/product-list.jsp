<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <link type="text/css" rel="stylesheet" href="css/style.css" />
    <script type="text/javascript" src="scripts/jquery-1.12.4.js"></script>
    <title>易买网 - 首页</title>
</head>
<body>
<div id="header" class="wrap">
    <div id="logo"><img src="images/logo.gif" /></div>
    <div class="help"><a href="shopping.jsp" class="shopping">购物车</a><a href="login.jsp">登录</a><a href="register.jsp">注册</a></div>
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
    您现在的位置：<a href="index.jsp">易买网</a> &gt; <a href="product-list.jsp">${sessionScope.father_Name}</a> &gt; ${sessionScope.child_Name}
</div>
<div id="main" class="wrap">
    <div class="lefter">
        <div class="box">
            <h2>商品分类</h2>
            <dl>
                <c:forEach items="${sessionScope.list}" var="pc">
                    <dt>${pc.epc_name}</dt>
                    <c:forEach items="${pc.list}" var="list_child">
                        <dd><a href="<%=request.getContextPath()%>/ProductServlet?method=showAllProduct&child_name=${list_child.epc_name}&father_name=${pc.epc_name}&epc_id=${pc.epc_id}">${list_child.epc_name}</a></dd>
                    </c:forEach>
                </c:forEach>
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
            <script type="text/javascript">
                document.write("Cookie中记录的购物车商品ID："+ getCookie("product") + "，可以在动态页面中进行读取");
            </script>
        </div>
    </div>
    <div class="main">
        <div class="product-list">
            <h2>全部商品</h2>
            <div class="pager">
                <ul class="clearfix">
                    <li><a href="#">上一页</a></li>
                    <li class="current">1</li>
                    <li><a href="#">2</a></li>
                    <li><a href="#">3</a></li>
                    <li><a href="#">4</a></li>
                    <li><a href="#">5</a></li>
                    <li><a href="#">下一页</a></li>
                </ul>
            </div>
            <div class="clear"></div>


            <ul class="product clearfix">
                <c:forEach items="${sessionScope.list_category}" var="product">
                    <li>
                        <dl>
                            <dt><a href="<%=request.getContextPath()%>/ProductServlet?method=productDetail&ep_id=${product.ep_id}" target="_blank"><img src="${product.EP_FILE_NAME}" /></a></dt>
                            <dd class="title"><a href="<%=request.getContextPath()%>/ProductServlet?method=productDetail&ep_id=${product.ep_id}" target="_blank" >${product.ep_name}</a></dd>
                            <dd class="price">￥${product.ep_price}</dd>
                        </dl>
                    </li>
                </c:forEach>
            </ul>


            <div class="clear"></div>

        </div>
    </div>
    <div class="clear"></div>
</div>
<div id="footer">
    Copyright &copy; 2010 北大青鸟 All Rights Reserved. 京ICP证1000001号
</div>
</body>
</html>
