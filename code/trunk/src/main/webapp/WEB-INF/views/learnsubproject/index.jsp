<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>  
<%@ taglib prefix="r" tagdir="/WEB-INF/tags/r" %>

<r:layout title="培训项目 | 培训子项目 " >
<jsp:include page="../layout/administrator_navbar.jsp" />
<div class="wrapper">
	<ul class="breadcrumb">
		<li><r:a href="/">首页</r:a> <span class="divider">/</span></li>
		<li><r:a href="/learnproject">培训项目列表</r:a> <span class="divider">/</span></li>
		<li class="active">"${learnProject.name }"的子项目列表</li>
	</ul>
	<r:a href="/learnproject/${learnProject.id}/learnsubproject/create" class="button">添加</r:a>
	<br/>
	<br/>
	<table class="table table-hover" >
		<tr>
			<th>编号</th>
			<th>子项目名称</th>
			<th>子项目所属培训项目</th>
			<th>子项目所属学科</th>
			<th>子项目所属批次</th>
			<th>操作</th>
		</tr>
		<c:forEach items="${list}" var="learnSubProject" varStatus="status">
			<tr>
				<td><span class="badge">${status.index+1}</span></td>
				<td><r:a href="/learnproject/${learnProject.id}/learnsubproject/${learnSubProject.id}">${learnSubProject.name}</r:a></td>
				<td>${learnSubProject.learnProject.name}</td>
				<td>
					${learnSubProject.discipline.learnLevel.name} - ${learnSubProject.discipline.learnSpeacialty.name}[${learnSubProject.discipline.code}]
				</td>
				<td>
					${learnSubProject.learnProject.batch.code}
				</td>
				<td>
					<c:if test="${learnSubProject.personInCharge eq null}">
					<r:a href="/learnproject/${learnProject.id}/learnsubproject/${learnSubProject.id}/personincharge/create">添加项目专家</r:a>
					</c:if>
					<c:if test="${learnSubProject.personInCharge ne null}">
					<r:a href="/learnproject/${learnProject.id}/learnsubproject/${learnSubProject.id}/personincharge">查看项目专家信息</r:a>
					</c:if>
					<r:a href="/learnproject/${learnProject.id}/learnsubproject/${learnSubProject.id}/update"> 编辑</r:a>
					<r:a href="/learnproject/${learnProject.id}/learnsubproject/${learnSubProject.id}" data-method="delete" data-confirm="确定删除吗？" >删除</r:a>
				</td>
			</tr>
		</c:forEach>
	</table>
	<div class="toolbar"><div class="pagination pagination-centered"><r:paginate data="${list}"></r:paginate></div></div>
</div>
</r:layout>