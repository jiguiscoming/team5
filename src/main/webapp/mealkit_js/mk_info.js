
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




function mk_review_reg(id, no) {


	if (id == "") {

		alert('로그인이 필요합니다.')

	} else {
		window.open("mealKit/mk_Review.jsp?id=" + id + "&no=" + no, "Review", "width = 800 , height=1200")
	}





}


function reviewQnA_delete(no, pw) {


	window.open("mealKit/mk_Review_delete.jsp?no=" + no + "&pw=" + pw, "Review", "width = 350 , height=350")

}
