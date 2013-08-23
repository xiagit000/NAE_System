package com.boventech.gplearn.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.boventech.gplearn.annotation.RequiredPrivilege;
import com.boventech.gplearn.entity.BigSubject;
import com.boventech.gplearn.entity.Constants;
import com.boventech.gplearn.entity.LearnClass;
import com.boventech.gplearn.entity.LearnThesis;
import com.boventech.gplearn.entity.Privilege;
import com.boventech.gplearn.entity.SchoolRoll;
import com.boventech.gplearn.entity.User;
import com.boventech.gplearn.entity.User.UserType;
import com.boventech.gplearn.service.BatchService;
import com.boventech.gplearn.service.BigSubjectService;
import com.boventech.gplearn.service.LearnClassService;
import com.boventech.gplearn.service.LearnThesisService;
import com.boventech.gplearn.service.LearnThesisSubmitInfomationService;
import com.boventech.gplearn.service.SchoolRollService;
import com.google.common.collect.Lists;

@Controller
@RequestMapping(value="/learnthesis")
public class LearnThesisController extends ApplicationController {

	private static final Logger logger = LoggerFactory.getLogger(LearnThesisController.class);
	
	@Autowired
	private LearnThesisService learnThesisService;
	
	@Autowired
	private BigSubjectService bigSubjectService;
	
	@Autowired
	private BatchService batchService;
	
	@Autowired
	private SchoolRollService schoolRollService;
	
	@Autowired
	private LearnClassService learnClassService;
	
	@Autowired
	private LearnThesisSubmitInfomationService learnThesisSubmitInfomationService;
	
	@RequiredPrivilege(value={Privilege.SYSTEM_LEARNTHESIS})
	@RequestMapping()
	public String index(Model model,Integer page,HttpServletRequest request){
		setSiteBarActive("jw", "learnthesis", request);
		List<LearnThesis> list =learnThesisService.listWithPagination(page);
		model.addAttribute("list", list);
		return "learnthesis/index";
	}
	
	@RequiredPrivilege(value={Privilege.SYSTEM_LEARNTHESIS})
	@RequestMapping(value="/create")
	public String create(Model model,RedirectAttributes redirectAttr){
		if (null == batchService.getCurrentBatch()) {
			sendErrorMessageWhenRedirect(redirectAttr,
					"learnPlan.currentbatch.null");
			return "redirect:/batch";
		}
		initSelectData(model);
		return "learnthesis/create";
	}
	
	@RequiredPrivilege(value={Privilege.SYSTEM_LEARNTHESIS})
	@RequestMapping(method=RequestMethod.POST)
	public String save(LearnThesis learnThesis,Long bigSubjectId,RedirectAttributes redirectAttr,Model model){
		BigSubject selectedBigSubject=bigSubjectService.findById(bigSubjectId);
		if(checkEntityEmpty(selectedBigSubject)){
			return "error/404";
		}
		learnThesis.setBigSubject(selectedBigSubject);
		if(!learnThesis.checkDatetime()){
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
			sendErrorMessageWithParameter(model, "begin.end.datetime.validate", sdf.format(learnThesis.getBeginTime()),sdf.format(learnThesis.getSubmitTime()));
			initSelectData(model);
			model.addAttribute("learnThesis", learnThesis);
			return "learnthesis/create";
		}
		
		learnThesisService.save(learnThesis);
		sendNoticeWhenRedirect(redirectAttr,"common.add.success");
		return "redirect:/learnthesis";
	}
	
	@RequiredPrivilege(value={Privilege.SYSTEM_LEARNTHESIS})
	@RequestMapping(value="/{id}/update")
	public String edit(@PathVariable Long id,Model model){
		LearnThesis learnThesis = learnThesisService.findById(id);
		if(checkEntityEmpty(learnThesis)){
			return "error/404";
		}
		initSelectData(model);
		model.addAttribute("learnThesis", learnThesis);
		return "learnthesis/edit";
	}
	
	@RequiredPrivilege(value={Privilege.SYSTEM_LEARNTHESIS})
	@RequestMapping(value="/{id}",method=RequestMethod.PUT)
	public String update(LearnThesis learnThesis,Long bigSubjectId,RedirectAttributes redirectAttr,Model model){
		BigSubject selectedBigSubject=bigSubjectService.findById(bigSubjectId);
		if(checkEntityEmpty(selectedBigSubject)){
			return "error/404";
		}
		learnThesis.setBigSubject(selectedBigSubject);
		if(!learnThesis.checkDatetime()){
			SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd");
			sendErrorMessageWithParameter(model, "begin.end.datetime.validate", sdf.format(learnThesis.getBeginTime()),sdf.format(learnThesis.getSubmitTime()));
			initSelectData(model);
			model.addAttribute("learnThesis", learnThesis);
			return "learnthesis/edit";
		}
		learnThesisService.update(learnThesis);
		sendNoticeWhenRedirect(redirectAttr, "common.update.success");
		return "redirect:/learnthesis";
	}
	
