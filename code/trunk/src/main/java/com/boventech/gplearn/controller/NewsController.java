package com.boventech.gplearn.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.boventech.gplearn.entity.Announcement;
import com.boventech.gplearn.service.AnnouncementService;

@Controller
@RequestMapping(value="/news")
public class NewsController extends ApplicationController {

	@Autowired
	private AnnouncementService announcementService;
	
	@RequestMapping
	public String listNewestAnnouncement(Model model,Integer page){
		List<Announcement> list =announcementService.listAllWithPagination(page);
		model.addAttribute("list", list);
		return "common/news/list";
	}
	
	@RequestMapping(value="/{id}")
	public String showAnnouncement(@PathVariable Long id,Model model){
		Announcement announcement = announcementService.findById(id);
		model.addAttribute("announcement", announcement);
		return "common/news/show";
	}
	
	@RequestMapping(value="/gp/{id}")
	public String showGPINFO(@PathVariable Long id){
		return "common/news/example/gp"+id;
	}
	
	@RequestMapping(value="question/{id}")
	public String showQuestionInfo(@PathVariable Long id){
		return "common/news/example/question"+id;
	}
}
