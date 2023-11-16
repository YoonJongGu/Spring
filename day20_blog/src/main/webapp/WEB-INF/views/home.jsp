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
	body {
		overflow: hidden;
	}
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
	
	details[open] {
		border: 2px solid black;
		padding: 5px;
	}
	
	#list {
		overflow-y: scroll;
		overflow-x: hidden;
		width: 700px;
		height: 500px;
		margin: auto;
		border: 1px solid black;
	}
	#list::-webkit-scrollbar {
/* 		display: none; */
	}
	#list > .item {
		padding: 5px;
		margin: 10px auto;
		border: 1px solid grey;
		width: 500px;
		text-align: center;
	}
	#list > .item > img {
		cursor: pointer;
	}
	
	#modal {
		
	}
	
	#modal_overlay {
		z-index: 1;
		position: absolute;
		top: 0;
		left: 0;
		width: 100%;
		height: 100vh;
		background-color: rgba(0, 0, 0, 0.6);
	}
	#modal_content {
		overflow: hidden;
		position: absolute;
		top: 50%;
	    left: 50%;
	    transform: translate(-50%, -50%);
		width: 700px;
		height: 500px;
		margin: auto;
		background-color: white;
		box-shadow: 10px 10px 10px black;
		border-radius: 10px;
		z-index: 5;
	}
	.hidden {
		display: none;
	}
	#slider {
		width: 100%;
		height: 500px;
		overflow: hidden;
	}
	#slider_window {
		position: absolute;
		height: 500px;
		display: flex;
		transition-duration: 0.5s;
	}
	#slider_window > div.img {
		position: relative;
		top: 0;
		width: 700px;
		height: 500px;
		flex: 1;
		display: flex;
		justify-content: center;
		align-items: center;
		background-size: auto 100%;
		background-position: center center;
		background-repeat: no-repeat;
	}
	
	#slider_control {
		position: absolute;
		top: 0;
		width: 100%;
	}
	#slider_control > div {
		position: absolute;
		top: 230px;
		width: 40px;
		height: 40px;
		z-index: 10;
		cursor: pointer;
		background-color: #dadada;
		border-radius: 50%;
	}
	#slider_control > .left {
		left: 20px;
	}	
	#slider_control > .right {
		right: 20px;
	}
	#modal > .prev,
	#modal > .next {
		position: absolute;
		z-index: 5;
		width: 50px;
		height: 50px;
		background-color: #f5f6f7;
		border-radius: 50%;
		cursor: pointer;
		top: 48%;
	}
	#modal > .prev {
		left: 10px;
	}
	#modal > .next {
		right: 10px;
	}
	
</style>
</head>
<body>


<h1>파일 하나씩 여러개 첨부하기</h1>
<hr>

<details>
	<summary><b>파일 업로드 DB</b></summary>
	<pre>
drop sequence blog_seq;
drop sequence uploadImage_seq;
drop table blog;
drop table uploadImage;
	
create sequence blog_seq
	start with 1
	maxvalue 9999999
	increment by 1
	nocache
	nocycle;

create sequence uploadImage_seq
	start with 1
	maxvalue 9999999
	increment by 1
	nocache
	nocycle;
	
create table blog (
	idx			number			default blog_seq.nextval primary key,
	text		varchar2(4000)	not null
);
	
create table uploadImage (
	idx			number			default uploadImage_seq.nextval primary key,
	blog_idx	number			not null,
	oldName	    varchar2(255)	not null,
    newName	    varchar2(255)	not null,
	
	constraint uploadImage_blog_fk foreign key(blog_idx)
	references blog(idx) on delete cascade
);
	</pre>
</details>

<div id="modal" class="hidden">
	<div class="prev"><img src="${cpath }/resources/prev.png" height="50"></div>
	<div class="next"><img src="${cpath }/resources/next.png" height="50"></div>
	<div id="modal_content">
		<div id="slider">
			<div id="slider_control">
				<div class="left"><img src="${cpath }/resources/prev.png" height="40"></div>
				<div class="right"><img src="${cpath }/resources/next.png" height="40"></div>
			</div>
			<div id="slider_window"></div>
		</div>
	</div>
	<div id="modal_overlay"></div>
</div>

