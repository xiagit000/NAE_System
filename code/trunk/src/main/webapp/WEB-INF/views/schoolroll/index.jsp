<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>  
<%@ taglib prefix="r" tagdir="/WEB-INF/tags/r" %>


<r:layout title="学员学籍" >
<jsp:include page="../layout/administrator_navbar.jsp" />
<div class="wrapper">
	<ul class="breadcrumb">
		<li><r:a href="/">首页</r:a> <span class="divider">/</span></li>
		<li class="active">学员学籍列表</li>
	</ul>
	<table class="table table-hover" >
		<tr>
			<th>编号</th>
			<th>所属批次</th>
			<th>学员姓名</th>
			<th>学员所属班级</th>
			<th>学员目前状态</th>
			<th>学员所属学科</th>
			<th>操作</th>
		</tr>
		<c:forEach items="${list}" var="schoolRoll" varStatus="status">
			<tr>
				<td><span class="badge">${status.index+1}</span></td>
				<td>${schoolRoll.learnClass.enrollmentPlan.batch.name}[${schoolRoll.learnClass.enrollmentPlan.batch.code}]</td>
				<td><r:a href="/schoolroll/${schoolRoll.id}">${schoolRoll.user.account.name}</r:a> </td>
				<td>${schoolRoll.learnClass.allName}</td>
				<td> <fmt:message key="${schoolRoll.schoolRollType}" />  </td>
				<td>${schoolRoll.learnClass.learnProject.discipline.learnLevel.name} - ${schoolRoll.learnClass.learnProject.discipline.learnSpeacialty.name}</td>
				<td> 
					<r:a href="/schoolroll/${schoolRoll.id}/update">学籍异动</r:a>
				</td>
			</tr>
		</c:forEach>
	</table>
<div class="toolbar"><div class="pagination pagination-centered"><r:paginate data="${list}"></r:paginate></div></div>
</div>
</r:layout>