<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="r" tagdir="/WEB-INF/tags/r" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<r:layout title="更新招生计划" >
<r:javascript name="/resources/js/enrollmentPlan/add.js"></r:javascript>

          <ul class="breadcrumb">
              <li><r:a href="/">首页</r:a> <span class="divider">/</span></li>
              <li><r:a href="/enrollmentplan">招生计划</r:a> <span class="divider">/</span></li>
              <li class="active">更新招生计划</li>
            </ul>
         <form id="add_form" action="<c:url value='/enrollmentplan/${enrollmentPlan.id }' />" method="POST">
         <input type="hidden" name="_method" value="PUT"/>
         <input type="hidden" name="id" value="${enrollmentPlan.id }"/>
         <table class="table table-hover" >
         <tbody>
         <tr><td><b>计划招生人数：</b><input name="enrollmentNumber" value="${enrollmentPlan.enrollmentNumber }"/></td></tr>
         <tr><td><b>教学模式：</b>
         <select name="learnModel">
          <option value="Scholastic_Year_System" ${enrollmentPlan.learnModel=="Scholastic_Year_System"?"selected='selected'":"" }>学年制</option>
          <option value="Credit_System" ${enrollmentPlan.learnModel=="Credit_System"?"selected='selected'":"" }>学分制</option>
         </select>
         </td></tr>
         <tr><td><b>培训批次：</b>
         <select name="batchId">
         <c:forEach items="${batchs }" var="batch" varStatus="status">
          <option value="${batch.id }" ${enrollmentPlan.batch.id==batch.id?"selected='selected'":"" }>${batch.name }</option>
          </c:forEach>
         </select>
         </td></tr>
         <tr><td><b>班级：</b>
         <select name="classId">
          <c:forEach items="${classes }" var="class" varStatus="status">
          <option value="${class.id }" ${enrollmentPlan.learnClass.id==class.id?"selected='selected'":"" }>${class.name }</option>
          </c:forEach>
         </select>
         </td></tr>
          <tr><td><b>招生开始日期：</b><input name="beginTime" value="${enrollmentPlan.beginTime }"  onclick="WdatePicker()" placeholder="点击选择日期" readonly/>
         <b>招生截止日期：</b><input name="endTime" value="${enrollmentPlan.endTime }"  onclick="WdatePicker()" placeholder="点击选择日期" readonly/></td></tr>
         <tr><td><b>是否收费：</b><input type="checkbox" id=pay name="pay" ${enrollmentPlan.pay==true?"checked='checked'":''}/></td></tr>
         <tr><td><b>金额：</b><input name="expense" id="expense" value="${enrollmentPlan.expense }"/></td></tr>
         <tr><td><b>备注：</b><textarea name="description">${enrollmentPlan.description }</textarea></td></tr>
         </tbody>
         </table>

         <input class="btn btn-primary" type="submit" value="提交"/>
         &nbsp;&nbsp;
         <r:a href="/enrollmentplan" class="btn">取消</r:a>
         </form>
</r:layout>