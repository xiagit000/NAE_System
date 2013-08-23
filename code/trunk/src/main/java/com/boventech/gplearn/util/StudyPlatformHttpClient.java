package com.boventech.gplearn.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import sun.misc.BASE64Encoder;

import com.boventech.gplearn.entity.Constants;
import com.boventech.gplearn.entity.SchoolSpace;
import com.boventech.gplearn.entity.SpaceType;
import com.boventech.gplearn.entity.User;
import com.boventech.gplearn.entity.User.UserType;
import com.google.common.collect.Lists;

public class StudyPlatformHttpClient {

	private static final Logger LOGGER = LoggerFactory.getLogger(StudyPlatformHttpClient.class);
	
	private DefaultHttpClient client;
	
	private BASE64Encoder encoder;
	
	private String baseURL;
	
	private String account;
	
	private String secret;
	
	public StudyPlatformHttpClient(){
		this.client=new DefaultHttpClient();
		this.encoder = new BASE64Encoder();
		this.baseURL=LoadProperties.getProperty(Constants.STUDY_PLATFORM_URL);
		this.account=this.encoder.encode(LoadProperties.getProperty(Constants.STUDY_PLATFORM_X_ACCOUNT).getBytes());
		this.secret=this.encoder.encode(LoadProperties.getProperty(Constants.STUDY_PLATFORM_X_SECRET).getBytes());
	}
	
	/**
	 * 创建SAKAI课程空间
	 * @param disciplineId 学科ID 
	 * @param title 学科空间的空间名
	 * @return 返回HTTP的响应状态码
	 */
	public Integer createStudySpace(String disciplineId,String title){
		Integer statusCode=0;
		String courseId = Constants.STUDY_PLATFORM_DISCIPLINESPACE_PREFIX+disciplineId;
		String createUrl = LoadProperties
				.getProperty(Constants.STUDY_PLATFORM_CREATESPACE_URL_KEY);
		String postUrl = this.baseURL + createUrl;
		title =LoadProperties.getProperty(Constants.DISCIPLINESPACE_TITLE_PREFIX_KEY)+"["+title+"]";
		HttpPost httpPost=new HttpPost(postUrl);
		httpPost.setHeader(Constants.STUDY_PLATFORM_X_ACCOUNT,this.account);
		httpPost.setHeader(Constants.STUDY_PLATFORM_X_SECRET,this.secret );
		httpPost.setHeader(Constants.STUDY_PLATFORM_COURSEID,courseId);
		try {
			title=this.encoder.encode(title.getBytes("UTF-8"));
		} catch (UnsupportedEncodingException e1) {
			LOGGER.error(e1.getMessage());
		}
		httpPost.setHeader(Constants.STUDY_PLATFORM_TITLE,title);
		
		try {
			HttpResponse response = this.client.execute(httpPost);
			statusCode = response.getStatusLine().getStatusCode();
			String backInfo = translateInputStreamToString(response.getEntity().getContent());
			System.out.println("createStudySpace["+statusCode+"]"+backInfo);
			httpPost.abort();
		} catch (ClientProtocolException e) {
			LOGGER.error(e.getMessage());
		} catch (IOException e) {
			LOGGER.error(e.getMessage());
		}
		return statusCode;
	}
	
	/**
	 * 创建SAKAI学校空间
	 * @param disciplineId 学科ID 
	 * @param title 校本研修空间的空间名
	 * @return 返回HTTP的响应状态码
	 */
	public Integer createSchoolSpace(SchoolSpace schoolspace) {
		Integer statusCode=0;
		String courseId = Constants.STUDY_PLATFORM_SCHOOLSPACE_PREFIX+schoolspace.getId();
		String title=schoolspace.getSchoolName();
		title =LoadProperties.getProperty(Constants.SCHOOL_TITLE_PREFIX_KEY)+"["+title+"]";
		String createUrl = LoadProperties
				.getProperty(Constants.STUDY_PLATFORM_CREATESPACE_URL_KEY);
		String postUrl = this.baseURL + createUrl;
		HttpPost httpPost=new HttpPost(postUrl);
		httpPost.setHeader(Constants.STUDY_PLATFORM_X_ACCOUNT,this.account);
		httpPost.setHeader(Constants.STUDY_PLATFORM_X_SECRET,this.secret );
		httpPost.setHeader(Constants.STUDY_PLATFORM_COURSEID,courseId);
		try {
			title=this.encoder.encode(title.getBytes("UTF-8"));
		} catch (UnsupportedEncodingException e1) {
			LOGGER.error(e1.getMessage());
		}
		httpPost.setHeader(Constants.STUDY_PLATFORM_TITLE,title);
		
		try {
			HttpResponse response = this.client.execute(httpPost);
			statusCode = response.getStatusLine().getStatusCode();
			String backInfo = translateInputStreamToString(response.getEntity().getContent());
			System.out.println("createSchoolSpace["+statusCode+"]"+backInfo);
			httpPost.abort();
		} catch (ClientProtocolException e) {
			LOGGER.error(e.getMessage());
		} catch (IOException e) {
			LOGGER.error(e.getMessage());
		}
		return statusCode;
	}
	
