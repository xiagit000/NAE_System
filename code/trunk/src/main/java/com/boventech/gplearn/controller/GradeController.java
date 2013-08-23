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

import java.util.List;

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
import com.boventech.gplearn.entity.Grade;
import com.boventech.gplearn.entity.GraduateStandard;
import com.boventech.gplearn.entity.LearnClass;
import com.boventech.gplearn.entity.Privilege;
import com.boventech.gplearn.entity.SchoolRoll;
import com.boventech.gplearn.entity.User;
import com.boventech.gplearn.service.BatchService;
import com.boventech.gplearn.service.GradeService;
import com.boventech.gplearn.service.GraduateStandardService;
import com.boventech.gplearn.service.LearnClassService;
import com.boventech.gplearn.service.SchoolRollService;
import com.google.common.collect.Lists;


@Controller
@RequestMapping(value = "/grade")
public class GradeController extends ApplicationController {

    @Autowired
    private GradeService gradeService;
    
    @Autowired
    private GraduateStandardService graduateStandardService;
    
    @Autowired
    private BatchService batchService;
    
    @Autowired
    private LearnClassService learnClassService;

    @Autowired
    private SchoolRollService schoolRollService;
    
    @RequiredPrivilege(value={Privilege.SYSTEM_GRADE})
    @RequestMapping(method = RequestMethod.GET)
    public String index(ModelMap model,HttpServletRequest request, Integer page) {
    	setSiteBarActive("xw","grade", request);
        model.addAttribute("grades", this.gradeService.listAllWithPagnate(page));
        return "grade/index";
    }
    
    @RequiredPrivilege(value={Privilege.STUDENT_SCORE_SEARCH})
    @RequestMapping(value="/show")
    public String show(Model model,HttpServletRequest request){
    	User user = (User)request.getSession().getAttribute("currentUser");
    	Grade grade = gradeService.findByUser(user);
    	GraduateStandard graduateStandard = graduateStandardService.getCurrentBatchGraduateStandard(batchService.getCurrentBatch());
    	if(!checkEntityEmpty(graduateStandard)){
    		model.addAttribute("graduateStandard", graduateStandard);
    	}
    	model.addAttribute("grade", grade);
    	return "role/student/gradeinfo";
    }
    

	@RequiredPrivilege(value={Privilege.TEACHER_NORMAL_SCORE})
	@RequestMapping(value="/students")
	public String setStudentNorMalScore(HttpServletRequest request,Integer page,Model model){
		User teacher = (User)request.getSession().getAttribute("currentUser");
		LearnClass learnClass = learnClassService.findByTeacher(teacher);
		List<SchoolRoll> classMate = schoolRollService.listActiveByClassWithPagination(learnClass,page);
		List<Grade> grades=Lists.newArrayList();
		for(SchoolRoll schoolRoll : classMate){
			grades.add(gradeService.findByUser(schoolRoll.getUser()));
		}
		model.addAttribute("classMate", classMate);
		model.addAttribute("grades", grades);
		return "role/teacher/listclassmembers";
	}
	
	@RequiredPrivilege(value={Privilege.TEACHER_NORMAL_SCORE})
	@RequestMapping(value="/{id}/updateusually")
	public String editusually(@PathVariable Long id,Model model){
		Grade grade = gradeService.findById(id);
		if(checkEntityEmpty(grade)){
			return "error/404";
		}
		model.addAttribute("grade", grade);
		return "role/teacher/updategrade";
	}
	
	@RequiredPrivilege(value={Privilege.TEACHER_NORMAL_SCORE})
	@RequestMapping(value="/{id}/updateusually",method=RequestMethod.POST)
	public String updateusually(@PathVariable Long id,Double usuallyScore,RedirectAttributes redirectAttr){
		Grade grade = gradeService.findById(id);
		if(checkEntityEmpty(grade)){
			return "error/404";
		}
		if(usuallyScore>(grade.getScoringStandard().getUsuallyProportion()*100)){
			usuallyScore=grade.getScoringStandard().getUsuallyProportion()*100;
		}
		grade.setUsuallyScore(usuallyScore);
		gradeService.update(grade);
		sendNoticeWhenRedirect(redirectAttr, "common.update.success");
		return "redirect:/grade/students";
	}

}
