<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="r" tagdir="/WEB-INF/tags/r" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<r:javascript name="/resources/js/batch/add.js"></r:javascript>

<r:layout title="培训批次添加" >
<jsp:include page="../layout/administrator_navbar.jsp" />
		<div class="wrapper">
			 <ul class="breadcrumb">
	              <li><r:a href="/">首页</r:a> <span class="divider">/</span></li>
	              <li><r:a href="/batch">培训批次管理</r:a> <span class="divider">/</span></li>
	              <li class="active">培训批次添加</li>
          	</ul>
          	<form id="add_form" action="<c:url value='/batch' />" method="POST">
		         <table class="table">
		         	<tbody>
		         		<tr>
		         			<td width="100"><b>招生批次代码：</b></td>
		         			<td><input name="code" value="${batch.code }"/>*</td>
		         		</tr>
		         		<tr>
		         			<td><b>招生批次名称：</b></td>
		         			<td><input name="name" value="${batch.name }"/>*</td>
		         		</tr>
		         		<tr>
		         			<td><b>招生开始日期：</b></td>
		         			<td><input name="beginTime"  onclick="WdatePicker()" placeholder="点击选择日期" readonly/></td>
		         		</tr>
		         		<tr>
		         			<td><b>招生截止日期：</b></td>
		         			<td><input name="endTime"  onclick="WdatePicker()" placeholder="点击选择日期" readonly/>*</td>
		         		</tr>
		         		<tr>
		         			<td><b>备注：</b></td>
		         			<td><textarea name="description">${batch.description }</textarea></td></tr>
		         		<tr>
		         			<td colspan="2">
		         			<input type="submit" class="button" value="提交"/>
	        				<r:a href="/batch" class="button">取消</r:a>
		         		</td></tr>
		         	</tbody>
		         </table>

	         	
        	 </form>
		</div>
		 
		
</r:layout>