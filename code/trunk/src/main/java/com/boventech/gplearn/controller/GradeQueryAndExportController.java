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

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.boventech.gplearn.annotation.RequiredPrivilege;
import com.boventech.gplearn.entity.Privilege;
import com.boventech.gplearn.service.BatchService;
import com.boventech.gplearn.service.GradeService;
import com.boventech.gplearn.service.LearnClassService;
import com.boventech.gplearn.util.ExcelExporter;
import com.boventech.gplearn.util.GradeFiller;

@Controller
@RequestMapping(value = "gradequeryandexport")
public class GradeQueryAndExportController extends ApplicationController {

    @Autowired
    private GradeService gradeService;

    @Autowired
    private BatchService batchService;

    @Autowired
    private LearnClassService learnClassService;

    @RequiredPrivilege(value={Privilege.SYSTEM_GRADE})
    @RequestMapping(method = RequestMethod.GET)
    public String index(ModelMap model, HttpServletRequest request, Integer page) {
        setSiteBarActive("xw", "gradequeryandexport", request);
        model.addAttribute("batchs", this.batchService.listAll());
        model.addAttribute("currentBatch", this.batchService.getNowBatch());
        model.addAttribute("learnClasses", this.learnClassService.listAll());
        return "gradequeryandexport/index";
    }

    @RequiredPrivilege(value={Privilege.SYSTEM_GRADE})
    @RequestMapping(value = "/query", method = RequestMethod.GET)
    public String query(ModelMap model, HttpServletRequest request, Long batchId,
             Long learnClassId,Integer page) {
        model.addAttribute("batchs", this.batchService.listAll());
        model.addAttribute("currentBatch", this.batchService.findById(batchId));
        model.addAttribute("learnClasses", this.learnClassService.listAll());

        model.addAttribute("learnClassId", learnClassId);

        model.addAttribute("params", "batchId=" + batchId + "&learnClassId=" + learnClassId);
        model.addAttribute("grades", this.gradeService.search(page,batchId,learnClassId));
        return "gradequeryandexport/index";
    }

    @RequiredPrivilege(value={Privilege.SYSTEM_GRADE})
    @RequestMapping(value = "/export", method = RequestMethod.GET)
    public void export(ModelMap model, HttpServletRequest request, HttpServletResponse response,
            Long batchId, Long learnClassId) {
        new ExcelExporter().exportXLS(response, getHeads(), getMessage("grade_excelName"), "",
                new GradeFiller(this.gradeService.search(batchId,learnClassId)));
    }

    private List<String> getHeads() {
        List<String> heads = new ArrayList<String>();
        heads.add(getMessage("grade_id"));
        heads.add(getMessage("grade_batch"));
        heads.add(getMessage("grade_loginName"));
        heads.add(getMessage("grade_name"));
        heads.add(getMessage("grade_learnVideoScore"));
        heads.add(getMessage("grade_learnThesisScore"));
        heads.add(getMessage("grade_learnDiscussScore"));
        heads.add(getMessage("grade_usuallyScore"));
        return heads;
    }
}
