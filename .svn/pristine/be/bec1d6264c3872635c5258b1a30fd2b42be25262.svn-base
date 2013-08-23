<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="r" tagdir="/WEB-INF/tags/r" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>  

<r:layout title="站内信" >
<jsp:include page="../layout/mail_navbar.jsp" />
<div class="wrapper">
          <ul class="breadcrumb">
          	  <li><r:a href="/">首页</r:a><span class="divider">/</span></li>
              <li class="active"><r:a href="/">收件箱</r:a></li>
          </ul>
          <div class="content">
			<h2 class="title_h2"><span class="color_block"></span>站内信</h2>
				<div style="padding:0 5px 5px 8px;">
					<div class="content-mail-tabs">
						<r:a class="curr-tab" href="/mail/receiver">收件箱(${unreadCount})</r:a>
						<span class="line"></span>
						<r:a href="/mail/sender">发件箱</r:a>
					</div>
					<div id="tab0"  style="display:block;">
						<table class="table table-hover">
						<tr>
							<th>编号</th>
							<th>标题</th>
							<th>发送人</th>
							<th>阅读情况</th>
							<th>接收时间</th>
							<th>操作</th>
						</tr>
						<c:forEach varStatus="status" items="${receiverNotifications}" var="receiver">
							<tr>
								<td><span class="badge">${status.index+1}</span></td>
								<td><r:a href="/mail/receiver/${receiver.id}">${receiver.message}</r:a></td>
								<td>${receiver.sender.realName}</td>
								<td>${receiver.consult==true?'已读':'未读'}</td>
								<td><fmt:formatDate value="${receiver.time}" pattern="yyyy-MM-dd HH:mm"/> </td>
								<td><r:a href="/mail/receiver/${receiver.id }" data-method="delete"
						data-confirm="确定要删除吗？" class="btn">删除</r:a></td>
							</tr>
						</c:forEach>
						</table>
						<div class="toolbar"><div class="pagination pagination-centered"><r:paginate data="${receiverNotifications}"></r:paginate></div></div>
					</div>
					<div id="tab3" class="tab-content default-tab" style="display:none;">
					</div>
				</div>
		</div>
 </div>
</r:layout>