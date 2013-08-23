<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="r" tagdir="/WEB-INF/tags/r"%>

<r:layout title="我提交的研修论文">
<jsp:include page="../../layout/student_navbar.jsp" />
<div class="wrapper">
	<ul class="breadcrumb">
		<li><r:a href="/">首页</r:a> <span class="divider">/</span></li>
		<li><r:a href="/learnthesis/show">开放提交的研修论文列表</r:a> <span class="divider">/</span></li>
		<li class="active">我提交的研修论文信息</li>
	</ul>
	<table class="table table-hover" >
		<c:if test="${empty learnThesisSubmitList}">您未提交任何研修论文!</c:if>
		<c:if test="${!empty learnThesisSubmitList}">
		<tr>
			<th>编号</th>
			<th>题干</th>
			<th>所属校本研修大主题</th>
			<th>提交时间</th>
			<th>已覆盖/最新</th>
			<th>批改结果</th>
			<th>操作</th>
		</tr>
		</c:if>
		<c:forEach items="${learnThesisSubmitList}" var="learnThesisSubmit" varStatus="status">
			<tr>
				<td><span class="badge">${status.index+1}</span></td>
				<td>${learnThesisSubmit.learnThesis.title}</td>
				<td>${learnThesisSubmit.learnThesis.bigSubject.title}</td>
				<td><fmt:formatDate value="${learnThesisSubmit.submitDate}" pattern="yyyy-MM-dd"/> </td>
				<td>
					<c:if test="${!learnThesisSubmit.newest}">已覆盖</c:if>
					<c:if test="${learnThesisSubmit.newest}">最新</c:if>	
				</td>
				<td>
					<c:if test="${learnThesisSubmit.learnThesisRating eq null}">未评分</c:if>
					<c:if test="${learnThesisSubmit.learnThesisRating ne null}">${learnThesisSubmit.score}(<fmt:message key="learnThesis_${learnThesisSubmit.learnThesisRating}" />)</c:if>
				</td>
				<td> 
					<r:a href="/attachment/${learnThesisSubmit.attachment.id}/download">下载</r:a>
				</td>
			</tr>
		</c:forEach>
	</table>
	<div class="toolbar"><div class="pagination pagination-centered"><r:paginate data="${learnThesisSubmitList}"></r:paginate></div></div>
</div>

</r:layout>