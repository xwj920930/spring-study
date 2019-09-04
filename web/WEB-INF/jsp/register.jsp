<%--
  Created by IntelliJ IDEA.
  User: yuki
  Date: 2018/8/21
  Time: 10:11
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<html>
<head>
    <title>注册</title>
</head>
<body>
<form method="post" action="/people/create">
    用户名：<input type="text" name="userName">
    密码：<input type="text" name="passWord">
    <input type="submit" value="提交">
</form>

<form method="post" action="/people/create1">
    <span>用于验证requestParam</span>
    用户名：<input type="text" name="userName">
    密码：<input type="text" name="passWord">
    <input type="submit" value="提交">
</form>
</body>
</html>
