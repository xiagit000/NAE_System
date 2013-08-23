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

import java.util.Collection;
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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import sun.misc.BASE64Encoder;

import com.boventech.gplearn.annotation.RequiredPrivilege;
import com.boventech.gplearn.entity.Account;
import com.boventech.gplearn.entity.Account.IdType;
import com.boventech.gplearn.entity.Batch;
import com.boventech.gplearn.entity.LearnClass;
import com.boventech.gplearn.entity.Privilege;
import com.boventech.gplearn.entity.SchoolRoll;
import com.boventech.gplearn.entity.User;
import com.boventech.gplearn.entity.User.UserType;
import com.boventech.gplearn.exception.UserDestroyInCASFaildException;
import com.boventech.gplearn.exception.UserDestroyInStudySpaceFaildException;
import com.boventech.gplearn.exception.UserUpdateToCASFaildException;
import com.boventech.gplearn.service.BatchService;
import com.boventech.gplearn.service.LearnClassService;
import com.boventech.gplearn.service.SchoolRollService;
import com.boventech.gplearn.service.UserService;
import com.boventech.gplearn.util.ExcelExporter;
import com.boventech.gplearn.util.UserFiller;
import com.google.common.base.Strings;
import com.google.common.collect.HashMultimap;
import com.google.common.collect.Lists;
import com.google.common.collect.Multimap;

@Controller
@RequestMapping(value = "/user")
public class UserController extends ApplicationController {

    private Logger logger = Logger.getLogger(this.getClass().getName());

    @Autowired
    private UserService userService;

    @Autowired
    private SchoolRollService schoolRollService;

    @Autowired
    private LearnClassService learnClassService;

    @Autowired
    private BatchService batchService;

    @RequiredPrivilege(value = { Privilege.SYSTEM_USER })
    @RequestMapping(method = RequestMethod.GET)
    public String index(Model model, HttpServletRequest request, Integer page, User user, Account account,
            String userTypeSelect, String idTypeSelect, String batchId, String learnClassId) {
        if (null != idTypeSelect) {
            checkSelectedIdType(account, idTypeSelect);
            model.addAttribute("idTypeSelect", idTypeSelect);
        }
        if (null != userTypeSelect) {
            checkSelectedUserType(user, userTypeSelect);
            model.addAttribute("userTypeSelect", userTypeSelect);
        }

        setSiteBarActive("xw", "user", request);
        List<Batch> batchlist = this.batchService.listAll();
        List<LearnClass> learnClasses = this.learnClassService.listAll();
        model.addAttribute("batchList", batchlist);
        model.addAttribute("learnClassList", learnClasses);
        Batch batch = null;
        LearnClass learnClass = null;
        if (!Strings.isNullOrEmpty(batchId)) {
            batch = this.batchService.findById(Long.parseLong(batchId));
        }
        if (!Strings.isNullOrEmpty(learnClassId)) {
            learnClass = this.learnClassService.findById(Long.parseLong(learnClassId));
        }
        model.addAttribute("users",
                this.userService.listSearchWithPagnate(page, user, account, batch, learnClass));
        return "user/index";
    }

    private void checkSelectedUserType(User user, String userTypeSelect) {
        if (userTypeSelect.equals("-1")) {
            user.setUserType(null);
        } else {
            user.setUserType(UserType.valueOf(userTypeSelect));
        }
    }

    private void checkSelectedIdType(Account account, String idTypeSelect) {
        if (idTypeSelect.equals("-1")) {
            account.setIdType(null);
        } else {
            account.setIdType(IdType.valueOf(idTypeSelect));
        }
    }

    @RequiredPrivilege(value = { Privilege.SYSTEM_USER })
    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public String destory(Model model, @PathVariable String id, final RedirectAttributes redirectAttrs) {
        User user = this.userService.findById(Long.parseLong(id));
        List<SchoolRoll> schoolRolls = this.schoolRollService.findSchoolRollsByUser(user);
        try {
            this.userService.destroyUser(user, schoolRolls);
            sendNoticeWhenRedirect(redirectAttrs, "common.destroy.success");
        } catch (UserDestroyInStudySpaceFaildException e) {
            logger.error(e.getMessage());
            sendErrorMessageWhenRedirect(redirectAttrs, "user.space.destroy.error");
        } catch (UserDestroyInCASFaildException e) {
            logger.error(e.getMessage());
            sendErrorMessageWhenRedirect(redirectAttrs, "user.cas.destroy.error");
        }
        return "redirect:/user";
    }

    @RequiredPrivilege(value = { Privilege.SYSTEM_USER })
    @RequestMapping(value = "/exportExcel", method = RequestMethod.GET)
    public void exportExcel(Model model, HttpServletResponse response, User user, Account account,
            String batchId, String learnClassId) {
        Batch batch = null;
        LearnClass learnClass = null;
        if (!Strings.isNullOrEmpty(batchId)) {
            batch = this.batchService.findById(Long.parseLong(batchId));
        }
        if (!Strings.isNullOrEmpty(learnClassId)) {
            learnClass = this.learnClassService.findById(Long.parseLong(learnClassId));
        }
        new ExcelExporter().exportXLS(response, getHeads(), getMessage("userExcelName"),
                getMessage("user_loginPassword_description"),
                new UserFiller(this.userService.listSearchWithoutPagnate(user, account, batch, learnClass)));
    }

