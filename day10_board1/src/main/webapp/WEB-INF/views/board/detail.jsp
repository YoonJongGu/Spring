<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>

<p>제목 : ${dto.title }</p>
<p>작성자 : ${dto.writer }</p>
<p>내용 : ${dto.content }</p>
<p>작성일 : ${dto.registDate }</p>

<c:if test="${login.userid == dto.writer }">
	<p>
		<a href="${cpath }/board/modify/${dto.idx}"><button>수정</button></a>
		<a href="${cpath }/board/remove/${dto.idx}"><button>삭제</button></a>
	</p>
</c:if>

</body>
</html>