	/**
	 * 创建SAKAI校本研修空间
	 * @param disciplineId 学科ID 
	 * @param title 校本研修空间的空间名
	 * @return 返回HTTP的响应状态码
	 */
	public Integer createXBYXSpace(String disciplineId,String title){
		Integer statusCode=0;
		String courseId = Constants.STUDY_PLATFORM_XBYX_PREFIX+disciplineId;
		String createUrl = LoadProperties
				.getProperty(Constants.STUDY_PLATFORM_CREATESPACE_URL_KEY);
		String postUrl = this.baseURL + createUrl;
		title =LoadProperties.getProperty(Constants.XBYX_TITLE_PREFIX_KEY)+"["+title+"]";
		HttpPost httpPost=new HttpPost(postUrl);
		httpPost.setHeader(Constants.STUDY_PLATFORM_X_ACCOUNT,this.account);
		httpPost.setHeader(Constants.STUDY_PLATFORM_X_SECRET,this.secret );
		httpPost.setHeader(Constants.STUDY_PLATFORM_COURSEID,courseId);
		try {
			title=this.encoder.encode(title.getBytes("UTF-8"));
		} catch (UnsupportedEncodingException e1) {
			LOGGER.error(e1.getMessage());
		}
		httpPost.setHeader(Constants.STUDY_PLATFORM_TITLE,title);
		
		try {
			HttpResponse response = this.client.execute(httpPost);
			statusCode = response.getStatusLine().getStatusCode();
			String backInfo = translateInputStreamToString(response.getEntity().getContent());
			System.out.println("createXBYXSpace["+statusCode+"]"+backInfo);
			httpPost.abort();
		} catch (ClientProtocolException e) {
			LOGGER.error(e.getMessage());
		} catch (IOException e) {
			LOGGER.error(e.getMessage());
		}
		return statusCode;
	}
	
	 /**
	 * 添加用户到指定的学校空间
	 * @param user
	 * @param schoolSpace
	 * @return
	 */
	public Integer createUserToSchoolpace(User user,SchoolSpace schoolSpace){
		Integer statusCode = null;
		String courseId=Constants.STUDY_PLATFORM_SCHOOLSPACE_PREFIX+schoolSpace.getId();
		String createURL=LoadProperties.getProperty(Constants.STUDY_PLATFORM_ADDUSERTOSPACE_URL_KEY);
		String role = checkUserRole(user);
		String postURL=this.baseURL+createURL;
		HttpPost httpPost = new HttpPost(postURL);
		httpPost.setHeader(Constants.STUDY_PLATFORM_X_ACCOUNT,this.account);
		httpPost.setHeader(Constants.STUDY_PLATFORM_X_SECRET, this.secret);
		httpPost.setHeader(Constants.STUDY_PLATFORM_USERNAME,user.getLoginName());
		String username=user.getRealName();
		try {
			username=this.encoder.encode(username.getBytes("UTF-8"));
		} catch (UnsupportedEncodingException e1) {
			LOGGER.error(e1.getMessage());
		}
		httpPost.setHeader(Constants.STUDY_PLATFORM_REALNAME,username);
		httpPost.setHeader(Constants.STUDY_PLATFORM_ROLE,role);
		httpPost.setHeader(Constants.STUDY_PLATFORM_COURSEID, courseId);
		
		try {
			HttpResponse response = this.client.execute(httpPost);
			statusCode = response.getStatusLine().getStatusCode();
			String backInfo = translateInputStreamToString(response.getEntity().getContent());
			System.out.println("createUserToSchoolpace["+statusCode+"]"+backInfo);
			httpPost.abort();
		} catch (ClientProtocolException e) {
			LOGGER.error(e.getMessage());
		} catch (IOException e) {
			LOGGER.error(e.getMessage());
		}
		return statusCode;
	}
	
