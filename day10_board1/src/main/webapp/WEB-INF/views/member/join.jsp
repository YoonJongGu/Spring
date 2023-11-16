<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>

<form method="POST">
	<p><input type="text" name="userid" placeholder="ID 입력" required autofocus></p>
	<p><input type="password" name="userpw" placeholder="PW 입력" required></p>
	<p><input type="text" name="username" placeholder="이름 입력" required></p>	
	<p><input type="date" name="birth" required></p>
	<p>
		<input type="radio" name="gender" value="남성" required>남성
		<input type="radio" name="gender" value="여성" required>여성
	</p>
	<p><input type="submit" value="가입"></p>
</form>

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

<div>
	<c:if test="${paging.startPage != 1 }">
		<a href="${cpath }/member/join?nowPage=${paging.startPage - 1 }">&lt;</a>
	</c:if>
	<c:forEach begin="${paging.startPage }" end="${paging.endPage }" var="page">
		<c:choose>
			<c:when test="${page == paging.nowPage }">
				<b>${page }</b>
			</c:when>
			<c:when test="${page != paging.nowPage }">
				<a href="${cpath }/member/join?nowPage=${page }">${page }</a>
			</c:when>
		</c:choose>
	</c:forEach>
	<c:if test="${paging.endPage != paging.lastPage }">
		<a href="${cpath }/member/join?nowPage=${paging.endPage + 1 }">&gt;</a>
	</c:if>
</div>

</body>
</html>