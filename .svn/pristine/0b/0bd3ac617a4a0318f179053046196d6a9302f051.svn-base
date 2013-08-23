package com.boventech.gplearn.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.boventech.gplearn.annotation.RequiredPrivilege;
import com.boventech.gplearn.entity.Constants;
import com.boventech.gplearn.entity.LearnClass;
import com.boventech.gplearn.entity.LearnResource;
import com.boventech.gplearn.entity.Privilege;
import com.boventech.gplearn.entity.User;
import com.boventech.gplearn.entity.User.UserType;
import com.boventech.gplearn.service.LearnClassService;
import com.boventech.gplearn.service.LearnResourceService;
import com.boventech.gplearn.service.SchoolRollService;

@Controller
@RequestMapping(value="/learnresource")
public class LearnResourceController extends ApplicationController {
	
	private static final Logger logger = LoggerFactory.getLogger(LearnResourceController.class);

	@Autowired
	private LearnClassService learnClassService;
	
	
	@Autowired
	private SchoolRollService schoolRollService;
	
	@Autowired
	private LearnResourceService learnResourceService;
	
	
	
	@RequiredPrivilege(value={Privilege.STUDENT_CLASS_RESOURCE,Privilege.TEACHER_CLASS_RESOURCE,
						Privilege.SUBJECT_RESOURCE})	
	@RequestMapping(value="/disciplineresources")
	public String showDisciplineresource(HttpServletRequest request,Model model,Integer page){
		User user = (User)request.getSession().getAttribute("currentUser");
		User disciplineUser = null;
		if(user.getUserType().equals(UserType.Student)){
			//找到学科专家
			LearnClass learnClass = schoolRollService.findByUserNewest(user).getLearnClass();
			disciplineUser = learnClass.getLearnProject().getDiscipline().getPersonInCharge();
		}
		if(user.getUserType().equals(UserType.Teacher)){
			LearnClass learnClass  = learnClassService.findByTeacher(user);
			disciplineUser = learnClass.getLearnProject().getDiscipline().getPersonInCharge();
		}
		if(user.getUserType().equals(UserType.Subject_Specialists)){
			disciplineUser=user;
		}
		List<LearnResource> disciplineResources=learnResourceService.listByUser(disciplineUser,page);
		model.addAttribute("disciplineResources", disciplineResources);
		return "role/"+backFolderNameByUserType(user.getUserType())+"/disciplineresources";
	}
	
	@RequiredPrivilege(value={Privilege.STUDENT_CLASS_RESOURCE,Privilege.TEACHER_CLASS_RESOURCE,
			Privilege.PROJECT_RESOURCE})	
	@RequestMapping(value="/projectresources")
	public String showProjectResources(HttpServletRequest request,Model model,Integer page){
		User user = (User)request.getSession().getAttribute("currentUser");
		User projectUser = null;
		if(user.getUserType().equals(UserType.Student)){
			LearnClass learnClass = schoolRollService.findByUserNewest(user).getLearnClass();
			projectUser = learnClass.getLearnProject().getPersonInCharge();
		}
		if(user.getUserType().equals(UserType.Teacher)){
			LearnClass learnClass  = learnClassService.findByTeacher(user);
			projectUser = learnClass.getLearnProject().getPersonInCharge();
		}
		if(user.getUserType().equals(UserType.Project_Specialists)){
			projectUser  = user;
		}
		List<LearnResource> projectResources=learnResourceService.listByUser(projectUser, page);
		model.addAttribute("projectResources", projectResources);
		return "role/"+backFolderNameByUserType(user.getUserType())+"/projectresources";
	}
	
	@RequiredPrivilege(value={Privilege.SUBJECT_USER_ACCOUNT,Privilege.PROJECT_RESOURCE})
	@RequestMapping(value="/new")
	public String createNewLearnResource(HttpServletRequest request){
		User user = (User)request.getSession().getAttribute("currentUser");
		return "role/"+backFolderNameByUserType(user.getUserType())+"/createlearnresource";
	}
	@RequiredPrivilege(value={Privilege.SUBJECT_USER_ACCOUNT,Privilege.PROJECT_RESOURCE})
	@RequestMapping(method=RequestMethod.POST)
	public String saveNewLearnResource(LearnResource learnResource,MultipartFile file,HttpServletRequest request,RedirectAttributes redirectAttrs){
		User user = (User)request.getSession().getAttribute("currentUser");
		Long size=file.getSize();
		if(size<=0){
			sendErrorMessageWhenRedirect(redirectAttrs, "upload.learnthesis.file.null");
		}
		if((size/1024/1024)>20){
			sendErrorMessageWhenRedirect(redirectAttrs,"upload.size.outofrange");
		}
		else{
			String path = request.getSession().getServletContext()
			.getRealPath(Constants.DEFAULT_UPLOAD_PATH);
			String fileName = file.getOriginalFilename();
			if(null!=fileName && !"".equals(fileName)){
				Integer prefix = fileName.lastIndexOf(Constants.POINT);
				String suffix = fileName.substring(prefix==-1?0:prefix,fileName.length());
				fileName=personInchargeLoginNamePrefix()+suffix;
				File target = new File(path, fileName);
				if (!target.exists()) {
					target.mkdirs();
				}
				try {
					file.transferTo(target);
					learnResourceService.saveLearnResource(user,learnResource,fileName);
					sendNoticeWhenRedirect(redirectAttrs,"common.add.success");
				} catch (IllegalStateException e) {
					logger.error(e.getMessage());
				} catch (IOException e) {
					logger.error(e.getMessage());
				}
			}
		}
		if(user.getUserType().equals(UserType.Project_Specialists)){
			return "redirect:/learnresource/projectresources";
		}
		else{
			return "redirect:/learnresource/disciplineresources";
		}
	}
}
