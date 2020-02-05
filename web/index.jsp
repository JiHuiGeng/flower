<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/2/5 0005
  Time: 6:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>花卉信息界面</title>
    <link type="text/css" rel="stylesheet" href="css/index.css">
</head>
<body>
<table border="1">
    <tr>
        <th>花卉编号</th>
        <th>花卉名称</th>
        <th>价格(元)</th>
        <th>原产地</th>
    </tr>
    <c:forEach items="${list}" var="flower">
        <tr>
            <th>${flower.id}</th>
            <th>${flower.name}</th>
            <th>${flower.price}</th>
            <th>${flower.production}</th>
        </tr>
    </c:forEach>
</table>
<a href="add.jsp">添加新的花卉信息</a>
</body>
</html>
