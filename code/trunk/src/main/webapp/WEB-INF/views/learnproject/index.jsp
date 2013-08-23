<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>  
<%@ taglib prefix="r" tagdir="/WEB-INF/tags/r" %>


<r:layout title="培训项目" >
<jsp:include page="../layout/administrator_navbar.jsp" />
<div class="wrapper">
	<ul class="breadcrumb">
		<li><r:a href="#">首页</r:a> <span class="divider">/</span></li>
		<li class="active">培训项目列表</li>
	</ul>
	<r:a href="/learnproject/create" class="button">添加</r:a>
	<br/>
	<br/>
	<table class="table table-hover" >
		<tr>
			<th>编号</th>
			<th>培训项目名称</th>
			<th>培训项目代码</th>
			<th>所属培训批次</th>
			<th>操作</th>
		</tr>
		<c:forEach items="${list}" var="learnProject" varStatus="status">
			<tr>
				<td><span class="badge">${status.index+1}</span></td>
				<td><r:a href="/learnproject/${learnProject.id}">${learnProject.name}</r:a> </td>
				<td>${learnProject.code}</td>
				<td>${learnProject.batch.code}</td>
				<td>
					<r:a href="/learnproject/${learnProject.id}/learnsubproject">查看子项目列表</r:a>
					<r:a href="/learnproject/${learnProject.id}/update"> 编辑</r:a>
					<r:a href="/learnproject/${learnProject.id}" data-method="delete" data-confirm="确定删除吗？" >删除</r:a>
				</td>
			</tr>
		</c:forEach>
	</table>
	<div class="toolbar"><div class="pagination pagination-centered"><r:paginate data="${list}"></r:paginate></div></div>
</div>
</r:layout>