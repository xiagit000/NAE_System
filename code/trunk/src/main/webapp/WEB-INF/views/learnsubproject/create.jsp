<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="r" tagdir="/WEB-INF/tags/r"%>

<r:layout title="培训项目 | 培训子项目 |添加培训子项目">
<jsp:include page="../layout/administrator_navbar.jsp" />
<div class="wrapper">
	<ul class="breadcrumb">
		<li><r:a href="/">首页</r:a> <span class="divider">/</span></li>
		<li><r:a href="/learnproject">项目列表</r:a> <span class="divider">/</span></li>
		<li><r:a href="/learnproject/${learnProject.id}/learnsubproject/">培训项目"${learnProject.name}"的子项目列表</r:a> <span class="divider">/</span></li>
		<li class="active">添加"${learnProject.name}" 的培训子项目</li>
	</ul>

	<form id="add_form" action="<c:url value='/learnproject/${learnProject.id}/learnsubproject/' />"
		method="post">

	<table class="table">
		<tbody>
			<tr>
				<th width="150">选择培训学科</th>
				<td>
						<select name="disciplineId">
							<c:forEach var="ls" items="${disciplineList}">
								<option value="${ls.id}"
									<c:if test="${ls.id eq learnSubProject.discipline.id}">selected="selected"</c:if>>${ls.learnLevel.name}
								- ${ls.learnSpeacialty.name}[${ls.code}]</option>
							</c:forEach>
						</select>
				</td>
			</tr>
			
			<tr>
				<th colspan="2">项目描述</th>
			</tr>
			<tr>
				<td colspan="2">
				<textarea rows="10" cols="100" name="description">${learnSubProject.description}</textarea></td>
			</tr>

			<tr>
				<td colspan="2">
				<button type="submit" class="button">添加</button>
				<r:a href="/learnproject/${learnProject.id}/learnsubproject" class="button">取消</r:a></td>
			</tr>
		</tbody>
	</table>
	</form>
</div>
</r:layout>