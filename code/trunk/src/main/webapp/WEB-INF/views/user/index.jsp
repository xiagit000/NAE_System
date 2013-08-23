<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="r" tagdir="/WEB-INF/tags/r" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<r:layout title="用户账户" >
<r:javascript name="/resources/js/user/index.js"></r:javascript>
<jsp:include page="../layout/administrator_navbar.jsp" />
	<div class="wrapper">
          <ul class="breadcrumb">
              <li><r:a href="/">首页</r:a> <span class="divider">/</span></li>
              <li class="active">用户账户管理</li>
            </ul>
            <r:a href="/user/exportExcel" class="button">批量导出账号</r:a>
    <br/>
    <br/>
    
    <!-- 搜索 -->
        <form action="<c:url value='/user' />" name="form-search" id="form-search" method="get">
         <table class="table table-hover" >
         <tbody>
        	 <tr>
        	 	<td><b>班级</b></td>
                 <td>
                    <select name="learnClassId"  style="width: 150px;">
                    <option value='${learnClass.id }'>请选择</option>
                        <c:forEach items="${learnClassList}" var="learnClass">
                            <option value='${learnClass.id}'>${learnClass.name}</option>
                        </c:forEach>
                    </select>
                </td>
         		<td><b>证件类型：</b></td>
         		<td><select name="idTypeSelect" style="width: 150px;">
         			 <option value='-1'>请选择</option>
         			 
			         <option value="ID_Cards" <c:if test="${idTypeSelect eq 'ID_Cards'}">selected='selected'</c:if> >身份证</option>
			         <option value="Passport" <c:if test="${idTypeSelect eq 'Passport'}">selected='selected'</c:if> >护照</option>
			         <option value="Certificate_Of_Officers" <c:if test="${idTypeSelect eq 'Certificate_Of_Officers'}">selected='selected'</c:if> >军官证</option>
			         <option value="Valid_Exit_Entry_Permit_To_HK_Macau" <c:if test="${idTypeSelect eq 'Valid_Exit_Entry_Permit_To_HK_Macau'}">selected='selected'</c:if> >港澳台通行证</option>
			         <option value="Other" <c:if test="${idTypeSelect eq 'Other'}">selected='selected'</c:if> >其他</option>
			         </select>
         		</td>
         		
         <td><b>培训项目批次</b></td>
                <td>
                    <select name="batchId"  style="width: 150px;">
                    <option value='${batch.id}'>请选择</option>
                        <c:forEach items="${batchList}" var="batch">
                            <option value='${batch.id}'>${batch.name}</option>
                        </c:forEach>
                    </select>
                </td>
         	</tr>
         	<tr>
                <td><b>姓名：</b></td>
         		<td><input name="name" value="${account.name }"  style="width: 150px;"/></td>
                <td><b>证件号：</b></td>
         		<td><input name="idNumber" value="${account.idNumber }"  style="width: 150px;"/></td>
         		<td><b>用户类型：</b> </td>
                <td>
                <select name="userTypeSelect" style="width: 150px;">
                        <option value='-1'>请选择</option>
                        <option value='Student' <c:if test="${userTypeSelect eq 'Student'}"> selected='selected'</c:if> >学生</option>
                        <option value='Teacher' <c:if test="${userTypeSelect eq 'Teacher'}"> selected='selected'</c:if> >老师</option>
                        <option value='Project_Specialists' <c:if test="${userTypeSelect eq 'Project_Specialists'}"> selected='selected'</c:if> >项目专家</option>
                        <option value='Subject_Specialists' <c:if test="${userTypeSelect eq 'Subject_Specialists'}"> selected='selected'</c:if> >学科专家</option>
					    <option value='System_Administrator' <c:if test="${userTypeSelect eq 'System_Administrator'}"> selected='selected'</c:if> >系统管理员</option>
					</select>
                </td>
               
            </tr>
            <tr>
            	<td colspan="2" rowspan="2"> </td>
            	<td colspan="2" rowspan="2"><button type="submit" class="btn_search" id="search">查询</button></td>
            	<td colspan="2" rowspan="2"> </td>
            </tr>
         </tbody>
         </table>
         </form>
    <table class="table table-hover" >
       <thead>
        <tr>
            <th>编号</th>
            <th>登录名</th>
            <th>用户类型</th>
            <th>用户姓名</th>
            <th>证件类型</th>
            <th>证件号</th>
            <th>批次</th>
            <th>状态</th>
            <th>操作</th>
        </tr>
       </thead>
       <tbody>
       <c:forEach items="${users}" var="user" varStatus="status">
       <tr>
       <td><span class="badge">${status.index+1}</span></td>
       <td>${user.loginName }</td>
       <td><fmt:message key="${user.userType}" /></td>
       <td>${user.account.name }</td>
       <td>
       <c:if test="${user.account!=null}">
       <fmt:message key="${user.account.idType}" />
       </c:if>
       </td>
       <td>${user.account.idNumber }</td>
       <td>${user.batch.name }</td>
       <td>${user.active==true?"已激活":"未激活" }</td>
       <td>
       	<c:if test="${user.userType eq 'Student'}">
       	<r:a href="/user/${user.id }" data-method="delete" data-confirm="确定要删除吗？" class="btn">删除</r:a>
       </c:if>
       </td></tr>
      
       </c:forEach>
       </tbody>
    </table>
    <div class="toolbar">
            <div class="pagination pagination-centered">
            <r:paginate data="${users}" />
            </div>
            </div>
</div>
</r:layout>