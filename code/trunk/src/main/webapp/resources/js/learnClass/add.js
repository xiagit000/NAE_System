$(function(){
	
	jQuery.validator.messages.required =
		"<span class='error' generated='true' style='color: red; font-size: 12px;'>*请填写此内容</span>";

	$("#add_form").validate({
		rules : {
			name : {required : true},
			allName : {required : true},
			code : {required : true},
			tel : {required : true},
			zipCode : {required : true},
			areaCode : {required : true},
		}
	});
});
