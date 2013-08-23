<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="r" tagdir="/WEB-INF/tags/r"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<r:layout title="培训班级">
	<jsp:include page="../layout/administrator_navbar.jsp" />
	<div class="wrapper">
		<ul class="breadcrumb">
			<li><r:a href="/">首页</r:a> <span class="divider">/</span></li>
			<li class="active">培训班级管理</li>
		</ul>
		<r:a href="/learnclass/new" class="button">添加</r:a>
		<br /> <br />
		<table class="table table-hover">
			<thead>
				<tr>
					<th>编号</th>
					<th>班级代码</th>
					<th>班级名称</th>
					<th>所属培训项目</th>
					<th>所在培训区域</th>
					<th>负责人</th>
					<th>电话</th>
					<th>班级状态</th>
					<th>操作</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${classes}" var="class" varStatus="status">
					<tr>
						<td><span class="badge">${status.index+1}</span></td>
						<td>${class.code }</td>
						<td>${class.name }</td>
						<td>${class.learnProject.name }</td>
						<td>${class.learnArea.name }</td>
						<td>${class.personIncharge }</td>
						<td>${class.tel }</td>
						<td>${class.status==true?'启用':'关闭' }</td>
						<td>
						    <c:if test="${class.teacher eq null}">
								<r:a href="/learnclass/${class.id}/personincharge/create" class="btn">设置班级内学员为老师</r:a>
								<br />
							</c:if>
							<c:if test="${class.teacher ne null}">
								<r:a href="/learnclass/${class.id}/personincharge" class="btn">查看老师信息</r:a>
								<br />
							</c:if> 
							<r:a href="/learnclass/${class.id }" class="btn">查看</r:a> 
							<r:a href="/learnclass/${class.id }/edit" class="btn">编辑</r:a>
						    <r:a href="/learnclass/${class.id }" data-method="delete"
								data-confirm="确定要删除吗？" class="btn">删除</r:a>
					   </td>
					</tr>

				</c:forEach>
			</tbody>
		</table>
		<div class="toolbar">
			<div class="pagination pagination-centered">
				<r:paginate data="${classes}" />
			</div>
		</div>
	</div>
</r:layout>