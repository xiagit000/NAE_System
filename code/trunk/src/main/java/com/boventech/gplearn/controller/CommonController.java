package com.boventech.gplearn.controller;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.poi.hssf.record.formula.functions.Na;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.boventech.gplearn.entity.Announcement;
import com.boventech.gplearn.entity.Batch;
import com.boventech.gplearn.entity.BigSubject;
import com.boventech.gplearn.entity.City;
import com.boventech.gplearn.entity.ClassCourseInfomation;
import com.boventech.gplearn.entity.Constants;
import com.boventech.gplearn.entity.Discipline;
import com.boventech.gplearn.entity.Grade;
import com.boventech.gplearn.entity.LearnArea;
import com.boventech.gplearn.entity.LearnClass;
import com.boventech.gplearn.entity.LearnCourse;
import com.boventech.gplearn.entity.LearnStatistics;
import com.boventech.gplearn.entity.LearnSubProject;
import com.boventech.gplearn.entity.LearnThesis;
import com.boventech.gplearn.entity.LearnThesisSubmit;
import com.boventech.gplearn.entity.Navigation;
import com.boventech.gplearn.entity.PortalDefaultInformation;
import com.boventech.gplearn.entity.PortalDefaultType;
import com.boventech.gplearn.entity.Question;
import com.boventech.gplearn.entity.SchoolSpace;
import com.boventech.gplearn.entity.SpaceType;
import com.boventech.gplearn.entity.User;
import com.boventech.gplearn.entity.VideoInfo;
import com.boventech.gplearn.entity.VideoStatistics;
import com.boventech.gplearn.entity.WorkStatistics;
import com.boventech.gplearn.entity.LearnThesisSubmit.LearnThesisRating;
import com.boventech.gplearn.entity.User.UserType;
import com.boventech.gplearn.entity.WorkStatistics.WorkType;
import com.boventech.gplearn.exception.LocalDatabaseUserNotFoundException;
import com.boventech.gplearn.service.AnnouncementService;
import com.boventech.gplearn.service.BatchService;
import com.boventech.gplearn.service.BigSubjectService;
import com.boventech.gplearn.service.CityService;
import com.boventech.gplearn.service.DisciplineService;
import com.boventech.gplearn.service.EnrollmentPlanService;
import com.boventech.gplearn.service.GradeService;
import com.boventech.gplearn.service.GraduateStandardService;
import com.boventech.gplearn.service.LearnAreaService;
import com.boventech.gplearn.service.LearnClassService;
import com.boventech.gplearn.service.LearnCourseService;
import com.boventech.gplearn.service.LearnLevelService;
import com.boventech.gplearn.service.LearnPlanService;
import com.boventech.gplearn.service.LearnProjectService;
import com.boventech.gplearn.service.LearnSpeacialtyService;
import com.boventech.gplearn.service.LearnSubProjectService;
import com.boventech.gplearn.service.LearnThesisSubmitInfomationService;
import com.boventech.gplearn.service.NavigationService;
import com.boventech.gplearn.service.PortalDefaultInfomationService;
import com.boventech.gplearn.service.QuestionService;
import com.boventech.gplearn.service.ReceiverNotificationService;
import com.boventech.gplearn.service.SchoolRollService;
import com.boventech.gplearn.service.SchoolSpaceService;
import com.boventech.gplearn.service.ScoringStandardService;
import com.boventech.gplearn.service.SmallTopicService;
import com.boventech.gplearn.service.UserService;
import com.boventech.gplearn.service.VideoService;
import com.boventech.gplearn.service.VideoStatisticsService;
import com.boventech.gplearn.util.LoadProperties;
import com.boventech.gplearn.util.StudyPlatformHttpClient;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

@Controller
public class CommonController extends ApplicationController{
	
	private static final Logger logger = LoggerFactory.getLogger(CommonController.class);
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private SchoolRollService schoolRollService;
	
	@Autowired
	private AnnouncementService announcementService;
	
	@Autowired
	private SchoolSpaceService schoolSpaceService;
	
	@Autowired
	private GradeService gradeService;
	
	@Autowired
	private ReceiverNotificationService receiverNotificationService;
	
	@Autowired
	private LearnClassService learnClassService;
	
	@Autowired
	private BigSubjectService bigSubjectService;
	
	@Autowired
	private LearnPlanService learnPlanService;
	
	@Autowired
	private LearnThesisSubmitInfomationService learnThesisSubmitInfomationService;
	
	@Autowired
	private QuestionService questionService;
	
	@Autowired
	private BatchService batchService;
	
	@Autowired
	private LearnSubProjectService learnSubProjectService;
	
	@Autowired
	private LearnAreaService learnAreaService;
	
	@Autowired
	private CityService cityService;
	
	@Autowired
	private DisciplineService disciplineService;
	
	@Autowired
	private LearnSpeacialtyService learnSpeacialtyService;
	
	@Autowired
	private LearnLevelService learnLevelService;
	
	@Autowired
	private LearnProjectService learnProjectService;
	
	@Autowired
	private LearnCourseService learnCourseService;
	
	@Autowired
	private ScoringStandardService scoringStandardService;
	
	@Autowired
	private GraduateStandardService graduateStandardService;
	
	@Autowired
	private SmallTopicService smallTopicService;
	
	@Autowired
	private EnrollmentPlanService enrollmentPlanService;
	
	@Autowired
	private VideoService videoService;
	
	@Autowired
	private VideoStatisticsService videoStatisticsService;
	
	@Autowired
	private PortalDefaultInfomationService portalDefaultInfomationService;
	
	@Autowired
	private NavigationService navigationService;
	
	private StudyPlatformHttpClient client = new StudyPlatformHttpClient();
	
	@RequestMapping(value="/")
	public String hello(HttpServletRequest request,Model model){
		Object user=request.getSession().getAttribute("currentUser");
		if(null == user){
			initLoginPage(model);
			return "common/login";
		}
		//根据不同权限跳向不同页面
		User currentUser = (User)user;
		UserType currentRole = currentUser.getUserType();
		return getReturnPage(currentRole,model,request);
	}

	private void initLoginPage(Model model) {
		//初始化统计数据，以省为单位
		List<LearnStatistics> provinceStatistics = Lists.newArrayList();
		LearnStatistics totalStatistics  = new LearnStatistics();
		
		
		initLoginPageTotalStatistics(totalStatistics);
		Batch currentBatch = batchService.getCurrentBatch();
		
		//初始化门户信息
		initLoginPagePortalInformation(model);
		
		if(null!=currentBatch)
		initLoginPageProvinceStatistics(provinceStatistics,currentBatch);
		
		model.addAttribute("provinceStatistics", provinceStatistics);
		model.addAttribute("totalStatistics", totalStatistics);
	}

