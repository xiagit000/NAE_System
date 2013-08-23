<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="r" tagdir="/WEB-INF/tags/r"%>

<r:javascript name="/resources/js/learnproject/add.js"></r:javascript>
<r:layout title="培训项目 | 编辑培训项目">
<jsp:include page="../layout/administrator_navbar.jsp" />
<div class="wrapper">
	<ul class="breadcrumb">
		<li><r:a href="/">首页</r:a> <span class="divider">/</span></li>
		<li><r:a href="/learnproject">项目列表</r:a> <span class="divider">/</span></li>
		<li class="active">编辑培训项目"${learnProject.name}"</li>
	</ul>

	<form id="add_form" action="<c:url value='/learnproject/${learnProject.id}' />"
		method="post">
	<input type="hidden" name="id" value="${learnProject.id}" /> 
	<input type="hidden" name="_method" value="put" />

	<table class="table">
		<tbody>
			
			<tr>
				<th colspan="2">培训项目批次</th>
			</tr>
			<tr>
				<td width=100>
					<select name="batchId" >
						<c:forEach items="${batchList}" var="batch">
							<option value='${batch.id}' <c:if test="${batch.id eq learnProject.batch.id}">selected = "selected"</c:if> >${batch.name}</option>
						</c:forEach>
						
					</select>
				</td>
				
			</tr>
			
			<tr>
				<th colspan="2">培训项目名称</th>
			</tr>
			<tr>
				<td width=100><input type="text" name="name"
					value="${learnProject.name}" placeholder="请输入培训项目名称"></td>
				<td><label for="name" class="error" generated="true"
					style="color: red; font-size: 12px;"></label></td>
			</tr>
			
			<tr>
				<th colspan="2">培训项目代码</th>
			</tr>
			<tr>
				<td width=100><input type="text" name="code" value="${learnProject.code}" placeholder="请输入培训项目代码"></td>
				<td><label for="code" class="error" generated="true" style="color: red; font-size: 12px;"></label></td>
			</tr>
			
			<tr>
				<th colspan="2">培训项目描述</th>
			</tr>
			<tr>
				<td colspan="2">
				<textarea rows="10" cols="100" name="description">${learnProject.description}</textarea></td>
			</tr>
			
			<tr>
				<td colspan="2">
				<button type="submit" class="button">更新</button>
				<r:a href="/learnproject" class="button">取消</r:a></td>
			</tr>
		</tbody>
	</table>
	</form>
</div>
</r:layout>