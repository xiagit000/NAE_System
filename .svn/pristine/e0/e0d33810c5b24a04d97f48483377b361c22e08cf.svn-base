<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="r" tagdir="/WEB-INF/tags/r"%>

<r:javascript name="/resources/js/discipline/add.js"></r:javascript>
<r:layout title="培训课程| 展示培训课程信息">
<jsp:include page="../layout/administrator_navbar.jsp" />
<div class="wrapper">
	<ul class="breadcrumb">
		<li><r:a href="/">首页</r:a> <span class="divider">/</span></li>
		<li><r:a href="/learncourse">课程列表</r:a> <span
			class="divider">/</span></li>
		<li class="active">培训课程:${learnCourse.name}</li>
	</ul>
	<table class="table">
		<tbody>
			<tr>
				<th width="100">课程代码</th>
				<td>${learnCourse.code}</td>
			</tr>
			<tr>
				<th width="100">课程形式</th>
				<td><fmt:message key="${learnCourse.learnShape}" /></td>
			</tr>
			<tr>
				<th width="100">课程范围</th>
				<td><fmt:message key="${learnCourse.learnRange}" /></td>
			</tr>
			<tr>
				<th width="100">基本学习时长</th>
				<td>${learnCourse.studyTimeCount}</td>
			</tr>
			<tr>
				<th colspan="2">课程简述</th>
			</tr>
			<tr>
				<td colspan="2">
					<textarea rows="10" cols="50" readonly="readonly">${learnCourse.description}</textarea>
				</td>
			</tr>
			
			<tr>
				<td colspan="2">
					<r:a href="/learncourse" class="button">返回</r:a></td>
			</tr>
		</tbody>
	</table>
</div>
</r:layout>