<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="r" tagdir="/WEB-INF/tags/r"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<r:layout title="学生成绩导出">
	<jsp:include page="../layout/administrator_navbar.jsp" />
	<div class="wrapper">
		<ul class="breadcrumb">
			<li><r:a href="/">首页</r:a> <span class="divider">/</span></li>
			<li class="active">学生成绩导出</li>
		</ul>

		<form action="<c:url value='/gradequeryandexport/query' />" name="form-search" id="form-search" method="get">
			<table class="table table-hover">
				<tbody>
                    <tr><td width="100px">批次：</td>
	                    <td> <select name="batchId">
	                    <option value="0">全部</option>
	                    <c:forEach items="${batchs }" var="batch">
	                    <option value="${batch.id}" ${batch.id eq currentBatch.id?'selected=selected':''}>
	                    ${batch.code }-${batch.name }
	                    </option>
	                    </c:forEach>
	                    </select> </td>
	                    
	                    <td width="100px">班级：</td>
	                    <td> <select name="learnClassId">
	                    <option value="0">全部</option>
	                    <c:forEach items="${learnClasses }" var="learnClass">
	                    <option value="${learnClass.id}" ${learnClass.id eq learnClassId?'selected=selected':''}>
	                     ${learnClass.code }_${learnClass.allName } </option>
	                    </c:forEach>
	                    </select> </td>
	                    <td><input class="btn_search" type="submit" value="查询"> </td>
                    </tr>
				</tbody>
			</table>
		</form>
		
		<c:if test="${fn:length(grades) != 0}">
		<r:a class="button" href="/gradequeryandexport/export?${params}">数据导出</r:a>
		<r:table data="${grades}" var="grade" class="table table-hover"
				varStatus="status">
				<r:col header="编号">${status.count}</r:col>
				<r:col header="批次">${grade.user.batch.code}-${grade.user.batch.name}</r:col>
				<r:col header="账号">${grade.user.loginName}</r:col>
				<r:col header="姓名">${grade.user.realName}</r:col>
				<r:col header="视频学习成绩">${grade.learnVideoScore}</r:col>
				<r:col header="研修论文成绩">${grade.learnThesisScore}</r:col>
				<r:col header="研修讨论成绩">${grade.learnDiscussScore}</r:col>
				<r:col header="平时成绩">${grade.usuallyScore}</r:col>
	    </r:table>

		<div class="toolbar">
                <div class="pagination pagination-centered">
                    <r:paginate data="${grades}" />
                </div>
            </div>	

		</c:if>
	</div>
</r:layout>