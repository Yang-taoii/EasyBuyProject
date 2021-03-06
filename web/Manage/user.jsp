﻿<%@ page import="com.kgc.pojo.Page" %>
<%@ page import="com.kgc.service.user.UserService" %>
<%@ page import="com.kgc.service.user.UserServiceImpl" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page pageEncoding="UTF-8"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>后台管理 - 易买网</title>
	<link type="text/css" rel="stylesheet" href="style.css" />
</head>
<body>

<div id="header" class="wrap">
	<div id="logo"><img src="logo.gif" /></div>
	<div class="help"><a href="<%=request.getContextPath()%>/EasyBuy/index.jsp">返回前台页面</a></div>
	<div class="navbar">
		<ul class="clearfix">
			<li><a href="index.jsp">首页</a></li>
			<li class="current"><a href="user.jsp">用户</a></li>
			<li><a href="order.jsp">订单</a></li>
			<li><a href="guestbook.jsp">留言</a></li>
			<li><a href="news.jsp">新闻</a></li>
		</ul>
	</div>
</div>
<div id="childNav">
	<div class="welcome wrap">
		管理员pillys您好，今天是2012-12-21，欢迎回到管理后台。
	</div>
</div>
<div id="position" class="wrap">
	您现在的位置：<a href="index.jsp">易买网</a> &gt; 管理后台
</div>
<div id="main" class="wrap">
	<div id="menu-mng" class="lefter">
		<div class="box">
			<dl>
				<dt>用户管理</dt>
				<dd><em><a href="user-add.jsp">新增</a></em><a href="user.jsp">用户管理</a></dd>
				<dt>订单管理</dt>
				<dd><a href="order.jsp">订单管理</a></dd>
				<dt>新闻管理</dt>
				<dd><em><a href="news-add.jsp">新增</a></em><a href="<%=request.getContextPath()%>/NewsServlet?method=showNewsByfenYe">新闻管理</a></dd>
			</dl>
		</div>
	</div>
	<div class="main">
		<h2>用户管理</h2>
		<div class="manage">
			<table class="list">
				<tr>
					<th>ID</th>
					<th>姓名</th>
					<th>性别</th>
					<th>Email</th>
					<th>手机</th>
					<th>操作</th>
				</tr>

				<c:forEach items="${sessionScope.page.list}" var="user" varStatus="sta">
					<tr>
						<td class="first w4 c">${user.id}</td>
						<td class="w1 c">${user.userName}</td>
						<td class="w2 c">${user.sex}</td>
						<td>${user.email}</td>
						<td class="w4 c">${user.mobile}</td>
						<td class="w1 c"><a href="<%=request.getContextPath()%>/UserServlet?method=getUser&user_name=${user.userName}">修改</a> <a href="<%=request.getContextPath()%>/UserServlet?method=del&user_name=${user.userName}">删除</a></td>
					</tr>
				</c:forEach>
			</table>

			<div>
				当前页码：【${sessionScope.page.pageIndex}/${sessionScope.page.totalPage}】<br/>
				<a href="<%=request.getContextPath()%>/UserServlet?method=showAllUserInfo&&pageIndex=1">首页</a>
				<a href="<%=request.getContextPath()%>/UserServlet?method=showAllUserInfo&&pageIndex=${sessionScope.page.pageIndex-1}">上一页</a>
				<a href="<%=request.getContextPath()%>/UserServlet?method=showAllUserInfo&&pageIndex=${sessionScope.page.pageIndex+1}">下一页</a>
				<a href="<%=request.getContextPath()%>/UserServlet?method=showAllUserInfo&&pageIndex=${sessionScope.page.totalPage}">尾页</a>
			</div>
		</div>
	</div>
	<div class="clear"></div>
</div>
<div id="footer">
	Copyright &copy; 2010 北大青鸟 All Rights Reserved. 京ICP证1000001号
</div>
</body>
</html>
