$(function() {
	$("#exportExcel").click(function(){
		$("#form-search").attr("action",contextpath+"user/exportExcel");
		document.form-search.submit();
	})
	
})