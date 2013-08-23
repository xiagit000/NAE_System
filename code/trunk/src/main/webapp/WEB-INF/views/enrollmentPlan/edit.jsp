<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="r" tagdir="/WEB-INF/tags/r" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<r:layout title="更新招生计划" >
<r:javascript name="/resources/js/enrollmentPlan/add.js"></r:javascript>
<jsp:include page="../layout/administrator_navbar.jsp" />
<div class="wrapper">
          <ul class="breadcrumb">
              <li><r:a href="/">首页</r:a> <span class="divider">/</span></li>
              <li><r:a href="/enrollmentplan">招生计划</r:a> <span class="divider">/</span></li>
              <li class="active">更新招生计划</li>
            </ul>
         <form id="add_form" action="<c:url value='/enrollmentplan/${enrollmentPlan.id }' />" method="POST">
         <input type="hidden" name="_method" value="PUT"/>
         <input type="hidden" name="id" value="${enrollmentPlan.id }"/>
         <input type="hidden" name="batchId" value="${enrollmentPlan.batch.id }"/>
         <input type="hidden" name="classId" value="${enrollmentPlan.learnClass.id }"/>
         <table class="table table-hover" >
         <tbody>
         <tr><td width="100"><b>计划招生人数：</b></td>
         <td><input name="enrollmentNumber" value="${enrollmentPlan.enrollmentNumber }"/></td></tr>
         <tr><td><b>教学模式：</b></td>
         <td><select name="learnModel">
          <option value="Scholastic_Year_System" ${enrollmentPlan.learnModel=="Scholastic_Year_System"?"selected='selected'":"" }>学年制</option>
          <option value="Credit_System" ${enrollmentPlan.learnModel=="Credit_System"?"selected='selected'":"" }>学分制</option>
         </select>
         </td></tr>
         <tr><td><b>培训批次：</b></td>
         <td>${enrollmentPlan.batch.code }-${enrollmentPlan.batch.name }
         </td></tr>
         <tr><td><b>班级：</b></td>
         <td>${enrollmentPlan.learnClass.allName }
         </td></tr>
          <tr><td><b>招生开始日期：</b></td>
          <td><input name="beginTime" value="${enrollmentPlan.beginTime }"  onclick="WdatePicker()" placeholder="点击选择日期" readonly/>
          </td>
          </tr>
          <tr>
          	<td><b>招生截止日期：</b></td>
          	<td><input name="endTime" value="${enrollmentPlan.endTime }"  onclick="WdatePicker()" placeholder="点击选择日期" readonly/></td>
          </tr>
         
         <tr><td><b>是否收费：</b></td>
         <td><input type="checkbox" id=pay name="pay" ${enrollmentPlan.pay==true?"checked='checked'":''}/></td></tr>
         <tr><td><b>金额：</b></td>
         <td><input name="expense" id="expense" value="${enrollmentPlan.expense }"/></td></tr>
         <tr><td colspan="2"><b>备注：</b></td></tr>
         <tr>
         	<td colspan="2">
         	<textarea name="description" cols="100" rows="10">${enrollmentPlan.description }</textarea>
         	</td>
         </tr>
         </tbody>
         </table>

         <input class="button" type="submit" value="提交"/>
         &nbsp;&nbsp;
         <r:a href="/enrollmentplan" class="button">取消</r:a>
         </form>
 </div>
</r:layout>