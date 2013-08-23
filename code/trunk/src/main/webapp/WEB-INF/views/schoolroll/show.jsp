<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="r" tagdir="/WEB-INF/tags/r"%>

<r:layout title="学员学籍 | 展示单个学员学籍">
<jsp:include page="../layout/administrator_navbar.jsp" />
	<div class="wrapper">
	<ul class="breadcrumb">
		<li><r:a href="/">首页</r:a> <span class="divider">/</span></li>
		<li><r:a href="/schoolroll">学籍列表</r:a> <span class="divider">/</span></li>
		<li class="active">学员"${schoolRoll.user.account.name}"的基本信息</li>
	</ul>

	<table class="table">
		<tbody>
			<tr>
				<th colspan="4" style="color:blue;">
				批次${schoolRoll.learnClass.enrollmentPlan.batch.name}[${schoolRoll.learnClass.enrollmentPlan.batch.code}] 学员: ${schoolRoll.user.account.name} 基本信息
				</th>
			</tr>
			<tr>
				<th>登录名</th>
				<td>${schoolRoll.user.loginName}</td>
				<th>密码</th>
				<td>${schoolRoll.user.password}</td>
			</tr>
			
			<tr>
				<th>证件类型</th>
				<td><fmt:message key="${schoolRoll.user.account.idType}" /></td>
				<th>证件号</th>
				<td>${schoolRoll.user.account.idNumber}</td>
			</tr>
			
			<tr>
				<th>Email</th>
				<td>${schoolRoll.user.account.email}</td>
				<th>电话</th>
				<td>${schoolRoll.user.account.tel}</td>
			</tr>
			<tr>
				<th colspan="4" style="color:blue;">
				批次${schoolRoll.learnClass.enrollmentPlan.batch.name}[${schoolRoll.learnClass.enrollmentPlan.batch.code}]学员: ${schoolRoll.user.account.name} 班级信息
				</th>
			</tr>
			<tr>
				<th>班级名称</th>
				<td>${schoolRoll.learnClass.name}</td>
				<th>班级全名</th>
				<td>${schoolRoll.learnClass.allName}</td>
			</tr>
			<tr>
				<th>班级代码</th>
				<td>${schoolRoll.learnClass.code}</td>
				<th>所属培训项目</th>
				<td>${schoolRoll.learnClass.learnProject.name}</td>
			</tr>
			<tr>
				<th>所属培训区域</th>
				<td>${schoolRoll.learnClass.learnArea.name}</td>
				<th>负责人</th>
				<td>${schoolRoll.learnClass.personIncharge}</td>
			</tr>
			<tr>
				<th>创建人</th>
				<td>${schoolRoll.learnClass.user.account.name}</td>
				<th>创建时间</th>
				<td>${schoolRoll.learnClass.createTime}</td>
			</tr>
			
			<tr>
				<th colspan="4" style="color:blue;">
				批次${schoolRoll.learnClass.enrollmentPlan.batch.name}[${schoolRoll.learnClass.enrollmentPlan.batch.code}] 学员: ${schoolRoll.user.account.name} 学籍记录
				</th>
			</tr>
			<tr>
				<td colspan="4">
					<c:if test="${!empty schoolRollList}">
						<ul>
							<c:forEach items="${schoolRollList}" var="sr" varStatus="status">
								<li>${status.index+1}.学员:${schoolRoll.user.account.name}  ${sr.createDate} 在 班级 :${sr.learnClass.name}  的状态为  <fmt:message key="${sr.schoolRollType}" /> </li>
							</c:forEach>	
						</ul>
					</c:if>
					
				</td>
			</tr>
			
			
			
			<tr>
				<td><r:a href="/schoolroll" class="btn">返回</r:a></td>
			</tr>
		</tbody>
	</table>
</div>
</r:layout>