package com.boventech.gplearn.controller;

import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.boventech.gplearn.annotation.RequiredPrivilege;
import com.boventech.gplearn.entity.Privilege;
import com.boventech.gplearn.entity.SenderNotification;
import com.boventech.gplearn.entity.User;
import com.boventech.gplearn.service.SenderNotificationService;
import com.boventech.gplearn.service.UserService;
import com.google.common.base.Strings;
import com.google.common.collect.Sets;

@Controller
@RequestMapping(value = "/mail/sender")
public class SenderNotificationController extends ApplicationController {

	@Autowired
	private SenderNotificationService senderNotificationService;

	@Autowired
	private UserService userService;

	@RequestMapping(method = RequestMethod.GET)
	public String index(Model model, HttpServletRequest request, Integer page) {
		User user = (User) request.getSession().getAttribute("currentUser");
		List<SenderNotification> senderNotifications = this.senderNotificationService
				.listAllNotificationByUser(user, page);
		model.addAttribute("senderNotifications", senderNotifications);
		return "common/mailsender";
	}

	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	public String show(Model model, HttpServletRequest request,
			@PathVariable String id) {
		SenderNotification senderNotification = this.senderNotificationService
				.findById(Long.parseLong(id));
		model.addAttribute("mail", senderNotification);
		return "common/showmail";
	}

	@RequiredPrivilege(value={Privilege.SYSTEM_ACCOUNT,Privilege.PROJECT_USER_ACCOUNT,Privilege.PROVINCE_USER_ACCOUNT
			,Privilege.SCHOOL_USER_ACCOUNT,Privilege.STUDENT_USER_ACCOUNT,Privilege.SUBJECT_USER_ACCOUNT,
			Privilege.TEACHER_USER_ACCOUNT})
	@RequestMapping(value = "/new", method = RequestMethod.GET)
	public String editNew(ModelMap model) {
		return "common/newmail";
	}

	@RequiredPrivilege(value={Privilege.SYSTEM_ACCOUNT,Privilege.PROJECT_USER_ACCOUNT,Privilege.PROVINCE_USER_ACCOUNT
			,Privilege.SCHOOL_USER_ACCOUNT,Privilege.STUDENT_USER_ACCOUNT,Privilege.SUBJECT_USER_ACCOUNT,
			Privilege.TEACHER_USER_ACCOUNT})
	@RequestMapping(method = RequestMethod.POST)
	public String create(Model model, HttpServletRequest request, Integer page,
			SenderNotification senderNotification, String receiver, String ids,
			final RedirectAttributes redirectAttrs) {
		User user = (User) request.getSession().getAttribute("currentUser");
		if (Strings.isNullOrEmpty(receiver) || user == null) {
			sendErrorMessage(model, "notification.send.faild");
			return "common/newmail";
		}
		if (!Strings.isNullOrEmpty(receiver) && Strings.isNullOrEmpty(ids)) {
			if (!checkLoginName(receiver)) {
				sendErrorMessage(model, "notification.send.faild");
				return "common/newmail";
			}
			setSenderNotificationByLoginName(user, senderNotification, receiver);
		} else {
			setSenderNotificationByUserId(user, senderNotification, ids);
		}
		this.senderNotificationService.sendNotification(senderNotification);
		sendNoticeWhenRedirect(redirectAttrs, "notification.send.success");
		return "redirect:/mail/sender";
	}

	@RequiredPrivilege(value={Privilege.SYSTEM_ACCOUNT,Privilege.PROJECT_USER_ACCOUNT,Privilege.PROVINCE_USER_ACCOUNT
			,Privilege.SCHOOL_USER_ACCOUNT,Privilege.STUDENT_USER_ACCOUNT,Privilege.SUBJECT_USER_ACCOUNT,
			Privilege.TEACHER_USER_ACCOUNT})
	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	public String destory(Model model, HttpServletRequest request,
			@PathVariable String id, final RedirectAttributes redirectAttrs) {
		this.senderNotificationService.delete(Long.parseLong(id));
		sendNoticeWhenRedirect(redirectAttrs, "common.destroy.success");
		return "redirect:/mail/sender";
	}

	@RequestMapping(value = "{id}/edit", method = RequestMethod.GET)
	public String edit(Model model, HttpServletRequest request,
			@PathVariable String id) {
		SenderNotification senderNotification = this.senderNotificationService
				.findById(Long.parseLong(id));
		model.addAttribute("senderNotification", senderNotification);
		return "/notification/sendernotification/edit";
	}

	private void setSenderNotificationByLoginName(User user,
			SenderNotification senderNotification, String loginNames) {
		senderNotification.setSender(user);
		senderNotification.setTime(new Date());

		Set<User> receivers = Sets.newHashSet();
		String[] namesArray = loginNames.split(";");
		for (String loginName : namesArray) {
			User receiver = this.userService.findByLoginName(loginName);
			receivers.add(receiver);
		}
		senderNotification.setReceivers(receivers);
	}

	private void setSenderNotificationByUserId(User user,
			SenderNotification senderNotification, String ids) {
		senderNotification.setSender(user);
		senderNotification.setTime(new Date());

		Set<User> receivers = Sets.newHashSet();
		String[] idsArray = ids.split(";");
		for (String id : idsArray) {
			User receiver = this.userService.findById(Long.parseLong(id));
			receivers.add(receiver);
		}
		senderNotification.setReceivers(receivers);
	}

	private boolean checkLoginName(String loginNames) {
		String[] namesArray = loginNames.split(";");
		for (String loginName : namesArray) {
			if (!this.userService.checkEntityExsitByLoginName(loginName)) {
				return false;
			}
		}
		return true;
	}
}
