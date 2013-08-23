<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="r" tagdir="/WEB-INF/tags/r"%>

<r:javascript name="/resources/js/bigsubjectAndsmalltopic/validate.js"></r:javascript>
<r:layout title="校本研修管理 | 修改校本研修大主题">
<jsp:include page="../layout/administrator_navbar.jsp" />
	<div class="wrapper">
	<ul class="breadcrumb">
		<li><r:a href="/">首页</r:a> <span class="divider">/</span></li>
		<li><r:a href="/bigsubject">校本研修大主题列表</r:a> <span class="divider">/</span></li>
		<li class="active">编辑校本研修大主题</li>
	</ul>

	<form id="add_form"
		action="<c:url value='/bigsubject/${bigSubject.id}' />" method="post">
	<input type="hidden" name="id" value="${bigSubject.id}" /> <input
		type="hidden" name="_method" value="put" />

	<table class="table">
		<tbody>
			<tr>
				<th>学科</th>
				<td>${bigSubject.discipline.learnLevel.name}-${bigSubject.discipline.learnSpeacialty.name}[<fmt:message
					key="${bigSubject.discipline.learnRange}" />]</td>
			</tr>
			<tr>
				<th>批次</th>
				<td>${bigSubject.batch.name}[${bigSubject.batch.code}]</td>
			</tr>
			<tr>
				<th colspan="2">大主题标题</th>
			</tr>
			<tr>
				<td width=100><input type="text" name="title"
					value="${bigSubject.title}" placeholder="请输入大主题标题"></td>
				<td><label for="title" class="error" generated="true"
					style="color: red; font-size: 12px;"></label></td>
			</tr>

			<tr>
				<th>大主题内容</th>
				<td><label for="description" class="error" generated="true"
					style="color: red; font-size: 12px;"></label></td>
			</tr>
			<tr>
				<td colspan="2"><textarea rows="10" cols="100"
					name="description">${bigSubject.description}</textarea></td>
			</tr>


			<tr>
				<td colspan="2">
				<input type="submit" class="button" value="更新" />
				<r:a href="/bigsubject" class="button">取消</r:a></td>
			</tr>
		</tbody>
	</table>
	</form>
	</div>
</r:layout>