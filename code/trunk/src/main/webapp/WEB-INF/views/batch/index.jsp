<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="r" tagdir="/WEB-INF/tags/r"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<r:layout title="培训批次">
	<jsp:include page="../layout/administrator_navbar.jsp" />
	<div class="wrapper">
	<ul class="breadcrumb">
		<li><r:a href="/">首页</r:a> <span class="divider">/</span></li>
		<li class="active">培训批次管理</li>
	</ul>
	<r:a href="/batch/new" class="button">添加</r:a>
	<br />
	<br />
	<table class="table table-hover">
		<thead>
			<tr>
				<th>编号</th>
				<th>批次代码</th>
				<th>批次名称</th>
				<th>开始结束时间</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${batchs}" var="batch" varStatus="status">
				<tr>
					<td><span class="badge">${status.index+1}</span></td>
					<td>${batch.code }</td>
					<td>${batch.name }</td>
					<td>${batch.beginTime }/${batch.endTime }</td>
					<td><r:a href="/batch/${batch.id }/edit" class="btn">编辑</r:a>
					<r:a href="/batch/${batch.id }" data-method="delete"
						data-confirm="确定要删除吗？" class="btn">删除</r:a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	</div>

</r:layout>