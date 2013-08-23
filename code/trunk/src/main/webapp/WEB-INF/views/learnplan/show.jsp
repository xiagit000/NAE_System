<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="r" tagdir="/WEB-INF/tags/r"%>

<r:javascript name="/resources/js/discipline/add.js"></r:javascript>
<r:layout title="培训项目 | 展示培训项目">
<jsp:include page="../layout/administrator_navbar.jsp" />
<div class="wrapper">
	<ul class="breadcrumb">
		<li><r:a href="/">首页</r:a> <span class="divider">/</span></li>
		<li><r:a href="/learnplan">教学计划列表</r:a> <span class="divider">/</span></li>
		<li class="active">教学计划 ${learnPlan.name} 基本信息</li>
	</ul>

	<table class="table">
		<tbody>
			<tr>
				<td colspan="2">
				<h3>教学计划 ${learnPlan.name} 基本信息</h3>
				</td>
			</tr>
			<tr>
				<th width="130">教学计划代码</th>
				<td>${learnPlan.code}</td>
			</tr>
			<tr>
				<th>教学计划所属批次</th>
				<td>${learnPlan.batch.code}</td>
			</tr>
			<tr>
				<th>教学计划课程</th>
				<td>${learnPlan.learnCourse.name}</td>
			</tr>
			<tr>
				<th>教学计划所选项目</th>
				<td>${learnPlan.learnSubProject.name}</td>
			</tr>
			<tr>
				<th>教学计划培训范围</th>
				<td><fmt:message key="${learnPlan.learnRange}" /></td>
			</tr>
			<tr>
				<th colspan="2">教学计划描述</th>
			</tr>
			<tr>
				<td colspan="2"><textarea rows="10" cols="100" readonly="readonly"
					name="description">${learnPlan.description}</textarea></td>
			</tr>

			<tr>
				<td><r:a href="/learnplan" class="button">返回</r:a></td>
			</tr>
		</tbody>
	</table>
</div>
</r:layout>