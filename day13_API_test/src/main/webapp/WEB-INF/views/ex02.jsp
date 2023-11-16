<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="cpath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ex02.jsp</title>
<style>
	.item {
		margin: 20px;
		position: relative;
	}
	.LAT, .LNG, .UC_SEQ, .MAIN_IMG_THUMB {
		display: none;
	}
	.MAIN_IMG_NORMAL {
		position: absolute;
		top: 22px;
		right: 10px;
		
		width: 250px;
		height: 250px;
		background-position: center center;
		background-size: auto 100%;				
	}
	.HOMEPAGE_URL > a {
		text-decoration: none;
		color: black;
		font-weight: bold;
	}
	.HOMEPAGE_URL > a:hover {
		text-decoration: underline;
	}
	fieldset {
		margin-top: 10px; 
	}
</style>
</head>
<body>

<h1>ex02.jsp</h1>
<hr>

<div id="root"></div>

<script src="${cpath }/resources/js/festival.js"></script>
<script>	
	async function loadHandler() {
		const root = document.getElementById('root')
		const url = 'https://apis.data.go.kr/6260000/FestivalService/getFestivalKr?serviceKey=KduDR9%2Fc1e%2BIhCQnNdf2gfUV%2BDkEleHLJ93mk7MCtTzv5qwMFJLvWfKDNaMzCJWD6ZyRvMLS4%2FlU2vYx2slpaw%3D%3D&pageNo=1&numOfRows=20&resultType=json'
		await fetch(url)
		.then(resp => resp.json())
		.then(json => {
			console.log(json.getFestivalKr.item)
			const arr = json.getFestivalKr.item
			arr.forEach(item => {			
				root.appendChild(makeList(item))		
			})
		})	
		
		const items = await document.querySelectorAll('.item')	
		console.log(items)	
		
		function clickHandler(event) {
			console.log(event.target.innerText)	
			const open = document.querySelectorAll('details.item[open]')
			console.log(open)
		}
		
		items.forEach(e => e.onclick = clickHandler)
	}
	
	document.body.onload = loadHandler
</script>

<script>
	
</script>

</body>
</html>