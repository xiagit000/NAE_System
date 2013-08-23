<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>  
<%@ taglib prefix="r" tagdir="/WEB-INF/tags/r" %>


<r:layout title="小课题管理" >

<jsp:include page="../../layout/administrator_navbar.jsp" />
	<div class="wrapper">
	<ul class="breadcrumb">
		<li><r:a href="/">首页</r:a> <span class="divider">/</span></li>
		<li><r:a href="/bigsubject">校本研修大主题列表</r:a> <span class="divider">/</span></li>
		<li class="active">大主题"${bigSubject.title}"的小课题列表</li>
	</ul>
	
	<r:a href="/bigsubject/${bigSubject.id}/smalltopic/create" class="button">添加</r:a>
	<br/>
	<br/>
	
	<table class="table table-hover" >
		<tr>
			<th>编号</th>
			<th>小课题标题</th>
			<th>操作</th>
		</tr>
		<c:forEach items="${list}" var="smallTopic" varStatus="status">
			<tr>
				<td><span class="badge">${status.index+1}</span></td>
				
				<td><r:a href="/bigsubject/${bigSubject.id}/smalltopic/${smallTopic.id}">${smallTopic.title}</r:a> </td>
				<td> 
					<r:a href="/bigsubject/${bigSubject.id}/smalltopic/${smallTopic.id}/update">编辑</r:a>
					<r:a href="/bigsubject/${bigSubject.id}/smalltopic/${smallTopic.id}" data-method="delete" data-confirm="确定要删除吗?">删除</r:a>
				</td>
			</tr>
		</c:forEach>
	</table>
	<div class="toolbar"><div class="pagination pagination-centered"><r:paginate data="${list}"></r:paginate></div></div>
</div>
</r:layout>