	@RequiredPrivilege(value={Privilege.SYSTEM_LEARNTHESIS})
	@RequestMapping(value="/{id}")
	public String show(@PathVariable Long id,Model model){
		LearnThesis learnThesis  = learnThesisService.findById(id);
		if(checkEntityEmpty(learnThesis)){
			return "error/404";
		}
		model.addAttribute("learnThesis", learnThesis);
		return "learnthesis/show";
	}
	
	@RequiredPrivilege(value={Privilege.TEACHER_LEARNTHESIS,Privilege.STUDENT_LEARNTHSIS_SUBMIT})
	@RequestMapping(value="/show")
	public String openShow(HttpServletRequest request,Model model){
		User user = (User)request.getSession().getAttribute("currentUser");
		if(user.getUserType().equals(UserType.Teacher)){
			LearnClass learnClass = learnClassService.findByTeacher(user);
			List<BigSubject> bigsubjects=bigSubjectService.listWithDisciplineInCurrentBatch(learnClass.getLearnProject().getDiscipline());
			List<LearnThesis> learnThesisList = Lists.newArrayList();
			learnThesisList=learnThesisService.lisOverThesisWithBigSubjects(bigsubjects);
			model.addAttribute("learnThesisList", learnThesisList);
			return "role/teacher/learnthesis";
		}else {
			SchoolRoll schoolRoll = schoolRollService.findByUserNewest(user);
			LearnClass learnClass = schoolRoll.getLearnClass();
			List<BigSubject> bigsubjects=bigSubjectService.listWithDisciplineInCurrentBatch(learnClass.getLearnProject().getDiscipline());
			List<LearnThesis> learnThesisList = Lists.newArrayList();
			learnThesisList=learnThesisService.listEnableThesisWithBigSubjects(bigsubjects);
			model.addAttribute("learnThesisList", learnThesisList);
			return "role/student/learnthesis";
		}
	}
	
	@RequiredPrivilege(value={Privilege.SYSTEM_LEARNTHESIS})
	@RequestMapping(value="/{id}",method=RequestMethod.DELETE)
	public String destroy(@PathVariable Long id,RedirectAttributes redirectAttr){
		LearnThesis learnThesis = learnThesisService.findById(id);
		if(checkEntityEmpty(learnThesis)){
			return "error/404";
		}
		learnThesisService.delete(id);
		sendNoticeWhenRedirect(redirectAttr, "common.destroy.success");
		return "redirect:/learnthesis";
	}
	
	@RequiredPrivilege(value={Privilege.STUDENT_LEARNTHSIS_SUBMIT})
	@RequestMapping(value="/{id}/submit",method=RequestMethod.POST)
	public String submitLearnThesis(@PathVariable Long id,MultipartFile file,HttpServletRequest request,RedirectAttributes redirectAttrs){
		User currentStudent =  (User) request.getSession().getAttribute("currentUser");
		LearnThesis learnThesis = learnThesisService.findById(id);
		if(checkEntityEmpty(learnThesis)){
			return "error/404";
		}
		else{
			Long size=file.getSize();
			if(size<=0){
				sendErrorMessageWhenRedirect(redirectAttrs, "upload.learnthesis.file.null");
			}
			if((size/1024/1024)>20){
				sendErrorMessageWhenRedirect(redirectAttrs,"upload.size.outofrange");
			}
			else{
				String path = request.getSession().getServletContext()
				.getRealPath(Constants.DEFAULT_UPLOAD_PATH);
				String fileName = file.getOriginalFilename();
				if(null!=fileName && !"".equals(fileName)){
					Integer prefix = fileName.lastIndexOf(Constants.POINT);
					String suffix = fileName.substring(prefix==-1?0:prefix,fileName.length());
					fileName=personInchargeLoginNamePrefix()+suffix;
					File target = new File(path, fileName);
					if (!target.exists()) {
						target.mkdirs();
					}
					try {
						file.transferTo(target);
						learnThesisSubmitInfomationService.saveLearnThesisSubmitInformation(learnThesis,currentStudent,fileName);
						sendNoticeWhenRedirect(redirectAttrs,"common.add.success");
					} catch (IllegalStateException e) {
						logger.error(e.getMessage());
					} catch (IOException e) {
						logger.error(e.getMessage());
					}
				}
			}
			
		}
		
		return "redirect:/learnthesis/show";
	}
	
	private void initSelectData(Model model){
		List<BigSubject> bigSubjectList=bigSubjectService.listWithBatch(batchService.getCurrentBatch());
		model.addAttribute("bigSubjectList", bigSubjectList);
		model.addAttribute("currentBatch", batchService.getCurrentBatch());
	}
}
