<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="cpath" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1><a href="${cpath }/">student1 테이블 추가</a></h1>
<hr>

<form method="POST">
	<p><input type="text" name="name" placeholder="이름" required autofocus></p>
	<p><input type="number" name="kor" placeholder="국어" min="0" required></p>
	<p><input type="number" name="eng" placeholder="영어" min="0" required></p>
	<p><input type="number" name="mat" placeholder="수학" min="0" required></p>
	<p><input type="submit" value="추가"></p>
</form>

</body>
</html>