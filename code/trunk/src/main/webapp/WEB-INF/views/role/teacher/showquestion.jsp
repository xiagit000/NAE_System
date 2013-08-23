<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="r" tagdir="/WEB-INF/tags/r"%>

<r:layout title="我的提问">
<jsp:include page="../../layout/teacher_navbar.jsp" />
<div class="wrapper">
	<ul class="breadcrumb">
		<li><r:a href="/">首页</r:a> <span class="divider">/</span></li>
		<li><r:a href="/question/mine">我的提问列表</r:a> <span class="divider">/</span></li>
		<li class="active">查看我的提问</li>
	</ul>
	<table class="table table-hover">
		<tbody>
			<tr>
				<th width="150">您的问题</th>
				<td>
					${question.askTitle}
				</td>
			</tr>
			<tr>
				<th colspan="2">回答</th>
			</tr>
			<tr>
				<td colspan="2">
					<c:if test="${question.resolved}">
						<textarea rows="10" cols="100" readonly="readonly">${question.answerContent}</textarea>
					</c:if>
					<c:if test="${!question.resolved}">专家还未能作答</c:if>
				</td>
			</tr>
		</tbody>
	</table>
</div>
</r:layout>