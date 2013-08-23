<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="r" tagdir="/WEB-INF/tags/r"%>

<r:javascript name="/resources/js/role/updateUsually.js"></r:javascript>
<r:layout title="批改学生研修论文">
<jsp:include page="../../layout/teacher_navbar.jsp" />
<div class="wrapper">
	<ul class="breadcrumb">
		<li><r:a href="/">首页</r:a> <span class="divider">/</span></li>
		<li><r:a href="/learnthesissubmit/show">批改过的研修论文</r:a> <span class="divider">/</span></li>
		<li><r:a href="/learnthesissubmit/${learnThesisSubmit.id}/update">研修论文"${learnThesisSubmit.learnThesis.title}" 批改列表</r:a><span class="divider">/</span></li>
		<li class="active">批改"${learnThesisSubmit.user.realName}"的研修论文</li>
	</ul>
	<form id="add_form" action="<c:url  value="/learnthesissubmit/${learnThesisSubmit.id}" />" method="post">
	<table class="table">
		<tbody>
			<tr>
				<th width="200">请输入"${learnThesisSubmit.user.realName}"的研修论文分数</th>
				<td width="150"><input type="text" name="score"  value="${learnThesisSubmit.score}" /> </td>
				<td><label for="score" class="error" generated="true" style="color:red;font-size:12px;"></label></td>
			</tr>
			<tr>
				<th>请选择"${learnThesisSubmit.user.realName}"的研修论文评级</th>
				<td>
					<select name="learnThesisRating">
						<c:forEach items="${ratings}" var="rating">
							<option value="${rating}"><fmt:message key="learnThesis_${rating}" /> </option>
						</c:forEach>
					</select>
				</td>
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