<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="r" tagdir="/WEB-INF/tags/r" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>  

<r:javascript name="/resources/js/portal/backstage/withoutimage/validate.js"></r:javascript>

<r:layout title="修改教师风采信息" >
<jsp:include page="../../../layout/administrator_navbar.jsp" />
		<div class="wrapper">
			 <ul class="breadcrumb">
	              <li><r:a href="/">首页</r:a> <span class="divider">/</span></li>
	              <li><r:a href="/portalinfo/backstage/teachershow">教师风采信息列表</r:a> <span class="divider">/</span></li>
	              <li class="active">修改教师风采信息</li>
          	</ul>
          	<form id="add_form" action="<c:url value='/portalinfo/backstage/teachershow/${portalDefaultInformation.id}' />" method="POST"   enctype="multipart/form-data">
          		<table class="table">
		         	<tbody>
		         		<tr>
		         			<td><b>教师名称</b></td>
		         			<td><label for="title" class="error" generated="true" style="color:red;font-size:12px;"></label></td>
		         		</tr>
		         		<tr>
		         			<td colspan="2"><input name="title" value="${portalDefaultInformation.title}" /></td>
		         		</tr>
		         		<tr>
		         			<td colspan="2"><b>教师图片预览</b></td>
		         		</tr>
		         		<tr>
		         			<td colspan="2"><img style="width: 100px; height: 75px;" src="<c:url value='/upload/${portalDefaultInformation.imagePath}'/>" /></td>
		         		</tr>
		         		<tr>
		         			<td><b>新的教师图片(如果不更换，可以不选择)</b></td>
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
		         		<td colspan="2"><textarea cols="100" rows="10" name="content">${portalDefaultInformation.content }</textarea>
							<script>CKEDITOR.replace( 'content' );</script>
						</td>
		         	</tr>	
		         	<tr>
		         		<td colspan="2">
		         			<input type="submit" class="button" value="更新"/>
	        				<r:a href="/portalinfo/backstage/teachershow" class="button">取消</r:a>
		         		</td></tr>
		         	</tbody>
		         </table>
		
        	 </form>
		</div>
		 
		
</r:layout>