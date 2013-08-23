<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>  
<%@ taglib prefix="r" tagdir="/WEB-INF/tags/r" %>

<r:layout title="查看公告" >

<jsp:include page="../../layout/administrator_navbar.jsp" />
<div class="wrapper">
	<ul class="breadcrumb">
		<li><r:a href="/">首页</r:a> <span class="divider">/</span></li>
		<li><r:a href="/announcement">公告列表</r:a> <span class="divider">/</span></li>
		<li class="active">查看公告</li>
	</ul>
	<table class="table">
		<tr>
			<th width="150">公告主题</th>
			<td>${ announcement.name}</td>
		</tr>	
		<tr>
			<th width="150">公告发布时间</th>
			<td><fmt:formatDate value="${ announcement.time}" pattern="yyyy-MM-dd HH:mm:ss"/> </td>
		</tr>
		<tr>
			<td colspan="2">公告内容</td>
		</tr>
		<tr>
			<td colspan="2">
				<textarea readonly="readonly" rows="10" cols="100">${ announcement.details}</textarea>
			</td>
		</tr>	
		<tr>
			<th colspan="2">
				<c:if test="${announcement.attachment ne null}">
				<r:a href="/attachment/${announcement.attachment.id}/download">下载附件</r:a>
				</c:if>
				<c:if test="${announcement.attachment eq null}">无附件下载</c:if>
			</th>
		</tr>
	</table>
	
</div>
</r:layout>