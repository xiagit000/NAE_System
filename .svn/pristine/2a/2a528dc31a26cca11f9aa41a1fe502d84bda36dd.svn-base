<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="r" tagdir="/WEB-INF/tags/r" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<r:layout title="项目专家中心" >
<jsp:include page="../layout/project_navbar.jsp" />
<div class="wrapper">
          <ul class="breadcrumb">
              <li class="active"><r:a href="/">首页</r:a></li>
          </ul>
          <div class="content">
			<h2 class="title_h2"><span class="color_block"></span>培训项目培训情况统计</h2>
			<table class="main_data">
				<thead>
					<tr>
						<th>培训项目名称</th>
						<th>省数量</th>
						<th>市区数量</th>
						<th>学校数量</th>
						<th>班级数</th>
						<th>学员数</th>
						<th>在线时长</th>
						<th>有效时长</th>
						<th>研修作业</th>
						<th>班级论坛</th>
						<th>问答</th>
					</tr>
					<tr>
						<th></th>
						<th></th>
						<th></th>
						<th></th>
						<th></th>
						<th>(总计/激活)</th>
						<th>(总计)</th>
						<th>(总计)</th>
						<th>(提交/批阅/推荐)</th>
						<th>(发帖/回帖)</th>
						<th>(已提问/已回答/待回答)</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>${projectStatistic.learnSubProject.name}</td>
						<td>${projectStatistic.provinceCount}</td>
						<td>${projectStatistic.citiesCount}</td>
						<td>${projectStatistic.schoolCount}</td>
						<td>${projectStatistic.learnClassCount}</td>
						<td>${projectStatistic.classMateInfo}</td>
						<td>${projectStatistic.onlineTimeCount}</td>
						<td>${projectStatistic.enableTimeCount}</td>
						<td>${projectStatistic.learnThesisInfo}</td>
						<td>${projectStatistic.forumTopicInfo}</td>
						<td>${projectStatistic.questionInfo}</td>
					</tr>
				</tbody>
			
			</table>
		</div>
		<div class="content">
			<h2 class="title_h2"><span class="color_block"></span>培训项目下班级学习情况统计</h2>
			<table class="main_data">
				<thead>
					<tr>	
						<th>编号</th>				
						<th>班级名称</th>
						<th>班级老师</th>
						<th>学员数(总数/激活)</th>
						<th>在线时长</th>
						<th>有效时长</th>
						<th>研修作业(提交/批阅/推荐)</th>
						<th>班级论坛(发帖/回帖)</th>
						<th>问答(已提问/已回答/待回答)</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${learnClassStatistics}" var="statistics" varStatus="status">
						<tr>
							<td><span class="badge">${status.index+1}</span></td>
							<td><r:a href="/statistics/learnclass/${statistics.learnClass.id}">${statistics.learnClass.name}</r:a></td>
							<td>
								<c:if test="${statistics.learnClass.teacher ne null}">
									${statistics.learnClass.teacher.realName}	
								</c:if>
								<c:if test="${statistics.learnClass.teacher eq null}">未设置老师</c:if>
							</td>
							<td>${statistics.classMateInfo}</td>
							<td>${statistics.onlineTimeCount}</td>
							<td>${statistics.enableTimeCount}</td>
							<td>${statistics.learnThesisInfo}</td>
							<td>${statistics.forumTopicInfo}</td>
							<td>${statistics.questionInfo}</td>
						</tr>
						
					</c:forEach>
				</tbody>
			
			</table>
		</div>
 </div>
</r:layout>