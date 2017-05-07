<%--
  Created by IntelliJ IDEA.
  User: yazawanico
  Date: 2017/5/7
  Time: 15:18
  To change this template use File | Settings | File Templates.
--%>
<%@page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"
         import="com.mybank.fundtrans.dao.*,com.mybank.fundtrans.domain.*,com.mybank.fundtrans.util.*"
%>
<%

    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="resources/css/bootstrap.css" type="text/css"/>
    <title>Insert title here</title>
    <%@include file="../common/cssjs.inc"%>
</head>
<body>
<h2 class="text-center">客户产品查询结果</h2>
<table class="table table-striped">

    <tr>
        <td>客户编号</td>
        <td>客户姓名</td>
        <td>客户可用资产</td>
        <td>客户客户总资产</td>
    </tr>


</html>