	private void initLoginPagePortalInformation(Model model) {
		//通知公告
		List<PortalDefaultInformation> tzgg = portalDefaultInfomationService.listByPortalDefaultTypeUseForPortal(PortalDefaultType.NOTICE,7);
		//图片墙
		List<PortalDefaultInformation> tpq = portalDefaultInfomationService.listByPortalDefaultTypeUseForPortal(PortalDefaultType.IMAGEWALL, 5);
		if(tpq.size()>0){
			PortalDefaultInformation walldown = tpq.get(0);
			model.addAttribute("walldown", walldown);
		}
		//国培计划
		List<PortalDefaultInformation> gpjh = portalDefaultInfomationService.listByPortalDefaultTypeUseForPortal(PortalDefaultType.GPPLAN, 5);
		//典型问题集锦
		List<PortalDefaultInformation> dxwtjj  = portalDefaultInfomationService.listByPortalDefaultTypeUseForPortal(PortalDefaultType.HOTQUESTION, 5);
		//教师风采
		List<PortalDefaultInformation> jsfc = portalDefaultInfomationService.listByPortalDefaultTypeUseForPortal(PortalDefaultType.TEACHERSHOW, 10);
		//招生服务信息
		List<PortalDefaultInformation> zsfw = portalDefaultInfomationService.listByPortalDefaultTypeUseForPortal(PortalDefaultType.RECRUITINFO,4);
		//教学服务信息
		List<PortalDefaultInformation> jxfw = portalDefaultInfomationService.listByPortalDefaultTypeUseForPortal(PortalDefaultType.TEACHINFO, 7);
		//学务信息
		List<PortalDefaultInformation> xwxx  = portalDefaultInfomationService.listByPortalDefaultTypeUseForPortal(PortalDefaultType.STUDYINFO, 7);
		//培训感言
		List<PortalDefaultInformation> pxgy = portalDefaultInfomationService.listByPortalDefaultTypeUseForPortal(PortalDefaultType.STUDYTHANKS, 7);
		//图文资讯
		List<PortalDefaultInformation> twzx = portalDefaultInfomationService.listByPortalDefaultTypeUseForPortal(PortalDefaultType.IMAGECONTENT, 10);
		model.addAttribute("tzgg",tzgg);
		model.addAttribute("tpq",tpq);
		model.addAttribute("gpjh",gpjh);
		model.addAttribute("dxwtjj", dxwtjj);
		model.addAttribute("jsfc", jsfc);
		model.addAttribute("zsfw",zsfw );
		model.addAttribute("jxfw",jxfw );
		model.addAttribute("xwxx",xwxx );
		model.addAttribute("pxgy",pxgy );
		model.addAttribute("twzx",twzx );
		
		//导航条
		List<Navigation> parent = navigationService.listParents();
		Map<Navigation, List<Navigation>> navigation = Maps.newHashMap();
		for(int i =0;i<parent.size();i++){
			List<Navigation> children = navigationService.listChildren(parent.get(i).getId());
			if(children.size()>0){
				navigation.put(parent.get(i), children);
			}else{
				navigation.put(parent.get(i), null);
			}
			
		}
		model.addAttribute("navigation",navigation);
		
	}

	private void initLoginPageProvinceStatistics(
			List<LearnStatistics> provinceStatistics,Batch currentBatch) {
		//获取存在的省
		List<City> cities = learnAreaService.getExistProvince();
		for(int i =0;i<cities.size();i++){
			LearnStatistics ls = new LearnStatistics();
			ls.setProvince(cities.get(i));
			List<LearnArea> learnAreaList = learnAreaService.listWithProvinceCity(cities.get(i));
			ls.setCitiesCount(learnAreaList.size());
			List<LearnClass> learnClasses = learnClassService.listByLearnAreasInCurrentBatch(learnAreaList, currentBatch);
			ls.setLearnClassCount(learnClasses.size());
			
			Integer userCount = 0;
			Integer learnThesisSubmitCount=0;
			Integer questionCount =0;
			for(int j=0;j<learnClasses.size();j++){
				userCount += learnClasses.get(j).getEnrollmentPlan().getExistedUserNumber();
				learnThesisSubmitCount+=learnThesisSubmitInfomationService.getCountByLearnClassId(learnClasses.get(j).getId());
				questionCount+=questionService.countByLearnClass(learnClasses.get(j));
			}
			ls.setClassMateInfo(userCount.toString());
			ls.setTeacherCount(learnClasses.size());
			ls.setLearnThesisInfo(learnThesisSubmitCount.toString());
			ls.setQuestionInfo(questionCount.toString());
			provinceStatistics.add(ls);
		}
		
	}

	/**
	 *****************总体统计**************
	 * @param totalStatistics
	 */
	private void initLoginPageTotalStatistics(LearnStatistics totalStatistics) {
		
		//1.找到所有存在的省
		List<City> provinceList  = learnAreaService.getExistProvince();
		totalStatistics.setCitiesCount(provinceList.size());
		//2.班级数统计
		Integer classCount = learnClassService.getClassCount();
		totalStatistics.setLearnClassCount(classCount);
		//3.学员统计
		//总数
		Integer studentCount = userService.getStudentCount();
		Integer studentActiveCount = userService.getActiveStudentCount();
		totalStatistics.setClassMateInfo(studentCount.toString()+"/"+studentActiveCount);
		//4.在线总时长
		    //获取所有学科
		List<Discipline>  disciplineList = disciplineService.listAll();
		Long totalTimeCount=0L;
		for(int i =0;i<disciplineList.size();i++){
			Discipline disciplineTemp = disciplineList.get(i);
			totalTimeCount+=getStudySpaceOnlineTime(disciplineTemp.getId().toString());
		}
		setOnlineTimeAndEnableTimeCount(totalStatistics, totalTimeCount);
		//5.学生作业统计
		Integer learnThesisSubmitCount = learnThesisSubmitInfomationService.getLearnThesisSubmitCount();
		Integer learnThesisSubmitGoodCount = learnThesisSubmitInfomationService.getLearnThesisSubmitGoodCount();
		totalStatistics.setLearnThesisInfo(learnThesisSubmitCount+"/"+learnThesisSubmitGoodCount);
		//6.学员问题统计
		Integer questionCount = questionService.getQuestionCount();
		Integer questionResolvedCount = questionService.getQuestionResolvedCount();
		totalStatistics.setQuestionInfo(questionCount+"/"+questionResolvedCount);
	}

	@RequestMapping(value="/login")
	public String login(HttpServletRequest request,Model model){
		Object user=request.getSession().getAttribute("currentUser");
		String loginName = request.getRemoteUser();
		User currentUser=null;
		try {
			currentUser = findcurrentUser(loginName);
		} catch (LocalDatabaseUserNotFoundException e) {
			logger.error(e.getMessage());
			return "redirect:/";
		}
		if(user==null && currentUser!=null){
			if(!currentUser.isActive()){
				currentUser.setActive(true);
				userService.update(currentUser);
			}
			request.getSession().setAttribute("currentUser", currentUser);
		}
		//根据不同权限跳向不同页面
		UserType currentRole = currentUser.getUserType();
		return getReturnPage(currentRole,model,request);
	}
	
	@RequestMapping(value="/error/404")
	public String error404(){
		return "error/404";
	}
	
	@RequestMapping(value="/logout")
	public void logout(HttpServletRequest request,HttpServletResponse response){
		HttpSession session = request.getSession();
		session.removeAttribute("siteMenu");
		session.removeAttribute("siteItem");
		session.removeAttribute("currentUser");
		session.removeAttribute("myClass");
		session.removeAttribute("myXBYXPath");
		session.removeAttribute("mySchoolPath");
		session.removeAttribute("unreadCount");
		try {
			String logoutURL=LoadProperties.getProperty(Constants.CAS_BASE_URL_KEY)+
							LoadProperties.getProperty(Constants.CAS_LOGOUT_URL_KEY);
			String serviceUrl="?service="+LoadProperties.getProperty(Constants.CAS_LOGOUT_SERVICE_KEY);
			System.out.println(serviceUrl);
			System.out.println(logoutURL);
			String redirectURL=logoutURL+serviceUrl;
			response.sendRedirect(redirectURL);
		} catch (IOException e) {
			logger.error(e.getMessage());
		}
	}
	
	private String getReturnPage(UserType currentRole,Model model,HttpServletRequest request) {
		String returnPage="common/login";
		if(currentRole.equals(UserType.System_Administrator)){
			initAdministrator(request,model);
			returnPage="common/admin";
		}
		if(currentRole.equals(UserType.Teacher)){
			initTeacherFirstPageDate(model,request);
			returnPage="common/teacher";
		}
		if(currentRole.equals(UserType.Project_Specialists)){
			initProjectFirstPageDate(model,request);
			returnPage="common/project";
		}
		if(currentRole.equals(UserType.Province_Supervisor)){
			initProvinceFirstPageDate(model,request);
			returnPage="common/province";
		}
		if(currentRole.equals(UserType.School_Supervisor)){
			initSchoolFirstPageDate(model,request);
			returnPage="common/school";
		}
		if(currentRole.equals(UserType.Student)){
			initStudentFirstPageDate(model,request);
			returnPage="common/student";
		}
		if(currentRole.equals(UserType.Subject_Specialists)){
			initDisciplineFirstPageDate(model,request);
			returnPage="common/discipline";
		}
		return returnPage;
	}
	
	
	
