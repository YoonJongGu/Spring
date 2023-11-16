<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>

<p>제목 : ${dto.title }</p>
<p>작성자 : ${dto.writer }</p>
<p>내용 : ${dto.content }</p>
<p>작성일 : ${dto.writeDate }</p>
<p>IP : ${dto.ipaddr }</p>
<p>조회수 : ${dto.viewCount }</p>
<div class="img">
	<c:forTokens var="fileName" items="${dto.uploadFileName }" delims=",">
	<div>
		<img src="${cpath }/upload/${fileName }">
	</div>
	</c:forTokens>
</div>

<c:if test="${login.userid == dto.writer }">
	<p>
		<a href="${cpath }/board/modify/${dto.idx}"><button>수정</button></a>
		<a href="${cpath }/board/remove/${dto.idx}"><button>삭제</button></a>
	</p>
</c:if>

<fieldset class="reply">
	<legend>댓글</legend>
	<c:forEach var="reply" items="${reply_list }">
	<div>		
		<p>댓글 작성자 : ${reply.reply_writer }</p>
		<p>댓글 번호 : ${reply.reply_board }</p>
		<p>댓글 내용 : ${reply.content }</p>
	</div>
	</c:forEach>
</fieldset>

<p>
	<a href="${cpath }/board/add_reply/${dto.idx }/${paging.nowPage }"><button>댓글 작성</button></a>
</p>

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
		<c:forEach var="detail" items="${list }">
		<tr class="${dto.idx == detail.idx ? 'bold' : '' }">
			<td>${detail.idx }</td>
			<td><a href="${cpath }/board/detail/${detail.idx }/${paging.nowPage }">${detail.title }</a></td>
			<td>${detail.writer }</td>
			<td>${detail.writeDate }</td>
			<td>${detail.ipaddr }</td>
			<td>${detail.viewCount }</td>
			<td>
				<c:if test="${not empty detail.uploadFileName }">
					<img src="${cpath }/resources/파일 아이콘.png" height="15px">
				</c:if>
			</td>
		</tr>
		</c:forEach>
	</tbody>
</table>

<p>
	<c:if test="${paging.nowPage > 1}">
		<a href="${cpath }/board/detail/${dto.idx }/${paging.nowPage - 1 }">&lt;</a>		
	</c:if>
	
	<c:forEach var="page" begin="${paging.startPage }" end="${paging.endPage }">
	<c:if test="${paging.lastPage >= page }">
		<c:if test="${page == paging.nowPage }">
			<b>${paging.nowPage }</b>
		</c:if>
		<c:if test="${page != paging.nowPage }">
			<a href="${cpath }/board/detail/${dto.idx }/${page }">${page }</a>
		</c:if>
	</c:if>
	</c:forEach>	
	<c:if test="${paging.nowPage < paging.lastPage}">
		<a href="${cpath }/board/detail/${dto.idx }/${paging.nowPage + 1 }">></a>		
	</c:if>
</p>

</body>
</html>