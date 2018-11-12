$(document).ready(function(){
	
	$(".boleto").hide();
    $('input[type="radio"]').click(function(){
        if($(this).attr("value")=="cartao"){
            $(".box").not(".cartao").hide();
            $(".cartao").show();
        }
        if($(this).attr("value")=="boleto"){
            $(".box").not(".boleto").hide();
            $(".boleto").show();
        }
    });
});