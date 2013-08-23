$(document).ready(function() {
	$('#learnRangeSelect').change(function() {
		var selectedValue=$(this).children('option:selected').val();
		var address=getRootPath()+"/learnplan/changelearncourse";
		$.post(address,{learnRange:selectedValue},function(result){
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


function getRootPath(){
    var curWwwPath=window.document.location.href;
    var pathName=window.document.location.pathname;
    var pos=curWwwPath.indexOf(pathName);
    var localhostPaht=curWwwPath.substring(0,pos);
    var projectName=pathName.substring(0,pathName.substr(1).indexOf('/')+1);
    return(localhostPaht+projectName);
}