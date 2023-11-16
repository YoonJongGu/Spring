<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>

<form action="${cpath }/board/search">
	<p><input type="text" name="keyword" placeholder="검색어 입력" value="${keyword }" autofocus></p>
	<p><input type="submit" value="검색"></p>
</form>

<table>
	<thead>
		<tr>
			<th>IDX</th>
			<th>TITLE</th>
			<th>WRITER</th>
			<th>WRITEDATE</th>
			<th>IPADDR</th>
			<th>VIEWCOUNT</th>
			<th>FILEEXISTS</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="dto" items="${list }">
		<tr>
			<td>${dto.idx }</td>
			<td><a href="${cpath }/board/detail/${dto.idx }/${paging.nowPage }">${dto.title }</a></td>
			<td>${dto.writer }</td>
			<td>${dto.writeDate }</td>
			<td>${dto.ipaddr }</td>
			<td>${dto.viewCount }</td>
			<td>
				<c:if test="${not empty dto.uploadFileName }">
					<img src="${cpath }/resources/파일 아이콘.png" height="15px">
				</c:if>
			</td>
		</tr>
		</c:forEach>
	</tbody>
</table>

<p><a href="${cpath }/board/write"><button>글쓰기</button></a></p>

<p>
	<c:if test="${paging.nowPage > 1}">
		<a href="${cpath }/board/list?nowPage=${paging.nowPage - 1 }">[이전]</a>		
	</c:if>
	
	<c:forEach var="page" begin="${paging.startPage }" end="${paging.endPage }">
	<c:if test="${paging.lastPage >= page }">
		<c:if test="${page == paging.nowPage }">
			<b>${paging.nowPage }</b>
		</c:if>
		<c:if test="${page != paging.nowPage }">
			<a href="${cpath }/board/list?nowPage=${page }">${page }</a>
		</c:if>
	</c:if>
	</c:forEach>	
	<c:if test="${paging.nowPage < paging.lastPage}">
		<a href="${cpath }/board/list?nowPage=${paging.nowPage + 1 }">[다음]</a>		
	</c:if>
</p>

</body>
</html>