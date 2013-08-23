<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="r" tagdir="/WEB-INF/tags/r"%>

<r:javascript name="/resources/js/learnthesis/validator.js"></r:javascript>
<r:layout title="研修论文管理 | 编辑研修论文">
<jsp:include page="../layout/administrator_navbar.jsp" />
<div class="wrapper">
	<ul class="breadcrumb">
		<li><r:a href="/">首页</r:a> <span class="divider">/</span></li>
		<li><r:a href="/learnthesis">研修论文列表</r:a> <span class="divider">/</span></li>
		<li class="active">编辑研修论文</li>
	</ul>

	<form id="add_form" action="<c:url value='/learnthesis/${learnThesis.id}' />"
		method="post">
		
	<input type="hidden" name="_method" value="put" />
	<input type="hidden" name="id" value="${learnThesis.id }">

	<table class="table">
		<tbody>

			<tr>
				<td width="150">当前批次</td>
				<td><span style="color: red;font-weight: bold;">${currentBatch.name}[${currentBatch.code}]</span></td>
			</tr>	
			<tr>
				<th>选择校本研修大主题</th>
				<td><select name="bigSubjectId">
					<c:forEach items="${bigSubjectList}" var="bigSubject">
						<option value='${bigSubject.id}'
							<c:if test="${bigSubject.id eq learnThesis.bigSubject.id}">selected = "selected"</c:if>>${bigSubject.title}</option>
					</c:forEach>
				</select></td>
			</tr>

			<tr>
				<th colspan="2">研修论文开始时间</th>
			</tr>
			<tr> 
				<td width=100><input type="text" name="beginTime" onclick="WdatePicker()" readonly="readonly"
					value="<fmt:formatDate value="${learnThesis.beginTime}" pattern="yyyy-MM-dd"/>" placeholder="请输入研修论文开始时间"></td>
				<td><label for="beginTime" class="error" generated="true"
					style="color: red; font-size: 12px;"></label></td>
			</tr>
			
			<tr>
				<th colspan="2">研修论文结束时间</th>
			</tr>
			<tr>
				<td width=100><input type="text" name="submitTime" onblur="WdatePicker()" readonly="readonly" 
					value="<fmt:formatDate value="${learnThesis.submitTime}" pattern="yyyy-MM-dd"/>" placeholder="请输入研修论文结束时间"></td>
				<td><label for="submitTime" class="error" generated="true"
					style="color: red; font-size: 12px;"></label></td>
			</tr>
	
			<tr>
				<th colspan="2">研修论文题干</th>
			</tr>
			<tr>
				<td width=100><input type="text" name="title"
					value="${learnThesis.title}" placeholder="请输入研修论文题干"></td>
				<td><label for="title" class="error" generated="true"
					style="color: red; font-size: 12px;"></label></td>
			</tr>
			
			<tr>
				<th>研修论文题目</th>
				<td><label for="content" class="error" generated="true"
					style="color: red; font-size: 12px;"></label></td>
			</tr>
			<tr>
				<td colspan="2">
				<textarea rows="10" cols="100" name="content">${learnThesis.content}</textarea></td>
			</tr>
			
			
			
			<tr>
				<td colspan="2">
				<button type="submit" class="button">创建</button>
				<r:a href="/learnthesis" class="button">取消</r:a></td>
			</tr>
		</tbody>
	</table>
	</form>
</div>
</r:layout>