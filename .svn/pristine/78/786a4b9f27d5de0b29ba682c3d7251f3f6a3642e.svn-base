<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>  
<%@ taglib prefix="r" tagdir="/WEB-INF/tags/r" %>

<r:layout title="培训学科" >
<jsp:include page="../layout/administrator_navbar.jsp" />
<div class="wrapper">
	<ul class="breadcrumb">
		<li><r:a href="/">首页</r:a> <span class="divider">/</span></li>
		<li class="active">学科列表</li>
	</ul>
	<r:a href="/discipline/create" class="button">添加</r:a>
	<br/>
	<br/>
	<table class="table table-hover" >
		<tr>
			<th>编号</th>
			<th>培训范围</th>
			<th>培训学科名称</th>
			<th>培训学科代码</th>
			<th>操作</th>
		</tr>
		<c:forEach items="${list}" var="discipline" varStatus="status">
			<tr>
				<td><span class="badge">${status.index+1}</span></td>
				<td><fmt:message  key='${discipline.learnRange}' /></td>
				<td>
					${discipline.learnLevel.name }-${discipline.learnSpeacialty.name}
				</td>
				<td>
					${discipline.code}
				</td>
				<td>
					<c:if test="${discipline.personInCharge eq null}">
						<r:a href="/discipline/${discipline.id}/personincharge/create">添加学科专家</r:a><br/>	
					</c:if>
					<c:if test="${discipline.personInCharge ne null}">
						<r:a href="/discipline/${discipline.id}/personincharge/${discipline.personInCharge.id}">查看学科专家信息</r:a><br/>	
					</c:if>
					<r:a href="/discipline/${discipline.id}" data-method="delete" data-confirm="确定删除吗？" >删除学科记录</r:a>
				</td>
			</tr>
		</c:forEach>
	</table>
	<div class="toolbar"><div class="pagination pagination-centered"><r:paginate data="${list}"></r:paginate></div></div>
</div>
</r:layout>