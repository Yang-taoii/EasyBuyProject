﻿<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>易买网 - 首页</title>
	<link type="text/css" rel="stylesheet" href="css/style.css" />
	<link rel="stylesheet" href="css/register.css">
	<script type="text/javascript" src="scripts/jquery-1.12.4.js"></script>
	<script type="text/javascript" src="scripts/register.js"></script>
</head>
<body>
<div id="header" class="wrap">
	<div id="logo"><img src="images/logo.gif" /></div>
	<div class="help">如已有账户&nbsp;<a href="login.jsp">请点击登录~</a></div>
	<div class="navbar">
		<ul class="clearfix">
			<li class="current"><a href="<%=request.getContextPath()%>/EasyBuy/index.jsp">首页</a></li>
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
<div id="register" class="wrap">
	<div class="shadow">
		<em class="corner lb"></em>
		<em class="corner rt"></em>
		<div class="box">
			<h1>欢迎注册易买网</h1>
			<ul class="steps clearfix">
				<li class="current"><em></em>填写注册信息</li>
				<li class="last"><em></em>注册成功</li>
			</ul>
			<form id="regForm" method="post" action="<%=request.getContextPath()%>/UserServlet?method=register" >
				<table>
					<tr>
						<td class="field">用户名：</td>
						<td><input class="text" type="text" name="userName" id="userName" required/><span id="spanName"></span></td>
					</tr>
					<tr>
						<td class="field">登录密码：</td>
						<td><input class="text" type="password" id="passWord" name="passWord" required/><span id="password_s"></span></td>
					</tr>
					<tr>
						<td class="field">确认密码：</td>
						<td><input class="text" type="password" name="rePassWord" id="password_again" required/><span id="password_ss"></span></td>
					</tr>

					<tr>
						<td class="field">选择性别：</td>
						<td><input class="text" type="radio" name="sex" value="T"/>男<input class="text" type="radio" name="sex" value="F"/>女</td>
					</tr>

					<tr>
						<td class="field">出生日期：</td>
						<td><input class="text" type="date" name="birth" /><span></span></td>
					</tr>

					<tr>
						<td class="field">手机号码：</td>
						<td><input class="text" type="text" name="mobile" required/><span></span></td>
					</tr>

					<tr>
						<td class="field">家庭地址：</td>
						<td><input class="text" type="text" name="address" required/><span></span></td>
					</tr>

					<tr>
						<td class="field">身份证：</td>
						<td><input class="text" type="text" name="ID_Card" required/><span></span></td>
					</tr>

					<tr>
						<td class="field">邮箱：</td>
						<td><input class="text" type="text" name="email" required/><span></span></td>
					</tr>

					<tr>
						<td class="field">验证码：</td>
						<td><input class="text verycode" type="text" name="veryCode" id="input_vc" required/>
							<div id="regCheckCodes" onclick="show()"></div>
							<span id="span_vc"></span>
						</td>
					</tr>
					<tr>
						<td></td>
						<td><label class="ui-green"><input type="submit" name="submit" value="提交注册" /></label></td>
					</tr>
				</table>
			</form>
		</div>
	</div>
	<div class="clear"></div>
</div>
<div id="footer">
	Copyright &copy; 2010 北大青鸟 All Rights Reserved. 京ICP证1000001号
</div>

</body>
</html>
