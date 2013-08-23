<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="r" tagdir="/WEB-INF/tags/r" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<r:layout title="国培用户信息" >
<jsp:include page="../../layout/administrator_navbar.jsp" />
	<div class="wrapper">
       <ul class="breadcrumb">
          <li><r:a href="/">首页</r:a> <span class="divider">/</span></li>
          <li><r:a href="/account">国培用户信息管理</r:a> <span class="divider">/</span></li>
          <li class="active">批量导入用户信息</li>
        </ul>
	    <r:a href="/account/bulkImport/methodOne" class="button">导入方式一</r:a>
	    <b>（根据已有的班级和招生计划批量导入固定的学员人数）</b>
	    <br>
	    <br>
	    <r:a href="#" class="button">导入方式二</r:a>
	    <b>（批量导入学员的同时根据培训项目批量生成班级和招生计划并自动分班）</b>
	    <br>
	    <br>
	    <r:a href="/account/bulkImport/downloadTemplate" class="button"><b>==&gt; excel模板下载</b></r:a>
    </div>
</r:layout>