<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="r" tagdir="/WEB-INF/tags/r" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script src="<c:url value="/resources/js/jquery-1.8.2.js"/>" type="text/javascript"></script>
<script src="<c:url value="/resources/js/batch/add.js"/>" type="text/javascript"></script>
<script src="<c:url value="/resources/js/My97DatePicker/WdatePicker.js"/>" type="text/javascript"></script>

<r:layout title="新建站内信" >
         <ul class="breadcrumb">
              <li><r:a href="/">首页</r:a> <span class="divider">/</span></li>
              <li><r:a href="/notification/receivernotification">站内信</r:a> <span class="divider">/</span></li>
              <li class="active">发私信</li>
          </ul>
            
         <form id="add_form" action="<c:url value='/notification' />" method="post">
         <table class="table table-hover" >
         <tbody>
         <tr><td width="100px"><b>收件人：</b></td>
         <td><input name="receiverId" value=""/></td></tr>
         
         <tr><td width="100px"><b>主题：</b></td>
         <td><input name="message" value="${notification.message }"/></td></tr>
        
         <tr><td width="100px"><b>内容：</b></td>
         <td><textarea name="details">${notification.details }</textarea></td></tr>
		 </tbody>
         </table>
         
         <input class="btn btn-primary" type="submit" value="提交"/>
         &nbsp;&nbsp;
         <r:a href="/notification" class="btn">取消</r:a>
        
       </form>
    

</r:layout>