<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>  
<%@ taglib prefix="r" tagdir="/WEB-INF/tags/r" %>

<r:javascript name="/resources/js/discipline/personincharge/validate.js"></r:javascript>
<r:layout title="培训学科 | 展示老师信息" >

<jsp:include page="../../layout/administrator_navbar.jsp" />
<div class="wrapper">
	<ul class="breadcrumb">
		<li><r:a href="/">首页</r:a> <span class="divider">/</span></li>
		<li><r:a href="/learnclass">班级列表</r:a> <span class="divider">/</span></li>
		<li class="active">展示"${learnClass.allName}"班级的老师信息</li>
	</ul>
	
	<table class="table">
			<tbody>
				<tr>
					<th style="color: red;">
						班级："${learnClass.allName}"的老师信息
					</th>
				</tr>
				<tr>
					<th width="150">辅导老师所属批次</th>
				</tr>
				<tr>
					<td>${user.batch.name}[${user.batch.code}]</td>
				</tr>
				<tr>
					<th>辅导老师真实姓名</th>
					
				</tr>
				<tr>
					<td>${user.realName}</td>
				</tr>
				<tr>
					<th>辅导老师登录名</th>
				</tr>
				<tr>
					<td>${user.loginName}</td>
				</tr>
				<tr>
					<th>辅导老师登录密码</th>
				</tr>
				<tr>
					<td>${user.password}</td>
				</tr>
				<tr>
					<td> <r:a href="/learnclass" class="button">返回班级列表</r:a> </td>
				</tr>
			</tbody>
		</table>
</div>
</r:layout>