$(function() {
	jQuery.validator.messages.required = "*请填写此项内容";
	jQuery.validator.messages.dateISO = "*请填写正确的日期";

	$("#add_form").validate({
		rules : {
			title : {required : true},
			content : {required : true},
			beginTime : {required : true,
						 dateISO : true},
			submitTime : {required : true,
						  dateISO : true}
		}
	});
});