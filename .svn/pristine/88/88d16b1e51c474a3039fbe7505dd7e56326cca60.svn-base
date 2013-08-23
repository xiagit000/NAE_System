<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="r" tagdir="/WEB-INF/tags/r"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<r:layout title="用户信息">
	<r:javascript name="/resources/js/account/add.js"></r:javascript>
	<jsp:include page="../layout/administrator_navbar.jsp" />
	<div class="wrapper">
	<ul class="breadcrumb">
		<li><r:a href="/">首页</r:a> <span class="divider">/</span></li>
		<li><r:a href="/account">国培用户信息管理</r:a> <span class="divider">/</span></li>
		<li class="active">用户信息</li>
	</ul>
	<table class="table table-hover">
		<tbody>
			<tr>
				<td><b>姓名：</b></td>
				<td>${account.name }</td>
				<td><b>性别：</b></td>
				<td>${account.sex}</td>
			</tr>
			<tr>
				<td><b>民族：</b></td>
				<td>${account.ethnic }</td>
				<td><b>证件类型：</b> </td>
				<td>
					<c:choose>
						<c:when test="${account.idType=='ID_Cards' }">身份证</c:when>
						<c:when test="${account.idType=='Passport' }">护照</c:when>
						<c:when test="${account.idType=='Certificate_Of_Officers' }">军官证</c:when>
						<c:when
							test="${account.idType=='Valid_Exit_Entry_Permit_To_HK_Macau' }">港澳台通行证</c:when>
						<c:when test="${account.idType=='Other' }">其他</c:when>
					</c:choose>
				</td>
			</tr>
			<tr>
				<td><b>证件号：</b></td>
				<td>${account.idNumber }</td>
				<td><b>目前所在大学：</b></td>
				<td>${account.school }</td>
			</tr>
			<tr>
				<td><b>政治面貌：</b></td>
				<td> 
				<c:choose>
					<c:when test="${account.politicallandscape=='Communist_Party' }">共产党</c:when>
					<c:when
						test="${account.politicallandscape=='Communist_Youth_League' }">共青团</c:when>
					<c:when test="${account.politicallandscape=='Masses' }">群众</c:when>
				</c:choose></td>
				<td><b>居住地：</b></td>
				<td>${account.address }</td>
			</tr>
			<tr>
				<td><b>联系地址：</b></td>
				<td>${account.contactAddr }</td>
				<td><b>邮政编码：</b></td>
				<td>${account.zipCode }</td>
			</tr>
			<tr>
				<td><b>邮箱：</b></td>
				<td>${account.email }</td>
				<td><b>联系电话：</b></td>
				<td>${account.tel }</td>
			</tr>
			<tr>
				<td><b>最高学位：</b></td>
				<td><c:choose>
					<c:when test="${account.hignestDegree=='Bachelor' }">学士</c:when>
					<c:when test="${account.hignestDegree=='Master' }">硕士</c:when>
					<c:when test="${account.hignestDegree=='Doctor' }">博士</c:when>
				</c:choose></td>
				<td><b>最高学历：</b></td>
				<td><c:choose>
					<c:when
						test="${account.highestEducationalBackground=='High_School' }">高中</c:when>
					<c:when
						test="${account.highestEducationalBackground=='Technician_Training_School' }">技校</c:when>
					<c:when
						test="${account.highestEducationalBackground=='Trade_School' }">中专</c:when>
					<c:when
						test="${account.highestEducationalBackground=='Junior_College' }">大专</c:when>
					<c:when
						test="${account.highestEducationalBackground=='Undergraduate_College' }">本科</c:when>
					<c:when
						test="${account.highestEducationalBackground=='Graduate_Student' }">研究生</c:when>
					<c:when test="${account.highestEducationalBackground=='Other' }">其他</c:when>
				</c:choose></td>
			</tr>
			<tr>
				<td><b>毕业院校：</b></td>
				<td>${account.graduatedSchool }</td>
				<td><b>毕业专业：</b></td>
				<td>${account.graduatedSpecialty }</td>
			</tr>
			<tr>
				
			</tr>
			<tr>
				<td><b>工作单位：</b></td>
				<td>${account.workPlace }</td>
				<td><b>工作性质：</b></td>
				<td>
				 <c:choose>
					<c:when test="${account.workNature=='Foreign_Funded_Enterprises' }">外企</c:when>
					<c:when test="${account.workNature=='Joint_Venture' }">合资企业</c:when>
					<c:when test="${account.workNature=='Private_Enterprise' }">私企</c:when>
					<c:when test="${account.workNature=='Army' }">军队</c:when>
					<c:when test="${account.workNature=='StateOwned_Enterprise' }">国企</c:when>
					<c:when test="${account.workNature=='Institution' }">事业单位</c:when>
					<c:when test="${account.workNature=='Government_Agency' }">政府机构</c:when>
				</c:choose></td>
			</tr>
			<tr>
				
			</tr>
			<tr>
				<td><b>工作职位：</b></td>
				<td>${account.position }"</td>
				<td><b>工作职称：</b></td>
				<td>${account.workTitles }</td>
			</tr>
			<tr>
				
			</tr>
			<tr>
				<td><b>工作年限：</b></td>
				<td>${account.workYear }</td>
				<td><b>工作简历：</b></td>
				<td>${account.workDescription }</td>
			</tr>
			<tr>
				<td><b>培训和获奖信息：</b></td>
				<td colspan="3">${account.learnAndRewardInfo }</td>
			</tr>
			<tr>
				<td colspan="4"><b>备注：</b></td>
			</tr>
			<tr>
				<td colspan="4"><textarea rows="10" cols="100" readonly="readonly">${account.description }</textarea></td>
			</tr>
		</tbody>
	</table>

	<r:a href="/account/${account.id }/edit" class="button">编辑</r:a>
	&nbsp;&nbsp; <r:a href="/account" class="button">返回</r:a>
	</form>
	</div>
</r:layout>