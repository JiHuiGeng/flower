<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/2/5 0005
  Time: 14:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>新增花卉信息</title>
    <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <link type="text/css" rel="stylesheet" href="css/add.css">
    <script type="text/javascript">
        $(function () {
            $("form").submit(function () {
                //如果name,price,production为空,那么就返回false
                //获取表单元素 type属性值:eq(0),获取第一个表单元素
                if ($(":text:eq(0)").val() == "" || $(":text:eq(1)").val() == "" || $(":text:eq(2)").val() == "") {
                    alert("请添加完整信息")
                    return false;
                }
            })
        });
    </script>
</head>
<body>
<!--
    post  字节流   2GB  相对来说更安全  相对效率低
    get   字符流   2KB  暴露地址        相对效率高
-->
<form action="insert" method="post">
    <table border="1" align="center">
        <tr>
            <td id="title" colspan="2">
                花卉信息
            </td>
        </tr>

        <tr>
            <td><b>花卉名称:</b></td>
            <td><input type="text" name="name"></td>
        </tr>
        <tr>
            <td><b>花卉价格:</b></td>
            <td><input type="text" name="price"></td>
        </tr>
        <tr>
            <td><b>原产地:</b></td>
            <td><input type="text" name="production"></td>
        </tr>
        <tr>
            <td colspan="2" align="center">
                <input type="submit" value="提交"><input type="reset" value="重置">
            </td>
        </tr>
    </table>
</form>
</body>
</html>
