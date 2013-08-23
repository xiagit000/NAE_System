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

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.boventech.gplearn.annotation.RequiredPrivilege;
import com.boventech.gplearn.entity.Batch;
import com.boventech.gplearn.entity.Privilege;
import com.boventech.gplearn.service.BatchService;

@Controller
@RequestMapping(value = "/batch")
public class BatchController extends ApplicationController {
    
    private Logger logger = Logger.getLogger(this.getClass().getName());

    @Autowired
    private BatchService batchService;

    @RequiredPrivilege(value={Privilege.SYSTEM_BATCH})
    @RequestMapping(method = RequestMethod.GET)
    public String index(ModelMap model,HttpServletRequest request) {
    	setSiteBarActive("jc", "batch", request);
        List<Batch> batchs = batchService.listAll();
        model.addAttribute("batchs", batchs);
        return "/batch/index";
    }

    @RequiredPrivilege(value={Privilege.SYSTEM_BATCH})
    @RequestMapping(method = RequestMethod.POST)
    public String create(Model model, Batch batch, final RedirectAttributes redirectAttrs) {
        if (batchService.isExistByCode(batch.getCode())) {
            sendErrorMessageWithParameter(model, "common.name.exsit", batch.getCode());
            model.addAttribute("batch", batch);
            return "batch/add";
        }
        if (compareDate(batch) || batchService.isDateConflict(batch)) {
            sendErrorMessage(model, "batch.date.error");
            model.addAttribute("batch", batch);
            return "batch/add";
        }
        batchService.save(batch);
        sendNoticeWhenRedirect(redirectAttrs, "common.add.success");
        return "redirect:/batch";
    }

    @RequiredPrivilege(value={Privilege.SYSTEM_BATCH})
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public String update(Model model, Batch batch, final RedirectAttributes redirectAttrs,
            @PathVariable String id) {
        if (batchService.isExistByCodeWithoutCurrent(batch)) {
            sendErrorMessageWithParameter(model, "common.name.exsit", batch.getCode());
            model.addAttribute("batch", this.batchService.findById(Long.parseLong(id)));
            return "batch/edit";
        }
        if (compareDate(batch) || batchService.isDateConflictWithoutCurrent(batch)) {
            sendErrorMessage(model, "batch.date.error");
            model.addAttribute("batch", this.batchService.findById(Long.parseLong(id)));
            return "batch/edit";
        }
        this.batchService.update(batch);
        sendNoticeWhenRedirect(redirectAttrs, "common.update.success");
        return "redirect:/batch";
    }

    @RequiredPrivilege(value={Privilege.SYSTEM_BATCH})
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public String destroy(Model model, @PathVariable String id, final RedirectAttributes redirectAttrs) {
        if (isBatchNull(redirectAttrs, model, false, id)) {
            return "redirect:/batch";
        }
        try {
            this.batchService.delete(Long.parseLong(id));
            sendNoticeWhenRedirect(redirectAttrs, "common.destroy.success");
        } catch (RuntimeException e) {
            logger.error(e.getMessage());
            sendErrorMessageWhenRedirect(redirectAttrs, "common.hasnode.warn");
            return "redirect:/batch";
        }
        return "redirect:/batch";
    }

    @RequiredPrivilege(value={Privilege.SYSTEM_BATCH})
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String show(Model model, @PathVariable String id, final RedirectAttributes redirectAttrs) {
        if (isBatchNull(redirectAttrs, model, true, id)) {
            return "redirect:/batch";
        }
        return "/batch/show";
    }

    @RequiredPrivilege(value={Privilege.SYSTEM_BATCH})
    @RequestMapping(value = "/{id}/edit", method = RequestMethod.GET)
    public String edit(Model model, @PathVariable String id, final RedirectAttributes redirectAttrs) {
        if (isBatchNull(redirectAttrs, model, true, id)) {
            return "redirect:/batch";
        }
        return "/batch/edit";
    }

    @RequiredPrivilege(value={Privilege.SYSTEM_BATCH})
    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public String editNew(ModelMap model) {
        return "/batch/add";
    }

    private boolean isBatchNull(final RedirectAttributes redirectAttrs, Model model, boolean whithModel,
            String id) {
        Batch batch = this.batchService.findById(Long.parseLong(id));
        if (null == batch) {
            sendErrorMessageWithParameterWhenRedirect(redirectAttrs, "common.obj.notfound", "id:" + id);
            return true;
        } else {
            if (whithModel) {
                model.addAttribute("batch", batch);
            }
            return false;
        }
    }

    private boolean compareDate(Batch batch) {
        if (batch.getBeginTime().getTime() >= batch.getEndTime().getTime()) {
            return true;
        } else {
            return false;
        }
    }
}
