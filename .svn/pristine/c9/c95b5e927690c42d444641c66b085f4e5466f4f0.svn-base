<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="r" tagdir="/WEB-INF/tags/r" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<r:layout title="毕业标准" >
<r:javascript name="/resources/js/graduateStandard/add.js"></r:javascript>
<jsp:include page="../layout/administrator_navbar.jsp" />
<div class="wrapper">
          <ul class="breadcrumb">
              <li><r:a href="/">首页</r:a> <span class="divider">/</span></li>
              <li class="active">毕业标准</li>
            </ul>
        <r:a href="/graduateStandard/new" class="button">添加</r:a>
        <br/>
        <br/>
        <table class="table table-hover" >
       <thead>
        <tr>
            <th>编号</th>
            <th>批次</th>
            <th>及格分数</th>
            <th>结业日期</th>
            <th>操作</th>
        </tr>
       </thead>
       <tbody>
       <c:forEach items="${graduateStandards}" var="graduateStandard" varStatus="status">
       <tr>
	       <td><span class="badge">${status.index+1}</span></td>
	       <td>${graduateStandard.batch.code }-${graduateStandard.batch.name }</td>
	       <td>${graduateStandard.passScore*100 }%</td>
	       <td>${graduateStandard.graduateTime }</td>
	       <td><r:a href="/graduateStandard/${graduateStandard.id }/edit" class="btn">编辑</r:a>
	       <r:a href="/graduateStandard/${graduateStandard.id }" data-method="delete" data-confirm="确定要删除吗？" class="btn">删除</r:a></td>
       </tr>
       </c:forEach>
       </tbody>
    </table>
</div>
</r:layout>