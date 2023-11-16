<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>

<p>아이디 : ${dto.userid }</p>
<p>비밀번호 : ${dto.userpw }</p>
<p>이름 : ${dto.username }</p>
<p>생년월일 : ${dto.birth }</p>
<p>성별 : ${dto.gender }</p>
<p>
	<a href="${cpath }/member/modify/${dto.idx}"><button>수정</button></a>
	<a href="${cpath }/member/remove/${dto.idx}"><button>삭제</button></a>
</p>

</body>
</html>