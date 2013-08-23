<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="r" tagdir="/WEB-INF/tags/r" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<r:layout title="学科专家中心" >
<jsp:include page="../layout/discipline_navbar.jsp" />
<div class="wrapper">
          <ul class="breadcrumb">
              <li class="active"><r:a href="/">首页</r:a></li>
          </ul>
          <div class="content">
			<h2 class="title_h2"><span class="color_block"></span>学科培训情况统计</h2>
			<table class="main_data">
				<thead>
					<tr>
						<th>学科名称</th>
						<th>项目数</th>
						<th>班级数</th>
						<th>学员数</th>
						<th>在线时长</th>
						<th>有效时长</th>
						<th>研修作业(提交/批阅/推荐)</th>
						<th>班级论坛(发帖/回帖)</th>
						<th>问答(已提问/已回答/待回答)</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>${disciplineStatistics.discipline.learnLevel.name}-${disciplineStatistics.discipline.learnSpeacialty.name}</td>
						<td>${disciplineStatistics.learnSubjectCount}</td>
						<td>${disciplineStatistics.learnClassCount}</td>
						<td>${disciplineStatistics.classMateInfo}</td>
						<td>${disciplineStatistics.onlineTimeCount}</td>
						<td>${disciplineStatistics.enableTimeCount}</td>
						<td>${disciplineStatistics.learnThesisInfo}</td>
						<td>${disciplineStatistics.forumTopicInfo}</td>
						<td>${disciplineStatistics.questionInfo}</td>
					</tr>	
				
				</tbody>
			
			</table>
		</div>
		 <div class="content">
			<h2 class="title_h2"><span class="color_block"></span>学科下项目的培训情况统计</h2>
			<table class="main_data">
				<thead>
					<tr>
						<th>项目名称</th>
						<th>班级数</th>
						<th>学员数</th>
						<th>在线时长</th>
						<th>有效时长</th>
						<th>研修作业(提交/批阅/推荐)</th>
						<th>班级论坛(发帖/回帖)</th>
						<th>问答(已提问/已回答/待回答)</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${learnSubprojectStatistics}" var="learnSubproject">
						<tr>
							<td><r:a href="/statistics/learnsubproject/${learnSubproject.learnSubProject.id}">${learnSubproject.learnSubProject.name}</r:a></td>
							<td>${learnSubproject.learnClassCount}</td>
							<td>${learnSubproject.classMateInfo}</td>
							<td>${learnSubproject.onlineTimeCount}</td>
							<td>${learnSubproject.enableTimeCount}</td>
							<td>${learnSubproject.learnThesisInfo}</td>
							<td>${learnSubproject.forumTopicInfo}</td>
							<td>${learnSubproject.questionInfo}</td>
						</tr>	
				</c:forEach>
				</tbody>
			
			</table>
		</div>
		
 </div>
</r:layout>