	/**
	 * 添加用户到指定的校本研修空间
	 * @param user
	 * @param disciplineId
	 * @return
	 */
	public Integer createUserToXBYXSpace(User user,String disciplineId){
		Integer statusCode = null;
		String courseId=Constants.STUDY_PLATFORM_XBYX_PREFIX+disciplineId;
		String createURL=LoadProperties.getProperty(Constants.STUDY_PLATFORM_ADDUSERTOSPACE_URL_KEY);
		String role = checkUserRole(user);
		String postURL=this.baseURL+createURL;
		HttpPost httpPost = new HttpPost(postURL);
		httpPost.setHeader(Constants.STUDY_PLATFORM_X_ACCOUNT,this.account);
		httpPost.setHeader(Constants.STUDY_PLATFORM_X_SECRET, this.secret);
		httpPost.setHeader(Constants.STUDY_PLATFORM_USERNAME,user.getLoginName());
		String username=user.getRealName();
		try {
			username=this.encoder.encode(username.getBytes("UTF-8"));
		} catch (UnsupportedEncodingException e1) {
			LOGGER.error(e1.getMessage());
		}
		httpPost.setHeader(Constants.STUDY_PLATFORM_REALNAME,username);
		httpPost.setHeader(Constants.STUDY_PLATFORM_ROLE,role);
		httpPost.setHeader(Constants.STUDY_PLATFORM_COURSEID, courseId);
		
		try {
			HttpResponse response = this.client.execute(httpPost);
			statusCode = response.getStatusLine().getStatusCode();
			String backInfo = translateInputStreamToString(response.getEntity().getContent());
			System.out.println("createUserToXBYXSpace["+statusCode+"]"+backInfo);
			httpPost.abort();
		} catch (ClientProtocolException e) {
			LOGGER.error(e.getMessage());
		} catch (IOException e) {
			LOGGER.error(e.getMessage());
		}
		return statusCode;
	}
	
	/**
	 * 添加用户到指定的学科空间(学科专家)
	 * @param user
	 * @param disciplineId
	 * @return
	 */
	public Integer createUserToStudySpace(User user,String disciplineId){
		Integer statusCode = null;
		String courseId=Constants.STUDY_PLATFORM_DISCIPLINESPACE_PREFIX+disciplineId;
		String createURL=LoadProperties.getProperty(Constants.STUDY_PLATFORM_ADDUSERTOSPACE_URL_KEY);
		String role = checkUserRole(user);
		String postURL=this.baseURL+createURL;
		HttpPost httpPost = new HttpPost(postURL);
		httpPost.setHeader(Constants.STUDY_PLATFORM_X_ACCOUNT,this.account);
		httpPost.setHeader(Constants.STUDY_PLATFORM_X_SECRET, this.secret);
		httpPost.setHeader(Constants.STUDY_PLATFORM_USERNAME,user.getLoginName());
		String username=user.getRealName();
		try {
			username=this.encoder.encode(username.getBytes("UTF-8"));
		} catch (UnsupportedEncodingException e1) {
			LOGGER.error(e1.getMessage());
		}
		httpPost.setHeader(Constants.STUDY_PLATFORM_REALNAME,username);
		httpPost.setHeader(Constants.STUDY_PLATFORM_ROLE,role);
		httpPost.setHeader(Constants.STUDY_PLATFORM_COURSEID, courseId);
		
		try {
			HttpResponse response = this.client.execute(httpPost);
			statusCode = response.getStatusLine().getStatusCode();
			String backInfo = translateInputStreamToString(response.getEntity().getContent());
			System.out.println("createUserToStudySpace["+statusCode+"]"+backInfo);
			httpPost.abort();
		} catch (ClientProtocolException e) {
			LOGGER.error(e.getMessage());
		} catch (IOException e) {
			LOGGER.error(e.getMessage());
		}
		return statusCode;
	}
	
	/**
	 * 在学科空间创建班级小组
	 * @param disciplineSpaceId 班级所属学科的Id
	 * @param title 班级名称
	 * @return 班级的访问ID
	 */
	public String createClassRoomInStudySpace(String disciplineId,String title){
		String classAccessId = null;
		String createUrl=LoadProperties.getProperty(Constants.STUDY_PLATFORM_CREATECLASSROOM_URL_KEY);
		String postURL  =this.baseURL + createUrl;
		String courseId =Constants.STUDY_PLATFORM_DISCIPLINESPACE_PREFIX+disciplineId; 
		HttpPost httpPost = new HttpPost(postURL);
		httpPost.setHeader(Constants.STUDY_PLATFORM_X_ACCOUNT,this.account);
		httpPost.setHeader(Constants.STUDY_PLATFORM_X_SECRET, this.secret);
		httpPost.setHeader(Constants.STUDY_PLATFORM_COURSEID, courseId);
		try {
			title=this.encoder.encode(title.getBytes("UTF-8"));
		} catch (UnsupportedEncodingException e1) {
			LOGGER.error(e1.getMessage());
		}
		httpPost.setHeader(Constants.STUDY_PLATFORM_TITLE, title);
		
		try {
			HttpResponse response = this.client.execute(httpPost);
			Integer statusCode = response.getStatusLine().getStatusCode();
			if(statusCode ==200){
				classAccessId=response.getFirstHeader(Constants.RESPONSE_BACK_HEADER_GROUPID).getValue();
			}
			String backInfo = translateInputStreamToString(response.getEntity().getContent());
			System.out.println("createClassRoomInStudySpace["+classAccessId+"]"+backInfo);
			httpPost.abort();
		} catch (ClientProtocolException e) {
			LOGGER.error(e.getMessage());
		} catch (IOException e) {
			LOGGER.error(e.getMessage());
		}
		return classAccessId;
	}
	
