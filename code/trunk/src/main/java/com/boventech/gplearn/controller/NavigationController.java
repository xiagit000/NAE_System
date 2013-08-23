package com.boventech.gplearn.controller;

import java.util.Date;
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
import com.boventech.gplearn.entity.Navigation;
import com.boventech.gplearn.entity.PortalDefaultInformation;
import com.boventech.gplearn.entity.Privilege;
import com.boventech.gplearn.service.NavigationService;
import com.boventech.gplearn.service.PortalDefaultInfomationService;


@Controller
@RequestMapping(value="/portal/navigation")
public class NavigationController extends ApplicationController {

	@Autowired
	private NavigationService navigationService;
	
	@Autowired
	private PortalDefaultInfomationService portalDefaultInfomationService;
	
	
	//########################################################## 第一级菜单  ################################################
	
	@RequiredPrivilege(value={Privilege.SYSTEM_ACCOUNT})
	@RequestMapping
	public String index(Integer page,Model model){
		List<Navigation> parentList = navigationService.listParents();
		model.addAttribute("parentList", parentList);
		return "navigation/parent";
	}
	
	@RequiredPrivilege(value={Privilege.SYSTEM_ACCOUNT})
	@RequestMapping(value="/create")
	public String create(RedirectAttributes redirectAttrs){
		Integer count  = navigationService.listParents().size();
		if(count>6){
			sendErrorMessageWhenRedirect(redirectAttrs,"navigation.outlist.error");
			return "redirect:/portal/navigation";
		}
		return "navigation/create";
	}
	
