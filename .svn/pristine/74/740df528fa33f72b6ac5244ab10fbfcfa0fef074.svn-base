<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="r" tagdir="/WEB-INF/tags/r"%>

<r:javascript name="/resources/js/bigsubjectAndsmalltopic/validate.js"></r:javascript>
<r:layout title="校本研修管理 | 添加校本研修大主题">
	<ul class="breadcrumb">
		<li><r:a href="/">首页</r:a> <span class="divider">/</span></li>
		<li><r:a href="/bigsubject">校本研修大主题列表</r:a> <span class="divider">/</span></li>
		<li class="active">添加校本研修大主题</li>
	</ul>

	<form id="add_form" action="<c:url value='/bigsubject' />"
		method="post">

	<table class="table">
		<tbody>
			<tr>
				<td colspan="2">
				<h3>添加新的校本研修大主题</h3>
				</td>
			</tr>

			<tr>
				<td colspan="2">选择培训批次</td>
			</tr>
			<tr>
				<td width=100><select name="batchId">
					<c:forEach items="${batchList}" var="batch">
						<option value='${batch.id}'
							<c:if test="${batch.id eq bigSubject.batch.id}">selected = "selected"</c:if>>${batch.name}[${batch.code}]</option>
					</c:forEach>
				</select></td>
			</tr>

			<tr>
				<td colspan="2">选择学科</td>
			</tr>
			<tr>
				<td width=100><select name="disciplineId">
					<c:forEach items="${disciplineList}" var="discipline">
						<option value='${discipline.id}'
							<c:if test="${discipline.id eq bigSubject.discipline.id}">selected = "selected"</c:if>>${discipline.learnLevel.name}-${discipline.learnSpeacialty.name
						}[<fmt:message key="${discipline.learnRange}" />]</option>
					</c:forEach>
				</select></td>
			</tr>
			<tr>
				<td colspan="2">大主题标题</td>
			</tr>
			<tr>
				<td width=100><input type="text" name="title"
					value="${bigSubject.title}" placeholder="请输入大主题标题"></td>
				<td><label for="title" class="error" generated="true"
					style="color: red; font-size: 12px;"></label></td>
			</tr>
			
			<tr>
				<td>大主题内容</td>
				<td><label for="description" class="error" generated="true"
					style="color: red; font-size: 12px;"></label></td>
			</tr>
			<tr>
				<td colspan="2">
				<textarea rows="10" cols="100" name="description">${bigSubject.description}</textarea></td>
			</tr>
			
			<tr>
				<td colspan="2">
				<button type="submit" class="btn">创建</button>
				<r:a href="/bigsubject" class="btn">取消</r:a></td>
			</tr>
		</tbody>
	</table>
	</form>

</r:layout>