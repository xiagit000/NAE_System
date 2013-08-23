<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="r" tagdir="/WEB-INF/tags/r"%>

<r:layout title="校本研修管理 | 展示校本研修小课题">

	<jsp:include page="../../layout/administrator_navbar.jsp" />
	<div class="wrapper">
	<ul class="breadcrumb">
		<li><r:a href="/">首页</r:a> <span class="divider">/</span></li>
		<li><r:a href="/bigsubject">校本研修大主题列表</r:a> <span class="divider">/</span></li>
		<li><r:a
			href="/bigsubject/${smallTopic.belongBigSubject.id}/smalltopic">大主题"${smallTopic.belongBigSubject.title}"的小课题列表</r:a>
		<span class="divider">/</span></li>
		<li>展示小课题</li>
	</ul>

	<table class="table">
		<tbody>
			<tr>
				<th width="150">所属大主题的标题</th>
				<td>${smallTopic.belongBigSubject.title}</td>
			</tr>
			<tr>
				<th>所属大主题的批次</th>
				<td>${smallTopic.belongBigSubject.batch.name}[${smallTopic.belongBigSubject.batch.code}]</td>
			</tr>
			<tr>
				<th>所属大主题的学科</th>
				<td>${smallTopic.belongBigSubject.discipline.learnLevel.name}-${smallTopic.belongBigSubject.discipline.learnSpeacialty.name}[<fmt:message
					key="${smallTopic.belongBigSubject.discipline.learnRange}" />]</td>
			</tr>
			<tr>
				<th>小课题标题</th>
				<td>${smallTopic.title}</td>
			</tr>
			<tr>
				<th colspan="2">小标题内容</th>
			</tr>
			<tr>
				<td colspan="2"><textarea rows="10" cols="100"
					readonly="readonly">${smallTopic.description}</textarea></td>
			</tr>

			<tr>
				<td colspan="2">
					<r:a href="/bigsubject/${smallTopic.belongBigSubject.id}/smalltopic" class="button">返回</r:a>
				</td>
			</tr>
		</tbody>
	</table>
	</div>
</r:layout>