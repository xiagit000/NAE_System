<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="r" tagdir="/WEB-INF/tags/r" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<r:layout title="成绩管理" >
<jsp:include page="../layout/administrator_navbar.jsp" />
<div class="wrapper">
          <ul class="breadcrumb">
              <li><r:a href="/">首页</r:a> <span class="divider">/</span></li>
              <li class="active">成绩管理</li>
            </ul>
    <table class="table table-hover" >
       <thead>
        <tr>
            <th>编号</th>
            <th>批次</th>
            <th>姓名</th>
            <th>证件号</th>
            <th>视频学习总分/得分</th>
            <th>研修论文总分/得分</th>
            <th>研修讨论总分/得分</th>
            <th>平时成绩总分/得分</th>
        </tr>
       </thead>
       <tbody>
       <c:forEach items="${grades}" var="grade" varStatus="status">
       <tr>
       <td><span class="badge">${status.index+1}</span></td>
       <td>${grade.user.batch.code }-${grade.user.batch.name }</td>
       <td>${grade.user.account.name }</td>
       <td>${grade.user.account.idNumber}</td>
       <td>${grade.scoringStandard.learnVideoProportion*100}/${grade.learnVideoScore}</td>
       <td>${grade.scoringStandard.learnThesisProportion*100}/${grade.learnThesisScore}</td>
       <td>${grade.scoringStandard.learnDiscussProportion*100}/${grade.learnDiscussScore}</td>
       <td>${grade.scoringStandard.usuallyProportion*100}/${grade.usuallyScore}</td>
       </c:forEach>
       </tbody>
    </table>
    <div class="toolbar">
            <div class="pagination pagination-centered">
            <r:paginate data="${grades}" />
            </div>
            </div>
 </div>
</r:layout>