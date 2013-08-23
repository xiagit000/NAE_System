<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="r" tagdir="/WEB-INF/tags/r"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<r:layout title="学科的学员培训情况">
	<jsp:include page="../../layout/discipline_navbar.jsp" />
	<div class="wrapper">
	<ul class="breadcrumb">
		<li><r:a href="/">首页</r:a> <span class="divider">/</span></li>
		<li><r:a href="/statistics/discipline">学科与项目培训情况统计</r:a><span class="divider">/</span></li>
		<li class="active">班级"${learnClass.name}"培训情况统计</li>
	</ul>
	<div class="content">
	<h2 class="title_h2"><span class="color_block"></span>班级"${learnClass.name}"培训动态数据</h2>
	<table class="main_data">
		<thead>
			<tr>
				<th>姓名</th>
				<th>区县</th>
				<th>学校</th>
				<th>是否已参训</th>
				<th>在线时长</th>
				<th>有效时长</th>
				<th>视频研修(已得分)</th>
				<th>研修作业 (已得分)</th>
				<th>班级讨论 (已得分)</th>
				<th>平时得分</th>
			</tr>
		</thead>
		<tbody>
			
				<c:forEach items="${grades}" var="grade">
				<tr>
					<td>${grade.user.account.name}</td>
					<td>${learnClass.name}</td>
					<td>${grade.user.account.school}</td>
					<td><c:if test="${grade.user.active}">是</c:if> <c:if
						test="${!grade.user.active}">否</c:if></td>
					<td>${grade.onlineTimeCount}</td>
					<td>${grade.effectiveTimeCount}</td>
					<td>${grade.learnVideoScore}</td>
					<td>${grade.learnThesisScore}</td>
					<td>${grade.learnDiscussScore}</td>
					<td>${grade.usuallyScore}</td>
				</tr>
				</c:forEach>
			
		</tbody>
	</table>
	<div class="toolbar"><div class="pagination pagination-centered"><r:paginate data="${grades}"></r:paginate></div></div>
</div>
	</div>
</r:layout>