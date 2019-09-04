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
    <title><fmt:message key="website.title"/></title>
</head>
<script type="text/javascript" src="/resource/js/jquery-3.2.1.min.js"></script>
<body>
<c:if test="${errors != null}">
    <c:forEach items="${errors}" var="error">
        ${error.defaultMessage}<br>
    </c:forEach>
</c:if>
<form action="/validate/people" method="post">
    <input type="text" name="userName"/>
    <input type="text" name="passWord" value="123123"/>
    <input type="text" name="time" value="2018-09-04"/>
    <input type="submit" value="测试validate"><br>
</form>
</body>
</html>
<script>
</script>
