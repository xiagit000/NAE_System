<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>  
<%@ taglib prefix="r" tagdir="/WEB-INF/tags/r" %>

<r:javascript name="/resources/js/discipline/personincharge/validate.js"></r:javascript>
<r:layout title="培训学科 | 展示项目专家信息" >

<jsp:include page="../../layout/administrator_navbar.jsp" />
<div class="wrapper">
	<ul class="breadcrumb">
		<li><r:a href="/">首页</r:a> <span class="divider">/</span></li>
		<li><r:a href="/learnproject/${learnSubproject.learnProject.id}/learnsubproject">"${learnSubproject.learnProject.name}"的培训子项目列表</r:a> <span class="divider">/</span></li>
		<li class="active">展示子项目"${learnSubproject.name}"的项目专家信息</li>
	</ul>
	
	<table class="table">
			<tbody>
				<tr>
					<th style="color: red;">
						子项目："${learnSubproject.name}"的项目专家信息
					</th>
				</tr>
				<tr>
					<th width="150">项目专家所属批次</th>
				</tr>
				<tr>
					<td>${user.batch.name}[${user.batch.code}]</td>
				</tr>
				<tr>
					<th>项目专家真实姓名</th>
					
				</tr>
				<tr>
					<td>${user.realName}</td>
				</tr>
				<tr>
					<th>项目专家登录名</th>
				</tr>
				<tr>
					<td>${user.loginName}</td>
				</tr>
				<tr>
					<th>项目专家登录密码</th>
				</tr>
				<tr>
					<td>${user.password}</td>
				</tr>
				<tr>
					<td> <r:a href="/learnproject/${learnSubproject.learnProject.id}/learnsubproject" class="button">返回培训子项目列表</r:a> </td>
				</tr>
			</tbody>
		</table>
</div>
</r:layout>