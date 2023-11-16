<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>

<p>제목 : ${dto.name }</p>
<p>지은이 : ${dto.author }</p>
<p>출판사 : ${dto.publisher }</p>
<p>출판일 : ${dto.publishDate }</p>
<p>가격 : ${dto.price }</p>
<p>메모 : ${dto.memo }</p>
<p>평점 : ${dto.score }</p>
<p>
<a href="${cpath }/modify?idx=${dto.idx }"><button>수정</button></a>			
<a href="${cpath }/delete?idx=${dto.idx }"><button>삭제</button></a>
</p>	
</body>
</html>