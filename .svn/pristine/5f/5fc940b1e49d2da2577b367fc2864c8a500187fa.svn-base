<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="r" tagdir="/WEB-INF/tags/r"%>

<r:javascript name="/resources/js/role/addquestion.js"></r:javascript>
<r:layout title="我要提问">
<jsp:include page="../../layout/teacher_navbar.jsp" />
<div class="wrapper">
	<ul class="breadcrumb">
		<li><r:a href="/">首页</r:a> <span class="divider">/</span></li>
		<li class="active">添加新问题</li>
	</ul>
	<form id="add_form" action="<c:url  value="/question" />" method="post">
	<table class="table">
		<tbody>
			<tr>
				<th width="150">请输入您要问的问题</th>
				<td><label for="askTitle" class="error" generated="true" style="color:red;font-size:12px;"></label></td>
			</tr>
			<tr>
				<td colspan="2">
				 	<textarea rows="10" cols="100" name="askTitle"></textarea>
				 </td>
			</tr>
			<tr>
				<td colspan="3">
					<input type="submit" class="button" value="添加" />
				</td>
			</tr>
		</tbody>
	</table>
	</form>
</div>
</r:layout>