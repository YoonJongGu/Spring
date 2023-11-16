<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>

<div class="detail">
	<div class="image"><img src="${cpath }/upload/${dto.thumbnailName }" height="300"></div>
	<div>
		<p class="title">${dto.productName }</p>
		<p><fmt:formatNumber>${dto.price }</fmt:formatNumber>원</p>
		<p>${dto.score }점</p>
		<p>
			<a href="${cpath }/modify?idx=${dto.idx }"><button>수정</button></a>
			<a href="${cpath }/delete?idx=${dto.idx }"><button>삭제</button></a>
		</p>		
	</div>
</div>

<div class="review">
	<img src="${cpath }/upload/${dto.reviewImageName }">
</div>

</body>
</html>