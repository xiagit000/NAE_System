$(function(){
	
	jQuery.validator.messages.required =
		"<span class='error' generated='true' style='color: red; font-size: 12px;'>*请填写此内容</span>";
	
	jQuery.validator.messages.digits =
		"<span class='error' generated='true' style='color: red; font-size: 12px;'>*必须输入整数</span>";
	
	jQuery.validator.messages.range =
		"<span class='error' generated='true' style='color: red; font-size: 12px;'>*必须输入0到100的整数</span>";

	$("#add_form").validate({
		rules : {
			learnVideoProportion : {required : true,digits:true,range:[0,100]},
			learnThesisProportion : {required : true,digits:true,range:[0,100]},
			learnDiscussProportion : {required : true,digits:true,range:[0,100]},
			usuallyProportion : {required :true,digits:true,range:[0,100]}
		}
	});
});