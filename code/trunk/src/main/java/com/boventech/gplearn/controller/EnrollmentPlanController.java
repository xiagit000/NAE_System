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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.boventech.gplearn.annotation.RequiredPrivilege;
import com.boventech.gplearn.entity.EnrollmentPlan;
import com.boventech.gplearn.entity.Privilege;
import com.boventech.gplearn.service.BatchService;
import com.boventech.gplearn.service.EnrollmentPlanService;
import com.boventech.gplearn.service.LearnClassService;

@Controller
@RequestMapping(value = "/enrollmentplan")
public class EnrollmentPlanController extends ApplicationController {

    @Autowired
    private EnrollmentPlanService enrollmentPlanService;

    @Autowired
    private BatchService batchService;

    @Autowired
    private LearnClassService learnClassService;

    @RequiredPrivilege(value={Privilege.SYSTEM_ENROLLMENTPLAN})
    @RequestMapping(method = RequestMethod.GET)
    public String index(Model model,HttpServletRequest request,Integer page) {
    	setSiteBarActive("zs", "enrollmentplan", request);
        List<EnrollmentPlan> enrollmentPlans = this.enrollmentPlanService.listWithPagination(page);
        model.addAttribute("enrollmentPlans", enrollmentPlans);
        return "enrollmentPlan/index";
    }

    @RequiredPrivilege(value={Privilege.SYSTEM_ENROLLMENTPLAN})
    @RequestMapping(method = RequestMethod.POST)
    public String create(Model model, final RedirectAttributes redirectAttrs, EnrollmentPlan enrollmentPlan,
            String batchId, String classId) {

        enrollmentPlan.setBatch(this.batchService.findById(Long.parseLong(batchId)));
        enrollmentPlan.setLearnClass(this.learnClassService.findById(Long.parseLong(classId)));

        if (this.enrollmentPlanService.isExistByBatchAndClass(enrollmentPlan)) {
            sendErrorMessageWithParameter(model, "common.name.exsit", enrollmentPlan.getBatch().getName()
                    + "-" + enrollmentPlan.getLearnClass().getName());
            model.addAttribute("enrollmentPlan", enrollmentPlan);
            model.addAttribute("batchs", this.batchService.listAll());
            model.addAttribute("classes", this.learnClassService.listEnable());
            return "enrollmentPlan/add";
        }
        if (compareDate(enrollmentPlan) || this.enrollmentPlanService.isConflictByDate(enrollmentPlan)) {
            sendErrorMessage(model, "enrollmentPlan.date.error");
            model.addAttribute("enrollmentPlan", enrollmentPlan);
            model.addAttribute("batchs", this.batchService.listAll());
            model.addAttribute("classes", this.learnClassService.listEnable());
            return "enrollmentPlan/add";
        }
        this.enrollmentPlanService.save(enrollmentPlan);
        sendNoticeWhenRedirect(redirectAttrs, "common.add.success");
        return "redirect:/enrollmentplan";
    }

    @RequiredPrivilege(value={Privilege.SYSTEM_ENROLLMENTPLAN})
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public String update(Model model, @PathVariable Long id, final RedirectAttributes redirectAttrs,
            EnrollmentPlan enrollmentPlan, String batchId, String classId) {
        enrollmentPlan.setBatch(this.batchService.findById(Long.parseLong(batchId)));
        enrollmentPlan.setLearnClass(this.learnClassService.findById(Long.parseLong(classId)));

        if (this.enrollmentPlanService.isExistByBatchAndClassWithoutCurrent(enrollmentPlan)) {
            sendErrorMessageWithParameter(model, "common.name.exsit", enrollmentPlan.getBatch().getName()
                    + "-" + enrollmentPlan.getLearnClass().getName());
            model.addAttribute("enrollmentPlan", enrollmentPlan);
            model.addAttribute("batchs", this.batchService.listAll());
            model.addAttribute("classes", this.learnClassService.listEnable());
            return "enrollmentPlan/edit";
        }
        if (compareDate(enrollmentPlan) || this.enrollmentPlanService.isConflictByDate(enrollmentPlan)) {
            sendErrorMessage(model, "enrollmentPlan.date.error");
            model.addAttribute("enrollmentPlan", this.enrollmentPlanService.findById(id));
            model.addAttribute("batchs", this.batchService.listAll());
            model.addAttribute("classes", this.learnClassService.listEnable());
            return "enrollmentPlan/edit";
        }

        EnrollmentPlan oldEnrollmentPlan = enrollmentPlanService.findById(id);
        enrollmentPlan.setExistedUserNumber(oldEnrollmentPlan.getExistedUserNumber());
        this.enrollmentPlanService.update(enrollmentPlan);
        sendNoticeWhenRedirect(redirectAttrs, "common.update.success");
        return "redirect:/enrollmentplan";
    }

