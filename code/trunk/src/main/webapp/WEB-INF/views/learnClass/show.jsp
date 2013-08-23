<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="r" tagdir="/WEB-INF/tags/r"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<r:layout title="展示培训班级">
	<jsp:include page="../layout/administrator_navbar.jsp" />
	<div class="wrapper">
		<ul class="breadcrumb">
			<li><r:a href="/">首页</r:a> <span class="divider">/</span></li>
			<li><r:a href="/learnclass">培训班级管理</r:a> <span class="divider">/</span></li>
			<li class="active">展示培训班级</li>
		</ul>
		<table class="table table-hover">
			<tbody>
				<tr>
					<th>班级代码：</th>
					<td>${learnClass.code }</td>
				</tr>
				<tr>
					<th>班级名称：</th>
					<td>${learnClass.name }</td>
				</tr>
				<tr>
					<th>班级全名：</th>
					<td>${learnClass.allName }</td>
				</tr>
				<tr>
					<th>培训区域：</th>
					<td>${learnClass.learnProject.name }</td>
				</tr>
				<tr>
					<th>培训项目：</th>
					<td>${learnClass.learnArea.name }</td>
				</tr>
				<tr>
					<th>负责人：</th>
					<td>${learnClass.personIncharge }</td>
				</tr>
				<tr>
					<th>电话：</th>
					<td>${learnClass.tel }</td>
				</tr>
				<tr>
					<th>邮箱：</th>
					<td>${learnClass.zipCode }</td>
				</tr>
				<tr>
					<th>住址：</th>
					<td>${learnClass.address }</td>
				</tr>
				<tr>
					<th>区号：</th>
					<td>${learnClass.areaCode }</td>
				</tr>
				<tr>
					<th>是否开启：</th>
					<td><input type="checkbox" name="status" ${learnClass.status==true?'checked="checked"':""}
						disabled="disabled" /></td>
				</tr>
				<tr>
					<td colspan="2">
					<r:a href="/learnclass/${learnClass.id }/edit" class="button">编辑</r:a> 
					<r:a href="/learnclass" class="button">取消</r:a>
					</td>
				</tr>
			</tbody>
		</table>



	</div>
</r:layout>