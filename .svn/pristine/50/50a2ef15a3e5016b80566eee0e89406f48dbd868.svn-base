<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="r" tagdir="/WEB-INF/tags/r" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<r:layout title="国培用户信息" >
<jsp:include page="../layout/administrator_navbar.jsp" />
<div class="wrapper">
          <ul class="breadcrumb">
              <li><r:a href="/">首页</r:a> <span class="divider">/</span></li>
              <li class="active">国培用户信息管理</li>
            </ul>
          <r:a href="/account/bulkImport" class="button">批量导入</r:a>
          <r:a href="/account/new" class="button">页面注册</r:a>
    <br/>
    <br/>
    <table class="table table-hover" >
       <thead>
        <tr>
            <th>编号</th>
            <th>姓名</th>
            <th>性别</th>
            <th>证件类型</th>
            <th>证件号</th>
            <th>所在大学</th>
            <th>联系地址</th>
            <th>电话</th>
            <th>邮箱</th>
            <th>操作</th>
        </tr>
       </thead>
       <tbody>
       <c:forEach items="${accounts}" var="account" varStatus="status">
       <tr>
       <td><span class="badge">${status.index+1}</span></td>
       <td>${account.name }</td>
       <td>${account.sex }</td>
       <td>
       <c:choose>
       <c:when test="${account.idType=='ID_Cards' }">身份证</c:when>
       <c:when test="${account.idType=='Passport' }">护照</c:when>
       <c:when test="${account.idType=='Certificate_Of_Officers' }">军官证</c:when>
       <c:when test="${account.idType=='Valid_Exit_Entry_Permit_To_HK_Macau' }">港澳台通行证</c:when>
       <c:when test="${account.idType=='Other' }">其他</c:when>
       </c:choose>
       </td>
       <td>${account.idNumber }</td>
       <td>${account.school }</td>
       <td>${account.address }</td>
       <td>${account.tel }</td>
       <td>${account.email }</td>
       <td>
       <r:a href="/account/${account.id }" class="btn">查看</r:a>
       <r:a href="/account/${account.id }/edit" class="btn">编辑</r:a>
       <r:a href="/account/${account.id }" data-method="delete" data-confirm="确定要删除吗？" class="btn">删除</r:a>
       </td></tr>
      
       </c:forEach>
       </tbody>
    </table>
    <div class="toolbar">
            <div class="pagination pagination-centered">
            <r:paginate data="${accounts}" />
            </div>
            </div>
</div>
</r:layout>