    @RequiredPrivilege(value = { Privilege.STUDENT_USER_ACCOUNT, Privilege.TEACHER_USER_ACCOUNT,
            Privilege.PROVINCE_USER_ACCOUNT, Privilege.SUBJECT_USER_ACCOUNT, Privilege.SYSTEM_ACCOUNT,
            Privilege.SCHOOL_USER_ACCOUNT, Privilege.PROJECT_ANNOUNCEMENT, })
    @RequestMapping(value = "/me")
    public String show(Model model, HttpServletRequest request) {
        User currentUser = (User) request.getSession().getAttribute("currentUser");
        if (checkEntityEmpty(currentUser)) {
            return "error/404";
        }
        UserType userType = currentUser.getUserType();
        if (userType.equals(UserType.Student)) {
            SchoolRoll schoolRoll = schoolRollService.findByUserNewest(currentUser);
            List<SchoolRoll> schoolRollList = schoolRollService.listAllInformationByUserId(currentUser
                    .getId());
            model.addAttribute("schoolRoll", schoolRoll);
            model.addAttribute("schoolRollList", schoolRollList);
            return "role/student/me";
        }
        model.addAttribute("user", currentUser);
        return "role/" + backFolderNameByUserType(userType) + "/me";
    }

    @RequiredPrivilege(value = { Privilege.STUDENT_USER_ACCOUNT, Privilege.TEACHER_USER_ACCOUNT,
            Privilege.PROVINCE_USER_ACCOUNT, Privilege.SUBJECT_USER_ACCOUNT, Privilege.SYSTEM_ACCOUNT,
            Privilege.SCHOOL_USER_ACCOUNT, Privilege.PROJECT_ANNOUNCEMENT, })
    @RequestMapping(value = "/changepass")
    public String changepassForward(HttpServletRequest request) {
        User currentUser = (User) request.getSession().getAttribute("currentUser");
        if (checkEntityEmpty(currentUser)) {
            return "error/404";
        }
        return "role/" + backFolderNameByUserType(currentUser.getUserType()) + "/changepass";
    }

    @RequiredPrivilege(value = { Privilege.STUDENT_USER_ACCOUNT, Privilege.TEACHER_USER_ACCOUNT,
            Privilege.PROVINCE_USER_ACCOUNT, Privilege.SUBJECT_USER_ACCOUNT, Privilege.SYSTEM_ACCOUNT,
            Privilege.SCHOOL_USER_ACCOUNT, Privilege.PROJECT_ANNOUNCEMENT, })
    @RequestMapping(value = "/changepass", method = RequestMethod.POST)
    public String changepass(String oldPassword, String newpassword, HttpServletRequest request, Model model,
            RedirectAttributes redirectAttr) {
        User currentUser = (User) request.getSession().getAttribute("currentUser");
        if (checkEntityEmpty(currentUser)) {
            return "error/404";
        }
        BASE64Encoder encoder = new BASE64Encoder();
        oldPassword = encoder.encode(oldPassword.getBytes());
        if (!oldPassword.equals(currentUser.getPassword())) {
            sendErrorMessage(model, "changepassword.oldpassword.error");
            model.addAttribute("oldPassword", oldPassword);
            model.addAttribute("newpassword", newpassword);
            return "role/" + backFolderNameByUserType(currentUser.getUserType()) + "/changepass";
        }
        currentUser.setPassword(encoder.encode(newpassword.getBytes()));
        try {
            userService.changePassword(currentUser);
            request.getSession().setAttribute("currentUser", currentUser);
            sendNoticeWhenRedirect(redirectAttr, "common.update.success");
        } catch (UserUpdateToCASFaildException e) {
            sendErrorMessageWhenRedirect(redirectAttr, "changepassword.toCAS.error");
            logger.error(e.getMessage());
        }
        return "redirect:/";
    }

    @RequestMapping(value = "/getUsers/{role}", method = RequestMethod.POST)
    @ResponseBody
    public List<User> getUsers(@PathVariable String role) {
        List<User> users = Lists.newArrayList();
        Collection<UserType> types = map.get(role);
        for (UserType type : types) {
            users.addAll(this.userService.findByUserTypeAndBatch(type));
        }
        return users;
    }

    static Multimap<String, UserType> map = HashMultimap.create();

    static {
        map.put("supervisor", UserType.Province_Supervisor);
        map.put("supervisor", UserType.School_Supervisor);
        map.put("specialists", UserType.Project_Specialists);
        map.put("specialists", UserType.Subject_Specialists);
        map.put("teacher", UserType.Teacher);
        map.put("student", UserType.Student);
    }

    private List<String> getHeads() {
        List<String> heads = Lists.newArrayList();
        heads.add(getMessage("user_id"));
        heads.add(getMessage("user_loginName"));
        heads.add(getMessage("user_name"));
        heads.add(getMessage("user_idType"));
        heads.add(getMessage("user_idNumber"));
        heads.add(getMessage("user_batch"));
        return heads;
    }
}
