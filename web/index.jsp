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
    <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <script type="text/javascript">
        //删除一行
        function delRow(rowIndex) {
            var tbobj = document.getElementById('table1');
            if (rowIndex == -1) {
                if (tbobj.rows.length > 1) {
                    tbobj.deleteRow(tbobj.rows.length - 1);
                }
            } else {
                tbobj.deleteRow(rowIndex);
            }
        }
    </script>
</head>
<body>
<table class="table table-hover">
    <caption>花卉信息</caption>
    <thead>
    <tr class="info">
        <th>花卉编号</th>
        <th>花卉名称</th>
        <th>价格(元)</th>
        <th>原产地</th>
        <th>操作</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${list}" var="flower">
        <tr class="active">
            <td>${flower.id}</td>
            <td>${flower.name}</td>
            <td>${flower.price}</td>
            <td>${flower.production}</td>
            <td>
                <div class="btn-group">
                    <button class="btn btn-default" type="button" οnclick="updateRowInfo()">修改</button>
                    <button class="btn btn-default" type="button" οnclick="deleteRowInfo()">删除</button>
                </div>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<div class="btn-group">
    <button class="btn btn-default" type="button" οnclick="deleteRowInfo()">
        <a href="add.jsp">新增花卉信息</a>
    </button>
</div>
</body>
</html>
