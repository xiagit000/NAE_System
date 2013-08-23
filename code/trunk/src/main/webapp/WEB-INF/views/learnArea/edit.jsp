<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="r" tagdir="/WEB-INF/tags/r" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>


<r:layout title="培训区域添加" >
<script src="<c:url value="/resources/js/learnArea/add.js"/>" type="text/javascript"></script>
<jsp:include page="../layout/administrator_navbar.jsp" />
<div class="wrapper">

         <ul class="breadcrumb">
              <li><r:a href="/">首页</r:a> <span class="divider">/</span></li>
              <li><r:a href="/learnArea">培训区域管理</r:a> <span class="divider">/</span></li>
              <li class="active">培训区域更新</li>
          </ul>
            
         <form action="<c:url value='/learnArea/${learnArea.id }' />" method="POST">
         <input name="_method" type="hidden" value="put"/>
         <input id="name" name="name" type="hidden" value="${learnArea.name }"/>
         <input id="elCode" name="elCode" type="hidden" value="${learnArea.elCode }"/>
         
         <table class="table table-hover" >
         <tbody>
         <tr><td width="150"><b>招生区域代码：</b></td>
         <td><input name="code" value="${learnArea.code }"/></td></tr>
         <tr><td><b>招生区域选择：</b></td>
         <td>
          <select id="province">
         <c:forEach items="${provinces }" var="province" varStatus="st">
         <option value="${province.elCode }"  ${fn:substringBefore(learnArea.elCode,'-')==province.elCode?'selected':'' }>${province.name }</option>
         </c:forEach>
         </select>
         
         <select name="city" id="city">
         <c:forEach items="${cities }" var="city" varStatus="st">
         <option value="${city.elCode }"  ${learnArea.elCode==city.elCode?'selected':'' }>${city.name }</option>
         </c:forEach>
         </select>
         </td></tr>
         
         <tr><td><b>负责人姓名：</b></td>
         <td><input name="personIncharge" value="${learnArea.personIncharge }"/></td></tr>
         <tr><td><b>住址：</b></td>
         <td><input name="address" value="${learnArea.address }"/></td></tr>
         <tr><td><b>电话：</b></td>
         <td><input name="tel" value="${learnArea.tel }"/></td></tr>
         <tr><td><b>邮箱：</b></td>
         <td><input name="email" value="${learnArea.email }"/></td></tr>
         <tr><td><b>邮政编码：</b></td>
         <td><input name="zipCode" value="${learnArea.zipCode }"/></td></tr>
         <tr><td><b>是否开启：</b></td>
         <td><input type="checkbox" name="status" ${learnArea.status==true?'checked="checked"':""}/></td></tr>
         </tbody>
         <tr>
         	<td colspan="2">
         		 <input class="button" type="submit" value="提交"/>
         <r:a href="/learnArea" class="button">取消</r:a>
         	</td>
         </tr>
         </table>

        
         </form>
</div>
</r:layout>