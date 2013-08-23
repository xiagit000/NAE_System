<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="r" tagdir="/WEB-INF/tags/r" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<r:layout title="结业管理" >
<jsp:include page="../layout/administrator_navbar.jsp" />
<div class="wrapper">
          <ul class="breadcrumb">
              <li><r:a href="/">首页</r:a> <span class="divider">/</span></li>
              <li class="active">结业管理</li>
            </ul>
   <table class="table table-hover" >
       <thead>
        <tr>
            <th>编号</th>
            <th>批次</th>
            <th>姓名</th>
            <th>证件号</th>
            <th>及格分数</th>
            <th>总得分</th>
            <th>结业状态</th>
            <th>操作</th>
        </tr>
       </thead>
       <tbody>
       <c:forEach items="${graduates}" var="graduate" varStatus="status">
       <tr>
       <td><span class="badge">${status.index+1}</span></td>
       <td>${graduate.grade.user.batch.code }-${graduate.grade.user.batch.name }</td>
       <td>${graduate.grade.user.account.name }</td>
       <td>${graduate.grade.user.account.idNumber}</td>
       <td>${graduate.graduateStandard.passScore }</td>
       <td>${graduate.grade.totalScore}</td>
       <td><fmt:message key="${graduate.graduateStatus }"/></td>
       <td>
       <c:if test="${graduate.graduateStatus=='NoGraduate' }">
       <r:a class="btn" href="/graduate/${graduate.id }/specialApprovalGraduated">特批结业</r:a>
       </c:if>
       <c:if test="${graduate.graduateStatus=='Special_Approval_Graduated' }">
       <r:a class="btn" href="/graduate/${graduate.id }/noGraduated">取消特批</r:a>
       </c:if>
       </td>
       </c:forEach>
       </tbody>
    </table>
    <div class="toolbar">
            <div class="pagination pagination-centered">
            <r:paginate data="${graduates}" />
            </div>
            </div>
</div>
</r:layout>