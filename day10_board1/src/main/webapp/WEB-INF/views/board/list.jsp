<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>

<form method="POST">
	<p>
		<input type="text" name="keyword" placeholder="제목으로 검색">
		<input type="submit" value="검색">
	</p>
</form>

<table>
	<thead>
		<tr>
			<th>IDX</th>
			<th>TITLE</th>
			<th>WRITER</th>
			<th>CONTENT</th>
			<th>REGISTDATE</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="dto" items="${list }">
		<tr>
			<td>${dto.idx }</td>
			<td><a href="${cpath }/board/detail/${dto.idx}">${dto.title }</a></td>
			<td>${dto.writer }</td>
			<td>${dto.content }</td>
			<td>${dto.registDate }</td>
		</tr>
		</c:forEach>
	</tbody>
</table>

<p><a href="${cpath }/board/write"><button>글쓰기</button></a></p>

<div>
	<c:if test="${paging.startPage != 1 }">
		<a href="${cpath }/board/list?nowPage=${paging.nowPage - 1 }">&lt;</a>
	</c:if>
	<c:forEach begin="${paging.startPage }" end="${paging.endPage }" var="page">
		<c:choose>
			<c:when test="${page == paging.nowPage }">
				<b>${page }</b>
			</c:when>
			<c:when test="${page != paging.nowPage }">
				<a href="${cpath }/board/list?nowPage=${page }">${page }</a>
			</c:when>
		</c:choose>
	</c:forEach>
	<c:if test="${paging.endPage != paging.lastPage }">
		<a href="${cpath }/board/list?nowPage=${paging.nowPage + 1 }">&gt;</a>
	</c:if>
</div>

</body>
</html>