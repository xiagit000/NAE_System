<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="r" tagdir="/WEB-INF/tags/r"%>

<r:javascript name="/resources/js/learnplan/add.js"></r:javascript>
<r:javascript name="/resources/js/learnplan/select.js"></r:javascript>
<r:layout title="教学计划 | 添加教学计划">
<jsp:include page="../layout/administrator_navbar.jsp" />
<div class="wrapper">
	<ul class="breadcrumb">
		<li><r:a href="/">首页</r:a> <span class="divider">/</span></li>
		<li><r:a href="/learnplan">教学计划列表</r:a> <span class="divider">/</span></li>
		<li class="active">添加教学计划</li>
	</ul>
  	<form id="add_form" action="<c:url value='/learnplan' />" method="post">
	<table class="table table-hover">
		<tbody>
			<tr>
				<th colspan="2"><span style="color: red;font-weight: bold;">当前批次&nbsp;&nbsp;:&nbsp;&nbsp;${currentBatch.name}[${currentBatch.code}]</span></th>
			</tr>
			
			<tr>
				<th>教学计划名称</th>
				<td><input type="text" name="name" value="${learnPlan.name}" placeholder="请输入教学计划名称"><label for="name" class="error" generated="true" style="color: red; font-size: 12px;"></label></td>
			</tr>
			<tr>
				<th>教学计划代码</th>
				<td><input type="text" name="code" value="${learnPlan.code}" placeholder="请输入教学计划代码"><label for="code" class="error" generated="true" style="color: red; font-size: 12px;"></label></td>
			</tr>
			<tr>
				<th>培训范围</th>
				<td><select name="learnRange" id="learnRangeSelect">
					<c:forEach items="${learnRangeList}" var="lr">
						<option value='${lr}'>
						<fmt:message key="${lr}" /></option>
					</c:forEach>
				</select>
				</td>
			</tr>

			<tr>
				<th>选择培训项目</th>
				<td><select name="learnSubProjectId">
					<c:forEach items="${learnSubProjectList}" var="learnSubProject">
						<option value="${learnSubProject.id}"
							<c:if test="${learnSubProject.id eq learnPlan.learnSubProject.id}">selected="selected"</c:if>>${learnSubProject.name}</option>
					</c:forEach>
				</select></td>
			</tr>
			
			<tr>
				<th>选择培训课程</th>
				<td><select name="learnCourseId" id="learnCourseSelect">
					<c:forEach items="${learnCourseList}" var="learnCourse">
						<option value="${learnCourse.id}" >${learnCourse.name}</option>
					</c:forEach>
				</select></td>
			</tr>
			
			<tr>
				<th colspan="2">教学计划描述</th>
			</tr>
			
			<tr>
				<td colspan="2"><textarea rows="10" cols="100"
					name="description">${learnPlan.description}</textarea></td>
			</tr>

			<tr>
				<td colspan="2">
				<button type="submit" class="button">添加</button>
				<r:a href="/learnplan" class="button">取消</r:a></td>
			</tr>
		</tbody>
	</table>
</form>
</div>
</r:layout>