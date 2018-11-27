1	$(function(){
2	    
2		    $('.size').change(function(){
3		//        var str = $('[name="size"]:checked').val();
4		        var str = $('.size:checked').val();
5		        console.log(str);
4	        calc();
5	    //    var str = $('.size:checked').val();
6	    //    console.log(str);
6		    });
8	    
9	    $('.toppingList').change(function() {
10	        calc();
11+	    //        var cnt = $('.toppingList:checkbox:checked').length;
12	     //       console.log(cnt);
13	    });
14	    
15	    $('.form-control').change(function() {
16	        calc();
17	  //      var quantity = $(this).val();
18	  //     console.log(quantity);
19	    });
20	
21	    function calc() {
22	        var str = $('.size:checked').val();
23	        var cnt = $('.toppingList:checkbox:checked').length;
24	        var quantity = $('.form-control option:selected').val();
25	        console.log("サイズ："+ str);
26	        console.log("トッピング："+ cnt);
27	        console.log("枚数："+ quantity);
28	          return "done";
29	        };
7	30	});
8	31	
9	32	

