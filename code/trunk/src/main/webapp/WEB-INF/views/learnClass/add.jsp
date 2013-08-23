<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="r" tagdir="/WEB-INF/tags/r"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<r:layout title="创建培训班级">
	<script src="<c:url value="/resources/js/learnClass/add.js"/>"
		type="text/javascript"></script>
	<jsp:include page="../layout/administrator_navbar.jsp" />
	<div class="wrapper">
		<ul class="breadcrumb">
			<li><r:a href="/">首页</r:a> <span class="divider">/</span></li>
			<li><r:a href="/learnclass">培训班级管理</r:a> <span class="divider">/</span></li>
			<li class="active">创建培训班级</li>
		</ul>
		<form id="add_form" action="<c:url value='/learnclass' />"
			method="POST">
			<table class="table table-hover">
				<tbody>
					<tr>
						<td><b>班级代码：</b></td>
						<td><input name="code" value="${learnClass.code }" /></td>
					</tr>
					<tr>
						<td><b>班级名称：</b></td>
						<td><input name="name" value="${learnClass.name }" /></td>
					</tr>
					<tr>
						<td><b>班级全名：</b></td>
						<td><input name="allName" value="${learnClass.allName }" /></td>
					</tr>
					<tr>
						<td><b>培训区域：</b></td>
						<td><select name="areaId">
								<c:forEach items="${areas }" var="area" varStatus="status">
									<option value="${area.id }">${area.name }</option>
								</c:forEach>
						</select></td>
					</tr>
					<tr>
						<td><b>培训项目：</b></td>
						<td>
						<select name="projectId">
								<c:forEach items="${projects }" var="project" varStatus="status">
									<option value="${project.id }">${project.name }</option>
								</c:forEach>
						</select>
						</td>
					</tr>
					<tr>
						<td width="150"><b>负责人：</b></td>
						<td><input name="personIncharge" value="${learnClass.personIncharge }" /></td>
					</tr>
					<tr>
						<td><b>电话：</b></td>
						<td><input name="tel" value="${learnClass.tel }" /></td>
					</tr>
					<tr>
						<td><b>邮箱：</b></td>
						<td><input name="zipCode" value="${learnClass.zipCode }" /></td>
					</tr>
					<tr>
						<td><b>住址：</b></td>
						<td><input name="address" value="${learnClass.address }" /></td>
					</tr>
					<tr>
						<td><b>区号：</b></td>
						<td><input name="areaCode" value="${learnClass.areaCode }" /></td>
					</tr>
					<tr>
						<td><b>是否开启：</b></td>
						<td><input type="checkbox" name="status" ${learnClass.status==true?"checked='checked'":''} /></td>
					</tr>
					<tr>
						<td colspan="2">
						<input class="button" type="submit" value="提交" />
					    <r:a href="/learnclass" class="button">取消</r:a></td>
					</tr>
				</tbody>

			</table>
		</form>
	</div>
</r:layout>