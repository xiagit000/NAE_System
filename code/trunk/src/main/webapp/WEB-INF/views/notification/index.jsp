<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="r" tagdir="/WEB-INF/tags/r" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script src="<c:url value="/resources/js/jquery-1.8.2.js"/>" type="text/javascript"></script>
<script src="<c:url value="/resources/js/application.js"/>" type="text/javascript"></script>

<r:layout title="站内信" >
          <ul class="breadcrumb">
              <li><r:a href="/">首页</r:a> <span class="divider">/</span></li>
              <li class="active">站内信管理</li>
            </ul>
          <r:a href="/notification/new" class="btn btn-large btn-primary disabled">新建站内信</r:a>
          
 
    <br/>
    <br/>
    <table class="table table-hover" >
       <thead>
        <tr>
            <th>编号</th>
            <th>时间</th>
            <th>主题</th>
            
        </tr>
       </thead>
       <tbody>
       <c:forEach items="${notifications}" var="notification" varStatus="status">
       <tr>
       <td><span class="badge">${status.index+1}</span></td>
       <td>${notification.time }</td>
       <td>${notification.message }</td>
      
       <td><r:a href="/notification/${notification.id }" class="btn">查看</r:a>
       <r:a href="/notification/${notification.id }/edit" class="btn">回复</r:a>
       <r:a href="/notification/${notification.id }" data-method="delete" data-confirm="确定要删除吗？" class="btn">删除</r:a></td>
       </tr>
       </c:forEach>
       </tbody>
    </table>
   
</r:layout>