	/**
	 * 修改学科空间内班级小组的名称
	 * @param disciplineId	班级所属学科的ID
	 * @param learnClassSpaceId 班级记录的访问学习空间的ID
	 * @param newTitle
	 * @return 返回HTTP请求响应状态
	 */
	public Integer upodateClassRoomTitleInStudySpace(String disciplineId,String learnClassSpaceId,String newTitle){
		Integer statusCode = null;
		String courseId=Constants.STUDY_PLATFORM_DISCIPLINESPACE_PREFIX+disciplineId;
		String updateURL=LoadProperties.getProperty(Constants.STUDY_PLATFORM_UPDATECLASSROOM_URL_KEY);
		String postUrl = this.baseURL+updateURL;
		HttpPost httpPost = new HttpPost(postUrl);
		httpPost.setHeader(Constants.STUDY_PLATFORM_X_ACCOUNT,this.account);
		httpPost.setHeader(Constants.STUDY_PLATFORM_X_SECRET, this.secret);
		httpPost.setHeader(Constants.STUDY_PLATFORM_COURSEID, courseId);
		httpPost.setHeader(Constants.STUDY_PLATFORM_GROUPID, learnClassSpaceId);
		try {
			newTitle=this.encoder.encode(newTitle.getBytes("UTF-8"));
		} catch (UnsupportedEncodingException e1) {
			LOGGER.error(e1.getMessage());
		}
		httpPost.setHeader(Constants.STUDY_PLATFORM_TITLE,newTitle);
		try {
			HttpResponse response = this.client.execute(httpPost);
			statusCode = response.getStatusLine().getStatusCode();
			String backInfo = translateInputStreamToString(response.getEntity().getContent());
			System.out.println("upodateClassRoomTitleInStudySpace["+statusCode+"]"+backInfo);
			httpPost.abort();
		} catch (ClientProtocolException e) {
			LOGGER.error(e.getMessage());
		} catch (IOException e) {
			LOGGER.error(e.getMessage());
		}
		return statusCode;
	}
	
	/**
	 * 删除学科空间内的班级小组
	 * @param disciplineId  所属学科的ID
	 * @param learnClassSpaceId 班级记录的访问学习空间的ID
	 * @return 返回HTTP请求响应状态
	 */
	public Integer destroyClassRoomInStudySpace(String disciplineId,String learnClassSpaceId){
		Integer statusCode = null;
		String courseID=Constants.STUDY_PLATFORM_DISCIPLINESPACE_PREFIX+disciplineId;
		String destroyURL=LoadProperties.getProperty(Constants.STUDY_PLATFORM_DELETECLASSROOM_URL_KEY);
		String postUrl = this.baseURL+destroyURL;
		HttpPost httpPost = new HttpPost(postUrl);
		httpPost.setHeader(Constants.STUDY_PLATFORM_X_ACCOUNT,this.account);
		httpPost.setHeader(Constants.STUDY_PLATFORM_X_SECRET, this.secret);
		httpPost.setHeader(Constants.STUDY_PLATFORM_COURSEID,courseID);
		httpPost.setHeader(Constants.STUDY_PLATFORM_GROUPID, learnClassSpaceId);
		try {
			HttpResponse response = this.client.execute(httpPost);
			statusCode = response.getStatusLine().getStatusCode();
			String backInfo = translateInputStreamToString(response.getEntity().getContent());
			System.out.println("destroyClassRoomInStudySpace["+statusCode+"]"+backInfo);
			httpPost.abort();
		} catch (ClientProtocolException e) {
			LOGGER.error(e.getMessage());
		} catch (IOException e) {
			LOGGER.error(e.getMessage());
		}
		return statusCode;
	}
	
