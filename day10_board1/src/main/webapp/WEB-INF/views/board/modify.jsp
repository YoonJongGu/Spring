<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>

<form method="POST">
	<p><input type="text" name="title" value="${dto.title }" placeholder="제목 입력" required autofocus></p>
	<p><textarea name="content" placeholder="내용 입력" required>${dto.content }</textarea></p>
	<p><input type="submit" value="수정"></p>
</form>

</body>
</html>