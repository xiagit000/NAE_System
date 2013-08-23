$(function() {
	
	checkChecked();
	
	jQuery.validator.messages.required =
		"<span class='error' generated='true' style='color: red; font-size: 12px;'>*请填写此内容</span>";

	$("#add_form").validate({
		rules : {
			name : {required : true},
			code : {required : true},
			beginTime : {required : true,dateISO:true},
			endTime : {required : true,dateISO:true}
		}
	});
	
	$("#pay").change(function(){
		checkChecked();
	});
});


function checkChecked(){
	if($("#pay").attr("checked")){
		$("#expense").removeAttr("disabled");
		}else{
		$("#expense").attr("disabled","disabled");
		$("#expense").val("0");
		}
}