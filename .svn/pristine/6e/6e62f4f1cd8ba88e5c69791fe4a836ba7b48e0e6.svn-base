<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="r" tagdir="/WEB-INF/tags/r" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script src="<c:url value="/resources/js/jquery-1.8.2.js"/>" type="text/javascript"></script>

<r:layout title="站内信管理" >
          <ul class="breadcrumb">
              <li><r:a href="/">首页</r:a> <span class="divider">/</span></li>
              <li><r:a href="/notification">站内信管理</r:a> <span class="divider">/</span></li>
              <li class="active">查看站内信</li>
            </ul>
         <table class="table table-hover" >
         <tbody>
         <tr><td><b>主题：</b>${notification.message }</td></tr>
         <tr><td><b>发布时间：</b>${notification.time}</td></tr> 
         <tr><td><b>收件人：</b>${notification.receiver.id }</td></tr>  
        
         <tr><td><b>发件人：</b>${notification.sender.id }</td></tr> 
         <tr><td><b>内容：</b>${notification.details }</td></tr>
         
         </tbody>
         </table>

         <r:a href="/notification/${notification.id }/edit" class="btn">回复</r:a>
         &nbsp;&nbsp;
         <r:a href="/notification" class="btn">取消</r:a>
         </form>
</r:layout>