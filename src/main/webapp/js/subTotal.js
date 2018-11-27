
$(function(){
	$('.size').change(function(){
//		var str = $('[name="size"]:checked').val();
		var str = $('.size:checked').val();
		console.log(str);
	});
});



//$(function(){
//	
//	$('input[name=size]').on("click",function(){
//			
//			var sizePrice;
//			
//			
//			if($('size').val() == "M"){
//				sizePrice=$('item.priceM').val();
//				console.log(sizePrice);
//			}else if($('size').val() == "L"){
//				sizePrice=$('item.priceL').val();
//				console.log(sizePrice);
//			}
//});
//
//	$("#get_button").click( function() {
//	    var radioVal = $("input[name='size']:checked").val();
//	    console.log(radioVal);
//	});
//	
//});


