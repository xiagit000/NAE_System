<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="r" tagdir="/WEB-INF/tags/r" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>  

<r:javascript name="/resources/js/portal/backstage/withiamge/validate.js"></r:javascript>

<r:layout title="添加教师风采信息" >
<jsp:include page="../../../layout/administrator_navbar.jsp" />
		<div class="wrapper">
			 <ul class="breadcrumb">
	              <li><r:a href="/">首页</r:a> <span class="divider">/</span></li>
	              <li><r:a href="/portalinfo/backstage/teachershow">教师风采信息列表</r:a> <span class="divider">/</span></li>
	              <li class="active">添加教师风采信息</li>
          	</ul>
          	<form id="add_form" action="<c:url value='/portalinfo/backstage/teachershow' />" method="POST"  enctype="multipart/form-data">
          	    <table class="table">
		         	<tbody>
		         		<tr>
		         			<td><b>教师姓名</b></td>
		         			<td><label for="title" class="error" generated="true" style="color:red;font-size:12px;"></label></td>
		         		</tr>
		         		<tr>
		         			<td colspan="2"><input name="title"/></td>
		         		</tr>
		         		<tr>
		         			<td><b>教师图片</b></td>
		         			<td><label for="file" class="error" generated="true" style="color:red;font-size:12px;"></label></td>
		         		</tr>
		         		<tr>
		         			<td colspan="2"><input type="file" name="file"/></td>
		         		</tr>
		         		<tr>
		         			<td><b>教师介绍(可以直接黏贴包含图片表格等元素的内容)</b></td>
		         			<td><label for="content" class="error" generated="true" style="color:red;font-size:12px;"></label></td>
		         		</tr>
		         	<tr>
		         		<td colspan="2"><textarea cols="100" rows="10" name="content">${announcement.details }</textarea>
							<script>CKEDITOR.replace( 'content' );</script>
						</td>
		         	</tr>	
		         	<tr>
		         		<td colspan="2">
		         			<input type="submit" class="button" value="提交"/>
	        				<r:a href="/portalinfo/backstage/teachershow" class="button">取消</r:a>
		         		</td></tr>
		         	</tbody>
		         </table>
		
        	 </form>
		</div>
		 
		
</r:layout>