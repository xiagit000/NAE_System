<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="r" tagdir="/WEB-INF/tags/r" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<r:layout title="培训区域 | 已存在的省列表" >
<jsp:include page="../../layout/administrator_navbar.jsp" />
<div class="wrapper">

          <ul class="breadcrumb">
              <li><r:a href="/">首页</r:a> <span class="divider">/</span></li>
              <li><r:a href="/learnArea">培训区域列表</r:a> <span class="divider">/</span></li>
              <li class="active">当前已存在的省份列表</li>
            </ul>
    <table class="table table-hover" >
       <thead>
        <tr>
            <th>编号</th>
            <th>区域名称</th>
            <th>操作</th>
        </tr>
       </thead>
       <tbody>
       <c:forEach items="${areas}" var="area" varStatus="status">
       <tr>
       <td><span class="badge">${status.index+1}</span></td>
       <td>${area.name }</td>
       <td>
       		<r:a href="/city/${area.id}/personincharge/create" class="btn">添加省督导员</r:a>
       		<r:a href="/city/${area.id}/personincharge" class="btn">查看省督导员信息</r:a>
      	</td></tr>
       </c:forEach>
       </tbody>
    </table>
</div>
</r:layout>