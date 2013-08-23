<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>  
<%@ taglib prefix="r" tagdir="/WEB-INF/tags/r" %>


<r:layout title="教学计划" >
	<jsp:include page="../layout/administrator_navbar.jsp" />
	<div class="wrapper">
		<ul class="breadcrumb">
			<li><r:a href="#">首页</r:a> <span class="divider">/</span></li>
			<li class="active">教学计划列表</li>
		</ul>
		<r:a href="/learnplan/create" class="button">添加</r:a>
		<br/>
		<br/>
		
		<r:table var="learnPlan" data="${list}" varStatus="loop" class="table table-hover">
		   <r:col header="编号"><span class="badge">${loop.count}</span></r:col>
		   <r:col header="教学计划名称"><r:a href="/learnplan/${learnPlan.id}">${learnPlan.name}</r:a></r:col>
		   <r:col header="教学计划代码">${learnPlan.code}</r:col>
	       <r:col header="培训批次">${learnPlan.batch.code}</r:col>
	       <r:col header="课程名称">${learnPlan.learnCourse.name}</r:col>
	       <r:col header="培训项目名称">${learnPlan.learnSubProject.name}</r:col>
	       <r:col header="培训范围"><fmt:message key="${learnPlan.learnRange}" /></r:col>
	       <r:col  header="操作">
	           <r:a href="/learnplan/${learnPlan.id}/update"> 编辑</r:a>
	           <r:a href="/learnplan/${learnPlan.id}" data-method="delete" data-confirm="确定删除吗？" >删除</r:a>
	       </r:col>
		</r:table>
		
		<div class="toolbar"><div class="pagination pagination-centered"><r:paginate data="${list}"></r:paginate></div></div>
	</div>
</r:layout>