<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>

<form method="POST">
	<p><input type="text" name="name" placeholder="책 제목" required autofocus></p>
	<p><input type="text" name="author" placeholder="지은이" required></p>
	<p><input type="text" name="publisher" placeholder="출판사" required></p>
	<p><input type="date" name="publishDate" placeholder="출판일" required></p>
	<p><input type="number" name="price" min="0" max="500000" placeholder="가격" required></p>
	<p><input type="text" name="memo" placeholder="메모" required></p>
	<p><input type="number" name="score" min="0" max="10" step="0.1" placeholder="평점"></p>
	<p><input type="submit" value="추가"></p>
</form>

</body>
</html>