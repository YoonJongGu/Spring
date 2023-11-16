function deleteHandler(event) {
	
	const replyWriter = event.target.parentNode.parentNode.querySelector('.writer')
	console.log(login_userid, replyWriter.innerText)	// 현재 로그인한 사용자, 댓글 작성자
	
	if(login_userid != replyWriter.innerText) {
		alert('본인이 작성한 댓글만 삭제할 수 있습니다')
		return
	}
	else {
		const flag = confirm('정말 삭제하시겠습니까?')
		if(flag) {
			// 삭제하는 내용을 fetch로 전송 (댓글idx)
			const idx = replyWriter.parentNode.parentNode.parentNode.getAttribute('idx')
//			console.log(idx)
			const url = `${cpath}/board/reply/${board_idx}/${idx}`	
			const opt = {
				method: 'DELETE'				
			}
			fetch(url, opt)	// 쿼리 수행 후 then을 이용하여 댓글 삭제된 형태로 새로 만들기
		}
	}
}

async function replyLoadHandler() {
	const replyDiv = document.getElementById('reply')	
	const url = cpath + '/board/reply/' + board_idx
	
	// 특정 작업이 끝난 이후 진행을 하고 싶다면...await
	// await는 async 함수 안에서만 가능
	
	await fetch(url)
	.then(resp => resp.json())
	.then(json => {
// 		console.log(json)

		const arr = json.map(item => {
			return {'idx': item.idx, 'writer': item.writer, 'content': item.content, 'writeDate': item.writeDate}
		})
		
		console.log(arr)
		replyDiv.innerHTML = ''
		
		arr.forEach(dto => {
			const html = convertHTMLfromJSON(dto)
			replyDiv.innerHTML += html
		})
// 		arr.forEach(e => {
// 			const reply_item = document.createElement('div')
// 			reply_item.classList.add('item')
			
// 			const reply_head = document.createElement('div')
// 			reply_head.classList.add('head')
			
// 			const reply_idx = document.createElement('div')
// 			reply_idx.classList.add('idx')
// 			reply_idx.innerText = '댓글 번호 : ' + e.idx
			
// 			const reply_date = document.createElement('div')
// 			reply_date.classList.add('date')			
// 			reply_date.innerText = yyyyMMdd(e.writeDate)
			
// 			const reply_writer = document.createElement('div')
// 			reply_writer.classList.add('writer')
// 			reply_writer.innerText = '작성자 : ' + e.writer
			
// 			const reply_content = document.createElement('div')
// 			reply_content.classList.add('content')
// 			reply_content.innerText = '내용 : ' + e.content
			
// 			reply_head.appendChild(reply_idx)
// 			reply_head.appendChild(reply_date)
// 			reply_item.appendChild(reply_head)
// 			reply_item.appendChild(reply_writer)
// 			reply_item.appendChild(reply_content)
// 			replyDiv.appendChild(reply_item)
// 		})
		
	})
	
	const deleteBtnList = document.querySelectorAll('button.delete')
//	console.log(deleteBtnList)
	deleteBtnList.forEach(btn => btn.onclick = deleteHandler)
}

function convertHTMLfromJSON(dto) {
	// JSON 객체를 받아서
	// HTML 태그형식으로 문자열을 반환해야 한다
	
	let html = `<div class="reply" idx="${dto.idx}">`
	html += `		<div class="replyTop">`
	html += `			<div class="left">`
	html += `				<div class="writer">${dto.writer}</div>`
	html += `				<div class="writeDate">${getYYYYMMDD(dto.writeDate)}</div>`
	html += `			</div>`
	html += `			<div class="right">`
	html += `				<button class="modify">수정</button>`
	html += `				<button class="delete">삭제</button>`
	html += `			</div>`
	html += `		</div>`
	html += `		<pre class="content">${dto.content}</pre>`
	html += `	</div>`
	return html
}

function getYYYYMMDD(date) {
	const newDate = new Date(date)
	const yyyy = newDate.getFullYear()
	let mm = newDate.getMonth() + 1
	let dd = newDate.getDate()		
	
	mm = mm < 10 ? '0' + mm : mm
	dd = dd < 10 ? '0' + dd : dd	
	
	return `${yyyy}-${mm}-${dd}`
}

function replyWriteHandler(event) {
	event.preventDefault()
	const content = document.querySelector('#replyWriteForm textarea')
	// 게시글 번호, 작성자, 내용
	const ob = {
		board_idx: board_idx,
		writer: login_userid,
		content: content.value
	}
//	console.log(ob)
	
	const url = cpath + '/board/reply/' + board_idx
	const opt = {
		method: 'POST',
		body: JSON.stringify(ob),
		headers: {
			'Content-Type': 'application/json; charset=utf-8'
		}
	}
	fetch(url, opt)
	.then(resp => resp.text())
	.then(text => {
		if(text == 1) {
			alert('작성 성공 !!')
			replyLoadHandler()	// 댓글 작성 이후 댓글 목록을 다시 불러온다
			content.value = ''
		}
	})
}
