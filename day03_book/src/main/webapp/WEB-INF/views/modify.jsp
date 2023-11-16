<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>

<form method="POST">
	<p>책 제목 : <input type="text" name="name" value="${dto.name }" required autofocus></p>
	<p>지은이 : <input type="text" name="author" value="${dto.author }" required></p>
	<p>출판사 : <input type="text" name="publisher" value="${dto.publisher }" required></p>
	<p>출판일 : <input type="date" name="publishDate" value="${dto.publishDate }" required></p>
	<p>가격 : <input type="number" name="price" min="0" max="500000" value="${dto.price }" required></p>
	<p>메모 : <input type="text" name="memo" value="${dto.memo }" required></p>
	<p>평점 : <input type="number" name="score" min="0" max="10" step="0.1" value="${dto.score }"></p>
	<p><input type="submit" value="수정"></p>
</form>

</body>
</html>