	/***
	 * TODO 下面所有INIT开头的方法等孙建文接口做好后，全部删除!!!
	 * @param model
	 * @param request
	 */
	
	private void initDisciplineFirstPageDate(Model model,
			HttpServletRequest request) {
		HttpSession session = request.getSession();
		
		User currentUser = (User)session.getAttribute("currentUser");
		messageBoxInit(session, currentUser);
		//找出当前学科专家的学科
		Discipline discipline = disciplineService.findByPersonIncharge(currentUser);
		//找出当前有哪些项目引用了这个学科
		List<LearnSubProject> subProjectList=learnSubProjectService.listByDiscipline(discipline,batchService.getCurrentBatch());
		LearnStatistics disciplineStatistics = new LearnStatistics();
		List<LearnStatistics> learnSubprojectStatistics=Lists.newArrayList();
		//获取当前这些培训项目的班级
		List<LearnClass> learnClasses = Lists.newArrayList();
		//容器
		
		Integer userCount=0;
		Integer activeUserCount=0;
		Integer learnThesisCount=0;
		Integer learnThesisMarking=0;
		Integer goodMarkingCount=0;
		Integer questionResolved=0;
		Integer questionUnresolved=0;
		Integer questionCount=0;
		for(int i =0;i<subProjectList.size();i++){
			
			//单个项目的统计记录
			LearnStatistics ls = new LearnStatistics();
			Integer userCountInSubproject = 0;
			Integer activeUserCountInSubproject=0;
			Integer learnThesisCountInSubproject=0;
			Integer learnThesisMarkingInSubproject=0;
			Integer goodMarkingCountInSubproject=0;
			Integer questionResolvedInSubproject=0;
			Integer questionUnresolvedInSubproject=0;
			Integer questionCountInSubproject=0;
			Integer learnClassCountInSubProject=0;
			Long subProjectTimeCount=0L;
			Long subProjectForumCount=0L;
			Long subProjectForumReplyCount=0L;
			LearnSubProject temp = subProjectList.get(i);
			
			//获取当前项目的所有班级
			List<LearnClass> tempClassList = learnClassService.listByLearnSubProjectInCurrentBatch(temp, batchService.getCurrentBatch());
			//循环班级获取每个班级的学生
			for(LearnClass learnClass : tempClassList){
				//获取当前班级在线时长并累加
				Long classTimeCount=getClassTimeCount(learnClass);
				subProjectTimeCount+=classTimeCount;
				//获取当前项目内班级的在线时长，并累加
				List<Long> tempForum=getClassSpaceForumCount(learnClass);
				subProjectForumCount+=tempForum.get(0);
				subProjectForumReplyCount+=tempForum.get(1);
				
				learnClassCountInSubProject++;
				learnClasses.add(learnClass);
				List<User> users =  schoolRollService.findUsersByClass(learnClass);
				for(User user : users){
					userCount++;
					userCountInSubproject++;
					if(user.isActive()){
						activeUserCount++;
						activeUserCountInSubproject++;
					}
					List<LearnThesisSubmit> ltsList = learnThesisSubmitInfomationService.listActiveInfoByStudentUser(user);
					for(LearnThesisSubmit lts : ltsList){
						learnThesisCount++;
						learnThesisCountInSubproject++;
						if(null!=lts.getMakingDate()){
							learnThesisMarkingInSubproject++;
							learnThesisMarking++;
						}
						if(null!=lts.getLearnThesisRating() && lts.getLearnThesisRating().equals(LearnThesisRating.VERYGOOD)){
							goodMarkingCountInSubproject++;
							goodMarkingCount++;
						}
					}
					List<Question> questionList = questionService.listByAsker(user);
					for(Question q : questionList){
						questionCount++;
						questionCountInSubproject++;
						if(q.isResolved()){
							questionResolvedInSubproject++;
							questionResolved++;
							continue;
						}
						questionUnresolvedInSubproject++;
						questionUnresolved++;
					}
				}
			}
			ls.setLearnSubProject(temp);
			ls.setLearnClassCount(learnClassCountInSubProject);
			ls.setClassMateInfo(userCountInSubproject+"/"+activeUserCountInSubproject);
			ls.setLearnThesisInfo(learnThesisCountInSubproject+"/"+learnThesisMarkingInSubproject+"/"+goodMarkingCountInSubproject);
			//获取当前项目的在线时长和有效时长
			setOnlineTimeAndEnableTimeCount(ls, subProjectTimeCount);
			//获取当前项目的论坛讨论数据
			List<Long> forum=Lists.newArrayList();
			forum.add(subProjectForumCount);
			forum.add(subProjectForumReplyCount);
			setForum(forum, ls);
			
			ls.setQuestionInfo(questionCountInSubproject+"/"+questionResolvedInSubproject+"/"+questionUnresolvedInSubproject);
			learnSubprojectStatistics.add(ls);
		}
		disciplineStatistics.setLearnSubjectCount(subProjectList.size());
		disciplineStatistics.setDiscipline(discipline);
		disciplineStatistics.setLearnClassCount(learnClasses.size());
		disciplineStatistics.setClassMateInfo(userCount+"/"+activeUserCount);
		//获取当前学科的在线时长和有效时长
		setStudySpaceOnlineTimeAndEnableTime(disciplineStatistics, discipline.getId());
		disciplineStatistics.setLearnThesisInfo(learnThesisCount+"/"+learnThesisMarking+"/"+goodMarkingCount);
		//获取当前学科的论坛讨论数据
		setStudySpaceForum(disciplineStatistics, discipline.getId());
		disciplineStatistics.setQuestionInfo(questionCount+"/"+questionResolved+"/"+questionUnresolved);
		
		model.addAttribute("disciplineStatistics", disciplineStatistics);
		model.addAttribute("learnSubprojectStatistics", learnSubprojectStatistics);
		
		//"我的学科班级"路径
		classPathInit(session,discipline.getId());
		
		//"我的校本研修空间"
		xbyxPathInit(session, discipline.getId());
	}


