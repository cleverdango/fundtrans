<%@page import="com.mybank.fundtrans.dao.FundDaoJDBCImpl"%>
<%@page import="com.mybank.fundtrans.dao.FundDao"%>
<%@ page import="com.mybank.fundtrans.domain.Fund" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
    //1.获取表单数据,如果有中文，应该先设置request编码
    request.setCharacterEncoding("utf-8");

    //Fund fund = (Fund)request.getAttribute("fundDelete");
%>

</body>
</html>
