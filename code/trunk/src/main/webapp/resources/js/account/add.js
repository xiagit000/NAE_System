$(function(){
	
	jQuery.validator.messages.required =
		"<span class='error' generated='true' style='color: red; font-size: 12px;'>*请填写此内容</span>";

	$("#add_form").validate({
		rules : {
			idNumber : {required : true},
			name : {required : true},
			sex : {required : true},
			ethnic : {required : true},
			idType : {required : true},
			school : {required : true},
			address : {required : true},
			contractAdd : {required : true},
			email : {required : true},
			tel : {required : true},
			highestEducationalBackground : {required : true},
			workPlace : {required : true},
			workYear : {required : true}
		}
	});
});
