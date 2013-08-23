<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>  
<%@ taglib prefix="r" tagdir="/WEB-INF/tags/r" %>


<r:layout title="学校空间" >
<jsp:include page="../layout/administrator_navbar.jsp" />
<div class="wrapper">
	<ul class="breadcrumb">
		<li><r:a href="/">首页</r:a> <span class="divider">/</span></li>
		<li class="active">学校空间列表</li>
	</ul>
	<table class="table table-hover" >
		<tr>
			<th>编号</th>
			<th>所属批次</th>
			<th>学校名称</th>
			<th>操作</th>
		</tr>
		<c:forEach items="${list}" var="schoolSpace" varStatus="status">
			<tr>
				<td><span class="badge">${status.index+1}</span></td>
				<td>${schoolSpace.batch.name}[${schoolSpace.batch.code}]</td>
				<td>${schoolSpace.schoolName}</td>
				<td> 
					<c:if test="${schoolSpace.user eq null}">
						<r:a href="/schoolspace/${schoolSpace.id}/personincharge/create">设置学校空间管理员</r:a>
					</c:if>
					<c:if test="${schoolSpace.user ne null}">
						<r:a href="/schoolspace/${schoolSpace.id}/personincharge">查看校区管理员信息</r:a>
					</c:if>
				</td>
			</tr>
		</c:forEach>
	</table>
<div class="toolbar"><div class="pagination pagination-centered"><r:paginate data="${list}"></r:paginate></div></div>
</div>
</r:layout>