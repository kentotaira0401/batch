
$(function(){
	 calc();
	
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
    	
    	var priceM = $('#mPrice').val(); // Mサイズの価格
    	console.log("Mサイズ価格" + priceM);
    	
    	var priceL = $('#lPrice').val(); // Lサイズの価格
    	console.log("Lサイズ価格" + priceL);
    	
    	var str = $('.size:checked').val(); // サイズ
    	var cnt = $('.toppingList:checkbox:checked').length;　// トッピングの個数
    	var quantity = $('.form-control option:selected').val(); // 枚数
    	console.log("サイズ" + str + "トッピング" + cnt + "枚数" + quantity);
    	
    	
    	var totalPrice = 0;
    	var toppingPrice = 0;
    	
    	if(str == "M"){ 　　　// Mサイズを選択した際の価格
    		var toppingPriceM = (200 * cnt);
    		 totalPrice	= (Number(priceM) + Number(toppingPriceM)) * quantity;
        	console.log("合計：" + totalPrice);
        	
    	}else if(str == "L"){　　// Lサイズを選択した際の価格
    		var toppingPriceL = (300 * cnt);
    		totalPrice = (Number(priceL) + Number(toppingPriceL)) * quantity;
        	console.log("合計：" + totalPrice);
    	}
    	
    	$("#totalPrice").text(totalPrice.toLocaleString()); 
    };   
   

});


