<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="r" tagdir="/WEB-INF/tags/r" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

   <div class="side_bar">
			<h1 class="sider_menu"><span class="img folder"></span>业务功能区</h1>
				<ul class="ul_list">
					<li><r:a href="/mail/sender/new">发私信</r:a></li>
					<li><r:a href="/mail/receiver">信箱</r:a></li>
				</ul>
	</div>