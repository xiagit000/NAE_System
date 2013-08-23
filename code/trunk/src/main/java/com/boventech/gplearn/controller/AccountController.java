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

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.boventech.gplearn.annotation.RequiredPrivilege;
import com.boventech.gplearn.entity.Account;
import com.boventech.gplearn.entity.EnrollmentPlan;
import com.boventech.gplearn.entity.Privilege;
import com.boventech.gplearn.exception.StudySpaceCreateFaildException;
import com.boventech.gplearn.exception.UserInfoPushToStudySpaceClassRoomFaildException;
import com.boventech.gplearn.exception.UserInfoPushToStudySpaceFaildException;
import com.boventech.gplearn.exception.UserInfoSendCASFaildException;
import com.boventech.gplearn.service.AccountService;
import com.boventech.gplearn.service.EnrollmentPlanService;
import com.boventech.gplearn.service.GraduateStandardService;
import com.boventech.gplearn.service.ScoringStandardService;
import com.boventech.gplearn.service.UserService;
import com.boventech.gplearn.util.FileSender;

@Controller
@RequestMapping(value = "/account")
public class AccountController extends ApplicationController {

    private Logger logger = Logger.getLogger(this.getClass().getName());

    @Autowired
    private AccountService accountService;

    @Autowired
    private EnrollmentPlanService enrollmentPlanService;

    @Autowired
    private UserService userService;

    @Autowired
    private ScoringStandardService scoringStandardService;

    @Autowired
    private GraduateStandardService graduateStandardService;

    @RequiredPrivilege(value = { Privilege.SYSTEM_ACCOUNT })
    @RequestMapping(method = RequestMethod.GET)
    public String index(Model model, HttpServletRequest request,Integer page) {
        setSiteBarActive("zs", "account", request);
        model.addAttribute("accounts", this.accountService.listWithPagination(page));
        return "account/index";
    }

    @RequiredPrivilege(value = { Privilege.SYSTEM_ACCOUNT })
    @RequestMapping(method = RequestMethod.POST)
    public String create(Model model, final RedirectAttributes redirectAttrs, Account account) {
        if (this.accountService.isExistByIdNumber(account.getIdNumber())) {
            sendErrorMessageWithParameter(model, "common.name.exsit", account.getIdNumber());
            model.addAttribute("account", account);
            return "account/add";
        }
        this.accountService.save(account);
        sendNoticeWhenRedirect(redirectAttrs, "common.add.success");
        return "redirect:/account";
    }

    @RequiredPrivilege(value = { Privilege.SYSTEM_ACCOUNT })
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public String update(Model model, final RedirectAttributes redirectAttrs, @PathVariable String id,
            Account account) {
        if (this.accountService.isExistByIdNumberWithoutCurrent(account)) {
            sendErrorMessageWithParameter(model, "common.name.exsit", account.getIdNumber());
            model.addAttribute("account", account);
            return "account/edit";
        }
        this.accountService.update(account);
        sendNoticeWhenRedirect(redirectAttrs, "common.update.success");
        return "redirect:/account";
    }

    @RequiredPrivilege(value = { Privilege.SYSTEM_ACCOUNT })
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public String destroy(Model model, @PathVariable String id, final RedirectAttributes redirectAttrs) {
        try {
            this.accountService.delete(Long.parseLong(id));
            sendNoticeWhenRedirect(redirectAttrs, "common.destroy.success");
        } catch (Exception e) {
            logger.info(e.getMessage());
            sendErrorMessageWhenRedirect(redirectAttrs, "common.hasnode.warn");
            return "redirect:/account";
        }
        return "redirect:/account";
    }

    @RequiredPrivilege(value = { Privilege.SYSTEM_ACCOUNT })
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String show(Model model, @PathVariable String id) {
        model.addAttribute("account", this.accountService.findById(Long.parseLong(id)));
        return "account/show";
    }

    @RequiredPrivilege(value = { Privilege.SYSTEM_ACCOUNT })
    @RequestMapping(value = "/{id}/edit", method = RequestMethod.GET)
    public String edit(Model model, @PathVariable String id, final RedirectAttributes redirectAttrs) {
        if (isNull(redirectAttrs, model, true, id)) {
            return "redirect:/account";
        }
        return "account/edit";
    }

    @RequiredPrivilege(value = { Privilege.SYSTEM_ACCOUNT })
    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public String editNew() {
        return "account/add";
    }

    @RequiredPrivilege(value = { Privilege.SYSTEM_ACCOUNT })
    @RequestMapping(value = "/bulkImport", method = RequestMethod.GET)
    public String bulkImport() {
        return "account/bulkImport/index";
    }

    @RequiredPrivilege(value = { Privilege.SYSTEM_ACCOUNT })
    @RequestMapping(value = "/bulkImport/methodOne", method = RequestMethod.GET)
    public String methodOne(Model model, final RedirectAttributes redirectAttrs) {
        if (!this.enrollmentPlanService.checkExist()) {
            sendErrorMessageWhenRedirect(redirectAttrs, "account.enrollmentPlan.list.empty");
            return "redirect:/enrollmentplan";
        }
        model.addAttribute("enrollmentPlans", this.enrollmentPlanService.listEnableImport());
        return "account/bulkImport/methodOne/index";
    }

