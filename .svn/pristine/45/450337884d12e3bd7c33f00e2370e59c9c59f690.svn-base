<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="r" tagdir="/WEB-INF/tags/r" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<r:layout title="查看培训区域" >
<jsp:include page="../layout/administrator_navbar.jsp" />
<div class="wrapper">
         <ul class="breadcrumb">
              <li><r:a href="/">首页</r:a> <span class="divider">/</span></li>
              <li><r:a href="/learnArea">培训区域管理</r:a> <span class="divider">/</span></li>
              <li class="active">查看培训区域</li>
          </ul>
            
         <input id="name" name="name" type="hidden" value="${learnArea.name }"/>
         <input id="elCode" name="elCode" type="hidden" value="${learnArea.elCode }"/>
         
         <table class="table table-hover" >
         <tbody>
         <tr><td width="100"><b>招生区域名称：</b></td>
         <td>${learnArea.name }</td></tr>
         <tr><td><b>负责人姓名：</b></td>
         <td>${learnArea.personIncharge }</td></tr>
         <tr><td><b>住址：</b></td>
         <td>${learnArea.address }</td></tr>
         <tr><td><b>电话：</b></td>
         <td>${learnArea.tel }</td></tr>
         <tr><td><b>邮箱：</b></td>
         <td>${learnArea.email }</td></tr>
         <tr><td><b>邮政编码：</b></td>
         <td>${learnArea.zipCode }</td></tr>
         <tr><td><b>是否开启：</b></td>
         <td><input type="checkbox" name="status" ${learnArea.status==true?'checked="checked"':""} disabled="disabled"/></td></tr>
         <tr>
         	<td colspan="2">
         		  <r:a href="/learnArea/${learnArea.id }/edit" class="button">编辑</r:a>
         		  <r:a href="/learnArea" class="button">返回</r:a>
         	</td>
         </tr>
         </tbody>
         </table>
</div>
       
</r:layout>