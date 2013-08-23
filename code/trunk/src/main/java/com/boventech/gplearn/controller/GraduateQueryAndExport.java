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

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.boventech.gplearn.annotation.RequiredPrivilege;
import com.boventech.gplearn.entity.Batch;
import com.boventech.gplearn.entity.GraduateStandard;
import com.boventech.gplearn.entity.Privilege;
import com.boventech.gplearn.service.BatchService;
import com.boventech.gplearn.service.GraduateService;
import com.boventech.gplearn.service.GraduateStandardService;
import com.boventech.gplearn.service.LearnClassService;
import com.boventech.gplearn.util.ExcelExporter;
import com.boventech.gplearn.util.GraduateFiller;
import com.google.common.collect.Lists;

@Controller
@RequestMapping(value = "graduatequeryandexport")
public class GraduateQueryAndExport extends ApplicationController {
    @Autowired
    private GraduateService graduateService;

    @Autowired
    private BatchService batchService;

    @Autowired
    private LearnClassService learnClassService;

    @Autowired
    private GraduateStandardService graduateStandardService;
    
    @RequiredPrivilege(value={Privilege.SYSTEM_GRADUATE})
    @RequestMapping(method = RequestMethod.GET)
    public String index(ModelMap model, HttpServletRequest request, Integer page) {
        setSiteBarActive("xw", "graduatequeryandexport", request);
        bundleInputData(model);
        return "graduatequeryandexport/index";
    }

    @RequiredPrivilege(value={Privilege.SYSTEM_GRADUATE})
    @RequestMapping(value = "/query", method = RequestMethod.GET)
    public String query(ModelMap model, HttpServletRequest request, Long batchId, Long learnClassId,
            Integer page) {
        bundleInputData(model);

        model.addAttribute("learnClassId", learnClassId);

        model.addAttribute("params", "batchId=" + batchId + "&learnClassId=" + learnClassId);
        model.addAttribute("graduates", this.graduateService.search(page, batchId, learnClassId));
        return "graduatequeryandexport/index";
    }

    private void bundleInputData(ModelMap model) {
        List<Batch> batchs = this.batchService.listAll();
        Batch currentBatch = this.batchService.getNowBatch();
        model.addAttribute("currentBatch", currentBatch);
        if (currentBatch != null) {
            GraduateStandard graduateStandard = this.graduateStandardService.getStandardByBatch(currentBatch);
            if (new Date().getTime() < graduateStandard.getGraduateTime().getTime()) {
                batchs.remove(currentBatch);
            }
        }
        model.addAttribute("batchs", batchs);
        model.addAttribute("learnClasses", this.learnClassService.listAll());
    }

    @RequiredPrivilege(value={Privilege.SYSTEM_GRADUATE})
    @RequestMapping(value = "/export", method = RequestMethod.GET)
    public void export(ModelMap model, HttpServletRequest request, HttpServletResponse response,
            Long batchId, Long learnClassId) {
        new ExcelExporter().exportXLS(response, getHeads(), getMessage("graduate_excelName"), "",
                new GraduateFiller(this.graduateService.search(batchId, learnClassId)));
    }

    private List<String> getHeads() {
        List<String> heads = Lists.newArrayList();
        heads.add(getMessage("graduate_id"));
        heads.add(getMessage("graduate_batch"));
        heads.add(getMessage("graduate_loginName"));
        heads.add(getMessage("graduate_name"));
        heads.add(getMessage("graduate_graduateStatus"));
        return heads;
    }
}
