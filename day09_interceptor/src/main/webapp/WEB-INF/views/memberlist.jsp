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
		</tr>
		</c:forEach>
	</tbody>
</table>

<div>
	<c:if test="${paging.startPage != 1 }">
		<a href="${cpath }/memberlist?nowPage=${paging.startPage - 1 }">&lt;</a>
	</c:if>
	<c:forEach begin="${paging.startPage }" end="${paging.endPage }" var="page">
		<c:choose>
			<c:when test="${page == paging.nowPage }">
				<b>${page }</b>
			</c:when>
			<c:when test="${page != paging.nowPage }">
				<a href="${cpath }/memberlist?nowPage=${page }">${page }</a>
			</c:when>
		</c:choose>
	</c:forEach>
	<c:if test="${paging.endPage != paging.lastPage }">
		<a href="${cpath }/memberlist?nowPage=${paging.endPage + 1 }">&gt;</a>
	</c:if>
</div>

</body>
</html>