	/**
	 * 从空间删除用户
	 * @param disciplineExpertLoginName 学科空间用户的登录名
	 * @param disciplineId 学科ID
	 * @return
	 */
	public Integer detroyUserFromStudySpace(String disciplineExpertLoginName,String id,SpaceType spaceType){
		Integer statusCode = null;
		String courseId=null;
		if(spaceType.equals(SpaceType.STUDY)){
			courseId=Constants.STUDY_PLATFORM_DISCIPLINESPACE_PREFIX+id;
		}
		if(spaceType.equals(SpaceType.SCHOOL)){
			courseId=Constants.STUDY_PLATFORM_SCHOOLSPACE_PREFIX+id;
		}
		if(spaceType.equals(SpaceType.XBYX)){
			courseId=Constants.STUDY_PLATFORM_XBYX_PREFIX+id;
		}
		String destroyURL=LoadProperties.getProperty(Constants.STUDY_PLATFORM_REMOVEUSERFROMSPACE_URL_KEY);
		String postURL=this.baseURL+destroyURL;
		HttpPost httpPost = new HttpPost(postURL);
		httpPost.setHeader(Constants.STUDY_PLATFORM_X_ACCOUNT,this.account);
		httpPost.setHeader(Constants.STUDY_PLATFORM_X_SECRET, this.secret);
		httpPost.setHeader(Constants.STUDY_PLATFORM_USERNAME,disciplineExpertLoginName);
		httpPost.setHeader(Constants.STUDY_PLATFORM_COURSEID, courseId);
		
		try {
			HttpResponse response = this.client.execute(httpPost);
			statusCode = response.getStatusLine().getStatusCode();
			String backInfo = translateInputStreamToString(response.getEntity().getContent());
			System.out.println("detroyUserFromStudySpace["+statusCode+"]"+backInfo);
			httpPost.abort();
		} catch (ClientProtocolException e) {
			LOGGER.error(e.getMessage());
		} catch (IOException e) {
			LOGGER.error(e.getMessage());
		}
		return statusCode;
	}
	
	/**
	 * 添加用户到学科空间的班级小组里
	 * @param user 用户模型
	 * @param learnClassSpaceId 学科内班级小组的访问ID
	 * @param disciplineId 学科ID
	 * @return
	 */
	public Integer createUserToStudySpaceClassRoom(User user,String learnClassSpaceId,String disciplineId){
		Integer statusCode = null;
		String courseId = Constants.STUDY_PLATFORM_DISCIPLINESPACE_PREFIX+disciplineId;
		String createURL=LoadProperties.getProperty(Constants.STUDY_PLATFORM_ADDUSERTOSPACECLASSROOM_URL_KEY);
		String postURL=this.baseURL+createURL;
		HttpPost httpPost = new HttpPost(postURL);
		httpPost.setHeader(Constants.STUDY_PLATFORM_X_ACCOUNT,this.account);
		httpPost.setHeader(Constants.STUDY_PLATFORM_X_SECRET, this.secret);
		httpPost.setHeader(Constants.STUDY_PLATFORM_COURSEID, courseId);
		httpPost.setHeader(Constants.STUDY_PLATFORM_GROUPID, learnClassSpaceId);
		httpPost.setHeader(Constants.STUDY_PLATFORM_USERNAME, user.getLoginName());
		try {
			HttpResponse response = this.client.execute(httpPost);
			statusCode = response.getStatusLine().getStatusCode();
			String backInfo = translateInputStreamToString(response.getEntity().getContent());
			System.out.println("createUserToStudySpaceClassRoom["+statusCode+"]"+backInfo);
			httpPost.abort();
		} catch (ClientProtocolException e) {
			LOGGER.error(e.getMessage());
		} catch (IOException e) {
			LOGGER.error(e.getMessage());
		}
		return statusCode;
	}
	
