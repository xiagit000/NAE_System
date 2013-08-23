<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>  
<%@ taglib prefix="r" tagdir="/WEB-INF/tags/r" %>


<r:layout title="校本研修管理" >
<jsp:include page="../../layout/teacher_navbar.jsp" />
<div class="wrapper">
	<ul class="breadcrumb">
		<li><r:a href="/">首页</r:a> <span class="divider">/</span></li>
		<li class="active">已结束提交的研修论文列表</li>
	</ul>
	<r:a class="button" href="/learnthesissubmit/show">查看我批改的研修论文</r:a>
	<br/>
	<br/>
	<table class="table table-hover" >
		<c:if test="${empty learnThesisList}">目前没有任何已经结束提交的研修论文可批改</c:if>
		<c:if test="${!empty learnThesisList}">
		<tr>
			<th>编号</th>
			<th>题干</th>
			<th>所属校本研修大主题</th>
			<th>开始时间</th>
			<th>结束时间</th>
			<th>操作</th>
		</tr>
		</c:if>
		<c:forEach items="${learnThesisList}" var="learnThesis" varStatus="status">
			<tr>
				<td><span class="badge">${status.index+1}</span></td>
				<td>${learnThesis.title}</td>
				<td>${learnThesis.bigSubject.title}</td>
				<td><fmt:formatDate value="${learnThesis.beginTime}" pattern="yyyy-MM-dd"/> </td>
				<td><fmt:formatDate value="${learnThesis.submitTime}" pattern="yyyy-MM-dd"/></td>
				<td> 
					<r:a href="/learnthesissubmit/learnthesis/${learnThesis.id}/update">批改研修论文</r:a>
				</td>
			</tr>
		</c:forEach>
	</table>
</div>
</r:layout>