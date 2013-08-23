<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="r" tagdir="/WEB-INF/tags/r"%>

<r:layout title="学生的提问">
<jsp:include page="../../layout/teacher_navbar.jsp" />
<div class="wrapper">
	<ul class="breadcrumb">
		<li><r:a href="/">首页</r:a> <span class="divider">/</span></li>
		<li><r:a href="/question">学生提问列表</r:a> <span class="divider">/</span></li>
		<li class="active">查看${question.asker.realName}</li>
	</ul>
	<table class="table table-hover">
		<tbody>
			<tr>
				<th colspan="2">您的问题&nbsp;&nbsp;:&nbsp;&nbsp;${question.askTitle}</th>
				
			</tr>
			<tr>
				<th colspan="2">${question.resolver.realName}的回答</th>
			</tr>
			<tr>
				<td colspan="2">
					<c:if test="${question.resolved}">
						<textarea rows="10" cols="100" readonly="readonly">${question.answerContent}</textarea>
					</c:if>
					<c:if test="${!question.resolved}">老师还未能作答</c:if>
				</td>
			</tr>
		</tbody>
	</table>
</div>
</r:layout>