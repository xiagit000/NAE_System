<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>  
<%@ taglib prefix="r" tagdir="/WEB-INF/tags/r" %>

<r:layout title="个人信息" >

<jsp:include page="../../layout/teacher_navbar.jsp" />
<div class="wrapper">
	<ul class="breadcrumb">
		<li><r:a href="/">首页</r:a> <span class="divider">/</span></li>
		<li class="active">本班学生列表</li>
	</ul>
	<table class="table">
		<tr>
			<th>编号</th>
			<th>姓名</th>
			<th>所属学校</th>
			<th>当前状态</th>
			<th>当前日常分数</th>
			<th>操作</th>
		</tr>
		<c:forEach items="${classMate}" var="schoolRoll" varStatus="status">
			<tr>
				<td><span class="badge">${status.index+1}</span></td>
				<td>${schoolRoll.user.realName}</td>
				<td>${schoolRoll.user.account.school}</td>
				<td><fmt:message key="${schoolRoll.schoolRollType}" /></td>
				<td>
					${grades[status.index].usuallyScore}
				</td>
				<td>
					<r:a href="/grade/${grades[status.index].id}/updateusually">修改平时成绩</r:a>
				</td>
			</tr>	
		</c:forEach>		
	</table>
<div class="toolbar"><div class="pagination pagination-centered"><r:paginate data="${classMate}"></r:paginate></div></div>
</div>
</r:layout>