    @RequiredPrivilege(value={Privilege.SYSTEM_ENROLLMENTPLAN})
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public String destroy(Model model, @PathVariable String id, final RedirectAttributes redirectAttrs) {
        if (isNull(redirectAttrs, model, false, id)) {
            return "redirect:/enrollmentplan";
        }
        try {
            this.enrollmentPlanService.delete(Long.parseLong(id));
            sendNoticeWhenRedirect(redirectAttrs, "common.destroy.success");
        } catch (RuntimeException e) {
            e.printStackTrace();
            sendErrorMessageWhenRedirect(redirectAttrs, "learnproject.hasnode");
            return "redirect:/enrollmentplan";
        }
        return "redirect:/enrollmentplan";
    }

    @RequiredPrivilege(value={Privilege.SYSTEM_ENROLLMENTPLAN})
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String show(Model model, @PathVariable String id, final RedirectAttributes redirectAttrs) {
        if (isNull(redirectAttrs, model, true, id)) {
            sendErrorMessageWithParameterWhenRedirect(redirectAttrs, "common.object.notfound", "id:" + id);
            return "redirect:/enrollmentplan";
        }
        return "enrollmentPlan/show";
    }

    @RequiredPrivilege(value={Privilege.SYSTEM_ENROLLMENTPLAN})
    @RequestMapping(value = "/{id}/edit", method = RequestMethod.GET)
    public String edit(Model model, @PathVariable String id, final RedirectAttributes redirectAttrs) {
        if (isNull(redirectAttrs, model, true, id)) {
            return "redirect:/batch";
        }
        return "enrollmentPlan/edit";
    }

    @RequiredPrivilege(value={Privilege.SYSTEM_ENROLLMENTPLAN})
    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public String editNew(Model model, final RedirectAttributes redirectAttrs) {
        if (!this.batchService.checkExist()) {
            sendErrorMessageWhenRedirect(redirectAttrs, "enrollmentPlan.batch.list.empty");
            return "redirect:/batch";
        }
        if (!this.learnClassService.checkExist()) {
            sendErrorMessageWhenRedirect(redirectAttrs, "enrollmentPlan.learnClass.list.empty");
            return "redirect:/learnclass";
        }
        model.addAttribute("batchs", this.batchService.listAll());
        model.addAttribute("classes", this.learnClassService.listEnable());
        return "enrollmentPlan/add";
    }

    private boolean isNull(final RedirectAttributes redirectAttrs, Model model, boolean whithModel, String id) {
        EnrollmentPlan enrollmentPlan = this.enrollmentPlanService.findById(Long.parseLong(id));
        if (null == enrollmentPlan) {
            sendErrorMessageWithParameterWhenRedirect(redirectAttrs, "common.object.notfound", "id:" + id);
            return true;
        } else {
            if (whithModel) {
                model.addAttribute("enrollmentPlan", enrollmentPlan);
                model.addAttribute("batchs", this.batchService.listAll());
                model.addAttribute("classes", this.learnClassService.listEnable());
            }
            return false;
        }
    }

    private boolean compareDate(EnrollmentPlan enrollmentPlan) {
        return enrollmentPlan.getBeginTime().getTime() >= enrollmentPlan.getEndTime().getTime();
    }

}
