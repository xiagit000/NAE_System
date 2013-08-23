$(function() {
	jQuery.validator.messages.required = "*请填写此项内容";
	jQuery.validator.messages.number="*请填写正确的数字";

	$("#add_form").validate({
		rules : {
			name : {required : true},
			code : {required : true},
			studyTimeCount : {
					required : true,
					number : true
			}
		}
	});
});

