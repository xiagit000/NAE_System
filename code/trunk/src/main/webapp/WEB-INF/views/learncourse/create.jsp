<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>  
<%@ taglib prefix="r" tagdir="/WEB-INF/tags/r" %>

<r:javascript name="/resources/js/learncourse/add.js"></r:javascript>
<r:layout title="培训课程 | 添加培训课程" >
<jsp:include page="../layout/administrator_navbar.jsp" />
<div class="wrapper">
	<ul class="breadcrumb">
		<li><r:a href="/">首页</r:a> <span class="divider">/</span></li>
		<li><r:a href="/learncourse">课程列表</r:a> <span class="divider">/</span></li>
		<li class="active">添加培训课程</li>
	</ul>
	
	<form id="add_form" action="<c:url value='/learncourse' />" method="post">
		
		<table class="table">
			<tbody>
				<tr>
					<th width="100">选择培训形式</th>
					<td><select name="learnShape">
							<c:forEach var="ls" items="${learnShapeList}">
								<option value="${ls}" <c:if test="${ls eq learnCourse.learnShape}">selected="selected"</c:if>  ><fmt:message  key='${ls}' /></option>	
							</c:forEach>
						</select></td>
				</tr>
				<tr>
					<th>选择培训范围</th>
					<td>
						<select name="learnRange">
							<c:forEach var="lr" items="${learnRangeList}">
								<option value="${lr}" <c:if test="${lr eq learnCourse.learnRange}">selected="selected"</c:if>  ><fmt:message  key='${lr}' /></option>	
							</c:forEach>
						</select>
					</td>
				</tr>
				<tr>
					<th>课程名称</th>
					<td>
						<input type="text" name="name"  value="${learnCourse.name}" placeholder="请输入课程名称">
						<label for="name" class="error" generated="true" style="color:red;font-size:12px;"></label>
					</td>
				</tr>
				<tr>
					<th>课程代码</th>
					
					<td>
						<input type="text" name="code"  value="${learnCourse.code}" placeholder="请输入课程代码">
						<label for="code" class="error" generated="true" style="color:red;font-size:12px;"></label>
					</td>
				</tr>
				
				<tr>
					<th colspan="2">课程描述</th>
				</tr>
				<tr>
					<td colspan="2">
						<textarea rows="10" cols="100" name="description">${learnCourse.description}</textarea>
					</td>
				</tr>
				
				<tr>
					<td colspan="2"><button type="submit" class="button">添加</button> <r:a href="/learncourse" class="button">取消</r:a></td>
				</tr>
			</tbody>
		</table>
	</form>
</div>	
</r:layout>