$(function() {
	//ユーザー登録用の住所自動出力
	$('#btn').click(function() {
		AjaxZip3.zip2addr('zipcode', '', 'address', 'address');
	});
	
	//注文用の住所自動出力
	$('#btn2').click(function() {
		AjaxZip3.zip2addr('destinationZipcode', '', 'destinationAddress', 'destinationAddress');
	});
});