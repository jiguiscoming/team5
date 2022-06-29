
// 일부만 포함되게 해주는 함수 (selectAll에서 사용)
var findAll = (function() {

    function parse(id, element, accumulator) {
        var children = element.children;
        for (var i = 0; i < children.length; i++) {
            var child = children[i];
            parse(id, child, accumulator);
        }

        if (element.id && element.id.indexOf(id) !== -1) {
            accumulator.push(element);
        }
    }

    return function findAll(id) {
        var acc = [];
        parse(id, document, acc);

        return {
            forEach: function forEach(fnc) {
                if (Object.prototype.toString.call(fnc) !== "[object Function]") {
                    throw new Error("Function required");
                }

                for (var i = 0; i < acc.length; i++) {
                    fnc(acc[i]);
                }
            }
        };
    }

})();

// 전체 선택
/*function selectAll(selectAll)  {
 /* const checkboxes 
       = document.getElementsByName('agree');
  
  checkboxes.forEach((checkbox) => {
    checkbox.checked = selectAll.checked;
  })*/
  /* 이 밑에꺼가 진짜 코드
 
  findAll("agree").forEach(function(checkbox) {
   checkbox.checked = selectAll.checked;
   
});



}

*/
// true 일 경우 O으로 false일 경우 X으로 보내는 함수
function is_checked() {
if(document.getElementById("agree1").checked) {
    document.getElementById("agree1_hidden").disabled = true;
}

if(document.getElementById("agree2").checked) {
    document.getElementById("agree2_hidden").disabled = true;
}

if(document.getElementById("agree3").checked) {
    document.getElementById("agree3_hidden").disabled = true;
}

if(document.getElementById("agree4").checked) {
    document.getElementById("agree4_hidden").disabled = true;
}


}

// 체크되지 않았을 경우 alert
function is_unchecked(){
	
	const checkbox = document.getElementById('');
	
	const is_checked = checkbox.checked;
	

	
}
 /*
 // 모두 체크되었을 경우 hidden 의 체크 해제
 function all_unchecking(){
 
 
 if(document.getElementById("agree1").checked||document.getElementById("agree2").checked||document.getElementById("agree3").checked||document.getElementById("agree4").checked){
 
   document.getElementById("agree1_hidden").disabled = false;
   document.getElementById("agree2_hidden").disabled = false;
   document.getElementById("agree3.hidden").disabled = false;
   document.getElementById("agree4_hidden").disabled = false;
}
}*/