<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="r" tagdir="/WEB-INF/tags/r"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<r:layout title="新建毕业标准">
	<r:javascript name="/resources/js/graduateStandard/add.js"></r:javascript>
	<jsp:include page="../layout/administrator_navbar.jsp" />
	<div class="wrapper">
		<ul class="breadcrumb">
			<li><r:a href="/">首页</r:a> <span class="divider">/</span></li>
			<li class="active">新建毕业标准</li>
		</ul>
		<form id="add_form" action="<c:url value='/graduateStandard' />" method="post">
			<table class="table table-hover">
				<tbody>
					<tr>
						<th width="150px">批次：</th>
						<td><select name="batchId">
								<c:forEach items="${batchs }" var="batch">
									<option value="${batch.id }">${batch.code}-${batch.name }</option>
								</c:forEach>
						</select></td>
					</tr>
					<tr>
						<th width="150px">合格分数：</th>
						<td><input name="passScore" value="${graduateStandard.passScore }" />%</td>
					</tr>
					<tr>
						<th width="150px">结业时间：</th>
						<td><input name="graduateTime"
							value="<fmt:formatDate pattern="yyyy-MM-dd" value="${graduateStandard.graduateTime}" type="both"/>"
							onclick="WdatePicker()" readonly="readonly" /></td>
					</tr>
					<tr>
						<td colspan="2">
						<input class="button" type="submit" value="提交" /> 
						<r:a href="/graduateStandard" class="button">取消</r:a>
						</td>
					</tr>
				</tbody>
			</table>
		</form>
	</div>
</r:layout>