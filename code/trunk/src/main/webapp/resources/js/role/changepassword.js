$(function() {
	jQuery.validator.messages.required = "*请填写此项内容";
	jQuery.validator.messages.equalTo = "*两次密码输入不一致";
	$("#add_form").validate({
		rules : {
			oldPassword:{required:true},
			newpassword :{required:true},
			newpasswordAgain:{required:true,
							equalTo:"#pwd"}
		}
	});
});
