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
import com.boventech.gplearn.entity.Constants;
import com.boventech.gplearn.entity.Discipline;
import com.boventech.gplearn.entity.LearnProject;
import com.boventech.gplearn.entity.LearnSubProject;
import com.boventech.gplearn.entity.Privilege;
import com.boventech.gplearn.service.DisciplineService;
import com.boventech.gplearn.service.LearnProjectService;
import com.boventech.gplearn.service.LearnSubProjectService;

@Controller
@RequestMapping(value="/learnproject/{lpid}/learnsubproject")
public class LearnSubProjectController extends ApplicationController {

	@Autowired
	private LearnSubProjectService learnSubProjectService;
	
	@Autowired
	private LearnProjectService learnProjectService;
	
	@Autowired
	private DisciplineService disciplineService;
	
	@RequiredPrivilege(value={Privilege.SYSTEM_LEARNSUBPROJECT})
	@RequestMapping
	public String index(@PathVariable Long lpid,Model model,HttpServletRequest request,Integer page,RedirectAttributes redirectAttr){
		setSiteBarActive("jc", "learnproject", request);
		LearnProject learnProject=learnProjectService.findById(lpid);
		if(null==learnProject){
			sendErrorMessageWithParameterWhenRedirect(redirectAttr, "common.obj.notfound","learnProject_Id");
			return "redirect:/learnproject/";
		}
		List<LearnSubProject> list=learnSubProjectService.listWithPaginationByLearnProjectId(page, lpid);
		model.addAttribute("learnProject", learnProject);
		model.addAttribute("list", list);
		return "learnsubproject/index";}
	
	@RequiredPrivilege(value={Privilege.SYSTEM_LEARNSUBPROJECT})
	@RequestMapping(value="/create")
	public String create(@PathVariable Long lpid,Model model,RedirectAttributes redirectAttr){ 
		LearnProject learnProject=learnProjectService.findById(lpid);
		if(null==learnProject){
			sendErrorMessageWithParameterWhenRedirect(redirectAttr, "common.obj.notfound","learnProject_Id");
			return "redirect:/learnproject";
		}
		if(!disciplineService.checkExsit()){
			sendErrorMessageWhenRedirect(redirectAttr, "learnsp.emptydiscipline");
			return "redirect:/discipline";
		}
		model.addAttribute("learnProject", learnProject);
		
		initSelectData(model);
		return "learnsubproject/create";
	}

	@RequiredPrivilege(value={Privilege.SYSTEM_LEARNSUBPROJECT})
	@RequestMapping(value="/{id}/update")
	public String edit(@PathVariable Long lpid ,@PathVariable Long id,Model model,RedirectAttributes redirectAttr){
		LearnProject learnProject=learnProjectService.findById(lpid);
		if(null==learnProject){
			sendErrorMessageWithParameterWhenRedirect(redirectAttr, "common.obj.notfound","learnProject_Id");
			return "redirect:/learnproject";
		}
		model.addAttribute("learnProject", learnProject);
		
		LearnSubProject learnSubProject = learnSubProjectService.findByIdAndLearnProject(learnProject, id);
		if(null==learnSubProject){
			sendErrorMessageWithParameterWhenRedirect(redirectAttr, "common.obj.notfound","learnSubProject_Id:"+id);
			return "redirect:/learnproject/"+lpid+"/learnsubproject";
		}
		model.addAttribute("learnSubProject",learnSubProject);
		initSelectData(model);
		return "learnsubproject/update";
	}
	
	@RequiredPrivilege(value={Privilege.SYSTEM_LEARNSUBPROJECT})
	@RequestMapping(method=RequestMethod.POST)
	public String save(@PathVariable Long lpid,LearnSubProject learnSubProject,Long disciplineId,Model model,RedirectAttributes redirectAttr){
		LearnProject learnProject=learnProjectService.findById(lpid);
		if(null==learnProject){
			sendErrorMessageWithParameterWhenRedirect(redirectAttr, "common.obj.notfound","learnProject_Id");
			return "redirect:/learnproject";
		}
		learnSubProject.setLearnProject(learnProject);
		
		
		Discipline discipline = disciplineService.findById(disciplineId);
		if(null==discipline){
			sendErrorMessage(model, "common.select.faild");
			initSelectData(model);
			model.addAttribute("learnProject",learnProject);
			model.addAttribute("learnSubProject", learnSubProject);
			return "learnsubproject/create";
		}
		learnSubProject.setDiscipline(discipline);

		learnSubProject.setName(learnProject.getName()+Constants.BREAKE_STR+learnSubProject.getDiscipline().getLearnLevel()
				.getName()+ learnSubProject.getDiscipline().getLearnSpeacialty()
						.getName());
	
		if(learnSubProjectService.checkExsitByDiscplineIdAndLearnProjectId(disciplineId, learnProject.getId())){
			sendErrorMessageWithParameter(model, "common.name.exsit", learnSubProject.getName());
			initSelectData(model);
			model.addAttribute("learnProject",learnProject);
			model.addAttribute("learnSubProject", learnSubProject);
			return "learnsubproject/create";
		}
		
		learnSubProjectService.save(learnSubProject);
		sendNoticeWhenRedirect(redirectAttr, "common.add.success");
		return "redirect:/learnproject/"+lpid+"/learnsubproject";
	}
	
