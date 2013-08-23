<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="r" tagdir="/WEB-INF/tags/r" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

   <div class="side_bar">
			<h1 class="sider_menu"><span class="img folder"></span>业务功能区</h1>
				<ul class="ul_list">
					<li><r:a href="/announcement">发布学科专家公告</r:a></li>
					<li><r:a href="/learnresource/disciplineresources">发布学科辅导资料</r:a></li>
				</ul>
			<h1 class="sider_menu"><span class="img folder"></span>专家导航</h1>
				<ul class="ul_list">
					<li><a href="${myClass}">我负责的学习空间</a></li>
				</ul>
			<h1 class="sider_menu"><span class="img sitemap"></span>培训情况统计</h1>
				<ul class="ul_list">
					<li><r:a href="/statistics/discipline">学科培训情况统计</r:a></li>
				</ul>
			
	</div>