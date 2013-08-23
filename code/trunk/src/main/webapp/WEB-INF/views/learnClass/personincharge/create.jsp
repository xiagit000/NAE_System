<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>  
<%@ taglib prefix="r" tagdir="/WEB-INF/tags/r" %>

<r:javascript name="/resources/js/discipline/personincharge/validate.js"></r:javascript>
<r:layout title="培训学科 | 添加班级辅导老师" >

<jsp:include page="../../layout/administrator_navbar.jsp" />
<div class="wrapper">
	<ul class="breadcrumb">
		<li><r:a href="/">首页</r:a> <span class="divider">/</span></li>
		<li><r:a href="/learnclass">班级列表</r:a> <span class="divider">/</span></li>
		<li class="active">添加"${learnClass.allName}"的辅导老师</li>
	</ul>
	
	<form id="add_form" action="<c:url value='/learnclass/${learnClass.id}/personincharge' />" method="post">
		<input type="hidden" name="prefix" value="${prefix}"/>
		<table class="table">
			<tbody>
				<tr>
					<th colspan="2">
						添加"${learnClass.allName}"的辅导老师
					</th>
				</tr>
				<tr>
					<th>请选择</th>
					<td>
						<select name="studentId">
							<c:forEach items="${classUsers}" var="user">
								<option value="${user.id}">${user.account.name}[证件号码:${user.account.idNumber}]</option>
							</c:forEach>
						</select>
					</td>
				</tr>
				
				<tr>
					<td colspan="2">
						<input type="submit" class="button" value="提交"/>
					</td>
				</tr>
			</tbody>
		</table>
	</form>
</div>
</r:layout>