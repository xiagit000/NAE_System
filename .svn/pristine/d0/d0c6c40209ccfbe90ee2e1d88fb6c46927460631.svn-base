package com.boventech.gplearn.controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.boventech.gplearn.annotation.RequiredPrivilege;
import com.boventech.gplearn.entity.LearnLevel;
import com.boventech.gplearn.entity.Privilege;
import com.boventech.gplearn.service.DisciplineService;
import com.boventech.gplearn.service.LearnLevelService;

@Controller
@RequestMapping(value = "/learnlevel")
public class LearnLevelController extends ApplicationController {

	@Autowired
	private LearnLevelService learnLevelService;

	@Autowired
	private DisciplineService disciplineService;

	/**
	 * List
	 * 
	 * @param model
	 * @return
	 */
	@RequiredPrivilege(value={Privilege.SYSTEM_LEARNLEVEL})
	@RequestMapping(method = RequestMethod.GET)
	public String index(Model model, HttpServletRequest request) {
		setSiteBarActive("jc", "learnlevel", request);
		List<LearnLevel> list = learnLevelService.listAll();
		model.addAttribute("list", list);
		return "learnlevel/index";
	}

	/**
	 * Jump to create page
	 * 
	 * @return
	 */
	@RequestMapping(value = "/create")
	public String create() {
		return "learnlevel/create";
	}

	/**
	 * Save
	 */
	@RequiredPrivilege(value={Privilege.SYSTEM_LEARNLEVEL})
	@RequestMapping(method = RequestMethod.POST)
	public String save(LearnLevel learnLevel,
			final RedirectAttributes redirectAttrs, Model model) {
		// 判断learnLevel是否已经存在了，如果存在就返回错误消息
		if (learnLevelService.checkExsit(learnLevel.getName())) {
			sendErrorMessageWithParameter(model, "common.name.exsit",
					learnLevel.getName());
			model.addAttribute("learnLevel", learnLevel);
			return "learnlevel/create";
		}
		learnLevelService.save(learnLevel);
		sendNoticeWhenRedirect(redirectAttrs, "common.add.success");
		return "redirect:/learnlevel";
	}

	/**
	 * Set LearnLevel Disabled
	 * 
	 * @return
	 */
	@RequiredPrivilege(value={Privilege.SYSTEM_LEARNLEVEL})
	@RequestMapping(value = "/{id}/disabled")
	public String disabled(@PathVariable Long id,
			final RedirectAttributes redirectAttrs) {
		LearnLevel learnLevel = learnLevelService.findById(id);
		// 检查被禁用的培训层次有没有数据库记录，如果没有，发送错误消息
		if (null == learnLevel) {
			sendErrorMessageWithParameterWhenRedirect(redirectAttrs,
					"common.obj.notfound", "Id:" + id);
			return "redirect:/learnlevel";
		}
		// 查找是否有使用这个培训层次组合出来的学科记录
		if (disciplineService.checkExsitByLearnLevelId(learnLevel.getId())) {
			sendErrorMessageWithParameterWhenRedirect(redirectAttrs,
					"common.rederence.disabled.faild", learnLevel.getName());
			return "redirect:/learnlevel";
		}

		// 禁用培训层次
		learnLevel.setActive(false);
		learnLevelService.update(learnLevel);

		// 禁用成功
		sendNoticeWithParameterWhenRedirect(redirectAttrs,
				"common.status.disabled.success", learnLevel.getName());
		return "redirect:/learnlevel";
	}

	/**
	 * Set LearnLevel Enabled
	 * 
	 * @param id
	 * @param redirectAttrs
	 * @return
	 */
	@RequiredPrivilege(value={Privilege.SYSTEM_LEARNLEVEL})
	@RequestMapping(value = "/{id}/enabled")
	public String enabled(@PathVariable Long id,
			final RedirectAttributes redirectAttrs, Model model) {
		LearnLevel learnLevel = learnLevelService.findById(id);
		// 检查被禁用的培训层次有没有数据库记录，如果没有，发送错误消息
		if (null == learnLevel) {
			sendErrorMessageWithParameterWhenRedirect(redirectAttrs,
					"common.obj.notfound", "Id:" + id);
			return "redirect:/learnlevel";
		}
		// 启用这个培训层次
		learnLevel.setActive(true);
		learnLevelService.update(learnLevel);

		// 启用成功
		sendNoticeWithParameterWhenRedirect(redirectAttrs,
				"common.status.active.success", learnLevel.getName());
		return "redirect:/learnlevel";
	}

	/**
	 * Destroy LearnLevel By ID
	 * 
	 * @param id
	 * @param redirectAttrs
	 * @return
	 */
	@RequiredPrivilege(value={Privilege.SYSTEM_LEARNLEVEL})
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public String destroy(@PathVariable Long id,
			final RedirectAttributes redirectAttrs) {
		LearnLevel learnLevel = learnLevelService.findById(id);
		if (null == learnLevel) {
			sendErrorMessageWithParameterWhenRedirect(redirectAttrs,
					"common.obj.notfound", "Id:" + id);
			return "redirect:/learnlevel";
		}
		try {
			learnLevelService.delete(id);
			sendNoticeWhenRedirect(redirectAttrs, "common.destroy.success");
		} catch (RuntimeException e) {
			sendErrorMessageWithParameterWhenRedirect(redirectAttrs,
					"common.reference.delete", learnLevel.getName());
		}
		return "redirect:/learnlevel";
	}

	/**
	 * Jump to edit Page
	 * 
	 * @param id
	 * @param model
	 * @return
	 */
	@RequiredPrivilege(value={Privilege.SYSTEM_LEARNLEVEL})
	@RequestMapping(value = "/{id}/update")
	public String edit(@PathVariable Long id, Model model,
			RedirectAttributes redirectAttrs) {
		LearnLevel learnLevel = learnLevelService.findById(id);
		if (null == learnLevel) {
			sendErrorMessageWithParameterWhenRedirect(redirectAttrs,
					"common.obj.notfound", "Id:" + id);
			return "redirect:/learnlevel";
		}
		model.addAttribute("learnLevel", learnLevel);
		return "learnlevel/update";
	}

	/**
	 * Update LearnLevel By Id
	 * 
	 * @param learnLevel
	 * @param redirectAttrs
	 * @return
	 */
	@RequiredPrivilege(value={Privilege.SYSTEM_LEARNLEVEL})
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public String update(LearnLevel learnLevel,
			final RedirectAttributes redirectAttrs, Model model) {
		// 判断learnLevel是否已经存在了，如果存在就返回错误消息
		if (learnLevelService.checkExsitWithOutCurrent(learnLevel)) {
			sendErrorMessageWithParameter(model, "common.name.exsit",
					learnLevel.getName());
			model.addAttribute("learnLevel", learnLevel);
			return "learnlevel/update";
		}
		learnLevelService.update(learnLevel);
		sendNoticeWhenRedirect(redirectAttrs, "common.update.success");
		return "redirect:/learnlevel";
	}
}
