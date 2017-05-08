<%--
  Created by IntelliJ IDEA.
  User: yazawanico
  Date: 2017/5/7
  Time: 15:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="com.mybank.fundtrans.dao.FundDao" %>
<%@ page import="com.mybank.fundtrans.dao.FundDaoJDBCImpl" %>
<%@ page import="com.mybank.fundtrans.domain.Fund" %>
<%@ page import="com.mybank.fundtrans.domain.Client" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
//basePath="http://localhost:8080/fundtrans/"
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">     <!--定义基准路径  -->
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>add fund</title>
    <script language="javascript">
        function checkNull() {
            /*判断是否有空内容*/
            for (i = 0; i < form1.length; i++) {
                if (form1.elements[i].value == "") {
                    alert(form1.elements[i].title + "不能为空!");
                    form1.elements[i].focus();
                    return false;
                }
            }
        }
    </script>
</head>
<body>
<div class="content-box-header">
    <h3>新增基金信息</h3>
</div>

<div class="content-box-content">
    <%


        Client client = (Client) request.getAttribute("Client");

    %>
    <form name="form1" action="client/updateClient.action" method="post"
          onSubmit="return checkNull()">
        <p>
            <input class="text-input large-input" type="hidden"
                   name="client.IDCard" value="<%=client.getIDCard()%>"/>
        </p>
        <p>
            客户名字：<input class="text-input large-input" type="text"
                        name="client.name" value="<%=client.getName()%>"/>
        </p>


        <p>
            客户性别 ： <input type="radio" name="client.status" value="Y"  <% if (client.getSex().equals("M")) out.print("checked");%> />男
            <input type="radio" name="client.sex" value="N"<% if (client.getSex().equals("F")) out.print("checked");%>/>女
        </p>
        <p>
            电话：<input class="text-input large-input" type="text"
                      name="client.phone" value="<%=client.getPhone()%>"/>
        </p>
        <p>
            地址：<input class="text-input large-input" type="text"
                      name="client.address" value="<%=client.getAddress()%>"/>
        </p>
        <p>
            Email：<input class="text-input large-input" type="text"
                         name="client.email" value="<%=client.getEmail()%>"/>
        </p>
        <p>
            爱好：<input class="text-input large-input" type="text"
                      name="client.hobby" value="<%=client.getHobby()%>"/>
        </p>
        <p>
            <input class="button" type="submit" value="修改"/> <input
                class="button" type="reset" value="取消"/>
        </p>
    </form>
</div>

</body>
</html>