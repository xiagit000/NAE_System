<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="r" tagdir="/WEB-INF/tags/r" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<r:layout title="国培用户信息批量导入" >
<jsp:include page="../../../layout/administrator_navbar.jsp" />
	<div class="wrapper">
           <ul class="breadcrumb">
              <li><r:a href="/">首页</r:a> <span class="divider">/</span></li>
              <li><r:a href="/account">国培用户信息管理</r:a> <span class="divider">/</span></li>
              <li><r:a href="/account/bulkImport">批量导入用户信息</r:a> <span class="divider">/</span></li>
              <li class="active">导入方式一</li>
            </ul>
    <form  id="readReportForm" action="<c:url value='/account/bulkImport/methodOne' />" method="post" enctype="multipart/form-data"  > 
       <table class="table table-hover" >
        <tr><th width="100px">招生计划：</th>
        <td>
        <select name="enrollmentPlanId">
        <c:forEach items="${enrollmentPlans }" var="enrollmentPlan" varStatus="status">
        <option value="${enrollmentPlan.id }">${enrollmentPlan.batch.name }-${enrollmentPlan.learnClass.name }</option>
        </c:forEach>
        </select>
        </td>
        </tr>
        <tr><th width="100px">选择文件：</th><td><input class id="file" type="file" name="file" /></td></tr>
        </table>   
       <p><input class="button" type="submit" value="导入数据">
       <r:a class="button" href="/account/bulkImport">取消</r:a>
       </p>
    </form> 
</div>
</r:layout>