<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="r" tagdir="/WEB-INF/tags/r"%>

<r:layout title="解答学生的问题">
<r:javascript name="/resources/js/role/resolvedquestion.js"></r:javascript>
<jsp:include page="../../layout/teacher_navbar.jsp" />
<div class="wrapper">
	<ul class="breadcrumb">
		<li><r:a href="/">首页</r:a><span class="divider">/</span></li>
		<li><r:a href="/question">学生的提问列表</r:a><span class="divider">/</span></li>
		<li class="active">解答"${question.asker.realName}"的问题</li>
	</ul>
<form id="add_form" action="<c:url value='/question/${question.id}/resolve' />" method="post">
	<input type="hidden" name="askTitle" value="${ question.askTitle}" /> 
	<table class="table table-hover">
		<tbody>
			<tr>
				<th colspan="2">问题&nbsp;&nbsp;:&nbsp;&nbsp;${question.askTitle}</th>
			</tr>
			<tr>
				<th>我的答案</th>
				<td><label for="answerContent" class="error" generated="true" style="color:red;font-size:12px;"></label></td>
			</tr>
			<tr>
				<td colspan="2">
					<textarea name="answerContent" rows="10" cols="100"></textarea>
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="解答" class="button" />
				</td>
			</tr>
		</tbody>
	</table>
</form>
</div>
</r:layout>