<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>

<form method="POST" enctype="multipart/form-data">
	<p>제목 : <input type="text" name="title" placeholder="제목 입력" value="${dto.title }" required autofocus></p>	
	<div class="content">
		<div>내용 : </div>
		<div><textarea name="content" placeholder="내용 입력" required>${dto.content }</textarea></div>
	</div>
	<p><input type="file" name="uploadFile" multiple></p>
	<p><input type="submit" value="글수정"></p>
</form>

</body>
</html>