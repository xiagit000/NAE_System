<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="r" tagdir="/WEB-INF/tags/r"%>

<r:javascript name="/resources/js/discipline/add.js"></r:javascript>
<r:layout title="培训项目 | 展示培训项目">
<jsp:include page="../layout/administrator_navbar.jsp" />
<div class="wrapper">
	<ul class="breadcrumb">
		<li><r:a href="/">首页</r:a> <span class="divider">/</span></li>
		<li><r:a href="/learnproject">项目列表</r:a> <span class="divider">/</span></li>
		<li class="active">培训项目"${learnProject.name}"基本信息</li>
	</ul>

	<table class="table">
		<tbody>
			<tr>
				<th width="150">培训项目名称</th>
				<td>${learnProject.name}</td>
			</tr>
			<tr>
				<th width="150">培训项目所属批次</th>
				<td>${learnProject.batch.name}[${learnProject.batch.code}]</td>
			</tr>
			<tr>
				<th width="150">培训项目代码</th>
				<td>${learnProject.code}</td>
			</tr>
			<tr>
				<th colspan="2">项目描述</th>
			</tr>
			<tr>
				<td colspan="2"><textarea rows="10" cols="100" readonly="readonly"
					name="description">${learnProject.description}</textarea></td>
			</tr>

			<tr>
				<td><r:a href="/learnproject" class="button">返回</r:a></td>
			</tr>
		</tbody>
	</table>
</div>
</r:layout>