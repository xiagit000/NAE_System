<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="r" tagdir="/WEB-INF/tags/r" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<r:layout title="门户导航管理" >
<jsp:include page="../../layout/administrator_navbar.jsp" />
<div class="wrapper">
          <ul class="breadcrumb">
              <li><r:a href="/">首页</r:a> <span class="divider">/</span></li>
              <li><r:a href="/portal/navigation">一级导航条列表</r:a> <span class="divider">/</span></li>
              <li class="active">门户导航条管理</li>
          </ul>
     <r:a href="/portal/navigation/${parent.id}/child/create" class="button">添加"${parent.name}"二级导航目录</r:a>
		<br/>
    <table class="table table-hover table-show" >
       <thead>
        <tr>
            <th>编号</th>
            <th>名称</th>
            <th>识别码</th>
            <th>包含子目录个数</th>
            <th>操作</th>
        </tr>
       </thead>
       <tbody>
       <c:forEach items="${childrenList}" var="child" varStatus="status"> 
	       <tr>
		       <td><span class="badge">${status.index+1}</span></td>
		       <td>${child.name}</td>
		       <td>${child.elCode}</td>
		       <td>${child.childCount}</td>
		       <td>
		       		<r:a href="/portal/navigation/${parent.id}/child/${child.id}/news">二级栏目新闻管理</r:a> <br/>
		       		<r:a href="/portal/navigation/${parent.id}/child/${child.id}/update">编辑</r:a>
		       		<r:a href="/portal/navigation/${parent.id}/child/${child.id}"  data-method="delete" data-confirm="确定删除吗？" >删除</r:a>
		       </td>
		   </tr>
       </c:forEach>
       </tbody>
    </table>
 </div>
</r:layout>