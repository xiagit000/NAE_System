<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="r" tagdir="/WEB-INF/tags/r" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<r:layout title="学科专家中心 | 单个培训项目的统计情况" >
<jsp:include page="../../layout/discipline_navbar.jsp" />
<div class="wrapper">
          <ul class="breadcrumb">
              <li><r:a href="/">首页</r:a></li>
              <li><r:a href="/statistics/discipline">学科与项目培训情况统计</r:a><span class="divider">/</span></li>
			  <li class="active">${learnSubProject.name}培训情况统计</li>
          </ul>
         <div class="content">
			<h2 class="title_h2"><span class="color_block"></span>培训项目"${learnSubProject.name}"培训情况统计</h2>
			<table class="main_data">
				<thead>
					<tr>
						<th>班级名称</th>
						<th>学员数(总计/激活)</th>
						<th>在线时长</th>
						<th>有效时长</th>
						<th>研修作业(提交/批阅/推荐)</th>
						<th>班级论坛(发帖/回帖)</th>
						<th>问答(已提问/已回答/待回答)</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${learnClassStatisticsBySubProject}" var="learnClassStatistics">
						<tr>
							<td><r:a href="/statistics/learnclass/${learnClassStatistics.learnClass.id}">${learnClassStatistics.learnClass.name}</r:a></td>
							<td>${learnClassStatistics.classMateInfo}</td>
							<td>${learnClassStatistics.onlineTimeCount}</td>
							<td>${learnClassStatistics.enableTimeCount}</td>
							<td>${learnClassStatistics.learnThesisInfo}</td>
							<td>${learnClassStatistics.forumTopicInfo}</td>
							<td>${learnClassStatistics.questionInfo}</td>
						</tr>	
				</c:forEach>
				</tbody>
			
			</table>
		</div>
		
 </div>
</r:layout>