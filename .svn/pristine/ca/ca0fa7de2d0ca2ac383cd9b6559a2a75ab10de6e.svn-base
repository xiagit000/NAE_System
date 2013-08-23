<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>  
<%@ taglib prefix="r" tagdir="/WEB-INF/tags/r" %>

<r:layout title="公告发布" >

<jsp:include page="../../layout/project_navbar.jsp" />
<div class="wrapper">
	<ul class="breadcrumb">
		<li><r:a href="/">首页</r:a> <span class="divider">/</span></li>
		<li class="active">我发布的项目公告列表</li>
	</ul>
	<r:a href="/announcement/new" class="button">添加项目公告</r:a>
	<br />
	<br />
	<table class="table">
		<tr>
			<th>编号</th>
			<th>公告主题</th>
			<th>发布时间</th>
			<th>有无附件</th>
			<th>操作</th>
		</tr>
		<c:forEach items="${announcementList}" var="announcement" varStatus="status">
			<tr>
				<td><span class="badge">${status.index+1}</span></td>
				<td>${announcement.name}</td>
				<td><fmt:formatDate value="${announcement.time}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
				<td>
					<c:if test="${announcement.attachment eq null}">无</c:if>
					<c:if test="${announcement.attachment ne null}">有</c:if>	
				</td>
				<td>
					<r:a href="/announcement/${announcement.id}" data-method="delete" data-confirm="确定删除吗？" >删除</r:a>
					<c:if test="${announcement.attachment ne null}">
						<r:a href="/attachment/${announcement.attachment.id}/download">下载附件</r:a>
					</c:if>
				</td>
			</tr>	
		</c:forEach>		
	</table>
<div class="toolbar"><div class="pagination pagination-centered"><r:paginate data="${announcementList}"></r:paginate></div></div>	
</div>
</r:layout>