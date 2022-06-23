
function setThumbnail(event) {
	var reader = new FileReader();

	reader.onload = function(event) {
		var img = document.createElement("img");
		img.setAttribute("src", event.target.result);
		img.setAttribute("class", "col-lg-6");
		document.querySelector("div#image_container").appendChild(img);
	};

	reader.readAsDataURL(event.target.files[0]);
}

function setThumbnail(event) {
	var reader = new FileReader();

	reader.onload = function(event) {
		var img = document.createElement("img");
		img.setAttribute("src", event.target.result);
		img.setAttribute("class", "col-lg-6");
		document.querySelector("div#image_container").appendChild(img);
	};

	reader.readAsDataURL(event.target.files[0]);
}


/*
const items = document.querySelectorAll('.question');
function openCloseAnswer() {
	const answerId = this.id.replace('que', 'ans');

	if (document.getElementById(answerId).style.display === 'block') {
		document.getElementById(answerId).style.display = 'none';
		document.getElementById(this.id + '-toggle').textContent = '+';
	} else {
		document.getElementById(answerId).style.display = 'block';
		document.getElementById(this.id + '-toggle').textContent = '-';
	}
}
items.forEach(item => item.addEventListener('click', openCloseAnswer));
*/

