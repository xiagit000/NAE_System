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

import sun.misc.BASE64Encoder;

import com.boventech.gplearn.annotation.RequiredPrivilege;
import com.boventech.gplearn.entity.City;
import com.boventech.gplearn.entity.LearnArea;
import com.boventech.gplearn.entity.Privilege;
import com.boventech.gplearn.entity.User;
import com.boventech.gplearn.entity.User.UserType;
import com.boventech.gplearn.exception.UserInfoSendCASFaildException;
import com.boventech.gplearn.service.CityService;
import com.boventech.gplearn.service.LearnAreaService;
import com.boventech.gplearn.service.UserService;

@Controller
@RequestMapping(value="/city/{cityId}/personincharge")
public class LearnAreaPersonInChargeController extends ApplicationController {

	private static final Logger logger = LoggerFactory.getLogger(LearnAreaPersonInChargeController.class);
	
	@Autowired
	private LearnAreaService learnAreaService;
	
	@Autowired
	private CityService cityService;
	
	@Autowired 
	private UserService userService;
	
	@RequiredPrivilege(value={Privilege.SYSTEM_LEARNAREA})
	@RequestMapping()
	public String show(Model model,@PathVariable Long cityId,RedirectAttributes redirectAttr){
		City city = cityService.findById(cityId);
		if(checkEntityEmpty(city)){
			return "error/404";
		}
		List<LearnArea> list = learnAreaService.listWithProvinceCity(city);
		if(!list.isEmpty()){
			User user = list.get(0).getUser();
			if(null !=user){
				model.addAttribute("user",user);
				model.addAttribute("city",city);
				return "learnArea/personincharge/show";
			}
		}
		sendWarningWhenRedirect(redirectAttr, "province.personincharge.notfound");
		return "redirect:/learnArea/showexsitprovice";
		
	}
	
	@RequiredPrivilege(value={Privilege.SYSTEM_LEARNAREA})
	@RequestMapping(value="/create")
	public String create(@PathVariable Long cityId,Model model){
		City city =cityService.findById(cityId);
		if(checkEntityEmpty(city)){
			return "error/404";
		}
		model.addAttribute("city", city);
		model.addAttribute("prefix",personInchargeLoginNamePrefix());
		return "learnArea/personincharge/create";
	}
	
	@RequiredPrivilege(value={Privilege.SYSTEM_LEARNAREA})
	@RequestMapping(method=RequestMethod.POST)
	public String save(User user,String prefix,@PathVariable Long cityId,RedirectAttributes redirect){
		City city = cityService.findById(cityId);
		if(checkEntityEmpty(city)){
			return "error/404";
		}
		
		List<LearnArea> areas=learnAreaService.listWithProvinceCity(city);
		user.setLoginName(prefix);
		user.setActive(true);
		user.setUserType(UserType.Province_Supervisor);
		user.setPassword(new BASE64Encoder().encode(user.getPassword().getBytes()));
		try {
			userService.saveProvinceUser(areas,user);
			sendNoticeWhenRedirect(redirect, "common.add.success");
		} catch (UserInfoSendCASFaildException e) {
			logger.error(e.getMessage());
			sendErrorMessageWhenRedirect(redirect, "user.cas.sendError");
		}
		return "redirect:/learnArea/showexsitprovice";
	}
}