	@RequestMapping(value="/{id}/update")
	@RequiredPrivilege(value={Privilege.SYSTEM_ACCOUNT})
	public String edit(@PathVariable Long id,Model model){
		Navigation navigation = navigationService.findById(id);
		if(checkEntityEmpty(navigation)){
			return "error/404";
		}
		model.addAttribute("navigation", navigation);
		return "navigation/update";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	@RequiredPrivilege(value={Privilege.SYSTEM_ACCOUNT})
	public String save(Navigation navigation,Model model,RedirectAttributes redirectAttr){
		//判断是否已经存在相同的条目了
		if(navigationService.isNameExsit(navigation.getName())){
			navigation.setName(null);
			model.addAttribute("navigation", navigation);
			sendErrorMessage(model, "navigation.name.exsit");
			return "navigation/create";
		}
		navigationService.saveParent(navigation);
		sendNoticeWhenRedirect(redirectAttr, "common.add.success");
		return "redirect:/portal/navigation";
	}
	
	@RequiredPrivilege(value={Privilege.SYSTEM_ACCOUNT})
	@RequestMapping(value="/{id}",method=RequestMethod.PUT)
	public String update(Navigation navigation
							,Model model
							,RedirectAttributes redirectAttributes
							,@PathVariable Long id){
		//判断新改的是否与其他重合
		if(navigationService.isNameExsitWithoutCurrentId(navigation.getName(),id)){
			navigation.setName(null);
			model.addAttribute("navigation", navigation);
			sendErrorMessage(model, "navigation.name.exsit");
			return "navigation/update";
		}
		Navigation old = navigationService.findById(id);
		old.setName(navigation.getName());
		navigationService.update(old);
		sendNoticeWhenRedirect(redirectAttributes, "common.update.success");
		return "redirect:/portal/navigation";
	}
	
	@RequiredPrivilege(value={Privilege.SYSTEM_ACCOUNT})
	@RequestMapping(value="/{id}",method=RequestMethod.DELETE)
	public String delete(@PathVariable Long id,RedirectAttributes redirectAttr){
		//删除所属一级导航下的所有二级导航
		navigationService.deleteParent(id);
		sendNoticeWhenRedirect(redirectAttr, "common.destroy.success");
		return "redirect:/portal/navigation";
	}
	
	//########################################################## 第二级菜单  ################################################//
	
	@RequiredPrivilege(value={Privilege.SYSTEM_ACCOUNT})
	@RequestMapping(value="/{parentId}/child")
	public String childIndex(@PathVariable Long parentId,Model model){
		List<Navigation> childrenList = navigationService.listChildren(parentId);
		model.addAttribute("childrenList", childrenList);
		Navigation parent = navigationService.findById(parentId);
		if(checkEntityEmpty(parent)){
			return "error/404";
		}
		model.addAttribute("parent", parent);
		return "navigation/child/index";
	}
	
	@RequiredPrivilege(value={Privilege.SYSTEM_ACCOUNT})
	@RequestMapping(value="/{parentId}/child/create")
	public String createChild(@PathVariable Long parentId,Model model){
		Navigation parent = navigationService.findById(parentId);
		if(checkEntityEmpty(parent)){
			return "error/404";
		}
		model.addAttribute("parent", parent);
		return "navigation/child/create";
	}
	
	@RequiredPrivilege(value={Privilege.SYSTEM_ACCOUNT})
	@RequestMapping(value="/{parentId}/child/{id}/update")
	public String editChild(@PathVariable Long parentId,@PathVariable Long id,Model model){
		Navigation parent = navigationService.findById(parentId);
		Navigation child = navigationService.findById(id);
		if(checkEntityEmpty(parent) || checkEntityEmpty(child)){
			return "error/404";
		}
		model.addAttribute("parent", parent);
		model.addAttribute("child", child);
		return "navigation/child/update";
	}
	
	@RequiredPrivilege(value={Privilege.SYSTEM_ACCOUNT})
	@RequestMapping(value="/{parentId}/child",method = RequestMethod.POST)
	public String saveChild(@PathVariable Long parentId
						,Navigation navigation
						,Model model
						,RedirectAttributes redirectAttributes){
		Navigation parent = navigationService.findById(parentId);
		if(checkEntityEmpty(parent)){
			return "error/404";
		}
		//判断是否已经存在相同的条目了
		if(navigationService.isNameExsit(navigation.getName())){
			navigation.setName(null);
			model.addAttribute("navigation", navigation);
			model.addAttribute("parent", parent);
			sendErrorMessage(model, "navigation.name.exsit");
			return "navigation/child/create";
		}
		navigationService.saveChild(navigation,parent);
		sendNoticeWhenRedirect(redirectAttributes, "common.add.success");
		return "redirect:/portal/navigation/"+parentId+"/child";
	}
	
	@RequiredPrivilege(value={Privilege.SYSTEM_ACCOUNT})
	@RequestMapping(value="/{parentId}/child/{id}",method=RequestMethod.PUT)
	public String updateChild(@PathVariable Long parentId
								,@PathVariable Long id
								,Navigation navigation
								,Model model
								,RedirectAttributes redirectAttributes){
		Navigation parent = navigationService.findById(parentId);
		Navigation child = navigationService.findById(id);
		if(checkEntityEmpty(parent) || checkEntityEmpty(child)){
			return "error/404";
		}
		//判断新改的是否与其他重合
		if(navigationService.isNameExsitWithoutCurrentId(navigation.getName(),id)){
			navigation.setName(null);
			model.addAttribute("navigation", navigation);
			model.addAttribute("parent", parent);
			model.addAttribute("child", child);
			sendErrorMessage(model, "navigation.name.exsit");
			return "navigation/child/update";
		}
		child.setName(navigation.getName());
		navigationService.update(child);
		sendNoticeWhenRedirect(redirectAttributes, "common.update.success");
		return "redirect:/portal/navigation/"+parentId+"/child";
	}
	
	@RequiredPrivilege(value={Privilege.SYSTEM_ACCOUNT})
	@RequestMapping(value="/{parentId}/child/{id}",method=RequestMethod.DELETE)
	public String deleteChild(@PathVariable Long id
								,@PathVariable Long parentId
								,RedirectAttributes redirectAttr){
		Navigation parent = navigationService.findById(parentId);
		parent.setChildCount(parent.getChildCount()-1);
		navigationService.update(parent);
		navigationService.delete(id);
		sendNoticeWhenRedirect(redirectAttr, "common.destroy.success");
		return "redirect:/portal/navigation/"+parentId+"/child";
	}
	
	
	//########################################################## 第二级菜单 新闻管理  ################################################//
	
	
	@RequiredPrivilege(value={Privilege.SYSTEM_ACCOUNT})
	@RequestMapping(value="/{parentId}/child/{id}/news")
	public String newsIndex(@PathVariable Long id,
							@PathVariable Long parentId,
							Model model,Integer page){
		
		Navigation parent = navigationService.findById(parentId);
		Navigation child = navigationService.findById(id);
		if(checkEntityEmpty(parent) || checkEntityEmpty(child)){
			return "error/404";
		}
		List<PortalDefaultInformation> list = portalDefaultInfomationService.listByNavigationIdWithPagination(child.getId(),page);
		model.addAttribute("list", list);
		model.addAttribute("parent", parent);
		model.addAttribute("child", child);
		return "navigation/child/news/index";
	}
	
	@RequiredPrivilege(value={Privilege.SYSTEM_ACCOUNT})
	@RequestMapping(value="/{parentId}/child/{id}/news/{newId}",method=RequestMethod.DELETE)
	public String newsDelete(@PathVariable Long newId,@PathVariable Long parentId,@PathVariable Long id){
		portalDefaultInfomationService.delete(newId);
		return "redirect:/portal/navigation/"+parentId+"/child/"+id+"/news";
	}
	
	@RequiredPrivilege(value={Privilege.SYSTEM_ACCOUNT})
	@RequestMapping(value="/{parentId}/child/{id}/news/create")
	public String newScreate(@PathVariable Long parentId,@PathVariable Long id,Model model){
		Navigation parent = navigationService.findById(parentId);
		Navigation child = navigationService.findById(id);
		if(checkEntityEmpty(parent) || checkEntityEmpty(child)){
			return "error/404";
		}
		model.addAttribute("parent", parent);
		model.addAttribute("child", child);
		return "navigation/child/news/create";
	}
	
	@RequiredPrivilege(value={Privilege.SYSTEM_ACCOUNT})
	@RequestMapping(value="/{parentId}/child/{id}/news/{newId}/update")
	public String newsUpdate(@PathVariable Long parentId
								,@PathVariable Long id
								,Model model
								,@PathVariable Long newId){
		Navigation parent = navigationService.findById(parentId);
		Navigation child = navigationService.findById(id);
		if(checkEntityEmpty(parent) || checkEntityEmpty(child)){
			return "error/404";
		}
		PortalDefaultInformation portalDefaultInformation = portalDefaultInfomationService.findById(newId);
		model.addAttribute("portalDefaultInformation", portalDefaultInformation);
		model.addAttribute("parent", parent);
		model.addAttribute("child", child);
		return "navigation/child/news/update";
	}
	
	@RequiredPrivilege(value={Privilege.SYSTEM_ACCOUNT})
	@RequestMapping(value="/{parentId}/child/{childId}/news",method=RequestMethod.POST)
	public String newSave(PortalDefaultInformation portalDefaultInformation
							,RedirectAttributes redirectAttributes
							,HttpServletRequest request
							,@PathVariable Long parentId
							,@PathVariable Long childId){
		Navigation navigation = navigationService.findById(childId);
		portalDefaultInformation.setPublishDate(new Date());
		portalDefaultInformation.setPublicPerson(getCurrentUser(request).getRealName());
		portalDefaultInformation.setNavigation(navigation);
		portalDefaultInformation.setNavigationParentId(parentId.toString());
		portalDefaultInfomationService.save(portalDefaultInformation);
		sendNoticeWhenRedirect(redirectAttributes, "common.add.success");
		return "redirect:/portal/navigation/"+parentId+"/child/"+childId+"/news";
	}
	
	@RequiredPrivilege(value={Privilege.SYSTEM_ACCOUNT})
	@RequestMapping(value="/{parentId}/child/{childId}/news/{id}",method=RequestMethod.PUT)
	public String newUpdate(PortalDefaultInformation portalDefaultInformation
								,RedirectAttributes redirectAttributes
								,HttpServletRequest request
								,@PathVariable Long parentId
								,@PathVariable Long childId
								,@PathVariable Long id){
		PortalDefaultInformation old = portalDefaultInfomationService.findById(id);
		old.setContent(portalDefaultInformation.getContent());
		old.setTitle(portalDefaultInformation.getTitle());
		portalDefaultInfomationService.update(old);
		sendNoticeWhenRedirect(redirectAttributes, "common.update.success");
		return "redirect:/portal/navigation/"+parentId+"/child/"+childId+"/news";
	}
	
	
	
	
}
