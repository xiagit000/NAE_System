﻿<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="r" tagdir="/WEB-INF/tags/r" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

   <div class="side_bar">
			<h1 class="sider_menu"><span class="img folder"></span>个人管理</h1>
				<ul class="ul_list">
					
					<li><r:a href="/user/me">个人信息</r:a></li>
					<li><r:a href="/user/changepass">修改密码</r:a></li>
				</ul>

			<h1 class="sider_menu" ><span class="img folder"></span>业务功能区</h1>
				<ul class="ul_list">
					
					<li><r:a href="/announcement">发布班级公告</r:a></li>
					<li><r:a href="/grade/students">设置学员附加分</r:a></li>
					<li><r:a href="/learnthesis/show">研修论文批改</r:a></li>
					<li><r:a href="/question">解答提问</r:a></li>
				</ul>
					
			<h1 class="sider_menu"><span class="img folder"></span>学习资料区</h1>
				<ul class="ul_list">
					<li><a href="${myClass}">我的班级空间</a></li>
					<li><a href="${myXBYXPath}">校本研修空间</a></li>
					<li><a href="${mySchoolPath}">我的学校空间</a></li>
					<li><r:a href="/learnresource/disciplineresources">学科专家共享资料</r:a></li>
					<li><r:a href="/learnresource/projectresources">项目专家共享资料</r:a></li>
				</ul>

			<h1 class="sider_menu"><span class="img search"></span>培训情况查询</h1>
				<ul class="ul_list">
					
					<li><r:a href="/statistics/myteachinfo">我的辅导行为</r:a></li>
					<li><r:a href="/statistics/studentInfo">学员培训情况</r:a></li>
				</ul>
			
	</div>