<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="r" tagdir="/WEB-INF/tags/r" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script src="<c:url value="/resources/js/jquery-1.8.2.js"/>" type="text/javascript"></script>

<r:layout title="更新公告" >
          <ul class="breadcrumb">
              <li><r:a href="/">首页</r:a> <span class="divider">/</span></li>
              <li><r:a href="/announcement">公告管理</r:a> <span class="divider">/</span></li>
              <li class="active">查看公告</li>
            </ul>
         <table class="table table-hover" >
         <tbody>
         <tr><td><b>公告名称：</b>${announcement.name }</td></tr>
         <tr><td><b>发布时间：</b>${announcement.time}</td></tr>    
         <tr><td><b>公告内容：</b>${announcement.details }</td></tr>
         <c:if test="${announcement.attachment!=null}">
            <tr><td><b>附件：</b><r:a href="/announcement/${announcement.id}/download" >${announcement.attachment.fileName}</r:a></td></tr>
         </c:if>
         
         </tbody>
         </table>

         <r:a href="/announcement/${announcement.id }/edit" class="btn">編輯</r:a>
         &nbsp;&nbsp;
         <r:a href="/announcement" class="btn">取消</r:a>
         </form>
</r:layout>