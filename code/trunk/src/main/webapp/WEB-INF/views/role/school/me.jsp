<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>  
<%@ taglib prefix="r" tagdir="/WEB-INF/tags/r" %>

<r:layout title="个人信息" >

<jsp:include page="../../layout/school_navbar.jsp" />
<div class="wrapper">
	<ul class="breadcrumb">
		<li><r:a href="/">首页</r:a> <span class="divider">/</span></li>
		<li class="active">个人信息</li>
	</ul>
	
	<table class="table">
			<tbody>
				<tr>
					<th width="150">所属批次</th>
				</tr>
				<tr>
					<td>${user.batch.name}[${user.batch.code}]</td>
				</tr>
				<tr>
					<th>真实姓名</th>
					
				</tr>
				<tr>
					<td>${user.realName}</td>
				</tr>
				<tr>
					<th>登录名</th>
				</tr>
				<tr>
					<td>${user.loginName}</td>
				</tr>
				<tr>
					<th>登录密码</th>
				</tr>
				<tr>
					<td>${user.password}</td>
				</tr>
			</tbody>
		</table>
</div>
</r:layout>