<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="cpath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ex03.jsp</title>
</head>
<body>

<h1>ex03 - CORS 정책에 의해 자바스크립트에서 호출할 수 없는 경우</h1>
<hr>

<script>
	// 실제로는 fetch 호출이 가능하지만, 연습을 위해 CORS 정책에 의해 막혔다고 가정하고 진행
// 	const url = 'https://apis.data.go.kr/1360000/MidFcstInfoService/getMidTa?serviceKey=KduDR9%2Fc1e%2BIhCQnNdf2gfUV%2BDkEleHLJ93mk7MCtTzv5qwMFJLvWfKDNaMzCJWD6ZyRvMLS4%2FlU2vYx2slpaw%3D%3D&pageNo=1&numOfRows=10&dataType=JSON&regId=11H20201&tmFc=202301270600'
	const url = '${cpath}/getMidFcst'
	
	fetch(url)
	.then(resp => resp.json())
	.then(json => {
		const data = json.response.body.items.item[0]

		for(let key in data) {
			if(key.includes('High') || key.includes('Low')) delete data[key]			
		}
		
		console.log(data)
		
	})
</script>
</body>
</html>