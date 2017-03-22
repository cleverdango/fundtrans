<%@page import="com.mybank.fundtrans.dao.FundDaoJDBCImpl"%>
<%@page import="com.mybank.fundtrans.dao.FundDao"%>
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
FundDao fundDao= new FundDaoJDBCImpl();
int fundNo=Integer.parseInt(request.getParameter("id"));
fundDao.delete(fundNo);

%>
<jsp:forward page="fund_list.jsp"></jsp:forward>

</body>
</html>
