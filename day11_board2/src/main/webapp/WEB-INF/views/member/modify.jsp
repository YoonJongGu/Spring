<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>

<form method="POST">
	<p><input type="text" name="userid" value="${dto.userid }" readonly></p>	
	<p><input type="password" name="userpw" value="${dto.userpw }" placeholder="PW 입력" required></p>	
	<p><input type="text" name="username" value="${dto.username }" placeholder="이름 입력" required></p>	
	<p><input type="date" name="birth" value="${dto.birth }" required></p>	
	<p>
		<input type="radio" name="gender" value="남성" ${dto.gender == '남성' ? 'checked' : ''} required>남성
		<input type="radio" name="gender" value="여성" ${dto.gender == '여성' ? 'checked' : ''} required>여성
	</p>	
	<p><input type="submit" value="수정"></p>	
</form>

</body>
</html>