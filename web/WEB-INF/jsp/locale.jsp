<%--
  Created by IntelliJ IDEA.
  User: yuki
  Date: 2018/8/21
  Time: 10:11
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<html>
<head>
    <title>测试国际化</title>
</head>
<script type="text/javascript" src="/resource/js/jquery-3.2.1.min.js"></script>
<body>
语言：<a href="?lang=zh_CN">中文</a>
<a href="?lang=en_US">英文</a><br>
<h1>
    <fmt:message key="greeting.morning"/>
</h1>
</body>
</html>
<script>
</script>
