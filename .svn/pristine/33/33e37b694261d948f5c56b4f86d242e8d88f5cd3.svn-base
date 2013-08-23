$(function() {
	jQuery.validator.messages.required = "*请填写此项内容";
	jQuery.validator.messages.equalTo = "*两次密码输入不一致"
	$("#add_form").validate({
		rules : {
			loginName:{required:true},
			password :{required:true},
			passwordAgain:{required:true,
							equalTo:"#pwd"},
			realName:{required:true}
		}
	});
});

