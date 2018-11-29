$(window).load(function() {
	var img = $("#slideshow").children("img"),
		num = img.length, 
		count = 0, 
		interval = 5000; 
	
	img.eq(0).addClass("show"); 
	
	setTimeout(slide, interval); 
	
	function slide() {
		img.eq(count).removeClass("show"); 
		count++; 
		if(count >= num) {
			count = 0; 
		}
		img.eq(count).addClass("show"); 
		setTimeout(slide, interval); 
	}
});
