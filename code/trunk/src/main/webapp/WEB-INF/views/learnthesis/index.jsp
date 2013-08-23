<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>  
<%@ taglib prefix="r" tagdir="/WEB-INF/tags/r" %>


<r:layout title="校本研修管理" >
<jsp:include page="../layout/administrator_navbar.jsp" />
<div class="wrapper">
	<ul class="breadcrumb">
		<li><r:a href="/">首页</r:a> <span class="divider">/</span></li>
		<li class="active">研修论文列表</li>
	</ul>
	<r:a href="/learnthesis/create" class="button">添加</r:a>
	<br/>
	<br/>
	<table class="table table-hover" >
		<tr>
			<th>编号</th>
			<th>批次</th>
			<th>题干</th>
			<th>所属校本研修大主题</th>
			<th>开始时间</th>
			<th>结束时间</th>
			<th>操作</th>
		</tr>
		<c:forEach items="${list}" var="learnThesis" varStatus="status">
			<tr>
				<td><span class="badge">${status.index+1}</span></td>
				<td>${learnThesis.bigSubject.batch.name}[${learnThesis.bigSubject.batch.code }] </td>
				<td><r:a href="/learnthesis/${learnThesis.id}">${learnThesis.title}</r:a> </td>
				<td><r:a href="/bigsubject/${learnThesis.bigSubject.id}">${learnThesis.bigSubject.title}</r:a></td>
				<td><fmt:formatDate value="${learnThesis.beginTime}" pattern="yyyy-MM-dd"/> </td>
				<td><fmt:formatDate value="${learnThesis.submitTime}" pattern="yyyy-MM-dd"/></td>
				<td> 
					<r:a href="/learnthesis/${learnThesis.id}/update">编辑</r:a>
					<r:a href="/learnthesis/${learnThesis.id}"  data-method="delete" data-confirm="确定删除吗？" >删除</r:a>
				</td>
			</tr>
		</c:forEach>
	</table>
	<div class="toolbar"><div class="pagination pagination-centered"><r:paginate data="${list}"></r:paginate></div></div>
</div>
</r:layout>