	/**
	 * 将用户从指定学科的指定班级小组中删除
	 * @param user
	 * @param learnClassSpaceId
	 * @param disciplineId
	 * @return
	 */
	public Integer destroyUserFromStudySpaceClassRoom(User user,String learnClassSpaceId,String disciplineId){
		Integer statusCode = null;
		String courseId = Constants.STUDY_PLATFORM_DISCIPLINESPACE_PREFIX+disciplineId;
		String destroyURL=LoadProperties.getProperty(Constants.STUDY_PLATFORM_REMOVEUSERFROMSPACECLASSROOM_URL_KEY);
		String postURL = this.baseURL+destroyURL;
		HttpPost httpPost = new HttpPost(postURL);
		httpPost.setHeader(Constants.STUDY_PLATFORM_X_ACCOUNT,this.account);
		httpPost.setHeader(Constants.STUDY_PLATFORM_X_SECRET, this.secret);
		httpPost.setHeader(Constants.STUDY_PLATFORM_COURSEID, courseId);
		httpPost.setHeader(Constants.STUDY_PLATFORM_GROUPID, learnClassSpaceId);
		httpPost.setHeader(Constants.STUDY_PLATFORM_USERNAME, user.getLoginName());
		try {
			HttpResponse response = this.client.execute(httpPost);
			statusCode = response.getStatusLine().getStatusCode();
			String backInfo = translateInputStreamToString(response.getEntity().getContent());
			System.out.println("destroyUserFromStudySpaceClassRoom["+statusCode+"]"+backInfo);
			httpPost.abort();
		} catch (ClientProtocolException e) {
			LOGGER.error(e.getMessage());
		} catch (IOException e) {
			LOGGER.error(e.getMessage());
		}
		return statusCode;
	}
	
	
	
	
	/********************************************************************************************************************
	 * ##########################################  Content HTTP Client API #############################################
	 * #################################################################################################################
	 ********************************************************************************************************************/
	
	
	/***
	 * 用户在课程空间的发帖和回帖数量统计
	 * List<Integer>总共就2个值. 下标为0的为发帖数,下标为1的是回帖数
	 */
	public List<Long> userForumCountInStudySpace(String courseId,String loginName,SpaceType spaceType){
		List<Long> forumCount = Lists.newArrayList();
		String getURL=this.baseURL+LoadProperties.getProperty(Constants.STUDY_PLATFORM_USERFORUMCOUNT_IN_STUDYSPACEURL_KEY);
		courseId=Constants.STUDY_PLATFORM_DISCIPLINESPACE_PREFIX+courseId;
		HttpGet get = new HttpGet(getURL);
		get.setHeader(Constants.STUDY_PLATFORM_X_ACCOUNT,this.account);
		get.setHeader(Constants.STUDY_PLATFORM_X_SECRET, this.secret);
		get.setHeader(Constants.STUDY_PLATFORM_COURSEID, courseId);
		get.setHeader(Constants.STUDY_PLATFORM_USERNAME, loginName);
		
		try {
			HttpResponse response = this.client.execute(get);
			Integer statusCode = response.getStatusLine().getStatusCode();
			String backInfo = translateInputStreamToString(response.getEntity().getContent());
			System.out.println("userForumCountInStudySpace["+statusCode+"]"+backInfo);
			if(statusCode==200){
				Long forum = Long.parseLong(response.getFirstHeader("result_forum_post").getValue());
				Long forumReply=Long.parseLong(response.getFirstHeader("result_forum_reply").getValue());
				forumCount.add(forum);
				forumCount.add(forumReply);
			}else{
				forumCount.add(-1L);
				forumCount.add(-1L);
			}
			get.abort();
		} catch (ClientProtocolException e) {
			LOGGER.error(e.getMessage());
		} catch (IOException e) {
			LOGGER.error(e.getMessage());
		}
		return forumCount;
	}
	
	
	/**
	 * 班级论坛的发帖回帖
	 * @param courseId
	 * @param classAccessId
	 * @return List<Integer>总共就2个值. 下标为0的为发帖数,下标为1的是回帖数
	 */
	public List<Long> classForumCountInStudySpace(String courseId,String classAccessId){
		List<Long> forumCount = Lists.newArrayList();
		String getRUL=this.baseURL+LoadProperties.getProperty(Constants.STUDY_PLATFORM_FORUMCOUNT_IN_CLASSURL_KEY);
		courseId =Constants.STUDY_PLATFORM_DISCIPLINESPACE_PREFIX+courseId;
		HttpGet get = new HttpGet(getRUL);
		get.setHeader(Constants.STUDY_PLATFORM_X_ACCOUNT,this.account);
		get.setHeader(Constants.STUDY_PLATFORM_X_SECRET, this.secret);
		get.setHeader(Constants.STUDY_PLATFORM_COURSEID, courseId);
		get.setHeader(Constants.STUDY_PLATFORM_GROUPID,classAccessId);

		try {
			HttpResponse response = this.client.execute(get);
			Integer statusCode = response.getStatusLine().getStatusCode();
			String backInfo = translateInputStreamToString(response.getEntity().getContent());
			System.out.println("classForumCountInStudySpace["+statusCode+"]"+backInfo);
			if(statusCode==200){
				Long forum = Long.parseLong(response.getFirstHeader("result_forum_post").getValue());
				Long forumReply=Long.parseLong(response.getFirstHeader("result_forum_reply").getValue());
				forumCount.add(forum);
				forumCount.add(forumReply);
			}else{
				forumCount.add(-1L);
				forumCount.add(-1L);
			}
			get.abort();
		} catch (ClientProtocolException e) {
			LOGGER.error(e.getMessage());
		} catch (IOException e) {
			LOGGER.error(e.getMessage());
		}
		return forumCount;
	}
	
