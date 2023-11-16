<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	.remove {
		font-weight: bold;
		font-size: 1.2em;
		cursor: pointer;
		display: inline-block;
		width: 16px;
		height: 16px;
		text-align: center;
		line-height: 16px;
		border: 1px solid black;
		padding: 5px;
	}
	.remove:hover {
		background-color: red;
	}
</style>
</head>
<body>


<h1>파일 하나씩 여러개 첨부하기</h1>
<hr>

<form method="POST" enctype="multipart/form-data">
	<div id="files">
		<p><input type="file" name="uploadFiles[0]"></p>
	</div>
	<p>
		<input id="addBtn" type="button" value="첨부 파일 추가">
		<input type="submit" value="제출">
	</p>
</form>

<script>
	const files = document.getElementById('files')
	const addBtn = document.getElementById('addBtn')
	const form = document.forms[0]
	
	function removeHandler(event) {
		const target = event.target.parentNode
		files.removeChild(target)
		
		form.querySelectorAll('input[type="file"]').forEach((e, i) => e.name = 'uploadFiles[' + i + ']')
	}
	
	function addHandler() {
		const size = document.querySelectorAll('input[type="file"]').length
		
		const input = document.createElement('input')
		input.type = 'file'
		input.name = 'uploadFiles[' + size + ']'
		
		const span = document.createElement('span')
		span.className = 'remove'
		span.innerText = 'X'
		span.onclick = removeHandler
		
		const p = document.createElement('p')
		p.appendChild(input)
		p.appendChild(span)
		files.appendChild(p)
		
	}
	function submitHandler(event) {
		
	}
	
	addBtn.onclick = addHandler
	form.onsubmit = submitHandler
	
	
</script>

</body>
</html>