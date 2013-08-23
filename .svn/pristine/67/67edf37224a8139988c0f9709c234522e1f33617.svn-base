/*
 * Copyright 2010. 
 * 
 * This document may not be reproduced, distributed or used 
 * in any manner whatsoever without the expressed written 
 * permission of Boventech Corp. 
 * 
 * $Rev: Rev $
 * $Author: Author $
 * $LastChangedDate: LastChangedDate $
 *
 */

package com.boventech.gplearn.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.boventech.gplearn.annotation.RequiredPrivilege;
import com.boventech.gplearn.entity.Announcement;
import com.boventech.gplearn.entity.Constants;
import com.boventech.gplearn.entity.Privilege;
import com.boventech.gplearn.entity.User;
import com.boventech.gplearn.service.AnnouncementService;

@Controller
@RequestMapping(value = "/announcement")
public class AnnouncementController extends ApplicationController {

	@Autowired
	private AnnouncementService announcementService;
	
	@RequiredPrivilege(value={Privilege.PROJECT_ANNOUNCEMENT,Privilege.PROVINCE_ANNOUNCEMENT,
			Privilege.SCHOOL_ANNOUNCEMENT,Privilege.SUBJECT_ANNOUNCEMENT,
			Privilege.TEACHER_ANNOUNCEMENT,Privilege.SYSTEM_ANNOUNCEMENT})
	@RequestMapping
	public String index(HttpServletRequest request,Integer page,Model model){
		User user = (User)request.getSession().getAttribute("currentUser");
		List<Announcement> announcementList = announcementService.listAllWithPagination(user,page);
		model.addAttribute("announcementList", announcementList);
		return "role/"+backFolderNameByUserType(user.getUserType())+"/listpublishgg";
	}
	
	@RequiredPrivilege(value={Privilege.PROJECT_ANNOUNCEMENT,Privilege.PROVINCE_ANNOUNCEMENT,
							Privilege.SCHOOL_ANNOUNCEMENT,Privilege.SUBJECT_ANNOUNCEMENT,
							Privilege.TEACHER_ANNOUNCEMENT,Privilege.SYSTEM_ANNOUNCEMENT})	
	@RequestMapping(value = "/new", method = RequestMethod.GET)
	public String editNew(ModelMap model,HttpServletRequest request) {
		User user = (User)request.getSession().getAttribute("currentUser");
		return "role/"+backFolderNameByUserType(user.getUserType())+"/publishgg";
	}
   
	@RequestMapping(method = RequestMethod.POST)
	public String create(Model model, Announcement announcement,HttpServletRequest request,
			@RequestParam(value = "file", required = false) MultipartFile file,final RedirectAttributes redirectAttrs) {
		User user = (User)request.getSession().getAttribute("currentUser");
		String path = request.getSession().getServletContext()
				.getRealPath("upload");
		String fileName = file.getOriginalFilename();
		Long size=file.getSize();
		if((size/1024/1024)>20){
			sendErrorMessageWhenRedirect(redirectAttrs,"upload.size.outofrange");
		}
		String saveFileName=null;
		if (!"".equals(fileName)) {
			Integer prefix=fileName.lastIndexOf(Constants.POINT);
			String suffix=fileName.substring(prefix==-1?0:prefix,fileName.length());
			fileName=personInchargeLoginNamePrefix()+suffix;
			saveFileName=fileName;
			File targetFile = new File(path, fileName);
			if (!targetFile.exists()) {
				targetFile.mkdirs();
			}
			try {
				file.transferTo(targetFile);
			} catch (IOException e) {
				sendErrorMessageWhenRedirect(redirectAttrs,
						"announcement.add.faild");
			}
		}
		this.announcementService.saveAnnouncement(saveFileName,user,announcement);
		sendNoticeWhenRedirect(redirectAttrs, "common.add.success");
		return "redirect:/announcement";
	}

	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public String show(Model model, @PathVariable String id,HttpServletRequest request) {
		User user = (User)request.getSession().getAttribute("currentUser");
		Announcement announcement = this.announcementService.findById(Long
				.parseLong(id));
		model.addAttribute("announcement", announcement);
		if(null!=user){
			return "role/"+backFolderNameByUserType(user.getUserType())+"/showgg";
		}
		else{
			return "common/main";
		}
	}

	@RequiredPrivilege(value={Privilege.PROJECT_ANNOUNCEMENT,Privilege.PROVINCE_ANNOUNCEMENT,
			Privilege.SCHOOL_ANNOUNCEMENT,Privilege.SUBJECT_ANNOUNCEMENT,
			Privilege.TEACHER_ANNOUNCEMENT,Privilege.SYSTEM_ANNOUNCEMENT})	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public String destroy(Model model, @PathVariable String id,
			final RedirectAttributes redirectAttrs,HttpServletRequest request) {
		this.announcementService.delete(Long.parseLong(id));
		sendNoticeWhenRedirect(redirectAttrs, "common.destroy.success");
		return "redirect:/announcement";
	}

}
