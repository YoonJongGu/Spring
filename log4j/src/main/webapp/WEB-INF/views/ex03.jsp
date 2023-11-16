<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<table>
	<thead>
		<tr>
			<th>IDX</th>
			<th>USERID</th>
			<th>USERPW</th>
			<th>USERNAME</th>
			<th>BIRTH</th>
			<th>GENDER</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="map" items="${list }">		
		<tr>
			<td>${map.IDX }</td>
			<td>${map.USERID }</td>
			<td>${map.USERPW }</td>
			<td>${map.USERNAME }</td>
			<td>${map.BIRTH }</td>			
			<td>${map.GENDER }</td>		
		</tr>		
		</c:forEach>
	</tbody>
</table>

</body>
</html>