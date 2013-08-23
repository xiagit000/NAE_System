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
         <form id="add_form" action="<c:url value='/account/${account.id }' />" method="POST">
         <input name="_method" type="hidden" value="put"/>
         <input name="id" type="hidden" value="${account.id }"/>
         <table class="table table-hover" >
         <tbody>
         <tr><td><b>姓名：</b><input name="name" value="${account.name }"/></td></tr>
         <tr><td><b>性别：</b>
         <input type="radio" name="sex" value="男" ${account.sex=="男"?"checked=true":""}/>男
         &nbsp;&nbsp;
         <input type="radio" name="sex" value="女" ${account.sex=="女"?"checked=true":""}/>女
         </td></tr>
         <tr><td><b>民族：</b><input name="ethnic" value="${account.ethnic }"/></td></tr>
         <tr><td><b>证件类型：</b>
         <select name="idType" >
         <option value="ID_Cards" ${account.idType=="ID_Cards"?"selected='selected'":""}>身份证</option>
         <option value="Passport" ${account.idType=="Passport"?"selected='selected'":""}>护照</option>
         <option value="Certificate_Of_Officers" 
         ${account.idType=="Certificate_Of_Officers"?"selected='selected'":""}>军官证</option>
         <option value="Valid_Exit_Entry_Permit_To_HK_Macau" 
         ${account.idType=="Valid_Exit_Entry_Permit_To_HK_Macau"?"selected='selected'":""}>港澳台通行证</option>
         <option value="Other" ${account.idType=="Other"?"selected='selected'":""}>其他</option>
         </select>
         </td></tr>
         <tr><td><b>证件号：</b><input name="idNumber" value="${account.idNumber }"/></td></tr>
         <tr><td><b>目前所在大学：</b><input name="school" value="${account.school }"/></td></tr>
         <tr><td><b>政治面貌：</b>
         <select name="politicallandscape">
         <option value="Communist_Party" ${account.politicallandscape=="Communist_Party"?"selected='selected'":""}>共产党</option>
         <option value="Communist_Youth_League" ${account.politicallandscape=="Communist_Youth_League"?"selected='selected'":""}>共青团</option>
         <option value="Masses" ${account.politicallandscape=="Masses"?"selected='selected'":""}>其他</option>
         </select>
         </td></tr>
         <tr><td><b>居住地：</b><input name="address" value="${account.address }"/></td></tr>
         <tr><td><b>联系地址：</b><input name="contactAddr" value="${account.contactAddr }"/></td></tr>
         <tr><td><b>邮政编码：</b><input name="zipCode" value="${account.zipCode }"/></td></tr>
         <tr><td><b>邮箱：</b><input  name="email" value="${account.email }"/></td></tr>
         <tr><td><b>联系电话：</b><input  name="tel" value="${account.tel }"/></td></tr>
         <tr><td><b>最高学位：</b>
         <select name="hignestDegree">
         <option value="">请选择</option>
         <option value="Bachelor" ${account.hignestDegree=="Bachelor"?"selected='selected'":""}>学士</option>
         <option value="Master" ${account.hignestDegree=="Master"?"selected='selected'":""}>硕士</option>
         <option value="Doctor" ${account.hignestDegree=="Doctor"?"selected='selected'":""}>博士</option>
         </select>
         </td></tr>
         <tr><td><b>最高学历：</b>
         <select name="highestEducationalBackground">
         <option value="High_School" ${account.highestEducationalBackground=="High_School"?"selected='selected'":""}>高中</option>
         <option value="Technician_Training_School" ${account.highestEducationalBackground=="Technician_Training_School"?"selected='selected'":""}>技校</option>
         <option value="Trade_School" ${account.highestEducationalBackground=="Trade_School"?"selected='selected'":""}>中专</option>
         <option value="Junior_College" ${account.highestEducationalBackground=="Junior_College"?"selected='selected'":""}>大专</option>
         <option value="Undergraduate_College" ${account.highestEducationalBackground=="Undergraduate_College"?"selected='selected'":""}>本科</option>
         <option value="Graduate_Student" ${account.highestEducationalBackground=="Graduate_Student"?"selected='selected'":""}>研究生</option>
         <option value="Other" ${account.highestEducationalBackground=="Other"?"selected='selected'":""}>其他</option>
         </select>
         </td></tr>
         <tr><td><b>毕业院校：</b><input  name="graduatedSchool" value="${account.graduatedSchool }"/></td></tr>
         <tr><td><b>毕业专业：</b><input  name="graduatedSpecialty" value="${account.graduatedSpecialty }"/></td></tr>
         <tr><td><b>工作单位：</b><input  name="workPlace" value="${account.workPlace }"/></td></tr>
         <tr><td><b>工作性质：</b>
         <select name="workNature">
         <option value="Foreign_Funded_Enterprises" ${account.workNature=="Foreign_Funded_Enterprises"?"selected='selected'":""}>外企</option>
         <option value="Joint_Venture" ${account.workNature=="Joint_Venture"?"selected='selected'":""}>合资企业</option>
         <option value="Private_Enterprise" ${account.workNature=="Private_Enterprise"?"selected='selected'":""}>私企</option>
         <option value="Army" ${account.workNature=="Army"?"selected='selected'":""}>军队</option>
         <option value="StateOwned_Enterprise" ${account.workNature=="StateOwned_Enterprise"?"selected='selected'":""}>国企</option>
         <option value="Institution" ${account.workNature=="Institution"?"selected='selected'":""}>事业单位</option>
         <option value="Government_Agency" ${account.workNature=="Government_Agency"?"selected='selected'":""}>政府机构</option>
         </select>
         </td></tr>
         <tr><td><b>工作职位：</b><input  name="position" value="${account.position }"/></td></tr>
         <tr><td><b>工作职称：</b><input  name="workTitles" value="${account.workTitles }"/></td></tr>
         <tr><td><b>工作年限：</b><input  name="workYear" value="${account.workYear }"/></td></tr>
         <tr><td><b>工作简历：</b><input  name="workDescription" value="${account.workDescription }"/></td></tr>
         <tr><td><b>培训和获奖信息：</b><input  name="learnAndRewardInfo" value="${account.learnAndRewardInfo }"/></td></tr>
         <tr><td><b>备注：</b><input  name="description" value="${account.description }"/></td></tr>
         </tbody>
         </table>

         <input class="btn btn-primary" type="submit" value="提交"/>
         &nbsp;&nbsp;
         <r:a href="/account" class="btn">取消</r:a>
         </form>
</r:layout>