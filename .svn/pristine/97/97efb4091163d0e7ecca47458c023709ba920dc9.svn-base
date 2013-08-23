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
import com.boventech.gplearn.entity.Batch;
import com.boventech.gplearn.entity.LearnSubProject;
import com.boventech.gplearn.entity.Privilege;
import com.boventech.gplearn.entity.User;
import com.boventech.gplearn.entity.User.UserType;
import com.boventech.gplearn.exception.UserInfoSendCASFaildException;
import com.boventech.gplearn.service.BatchService;
import com.boventech.gplearn.service.LearnSubProjectService;
import com.boventech.gplearn.service.UserService;

@Controller
@RequestMapping(value="/learnproject/{lpid}/learnsubproject/{id}/personincharge")
public class LearnSubProjectPersonInChargeController extends
		ApplicationController {
	
	private static final Logger logger = LoggerFactory.getLogger(LearnSubProjectPersonInChargeController.class);
	
	@Autowired
	private LearnSubProjectService learnSubProjectService;
	
	@Autowired
	private BatchService batchService;
	
	@Autowired 
	private UserService userService;
	
	@RequiredPrivilege(value={Privilege.SYSTEM_LEARNSUBPROJECT})
	@RequestMapping
	public String show(@PathVariable Long id,Model model){
		LearnSubProject lsp = learnSubProjectService.findById(id);
		if(checkEntityEmpty(lsp)){
			return "error/404";
		}
		model.addAttribute("learnSubproject",lsp);
		model.addAttribute("user", lsp.getPersonInCharge());
		return "learnsubproject/personincharge/show";
	}
	
	@RequiredPrivilege(value={Privilege.SYSTEM_LEARNSUBPROJECT})
	@RequestMapping(value="/create")
	public String create(@PathVariable Long lpid,@PathVariable Long id,Model model,RedirectAttributes redirectAttr){
		LearnSubProject lsp = learnSubProjectService.findById(id);
		if(checkEntityEmpty(lsp)){
			return "error/404";
		}
		model.addAttribute("learnSubproject", lsp);
		model.addAttribute("prefix", personInchargeLoginNamePrefix());
		return "learnsubproject/personincharge/create";
	}
	
	@RequiredPrivilege(value={Privilege.SYSTEM_LEARNSUBPROJECT})
	@RequestMapping(method=RequestMethod.POST)
	public String save(User user,@PathVariable Long lpid,@PathVariable Long id,RedirectAttributes redirectAttr,String prefix){
		user.setLoginName(prefix);
		user.setId(null);
		LearnSubProject lsp = learnSubProjectService.findById(id);
		if(checkEntityEmpty(lsp)){
			return "error/404";
		}
		if(userService.checkEntityExsitByLoginName(user.getLoginName())){
			sendErrorMessageWhenRedirect(redirectAttr, "user.entity.exsit");
		}
		else{
			Batch currentBatch=batchService.getCurrentBatch();
			if(null==currentBatch){
				sendErrorMessageWhenRedirect(redirectAttr,
				"learnPlan.currentbatch.null");
				return "redirect:/batch";
			}
			user.setBatch(currentBatch);
			user.setPassword(new BASE64Encoder().encode(user.getPassword().getBytes()));
			user.setActive(true);
			user.setUserType(UserType.Project_Specialists);
			try {
				userService.saveProjectUser(user,lsp);
				sendNoticeWhenRedirect(redirectAttr, "common.add.success");
			} catch (UserInfoSendCASFaildException e) {
				sendErrorMessageWhenRedirect(redirectAttr, "user.cas.sendError");
				logger.error(e.getMessage());
			}
		}
		return "redirect:/learnproject/"+lpid+"/learnsubproject";
	}
	
}
