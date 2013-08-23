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
import com.boventech.gplearn.entity.Batch;
import com.boventech.gplearn.entity.BigSubject;
import com.boventech.gplearn.entity.Discipline;
import com.boventech.gplearn.entity.Privilege;
import com.boventech.gplearn.service.BatchService;
import com.boventech.gplearn.service.BigSubjectService;
import com.boventech.gplearn.service.DisciplineService;
import com.boventech.gplearn.service.SmallTopicService;

@Controller
@RequestMapping(value="/bigsubject")
public class BigSubjectController extends ApplicationController {

	@Autowired
	private BigSubjectService bigSubjectService;
	
	@Autowired
	private BatchService batchService;
	
	@Autowired
	private DisciplineService disciplineService;
	
	@Autowired
	private SmallTopicService smallTopicService;
	
	@RequiredPrivilege(value={Privilege.SYSTEM_BIGSUBJECT})
	@RequestMapping
	public String index(Model model,Integer page,HttpServletRequest request){
		setSiteBarActive("jw", "bigsubject", request);
		List<BigSubject> list =bigSubjectService.listWithPagination(page);
		model.addAttribute("list",list);
		return "bigsubject/index";
	}
	
	@RequiredPrivilege(value={Privilege.SYSTEM_BIGSUBJECT})
	@RequestMapping(value="/create")
	public String create(Model model,RedirectAttributes redirectAttr){
		List<Batch> batchList=batchService.listAll();
		List<Discipline>  disciplineList=disciplineService.listAll();
		if(batchList.isEmpty()){
			sendErrorMessageWhenRedirect(redirectAttr,
			"learnPlan.currentbatch.null");
			return "redirect:/batch";
		}
		if(disciplineList.isEmpty()){
			sendErrorMessageWhenRedirect(redirectAttr,"learnsp.emptydiscipline");
			return "redirect:/discipline";
		}
		model.addAttribute("batchList", batchList);
		model.addAttribute("disciplineList", disciplineList);
		
		return "bigsubject/create";
	}
	
	@RequiredPrivilege(value={Privilege.SYSTEM_BIGSUBJECT})
	@RequestMapping(method=RequestMethod.POST)
	public String save(BigSubject bigSubject,Long batchId,Long disciplineId,RedirectAttributes redirectAttr,Model model){
		if(null==batchId || null==disciplineId){
			sendErrorMessageWhenRedirect(redirectAttr,"select.value.null");
			return "redirect:/bigsubject";
		}
		Batch selectBatch = batchService.findById(batchId);
		Discipline selectDiscipline = disciplineService.findById(disciplineId);
		
		bigSubject.setBatch(selectBatch);
		bigSubject.setDiscipline(selectDiscipline);
		
		if(bigSubjectService.isAlreadyExsitByTitle(bigSubject.getTitle())){
			sendErrorMessageWithParameter(model, "common.name.exsit",bigSubject.getTitle());
			initSelectValue(model);
			model.addAttribute("bigSubject", bigSubject);
			return "bigsubject/create";
		}
		
		bigSubjectService.save(bigSubject);
		sendNoticeWhenRedirect(redirectAttr, "common.add.success");
		/**
		 * TODO 新创建的大主题推送给学习平台
		 */
		return "redirect:/bigsubject";
	}
	
	@RequiredPrivilege(value={Privilege.SYSTEM_BIGSUBJECT})
	@RequestMapping(value="/{id}/update")
	public String edit(@PathVariable Long id,RedirectAttributes redirectAttr,Model model){
		BigSubject bigSubject=bigSubjectService.findById(id);
		if(null==bigSubject){
			sendErrorMessageWithParameterWhenRedirect(redirectAttr, "common.obj.notfound","id:"+id);
			return "redirect:/bigsubject";
		}
		initSelectValue(model);
		model.addAttribute("bigSubject", bigSubject);
		return "bigsubject/edit";
	}
	
	@RequiredPrivilege(value={Privilege.SYSTEM_BIGSUBJECT})
	@RequestMapping(value="/{id}",method=RequestMethod.PUT)
	public String update(BigSubject bigSubject,RedirectAttributes redirectAttr,Model model){
		if(bigSubjectService.isAlradyExsitByTitleWithOutCurrent(bigSubject)){
			sendErrorMessageWithParameter(model, "common.name.exsit",bigSubject.getTitle());
			initSelectValue(model);
			model.addAttribute("bigSubject", bigSubject);
			return "bigsubject/edit";
		}
		BigSubject updateBigSubject = bigSubjectService.findById(bigSubject.getId());
		updateBigSubject.setTitle(bigSubject.getTitle());
		updateBigSubject.setDescription(bigSubject.getDescription());
		
		bigSubjectService.update(updateBigSubject);
		sendNoticeWhenRedirect(redirectAttr, "common.add.success");
		
		/**
		 * TODO 修改后的大主题标题和描述推送给学习平台
		 */
		return "redirect:/bigsubject";
	}
	
	@RequiredPrivilege(value={Privilege.SYSTEM_BIGSUBJECT})
	@RequestMapping(value="/{id}",method=RequestMethod.DELETE)
	public String destroy(@PathVariable Long id,RedirectAttributes redirectAttr){
		BigSubject bigSubject = bigSubjectService.findById(id);
		if(null==bigSubject){
			sendErrorMessageWithParameterWhenRedirect(redirectAttr, "common.obj.notfound","id:"+id);
			return "redirect:/bigsubject";
		}
		if(!smallTopicService.isEmptyWithBigSubjectId(bigSubject.getId())){
			sendErrorMessageWithParameterWhenRedirect(redirectAttr, "common.reference.delete", bigSubject.getTitle());
			return "redirect:/bigsubject/"+bigSubject.getId()+"/smalltopic";
		}
		
		bigSubjectService.delete(id);
		sendNoticeWhenRedirect(redirectAttr,"common.destroy.success");
		return "redirect:/bigsubject";
		/**
		 * TODO 删除需要将删除的大主题关联信息推送给 学习平台
		 */
	}
	
	@RequiredPrivilege(value={Privilege.SYSTEM_BIGSUBJECT})
	@RequestMapping(value="/{id}")
	public String show(@PathVariable Long id,Model model,RedirectAttributes redirectAttr){
		BigSubject bigSubject = bigSubjectService.findById(id);
		if(null==bigSubject){
			sendErrorMessageWithParameterWhenRedirect(redirectAttr, "common.obj.notfound","id:"+id);
			return "redirect:/bigsubject";
		}
		model.addAttribute("bigSubject", bigSubject);
		return "bigsubject/show";
	}
	
	private void initSelectValue(Model model){
		List<Batch> batchList=batchService.listAll();
		List<Discipline>  disciplineList=disciplineService.listAll();
		model.addAttribute("batchList", batchList);
		model.addAttribute("disciplineList", disciplineList);
	}
}
