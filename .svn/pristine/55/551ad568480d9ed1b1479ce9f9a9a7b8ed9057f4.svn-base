<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="r" tagdir="/WEB-INF/tags/r"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<r:yieldTitle prefix="职教院非学历教学平台 | "></r:yieldTitle>

<link rel="stylesheet" href="<c:url value='/resources/css/style.css'/>" type="text/css" media="screen" />
<link rel="stylesheet" href="<c:url value='/resources/css/base.css'/>" type="text/css" media="screen" />
  <link rel="icon" href="<c:url value="/resources/images/index.ico" />"    type="image/x-icon">   <link rel="stylesheet" href="<c:url value='/resources/css/lee.css'/>" type="text/css" media="screen" />
<link rel="stylesheet" href="<c:url value='/resources/css/jquery-ui-1.10.3.custom.min.css'/>" type="text/css" media="screen" />

<script>var contextPath="<c:url value='/'/>";</script>
<script src="<c:url value='/resources/js/jquery-1.9.1.min.js'/>"></script>
<script src="<c:url value='/resources/js/jquery-ui-1.10.3.custom.min.js'/>"></script>
<script src="<c:url value='/resources/js/bootstrap.min.js'/>"></script>
<script src="<c:url value='/resources/js/application.js'/>"></script>
<script src="<c:url value='/resources/js/nav.js'/>"></script>
<script src="<c:url value='/resources/js/jquery.KinSlideshow-1.1.js'/>"></script>
<script src="<c:url value='/resources/js/scrolltop.js'/>"></script>
<script src="<c:url value='/resources/js/jquery.validate.min.js' />"></script>
<script src="<c:url value='/resources/js/rails.js' />"></script>
<script src="<c:url value='/resources/js/ckeditor.js' />"></script>

<script
	src="<c:url value="/resources/js/My97DatePicker/WdatePicker.js"/>"
	type="text/javascript"></script>
<r:yieldJavascripts />

</head>
<body>
<jsp:useBean id="now" class="java.util.Date" />
<c:set var="nowtime" scope="request">
	<fmt:formatDate value="${now}" pattern="yyyy年MM月dd日 HH点mm分" />
</c:set>
	<div style="display: none" id="goTopBtn"></div>
	<!-- Header Begin -->
	<div class="header">
		<p class="login_title"></p>
		<div class="header_content">
			<p class="header_p">
				<span class="header_user">欢迎您：<a href="###">${currentUser.realName}</a></span> 
				<span>当前权限：<fmt:message key="${currentUser.userType}" /></span>
				<span class="mail"><r:a href="/mail/receiver">站内信(${unreadCount})</r:a></span>
			</p>
			<ul class="header_list">
				<li><r:a href="/" class="list_current">首页</r:a></li>
			<li>
					<p class="list_line"></p>
				</li>
			<li><r:a href="/logout">退出</r:a></li>
				<li>
					<p class="list_line"></p>
				</li>
				<li>
					<span id="divT" style="display: inline-block;">${nowtime}</span>
				</li>
			</ul>
		</div>
	</div>
	<!-- Header OVER -->

	<!-- Main Begin -->
	<div class="main_content">
		 <c:if test="${message ne null}">
        	<div class="alert alert-success">
        		<button type="button" class="close" data-dismiss="alert">×</button>
        		${message}
        	</div>
        </c:if>
        <c:if test="${warning ne null}">
        	<div class="alert">
  				<button type="button" class="close" data-dismiss="alert">×</button>
				${warning}  
			</div>
        </c:if>
        <c:if test="${error ne null}">
        	<div class="alert alert-error">
  				<button type="button" class="close" data-dismiss="alert">×</button>
  				${error}
			</div>
        </c:if>
		<r:yieldBody></r:yieldBody>
	</div>
	<div class="clear"></div>
		<p class="footer">
			技术支持：国家数字化学习工程技术研究中心
		</p>
</body>
</html>