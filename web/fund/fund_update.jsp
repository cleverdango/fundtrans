<%@ page import="com.mybank.fundtrans.dao.FundDao" %>
<%@ page import="com.mybank.fundtrans.dao.FundDaoJDBCImpl" %>
<%@ page import="com.mybank.fundtrans.domain.Fund" %>
<%@ page import="java.util.Date" %>
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
        request.setCharacterEncoding("utf-8");

        Fund fund = (Fund)request.getAttribute("fundUpdate");

    %>
    <form name="form1" action="Fund?type=5" method="post"
          onSubmit="return checkNull()">
        <p>
            <input class="text-input large-input" type="hidden"
                        name="fundId" value="<%=fund.getId()%>"/>
        </p>
        <p>
            基金名字：<input class="text-input large-input" type="text"
                        name="fundName" value="<%=fund.getName()%>"/>
        </p>
        <p>
            基金价格：<input class="text-input large-input" type="text"
                        name="fundPrice" value="<%=fund.getPrice()%>"/>
        </p>
        <p>
            基金描述：
            <textarea class="text-input textarea" rows="16" cols="50"
                      name="fundDes" ><%=fund.getDescription()%></textarea>
        </p>

        <p>
            基金状态： <input type="radio" name="fundStatus" value="Y"

        >可交易
            <input type="radio" name="fundStatus" value="N"/>不可交易
        </p>
        <p>
            <input class="button" type="submit" value="修改"/> <input
                class="button" type="reset" value="取消"/>
        </p>
    </form>
</div>

</body>
</html>