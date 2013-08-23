<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>  
<%@ taglib prefix="r" tagdir="/WEB-INF/tags/r" %>
<r:javascript name="/resources/js/learnlevel/add.js"></r:javascript>
<r:layout title="培训层次 | 添加培训层次" >
<jsp:include page="../layout/administrator_navbar.jsp" />
<div class="wrapper">
	<ul class="breadcrumb">
		<li><r:a href="/">首页</r:a> <span class="divider">/</span></li>
		<li><r:a href="/learnlevel>">层次列表</r:a> <span class="divider">/</span></li>
		<li class="active">添加培训层次</li>
	</ul>
	
	<form id="add_form" action="<c:url value='/learnlevel' />" method="post" >
		
		<table class="table">
			<tbody>
				<tr>
					<td colspan="2">
						<span class="help-block">培训层次名称  如："国培高中"、"师培高中"......</span>
					</td>
				</tr>
				<tr>
					<td width=100 >
						<input type="text" name="name"  value="${learnLevel.name}" placeholder="请输入培训层次名称">
					</td>
					<td>
						<label for="name" class="error" generated="true" style="color:red;font-size:12px;"></label>
					</td>
				</tr>
				<tr>
					<td colspan="2">
						<label class="checkbox"> 
						<input type="checkbox" <c:if test="${learnLevel.active}">checked="checked"</c:if> name="active" /> 是否马上启用
						</label>
					</td>
				</tr>
				<tr>
					<td colspan="2"><button type="submit" class="button">添加</button> <r:a href="/learnlevel" class="button">取消</r:a></td>
				</tr>
			</tbody>
		</table>
	</form>
</div>
	
</r:layout>