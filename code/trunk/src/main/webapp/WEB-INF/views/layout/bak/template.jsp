<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>  
<%@ taglib prefix="r" tagdir="/WEB-INF/tags/r"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<r:yieldTitle prefix="Demo | "></r:yieldTitle>
<link rel="stylesheet" href="<c:url value='/resources/css/bootstrap.min.css'/>" type="text/css" media="screen" />

<r:yieldStylesheets></r:yieldStylesheets>
<style type="text/css">
    body {
      padding-top: 60px;
      padding-bottom: 40px;
    }
    .sidebar-nav {
      padding: 9px 0;
    }
</style>

<script src="<c:url value='/resources/js/jquery-1.8.2.js'/>"></script>
<script src="<c:url value='/resources/js/bootstrap.min.js'/>"></script>
<script src="<c:url value='/resources/js/jquery.validate.min.js' />"></script>
<script src="<c:url value='/resources/js/rails.js' />"></script>
<script src="<c:url value="/resources/js/My97DatePicker/WdatePicker.js"/>" type="text/javascript"></script>
<r:yieldJavascripts />

</head>
<body>
  <div class="navbar navbar-inverse navbar-fixed-top" >
    <div class="navbar-inner" >
      <div class="container-fluid" style="background-color:#08c;">
        <a class="brand" href="#"><font color="white"><b>华中师范大学非学历远程教育业务管理平台</b></font></a>
        <div class="nav-collapse collapse">
          <ul class="nav pull-right" id="userbar">
            <li>
              <a href="/notifications" id="user_notifications_count"><span class="badge ">站内信[0]</span></a>
            </li>
            <li class="dropdown" id="user_menu">
              <a href="#user_menu" class="dropdown-toggle" data-toggle="dropdown"><i class="icon-user icon-white"></i>用户名</a>
            </li>
          </ul> 
         </div>
	</div>
    </div>
  </div>

  <div class="container-fluid main-wrapper">
    <div class="row-fluid">
          <jsp:include page="navbar.jsp"></jsp:include>
      <div class="span10">
        <div class="box">
        <c:if test="${message ne null}">
        	<div class="alert alert-success">
        		<button type="button" class="close" data-dismiss="alert">×</button>
        		${message}
        	</div>
        </c:if>
        <c:if test="${warning ne null}">
        	<div class="alert">
  				<button type="button" class="close" data-dismiss="alert">×</button>
				${warning}  
			</div>
        </c:if>
        <c:if test="${error ne null}">
        	<div class="alert alert-error">
  				<button type="button" class="close" data-dismiss="alert">×</button>
  				${error}
			</div>
        </c:if>
        <r:yieldBody></r:yieldBody>
        </div>
      </div>
    </div>
  </div>

</body>
</html>