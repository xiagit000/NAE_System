<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="r" tagdir="/WEB-INF/tags/r"%>

<r:javascript name="/resources/js/learnproject/add.js"></r:javascript>
<r:layout title="学员学籍 | 学籍异动">
<jsp:include page="../layout/administrator_navbar.jsp" />
	<div class="wrapper">
	<ul class="breadcrumb">
		<li><r:a href="/">首页</r:a> <span class="divider">/</span></li>
		<li><r:a href="/schoolroll">学员学籍列表</r:a> <span class="divider">/</span></li>
		<li class="active">学籍异动</li>
	</ul>

	<form id="add_form"
		action="<c:url value='/schoolroll/${schoolRoll.id}' />" method="post">
	<input type="hidden" name="id" value="${schoolRoll.id}" /> <input
		type="hidden" name="_method" value="put" />

	<table class="table">
		<tbody>
			<tr>
				<th colspan="2">批次${schoolRoll.learnClass.enrollmentPlan.batch.name}[${schoolRoll.learnClass.enrollmentPlan.batch.code}]
				学员： ${schoolRoll.user.account.name} 的学籍异动</th>


			</tr>

			<tr>
				<th colspan="2">选择异动类型</th>
			</tr>
			<tr>
				<td width=100><select name="schoolRollType">
					<c:forEach items="${schoolRollTypeList}" var="srType">
						<option value='${srType}'
							<c:if test="${srType eq schoolRoll.schoolRollType}">selected = "selected"</c:if>><fmt:message
							key="${srType}" /></option>
					</c:forEach>
				</select></td>

			</tr>

			<tr>
				<td colspan="2">
				<button type="submit" class="button">更新</button>
				<r:a href="/schoolroll" class="button">取消</r:a></td>
			</tr>
		</tbody>
	</table>
	</form>
	</div>
</r:layout>