var sell_price;
var amount;


// init 초기값을 지정할 수 있다.
function init() {
	sell_price = document.Calculation.sell_price.value;
	amount = document.Calculation.amount.value;
	document.Calculation.sum.value = sell_price;
	change();
}


// add
// howmany 값을 1 증가 시키고, 합계를 계산.
function add() {
	hm = document.Calculation.amount;
	sum = document.Calculation.sum;
	hm.value++;

	sum.value = parseInt(hm.value) * sell_price;

}





// del

// howmany 값을 1 감소 시키고, 합계를 계산.

function del() {

	hm = document.Calculation.amount;

	sum = document.Calculation.sum;



	// 에러 처리 : 음수 값

	if (hm.value > 1) {

		hm.value--;

		sum.value = parseInt(hm.value) * sell_price;

	}

}





function change() {



	hm = document.Calculation.amount;

	sum = document.Calculation.sum;



	if (hm.value < 0) {

		hm.value = 0;

	}

	sum.value = parseInt(hm.value) * sell_price;

} 
