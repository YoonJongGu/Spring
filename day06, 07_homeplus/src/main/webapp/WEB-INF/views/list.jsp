<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>

<div class="menu">
<form method="POST">
	<p>카테고리 : 
		<input type="radio" name="keyword" value="사과">사과
		<input type="radio" name="keyword" value="배">배	
	
	/ 정렬 방식 : 
		<input type="radio" name="order" value="desc">높은 가격순
		<input type="radio" name="order" value="asc">낮은 가격순
		<input type="submit" value="검색">
	</p>
	
</form>
</div>

<div class="wrap">
	<c:forEach var="dto" items="${list }">
	<div class="item">
		<p><a href="${cpath }/detail?idx=${dto.idx }"><img src="${cpath }/upload/${dto.thumbnailName }" height="150"></a></p>		
		<p><a href="${cpath }/detail?idx=${dto.idx }">${dto.productName }</a></p>
		<p><fmt:formatNumber>${dto.price }</fmt:formatNumber>원</p>
		<p>${dto.score }점</p>		
	</div>
	</c:forEach>
</div>

</body>
</html>