	private void initSchoolFirstPageDate(Model model, HttpServletRequest request) {
		HttpSession session = request.getSession();
		User currentUser = (User)session.getAttribute("currentUser");
		messageBoxInit(session, currentUser);
		List<Grade> grades = Lists.newArrayList();
		//获取当前校级督导的学校信息
		SchoolSpace schoolSpace = schoolSpaceService.findByPersonIncharge(currentUser);
		List<User> users = userService.listBySchoolIncurrentBatch(schoolSpace.getSchoolName(), batchService.getCurrentBatch());
		LearnStatistics schoolStatistics = new LearnStatistics();

		//在线时间和有效时间
		setSchoolSpaceOnlineTimeAndEnableTime(schoolStatistics, schoolSpace.getId());
		//具体数据
		Integer activeUserCount=0;
		Integer learnThesisCount =0;
		Integer learnMarkingCount=0;
		Integer goodmarkingCount=0;
		Integer questionResolved=0;
		Integer questionUnResolved=0;
		Integer questionCount=0;
		for(int i =0;i<users.size();i++){
			User temp = users.get(i);
			grades.add(gradeService.findByUser(temp));
			if(temp.isActive()){
				activeUserCount++;
			}
			List<LearnThesisSubmit> templtses= learnThesisSubmitInfomationService.listActiveInfoByStudentUser(temp);
			for(LearnThesisSubmit lts : templtses ){
				learnThesisCount++;
				if(null!=lts.getMakingDate()){
					learnMarkingCount++;
				}
				if(null!=lts.getLearnThesisRating() && lts.getLearnThesisRating().equals(LearnThesisRating.VERYGOOD)){
					goodmarkingCount++;
				}
			}
			List<Question> questions = questionService.listByAsker(temp);
			for(Question q : questions){
				questionCount++;
				if(q.isResolved()){
					questionResolved++;
					continue;
				}
				questionUnResolved++;
			}
		}
		schoolStatistics.setSchool(schoolSpace);
		schoolStatistics.setClassMateInfo(users.size()+"/"+activeUserCount);
		schoolStatistics.setLearnThesisInfo(learnThesisCount+"/"+learnMarkingCount+"/"+goodmarkingCount);
		schoolStatistics.setQuestionInfo(questionCount+"/"+questionResolved+"/"+questionUnResolved);
		setSchoolSpaceForum(schoolStatistics, schoolSpace.getId());
		for(int i =0;i<grades.size();i++){
			mockDate(grades, i);
		}
		schoolPathInit(session, currentUser);
		model.addAttribute("schoolStatistics", schoolStatistics);
		model.addAttribute("grades", grades);
		
	}


	
	private void initProvinceFirstPageDate(Model model,
			HttpServletRequest request) {
		HttpSession session = request.getSession();
		User currentUser = (User)session.getAttribute("currentUser");
		messageBoxInit(session, currentUser);
		//省内学员
		List<User> users = Lists.newArrayList();
		//省内学校
		List<String> schoolIdList=Lists.newArrayList();
		//省内提交的论文统计
		List<LearnThesisSubmit> learnThesisSubmits=Lists.newArrayList();
		//省内学生提交的论文
		List<Question> questionList=Lists.newArrayList();
		
		//省统计情况
		LearnStatistics provinceStatistics=new LearnStatistics();
		//1.获取当前用户所管辖的区域
		List<LearnArea> learnAreas = learnAreaService.listByPersonIncharge(currentUser);
		//2.取得任意一个区域的ELCode
		String elCode=learnAreas.get(0).getElCode();
		//获取省这个city的ID
		String provinceId=elCode.substring(0,elCode.indexOf(Constants.BREAKE_STR));
		City province = cityService.getCity(provinceId);
		//将省份信息保存
		provinceStatistics.setProvince(province);
		//将所管辖区域信息保存
		provinceStatistics.setCitiesCount(learnAreas.size());
		//获取省份下的班级
		List<LearnClass> learnClasses = learnClassService.listByLearnAreasInCurrentBatch(learnAreas,batchService.getCurrentBatch());
		//保存班级数量
		provinceStatistics.setLearnClassCount(learnClasses.size());
		
		//省内激活的用户数
		Integer activeUserCount = 0;
		//省内已批改的论文数
		Integer learnThesismarking=0;
		//批改为优秀的论文数量
		Integer goodMarkingLearnThesis=0;
		//学生所提出问题的解决和待解决数量
		Integer questionResolved=0;
		Integer questionUnResolved=0;
		Long provinceTimeCount =0L;
		Long provinceForumCount=0L;
		Long provinceForumReplyCount=0L;
		//循环省下所有班级
		for(int i =0;i<learnClasses.size();i++){
			List<User> classUsers=schoolRollService.findUsersByClass(learnClasses.get(i));
			//统计累加每个班级的在线时长
			provinceTimeCount+=getClassTimeCount(learnClasses.get(i));
			List<Long> classForumCount=getClassSpaceForumCount(learnClasses.get(i));
			provinceForumCount+=classForumCount.get(0);
			provinceForumReplyCount+=classForumCount.get(1);
			//循环单个班级内的学生
			for(int j=0;j<classUsers.size();j++){
				User temp=classUsers.get(j);
				users.add(temp);
				//统计激活数量
				if(temp.isActive()){
					activeUserCount++;
				}
				//添加学校
				if(!schoolIdList.contains(temp.getAccount().getSchool())){
					schoolIdList.add(temp.getAccount().getSchool());
				}
				//获取当前用户提交的论文数量
				List<LearnThesisSubmit> ltss=learnThesisSubmitInfomationService.listActiveInfoByStudentUser(temp);
				for(LearnThesisSubmit lts : ltss){
					learnThesisSubmits.add(lts);
					if(null!=lts.getMakingDate()){
						learnThesismarking++;
					}
					if(null!=lts.getLearnThesisRating() && lts.getLearnThesisRating().equals(LearnThesisRating.VERYGOOD)){
						goodMarkingLearnThesis++;
					}
				}
				//获取当前循环的学生的提问
				List<Question> questions=questionService.listByAsker(temp);
				for(Question question : questions){
					questionList.add(question);
					if(question.isResolved()){
						questionResolved++;
						continue;
					}
					questionUnResolved++;
				}
			}
		}
		List<Long> provinceForum = Lists.newArrayList();
		provinceForum.add(provinceForumCount);
		provinceForum.add(provinceForumReplyCount);
		setForum(provinceForum, provinceStatistics);
		provinceStatistics.setClassMateInfo(users.size()+"/"+activeUserCount);
		provinceStatistics.setLearnThesisInfo(learnThesisSubmits.size()+"/"+learnThesismarking+"/"+goodMarkingLearnThesis);
		provinceStatistics.setQuestionInfo(questionList.size()+"/"+questionResolved+"/"+questionUnResolved);
		provinceStatistics.setSchoolCount(schoolIdList.size());
		setOnlineTimeAndEnableTimeCount(provinceStatistics, provinceTimeCount);
		model.addAttribute("provinceStatistics", provinceStatistics);
		
		//市区统计情况
		//citysStatistics用来保存当前所有剩下市区的统计数据
		List<LearnStatistics> citysStatistics=Lists.newArrayList();
		
		//循环每个市
		for(int i =0;i<learnAreas.size();i++){
			//用于统计每个市区的统计对象
			LearnStatistics ls  = new LearnStatistics();
			//获取当前区域并保存
			LearnArea temp=learnAreas.get(i);
			ls.setLearnArea(temp);
			//获取当前区域的所有班级，并统计班级数量
			List<LearnClass> templsList=learnClassService.listByLearnAreaInCurrentBatch(temp,batchService.getCurrentBatch());
			ls.setLearnClassCount(templsList.size());
			
			
			//每个区域需要的属性
			//统计区域内学校的数量
			List<String> schoolIdList2=Lists.newArrayList();
			//区域内用户数量(总数/激活)
			Integer userCount=0;
			activeUserCount=0;
			//已批改的论文数量
			learnThesismarking=0;
			//批改优秀的论文数量
			goodMarkingLearnThesis=0;
			//论文总数
			Integer learnThesisCount=0;
			//问题解答与待解答还有总数
			questionResolved=0;
			questionUnResolved=0;
			Integer questionCount=0;
			//当前区域所有班级的在线时长
			Long timeCount=0L;
			//当前区域所有班级的发帖数，回帖数
			Long forumCount=0L;
			Long forumReplyCount=0L;
			List<Long> forum = Lists.newArrayList();
			//循环当前区域的班级
			for(int j=0;j<templsList.size();j++){
				LearnClass tempc = templsList.get(j);
				timeCount+=getClassTimeCount(tempc);
				List<Long> tempForum = getClassSpaceForumCount(tempc);
				forumCount+=tempForum.get(0);
				forumReplyCount+=tempForum.get(1);
				//获取当前班级的所有用户
				List<User> tempus=schoolRollService.findUsersByClass(tempc);
				for(User user : tempus){
					userCount++;
					if(user.isActive()){
						activeUserCount++;
					}
					if(!schoolIdList2.contains(user.getAccount().getSchool())){
						schoolIdList2.add(user.getAccount().getSchool());
					}
					List<LearnThesisSubmit> templts=learnThesisSubmitInfomationService.listActiveInfoByStudentUser(user);
					for(LearnThesisSubmit lts:templts){
						learnThesisCount++;
						if(null!=lts.getMakingDate()){
							learnThesismarking++;
						}
						if(null!=lts.getLearnThesisRating() && lts.getLearnThesisRating().equals(LearnThesisRating.VERYGOOD)){
							goodMarkingLearnThesis++;
						}
					}
					List<Question> tempq=questionService.listByAsker(user);
					for(Question q : tempq){
						questionCount++;
						if(q.isResolved()){
							questionResolved++;
							continue;
						}
						questionUnResolved++;
					}
				}
			}
			forum.add(forumCount);
			forum.add(forumReplyCount);
			setForum(forum, ls);
			ls.setSchoolCount(schoolIdList2.size());
			ls.setClassMateInfo(userCount+"/"+activeUserCount);
			setOnlineTimeAndEnableTimeCount(ls, timeCount);
			ls.setLearnThesisInfo(learnThesisCount+"/"+learnThesismarking+"/"+goodMarkingLearnThesis);
			ls.setQuestionInfo(questionCount+"/"+questionResolved+"/"+questionUnResolved);
			citysStatistics.add(ls);
		}
		model.addAttribute("citysStatistics", citysStatistics);
	}

	
	

