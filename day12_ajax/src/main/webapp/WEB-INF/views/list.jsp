<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="cpath" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	#root {
		border: 2px solid black;
		max-width: 1200px;
		margin: auto;
	}
	#column {
		background-color: #dadada;
		display: flex;
	}
	#column > div {
		flex: 1;
		padding: 5px 10px;
		border: 1px solid black;
		text-align: center;
		font-weight: bold;
	}
	.item {
		display: flex;
	}
	.item > div {
		flex: 1;
		border: 1px solid grey;
	}
</style>
</head>
<body>

<h1>Member5 List</h1>
<hr>

<div id="root">
	<div id="column">
		<div class="idx">IDX</div>
		<div class="userid">USERID</div>
		<div class="userpw">USERPW</div>
		<div class="username">USERNAME</div>
		<div class="birth">BIRTH</div>
		<div class="gender">GENDER</div>
	</div>
	<div id="items"></div>
</div>
<script src="${cpath }/resources/js/list.js"></script>
<script>
	const items = document.getElementById('items')
	const cpath = '${cpath}'
	
	document.body.onload = getList
</script>

</body>
</html>