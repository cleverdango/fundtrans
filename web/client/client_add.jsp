<%--
  Created by IntelliJ IDEA.
User: yazawanico
Date: 2017/5/7
Time: 14:55
To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
//basePath="http://localhost:8080/clienttrans/"
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">     <!--定义基准路径  -->
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>add client</title>
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
    <h3>客户信息管理</h3>
</div>

<div class="content-box-content">
    <form name="form1" action="client/addClient.action" method="post"
          onSubmit="return checkNull()">
        <p>
            身份证号：<input class="text-input large-input" type="text"
                        name="client.IDCard"/>
        </p>
        <p>
            姓名：<input class="text-input large-input" type="text"
                        name="client.name"/>
        </p>
        <p>
            性别：
            <input type="radio" name="client.sex" value="M" checked/>男
            <input type="radio" name="client.sex" value="F"/>女

        </p>
        <p>
            电话：
            <input class="text-input large-input" type="text"
                   name="client.phone"/>
        </p>

        <p>
            地址：<input class="text-input large-input" type="text"
                      name="client.address"/>
        </p>
        <p>
            Email：<input class="text-input large-input" type="text"
                      name="client.email"/>
        </p>
        <p>
            爱好<input class="text-input large-input" type="text"
                     name="client.hobby"/>
        </p>

        <p>
            <input class="button" type="submit" value="新增" />
            <input
                class="button" type="reset" value="取消"/>
        </p>
    </form>
</div>

</body>
</html>