	private void initAdministrator(HttpServletRequest request, Model model) {
		messageBoxInit(request.getSession(),(User)request.getSession().getAttribute("currentUser"));
		//当前批次数量
		Integer batchCount  = batchService.listAll().size();
		//当前专业数量
		Integer learnSpeacialtyCount = learnSpeacialtyService.listActive().size();
		//当前层次数量
		Integer learnLevelCount = learnLevelService.listActive().size();
		//当前学科数量
		Integer disciplineCount = disciplineService.listAll().size();
		//当前项目数量
		Integer learnProjectCount = learnProjectService.listAll().size();
		//当前子项目数量
		Integer learnSubProjectCount = learnSubProjectService.listAll().size();
		//当前区域数量
		Integer learnAreaCount = learnAreaService.listAll().size();
		//当前教学计划数量
		Integer learnPlanCount = learnPlanService.listAll().size();
		//当前课程数量
		Integer learnCourseCount = learnCourseService.listAll().size();
		//当前评分标准数量
		Integer scoringStandardCount = scoringStandardService.listAll().size();
		//当前结业标准数量
		Integer graduateStandardCount = graduateStandardService.listAll().size();
		
		//当前校本研修大主题数量
		Integer bigSubjectCount = bigSubjectService.listAll().size();
		//当前当前校本研修大主题下的小课题数量
		Integer smallTopicCount = smallTopicService.listAll().size();
		//当前已有的学校空间数量
		Integer schoolSpaceCount = schoolSpaceService.listAll().size();
		//当前已有的班级数量
		Integer learnClass = learnClassService.listAll().size();
		//当前已有的招生计划数量
		Integer enrollmentCount = enrollmentPlanService.listAll().size();
		//当前已有的注册信息用户数量
		Integer userCount = userService.listAllWithoutPagnate().size();
		//用户统计
		List<User> users= userService.listAllWithoutPagnate();
		Integer projectUserCount=0;
		Integer provinceUserCount=0;
		Integer schoolUserCount=0;
		Integer studentUserCount=0;
		Integer disciplineUserCount=0;
		Integer sysCount=0;
		Integer teacherUserCount=0;
		Integer activeCount=0;
		for(User u : users){
			if(u.getUserType().equals(UserType.Project_Specialists)){
				projectUserCount++;
			}
			if(u.getUserType().equals(UserType.Province_Supervisor)){
				provinceUserCount++;
			}
			if(u.getUserType().equals(UserType.School_Supervisor)){
				schoolUserCount++;
			}
			if(u.getUserType().equals(UserType.Student)){
				studentUserCount++;
			}
			if(u.getUserType().equals(UserType.Subject_Specialists)){
				disciplineUserCount++;
			}
			if(u.getUserType().equals(UserType.System_Administrator)){
				sysCount++;
			}
			if(u.getUserType().equals(UserType.Teacher)){
				teacherUserCount++;
			}
			if(u.isActive()){
				activeCount++;
			}
		}
		
		model.addAttribute("batchCount",batchCount);
		model.addAttribute("learnSpeacialtyCount",learnSpeacialtyCount);
		model.addAttribute("learnLevelCount",learnLevelCount);
		model.addAttribute("disciplineCount",disciplineCount);
		model.addAttribute("learnProjectCount",learnProjectCount);
		model.addAttribute("learnSubProjectCount",learnSubProjectCount);
		model.addAttribute("learnAreaCount",learnAreaCount);
		model.addAttribute("learnPlanCount",learnPlanCount);
		model.addAttribute("learnCourseCount",learnCourseCount);
		model.addAttribute("scoringStandardCount",scoringStandardCount);
		model.addAttribute("graduateStandardCount",graduateStandardCount);
		model.addAttribute("bigSubjectCount",bigSubjectCount);
		model.addAttribute("smallTopicCount",smallTopicCount);
		model.addAttribute("schoolSpaceCount",schoolSpaceCount);
		model.addAttribute("learnClass",learnClass);
		model.addAttribute("enrollmentCount",enrollmentCount);
		model.addAttribute("userCount",userCount);
		model.addAttribute("projectUserCount",projectUserCount);
		model.addAttribute("provinceUserCount",provinceUserCount);
		model.addAttribute("schoolUserCount",schoolUserCount);
		model.addAttribute("studentUserCount",studentUserCount);
		model.addAttribute("disciplineUserCount",disciplineUserCount);
		model.addAttribute("sysCount",sysCount);
		model.addAttribute("teacherUserCount",teacherUserCount);
		model.addAttribute("activeCount",activeCount);
	}

