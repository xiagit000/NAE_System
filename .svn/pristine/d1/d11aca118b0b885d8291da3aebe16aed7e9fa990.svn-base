<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="r" tagdir="/WEB-INF/tags/r" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>  



<r:layout title="添加一级导航条目" >
<jsp:include page="../layout/administrator_navbar.jsp" />
		<div class="wrapper">
			 <ul class="breadcrumb">
	              <li><r:a href="/">首页</r:a> <span class="divider">/</span></li>
	              <li><r:a href="/portalinfo/backstage/gp">一级导航条列表</r:a> <span class="divider">/</span></li>
	              <li class="active">添加一级导航条目</li>
          	</ul>
          	<form id="add_form" action="<c:url value='/portal/navigation' />" method="POST">
          	    <table class="table">
		         	<tbody>
		         		<tr>
		         			<td><b>一级栏目名称</b></td>
		         			<td><label for="name" class="error" generated="true" style="color:red;font-size:12px;"></label></td>
		         		</tr>
		         		<tr>
		         			<td colspan="2"><input name="name"/></td>
		         		</tr>
		         		
		         	<tr>
		         		<td colspan="2">
		         			<input type="submit" class="button" value="提交"/>
	        				<r:a href="/portal/navigation" class="button">取消</r:a>
		         		</td></tr>
		         	</tbody>
		         </table>
		
        	 </form>
		</div>
		 
		
</r:layout>