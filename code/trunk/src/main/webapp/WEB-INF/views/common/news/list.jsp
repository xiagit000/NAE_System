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
<link rel="icon" href="<c:url value="/resources/images/index.ico" />"
	type="image/x-icon">
<title>通知公告</title>
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
	<li class="active">通知列表</li>
</ul>
<div class="content_p">
<table class="table_list">
	<c:forEach items="${list}" var="announcement" varStatus="status">
		<tr style="height: 30px;">
			<td><span class="badge">${status.index+1}</span></td>
			<td style="text-align: left;"><r:a href="/news/${announcement.id}">[通知公告] ${announcement.name}</r:a></td>
			<td><fmt:formatDate value="${announcement.time}" pattern="yyyy年MM月dd日"/> </td>
		</tr>
	</c:forEach>
</table>
<div class="toolbar">
			<div class="pagination pagination-centered">
				<r:paginate data="${list}" />
			</div>
</div>
</div>
</div>

<div class="clear"></div>
<div class="footer">技术支持：国家数字化学习工程技术研究中心</div>
</div>
</body>
</html>
