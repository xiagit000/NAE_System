<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="r" tagdir="/WEB-INF/tags/r" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<r:layout title="招生计划" >
<jsp:include page="../layout/administrator_navbar.jsp" />
<div class="wrapper">
          <ul class="breadcrumb">
              <li><r:a href="/">首页</r:a> <span class="divider">/</span></li>
              <li class="active">招生计划管理</li>
            </ul>
          <r:a href="/enrollmentplan/new" class="button">添加</r:a>
    <br/>
    <br/>
    <table class="table table-hover" >
       <thead>
        <tr>
            <th>编号</th>
            <th>培训批次</th>
            <th>班级</th>
            <th>招生人数</th>
            <th>已招收学生人数</th>
            <th>教学模式</th>
            <th>招生开始/结束时间</th>
            <th>学费</th>
            <th>操作</th>
        </tr>
       </thead>
       <tbody>
       <c:forEach items="${enrollmentPlans}" var="enrollmentPlan" varStatus="status">
       <tr>
       <td><span class="badge">${status.index+1}</span></td>
       <td>${enrollmentPlan.batch.name }</td>
       <td>${enrollmentPlan.learnClass.name }</td>
       <td>${enrollmentPlan.enrollmentNumber }</td>
       <td>${enrollmentPlan.existedUserNumber }</td>
       <td>${enrollmentPlan.learnModel=="Scholastic_Year_System"?"学年制":"学分制" }</td>
       <td>${enrollmentPlan.beginTime }/${enrollmentPlan.endTime }</td>
       <td>${enrollmentPlan.expense}</td>
       <td>
       <r:a href="/enrollmentplan/${enrollmentPlan.id }" class="btn">查看</r:a>
       <r:a href="/enrollmentplan/${enrollmentPlan.id }/edit" class="btn">编辑</r:a>
       <r:a href="/enrollmentplan/${enrollmentPlan.id }" data-method="delete" data-confirm="确定要删除吗？" class="btn">删除</r:a>
       </td></tr>
      
       </c:forEach>
       </tbody>
    </table>
    <div class="toolbar"><div class="pagination pagination-centered"><r:paginate data="${enrollmentPlans}"></r:paginate></div></div>
 </div>
</r:layout>