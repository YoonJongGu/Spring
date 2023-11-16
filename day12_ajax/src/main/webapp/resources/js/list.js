function getList() {
	const url = cpath + '/list/data'
	const opt = {
		method: 'GET'
	}
	fetch(url, opt)
	.then(resp => resp.json())
	.then(json => {
		json.forEach(data => {
			
			const item = dataToHTML(data)
			console.log(item)
			items.innerHTML += item
//			======================================================
//			const item = document.createElement('div')
//			item.classList.add('item')
//			
//			const idx = document.createElement('div')
//			idx.classList.add('idx')
//			idx.innerText = data.idx
//			
//			const userid = document.createElement('div')
//			userid.classList.add('userid')
//			userid.innerText = data.userid
//			
//			const userpw = document.createElement('div')
//			userpw.classList.add('userpw')
//			userpw.innerText = data.userpw
//			
//			const username = document.createElement('div')
//			username.classList.add('username')
//			username.innerText = data.username
//			
//			const birth = document.createElement('div')
//			birth.classList.add('birth')
//			birth.innerText = data.birth
//			
//			const gender = document.createElement('div')
//			gender.classList.add('gender')
//			gender.innerText = data.gender
//			
//			item.appendChild(idx)
//			item.appendChild(userid)
//			item.appendChild(userpw)
//			item.appendChild(username)
//			item.appendChild(birth)
//			item.appendChild(gender)
//			items.appendChild(item)
//			======================================================
		})
	})
}

function dataToHTML(data) {
	const tag = `
	<div class="item">
		<div class="idx">${data.idx}</div>
		<div class="userid">${data.userid}</div>
		<div class="userpw">${data.userpw}</div>
		<div class="username">${data.username}</div>
		<div class="birth">${data.birth}</div>
		<div class="gender">${data.gender}</div>
	</div>
	`
	return tag
}