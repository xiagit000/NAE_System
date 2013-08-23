<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="r" tagdir="/WEB-INF/tags/r" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<r:layout title="图文资讯管理" >
<jsp:include page="../../../layout/administrator_navbar.jsp" />
<div class="wrapper">
          <ul class="breadcrumb">
              <li><r:a href="/">首页</r:a> <span class="divider">/</span></li>
              <li class="active">图文资讯管理</li>
          </ul>
     <r:a href="/portalinfo/backstage/imagecontent/create" class="button">添加图文资讯新闻</r:a>
		<br/>	<br/>
    <table class="table table-hover table-show" >
       <thead>
        <tr>
            <th>编号</th>
            <th>标题</th>
            <th>发布时间</th>
            <th>点击数</th>
            <th>预览图</th>
            <th>操作</th>
        </tr>
       </thead>
       <tbody>
       <c:forEach items="${list}" var="portalDefaultInformation" varStatus="status"> 
	       <tr>
		       <td><span class="badge">${status.index+1}</span></td>
		       <td><r:a href="/portalinfo/${portalDefaultInformation.id}">${portalDefaultInformation.title}</r:a></td>
		       <td><fmt:formatDate value="${portalDefaultInformation.publishDate}" pattern="yyyy年MM月dd日 HH时mm分"/></td>
		       <td>${portalDefaultInformation.clickCount}</td>
		       <td><img style="width:60px; height: 48px;" src="<c:url value='/upload/${portalDefaultInformation.imagePath}'/>" /></td>
		       <td>
		       		<r:a href="/portalinfo/backstage/imagecontent/${portalDefaultInformation.id}/update">编辑</r:a>
		       		<r:a href="/portalinfo/${portalDefaultInformation.id}"  data-method="delete" data-confirm="确定删除吗？" >删除</r:a>
		       </td>
		   </tr>
       </c:forEach>
       </tbody>
    </table>
    <div class="toolbar">
            <div class="pagination pagination-centered">
            <r:paginate data="${list}" />
            </div>
            </div>
 </div>
</r:layout>