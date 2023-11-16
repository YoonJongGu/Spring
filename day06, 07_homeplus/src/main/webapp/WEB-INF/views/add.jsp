<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>

<form method="POST" enctype="multipart/form-data">
	<p>
		<input type="radio" name="category" value="사과" required>사과
		<input type="radio" name="category" value="배" required>배
	</p>
	<p><input type="text" name="productName" placeholder="상품이름" required></p>
	<p><input type="number" name="price" min="0" max="500000" step="10" placeholder="가격" required></p>
	<p><input type="number" name="score" min="0" max="5" step="0.1" placeholder="점수" required></p>
	<p><input type="file" name="thumbnail"></p>
	<p><input type="file" name="reviewImage"></p>
	<p><input type="submit" value="추가"></p>	
</form>

</body>
</html>