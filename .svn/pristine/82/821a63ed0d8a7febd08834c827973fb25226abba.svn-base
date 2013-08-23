<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="r" tagdir="/WEB-INF/tags/r"%>

<r:layout title="校本研修管理 | 展示校本研修大主题">
	<ul class="breadcrumb">
		<li><r:a href="/">首页</r:a> <span class="divider">/</span></li>
		<li><r:a href="/bigsubject">校本研修大主题列表</r:a> <span class="divider">/</span></li>
		<li class="active">大主题:${bigSubject.title}</li>
	</ul>

	<table class="table">
		<tbody>
			<tr>
				<th>所属批次</th>
				<td>${bigSubject.batch.name}[${bigSubject.batch.code}]</td>
			</tr>
			<tr>
				<th>所属学科</th>
				<td>${bigSubject.discipline.learnLevel.name}-${bigSubject.discipline.learnSpeacialty.name}[ <fmt:message key="${bigSubject.discipline.learnRange}" />]</td>
			</tr>
			<tr>
				<th>大主题标题</th>
				<td>${bigSubject.title}</td>
			</tr>
			<tr>
				
			</tr>
			<tr>
				<th colspan="2">大主题内容</th>
			</tr>
			<tr>
				<td colspan="2">
					<textarea rows="10" cols="100" readonly="readonly">${bigSubject.description}</textarea>
				</td>
			</tr>
			
			<tr>
				<td colspan="2"><r:a href="/bigsubject" class="btn">返回</r:a></td>
			</tr>
		</tbody>
	</table>
</r:layout>