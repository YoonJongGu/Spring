<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="cpath" value="${pageContext.request.contextPath }" /> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>ex05 - 코로나 현황</h1>
<hr>

<script>
	const url = '${cpath}/COVID-19'
	
	fetch(url)
	.then(resp => resp.text)
	.then(text => new DOMParser().parseFromString(text, 'application/xml'))
	.then(xml => console.log(xml))	
</script>

</body>
</html>