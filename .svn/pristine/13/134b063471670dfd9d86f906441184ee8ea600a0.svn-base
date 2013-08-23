<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="r" tagdir="/WEB-INF/tags/r"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<r:layout title="评分标准添加">
	<r:javascript name="/resources/js/scoringStandard/add.js"></r:javascript>
	<jsp:include page="../layout/administrator_navbar.jsp" />
	<div class="wrapper">
		<ul class="breadcrumb">
			<li><r:a href="/">首页</r:a> <span class="divider">/</span></li>
			<li><r:a href="/scoringStandard">培训批次管理</r:a> <span class="divider">/</span></li>
			<li class="active">评分标准添加</li>
		</ul>

		<form id="add_form" name="add_form"
			action="<c:url value='/scoringStandard' />" method="POST">
			<table class="table table-hover">
				<tbody>
					<tr>
						<th width="150px">批次：</th>
						<td><select name="batchId">
								<c:forEach items="${batchs }" var="batch" varStatus="status">
									<option value="${batch.id }">${batch.code}-${batch.name }</option>
								</c:forEach>
						</select></td>
					</tr>
					<tr>
						<th width="150px">视频学习比重：</th>
						<td><input name="learnVideoProportion"
							id="learnVideoProportion"
							value="<fmt:formatNumber value='${scoringStandard.learnVideoProportion*100 }' type='number'/>" /></td>
					</tr>
					<tr>
						<th width="150px">研修论文比重：</th>
						<td><input name="learnThesisProportion"
							id="learnThesisProportion"
							value="<fmt:formatNumber value='${scoringStandard.learnThesisProportion*100 }' type='number'/>" /></td>
					</tr>
					<tr>
						<th width="150px">研修讨论比重：</th>
						<td><input name="learnDiscussProportion"
							id="learnDiscussProportion"
							value="<fmt:formatNumber value='${scoringStandard.learnDiscussProportion*100 }' type='number'/>" /></td>
					</tr>
					<tr>
						<th width="150px">平时成绩比重：</th>
						<td><input name="usuallyProportion" id="usuallyProportion"
							value="<fmt:formatNumber value='${scoringStandard.usuallyProportion*100 }' type='number'/>" /></td>
					</tr>
					<tr>
						<td colspan="2">
						<input class="button" type="submit" id="submit" value="提交" />
						 <r:a href="/scoringStandard" class="button">取消</r:a>
						</td>
					</tr>
				</tbody>
			</table>


		</form>
	</div>
</r:layout>