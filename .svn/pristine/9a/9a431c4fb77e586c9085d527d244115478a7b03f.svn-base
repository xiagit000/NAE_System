<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="r" tagdir="/WEB-INF/tags/r"%>

<r:javascript name="/resources/js/role/updateUsually.js"></r:javascript>
<r:layout title="修改平时成绩">
<jsp:include page="../../layout/teacher_navbar.jsp" />
<div class="wrapper">
	<ul class="breadcrumb">
		<li><r:a href="/">首页</r:a> <span class="divider">/</span></li>
		<li><r:a href="/grade/students">班级学员列表</r:a> <span class="divider">/</span></li>
		<li class="active">修改"${grade.user.realName}"的平时成绩</li>
	</ul>
	<form id="add_form" action="<c:url  value="/grade/${grade.id}/updateusually" />" method="post">
	<table class="table">
		<tbody>
			<tr>
				<th width="200">请输入"${grade.user.realName}"的新平时成绩</th>
				<td width="150"><input type="text" name="usuallyScore" value="${grade.usuallyScore}" /> </td>
				<td><label for="usuallyScore" class="error" generated="true" style="color:red;font-size:12px;"></label></td>
			</tr>
			<tr>
				<td colspan="3">
					<input type="submit" class="button" value="更新" />
				</td>
			</tr>
		</tbody>
	</table>
	</form>
</div>
</r:layout>