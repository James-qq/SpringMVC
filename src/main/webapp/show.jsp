<%--
  Created by IntelliJ IDEA.
  User: qianq
  Date: 2020/6/7
  Time: 17:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>学生信息</h1>
<form>
    学生ID：<input type="text" name="id" value="${student.id}"/><br/>
    学生姓名：<input type="text" name="name" value="${student.name}"/><br/>
    学生年龄：<input type="text" name="age" value="${student.age}"/><br/>
    <input type="submit" value="提交"/>
</body>
</html>
