<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="r" tagdir="/WEB-INF/tags/r"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<r:layout title="省督导 | 学校情况统计">
	<jsp:include page="../../layout/province_navbar.jsp" />
	<div class="wrapper">
	<ul class="breadcrumb">
		<li><r:a href="/">首页</r:a> <span class="divider">/</span></li>
		<li><r:a href="/statistics/province">本省各区的培训情况统计</r:a><span class="divider">/</span></li>
		<li class="active">"${learnArea.name}"下的学校培训情况统计</li>
	</ul>
	<div class="content">
			<h2 class="title_h2"><span class="color_block"></span>"${learnArea.name}"下的学校学习情况统计</h2>
			<table class="main_data">
				<thead>
					<tr>
						<th>学校名称</th>
						<th>学员数</th>
						<th>在线时长</th>
						<th>有效时长</th>
						<th>研修作业(提交/批阅/推荐)</th>
						<th>班级论坛(发帖/回帖)</th>
						<th>问答(已提问/已回答/待回答)</th>

					</tr>
				</thead>
				<tbody>
					<c:forEach items="${schoolStatistics}" var="school">
						<tr>
							<td><r:a href="/statistics/school/${school.school.id}">${school.school.schoolName}</r:a></td>
							<td>${school.classMateInfo}</td>
							<td>${school.onlineTimeCount}</td>
							<td>${school.enableTimeCount}</td>
							<td>${school.learnThesisInfo}</td>
							<td>${school.forumTopicInfo}</td>
							<td>${school.questionInfo}</td>
						</tr>
					</c:forEach>
				</tbody>
			
			</table>
		</div>
	</div>
</r:layout>