	/**
	 * 学习系统的空间发帖回帖数
	 * @param courseId
	 * @param spaceType
	 * @return List<Integer>总共就2个值. 下标为0的为发帖数,下标为1的是回帖数
	 */
	public List<Long> studySpaceForumCount(String courseId,SpaceType spaceType){
		List<Long> forumCount = Lists.newArrayList();
		if(spaceType.equals(SpaceType.STUDY)){
			courseId=Constants.STUDY_PLATFORM_DISCIPLINESPACE_PREFIX+courseId;
		}
		if(spaceType.equals(SpaceType.SCHOOL)){
			courseId=Constants.STUDY_PLATFORM_SCHOOLSPACE_PREFIX+courseId;
		}
		if(spaceType.equals(SpaceType.XBYX)){
			courseId=Constants.STUDY_PLATFORM_XBYX_PREFIX+courseId;
		}
		String getURL=this.baseURL+LoadProperties.getProperty(Constants.STUDY_PLATFORM_FORUMCOUNT_IN_SPACEURL_KEY);
		HttpGet get = new HttpGet(getURL);
		get.setHeader(Constants.STUDY_PLATFORM_X_ACCOUNT,this.account);
		get.setHeader(Constants.STUDY_PLATFORM_X_SECRET, this.secret);
		get.setHeader(Constants.STUDY_PLATFORM_COURSEID, courseId);
		try {
			HttpResponse response = this.client.execute(get);
			Integer statusCode = response.getStatusLine().getStatusCode();
			String backInfo = translateInputStreamToString(response.getEntity().getContent());
			System.out.println("studySpaceForumCount["+statusCode+"]"+backInfo);
			if(statusCode==200){
				Long forum = Long.parseLong(response.getFirstHeader("result_forum_post").getValue());
				Long forumReply=Long.parseLong(response.getFirstHeader("result_forum_reply").getValue());
				forumCount.add(forum);
				forumCount.add(forumReply);
			}else{
				forumCount.add(-1L);
				forumCount.add(-1L);
			}
			get.abort();
		} catch (ClientProtocolException e) {
			LOGGER.error(e.getMessage());
		} catch (IOException e) {
			LOGGER.error(e.getMessage());
		}
		return forumCount;
	}
	
	/**
	 * 用户的在线时长统计
	 * @param courseId 学习空间ID（校本研修空间ID，学校空间ID）
	 * @param loginName 登录名
	 * @param spaceType 空间类型
	 * @return
	 */
	public Long userOnlineTimeCount(String courseId,String loginName,SpaceType spaceType){
		Long onlineTimeCount=-1L;
		String getURL=this.baseURL+LoadProperties.getProperty(Constants.STUDY_PLATFORM_USERONLINECOUNT_SPACEURL_KEY);
		if(spaceType.equals(SpaceType.STUDY)){
			courseId=Constants.STUDY_PLATFORM_DISCIPLINESPACE_PREFIX+courseId;
		}
		if(spaceType.equals(SpaceType.SCHOOL)){
			courseId=Constants.STUDY_PLATFORM_SCHOOLSPACE_PREFIX+courseId;
		}
		if(spaceType.equals(SpaceType.XBYX)){
			courseId=Constants.STUDY_PLATFORM_XBYX_PREFIX+courseId;
		}
		HttpGet get = new HttpGet(getURL);
		get.setHeader(Constants.STUDY_PLATFORM_X_ACCOUNT,this.account);
		get.setHeader(Constants.STUDY_PLATFORM_X_SECRET, this.secret);
		get.setHeader(Constants.STUDY_PLATFORM_COURSEID, courseId);
		get.setHeader(Constants.STUDY_PLATFORM_USERNAME, loginName);
		try {
			HttpResponse response = this.client.execute(get);
			Integer statusCode = response.getStatusLine().getStatusCode();
			String backInfo = translateInputStreamToString(response.getEntity().getContent());
			System.out.println("userOnlineTimeCount["+statusCode+"]"+backInfo);
			if(statusCode==200){
				onlineTimeCount=Long.parseLong(response.getFirstHeader("result_presence").getValue());
			}
			get.abort();
		} catch (ClientProtocolException e) {
			LOGGER.error(e.getMessage());
		} catch (IOException e) {
			LOGGER.error(e.getMessage());
		}
		return onlineTimeCount;
	}
	
	
	public Long classOnlineTimeCount(String courseId,String classAccessId,SpaceType spaceType){
		Long onlineTimeCount=-1L;
		String getURL=this.baseURL+LoadProperties.getProperty(Constants.STUDY_PLATFORM_CLASSONLINECOUNT_URL_KEY);
		if(spaceType.equals(SpaceType.STUDY)){
			courseId=Constants.STUDY_PLATFORM_DISCIPLINESPACE_PREFIX+courseId;
		}
		if(spaceType.equals(SpaceType.SCHOOL)){
			courseId=Constants.STUDY_PLATFORM_SCHOOLSPACE_PREFIX+courseId;
		}
		if(spaceType.equals(SpaceType.XBYX)){
			courseId=Constants.STUDY_PLATFORM_XBYX_PREFIX+courseId;
		}
		HttpGet get = new HttpGet(getURL);

		get.setHeader(Constants.STUDY_PLATFORM_X_ACCOUNT,this.account);
		get.setHeader(Constants.STUDY_PLATFORM_X_SECRET, this.secret);
		get.setHeader(Constants.STUDY_PLATFORM_COURSEID, courseId);
		get.setHeader(Constants.STUDY_PLATFORM_GROUPID, classAccessId);
		try {
			HttpResponse response = this.client.execute(get);
			Integer statusCode = response.getStatusLine().getStatusCode();
			String backInfo = translateInputStreamToString(response.getEntity().getContent());
			System.out.println("classOnlineTimeCount["+statusCode+"]"+backInfo);
			if(statusCode==200){
				onlineTimeCount=Long.parseLong(response.getFirstHeader("result_presence").getValue());
			}
			get.abort();
		} catch (ClientProtocolException e) {
			LOGGER.error(e.getMessage());
		} catch (IOException e) {
			LOGGER.error(e.getMessage());
		}
		return onlineTimeCount;
	}
	
