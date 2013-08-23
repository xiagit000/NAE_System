<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="r" tagdir="/WEB-INF/tags/r"%>

<r:layout title="我的培训情况统计">
<jsp:include page="../../layout/teacher_navbar.jsp" />
<div class="wrapper">
	<ul class="breadcrumb">
		<li><r:a href="/">首页</r:a> <span class="divider">/</span></li>
		<li class="active">我的培训情况统计</li>
	</ul>
	<div class="content">
			<h2 class="title_h2"><span class="color_block"></span>我的培训情况统计</h2>
			<table class="main_data">
				<thead>
					<tr>
						<th>姓名</th>
						<th>用户名</th>
						<th>是否激活</th>
						<th>学员数量(激活/总数)</th>
						<th>我的在线时长</th>
						<th>研修论文(提交/批阅/推荐)</th>
						<th>班级论坛(发帖/回帖)</th>
						<th>问题解答(提问/解决/待解决)</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>${learnStatistics.teacher.realName}</td>
						<td>${learnStatistics.teacher.loginName}</td>
						<td>
							<c:if test="${learnStatistics.teacher.active}">是</c:if>
							<c:if test="${!learnStatistics.teacher.active}">否</c:if>
						</td>
						<td>${learnStatistics.classMateInfo}</td>
						<td>${learnStatistics.onlineTimeCount}小时</td>
						<td>${learnStatistics.learnThesisInfo}</td>
						<td>${learnStatistics.forumTopicInfo}</td>
						<td>${learnStatistics.questionInfo}</td>
					</tr>	
				</tbody>
			</table>
		</div>
</div>
</r:layout>