    @RequiredPrivilege(value = { Privilege.SYSTEM_ACCOUNT })
    @RequestMapping(value = "/bulkImport/methodTwo", method = RequestMethod.GET)
    public String methodTwo() {
        return "account/bulkImport/methodTwo/index";
    }

    /**
     * 根据已有的招生计划导入学生
     */
    @RequiredPrivilege(value = { Privilege.SYSTEM_ACCOUNT })
    @RequestMapping(value = "/bulkImport/methodOne", method = RequestMethod.POST)
    public String importExcel(final RedirectAttributes redirectAttrs, Model model,
            @RequestParam MultipartFile file, String enrollmentPlanId) throws IOException {
        List<Account> accounts = null;
        EnrollmentPlan enrollmentPlan = this.enrollmentPlanService.findById(Long.parseLong(enrollmentPlanId));
        // 判断当前时间是否是注册时间
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(enrollmentPlan.getBeginTime());
        calendar.add(Calendar.DATE, -1);
        Date begin = calendar.getTime();
        calendar.setTime(enrollmentPlan.getEndTime());
        calendar.add(Calendar.DATE, 1);
        Date end = calendar.getTime();
        if (!date.after(begin) || !date.before(end)) {
            sendErrorMessageWithParameter(model, "enrollmentPlan.time.wrong");
            model.addAttribute("enrollmentPlans", this.enrollmentPlanService.listEnableImport());
            return "account/bulkImport/methodOne/index";
        }

        // 验证评分标准是否添加
        if (!this.scoringStandardService.checkExistByBatch(enrollmentPlan.getBatch())) {
            sendWarningWhenRedirect(redirectAttrs, "account.scoringStandard.empty");
            return "redirect:/scoringStandard";
        }

        // 验证结业标准是否添加
        if (!this.graduateStandardService.checkeExistByBatch(enrollmentPlan.getBatch())) {
            sendWarningWhenRedirect(redirectAttrs, "account.graduateStandard.empty");
            return "redirect:/graduateStandard";
        }
        

        accounts = this.accountService.readXls(file.getInputStream());
        if (this.accountService.validateAccounts(accounts, enrollmentPlan) != 0) {
            sendErrorMessageWithParameter(model, "account.import.exsit",
                    this.accountService.validateAccounts(accounts, enrollmentPlan));
            model.addAttribute("enrollmentPlans", this.enrollmentPlanService.listEnableImport());
            return "account/bulkImport/methodOne/index";
        }
        //检查当前导入是否超出了剩余人数
        if(accounts.size()>(enrollmentPlan.getEnrollmentNumber() - enrollmentPlan.getExistedUserNumber())){
        	sendErrorMessageWithParameter(model, "enrollmentPlan.importNumber.morethan.lastNumber",
        							accounts.size()-(enrollmentPlan.getEnrollmentNumber() - enrollmentPlan.getExistedUserNumber()));
        	model.addAttribute("enrollmentPlans", this.enrollmentPlanService.listEnableImport());
        	return "account/bulkImport/methodOne/index";
        }
        
        try {
            this.userService.saveAllAccountInformation(accounts, enrollmentPlan);
            this.enrollmentPlanService.updateExistedUserNumber(enrollmentPlan);
            sendNoticeWhenRedirect(redirectAttrs, "common.import.success");
        } catch (UserInfoSendCASFaildException e) {
            logger.error(e.getMessage());
            model.addAttribute("enrollmentPlans", this.enrollmentPlanService.listEnableImport());
            sendErrorMessageWithParameter(model, "user.cas.sendError");
            return "account/bulkImport/methodOne/index";
        } catch (UserInfoPushToStudySpaceFaildException e) {
            logger.error(e.getMessage());
            model.addAttribute("enrollmentPlans", this.enrollmentPlanService.listEnableImport());
            sendErrorMessageWithParameter(model, "user.space.sendError");
            return "account/bulkImport/methodOne/index";
        } catch (UserInfoPushToStudySpaceClassRoomFaildException e) {
            logger.error(e.getMessage());
            model.addAttribute("enrollmentPlans", this.enrollmentPlanService.listEnableImport());
            sendErrorMessageWithParameter(model, "user.space.classroom.sendError");
            return "account/bulkImport/methodOne/index";
        } catch (StudySpaceCreateFaildException e) {
            logger.error(e.getMessage());
            model.addAttribute("enrollmentPlans", this.enrollmentPlanService.listEnableImport());
            sendErrorMessageWithParameter(model, "studyspace.school.senderror");
            return "account/bulkImport/methodOne/index";
        }
        return "redirect:/account";
    }

    @RequiredPrivilege(value = { Privilege.SYSTEM_ACCOUNT })
    @RequestMapping(value = "/bulkImport/downloadTemplate", method = RequestMethod.GET)
    public void downloadTemplate(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String localFilePath = "/resources/template.xls";
        String fileName = getMessage("templateName");
        new FileSender().downLoad(request, response, localFilePath, fileName);
    }

    private boolean isNull(final RedirectAttributes redirectAttrs, Model model, boolean whithModel, String id) {
        Account account = this.accountService.findById(Long.parseLong(id));
        if (null == account) {
            sendErrorMessageWithParameterWhenRedirect(redirectAttrs, "common.obj.notfound", "id:" + id);
            return true;
        } else {
            if (whithModel) {
                model.addAttribute("account", account);
            }
            return false;
        }
    }
}
