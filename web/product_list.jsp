<%@ page import="basic.Product" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: SHUQIN
  Date: 2021/9/27
  Time: 20:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=GBK" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=GBK">
    <title>product</title>
</head>
<style type="text/css">
    td{font-size: 16px;}
    h2{margin: 2px}
</style>
<body background="timg(14).jpg">
<table align="center" width="900" border="4" bgcolor="#dcdcdc" style="border: #7d8a2e">
    <tr>
        <td align="center" colspan="5">
            <h2 style="color: #ff8598">所有商品信息</h2>
        </td>
    </tr>
    <tr align="center" style="color: black">
        <td><b>ID</b></td>
        <td><b>商品名称</b></td>
        <td><b>价格</b></td>
        <td><b>数量</b></td>
        <td><b>单位</b></td>
    </tr>
    <%
        List<Product> list = (List<Product>)request.getAttribute("list");
        for(Product p : list){
    %>
    <tr align="center" style="color: dimgrey">
        <td><%=p.getId()%></td>
        <td><%=p.getName()%></td>
        <td><%=p.getPrice()%></td>
        <td><%=p.getNum()%></td>
        <td><%=p.getUnit()%></td>
    </tr>
    <%
        }
    %>
    <tr>
        <td align="center" colspan="5">
            <%=request.getAttribute("bar")%>
        </td>
    </tr>

</table>
</body>
</html>
