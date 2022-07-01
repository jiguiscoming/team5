
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



/*function idCheck(id){
	if(!id){
		alert('회원만 상품후기가 가능합니다.');
					
	}if(id){
		
		alert('안녕')
			window.open("../mealKit/mk_Review.jsp", "Review" , "width = 800 , height=1200" )
				
		
	}
}*/

function reviewQnA_delete(no ,pw){
	
	alert(no)
	alert(pw)
	window.open("mealKit/mk_Review_delete.jsp?no=" + no + "?pw=" + pw , "Review" , "width = 350 , height=350" )
	
}
