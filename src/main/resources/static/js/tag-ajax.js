const xhr = new XMLHttpRequest()

const reviewIdElement = document.querySelector('#review-id')
const currentReviewId = reviewIdElement.value

const tagDeleteButtonList = document.querySelectorAll('.tag-delete-x')
tagDeleteButtonList.forEach(function(xButton) {
	addTagDeleteListener(xButton)
})

function addTagDeleteListener(x) {
	x.addEventListener('click', function() {
		const currentTagId = x.nextElementSibling.value
		console.log('current tag id is: ' + currentTagId)
		const deleteRequestUrl = 'http://localhost:8080/review/' + currentReviewId + '/tag/' + currentTagId + '/deletetag'

		xhr.open('DELETE', deleteRequestUrl, true)
		xhr.send()

		xhr.onreadystatechange = function() {
			if (this.readyState === 4 && this.status === 200) {
				x.parentNode.remove();	
			}
		}
	})
}

const tagAddButton = document.querySelector('.tag-add-button')
tagAddButton.addEventListener('click', function() {
	const tagName = document.querySelector('#tagName').value
	const tagDescription = document.querySelector('#tagDescription').value
	const addRequestUrl = 'http://localhost:8080/review/' + currentReviewId + '/addtag/' + tagName + '/' + tagDescription

	xhr.open('PUT', addRequestUrl, true)
	xhr.send()

	xhr.onreadystatechange = function() {
		if (this.readyState === 4 && this.status === 200) {
			if (xhr.reponse !== null) {

				const res = JSON.parse(xhr.response)

				const newTag = document.createElement('span')
				newTag.classList.add('review-tag')
				newTag.innerHTML = `
					<a href="/tag/${res.id}">${res.name}</a>
					<a class="tag-delete-x"> x</a>
					<input type="hidden" value="${res.id}" />`
				const tagList = document.querySelector('.tag-list')
				tagList.appendChild(newTag)

				const newXButton = tagList.lastChild.children[1]
				console.log(newXButton)
				addTagDeleteListener(newXButton)
			}
		}
	}
})