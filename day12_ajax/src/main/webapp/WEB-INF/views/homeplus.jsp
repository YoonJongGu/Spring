<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="cpath" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link type="text/css" rel="stylesheet" href="${cpath }/resources/css/style.css">
</head>
<body>

<h1>homeplus 상품 목록</h1>
<hr>

<div id="root">
	<div id="column">
		<div class="idx">상품번호</div>
		<div class="category">카테고리</div>
		<div class="productName">상품명</div>
		<div class="price">가격</div>
		<div class="score">점수</div>
		<div class="registDate">등록날짜</div>		
	</div>
	<div id="items">
		<img class="loading" src="${cpath }/resources/image/로딩.gif">
	</div>
</div>
<script src="${cpath }/resources/js/function.js"></script>
<script>
	const cpath = '${cpath}'
	const items = document.getElementById('items')
	
	// 문서 body가 모두 불러와지면 자동으로 loadHandler를 실행한다
	document.body.onload = loadHandler
</script>

</body>
</html>