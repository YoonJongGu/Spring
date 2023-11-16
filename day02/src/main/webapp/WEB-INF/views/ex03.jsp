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

<h1><a href="${cpath }/">student1 테이블 수정</a></h1>
<hr>

<form method="POST">
	<p><input type="text" name="name" value="${dto.name }" readonly></p>
	<p><input type="number" name="kor" value="${dto.kor }" min="0" required></p>
	<p><input type="number" name="eng" value="${dto.eng }" min="0" required></p>
	<p><input type="number" name="mat" value="${dto.mat }" min="0" required></p>
	<p><input type="submit" value="수정"></p>
</form>

</body>
</html>