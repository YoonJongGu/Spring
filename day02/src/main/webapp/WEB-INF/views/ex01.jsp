<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="cpath" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	table {
		border-collapse: collapse;
		border: 2px solid black;
	}
	th, td {
		border: 1px solid grey;
		padding: 10px 20px;
	}
</style>
</head>
<body>

<h1><a href="${cpath }/">student1 테이블 목록</a></h1>
<hr>

<table>
	<thead>
		<tr>
			<th>NAME</th>
			<th>KOR</th>
			<th>ENG</th>
			<th>MAT</th>
			<th>수정</th>
			<th>삭제</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="dto" items="${list }">
		<tr>
			<td>${dto.name }</td>
			<td>${dto.kor }</td>
			<td>${dto.eng }</td>
			<td>${dto.mat }</td>
			<td><a href="${cpath }/ex03?name=${dto.name }"><button>수정</button></a></td>		
			<td><a href="${cpath }/ex04?name=${dto.name }"><button>삭제</button></a></td>		
		</tr>
		</c:forEach>
	</tbody>
</table>

</body>
</html>