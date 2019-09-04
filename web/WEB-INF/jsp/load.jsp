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
    <title>文件上传下载</title>
</head>
<script type="text/javascript" src="/resource/js/jquery-3.2.1.min.js"></script>
<body>
<form action="/load/up" enctype="multipart/form-data" method="post">
    <input type="file" name="file"/>
    <input type="submit" value="上传"><br>
</form>
<a href="/load/down">下载</a>
</body>
</html>
<script>
</script>
