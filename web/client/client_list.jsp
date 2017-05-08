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

        <td>客户姓名</td>
        <td>客户性别</td>
        <td>客户邮箱</td>
        <td>客户爱好</td>
        <td>客户电话</td>
        <td>客户创建时间</td>
    </tr>
    <%
        Client client = (Client)request.getAttribute("client");
        List <Client> clients = (List <Client>)request.getAttribute("clients");
        for (Client newclient:clients){
    %>
    <tr>

        <td><%=newclient.getName()%></td>
        <td><%=newclient.getSex()%></td>
        <td><%=newclient.getEmail()%></td>
        <td><%=newclient.getHobby()%></td>
        <td><%=newclient.getPhone()%></td>
        <td><%=newclient.getCreateTime()%></td>
        <td>
            <a href="client/preUpdate.action?IDCard=<%=newclient.getIDCard() %>">修改</a>
            <a href="client/deleteClient.action?client.IDCard=<%=newclient.getIDCard() %>">删除</a>
        </td>
    </tr>
    <%
        }
    %>
</table>
</body>
</html>