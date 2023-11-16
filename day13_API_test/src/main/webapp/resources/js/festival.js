function makeList(item) {
	const detail = document.createElement('details')
	detail.classList.add('item')
	
	const summary = document.createElement('summary')
	const title = item.MAIN_TITLE.split('(')[0]
//	console.log(title)
	summary.innerText = title
	
	const fieldset = document.createElement('fieldset')
	for(let key in item) {
		if(item[key] != '') {
			const p = document.createElement('p')
			p.classList.add(key)
			p.innerText = item[key]
			if(key == 'MAIN_TITLE') {
				p.innerText = title			
			}			
			if(key == 'HOMEPAGE_URL') {
				p.innerText = ''
				const a = `
				<a href="${item[key]}" target="_blank">${item[key]}</a>
				`
				p.innerHTML += a
			}			
			fieldset.appendChild(p)
		}		
	}
	
	const imgNormal = fieldset.querySelector('.MAIN_IMG_NORMAL')	
	imgNormal.style.backgroundImage = 'url(' + imgNormal.innerText + ')'
	imgNormal.innerText = ''
	
	detail.appendChild(summary)
	detail.appendChild(fieldset)
	return detail
}