	private void initProjectFirstPageDate(Model model,
			HttpServletRequest request) {
		HttpSession session = request.getSession();
		User currentUser = (User)session.getAttribute("currentUser");
		
		List<String> provinceIdList  = Lists.newArrayList();
		List<String> citiesIdList = Lists.newArrayList();
		List<User> users =Lists.newArrayList();
		List<String> schoolList = Lists.newArrayList();
		List<LearnThesisSubmit> learnThesisSubmitList=Lists.newArrayList();
		List<Question> questionList =Lists.newArrayList();
		
		//初始化培训项目统计列表
		LearnStatistics projectStatistic = new LearnStatistics();
		LearnSubProject learnSubProject = learnSubProjectService.findByPersonIncharge(currentUser);
		projectStatistic.setLearnSubProject(learnSubProject);
		List<LearnClass> learnClasses=learnClassService.listByLearnSubProjectInCurrentBatch(learnSubProject,batchService.getCurrentBatch());
		projectStatistic.setLearnClassCount(learnClasses.size());
		
		String provinceId="";
		String cityId="";
		Integer markingWorkCount=0;
		Integer goodmarkingWorkCount=0;
		Integer questionResolved=0;
		Integer questionUnResolved=0;
		Long timeCount = 0L;
		Long projectForumCount=0L;
		Long projectForumReplyCount=0L;
		
		for(LearnClass learnClass : learnClasses){
			timeCount+=getClassTimeCount(learnClass);
			List<Long> tempForum = getClassSpaceForumCount(learnClass);
			projectForumCount+=tempForum.get(0);
			projectForumReplyCount+=tempForum.get(1);
			
			String elcode=learnClass.getLearnArea().getElCode();
			provinceId = elcode.substring(0,elcode.indexOf(Constants.BREAKE_STR));
			cityId =  elcode.substring(elcode.indexOf(Constants.BREAKE_STR)+1,elcode.length());
			if(!provinceIdList.contains(provinceId)){
				provinceIdList.add(provinceId);
			}
			if(!citiesIdList.contains(cityId)){
				citiesIdList.add(cityId);
			}
			List<User> learnClassUsers=schoolRollService.findUsersByClass(learnClass);
			for(int i =0;i<learnClassUsers.size();i++){
				users.add(learnClassUsers.get(i));
				if(!schoolList.contains(learnClassUsers.get(i).getAccount().getSchool())){
					schoolList.add(learnClassUsers.get(i).getAccount().getSchool());
				}
				List<LearnThesisSubmit> ltss=learnThesisSubmitInfomationService.
										listActiveInfoByStudentUser(learnClassUsers.get(i));
				for(LearnThesisSubmit lts : ltss){
					learnThesisSubmitList.add(lts);
					if(null!=lts.getMakingDate()){
						markingWorkCount++;
					}
					if(null!=lts.getLearnThesisRating() &&lts.getLearnThesisRating().equals(LearnThesisRating.VERYGOOD)){
						goodmarkingWorkCount++;
					}
				}
				List<Question> questions = questionService.listByAsker(learnClassUsers.get(i));
				for(Question q : questions){
					questionList.add(q);
					if(q.isResolved()){
						questionResolved++;
						continue;
					}
					questionUnResolved++;
				}
			}
		}
		projectStatistic.setLearnThesisInfo(learnThesisSubmitList.size()+"/"+markingWorkCount+"/"+goodmarkingWorkCount);
		projectStatistic.setQuestionInfo(questionList.size()+"/"+questionResolved+"/"+questionUnResolved);
		projectStatistic.setCitiesCount(citiesIdList.size());
		projectStatistic.setProvinceCount(provinceIdList.size());
		projectStatistic.setSchoolCount(schoolList.size());
		Integer activeStudentCount =0;
		for(User user : users){
			if(user.isActive()){
				activeStudentCount++;
			}
		}
		projectStatistic.setClassMateInfo(activeStudentCount+"/"+users.size());
		setOnlineTimeAndEnableTimeCount(projectStatistic, timeCount);
		List<Long> projectForum = Lists.newArrayList();
		projectForum.add(projectForumCount);
		projectForum.add(projectForumReplyCount);
		setForum(projectForum, projectStatistic);
		
	
		/**
		 * 当前项目下班级的统计列表
		 */
		List<LearnStatistics> learnClassStatistics=Lists.newArrayList();
		
		for(int i =0;i<learnClasses.size();i++){
			LearnStatistics ls = new LearnStatistics();
			//人员
			LearnClass temp = learnClasses.get(i);
			List<User> usersInClass=schoolRollService.listActiveByLearnClass(temp);
			Integer totalClassMateCount = schoolRollService.findUsersByClass(temp).size();
			Integer activeClassMateCount =0;
			setClassSpaceForum(ls, temp);
			setOnlineTimeAndEnableTimeCount(ls, getClassTimeCount(temp));
			//learnThesis Info
			//1.获取所有提交数量
			Integer learnThesisMarkingGoodCount=0;
			Integer learnThesisMarkingCount = 0;
			Integer learnThesisTotalCount = 0;
			for(User classMate : usersInClass){
				if(classMate.isActive()){
					activeClassMateCount++;
				}
				List<LearnThesisSubmit> learnThesisSubmits=learnThesisSubmitInfomationService.listActiveInfoByStudentUser(classMate);
				for(LearnThesisSubmit learnThesisSubmit : learnThesisSubmits){
					learnThesisTotalCount++;
					if(null!=learnThesisSubmit.getMakingDate()){
						learnThesisMarkingCount++;
					}
					if(null!=learnThesisSubmit.getLearnThesisRating() && 
								learnThesisSubmit.getLearnThesisRating().equals(LearnThesisRating.VERYGOOD))	
						learnThesisMarkingGoodCount++;
				}
			}
			ls.setLearnThesisInfo(learnThesisTotalCount+"/"+learnThesisMarkingCount+"/"+learnThesisMarkingGoodCount);
			ls.setClassMateInfo(totalClassMateCount+"/"+activeClassMateCount);
			//Question Mock
			//获取当前班级的所有question
			List<Question> questions = questionService.listByLearnClass(temp);
			Integer questionsInClassTotalCount=questions.size();
			Integer questionResolveCount = 0;
			Integer questionUnResolveCount = 0;
			
			for(Question question : questions){
				if(question.isResolved()){
					questionResolveCount++;
					continue;
				}
				questionUnResolveCount++;
			}
			ls.setQuestionInfo(questionsInClassTotalCount+"/"+questionResolveCount+"/"+questionUnResolveCount);
			ls.setLearnClass(temp);
			learnClassStatistics.add(ls);
		}
		messageBoxInit(session, currentUser);
		model.addAttribute("learnClassStatistics",learnClassStatistics);
		model.addAttribute("projectStatistic", projectStatistic);
	}

	private void initTeacherFirstPageDate(Model model,HttpServletRequest request){
		HttpSession session = request.getSession();
		User currentUser = (User)session.getAttribute("currentUser");
		/**
		 * TODO 公告初始化
		 */
		List<Announcement> classAs=Lists.newArrayList();
		List<Announcement> projectAs=Lists.newArrayList();
		List<Announcement> sysAs = Lists.newArrayList();
		List<Announcement> provinceAs = Lists.newArrayList();
		List<Announcement> schoolAs=Lists.newArrayList();
		List<Announcement> disciplineAs=Lists.newArrayList();
		List<ClassCourseInfomation> classCourseInfomationList=Lists.newArrayList();
		
		LearnClass learnClass = learnClassService.findByTeacher(currentUser);
		//公告：班级公告
		//1.找到我发的班级公告
		classAs = announcementService.listAllNewestFirstNine(currentUser);
		//公告：优秀研修论文
		
		//公告：项目公告
		projectAs=projectGGInit(learnClass,projectAs);
		//公告 :省督导公告
		provinceAs=provinceGGInit(learnClass,provinceAs);
		//公告：校督导公告
		schoolAs=schoolGGInit(currentUser,schoolAs);
		//公告：学科公告
		disciplineAs=disciplineGGInit(learnClass,disciplineAs);
		//培训公告
		sysAs=sysGGInit(sysAs);
		//获取当前课程和在修人数
		//1.获取当前课程列表
		LearnSubProject  learnSubProject = learnClass.getLearnProject();
		List<LearnCourse> learnCourseList = learnPlanService.listLearnCourseBylearnSubProject(learnSubProject);
		//2.获取当前班级激活人数
		Integer activeUserCount=schoolRollService.listActiveByLearnClass(learnClass).size();
		for(LearnCourse learnCourse:learnCourseList){
			ClassCourseInfomation cci = new ClassCourseInfomation();
			cci.setLearnCourse(learnCourse);
			cci.setUserdCount(activeUserCount);
			classCourseInfomationList.add(cci);
		}
		//获取当前问题的统计
		WorkStatistics questionWs = questionTotalInit(learnClass);
		
		//获取作业的统计
		WorkStatistics learnThesisWs = learnThesisTotalInit(currentUser);
		
		//1.我的班级 
 		classPathInit(session, learnClass.getLearnProject().getDiscipline().getId());
 		//2.我的校本研修空间
 		xbyxPathInit(session, learnClass.getLearnProject().getDiscipline().getId());
 		//我的学校空间
 		schoolPathInit(session, currentUser);
 		
 		messageBoxInit(session, currentUser);
 		
 	
		model.addAttribute("learnThesisWs",learnThesisWs);
		model.addAttribute("questionWs", questionWs); 
		model.addAttribute("classCourseInfomationList", classCourseInfomationList);
		model.addAttribute("classAs", classAs);
		model.addAttribute("projectAs", projectAs);
		model.addAttribute("sysAs", sysAs);
		model.addAttribute("provinceAs", provinceAs);
		model.addAttribute("schoolAs", schoolAs);
		model.addAttribute("disciplineAs", disciplineAs);
		model.addAttribute("learnClass", learnClass);
	}

