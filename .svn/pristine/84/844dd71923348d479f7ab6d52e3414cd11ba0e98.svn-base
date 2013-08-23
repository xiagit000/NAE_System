$(document).ready(function() {
	$('#learnRangeSelect').change(function() {
		var selectedValue=$(this).children('option:selected').val();
		$.post("./changelearncourse",{learnRange:selectedValue},function(result){
			$("#learnCourseSelect").find("option").remove();
			if(result.length<=0){
				$("#learnCourseSelect").append("<option value='-1'>--没有可选课程--</option>");
			}else{
				for(var i=0;i<result.length;i++){
					$("#learnCourseSelect").append("<option value='"+result[i].id+"'>"+result[i].name+"</option>");
				}
				
			}
		});
		
	})
})