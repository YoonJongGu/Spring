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
	table {
		border-collapse: collapse;
		border: 2px solid black;
	}
	thead {
		background-color: #dadada;
	}	
	th, td {
		border: 1px solid grey;
		padding: 5px 10px;
	}
</style>
</head>
<body>
<%--
		기능			주소			메서드		함수						응답
		==============================================================
		목록			/list		GET			list()					"list"
					목록에서는 책의 이름과 가격 출판사만 표기합니다
					
		검색			/list		POST		search(String search)	"list"
		
		추가			/add		GET			add()					"add"
					/add		POST		add(BookDTO dto)		"redirect:/list"
		
		단일보기		/detail		GET			detail(int idx)			"detail"
					단일보기에서는 책의 모든 내용을 한 화면에 출력합니다
					
		수정			/modify		GET			modify(int idx)			"modify"
					/modify		POST		modify(BookDTO dto)		"redirect:/list"
					
		삭제			/delete		GET			delete(int idx)			"redirect:list"
 --%>
<%-- 여기까지는 header.jsp --%>
<h1><a href="${cpath }/">day03 - book</a></h1>
<nav>
	<ul>
		<li><a href="${cpath }/list">목록(검색 포함, 제목으로 검색, 단일 보기 메뉴 구현하기)</a></li>		
		<li><a href="${cpath }/add">추가</a></li>
	</ul>
</nav>