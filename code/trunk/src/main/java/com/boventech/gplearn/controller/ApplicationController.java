package com.boventech.gplearn.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.context.MessageSource;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.boventech.gplearn.entity.User;
import com.boventech.gplearn.entity.User.UserType;
import com.boventech.gplearn.util.DateUtil;

public class ApplicationController {

	@Autowired
	private MessageSource messageSource;

	private static final String NOTICE = "message";

	private static final String WARNING = "warning";

	private static final String ERROR = "error";

	public String getMessage(String key) {
		return messageSource.getMessage(key, null, null);
	}

	private String getMessageWithParamaters(String key, Object... objs) {
		return messageSource.getMessage(key, objs, null);
	}

	protected void sendNoticeWhenRedirect(RedirectAttributes redirectAttr,
			String messageKey) {
		redirectAttr.addFlashAttribute(NOTICE, getMessage(messageKey));
	}

	protected void sendWarningWhenRedirect(RedirectAttributes redirectAttrs,
			String messageKey) {
		redirectAttrs.addFlashAttribute(WARNING, getMessage(messageKey));
	}

	protected void sendErrorMessage(Model model, String messageKey) {
		model.addAttribute(ERROR, getMessage(messageKey));
	}

	protected void sendErrorMessageWhenRedirect(
			RedirectAttributes redirectAttrs, String messageKey) {
		redirectAttrs.addFlashAttribute(ERROR, getMessage(messageKey));
	}

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat(
				DateUtil.COMMON_DATE_FORMAT);
		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(
				dateFormat, true));
	}

	protected void sendNoticeWithParameterWhenRedirect(
			RedirectAttributes redirectAttr, String messageKey,
			Object... parameter) {
		redirectAttr.addFlashAttribute(WARNING, getMessageWithParamaters(
				messageKey, parameter));
	}

	protected void sendWarningWithParameterWhenRedirect(
			RedirectAttributes redirectAttrs, String messageKey,
			Object... parameter) {
		redirectAttrs.addFlashAttribute(WARNING, getMessageWithParamaters(
				messageKey, parameter));
	}

	protected void sendErrorMessageWithParameterWhenRedirect(
			RedirectAttributes redirectAttrs, String messageKey,
			Object... parameter) {
		redirectAttrs.addFlashAttribute(ERROR, getMessageWithParamaters(
				messageKey, parameter));
	}

	protected void sendErrorMessageWithParameter(Model model,
			String messageKey, Object... parameter) {
		model.addAttribute(ERROR, getMessageWithParamaters(messageKey,
				parameter));
	}
	
	protected boolean checkEntityEmpty(Object object){
		return null==object;
	}
	
	protected void setSiteBarActive(String menu,String item,HttpServletRequest request){
		HttpSession session = request.getSession();
		session.setAttribute("siteItem",item);
		session.setAttribute("siteMenu",menu);
	}
	
	protected String personInchargeLoginNamePrefix(){
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		String prefix=sdf.format(date);
		return "GP"+prefix;
	}
	
	protected String backFolderNameByUserType(UserType userType){
    	if(userType.equals(UserType.Project_Specialists)){
    		return "project";
    	}
    	if(userType.equals(UserType.Province_Supervisor)){
    		return "province";
    	}
    	if(userType.equals(UserType.School_Supervisor)){
    		return "school";
    	}
    	if(userType.equals(UserType.Student)){
    		return "student";
    	}
    	if(userType.equals(UserType.Subject_Specialists)){
    		return "discipline";
    	}
    	if(userType.equals(UserType.Teacher)){
    		return "teacher";
    	}
    	if(userType.equals(UserType.System_Administrator)){
    		return "admin";
    	}
    	else{
    		return null;
    	}
    }
	
	protected User getCurrentUser(HttpServletRequest request) {
		HttpSession session = request.getSession();
		Object result = session.getAttribute("currentUser"); 
		return result==null?null:(User)result;
	}
}
