<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="r" tagdir="/WEB-INF/tags/r"%>

<r:javascript name="/resources/js/role/changepassword.js"></r:javascript>
<r:layout title="修改密码">
<jsp:include page="../../layout/teacher_navbar.jsp" />
<div class="wrapper">
	<ul class="breadcrumb">
		<li><r:a href="/">首页</r:a> <span class="divider">/</span></li>
		<li class="active">修改密码</li>
	</ul>
	<form id="add_form" action="<c:url  value="/user/changepass" />" method="post">
	<table class="table">
		<tbody>
			<tr>
				<th width="150">请输入旧的密码</th>
				<td width="150"><input type="text" name="oldPassword" value="${oldpassword}" /> </td>
				<td><label for="oldPassword" class="error" generated="true" style="color:red;font-size:12px;"></label></td>
			</tr>
			<tr>
				<th>输入新密码</th>
				<td><input type="text" name="newpassword" id="pwd" value="${newpassword}"/> </td>
				<td><label for="pwd" class="error" generated="true" style="color:red;font-size:12px;"></label></td>
			</tr>
			<tr>
				<th>确认新密码</th>
				<td><input type="text" name="newpasswordAgain"/> </td>
				<td><label for="newpasswordAgain" class="error" generated="true" style="color:red;font-size:12px;"></label></td>
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