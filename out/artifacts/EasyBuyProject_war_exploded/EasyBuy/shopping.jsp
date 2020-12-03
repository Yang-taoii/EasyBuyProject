<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
    <title>Title</title>
    <link type="text/css" rel="stylesheet" href="css/style.css" />
    <script type="text/javascript" src="scripts/jquery-1.12.4.js"></script>
    <script type="text/javascript" src="scripts/shopping.js"></script>
    <script type="text/javascript">
        $(function () {
            $("input#number_id_1").blur(function () {
                const $amount_input =$(this);
                const $amount = $amount_input.val();
                const $goods_id = $amount_input.next().val();
                const $reserve = $amount_input.next().next().val();
                alert($reserve+"--"+$goods_id+"--"+$amount);
                $.post("<%=request.getContextPath()%>/ShoppingCarServlet?method=updateAmount",{"goods_id":$goods_id,"amount":$amount,"reserve":$reserve},function (data) {
                    if (data.result){
                        alert("购买修改成功");

                    }else
                        alert("购买修改失败");
                },"JSON");
            });
        })
    </script>
</head>
<body>
<% Object name = request.getSession().getAttribute("loginUser");%>
<div id="header" class="wrap">
    <div id="logo"><img src="images/logo.gif" width="220px" height="80px" /></div>
    <div class="help">当前用户：${sessionScope.loginUser}<a href="shopping.jsp" class="shopping">购物车(${sessionScope.list_car.size()})</a>
        <c:if test="<%=name==null%>">
        <a href="login.jsp">登录</a>
        <a href="register.jsp">注册</a></div>
    </c:if>

    <c:if test="<%=name!=null%>">
        <a href="<%=request.getContextPath()%>/UserServlet?method=logout">注销</a>
    </c:if>
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
    您现在的位置：<a href="index.jsp">易买网</a> &gt; 购物车
</div>
<div class="wrap">
    <div id="shopping">
        <form action="<%=request.getContextPath()%>/OrderServlet?method=submit" method="post">
            <table>
                <tr>
                    <th>商品名称</th>
                    <th>商品价格</th>
                    <th>购买数量</th>
                    <th>操作</th>
                </tr>


                <c:forEach items="${sessionScope.list_car}" var="s">
                    <tr id="product_id_1">
                        <td class="thumb"><img src="${s.product.EP_FILE_NAME}" /><a href="product-view.jsp">${s.product.ep_name}</a></td>
                        <td class="price" id="price_id_1">
                            <span>￥${s.product.ep_price}</span>
                            <input type="hidden" value="99" />
                        </td>
                        <td class="number">
                            <dl>
                                <dt>
                                    <input id="number_id_1" type="text" name="number" value="${s.amount}" />
                                    <input type="hidden" value="${s.goods_id}">
                                    <input type="hidden" value="${sessionScope.product_reserve}">
                                </dt>
                            </dl>
                        </td>
                        <td class="delete"><a href="<%=request.getContextPath()%>/ShoppingCarServlet?method=delete&goods_id=${s.goods_id}">删除</a></td>
                    </tr>
                </c:forEach>



            </table>
            总计：￥${sessionScope.sum_price}
            <div class="button"><input type="submit"/></div>
        </form>
    </div>
</div>
<div id="footer">
    Copyright &copy; 2010 北大青鸟 All Rights Reserved. 京ICP证1000001号
</div>
</body>
</html>
