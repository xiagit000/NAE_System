<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>  
<%@ taglib prefix="r" tagdir="/WEB-INF/tags/r" %>

<r:layout title="发布项目辅导资料" >

<r:javascript name="/resources/js/role/learnresourcevalidator.js"></r:javascript>
<jsp:include page="../../layout/project_navbar.jsp" />
<div class="wrapper">
	<ul class="breadcrumb">
		<li><r:a href="/">首页</r:a> <span class="divider">/</span></li>
		<li><r:a href="/learnresource/projectresources">项目辅导资料列表</r:a> <span class="divider">/</span></li>
		<li class="active">发布项目辅助资料</li>
	</ul>
	<form id="add_form" action="<c:url value='/learnresource' />" method="post" enctype="multipart/form-data">
	<table class="table">
			<tbody>
				<tr>
					<td colspan="2"><b>辅助资料简介：</b>
					<input style="width: 400px;" name="title" value="${announcement.name }" /><label for="title" class="error" generated="true" style="color:red;font-size:12px;"></label></td>
				</tr>
				<tr>
					<td colspan="2"><b>添加附件：</b><input type="file" name="file" /></td>
				</tr>
				<tr>
					<td><input type="submit" class="button" value="提交" />  </td>
				</tr>
			</tbody>
		</table>
	</form>
</div>
</r:layout>