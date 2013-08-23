<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="r" tagdir="/WEB-INF/tags/r" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<r:layout title="更新用户信息" >
<r:javascript name="/resources/js/account/add.js"></r:javascript>
          <ul class="breadcrumb">
              <li><r:a href="/">首页</r:a> <span class="divider">/</span></li>
              <li><r:a href="/account">国培用户信息管理</r:a> <span class="divider">/</span></li>
              <li class="active">更新用户信息</li>
            </ul>
         <table class="table table-hover" >
         <tbody>
         <tr><td><b>姓名：</b>${account.name }</td></tr>
         <tr><td><b>性别：</b>${account.sex}</td></tr>
         <tr><td><b>民族：</b>${account.ethnic }</td></tr>
         <tr><td><b>证件类型：</b>
         <c:choose>
       <c:when test="${account.idType=='ID_Cards' }">身份证</c:when>
       <c:when test="${account.idType=='Passport' }">护照</c:when>
       <c:when test="${account.idType=='Certificate_Of_Officers' }">军官证</c:when>
       <c:when test="${account.idType=='Valid_Exit_Entry_Permit_To_HK_Macau' }">港澳台通行证</c:when>
       <c:when test="${account.idType=='Other' }">其他</c:when>
       </c:choose>
         </td></tr>
         <tr><td><b>证件号：${account.idNumber }</td></tr>
         <tr><td><b>目前所在大学：</b>${account.school }</td></tr>
         <tr><td><b>政治面貌：</b>
         <c:choose>
       <c:when test="${account.politicallandscape=='Communist_Party' }">共产党</c:when>
       <c:when test="${account.politicallandscape=='Communist_Youth_League' }">共青团</c:when>
       <c:when test="${account.politicallandscape=='Masses' }">群众</c:when>
       </c:choose>
         </td></tr>
         <tr><td><b>居住地：</b>${account.address }</td></tr>
         <tr><td><b>联系地址：</b>${account.contactAddr }</td></tr>
         <tr><td><b>邮政编码：</b>${account.zipCode }</td></tr>
         <tr><td><b>邮箱：</b>${account.email }</td></tr>
         <tr><td><b>联系电话：</b>${account.tel }</td></tr>
         <tr><td><b>最高学位：</b>
         <c:choose>
       <c:when test="${account.hignestDegree=='Bachelor' }">学士</c:when>
       <c:when test="${account.hignestDegree=='Master' }">硕士</c:when>
       <c:when test="${account.hignestDegree=='Doctor' }">博士</c:when>
       </c:choose>
         </td></tr>
         <tr><td><b>最高学历：</b>
         <c:choose>
       <c:when test="${account.highestEducationalBackground=='High_School' }">高中</c:when>
       <c:when test="${account.highestEducationalBackground=='Technician_Training_School' }">技校</c:when>
       <c:when test="${account.highestEducationalBackground=='Trade_School' }">中专</c:when>
       <c:when test="${account.highestEducationalBackground=='Junior_College' }">大专</c:when>
       <c:when test="${account.highestEducationalBackground=='Undergraduate_College' }">本科</c:when>
       <c:when test="${account.highestEducationalBackground=='Graduate_Student' }">研究生</c:when>
       <c:when test="${account.highestEducationalBackground=='Other' }">其他</c:when>
       </c:choose>
         </td></tr>
         <tr><td><b>毕业院校：</b>${account.graduatedSchool }</td></tr>
         <tr><td><b>毕业专业：</b>${account.graduatedSpecialty }</td></tr>
         <tr><td><b>工作单位：</b>${account.workPlace }</td></tr>
         <tr><td><b>工作性质：</b>
         <c:choose>
       <c:when test="${account.workNature=='Foreign_Funded_Enterprises' }">外企</c:when>
       <c:when test="${account.workNature=='Joint_Venture' }">合资企业</c:when>
       <c:when test="${account.workNature=='Private_Enterprise' }">私企</c:when>
       <c:when test="${account.workNature=='Army' }">军队</c:when>
       <c:when test="${account.workNature=='StateOwned_Enterprise' }">国企</c:when>
       <c:when test="${account.workNature=='Institution' }">事业单位</c:when>
       <c:when test="${account.workNature=='Government_Agency' }">政府机构</c:when>
       </c:choose>
         </td></tr>
         <tr><td><b>工作职位：</b>${account.position }"</td></tr>
         <tr><td><b>工作职称：</b>${account.workTitles }</td></tr>
         <tr><td><b>工作年限：</b>${account.workYear }</td></tr>
         <tr><td><b>工作简历：</b>${account.workDescription }</td></tr>
         <tr><td><b>培训和获奖信息：</b>${account.learnAndRewardInfo }</td></tr>
         <tr><td><b>备注：</b>${account.description }</td></tr>
         </tbody>
         </table>

         <r:a href="/account/${account.id }/edit" class="btn">编辑</r:a>
         &nbsp;&nbsp;
         <r:a href="/account" class="btn">返回</r:a>
         </form>
</r:layout>