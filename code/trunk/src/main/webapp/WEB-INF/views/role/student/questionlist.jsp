<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="r" tagdir="/WEB-INF/tags/r"%>

<r:layout title="我的提问列表">
<jsp:include page="../../layout/student_navbar.jsp" />
<div class="wrapper">
	<ul class="breadcrumb">
		<li><r:a href="/">首页</r:a> <span class="divider">/</span></li>
		<li class="active">我的提问列表</li>
	</ul>
	<r:a href="/question/create" class="button">我要提问</r:a>
	<br />
	<br/>
	 <table class="table table-hover" >
     	<tr>
     		<th>编号</th>
     		<th>问题</th>
     		<th>是否已解答</th>
     		<th>解答人</th>
     	</tr>
     	<c:forEach items="${questionList}" var="question" varStatus="status">
     		<tr>
     			<td><span class="badge">${status.index+1}</span></td>
     			<td><r:a href="/question/${question.id}">${question.askTitle}</r:a></td>
     			<td>
     				<c:if test="${question.resolved}">已解答</c:if>
     				<c:if test="${!question.resolved}">未解答</c:if>
     			</td>
     			<td>
     				${question.resolver.realName}
     			</td>
     		</tr>
     		
     	</c:forEach>
     </table>
     <div class="toolbar"><div class="pagination pagination-centered"><r:paginate data="${questionList}"></r:paginate></div></div>
</div>
</r:layout>