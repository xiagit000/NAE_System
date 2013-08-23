<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="r" tagdir="/WEB-INF/tags/r" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html>
<head>
<title>登录</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />

<link rel="icon" href="<c:url value="/resources/images/index.ico" />"    type="image/x-icon">

<link rel="stylesheet" href="<c:url value='/resources/css/base.css'/>" type="text/css" media="screen" />
<link rel="stylesheet" href="<c:url value='/resources/css/login.css'/>" type="text/css" media="screen" />

<script src="<c:url value='/resources/js/jquery-1.9.1.min.js'/>"></script>
<script src="<c:url value='/resources/js/jquery.KinSlideshow-1.1.js'/>"></script>
<script src="<c:url value='/resources/js/application.js'/>"></script>
<script src="<c:url value='/resources/js/login.js'/>"></script>
</head>
<body>

	<div class="wrap">
		<p class="header">		
		</p>
		<div class="menu">
	<ul class="menu_ul">
		<c:forEach items="${navigation}" var="nav">
		<li id="line">
			<span>${nav.key.name}</span>
			<c:if test="${nav.value ne null}">
				<ul class="menu_li" style="display:none;">
				<c:forEach items="${nav.value}" var="children">
						<li><a href="###">${children.name}</a></li>
				</c:forEach>
				</ul>
			</c:if>
		</li>	
		</c:forEach>
		
		
	</ul>
	<form class="seach">
		<input type="text" class="seach_input" />
		<input type="button" value=" " class="seach_button"></input>
				
	</form>
