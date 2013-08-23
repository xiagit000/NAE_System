<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="r" tagdir="/WEB-INF/tags/r" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<r:layout title="查看招生计划" >
<r:javascript name="/resources/js/enrollmentPlan/add.js"></r:javascript>
<jsp:include page="../layout/administrator_navbar.jsp" />
<div class="wrapper">

          <ul class="breadcrumb">
              <li><r:a href="/">首页</r:a> <span class="divider">/</span></li>
              <li><r:a href="/enrollmentplan">招生计划</r:a> <span class="divider">/</span></li>
              <li class="active">查看招生计划</li>
            </ul>
         <table class="table table-hover" >
         <tbody>
         <tr><td width="150"><b>计划招生人数：</b></td>
         <td>${enrollmentPlan.enrollmentNumber }</td></tr>
         <tr><td><b>教学模式：</b></td>
         <td>${enrollmentPlan.learnModel=="Credit_System"?"学分制":"学年制" }
         </td></tr>
         <tr><td><b>培训批次：</b></td>
          <td>${enrollmentPlan.batch.name}
         </td></tr>
         <tr><td><b>班级：</b></td>
        <td>${enrollmentPlan.learnClass.name }
         </td></tr>
          <tr><td><b>招生开始/结束日期：</b></td>
          <td>${enrollmentPlan.beginTime }/${enrollmentPlan.endTime }</td></tr>
         <tr><td><b>是否收费：</b></td>
         <td>${enrollmentPlan.pay==true?"是":'否'}</td></tr>
         <tr><td><b>金额：</b></td>
         <td>${enrollmentPlan.expense }</td></tr>
         <tr><td><b>备注：</b></td>
         <td>${enrollmentPlan.description }</td></tr>
         <tr>
         	<td colspan="2">
         		 <r:a href="/enrollmentplan/${enrollmentPlan.id }/edit" class="button">编辑</r:a>
        
         <r:a href="/enrollmentplan" class="button">返回</r:a>
         	</td>
         </tr>
         </tbody>
         </table>
     
 </div>
</r:layout>