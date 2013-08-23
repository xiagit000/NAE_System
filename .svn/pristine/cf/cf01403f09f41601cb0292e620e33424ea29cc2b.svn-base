<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="r" tagdir="/WEB-INF/tags/r" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script src="<c:url value="/resources/js/jquery-1.8.2.js"/>" type="text/javascript"></script>
<script src="<c:url value="/resources/js/application.js"/>" type="text/javascript"></script>

<r:layout title="公告信息" >
          <ul class="breadcrumb">
              <li><r:a href="/">首页</r:a> <span class="divider">/</span></li>
              <li class="active">公告管理</li>
            </ul>
          <r:a href="/announcement/new" class="btn btn-large btn-primary disabled">添加</r:a>
    <br/>
    <br/>
    <table class="table table-hover" >
       <thead>
        <tr>
            <th>编号</th>
            <th>发布时间</th>
            <th>公告主题</th>
            
        </tr>
       </thead>
       <tbody>
       <c:forEach items="${systemAnnouncements}" var="announcement" varStatus="status">
       <tr>
       <td><span class="badge">${status.index+1}</span></td>
       <td>${announcement.time }</td>
       <td>${announcement.name }</td>
      
       <td><r:a href="/announcement/${announcement.id }" class="btn">查看</r:a>
       <r:a href="/announcement/${announcement.id }/edit" class="btn">编辑</r:a>
       <r:a href="/announcement/${announcement.id }" data-method="delete" data-confirm="确定要删除吗？" class="btn">删除</r:a></td>
       </tr>
       </c:forEach>
       </tbody>
    </table>
   
</r:layout>