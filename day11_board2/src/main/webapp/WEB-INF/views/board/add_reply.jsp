<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>

<p>제목 : ${dto.title }</p>
<p>작성자 : ${dto.writer }</p>
<p>내용 : ${dto.content }</p>
<p>작성일 : ${dto.writeDate }</p>
<p>IP : ${dto.ipaddr }</p>
<p>조회수 : ${dto.viewCount }</p>

<form method="POST">
	<p><input type="hidden" name="reply_writer" value="${login.userid }" required></p>	
	<p><input type="hidden" name="reply_board" value="${dto.idx }" required></p>
	<p>
		<textarea name="content" placeholder="댓글 내용 입력" required autofocus></textarea>
	</p>
	<p><input type="submit" value="댓글 작성"></p>
</form>

</body>
</html>