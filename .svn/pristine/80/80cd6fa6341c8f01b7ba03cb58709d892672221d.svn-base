<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="r" tagdir="/WEB-INF/tags/r"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>通知公告</title>
<link rel="icon" href="<c:url value="/resources/images/index.ico" />"
	type="image/x-icon">
<link rel="stylesheet" href="<c:url value='/resources/css/base.css'/>" type="text/css" media="screen" />
<link rel="stylesheet" href="<c:url value='/resources/css/login.css'/>" type="text/css" media="screen" />
<link rel="stylesheet" href="<c:url value='/resources/css/lee.css'/>" type="text/css" media="screen" />
</head>
<body>
<div class="wrap">
<p class="header"></p>
<div class="content">
	<ul class="breadcrumb">
		<li><r:a href="/">首页</r:a><span class="divider">/</span></li>
		<li><r:a href="/news">通知列表</r:a><span class="divider">/</span></li>
		<li class="active">查看通知</li>
	</ul>
	<div class="content_p">
	<p>
		<p class="text_title">${announcement.name}</p>
		<p class="time">发表者 : ${announcement.user.realName} 发布时间 ：<fmt:formatDate value="${announcement.time}" pattern="yyyy年MM月dd日 HH点mm分ss秒"/></p>
		<p class="font">${announcement.details}</p>
		<br />
		<br />
		<br />
		<br />
		<br />
		
			<c:if test="${announcement.attachment ne null}">
			<hr color="lightblue" size="1" />
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;详情附件：<r:a href="/attachment/${announcement.attachment.id}/download">下载附件</r:a>
			</c:if>
		
	</p>

</div>
</div>

<div class="clear"></div>
<div class="footer">技术支持：国家数字化学习工程技术研究中心</div>
</div>
</body>
</html>