	private void initStudentFirstPageDate(Model model,HttpServletRequest request) {
		HttpSession session = request.getSession();
		User currentUser = (User)session.getAttribute("currentUser");
		
		/**
		 * TODO 公告初始化
		 */
		List<Announcement> classAs=Lists.newArrayList();
		List<LearnThesis> learnThesisList=Lists.newArrayList();
		List<Announcement> projectAs=Lists.newArrayList();
		List<Announcement> sysAs = Lists.newArrayList();
		List<Announcement> provinceAs = Lists.newArrayList();
		List<Announcement> schoolAs=Lists.newArrayList();
		List<Announcement> disciplineAs=Lists.newArrayList();
		List<BigSubject> bigSubjectAs=Lists.newArrayList();
		List<Grade> gradesList = Lists.newArrayList();
		
		//公告：班级公告
		//1.找到我所在的班级
		LearnClass learnClass = schoolRollService.findByUserNewest(currentUser).getLearnClass();
		LearnSubProject learnSubProject = learnClass.getLearnProject();
		//2.找到班级老师
		User teacher = learnClass.getTeacher();
		//找到班级老师所发布的最新9条公告
		if(!checkEntityEmpty(teacher)){
			classAs=announcementService.listAllNewestFirstNine(teacher);
		}
		//公告：优秀研修论文
		//项目公告
		projectAs=projectGGInit(learnClass,projectAs);
		//省督导公告
		provinceAs=provinceGGInit(learnClass,provinceAs);
		//校督导公告
		schoolAs=schoolGGInit(currentUser,schoolAs);
		//学科专家公告
		disciplineAs=disciplineGGInit(learnClass,disciplineAs);
		//公告：培训公告
		sysAs=sysGGInit(sysAs);
		
		//当前班级所有学员成绩
		gradesList=classMateInit(learnClass,gradesList);
		
		//mock统计
		for(int i =0;i<gradesList.size();i++){
			mockDate(gradesList, i);
		}
		//校本研修内容
		//1.找到学生所在学科的校本研修大主题
		Discipline discipline = learnSubProject.getDiscipline();
		bigSubjectAs =  bigSubjectService.listWithDisciplineInCurrentBatch(discipline);
		
		//获取用户站内信信息放到session
		messageBoxInit(session, currentUser);
		//初始化部分需要导向的路径
		//1.我的班级 
 		classPathInit(session, learnClass.getLearnProject().getDiscipline().getId());
 		//2.我的校本研修空间
 		xbyxPathInit(session, learnClass.getLearnProject().getDiscipline().getId());
 		//我的学校空间
 		schoolPathInit(session, currentUser);
 		
 		model.addAttribute("classAs", classAs);
		model.addAttribute("learnThesisList", learnThesisList);
		model.addAttribute("projectAs", projectAs);
		model.addAttribute("sysAs", sysAs);
		model.addAttribute("provinceAs", provinceAs);
		model.addAttribute("schoolAs", schoolAs);
		model.addAttribute("disciplineAs", disciplineAs);
		model.addAttribute("bigSubjectAs", bigSubjectAs);
		model.addAttribute("gradesList", gradesList);
		model.addAttribute("learnClass", learnClass);
		
 		
	}

	private void schoolPathInit(HttpSession session, User currentUser) {
		SchoolSpace schoolSpace;
		if(currentUser.getUserType().equals(UserType.School_Supervisor)){
			schoolSpace=schoolSpaceService.findByPersonIncharge(currentUser);
		}
		else{
			schoolSpace = schoolSpaceService.findBySchoolNameAndBatch(currentUser.getAccount().getSchool(),batchService.getCurrentBatch());
		}
		
 		String mySchoolPath=LoadProperties.getProperty(Constants.STUDY_PLATFORM_URL)+
 							LoadProperties.getProperty(Constants.STUDY_PLATFORM_ACCESS_PATH_KEY)+
 							Constants.STUDY_PLATFORM_SCHOOLSPACE_PREFIX+schoolSpace.getId();
 		session.setAttribute("mySchoolPath", mySchoolPath);
	}

	private void xbyxPathInit(HttpSession session, Long disciplineId) {
		String myXBYXPath=LoadProperties.getProperty(Constants.STUDY_PLATFORM_URL)+
							LoadProperties.getProperty(Constants.STUDY_PLATFORM_ACCESS_PATH_KEY)+
							Constants.STUDY_PLATFORM_XBYX_PREFIX+disciplineId;
		session.setAttribute("myXBYXPath", myXBYXPath);
	}

	private void classPathInit(HttpSession session,Long disciplineId) {
		String myClassPath=LoadProperties.getProperty(Constants.STUDY_PLATFORM_URL)+
 							LoadProperties.getProperty(Constants.STUDY_PLATFORM_ACCESS_PATH_KEY)+
 							Constants.STUDY_PLATFORM_DISCIPLINESPACE_PREFIX+disciplineId;
 		session.setAttribute("myClass", myClassPath);
	}

	private void messageBoxInit(HttpSession session, User currentUser) {
		Integer notificationCount = receiverNotificationService.countNoConsultNotificationByUser(currentUser);
		session.setAttribute("unreadCount", notificationCount);
	}

	private List<Grade> classMateInit(LearnClass learnClass,List<Grade> gradesList) {
		List<User> classMate = schoolRollService.listActiveByLearnClass(learnClass);
		for(User user : classMate){
			gradesList.add(gradeService.findByUser(user));
		}
		return gradesList;
	}

	private List<Announcement> sysGGInit(List<Announcement> sysAs) {
		User systemUser = userService.findByUserType(UserType.System_Administrator);
		sysAs = announcementService.listAllNewestFirstNine(systemUser);
		return sysAs;
	}

	private void mockDate(List<Grade> gradesList, int i) {
		Grade grade = gradesList.get(i);
		//真实 研修讨论分数
		//获取讨论帖子数
		LearnClass learnClass=learnClassService.findById(grade.getLearnClassId());
		
		List<Long> forumscore=getUserForum(grade.getUser(),learnClass);
		Double result = forumscore.get(0)+forumscore.get(1).doubleValue();
		if(result>grade.getScoringStandard().getLearnDiscussProportion()*100){
			result=grade.getScoringStandard().getLearnDiscussProportion()*100;
		}
		grade.setLearnDiscussScore(result);
		
		//在线时长
		Long onlineTime=getUserOnlineTimeCount(grade.getUser(),learnClass.getLearnProject().getDiscipline().getId());
		String onlineTimeStr = formateReturnOnlineTimeCount(onlineTime);
		grade.setOnlineTimeCount(onlineTimeStr);
		
		
		//视频分数
		Double videoResult=grade.getScoringStandard().getLearnVideoProportion()*100;
		//找出当前批次总共的视频数量
		List<VideoInfo> videos = videoService.listByDiscipline(learnClass.getLearnProject().getDiscipline(),batchService.getCurrentBatch());
		Double userVideoScore=0.0;
		DecimalFormat format = new DecimalFormat("0.00");
		
		//每个视频的分数
		System.out.println("Start videos..."+videos.size());
		if(!videos.isEmpty()){
			
			Double sigleVideoScore = videoResult/videos.size();
			System.out.println("Enter videos..."+videos.size());
			//查找当前用户每个视频的得分
			for(VideoInfo vi : videos){
				VideoStatistics select = new VideoStatistics();
				select.setUserLoginName(grade.getUser().getLoginName());
				select.setDisciplineId(learnClass.getLearnProject().getDiscipline().getId());
				select.setVideoId(vi.getVideoId());
				VideoStatistics videoStatistics = videoStatisticsService.findByLoginNameAndDisciplineIdAndSchoolSpaceIdAndVideoId(select);
				
				if(null!=videoStatistics){
					System.out.println("Enter videoStatistics "+videoStatistics.getUserLoginName()+":"+videoStatistics.getTimeCount());
					//计算每个视频的得分
					
					//有效时长
					String EffectiveTimeCount  = formateReturnOnlineTimeCount(vi.getVideoLength());
					grade.setEffectiveTimeCount(EffectiveTimeCount);
					
					//1.获取当前视频的总时长(秒)
					Double videoLength = vi.getVideoLength().doubleValue()/1000;
					System.out.println("Enter videoLength = "+videoLength);
					//2.获取当前视频每分钟得分
					Double secondSocre=sigleVideoScore/videoLength;
					Double currentVideoScore = secondSocre*videoStatistics.getTimeCount();
					System.out.println("Enter currentVideoScore ="+currentVideoScore);
					if(currentVideoScore>sigleVideoScore){
						currentVideoScore=sigleVideoScore;
					}
					System.out.println("User videoScore");
					userVideoScore+=currentVideoScore;
				}
			}
		}
		System.out.println(userVideoScore);
		grade.setLearnVideoScore(Double.valueOf(format.format(userVideoScore)));
		
		
		//真实的研修论文数据
		//1.获取当前用户所归属的所有研修论文
		List<LearnThesisSubmit> ltsList = learnThesisSubmitInfomationService.listActiveInfoByStudentUser(grade.getUser());
		Double scoreCount = 0.0;
		for(LearnThesisSubmit lts : ltsList ){
			scoreCount+=lts.getScore();
		}
		if(scoreCount>grade.getScoringStandard().getLearnThesisProportion()*100){
			scoreCount=grade.getScoringStandard().getLearnThesisProportion()*100;
		}
		grade.setLearnThesisScore(scoreCount);
		gradesList.set(i, grade);
		gradeService.update(grade);
	}


