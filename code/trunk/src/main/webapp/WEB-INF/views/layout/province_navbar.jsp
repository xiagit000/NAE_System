<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="r" tagdir="/WEB-INF/tags/r" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

   <div class="side_bar">
			<h1 class="sider_menu"><span class="img folder"></span>业务功能区</h1>
				<ul class="ul_list">
					<li <c:if test="${siteItem eq 'user'}">class="checked"</c:if>><r:a href="/announcement">发布省督导公告</r:a></li>
				</ul>
			<h1 class="sider_menu"><span class="img sitemap"></span>培训情况统计</h1>
				<ul class="ul_list">
					<li <c:if test="${siteItem eq 'user'}">class="checked"</c:if>><r:a href="/statistics/province">省培训情况统计</r:a></li>
				</ul>
			
	</div>