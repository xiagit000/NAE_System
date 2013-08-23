<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="r" tagdir="/WEB-INF/tags/r"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<r:layout title="评分标准">
	<r:javascript name="/resources/js/scoringStandard/add.js"></r:javascript>
	<jsp:include page="../layout/administrator_navbar.jsp" />
	<div class="wrapper">
		<ul class="breadcrumb">
			<li><r:a href="/">首页</r:a> <span class="divider">/</span></li>
			<li class="active">评分标准</li>
		</ul>
		<r:a href="/scoringStandard/new" class="button">添加</r:a>
		<br /> <br />
		<table class="table table-hover">
			<thead>
				<tr>
					<th>编号</th>
					<th>批次</th>
					<th>视频学习比重</th>
					<th>研修论文比重</th>
					<th>研修讨论比重</th>
					<th>平时成绩比重</th>
					<th>操作</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${scoringStandards}" var="scoringStandard" varStatus="status">
					<tr>
						<td><span class="badge">${status.index+1}</span></td>
						<td>${scoringStandard.batch.code }-${scoringStandard.batch.name }</td>
						<td>${scoringStandard.learnVideoProportion*100 }%</td>
						<td>${scoringStandard.learnThesisProportion*100 }%</td>
						<td>${scoringStandard.learnDiscussProportion*100 }%</td>
						<td>${scoringStandard.usuallyProportion*100 }%</td>
						<td><r:a href="/scoringStandard/${scoringStandard.id }/edit" class="btn">编辑</r:a> 
							<r:a href="/scoringStandard/${scoringStandard.id }" 
							data-method="delete" data-confirm="确定要删除吗？" class="btn">删除</r:a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</r:layout>