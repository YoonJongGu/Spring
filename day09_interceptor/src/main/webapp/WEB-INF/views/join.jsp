<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>

<table>
	<thead>
		<tr>
			<th>IDX</th>
			<th>USERID</th>
			<th>USERPW</th>
			<th>USERNAME</th>
			<th>BIRTH</th>
			<th>GENDER</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="dto" items="${list }">
		<tr>
			<td>${dto.idx }</td>
			<td>${dto.userid }</td>
			<td>${dto.userpw }</td>
			<td>${dto.username }</td>
			<td>${dto.birth }</td>
			<td>${dto.gender }</td>
		</tr>
		</c:forEach>
	</tbody>
</table>

<form method="POST">
	<p><input type="text" name="userid" placeholder="ID 입력" required autofocus></p>
	<p><input type="password" name="userpw" placeholder="PW 입력" required></p>
	<p><input type="text" name="username" placeholder="이름 입력" required></p>
	<p><input type="date" name="birth" required></p>
	<p>
		<input type="radio" name="gender" value="남성" required>남성
		<input type="radio" name="gender" value="여성" required>여성
	</p>
	<p><input type="submit" value="회원가입"></p>
</form>

</body>
</html>