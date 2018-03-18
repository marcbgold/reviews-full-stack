function toggleElementDisplay(element) {
	if (element) {
		element.classList.toggle('hidden');
	}
}

// show/hide nav links

const navIcon = document.querySelector('.nav-icon');
const navLinks = document.querySelector('.nav-links');
if (navIcon) {
	navIcon.addEventListener('click', function() {
		toggleElementDisplay(navLinks);
	})
}