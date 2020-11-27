<%@ page import="com.kgc.service.product.ProductCategoryService" %>
<%@ page import="com.kgc.service.product.ProductCategoryServiceImpl" %>
<%@ page import="com.kgc.pojo.ProductCategory" %>
<%@ page import="java.util.List" %>
<%@ page import="com.kgc.service.news.NewsService" %>
<%@ page import="com.kgc.service.news.NewsServiceImpl" %>
<%@ page import="com.kgc.pojo.News" %>
<%@ page import="com.kgc.service.product.ProductService" %>
<%@ page import="com.kgc.service.product.ProductServiceImpl" %>
<%@ page import="com.kgc.pojo.Product" %>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <link rel="shortcut icon" href="#" />
    <title>Title</title>
    <link rel="stylesheet" href="Plug-in/css/bootstrap.min.css">
    <link rel="stylesheet" href="Plug-in/css/bootstrap-theme.min.css">
    <link rel="stylesheet" href="Plug-in/css/default.css">
    <link rel="stylesheet" href="Plug-in/css/normalize.css">
    <link rel="stylesheet" href="Plug-in/css/site.css">

    <link type="text/css" rel="stylesheet" href="css/style.css" />
    <link rel="stylesheet" href="css/index.css">

    <script type="text/javascript" src="scripts/jquery-1.12.4.js"></script>
    <script type="text/javascript" src="Plug-in/js/jquery-1.11.0.min.js"></script>
    <script type="text/javascript" src="Plug-in/js/jquery.bootstrap.newsbox.js"></script>
    <script type="text/javascript" src="Plug-in/js/jquery.bootstrap.newsbox.min.js"></script>
    <script type="text/javascript" src="scripts/index.js"></script>
</head>
<body>

<%
    ProductCategoryService pcs = new ProductCategoryServiceImpl();
    List<ProductCategory> list1 = pcs.findAllParents();
    request.getSession().setAttribute("list",list1);

    NewsService newsService = new NewsServiceImpl();
    List<News> list_news = newsService.findAllNews();
    request.getSession().setAttribute("list_news",list_news);

    ProductService ps = new ProductServiceImpl();
    List<Product> list_product = ps.findALlProduct();
    request.getSession().setAttribute("allProduct",list_product);

    Object name = request.getSession().getAttribute("loginUser");

%>

<div id="header" class="wrap">
    <div id="logo"><img src="images/logo.gif" width="220px" height="80px" /></div>
    <div class="help">用户：${sessionScope.loginUser}&nbsp;<a href="<%=request.getContextPath()%>/ShoppingCarServlet?method=select" class="shopping">购物车</a>

        <c:if test="<%=name==null%>">
            <a href="login.jsp">登录</a>
        <a href="register.jsp">注册</a></div>
        </c:if>

        <c:if test="<%=name!=null%>">
            <a href="<%=request.getContextPath()%>/UserServlet?method=logout">注销</a>
        </c:if>

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
                <dt><img src="images/product/0_tiny.gif" /></dt>
                <dd><a href="product-view.jsp">法国德菲丝松露精品巧克力500g/盒</a></dd>
                <dt><img src="images/product/0_tiny.gif" /></dt>
                <dd><a href="product-view.jsp">法国德菲丝松露精品巧克力500g/盒</a></dd>
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
                <li><img src="scroll-01.jpg" height="350px" width="520px"/></li>
                <li><img src="scroll-02.jpg" height="350px" width="520px"/></li>
                <li><img src="scroll-03.jpg" height="350px" width="520px"/></li>
                <li><img src="scroll-04.jpg" height="350px" width="520px"/></li>
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

                <ul class="demo2">
                    <c:forEach items="${sessionScope.list_news}" var="news">
                        <li class="news-item"><a href="#">${news.title}</a></li>
                    </c:forEach>
                </ul>
            </div>
            <div class="spacer"></div>


            <div class="news-list">
                <h4>新闻动态</h4>

                <ul class="demo2">
                    <c:forEach items="${sessionScope.list_news}" var="news">
                        <li class="news-item"><a href="#">${news.content}</a></li>
                    </c:forEach>
                </ul>
            </div>
            </div>
        <div class="spacer clear"></div>




            <div class="hot">
                <h2>热卖推荐</h2>
                <ul class="product clearfix">
                    <c:forEach items="${sessionScope.allProduct}" var="p" begin="0" end="5">
                        <li>
                            <dl>
                                <dt><a href="product-view.jsp" target="_blank"><img src="${p.EP_FILE_NAME}" /></a></dt>
                                <dd class="title"><a href="product-view.jsp" target="_blank">${p.ep_name}</a></dd>
                                <dd class="price">${p.ep_price}</dd>
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
