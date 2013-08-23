<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="r" tagdir="/WEB-INF/tags/r" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>  
<r:layout title="站内信" >
<r:javascript name="/resources/js/common/newmail.js"></r:javascript>
<jsp:include page="../layout/mail_navbar.jsp" />
<div class="wrapper">
          <ul class="breadcrumb">
          	  <li><r:a href="/">首页</r:a><span class="divider">/</span></li>
          	  <li><r:a href="/">站内信</r:a><span class="divider">/</span></li>
              <li class="active">发私信</li>
          </ul>
          <h2 class="title_h2"><span class="color_block"></span>站内信</h2>
          
          <div style="float:left;width: 70%;">
          <form id="add_form" action="<c:url value='/mail/sender' />" method="post">
          <input name="ids" id="ids" type="hidden"/>
         <table class="table" >
         <tbody>
         <tr><td width="100px"><b>收信人：</b></td>
         <td><input id="receivers" name="receiver" style="width:90%;height:25px;" />
         <span id="clearLinkMen" style="display: none;"><input type="button"  class="button" value="清空" onclick="clearLinkMen()"/></span>
         <div><font color="blue">*手动添加收信人请填写其登陆账号，多个账号之间用分号隔开</font></div>
         </td></tr>
         
         <tr><td><b>标题：</b></td>
         <td><input name="message" value="${notification.message }" style="width:100%;"/></td></tr>
        
         <tr><td><b>内容：</b></td>
         <td><textarea style="width:100%;height: 250px;" name="details">${notification.details }</textarea></td></tr>
        
         <tr><td></td>
         <td>
         <input class="button" type="submit" value="提交"/>
         &nbsp;&nbsp;
         <r:a class="button" href="/mail/receiver">取消</r:a>
         </tr>
         </tbody>
         </table>
          </form>
         </div>


		<div style="float: right; width: 30%;">
			<div id="tabs">
				<ul>
					<li><a href="#tabs-1">联系人列表</a></li>
				</ul>
				<div id="tabs-1">
				<div style="height:350px;border:1px;">
					<div id="linkman"></div>
					</div>
				</div>
			</div>
		</div>



	</div>
</r:layout>