<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="r" tagdir="/WEB-INF/tags/r" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>  

<r:javascript name="/resources/js/portal/backstage/withoutimage/validate.js"></r:javascript>

<r:layout title="查看门户新闻" >
<jsp:include page="../../layout/administrator_navbar.jsp" />
		<div class="wrapper">
			 <ul class="breadcrumb">
	              <li><r:a href="/">首页</r:a> <span class="divider">/</span></li>
	              <li class="active">查看门户新闻</li>
          	</ul>
         <table class="table table-hover">
         	<tr>
         		<td style="text-align: center;font-size: 20px;font-weight: bold">${portalDefaultInformation.title}</td>
         	</tr>
         	<tr>
         		<td style="text-align: center;"><b>发表者 :</b>${portalDefaultInformation.publicPerson}&nbsp;&nbsp;&nbsp;&nbsp;<b>发布时间  : </b><fmt:formatDate value="${portalDefaultInformation.publishDate}" pattern="yyyy年MM月dd日 HH时mm分"/>&nbsp;&nbsp;&nbsp;&nbsp;<b>点击 : </b>${portalDefaultInformation.clickCount}</td>
         	</tr>
         	<tr>
         		<td>${portalDefaultInformation.content}</td>
         	</tr>
         </table>	
          	
        
				
			

		</div>
		 
		
</r:layout>