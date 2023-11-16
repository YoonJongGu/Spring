<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>

<form method="POST" enctype="multipart/form-data">
<div>
	<input type="hidden" name="idx" value="${dto.idx }">
	<p>
		<input type="radio" name="category" value="사과" ${dto.category == '사과' ? 'checked' : ''} required>사과
		<input type="radio" name="category" value="배" ${dto.category == '배' ? 'checked' : ''} required>배
	</p>
	<p><input type="text" name="productName" value="${dto.productName }" required></p>
	<p><input type="number" name="price" min="0" max="500000" step="10" value="${dto.price }" required></p>
	<p><input type="number" name="score" min="0" max="5" step="0.1" value="${dto.score }" required></p>
	<p>수정할 썸네일 이미지 : <input type="file" name="thumbnail"></p>
	<p><input type="text" name="thumbnailName" value="${dto.thumbnailName }"></p>
	<p>수정할 리뷰 이미지 : <input type="file" name="reviewImage"></p>
	<p><input type="text" name="reviewImageName" value="${dto.reviewImageName }"></p>
	<p><input type="submit" value="수정"></p>	
</div>
</form>

</body>
</html>