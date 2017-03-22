<%@ page import="java.util.Enumeration" %><%--
  Created by IntelliJ IDEA.
  User: yazawanico
  Date: 2017/3/13
  Time: 23:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Parameter</title>
</head>
<body>
<%
    Enumeration<String> names = request.getParameterNames();

    while(names.hasMoreElements()){
        String key = names.nextElement();
        String value = request.getParameter(key);
%>
    <%=key%>:<%=value%><br/>
<%
    }
%>
</body>
</html>
