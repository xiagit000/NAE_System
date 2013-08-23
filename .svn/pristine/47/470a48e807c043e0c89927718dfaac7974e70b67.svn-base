<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="r" tagdir="/WEB-INF/tags/r"%>

<r:layout title="班级信息">
<jsp:include page="../../layout/student_navbar.jsp" />
<div class="wrapper">
	<ul class="breadcrumb">
		<li><r:a href="/">首页</r:a> <span class="divider">/</span></li>
		<li class="active">班级信息</li>
	</ul>
	 <table class="table table-hover" >
         <tbody>
         <tr><td width="150"><b>班级代码：</b></td>
         <td>${learnClass.code }</td></tr>
         <tr><td><b>班级名称：</b></td>
         <td>${learnClass.name }</td></tr>
         <tr><td><b>班级全名：</b></td>
         <td>${learnClass.allName }</td></tr>
         <tr><td><b>培训区域：</b></td>
         <td>${learnClass.learnArea.name }
         </td></tr>
         <tr><td><b>培训项目：</b></td>
         <td>${learnClass.learnProject.name }
         </td></tr>
         <tr><td><b>负责人：</b></td>
         <td>${learnClass.personIncharge }</td></tr>
         <tr><td><b>电话：</b></td>
         <td>${learnClass.tel }</td></tr>
         <tr><td><b>邮箱：</b></td>
         <td>${learnClass.zipCode }</td></tr>
         <tr><td><b>住址：</b></td>
         <td>${learnClass.address }</td></tr>
         <tr><td><b>区号：</b></td>
         <td>${learnClass.areaCode }</td></tr>
         <tr><td><b>是否开启：</b></td>
         <td><input type="checkbox" name="status" ${learnClass.status==true?'checked="checked"':""} disabled="disabled"/></td></tr>
         </tbody>
         </table>
</div>
</r:layout>