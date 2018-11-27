
$(function(){
	
	$('.size').change(function(){
		calc();
	});
	
	$('.toppingList').change(function() {
		calc();
	});
	
    $('.form-control').change(function() {
    	calc();
    });

    function calc() {
    	
    	var priceM = $('#mPrice').val();
    	console.log("Mサイズ価格" + priceM);
    	
    	var priceL = $('#lPrice').val();
    	console.log("Lサイズ価格" + priceL);
    	
    	var str = $('.size:checked').val();
    	var cnt = $('.toppingList:checkbox:checked').length;
    	var quantity = $('.form-control option:selected').val();
    	console.log("サイズ" + str + "トッピング" + cnt + "枚数" + quantity);
    	
    	
    	
    	var totalPrice = 0;
    	var toppingPrice = 0;
    	
    	if(str == "M"){
    		toppingPriceM = (200 * cnt);
    		totalPrice	= (Number(priceM) + Number(toppingPriceM)) * quantity;
        	console.log("合計：" + totalPrice);
        	
    	}else if(str == "L"){
    		toppingPriceL = (300 * cnt);
    		totalPrice = (Number(priceL) + Number(toppingPriceL)) * quantity;
        	console.log("合計：" + totalPrice);
    	}
    	$("#totalPrice").text(totalPrice.toLocaleString()); 
    };
    	
});



	
	
	
	
	






