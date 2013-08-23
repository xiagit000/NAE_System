<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="r" tagdir="/WEB-INF/tags/r" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script src="<c:url value="/resources/js/jquery-1.8.2.js"/>" type="text/javascript"></script>
<script src="<c:url value="/resources/js/batch/add.js"/>" type="text/javascript"></script>
<script src="<c:url value="/resources/js/My97DatePicker/WdatePicker.js"/>" type="text/javascript"></script>

<r:layout title="公告编辑" >
         <ul class="breadcrumb">
              <li><r:a href="/">首页</r:a> <span class="divider">/</span></li>
              <li><r:a href="/announcement">公告管理</r:a> <span class="divider">/</span></li>
              <li class="active">公告编辑</li>
          </ul>
            
         <form id="add_form" action="<c:url value='/announcement/${announcement.id }' />" method="post">
         <input type="hidden" name="_method" value="PUT"/>
         <input type="hidden" name="id" value="${announcement.id }"/>
         <table class="table table-hover" >
         <tbody>
         <tr><td><b>公告主题：</b><input name="name" value="${announcement.name }"/></td></tr>
         <tr><td><b>公告内容：</b><textarea name="details">${announcement.details }</textarea></td></tr>
        
         </tbody>
         </table>
         <input class="btn btn-primary" type="submit" value="提交"/>
         &nbsp;&nbsp;
         <r:a href="/announcement" class="btn">取消</r:a>
         </form>
</r:layout>