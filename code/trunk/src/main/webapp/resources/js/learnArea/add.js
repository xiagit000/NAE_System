$(function(){
	jQuery.validator.messages.required =
		"<span class='error' generated='true' style='color: red; font-size: 12px;'>*请填写此内容</span>";

	initCities();
	
	$("#city").change(function(){
		$("#name").val($("#province").find("option:selected").text()+$("#city").find("option:selected").text());
		$("#elCode").val($("#city").val());
	});
	
	
	$("#province").change(function(){
		initCities();
	});
	
	$("#add_form").validate({
		rules : {
			personIncharge : {required : true},
			code : {required : true},
			tel : {required : true},
			email : {required : true},
			zipCode : {required : true}
		}
	});
});

function initCities(){
	var selectedValue=$("#province").children('option:selected').val();
	var url=contextPath+"/city/changecity";
	$.post(url,{elcode:selectedValue},function(result){
		$("#city").find("option").remove();
		if(result.length>0){
			for(var i=0;i<result.length;i++){
				$("#city").append("<option value='"+result[i].elCode+"'>"+result[i].name+"</option>");
				$("#name").val($("#province").find("option:selected").text()+$("#city").find("option:selected").text());
				$("#elCode").val($("#city").val());
			}
		}
	});
}
