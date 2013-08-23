package com.boventech.gplearn.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import com.boventech.gplearn.annotation.RequiredPrivilege;
import com.boventech.gplearn.entity.LearnClass;
import com.boventech.gplearn.entity.Privilege;
import com.boventech.gplearn.entity.User;
import com.boventech.gplearn.exception.UserDestroyInStudySpaceFaildException;
import com.boventech.gplearn.exception.UserInfoPushToStudySpaceClassRoomFaildException;
import com.boventech.gplearn.service.LearnClassService;
import com.boventech.gplearn.service.SchoolRollService;
import com.boventech.gplearn.service.UserService;

@Controller
@RequestMapping(value="/learnclass/{classId}/personincharge")
public class LearnClassPersonInChargeController extends ApplicationController {

	private static final Logger logger = LoggerFactory.getLogger(LearnClassPersonInChargeController.class);
	
	@Autowired
	private LearnClassService learnClassService;
	
	@Autowired
	private UserService userService;
	
	
	@Autowired
	private SchoolRollService schoolRollService;
	
	@RequiredPrivilege(value={Privilege.SYSTEM_LEARNCLASS})
	@RequestMapping
	public String show(@PathVariable Long classId,Model model){
		LearnClass learnClass = learnClassService.findById(classId);
		if(checkEntityEmpty(learnClass)){
			return "error/404";
		}
		model.addAttribute("user",learnClass.getTeacher());
		model.addAttribute("learnClass",learnClass);
		return "learnClass/personincharge/show";
	}
	
	@RequiredPrivilege(value={Privilege.SYSTEM_LEARNCLASS})
	@RequestMapping(value="/create")
	public String create(@PathVariable Long classId,Model model,RedirectAttributes redirectAttr){
		LearnClass learnClass = learnClassService.findById(classId);
		if(checkEntityEmpty(learnClass)){
			return "error/404";
		}
		List<User> classUsers = schoolRollService.findUsersByClass(learnClass);
		if(classUsers.isEmpty()){
			sendErrorMessageWhenRedirect(redirectAttr, "setteacher.enableusers.notfound");
			return "redirect:/account";
		}
		model.addAttribute("learnClass", learnClass);
		model.addAttribute("classUsers", classUsers);
		return "learnClass/personincharge/create";
	}
	
	/**
	 * 创建班级老师
	 * @param studentId
	 * @param classId
	 * @param model
	 * @param redirect
	 * @return
	 */
	@RequiredPrivilege(value={Privilege.SYSTEM_LEARNCLASS})
	@RequestMapping(method=RequestMethod.POST)
	public String save(Long studentId,@PathVariable Long classId,Model model,RedirectAttributes redirect){
		User user = userService.findById(studentId);
		LearnClass learnClass = learnClassService.findById(classId);
		if(checkEntityEmpty(learnClass) || checkEntityEmpty(user)){
			return "error/404";
		}
		try {
			userService.saveTeacher(learnClass,user);
			sendNoticeWhenRedirect(redirect, "common.add.success");
		} catch (UserDestroyInStudySpaceFaildException e) {
			sendErrorMessageWhenRedirect(redirect, "user.space.destroy.error");
			logger.error(e.getMessage());
		} catch (UserInfoPushToStudySpaceClassRoomFaildException e) {
			sendErrorMessageWhenRedirect(redirect, "user.space.classroom.sendError");
			logger.error(e.getMessage());
		}
		
		return "redirect:/learnclass";
	}
}