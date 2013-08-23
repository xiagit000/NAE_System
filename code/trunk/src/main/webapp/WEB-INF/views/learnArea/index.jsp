<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="r" tagdir="/WEB-INF/tags/r" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<r:layout title="培训区域" >
<jsp:include page="../layout/administrator_navbar.jsp" />
<div class="wrapper">

          <ul class="breadcrumb">
              <li><r:a href="/">首页</r:a> <span class="divider">/</span></li>
              <li class="active">培训区域管理</li>
            </ul>
          <r:a href="/learnArea/new" class="button">添加</r:a>
           <r:a href="/learnArea/showexsitprovice" class="button">省督导</r:a>
    <br/>
    <br/>
    <table class="table table-hover" >
       <thead>
        <tr>
            <th>编号</th>
            <th>区域代码</th>
            <th>区域名称</th>
            <th>负责人</th>
            <th>住址</th>
            <th>电话</th>
            <th>是否开启</th>
            <th>操作</th>
        </tr>
       </thead>
       <tbody>
       <c:forEach items="${areas}" var="area" varStatus="status">
       <tr>
       <td><span class="badge">${status.index+1}</span></td>
       <td>${area.code }</td>
       <td>${area.name }</td>
       <td>${area.personIncharge }</td>
       <td>${area.address }</td>
       <td>${area.tel }</td>
       <td>${area.status==true?'是':'否' }</td>
       <td>
       <r:a href="/learnArea/${area.id }" class="btn">查看</r:a>
       <r:a href="/learnArea/${area.id }/edit" class="btn">编辑</r:a>
       <r:a href="/learnArea/${area.id }" data-method="delete" data-confirm="确定要删除吗？" class="btn">删除</r:a>
       </td></tr>
      
       </c:forEach>
       </tbody>
    </table>
</div>
</r:layout>