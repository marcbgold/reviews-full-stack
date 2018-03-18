const xhr = new XMLHttpRequest()

const reviewIdElement = document.querySelector('#review-id')
const currentReviewId = reviewIdElement.value

// delete tag button

const tagDeleteButtonList = document.querySelectorAll('.tag-delete-x')
tagDeleteButtonList.forEach(function(xButton) {
	addTagDeleteListener(xButton)
})

function addTagDeleteListener(element) {
	element.addEventListener('click', function() {
		const currentTagId = element.nextElementSibling.value
		const deleteRequestUrl = 'http://localhost:8080/review/' + currentReviewId + '/tag/' + currentTagId + '/deletetag'

		xhr.open('DELETE', deleteRequestUrl, true)
		xhr.send()

		xhr.onreadystatechange = function() {
			if (this.readyState === 4 && this.status === 200) {
				element.parentNode.remove();	
			}
		}
	})
}

// add tag form

const tagAddButton = document.querySelector('.tag-add-button')
tagAddButton.addEventListener('click', function() {
	const tagName = document.querySelector('#tagName').value
	const tagDescription = document.querySelector('#tagDescription').value

	if (tagName && tagDescription) {
		const addRequestUrl = 'http://localhost:8080/review/' + currentReviewId + '/addtag/' + tagName + '/' + tagDescription
		xhr.open('PUT', addRequestUrl, true)
		xhr.send()
	} else {
		alert("Please enter both a tag name and a description.")
	}

	xhr.onreadystatechange = function() {
		if (this.readyState === 4 && this.status === 200) {
			if (xhr.response) {
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
				addTagDeleteListener(newXButton)
			} else {
				alert("A tag with that name already exists in this review.")
			}
		}
	}
})