	@RequiredPrivilege(value={Privilege.SYSTEM_LEARNSUBPROJECT})
	@RequestMapping(value="/{id}",method=RequestMethod.PUT)
	public String update(@PathVariable Long lpid,LearnSubProject learnSubProject,Long disciplineId,Model model,RedirectAttributes redirectAttr){ 
		
		LearnProject learnProject=learnProjectService.findById(lpid);
		if(null==learnProject){
			sendErrorMessageWithParameterWhenRedirect(redirectAttr, "common.obj.notfound","learnProject_Id");
			return "redirect:/learnproject";
		}
		learnSubProject.setLearnProject(learnProject);
		Discipline discipline = disciplineService.findById(disciplineId);
		if(null==discipline){
			sendErrorMessage(model, "common.select.faild");
			initSelectData(model);
			model.addAttribute("learnProject",learnProject);
			model.addAttribute("learnSubProject", learnSubProject);
			return "learnsubproject/update";
		}
		learnSubProject.setDiscipline(discipline);

		learnSubProject.setName(learnProject.getName()+Constants.BREAKE_STR+learnSubProject.getDiscipline().getLearnLevel()
				.getName()+ learnSubProject.getDiscipline().getLearnSpeacialty()
						.getName());
		if(learnSubProjectService.checkExsitByDiscplineIdAndLearnProjectIdWithOutCurrent(learnSubProject, lpid))
		{
			sendErrorMessageWithParameter(model, "common.name.exsit",learnSubProject.getName());
			initSelectData(model);
			model.addAttribute("learnProject",learnProject);
			model.addAttribute("learnSubProject", learnSubProject);
			return "learnsubproject/update";
		}
		
		
		learnSubProjectService.update(learnSubProject);
		sendNoticeWhenRedirect(redirectAttr, "common.update.success");
		return "redirect:/learnproject/"+lpid+"/learnsubproject";
	}
	
	@RequiredPrivilege(value={Privilege.SYSTEM_LEARNSUBPROJECT})
	@RequestMapping(value="/{id}",method=RequestMethod.DELETE)
	public String destroy(@PathVariable Long lpid,@PathVariable Long id,RedirectAttributes redirectAttr){ 
		LearnProject learnProject=learnProjectService.findById(lpid);
		if(null==learnProject){
			sendErrorMessageWithParameterWhenRedirect(redirectAttr, "common.obj.notfound","learnProject_Id");
			return "redirect:/learnproject";
		}
		LearnSubProject learnSubProject = learnSubProjectService.findById(id);
		if(null==learnSubProject){
			sendErrorMessageWithParameterWhenRedirect(redirectAttr, "common.obj.notfound","id:"+id);
			return "redirect:/learnsubproject";
		}
		try {
			learnSubProjectService.delete(id);
			sendNoticeWhenRedirect(redirectAttr, "common.destroy.success");
		} catch (RuntimeException e) {
			sendErrorMessageWithParameterWhenRedirect(redirectAttr, "common.reference.delete",learnSubProject.getName());
		}
		return "redirect:/learnproject/"+lpid+"/learnsubproject"; 
	}
	
	@RequiredPrivilege(value={Privilege.SYSTEM_LEARNSUBPROJECT})
	@RequestMapping(value="/{id}")
	public String show(@PathVariable Long id,@PathVariable Long lpid,RedirectAttributes redirectAttr,Model model){
		LearnProject learnProject=learnProjectService.findById(lpid);
		if(null==learnProject){
			sendErrorMessageWithParameterWhenRedirect(redirectAttr, "common.obj.notfound","learnProject_Id");
			return "redirect:/learnproject";
		}
		
		LearnSubProject learnSubProject = learnSubProjectService.findById(id);
		if(null == learnSubProject){
			sendWarningWhenRedirect(redirectAttr,"common.obj.notfound");
			return "redirect:/learnproject/"+lpid+"/learnsubproject";
		}
		model.addAttribute("learnSubProject", learnSubProject);
		model.addAttribute("learnProject", learnProject);
		return "learnsubproject/show";
	}
	
	
	private void initSelectData(Model model) {
		List<Discipline> disciplineList=disciplineService.listAll();
		model.addAttribute("disciplineList", disciplineList);
	}
	
}
