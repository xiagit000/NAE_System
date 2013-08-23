<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="r" tagdir="/WEB-INF/tags/r" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<r:layout title="培训批次编辑" >
<r:javascript name="/resources/js/batch/add.js"></r:javascript>
         <ul class="breadcrumb">
              <li><r:a href="/">首页</r:a> <span class="divider">/</span></li>
              <li><r:a href="/batch">培训批次管理</r:a> <span class="divider">/</span></li>
              <li class="active">培训批次编辑</li>
          </ul>
            
         <form id="add_form" action="<c:url value='/batch/${batch.id }' />" method="post">
         <input type="hidden" name="_method" value="PUT"/>
         <input type="hidden" name="id" value="${batch.id }"/>
         <table class="table table-hover" >
         <tbody>
         <tr><td><b>招生批次代码：</b><input name="code" value="${batch.code }"/></td></tr>
         <tr><td><b>招生批次名称：</b><input name="name" value="${batch.name }"/></td></tr>
         <tr><td><b>招生开始日期：</b><input name="beginTime" value="${batch.beginTime }" onclick="WdatePicker()" placeholder="点击选择日期" readonly/>
         <b>招生截止日期：</b><input name="endTime" value="${batch.endTime }" onclick="WdatePicker()" placeholder="点击选择日期" readonly/></td></tr>
         <tr><td><b>备注：</b><textarea name="description">${batch.description }</textarea></td></tr>
         </tbody>
         </table>

         <input class="btn btn-primary" type="submit" value="提交"/>
         &nbsp;&nbsp;
         <r:a href="/batch" class="btn">取消</r:a>
         </form>
</r:layout>