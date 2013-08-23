<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="r" tagdir="/WEB-INF/tags/r"%>

<r:javascript name="/resources/js/discipline/add.js"></r:javascript>
<r:layout title="培训项目 | 培训子项目  |展示培训子项目">
<jsp:include page="../layout/administrator_navbar.jsp" />
<div class="wrapper">
	<ul class="breadcrumb">
		<li><r:a href="/">首页</r:a> <span class="divider">/</span></li>
		<li><r:a href="/learnproject'">项目列表</r:a> <span class="divider">/</span></li>
		<li><r:a href="/learnproject/${learnProject.id}/learnsubproject"> "${learnProject.name }"的子项目列表</r:a><span class="divider">/</span></li>
		<li class="active">查看培训子项目"${learnSubProject.name}"</li>
	</ul>

	<table class="table">
		<tbody>
			<tr>
				<th width="150">培训子项目绑定学科</th>
				<td>${learnSubProject.discipline.learnLevel.name} - ${learnSubProject.discipline.learnSpeacialty.name}[${learnSubProject.discipline.code}]</td>
			</tr>
			<tr>
				<th colspan="2">项目描述</th>
			</tr>
			<tr>
				<td colspan="2"><textarea rows="10" cols="100" readonly="readonly"
					name="description">${learnSubProject.description}</textarea></td>
			</tr>

			<tr>
				<td><r:a href="/learnproject/${learnProject.id}/learnsubproject" class="button">返回</r:a></td>
			</tr>
		</tbody>
	</table>
</div>
</r:layout>