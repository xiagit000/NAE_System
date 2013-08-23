<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="r" tagdir="/WEB-INF/tags/r" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<r:layout title="首页" >
<jsp:include page="layout/administrator_navbar.jsp" />
	<div class="wrapper">
		<ul class="breadcrumb">
              <li class="active"><r:a href="/">首页</r:a></li>
        </ul>
     	<div class="content content_fixed">
	
			<h2 class="title_h2"><span class="color_block"></span>最新公告</h2>
			<div style="padding:0 5px 5px 8px;">
			<div class="content-box-tabs">
				<a class="curr-tab" data-tab="#tab0" href="#tab0">班级公告</a><span class="line"></span>
				
				<a class="" data-tab="#tab1" href="#tab1">优秀研修日志</a>
				<span class="line"></span>
				<a class="" data-tab="#tab2" href="#tab2">项目公告</a>
				<span class="line"></span>
				<a class="" data-tab="#tab3" href="#tab3">培训公告</a>
				<span class="line"></span>
				<a class="" data-tab="#tab4" href="#tab4">省督导公告</a>
				<span class="line"></span>
				<a class="" data-tab="#tab5" href="#tab5">校督导公告</a>
				<span class="line"></span>
				<a class="" data-tab="#tab6" href="#tab6">学科公告</a>
				
	        </div>
			<div id="tab0" class="tab-content default-tab" style="display:block;">
				<p><a href="#">第七届教师大会开会通知</a></p>
				<p><a href="#">班会地点更改</a></p>
				<p><a href="#">关于2013五一放假通知</a></p>
				<p><a href="#">关于2013年端午节放假通知</a></p>
			</div>
			<div id="tab1" class="tab-content default-tab" style="display:none;">
				<p><a href="#">关于2012年十一放假通知</a></p>
				<p><a href="#">关于2012五一放假通知</a></p>
				<p><a href="#">祝贺我校计算机学院教师谢玲玲荣获中国优秀青年称誉</a></p>
			</div>
			<div id="tab2" class="tab-content default-tab" style="display:none;">
				<p><a href="#">关于2012年十一放假通知</a></p>
				<p><a href="#">关于2012五一放假通知</a></p>
				<p><a href="#">关于2012年十一放假通知</a></p>
				<p><a href="#">关于2012五一放假通知</a></p>
			</div>
			<div id="tab3" class="tab-content default-tab" style="display:none;">
				<p><a href="#">祝贺我校计算机学院教师谢玲玲荣获中国优秀青年称誉</a></p>
			</div>
			<div id="tab4" class="tab-content default-tab" style="display:none;">
				<p><a href="#">关于2012五一放假通知</a></p>
				<p><a href="#">祝贺我校计算机学院教师谢玲玲荣获中国优秀青年称誉</a></p>
			</div>
			<div id="tab5" class="tab-content default-tab" style="display:none;">
				<p><a href="#">关于2012年十一放假通知</a></p>
				<p><a href="#">关于2012五一放假通知</a></p>
			</div>
			
			<div id="tab6" class="tab-content hide" style="display:none;">
				<p><a href="#">亲爱的老师：</a></p>
				<p><a href="#">你还有<span class="yellow">1</span>份待批阅的请假条</a></p>
			</div>
			</div>
		</div>
		<div class="content">
			<h2 class="title_h2"><span class="color_block"></span>省学习情况统计</h2>
			<table class="main_data">
				<thead>
					<tr>
						<th>学科名称</th>
						<th>省数量</th>
						<th>市区数量</th>
						<th>学校数量</th>						
						<th>班级数</th>
						<th>学员数</th>
						<th>登录学员数</th>
						<th>学员参训率</th>
						<th>人均在线时长</th>
						<th>人均有效时长</th>
						<th>研修作业(提交/批阅/推荐)</th>
						<th>班级论坛(发帖/回帖)</th>
						<th>问答(已提问/已回答/待回答)</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>作业</td>
						<td>0</td>
						<td>0</td>
						<td>0</td>
						<td>作业</td>
						<td>0</td>
						<td>0</td>
						<td>0</td>
						<td>0</td>
						<td>作业</td>
						<td>0</td>
						<td>0</td>
						<td>0</td>
					</tr>
					<tr>
						<td>作业</td>
						<td>0</td>
						<td>0</td>
						<td>0</td>
						<td>作业</td>
						<td>0</td>
						<td>0</td>
						<td>0</td>
						<td>0</td>
						<td>作业</td>
						<td>0</td>
						<td>0</td>
						<td>0</td>
					</tr>
				
				</tbody>
			
			</table>
		</div>
     </div>

</r:layout>