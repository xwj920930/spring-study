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
    <title>测试requestbody</title>
</head>
<script type="text/javascript" src="/resource/js/jquery-3.2.1.min.js"></script>
<body>
<input type="button" value="提交json对象，返回string或实体" id="sub"><br>
<input type="button" value="提交json字符串，返回string或实体" id="sub1"><br>
<input type="button" value="提交json字符串，返回jsonobject" id="sub2"><br>
<input type="button" value="接收使用httpservletrequest" id="sub3"><br>
<form action="/people/model" method="post">
    <input type="text" name="userName"/>
    <input type="submit" value="测试modelAndView"><br>
</form>
<input type="button" value="测试modelAndView" id="sub4"><br>
<form action="/people/model1" method="post">
    <input type="text" name="userName"/>
    <input type="submit" value="测试@modelAttribute"><br>
</form>
<form action="/people/model2" method="post">
    <input type="text" name="passWord"/>
    <input type="submit" value="测试modelmap"><br>
</form>
<form action="/people/session" method="get">
    <input type="text" name="userName"/>
    <input type="text" name="passWord"/>
    <input type="submit" value="测试@sessionAttributes"><br>
</form>
<form action="/converter/format" method="post">
    <input type="text" name="userName" value="xwj"/>
    <input type="text" name="passWord" value="123123"/>
    <input type="text" name="time" value="2018-09-04"/>
    <input type="submit" value="测试@dateTimeFormat"><br>
</form>
<div id="div1"></div>
<%--<jsp:include page="model.jsp"/>--%>
<%--<iframe src="/people/jspp"/>--%>
</body>
</html>
<script>
    $('#sub').click(function () {
        $.ajax({
            url:"/people/json1",
            type:"post",
            data:{"userName":"xwj","passWord":"123"},
            success:function (data) {
                alert(data);
            }
        })
    });
    $('#sub1').click(function () {
        $.ajax({
            url:"/people/json2",
            type:"post",
            data:JSON.stringify({"userName":"xwj","passWord":"123"}),
            dataType:"json",
            contentType:"application/json",
            success:function (data) {
                alert(data);
            }
        })
    });
    $('#sub2').click(function () {
        $.ajax({
            url:"/people/json3",
            type:"post",
            data:JSON.stringify({"userName":"xwj","passWord":"123"}),
            dataType:"json",
            contentType:"application/json",
            success:function (data) {
                alert(data);
            }
        })
    });
    $('#sub3').click(function () {
        $.ajax({
            url:"/people/httpReq",
            type:"post",
            data:{"userName":"xwj","passWord":"123"},
            success:function (data) {
                alert(data);
            }
        })
    });
    $('#sub4').click(function () {
        $.ajax({
            url:"/people/model",
            type:"post",
            data:{"userName":"xwj","passWord":"123"},
            success:function (data) {
                alert(data);
                $('#div1').html(data);
            }
        })
    });
</script>