<form method="POST" enctype="multipart/form-data">
	<p>
		<textarea name="text" placeholder="내용 입력"></textarea>
	</p>
	<div id="files">
		<p><input type="file" name="uploadFiles[0]"></p>
	</div>
	<p>
		<input id="addBtn" type="button" value="첨부 파일 추가">
		<input type="submit" value="제출">
	</p>
</form>

<div id="list"></div>

<script>
	const files = document.getElementById('files')
	const addBtn = document.getElementById('addBtn')
	const form = document.forms[0]
	const left = document.querySelector('.left')
	const right = document.querySelector('.right')
	const slider_window = document.getElementById('slider_window')
	const slider = document.getElementById('slider')
	const overlay = document.getElementById('modal_overlay')
	const prev = document.querySelector('#modal > .prev > img')
	const next = document.querySelector('#modal > .next > img')
	
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
	function openModal(event) {
		const idx = event.target.parentNode.getAttribute('idx')
		document.getElementById('modal').classList.remove('hidden')
		slider.setAttribute('idx', idx)
		loadModal(idx)
	}
	function loadModal(idx) {
		const url = '${cpath}/getImages/' + idx
		fetch(url)
		.then(resp => resp.json())
		.then(json => {
			console.log(json)
			if(json == 0) {
				console.log('empty data')
				return
			}
			
			slider_window.style.width = json.length * 700 + 'px'
			slider_window.innerHTML = ''
			json.forEach(e => {
				const div = document.createElement('div')
				div.className = 'img'
				div.style.backgroundImage = "url('${cpath}/upload/" + e + "')"
				slider_window.appendChild(div)
			})
			slider_window.setAttribute('idx', 0)
			slider_window.style.left = '0px'
			slider_window.style.transitionDuration = '0.5s'
		})
	}
	function closeModal() {
		document.getElementById('modal').classList.add('hidden')
		slider_window.style.transitionDuration = ''
	}
	function getBlog() {
		const list = document.getElementById('list')
		const offset = list.querySelectorAll('.item').length
		const url = '${cpath}/getBlog/' + offset
		
		fetch(url)
		.then(resp => resp.json())
		.then(json => {
			console.log(json)
			
			json.forEach(e => {
				let tag = '<div class="item" idx="' + e.IDX+ '">'
				tag += '<div class="text">' + e.TEXT + '</div>' 
				tag += '<img src="${cpath}/upload/' + e.THUMBNAIL + '" height="150">' 
				tag += '</div>'
				list.innerHTML += tag
			})
			
			list.querySelectorAll('.item img').forEach(e => e.onclick = openModal)
		})
	}
	function leftHandler() {
		const slider_window = document.getElementById('slider_window')
		const length = +slider_window.querySelectorAll('div.img').length
		const idx = +slider_window.getAttribute('idx')
		if(idx > 0) {
			slider_window.setAttribute('idx', idx - 1)
			slider_window.style.left = (+slider_window.style.left.replace('px', '') + 700) + 'px' 
		}
	}
	function rightHandler() {
		const slider_window = document.getElementById('slider_window')
		const length = +slider_window.querySelectorAll('div.img').length
		const idx = +slider_window.getAttribute('idx')
		console.log(idx, length)
		if(idx < length - 1) {
			slider_window.setAttribute('idx', idx + 1)
			slider_window.style.left = (+slider_window.style.left.replace('px', '') - 700) + 'px' 
		}
	}
	function scrollHandler(event) {
		const ob = {
			st : event.target.scrollTop,
			sh : event.target.scrollHeight,
			ch : event.target.clientHeight
		}
		if(ob.st + ob.ch > ob.sh * 0.98) {
			getBlog()
		}
	}
	function prevHandler() {
		const idx = +slider.getAttribute('idx')
		slider.setAttribute('idx', idx + 1)
		loadModal(idx + 1)
	}
	function nextHandler() {
		const idx = +slider.getAttribute('idx')
		slider.setAttribute('idx', idx - 1)
		loadModal(idx - 1)
	}
	addBtn.onclick = addHandler
	window.onload = getBlog
	right.onclick = rightHandler
	left.onclick = leftHandler
	overlay.onclick = closeModal
	list.onscroll = scrollHandler
	prev.onclick = prevHandler 
	next.onclick = nextHandler 
	
	
</script>

</body>
</html>