<%@page import="java.util.List" %>
<%@page import="com.mybank.fundtrans.dao.*" %>
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
<h2 class="text-center">基金产品查询结果</h2>
<table class="table table-striped">

    <tr>
        <td>基金编号</td>
        <td>基金产品名称</td>
        <td>基金产品价格</td>
        <td>基金产品状态</td>
        <td>基金产品创建时间</td>
        <td>操作</td>
    </tr>
    <%

        //FundDao fundDao = new FundDaoJDBCImpl();

        List<Fund> funds = (List) request.getAttribute("fundList");
        String status = "";
        //PageBean pageBean =(PageBean) request.getAttribute("fundList");
       // List<Fund> funds = pageBean.getData();
        for (Fund fund : funds) {
    %>
    <tr>
        <td><%=fund.getId() %>
        </td>
        <td><%=fund.getName() %>
        </td>
        <td><%=fund.getPrice() %>
        </td>
        <%
            if (fund.getStatus().equals("N"))
                status = "不可交易";
            else
                status = "可交易";
        %>
        <td><%=status%>
        </td>
        <td><%=fund.getCreateTime() %>
        </td>
        <td>
            <a href="Fund?type=3&id=<%=fund.getId() %>">修改</a>
            <a href="Fund?type=4&id=<%=fund.getId() %>">删除</a>
        </td>
    </tr>
    <%
        }
    %>
    <form action="Fund?/type=2" method="post">
        <%@include file="../common/page.jsp"%>
    </form>

</table>
</body>
</html>