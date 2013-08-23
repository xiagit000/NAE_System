<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>  
<%@ taglib prefix="r" tagdir="/WEB-INF/tags/r" %>

<r:javascript name="/resources/js/discipline/personincharge/validate.js"></r:javascript>
<r:layout title="培训学科 | 添加学科专家" >

<jsp:include page="../../layout/administrator_navbar.jsp" />
<div class="wrapper">
	<ul class="breadcrumb">
		<li><r:a href="/">首页</r:a> <span class="divider">/</span></li>
		<li><r:a href="/discipline">学科列表</r:a> <span class="divider">/</span></li>
		<li class="active">添加学科专家</li>
	</ul>
	
	<form id="add_form" action="<c:url value='/discipline/${discipline.id}/personincharge' />" method="post">
		<input type="hidden" name="prefix" value="${prefix}"/>
		<table class="table">
			<tbody>
				<tr>
					<th colspan="2">
						添加学科"${discipline.learnLevel.name}${discipline.learnSpeacialty.name}"的专家
					</th>
				</tr>
				<tr>
					<th colspan="2">学科专家登录名</th>
				</tr>
				
				<tr>
					<td colspan="2"  width="100">
						<span style="color: red;font-weight: bold;">${prefix}</span>
					</td>
				</tr>
				<tr>
					<th colspan="2">学科专家登录密码</th>
				</tr>
				
				<tr>
					<td  width="100">
						<input type="text" name="password" id="pwd"  placeholder="请输入专家登录密码">
					</td>
					<td>
						<label for="password" class="error" generated="true" style="color:red;font-size:12px;"></label>
					</td>
				</tr>
				<tr>
					<th colspan="2">确认学科专家登录密码</th>
				</tr>
				
				<tr>
					<td  width="100">
						<input type="text" name="passwordAgain"  placeholder="请确认专家登录密码">
					</td>
					<td>
						<label for="passwordAgain" class="error" generated="true" style="color:red;font-size:12px;"></label>
					</td>
				</tr>
				<tr>
					<th colspan="2">输入学科专家的真实姓名</th>
				</tr>
				
				<tr>
					<td  width="100">
						<input type="text" name="realName"  placeholder="请输入专家真实姓名">
					</td>
					<td>
						<label for="realName" class="error" generated="true" style="color:red;font-size:12px;"></label>
					</td>
				</tr>
				
				<tr>
					<td colspan="2">
						<input type="submit" class="button" value="提交"/>
					</td>
				</tr>
			</tbody>
		</table>
	</form>
</div>
</r:layout>