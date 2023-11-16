<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>

<form method="POST">
	<p><input type="text" name="userid" placeholder="ID" required autofocus></p>
	<p><input type="password" name="userpw" placeholder="Password" required></p>
	<p><input type="text" name="username" placeholder="Name" required></p>
	<p><input type="date" name="birth" required></p>
	<p><input type="radio" name="gender" value="남성" required>남성</p>	
	<p><input type="radio" name="gender" value="여성" required>여성</p>	
	<p><input type="submit" value="추가"></p>
</form>

</body>
</html>