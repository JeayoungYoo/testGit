<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<html>
<head>
	<title>Home</title>
</head>
<body>
<c:set var="myContextPath" value="${pageContext.request.contextPath}"/>

<h1>
	Sprint test project : third  
</h1>
<c:if test="${ empty member }">
<form action="login.do" method="post">
	아이디 : <input type="text" name="id"> <br>
	암   호 : <input type="password" name="passwd"> <br>
	<input type="submit" value="login">
</form>
<a href="enrollView.do">회원가입</a>
</c:if>
<c:if test="${ !empty member }">
	<h3>${ sessionScope.member.name } 님 <a href="logout.do">로그아웃</a></h3>
</c:if>
</body>
</html>