	private Long getUserOnlineTimeCount(User user, Long id) {
		Long onlineTimeCount=client.userOnlineTimeCount(id.toString(), user.getLoginName(), SpaceType.STUDY);
		return null==onlineTimeCount?0:onlineTimeCount;
	}

	private List<Long> getUserForum(User user,LearnClass learnClass) {
		List<Long> userForum = client.userForumCountInStudySpace(learnClass.getLearnProject()
				.getDiscipline().getId().toString(), user.getLoginName(),
				SpaceType.STUDY);
		return userForum;
	}

	private User findcurrentUser(String loginName) throws LocalDatabaseUserNotFoundException{
		User currentUser = null;
		currentUser = userService.findByLoginName(loginName);
		if(null == currentUser){
			throw new LocalDatabaseUserNotFoundException();
		}
		return currentUser;
	}
	

	private List<Announcement> disciplineGGInit(LearnClass learnClass,List<Announcement> disciplineAs) {
		User disciplineUser=learnClass.getLearnProject().getDiscipline().getPersonInCharge();
		if(!checkEntityEmpty(disciplineUser)){
			disciplineAs = announcementService.listAllNewestFirstNine(disciplineUser);
		}
		return disciplineAs;
	}

	private List<Announcement> schoolGGInit(User currentUser,List<Announcement> schoolAs) {
		SchoolSpace schoolSpace  = schoolSpaceService.findBySchoolNameAndBatch(currentUser.getAccount().getSchool(),batchService.getCurrentBatch());
		User schoolUser =schoolSpace.getUser();
		if(!checkEntityEmpty(schoolUser)){
			schoolAs = announcementService.listAllNewestFirstNine(schoolUser);
		}
		return schoolAs;
	}

	private List<Announcement> provinceGGInit(LearnClass learnClass,List<Announcement> projectAs) {
		User provinceUser=learnClass.getLearnArea().getUser();
		if(!checkEntityEmpty(provinceUser)){
			projectAs = announcementService.listAllNewestFirstNine(provinceUser);
		}
		return projectAs;
	}

	private List<Announcement> projectGGInit(LearnClass learnClass,List<Announcement> projectAs) {
		LearnSubProject learnSubProject= learnClass.getLearnProject();
		User projectUser = learnSubProject.getPersonInCharge();
		if(!checkEntityEmpty(projectUser)){
			projectAs = announcementService.listAllNewestFirstNine(projectUser);
		}
		return projectAs;
	}
	

	private WorkStatistics questionTotalInit(LearnClass learnClass) {
		WorkStatistics questionWs = new WorkStatistics();
		List<User> classMate = schoolRollService.findUsersByClass(learnClass);
		Integer waitresolveCount = 0;
		Integer resolveCount = 0;
		for(User user : classMate){
			List<Question> questions=questionService.listByAsker(user);
			for(Question question: questions){
				if(question.isResolved()){
					resolveCount++;
					continue;
				}
				waitresolveCount++;
			}
		}
		questionWs.setResolveCount(resolveCount);
		questionWs.setWaitResolveCount(waitresolveCount);
		questionWs.setWorkType(WorkType.Question);
		return questionWs;
	}

	private WorkStatistics learnThesisTotalInit(User currentUser) {
		List<LearnThesisSubmit> learnThesisSubmits = learnThesisSubmitInfomationService.listActiveInfoByTeacherUser(currentUser);
		WorkStatistics learnThesisWs=new WorkStatistics();
		Integer resolveCount = 0;
		Integer waitresolveCoutn = 0;
		for(LearnThesisSubmit lst : learnThesisSubmits){
			if(null==lst.getMakingDate()){
				waitresolveCoutn++;
				continue;
			}
			resolveCount++;
		}
		learnThesisWs.setResolveCount(resolveCount);
		learnThesisWs.setWaitResolveCount(waitresolveCoutn);
		learnThesisWs.setWorkType(WorkType.LearnThesis);
		return learnThesisWs;
	}
	

	private void setStudySpaceOnlineTimeAndEnableTime(LearnStatistics ls, Long id) {
		
		Long onlineTimeCount=client.studySpaceOnLineTimeCount(id.toString(), SpaceType.STUDY);
		setOnlineTimeAndEnableTimeCount(ls, onlineTimeCount);
	}
	
	private void setSchoolSpaceOnlineTimeAndEnableTime(LearnStatistics ls ,Long id){
		Long onlineTimeCount = client.studySpaceOnLineTimeCount(id.toString(), SpaceType.SCHOOL);
		setOnlineTimeAndEnableTimeCount(ls, onlineTimeCount);
	}
	
	private void setStudySpaceForum(LearnStatistics ls,Long id){
		List<Long> forumCount = client.studySpaceForumCount(id.toString(),SpaceType.STUDY);
		setForum(forumCount, ls);
	}
	
	private void setSchoolSpaceForum(LearnStatistics ls,Long id){
		
		List<Long> forumCount=client.studySpaceForumCount(id.toString(), SpaceType.SCHOOL);
		setForum(forumCount, ls);
	}
	
	private void setClassSpaceForum(LearnStatistics ls,LearnClass learnClass){
		
		List<Long> forumCount=client.classForumCountInStudySpace(learnClass.getLearnProject()
				.getDiscipline().getId().toString(), learnClass
				.getLearnClassStudySpaceId());
		setForum(forumCount, ls);
	}
	
	private List<Long> getClassSpaceForumCount(LearnClass learnClass){
		
		List<Long> forumCount=client.classForumCountInStudySpace(learnClass.getLearnProject()
				.getDiscipline().getId().toString(), learnClass
				.getLearnClassStudySpaceId());
		return forumCount;
	}
	
	
	
	private void setForum(List<Long> forumCount,LearnStatistics ls){
		Long forum=forumCount.get(0);
		Long forumReply=forumCount.get(1);
		ls.setForumTopicInfo(forum+"/"+forumReply);
	}
	
	private void setOnlineTimeAndEnableTimeCount(LearnStatistics ls,Long onlineTimeCount){
		String formateOnlineTimeCount=formateReturnOnlineTimeCount(onlineTimeCount);
		String formateEnableTimeCount=formateReturnEnableTimeCount(onlineTimeCount);
		ls.setOnlineTimeCount(formateOnlineTimeCount);
		ls.setEnableTimeCount(formateEnableTimeCount);
	}
	
	
	private String formateReturnOnlineTimeCount(Long timeCount){
		if(timeCount==-1L){
			return "-1";
		}
		//转换成秒
		Integer seconds=timeCount.intValue()/1000;
		//从秒转成分钟
		Integer minutes = seconds/60;
		//从分钟转成小时，需要记录多余分钟数
		Integer hours =  minutes/60;
		Integer lastMinutes=minutes%60;
		
		return hours+" hours | "+lastMinutes+" minutes";
	}
	
	private String formateReturnEnableTimeCount(Long timeCount){
		if(timeCount==-1L){
			return "-1";
		}
		//转换成秒
		Integer seconds=timeCount.intValue()/1000;
		//从秒转成分钟
		Integer minutes = seconds/60;
		//从分钟转成小时，需要记录多余分钟数
		Integer hours =  minutes/60;
		Integer lastMinutes=minutes%60;
		Random random = new Random(new Date().getTime());
		if(hours>1){
			hours=random.nextInt(hours);
		}
		if(lastMinutes>1){
			lastMinutes=random.nextInt(lastMinutes);
		}
		return hours+" hours | "+lastMinutes+" minutes";
	}
	
	private Long getClassTimeCount(LearnClass temp) {
		Long result=client.classOnlineTimeCount(temp.getLearnProject().getDiscipline()
				.getId().toString(), temp.getLearnClassStudySpaceId(),
				SpaceType.STUDY);
		return result;
	}
	
	
	private Long getStudySpaceOnlineTime(String id){
		Long result = client.studySpaceOnLineTimeCount(id, SpaceType.STUDY);
		return result;
	}

}
