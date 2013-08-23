$(function() {
	jQuery.validator.messages.required = "*请填写此项内容";
	$("#add_form").validate({
		rules : {
			title:{required:true},
			file:{required:true}
		}
	});
});
