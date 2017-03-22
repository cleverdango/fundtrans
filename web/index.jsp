<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">
    <title>基金交易系统</title>
    <link rel="stylesheet" href="resources/css/reset.css" type="text/css" media="screen"/>
    <link rel="stylesheet" href="resources/css/style.css" type="text/css" media="screen"/>
    <link rel="stylesheet" href="resources/css/invalid.css" type="text/css" media="screen"/>
    <link rel="stylesheet" href="resources/css/bootstrap.css" type="text/css"/>
</head>
<%--
    if (session.getAttribute("user")==null)
        response.sendRedirect("login.jsp");

--%>

<frameset frameSpacing="0" cols="260,*">
    <frame name=menu src="index/left.jsp" frameBorder=0>
    <frame name=dmMain src="index/right.jsp" frameBorder=0>
</frameset>
</html>
