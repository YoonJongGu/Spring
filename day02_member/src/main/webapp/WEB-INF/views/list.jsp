<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>

<table>
	<thead>
		<tr>
			<th>IDX</th>
			<th>USERID</th>
			<th>USERPW</th>
			<th>USERNAME</th>
			<th>BIRTH</th>
			<th>GENDER</th>
			<th>수정</th>
			<th>삭제</th>			
		</tr>
	</thead>
	<tbody>
		<c:forEach var="dto" items="${list }">
		<tr>
			<td>${dto.idx }</td>
			<td>${dto.userid }</td>
			<td>${dto.userpw }</td>
			<td>${dto.username }</td>
			<td>${dto.birth }</td>
			<td>${dto.gender }</td>
			<td><a href="${cpath }/update?idx=${dto.idx }"><button>수정</button></a></td>
			<td><a href="${cpath }/delete?idx=${dto.idx }"><button>삭제</button></a></td>			
		</tr>
		</c:forEach>
	</tbody>
</table>

</body>
</html>