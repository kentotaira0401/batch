
$(function(){
	
	$('.size').change(function(){
		calc();
	//	var str = $('.size:checked').val();
	//	console.log(str);
	});
	
	$('.toppingList').change(function() {
		calc();
	//        var cnt = $('.toppingList:checkbox:checked').length;
	 //       console.log(cnt);
	});
	
    $('.form-control').change(function() {
    	calc();
  //      var quantity = $(this).val();
  //     console.log(quantity);
    });

    function calc() {
    	var str = $('.size:checked').val();
    	var cnt = $('.toppingList:checkbox:checked').length;
    	var quantity = $('.form-control option:selected').val();
    	console.log("サイズ："+ str);
    	console.log("トッピング："+ cnt);
    	console.log("枚数："+ quantity);
    	  return "done";
    	};
});



	
	
	
	
	