	public Long studySpaceOnLineTimeCount(String courseId,SpaceType spaceType){
		Long onlineTimeCount=-1L;
		String getURL=this.baseURL+LoadProperties.getProperty(Constants.STUDY_PLATFORM_SPACEONLINECOUNT_URL_KEY);
		if(spaceType.equals(SpaceType.STUDY)){
			courseId=Constants.STUDY_PLATFORM_DISCIPLINESPACE_PREFIX+courseId;
		}
		if(spaceType.equals(SpaceType.SCHOOL)){
			courseId=Constants.STUDY_PLATFORM_SCHOOLSPACE_PREFIX+courseId;
		}
		if(spaceType.equals(SpaceType.XBYX)){
			courseId=Constants.STUDY_PLATFORM_XBYX_PREFIX+courseId;
		}
		HttpGet get = new HttpGet(getURL);

		get.setHeader(Constants.STUDY_PLATFORM_X_ACCOUNT,this.account);
		get.setHeader(Constants.STUDY_PLATFORM_X_SECRET, this.secret);
		get.setHeader(Constants.STUDY_PLATFORM_COURSEID, courseId);
		try {
			HttpResponse response = this.client.execute(get);
			Integer statusCode = response.getStatusLine().getStatusCode();
			String backInfo = translateInputStreamToString(response.getEntity().getContent());
			System.out.println("studySpaceOnLineTimeCount["+statusCode+"]"+backInfo);
			if(statusCode==200){
				onlineTimeCount=Long.parseLong(response.getFirstHeader("result_presence").getValue());
			}
			get.abort();
		} catch (ClientProtocolException e) {
			LOGGER.error(e.getMessage());
		} catch (IOException e) {
			LOGGER.error(e.getMessage());
		}
		return onlineTimeCount;
	}
	
	/**
	 * 检查插入学科空间用户的权限
	 * @param user
	 * @return
	 */
	private String checkUserRole(User user) {
		if(user.getUserType().equals(UserType.Subject_Specialists) || 
				user.getUserType().equals(UserType.School_Supervisor)){
			return Constants.STUDY_PLATFORM_ROLE_TEACHER;
		}
		if(user.getUserType().equals(UserType.Teacher)){
			return Constants.STUDY_PLATFORM_ROLE_ASSISTANT;
		}
		return Constants.STUDY_PLATFORM_ROLE_STUDENT;
	}
	
	/**
	 * 将响应的内容提取出来
	 * @param is
	 * @return
	 */
	private String translateInputStreamToString(InputStream is){
    	StringBuffer sb = new StringBuffer();
    	BufferedReader reader= new BufferedReader(new InputStreamReader(is));
    	
    	String line=null;
    	try {
			while((line=reader.readLine())!=null){
				sb.append(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
    	finally{
    		try {
				is.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
    	}
    	
    	return sb.toString();
    }

	
}
