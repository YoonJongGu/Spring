<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>

<form method="POST">
	<p><input type="text" name="search" placeholder="책 제목으로 검색" required autofocus></p>
	<p><input type="submit" value="검색"></p>
</form>

<table>
	<thead>
		<tr>
			<th>NAME</th>
			<th>PRICE</th>
			<th>PUBLISHER</th>		
		</tr>
	</thead>
	<tbody>
		<c:forEach var="dto" items="${list }">
		<tr>
			<td><a href="${cpath }/detail?idx=${dto.idx }">${dto.name }</a></td>
			<td>${dto.price }</td>
			<td>${dto.publisher }</td>				
		</tr>
		</c:forEach>
	</tbody>
</table>

</body>
</html>