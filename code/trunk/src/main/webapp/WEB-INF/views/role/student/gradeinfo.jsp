<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="r" tagdir="/WEB-INF/tags/r"%>

<r:layout title="查看成绩信息">
<jsp:include page="../../layout/student_navbar.jsp" />
<div class="wrapper">
	<ul class="breadcrumb">
		<li><r:a href="/">首页</r:a> <span class="divider">/</span></li>
		<li class="active">我的成绩信息</li>
	</ul>
	 <table class="table table-hover" >
         <tbody>
         	<tr>
         		<th width="250">在线时长/有效时长</th>
         	</tr>
         	<tr>
         		<td>${grade.onlineTimeCount}/${grade.effectiveTimeCount}</td>
         	</tr>
         	<tr>
         		<th width="250">视频总分/已完成</th>
         	</tr>
         	<tr>
         		<td>${grade.scoringStandard.learnVideoProportion*100}/${grade.learnVideoScore}</td>
         	</tr>
         	<tr>
         		<th>研修讨论总分/已完成</th>
         	</tr>
         	<tr>
         		<td>${grade.scoringStandard.learnDiscussProportion*100}/${grade.learnDiscussScore}</td>
         	</tr>
         	<tr>
         		<th>研修论文总分/已完成</th>
         	</tr>
         	<tr>
         		<td>${grade.scoringStandard.learnThesisProportion*100}/${grade.learnThesisScore}</td>
         	</tr>
         	<tr>
         		<th>当前总分</th>
         	</tr>
         	<tr><td>${grade.totalScore}</td></tr>
         </tbody>
         </table>
</div>
</r:layout>