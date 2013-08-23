<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="r" tagdir="/WEB-INF/tags/r"%>

<r:layout title="研修论文管理 | 展示研修论文">
<jsp:include page="../layout/administrator_navbar.jsp" />
<div class="wrapper">
	<ul class="breadcrumb">
		<li><r:a href="/">首页</r:a> <span class="divider">/</span></li>
		<li><r:a href="/learnthesis">研修论文列表</r:a> <span class="divider">/</span></li>
		<li class="active">研修论文"${learnThesis.title}"</li>
	</ul>

	<table class="table">
		<tbody>
			<tr>
				<th width="150">所属批次</th>
				<td>${learnThesis.bigSubject.batch.name}[${bigSubject.batch.code}]</td>
			</tr>
			<tr>
				<th>所属大主题名称</th>
				<td>${learnThesis.bigSubject.title}</td>
			</tr>
			<tr>
				<th>成绩管理发布的分数</th>
				<td>
					<c:if test="${learnThesis.score == 0.0}">
						成绩中还未设置研修论文的总分
					</c:if>
					<c:if test="${learnThesis.score != 0.0}">
						${learnThesis.score}
					</c:if>
				</td>
			</tr>
			<tr>
				<th>研修论文开始时间</th>
				<td> <fmt:formatDate value="${learnThesis.beginTime}" pattern="yyyy-MM-dd"/> </td>
			</tr>
			<tr>
				<th>研修论文结束时间</th>
				<td> <fmt:formatDate value="${learnThesis.submitTime}" pattern="yyyy-MM-dd"/> </td>
			</tr>
			<tr>
				<th>研修论文题干</th>
				<td>${learnThesis.title}</td>
			</tr>
			<tr>
				<th colspan="2">研修论文题目</th>
			</tr>
			<tr>
				<td colspan="2">
					<textarea rows="10" cols="100" readonly="readonly">${learnThesis.content}</textarea>
				</td>
			</tr>
			<tr>
				<td colspan="2"><r:a href="/learnthesis" class="button">返回</r:a></td>
			</tr>
			
		</tbody>
	</table>
</div>
</r:layout>