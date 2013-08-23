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
import com.boventech.gplearn.entity.LearnProject;
import com.boventech.gplearn.entity.Privilege;
import com.boventech.gplearn.service.BatchService;
import com.boventech.gplearn.service.LearnProjectService;

@Controller
@RequestMapping(value="/learnproject")
public class LearnProjectController extends ApplicationController {

		@Autowired
		private LearnProjectService learnProjectService;
		
		@Autowired
		private BatchService batchService;
	
		@RequiredPrivilege(value={Privilege.SYSTEM_LEARNPROJECT})
		@RequestMapping(method = RequestMethod.GET)
	    public String index(Model model,Integer page,HttpServletRequest request) {
			setSiteBarActive("jc", "learnproject", request);
			List<LearnProject> list=learnProjectService.listWithPagination(page);
			model.addAttribute("list", list);
	        return "learnproject/index";
	    }
		
		@RequiredPrivilege(value={Privilege.SYSTEM_LEARNPROJECT})
		@RequestMapping(value="/create",method = RequestMethod.GET)
	    public String create(RedirectAttributes redirectAttr,Model model) {
			if(!batchService.checkExist()){
				sendErrorMessageWhenRedirect(redirectAttr,"learnproject.batch.list.empty");
				return "redirect:/batch";
			}
			initBatchList(model);
	        return "learnproject/create";
	    }
		
		@RequiredPrivilege(value={Privilege.SYSTEM_LEARNPROJECT})
		@RequestMapping(value = "/{id}/update", method = RequestMethod.GET)
	    public String edit(@PathVariable Long id,Model model,RedirectAttributes redirectAttr) {
			LearnProject learnProject=learnProjectService.findById(id);
			if(null==learnProject){
				sendErrorMessageWithParameterWhenRedirect(redirectAttr,"common.obj.notfound","id:"+id);
				return "redirect:/learnproject";
			}
			initBatchList(model);
			model.addAttribute("learnProject",learnProject);
	        return "learnproject/update";
	    }
		
		@RequiredPrivilege(value={Privilege.SYSTEM_LEARNPROJECT})
		@RequestMapping(method = RequestMethod.POST)
	    public String save(LearnProject learnProject,Long batchId,RedirectAttributes redirectAttr,Model model) {
			if(learnProjectService.isExsitByName(learnProject.getName())){
				sendErrorMessageWithParameter(model, "common.name.exsit", learnProject.getName());
				model.addAttribute("learnProject", learnProject);
				return "learnproject/create";
			}
			if(learnProjectService.isExsitByCode(learnProject.getCode())){
				sendErrorMessageWithParameter(model, "common.name.exsit", learnProject.getCode());
				model.addAttribute("learnProject", learnProject);
				return "learnproject/create";
			}
			Batch batch = batchService.findById(batchId);
			learnProject.setBatch(batch);
			learnProjectService.save(learnProject);
			sendNoticeWhenRedirect(redirectAttr, "common.add.success");
			return "redirect:/learnproject";
	    }

		@RequiredPrivilege(value={Privilege.SYSTEM_LEARNPROJECT})
	    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	    public String update(LearnProject learnProject,Long batchId,Model model, @PathVariable String id,RedirectAttributes redirectAttr) {
	    	if(learnProjectService.isExsitByNameWithOutCurrent(learnProject)){
	    		sendErrorMessageWithParameter(model, "common.name.exsit", learnProject.getName());
				model.addAttribute("learnProject", learnProject);
				return "learnproject/update";
	    	}
	    	if(learnProjectService.isExsitByCodeWithOutCurrent(learnProject)){
	    		sendErrorMessageWithParameter(model, "common.name.exsit", learnProject.getName());
				model.addAttribute("learnProject", learnProject);
				return "learnproject/update";
	    	}
	    	Batch batch = batchService.findById(batchId);
			learnProject.setBatch(batch);
	    	learnProjectService.update(learnProject);
	    	sendNoticeWhenRedirect(redirectAttr, "common.update.success");
	        return "redirect:/learnproject";
	    }
	    
		@RequiredPrivilege(value={Privilege.SYSTEM_LEARNPROJECT})
	    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	    public String destroy(@PathVariable Long id,Model model,RedirectAttributes redirectAttr) {
	    	LearnProject learnProject = learnProjectService.findById(id);
	    	if(null==learnProject){
	    		sendErrorMessageWithParameterWhenRedirect(redirectAttr,"common.obj.notfound","id:"+id);
				return "redirect:/learnproject";
	    	}
	    	try {
	    		learnProjectService.delete(id);
	    		sendNoticeWhenRedirect(redirectAttr, "common.destroy.success");
			} catch (RuntimeException e) {
				sendErrorMessageWhenRedirect(redirectAttr,"learnproject.hasnode");
				return "redirect:/learnproject";
			}
	    	
	    	
	        return "redirect:/learnproject";
	    }

		@RequiredPrivilege(value={Privilege.SYSTEM_LEARNPROJECT})
	    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
	    public String show(Model model, @PathVariable Long id,RedirectAttributes redirectAttr) {
	    	LearnProject learnProject = learnProjectService.findById(id);
	    	if(null==learnProject){
	    		sendErrorMessageWithParameterWhenRedirect(redirectAttr,"common.obj.notfound","id:"+id);
				return "redirect:/learnproject";
	    	}
	    	model.addAttribute("learnProject", learnProject);
	        return "learnproject/show";
	    }
	    
	    private void initBatchList(Model model){
	    	List<Batch> batchList=batchService.listAll();
	    	model.addAttribute("batchList", batchList);
	    }

}
