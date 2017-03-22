<%@page import="com.mybank.fundtrans.dao.FundDaoJDBCImpl"%>
<%@page import="com.mybank.fundtrans.domain.*" %>
<%@page import="com.mybank.fundtrans.dao.*" %>
<%@page import="java.util.Date" %>

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
	String fundName = request.getParameter("fundName");
	Double fundPrice = Double.valueOf(request.getParameter("fundPrice"));
	String fundDes = request.getParameter("fundDes");
	String fundStatus = request.getParameter("fundStatus");
	
	Fund fund = new Fund(0,fundName,fundDes,fundPrice,fundStatus,new Date());
	
	FundDao fundDao = new FundDaoJDBCImpl();
	fundDao.insert(fund);
	
%>
<jsp:forward page="fund_list.jsp"></jsp:forward>
</body>
</html>