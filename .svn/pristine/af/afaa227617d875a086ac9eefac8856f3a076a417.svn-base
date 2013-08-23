<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="r" tagdir="/WEB-INF/tags/r" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script src="<c:url value="/resources/js/jquery-1.8.2.js"/>" type="text/javascript"></script>
<script src="<c:url value="/resources/js/application.js"/>" type="text/javascript"></script>
<link rel="stylesheet" href="<c:url value='/resources/css/notification/notification.css'/>" type="text/css"/>

<r:layout title="站内信" >
          <ul class="breadcrumb">
              <li><r:a href="/">首页</r:a> <span class="divider">/</span></li>
              <li><r:a href="/notification/receivernotification">站内信</r:a> <span class="divider">/</span></li>
              <li class="active">收件箱</li>
            </ul>
          <r:a href="/notification/sendernotification/new" class="button" style="float:right;color:white">发私信</r:a>

    <ul class="tabs">
      <li class="tab_active"><r:a href="#">收件箱</r:a></li>
      <li><r:a href="/notification/sendernotification">发件箱</r:a></li>
    </ul>
    <table class="table table-hover" >
       <thead>
        <tr>
            <th>选择</th>
            <th>编号</th>
            <th>发件人</th>
            <th>主题</th>
            <th>时间</th>
        </tr>
       </thead>
       <tbody>
       <tr>
            <td width="200px">
            <input type="checkbox" name=""/>全选
            <r:a href="#" class="button">删除</r:a>
            </td>
            <td colspan="4" ></td>
        </tr>
       <c:forEach items="${notifications}" var="notification" varStatus="status">
       <tr>
       <td><span class="badge">${status.index+1}</span></td>
       <td>${notification.time }</td>
       <td>${notification.message }</td>
       <td>${notification.time }</td>
      
       <td><r:a href="/notification/${notification.id }" class="btn">查看</r:a>
       <r:a href="/notification/${notification.id }/edit" class="btn">回复</r:a>
       <r:a href="/notification/${notification.id }" data-method="delete" data-confirm="确定要删除吗？" class="btn">删除</r:a></td>
       </tr>
       </c:forEach>
       </tbody>
    </table>
   
</r:layout>