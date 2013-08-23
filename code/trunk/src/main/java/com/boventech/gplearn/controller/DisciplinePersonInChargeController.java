package com.boventech.gplearn.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import sun.misc.BASE64Encoder;

import com.boventech.gplearn.annotation.RequiredPrivilege;
import com.boventech.gplearn.controller.ApplicationController;
import com.boventech.gplearn.entity.Discipline;
import com.boventech.gplearn.entity.Privilege;
import com.boventech.gplearn.entity.User;
import com.boventech.gplearn.entity.User.UserType;
import com.boventech.gplearn.exception.UserInfoPushToStudySpaceFaildException;
import com.boventech.gplearn.exception.UserInfoSendCASFaildException;
import com.boventech.gplearn.service.DisciplineService;
import com.boventech.gplearn.service.UserService;

@Controller
@RequestMapping(value="/discipline/{disciplineId}/personincharge")
public class DisciplinePersonInChargeController extends ApplicationController {

	private static final Logger LOGGER = LoggerFactory.getLogger(DisciplinePersonInChargeController.class);
	
	@Autowired
	private DisciplineService disciplineService;
	
	@Autowired
	private UserService userService;
	
	@RequiredPrivilege(value={Privilege.SYSTEM_DISCIPLINE})
	@RequestMapping(value="/{userId}")
	public String show(Model model,@PathVariable Long disciplineId,@PathVariable Long userId){
		User disciplinePersonIncharge=userService.findById(userId);
		Discipline discipline = disciplineService.findById(disciplineId);
		if(checkEntityEmpty(disciplinePersonIncharge) || checkEntityEmpty(discipline)){
			return "error/404";
		}
		model.addAttribute("discipline", discipline);
		model.addAttribute("user",disciplinePersonIncharge);
		return "discipline/personincharge/show";
	}
	
	@RequiredPrivilege(value={Privilege.SYSTEM_DISCIPLINE})
	@RequestMapping(value="/create")
	public String create(@PathVariable Long disciplineId,Model model,RedirectAttributes redirectAttr){
		Discipline selectedDiscipline= disciplineService.findById(disciplineId);
		if(checkEntityEmpty(selectedDiscipline)){
			sendErrorMessageWhenRedirect(redirectAttr, "discipline.notfound");
			return "redirect:/discipline";
		}
		model.addAttribute("discipline", selectedDiscipline);
		model.addAttribute("prefix", personInchargeLoginNamePrefix());
		return "discipline/personincharge/create";
	}
	
	@RequiredPrivilege(value={Privilege.SYSTEM_DISCIPLINE})
	@RequestMapping(method=RequestMethod.POST)
	public String save(String prefix,@PathVariable Long disciplineId,User user,RedirectAttributes redirectAttr){
		Discipline selectedDiscipline= disciplineService.findById(disciplineId);
		if(checkEntityEmpty(selectedDiscipline)){
			sendErrorMessageWhenRedirect(redirectAttr, "discipline.notfound");
		}
		else{
			if(userService.checkEntityExsitByLoginName(user.getLoginName())){
				sendErrorMessageWhenRedirect(redirectAttr, "user.entity.exsit");
			}
			else{
				user.setLoginName(prefix);
				user.setActive(true);
				user.setUserType(UserType.Subject_Specialists);
				user.setPassword(new BASE64Encoder().encode(user.getPassword().getBytes()));
				try {
					userService.pushDisciplinePersonInChargeToTheStudySpace(user,selectedDiscipline);
					sendNoticeWhenRedirect(redirectAttr, "common.add.success");
				} catch (UserInfoSendCASFaildException e) {
					LOGGER.error(e.getMessage());
					sendErrorMessageWhenRedirect(redirectAttr, "user.cas.sendError");
				} catch (UserInfoPushToStudySpaceFaildException e) {
					LOGGER.error(e.getMessage());
					sendErrorMessageWhenRedirect(redirectAttr, "user.space.sendError");
				}
			}
		}
		
		return "redirect:/discipline";
	}
	
	
	
	

}

	