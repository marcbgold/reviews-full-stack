//const xhr = new XMLHttpRequest()
//xhr.onreadystatechange = function() {
//	if (this.readyState === 4 && this.status === 200) {
//		const res = JSON.parse(xhr.response);
//		const body = document.body;
//
//		const courseContainer = document.createElement('div')
//		courseContainer.classList.add('courseContainer')
//
//		const courseTitle = createElement('h2', res[0].name)
//		const courseDescription = createElement('p', res[0].description)
//		const courseInstructor = createElement('h3', res[0].instructor.name)
//
//		appendElement(courseContainer, courseTitle)
//		appendElement(courseContainer, courseDescription)
//		appendElement(courseContainer, courseInstructor)
//
//		appendElement(body, courseContainer)
//
//		function createElement(elem, textValue) {
//			const newElem = document.createElement(elem)
//			newElem.innerText = textValue
//			return newElem
//		}
//
//		function appendElement(parent, child) {
//			parent.appendChild(child)
//		}
//	}
//}
//
//xhr.open('PUT', 'http://localhost:8080/show-courses', true)
//xhr.send()