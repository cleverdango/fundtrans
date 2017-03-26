<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="common/head.jsp"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<!--定义基准路径  -->
<title>欢迎使用基金交易系统</title>
<%@ include file="common/cssjs.inc"%>
</head>
<body>
	<div style="position: absolute; left: 40%; top: 40%; ">
		<h3>欢迎使用基金交易系统</h3>
		<form name="form1" action="User?type=1" method="post">
			<p>
				账号：<input class="text-input medium-input" type="text" name="userName" />
			</p>
			<p>
				密码：<input class="text-input medium-input" type="passWord"
					name="password" />
			</p>
			<p>
				<input class="button" type="submit" value="确定" />
				<input class="button" type="reset" value="取消" />
			</p>
		</form>
	</div>
</body>
</html>