</div>
		<div class="content">
			<div class="new">
				<h1 class="title"><r:a  class="more" href="/news/tzgg">更多</r:a><span class="title_span">通知公告</span></h1>
				<ul class="ggLists">
					<c:forEach items="${tzgg}" var="tt" varStatus="status">
						<c:if test="${status.index<8}">
							<li><r:a  href="/news/${tt.id}" target="_blank" title="${tt.title}"><c:if test="${fn:length(tt.title) > 30}">${fn:substring(tt.title, 0, 30)}...</c:if><c:if test="${fn:length(tt.title) <= 30}">${tt.title}</c:if></r:a></li>
						</c:if>
					</c:forEach>	
				</ul>
			
			</div>
			<div class="new_right" >
				<div id="slide" class="photoWall">
					<c:forEach items="${tpq}" var="tp">
					<r:a href="/news/${tp.id}">
						<img src="<c:url value='upload/${tp.imagePath}' />" alt="${tp.title}"></img>
					</r:a>
					</c:forEach>
				</div>
				
				<div style="height: 70px;">
						<h3 class="title" style="font-size: 18px;text-align: center;" ><a href="#">${walldown.title}</a></h3>
						<p class="title_p">${walldown.content}</p>
				</div>
				
				
				
			</div>
			<div class="img_enter">
				<r:a href="/mystudyspace"><img src="<c:url value='/resources/images/img01.png' />"></img></r:a>
				<r:a href="/help"><img src="<c:url value='/resources/images/img02.jpg' />"></img></r:a>
				<r:a href="/mypersonal"><img src="<c:url value='/resources/images/img03.jpg' />"></img></r:a>
				<r:a href="/login"><img src="<c:url value='/resources/images/img04.jpg' />"></img></r:a>
			
			</div>
			<div class="clear"></div>
			<div class="inform fl">		
				<h1 class="title"><a class="more" href="###">更多</a><span class="title_span">国培计划</span></h1>
				<p class="img">
					<a href="#"><img src="<c:url value='/resources/images/pic_A01.jpg"'/>"></a>
				</p>
				<ul class="lists fr">
					<c:forEach items="${gpjh}" var="gp">
					<li><r:a class="gray" href="/news/${gp.id}" target="_blank" title="${gp.title}">${gp.title}</r:a></li>
					</c:forEach>  
				</ul>
				
			</div>
			
			<div class="inform fr">
				<h1 class="title"><a class="more" href="###">更多</a><span class="title_span">典型问题集锦</span></h1>
				<p class="img">
					<a href="#"><img src="<c:url value='/resources/images/flash02.jpg"'/>"></a>
				</p>
				<ul class="lists fr">
					<c:forEach items="${dxwtjj}" var="dxwt">
						<li><r:a href="/news/${dxwt.id}" target="_blank" title="${dxwt.title}">${dxwt.title}</r:a></li>
					</c:forEach>
				</ul>
			</div>
			
			<div class="scollingIMG fl">
				<h1 class="title"><span class="title_span">教师风采</span></h1>	
				<div class="sc_menu">
					<ul class="sc_menu">
						<c:forEach items="${jsfc}" var="js">
						<li><r:a href="/news/${js.id}"><img src="<c:url value='/upload/${js.imagePath}' />" alt="${js.title}"/><span>${js.title}</span></r:a></li>
						</c:forEach>
					</ul>
				</div>
			</div>
			<div class="zsInfo fl">		
				<h1 class="title"><a class="more" href="###">更多</a><span class="title_span">招生服务信息</span></h1>
				<ul class="zsLists fl">
					<c:forEach items="${zsfw}" var="zs">
					<li><r:a  href="/news/${zs.id}" target="_blank" title="${zs.title}">${zs.title}</r:a></li>
				    </c:forEach>
				</ul>
			</div>
			
			<div class="firstSmallInform fl">
				<h1 class="title"><a class="more" href="###">更多</a><span class="title_span">教学服务信息</span></h1>
				<ul class="lists fl">
					<c:forEach items="${jxfw}" var="jx">
					<li><r:a href="/news/${jx.id}" target="_blank" title="${jx.title}">${jx.title}</r:a></li>
					</c:forEach>
				</ul>
			</div>
			<div class="smallInform fl">
				<h1 class="title"><a class="more" href="###">更多</a><span class="title_span">学务信息</span></h1>
				<ul class="lists fl">
					<c:forEach items="${xwxx}" var="xw">
						<li><r:a href="/news/${xw.id}" target="_blank" title="${xw.title}">${xw.title}</r:a></li>
					</c:forEach>
				</ul>
			</div>
			<div class="smallInform fl">
				<h1 class="title"><a class="more" href="###">更多</a><span class="title_span">培训感言</span></h1>
				<ul class="lists fl">
					<c:forEach items="${pxgy}" var="px">
					<li><r:a href="/news/${px.id}" target="_blank" title="${px.title}">${px.title}</r:a></li>
					</c:forEach>
				</ul>
			</div>
			<div class="scollingInfo fl">
				<h1 class="title"><span class="title_span">图文资讯</span></h1>	
				<div class="sc_menu1">
					<ul class="sc_menu1">
						<c:forEach items="${twzx}" var="tw">
						<li><r:a href="/news/${tw.id}"><img class="InfoImage" src="<c:url value='/upload/${tw.imagePath}' />" title="${tw.title}"/><span>${tw.title}</span></r:a></li>
						</c:forEach>
					</ul>
				</div>
			</div>
			

			<div class="clear"></div>
			
			<div class="tabs">
			<h1 class="tabs_title">
				<span>
					<ul class="tabUl">
						<li class="tabOn" data-target="tab0">名校巡礼</li>
						<li data-target="tab1">友情链接</li>
					</ul>
				</span>	
				<a href="###" class="more">更多</a>
	        </h1>
			<div class="p10 clearfix">
			<div class="tabCon" style="display: block;" id="tab0">
				<ul class="listPhoto">
					<li><a href="http://www.ccnu.edu.cn/"><img src="<c:url value='resources/images//huazhongshifan.jpg"'/>" /></a><span><a href="#">华中师范大学</a></span></li>
					<li><a href="http://www.bnu.edu.cn/"><img src="<c:url value='resources/images/beijingshifan.jpg"'/>" /></a><span><a href="#">北京师范大学</a></span></li>
	               <li><a href="http://www.ecnu.edu.cn/"><img src="<c:url value='resources/images/huadongshifan.jpg"'/>" /></a><span><a href="#">华东师范大学</a></span></li>
	               <li><a href="http://www.scnu.edu.cn/scnu/"><img src="<c:url value='resources/images/huananshifan.jpg"'/>" /></a><span><a href="#">华南师范大学</a></span></li>
	               <li><a href="http://www.nenu.edu.cn/"><img src="<c:url value='resources/images/dongbeishifan.jpg"'/>" /></a><span><a href="#">东北师范大学</a></span></li>
	               <li><a href="http://www.snnu.edu.cn/"><img src="<c:url value='resources/images/shanxishifan.jpg"'/>" /></a><span><a href="#">陕西师范大学</a></span></li>
	               <li><a href="http://www.swnu.edu.cn/"><img src="<c:url value='resources/images/xinandaxue.jpg"'/>" /></a><span><a href="#">西南大学</a></span></li>
				</ul>
			</div>
			<div class="tabCon" style="display: none;" id="tab1">

				<ul class="listPhoto">
					<li>
						<a href="http://www.moe.gov.cn/">
							<img src="<c:url value='resources/images/11.png"'/>" />
						</a>
						<span>
							<a href="http://www.moe.gov.cn/">中国人民共和国教育部</a>
						</span>
					</li>
					<li>
						<a href="http://resource.jingpinke.com/">
							<img src="<c:url value='resources/images/22.gif"'/>" />
						</a>
						<span>
							<a href="http://resource.jingpinke.com/">国家精品课程资源网</a>
						</span>
					</li>
					<li>
						<a href="http://gxsb.e21.cn/jpkc/jpkc.php">
							<img src="<c:url value='resources/images/33.gif"'/>" />
						</a>
						<span>
							<a href="http://gxsb.e21.cn/jpkc/jpkc.php">湖北省高等学校精品课程资源共享平台</a>
						</span>
					</li>
					<li>
						<a href="http://www.ccnu.edu.cn/">
							<img src="<c:url value='resources/images/44.jpg"'/>" />
						</a>
						<span>
							<a href="http://www.ccnu.edu.cn/">华中师范大学</a>
						</span>
					</li>
					<li>
						<a href="http://www.hznu.cn/">
							<img src="<c:url value='resources/images/55.gif"'/>" />
						</a>
						<span>
							<a href="http://www.hznu.cn/">华中师范大学职业与继续教育学院</a>
						</span>
					</li>
					<li>
						<a href="http://www.chinaonlineedu.com/">
							<img src="<c:url value='resources/images/66.gif"'/>" />
						</a>
						<span>
							<a href="http://www.chinaonlineedu.com/">中国网络教育</a>
						</span>
					</li>
					<li>
						<a href="http://www.cdce.cn/">
							<img src="<c:url value='resources/images/77.gif"'/>" />
						</a>
						<span>
							<a href="http://www.cdce.cn/">中国现代远程与继续教育网</a>
						</span>
					</li>
				</ul>
			</div>
		</div>
		</div>
		
		

		<div class="clear"></div>
		<div class="add">
				<h1 class="add_title">
					<span class="more add_more"></span>
					<span class="add_span">总计：</span>
				</h1>	
				<table class="table" border="1">
					<thead>
						<tr>
							<th>省份统计</th>
							<td>${totalStatistics.citiesCount}</td>
							<th>班级数统计</th>
							<td>${totalStatistics.learnClassCount}</td>
							<th>学员数统计(注册/激活)</th>
							<td>${totalStatistics.classMateInfo}</td>
						</tr>
						<tr>
							<th>在线总时长</th>
							<td>${totalStatistics.onlineTimeCount}</td>
							<th>学员作业统计</th>
							<td>${totalStatistics.learnThesisInfo}</td>
							<th>学员问题统计</th>
							<td>${totalStatistics.questionInfo}</td>
						</tr>
					</thead>
				</table>
		</div>
		<div class="clear"></div>
		<div class="add">
				<h1 class="add_title">
					<span class="more add_more"></span>
					<span class="add_span">省统计情况：</span>
				</h1>	
				<table class="table" border="1">
					<thead>
						<tr>
							<th>省份名称</th>
							<th>所含培训区域数量</th>
							<th>班级数统计</th>
							<th>学员数统计</th>
							<th>教师数统计</th>
							<th>作业统计</th>
							<th>问题统计</th>
						</tr>
						<c:forEach items="${provinceStatistics}" var="ps">
							<tr>
							<td>${ps.province.name}</td>
							<td>${ps.citiesCount}</td>
							<td>${ps.learnClassCount}</td>
							<td>${ps.classMateInfo}</td>
							<td>${ps.teacherCount}</td>
							<td>${ps.learnThesisInfo}</td>
							<td>${ps.questionInfo}</td>
						</tr>
						</c:forEach>
						
					</thead>
				</table>
		</div>
		<div class="clear"></div>
		<div class="footer">
			技术支持：国家数字化学习工程技术研究中心
		</div>
			<div class="clear"></div>
	</div>
</div>
		<div class="clear"></div>
</body>
</html>