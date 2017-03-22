<%@ page import="com.mybank.fundtrans.domain.Fund" %>
<%@ page import="java.util.Date" %>
<%@ page import="com.mybank.fundtrans.dao.FundDao" %>
<%@ page import="com.mybank.fundtrans.dao.FundDaoJDBCImpl" %>
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
    request.setCharacterEncoding("utf-8");
    Integer fundId = Integer.parseInt(request.getParameter("fundId"));
    String fundName = request.getParameter("fundName");
    Double fundPrice = Double.valueOf(request.getParameter("fundPrice"));
    String fundDes = request.getParameter("fundDes");
    String fundStatus = request.getParameter("fundStatus");

    Fund fund = new Fund(fundId,fundName,fundDes,fundPrice,fundStatus,new Date());

    FundDao fundDao = new FundDaoJDBCImpl();
    fundDao.update(fund);
%>
<jsp:forward page="fund_list.jsp"></jsp:forward>

</body>
</html>