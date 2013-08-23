package com.boventech.gplearn.controller;

import java.io.File;
import java.util.Date;
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
import com.boventech.gplearn.entity.Constants;
import com.boventech.gplearn.entity.PortalDefaultInformation;
import com.boventech.gplearn.entity.PortalDefaultType;
import com.boventech.gplearn.entity.Privilege;
import com.boventech.gplearn.service.PortalDefaultInfomationService;

@Controller
@RequestMapping(value="/portalinfo")
public class PortalInformationController extends ApplicationController {

	private static final Logger logger = LoggerFactory.getLogger(PortalInformationController.class);
	
	@Autowired
	private PortalDefaultInfomationService portalDefaultInfomationService;
	
	/*****************************************后台页面控制器************************************************/
	
	/////////////////////////////////////////通知公告管理///////////////////////////////////
	@RequiredPrivilege(value={Privilege.SYSTEM_ACCOUNT})
	@RequestMapping(value="/backstage/noticeinfo")
	public String noticeIndex(Integer page,Model model,HttpServletRequest request){
		setSiteBarActive("mh", "notice",request);
		List<PortalDefaultInformation> list = portalDefaultInfomationService.listByPortalDefaultTypeWithPagination(PortalDefaultType.NOTICE, page);
		model.addAttribute("list", list);
		return "portal/backstage/notice/index";
	}
	
	@RequiredPrivilege(value={Privilege.SYSTEM_ACCOUNT})
	@RequestMapping(value="/backstage/noticeinfo/create")
	public String noticeCreate(){
		return "portal/backstage/notice/create";
	}
	
	@RequiredPrivilege(value={Privilege.SYSTEM_ACCOUNT})
	@RequestMapping(value="/backstage/noticeinfo/{id}/update")
	public String noticeEdit(@PathVariable Long id,Model model){
		PortalDefaultInformation portalDefaultInformation  = portalDefaultInfomationService.findById(id);
		if(checkEntityEmpty(portalDefaultInformation)){
			return "error/404";
		}
		model.addAttribute("portalDefaultInformation", portalDefaultInformation);
		return "portal/backstage/notice/update";
	}
	
	@RequiredPrivilege(value={Privilege.SYSTEM_ACCOUNT})
	@RequestMapping(value="/backstage/noticeinfo",method=RequestMethod.POST)
	public String noticeSave(PortalDefaultInformation portalDefaultInformation
								,RedirectAttributes redirectAttributes
								,HttpServletRequest request){
		portalDefaultInformation.setPublishDate(new Date());
		portalDefaultInformation.setPublicPerson(getCurrentUser(request).getRealName());
		save(PortalDefaultType.NOTICE, portalDefaultInformation);
		sendNoticeWhenRedirect(redirectAttributes, "common.add.success");
		return "redirect:/portalinfo/backstage/noticeinfo";
	}
	
	@RequiredPrivilege(value={Privilege.SYSTEM_ACCOUNT})
	@RequestMapping(value="/backstage/noticeinfo/{id}",method=RequestMethod.PUT)
	public String noticeUpdate(PortalDefaultInformation portalDefaultInformation
								,RedirectAttributes redirectAttributes
								,@PathVariable Long id){
		PortalDefaultInformation old  = portalDefaultInfomationService.findById(id);
		if(checkEntityEmpty(old)){
			return "error/404";
		}
		old.setContent(portalDefaultInformation.getContent());
		old.setTitle(portalDefaultInformation.getTitle());
		portalDefaultInfomationService.update(old);
		sendNoticeWhenRedirect(redirectAttributes, "common.update.success");
		return "redirect:/portalinfo/backstage/noticeinfo";
	}
	
	/////////////////////////////////////////通知公告管理 END///////////////////////////////////
	
	
	
	/////////////////////////////////////////图片墙新闻管理///////////////////////////////////
	@RequiredPrivilege(value={Privilege.SYSTEM_ACCOUNT})
	@RequestMapping(value="/backstage/imagewall")
	public String imageWallIndex(Integer page,Model model,HttpServletRequest request){
		setSiteBarActive("mh", "imagewall",request);
		List<PortalDefaultInformation> list = portalDefaultInfomationService.listByPortalDefaultTypeWithPagination(PortalDefaultType.IMAGEWALL, page);
		model.addAttribute("list", list);
		return "portal/backstage/imagewall/index";
	}
	
	@RequiredPrivilege(value={Privilege.SYSTEM_ACCOUNT})
	@RequestMapping(value="/backstage/imagewall/create")
	public String imageWallCreate(){
		return "portal/backstage/imagewall/create";
	}
	
	@RequiredPrivilege(value={Privilege.SYSTEM_ACCOUNT})
	@RequestMapping(value="/backstage/imagewall/{id}/update")
	public String imagewallEdit(@PathVariable Long id,Model model){
		PortalDefaultInformation portalDefaultInformation  = portalDefaultInfomationService.findById(id);
		if(checkEntityEmpty(portalDefaultInformation)){
			return "error/404";
		}
		model.addAttribute("portalDefaultInformation", portalDefaultInformation);
		return "portal/backstage/imagewall/update";
	}
	
	@RequiredPrivilege(value={Privilege.SYSTEM_ACCOUNT})
	@RequestMapping(value="/backstage/imagewall",method=RequestMethod.POST)
	public String imagewallSave(PortalDefaultInformation portalDefaultInformation
								,RedirectAttributes redirectAttributes
								,HttpServletRequest request
								,MultipartFile file
								,Model model){
		Long size=file.getSize();
		if(size<=0){
			sendErrorMessage(model, "upload.learnthesis.file.null");
			model.addAttribute("portalDefaultInformation", portalDefaultInformation);
			return "portal/backstage/imagewall/create";
		}
		if((size/1024/1024)>20){
			sendErrorMessage(model,"upload.size.outofrange");
			model.addAttribute("portalDefaultInformation", portalDefaultInformation);
			return "portal/backstage/imagewall/create";
		}
		//生成路径
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
				portalDefaultInformation.setPublishDate(new Date());
				portalDefaultInformation.setPublicPerson(getCurrentUser(request).getRealName());
				portalDefaultInformation.setImagePath(fileName);
				save(PortalDefaultType.IMAGEWALL, portalDefaultInformation);
				sendNoticeWhenRedirect(redirectAttributes, "common.add.success");
				return "redirect:/portalinfo/backstage/imagewall";
			}
			catch (Exception e) {
				logger.error(e.getMessage());
				sendErrorMessage(model,"file.upload.faild");
				model.addAttribute("portalDefaultInformation", portalDefaultInformation);
			}
		}
		return "portal/backstage/imagewall/create";
	}
	
	@RequiredPrivilege(value={Privilege.SYSTEM_ACCOUNT})
	@RequestMapping(value="/backstage/imagewall/{id}",method=RequestMethod.POST)
	public String imagewallUpdate(PortalDefaultInformation portalDefaultInformation
								,RedirectAttributes redirectAttributes
								,@PathVariable Long id
								,MultipartFile file
								,Model model
								,HttpServletRequest request){
		PortalDefaultInformation old  = portalDefaultInfomationService.findById(id);
		if(checkEntityEmpty(old)){
			return "error/404";
		}
		Long size=file.getSize();
		if((size/1024/1024)>20){
			sendErrorMessage(model,"upload.size.outofrange");
			model.addAttribute("portalDefaultInformation", portalDefaultInformation);
			return "portal/backstage/imagewall/update";
		}
		if(size!=0){
			
			//生成新的图片文件
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
					//删除原有的图片
					String oldPath = old.getImagePath();
					File oldFile = new File(oldPath);
					oldFile.deleteOnExit();
					//设置新的图片路径
					old.setImagePath(fileName);
					
				}
				catch (Exception e) {
					sendErrorMessage(model,"file.upload.faild");
					model.addAttribute("portalDefaultInformation", portalDefaultInformation);
					return "portal/backstage/imagewall/update";
				}
			}
		}
		old.setContent(portalDefaultInformation.getContent());
		old.setTitle(portalDefaultInformation.getTitle());
		portalDefaultInfomationService.update(old);
		sendNoticeWhenRedirect(redirectAttributes, "common.update.success");
		return "redirect:/portalinfo/backstage/imagewall";
	}
	

	//###########################################图片墙新闻管理 END!##############################/
	
	//###########################################国培计划管理##############################/
	
	@RequiredPrivilege(value={Privilege.SYSTEM_ACCOUNT})
	@RequestMapping(value="/backstage/gp")
	public String gpIndex(Integer page,Model model,HttpServletRequest request){
		setSiteBarActive("mh", "gpplan",request);
		List<PortalDefaultInformation> list = portalDefaultInfomationService.listByPortalDefaultTypeWithPagination(PortalDefaultType.GPPLAN, page);
		model.addAttribute("list", list);
		return "portal/backstage/gp/index";
	}
	
	@RequiredPrivilege(value={Privilege.SYSTEM_ACCOUNT})
	@RequestMapping(value="/backstage/gp/create")
	public String gpCreate(){
		return "portal/backstage/gp/create";
	}
	
	@RequiredPrivilege(value={Privilege.SYSTEM_ACCOUNT})
	@RequestMapping(value="/backstage/gp/{id}/update")
	public String gpEdit(@PathVariable Long id,Model model){
		PortalDefaultInformation portalDefaultInformation  = portalDefaultInfomationService.findById(id);
		if(checkEntityEmpty(portalDefaultInformation)){
			return "error/404";
		}
		model.addAttribute("portalDefaultInformation", portalDefaultInformation);
		return "portal/backstage/gp/update";
	}
	
	@RequiredPrivilege(value={Privilege.SYSTEM_ACCOUNT})
	@RequestMapping(value="/backstage/gp",method=RequestMethod.POST)
	public String gpSave(PortalDefaultInformation portalDefaultInformation
								,RedirectAttributes redirectAttributes
								,HttpServletRequest request){
		portalDefaultInformation.setPublishDate(new Date());
		portalDefaultInformation.setPublicPerson(getCurrentUser(request).getRealName());
		save(PortalDefaultType.GPPLAN, portalDefaultInformation);
		sendNoticeWhenRedirect(redirectAttributes, "common.add.success");
		return "redirect:/portalinfo/backstage/gp";
	}
	
	@RequiredPrivilege(value={Privilege.SYSTEM_ACCOUNT})
	@RequestMapping(value="/backstage/gp/{id}",method=RequestMethod.PUT)
	public String gpUpdate(PortalDefaultInformation portalDefaultInformation
								,RedirectAttributes redirectAttributes
								,@PathVariable Long id){
		PortalDefaultInformation old  = portalDefaultInfomationService.findById(id);
		if(checkEntityEmpty(old)){
			return "error/404";
		}
		old.setContent(portalDefaultInformation.getContent());
		old.setTitle(portalDefaultInformation.getTitle());
		portalDefaultInfomationService.update(old);
		sendNoticeWhenRedirect(redirectAttributes, "common.update.success");
		return "redirect:/portalinfo/backstage/gp";
	}
	
	//###########################################国培计划管理 END!##############################/	
	
	
	//###########################################经典问题管理##############################/
	
	@RequiredPrivilege(value={Privilege.SYSTEM_ACCOUNT})
	@RequestMapping(value="/backstage/hotquestion")
	public String hotquestionIndex(Integer page,Model model,HttpServletRequest request){
		setSiteBarActive("mh", "hotquestion",request);
		List<PortalDefaultInformation> list = portalDefaultInfomationService.listByPortalDefaultTypeWithPagination(PortalDefaultType.HOTQUESTION, page);
		model.addAttribute("list", list);
		return "portal/backstage/hotquestion/index";
	}
	
	@RequiredPrivilege(value={Privilege.SYSTEM_ACCOUNT})
	@RequestMapping(value="/backstage/hotquestion/create")
	public String hotquestionCreate(){
		return "portal/backstage/hotquestion/create";
	}
	
	@RequiredPrivilege(value={Privilege.SYSTEM_ACCOUNT})
	@RequestMapping(value="/backstage/hotquestion/{id}/update")
	public String hotquestionEdit(@PathVariable Long id,Model model){
		PortalDefaultInformation portalDefaultInformation  = portalDefaultInfomationService.findById(id);
		if(checkEntityEmpty(portalDefaultInformation)){
			return "error/404";
		}
		model.addAttribute("portalDefaultInformation", portalDefaultInformation);
		return "portal/backstage/hotquestion/update";
	}
	
	@RequiredPrivilege(value={Privilege.SYSTEM_ACCOUNT})
	@RequestMapping(value="/backstage/hotquestion",method=RequestMethod.POST)
	public String hotquestionSave(PortalDefaultInformation portalDefaultInformation
								,RedirectAttributes redirectAttributes
								,HttpServletRequest request){
		portalDefaultInformation.setPublishDate(new Date());
		portalDefaultInformation.setPublicPerson(getCurrentUser(request).getRealName());
		save(PortalDefaultType.HOTQUESTION, portalDefaultInformation);
		sendNoticeWhenRedirect(redirectAttributes, "common.add.success");
		return "redirect:/portalinfo/backstage/hotquestion";
	}
	
	@RequiredPrivilege(value={Privilege.SYSTEM_ACCOUNT})
	@RequestMapping(value="/backstage/hotquestion/{id}",method=RequestMethod.PUT)
	public String hotquestionUpdate(PortalDefaultInformation portalDefaultInformation
								,RedirectAttributes redirectAttributes
								,@PathVariable Long id){
		PortalDefaultInformation old  = portalDefaultInfomationService.findById(id);
		if(checkEntityEmpty(old)){
			return "error/404";
		}
		old.setContent(portalDefaultInformation.getContent());
		old.setTitle(portalDefaultInformation.getTitle());
		portalDefaultInfomationService.update(old);
		sendNoticeWhenRedirect(redirectAttributes, "common.update.success");
		return "redirect:/portalinfo/backstage/hotquestion";
	}
	
	//###########################################经典问题管理END！##############################/

	//###########################################教师风采管理##############################/
	
	@RequiredPrivilege(value={Privilege.SYSTEM_ACCOUNT})
	@RequestMapping(value="/backstage/teachershow")
	public String teachershowIndex(Integer page,Model model,HttpServletRequest request){
		setSiteBarActive("mh", "teachershow",request);
		List<PortalDefaultInformation> list = portalDefaultInfomationService.listByPortalDefaultTypeWithPagination(PortalDefaultType.TEACHERSHOW, page);
		model.addAttribute("list", list);
		return "portal/backstage/teachershow/index";
	}
	
	@RequiredPrivilege(value={Privilege.SYSTEM_ACCOUNT})
	@RequestMapping(value="/backstage/teachershow/create")
	public String teachershowCreate(){
		return "portal/backstage/teachershow/create";
	}
	
	@RequiredPrivilege(value={Privilege.SYSTEM_ACCOUNT})
	@RequestMapping(value="/backstage/teachershow/{id}/update")
	public String teachershowEdit(@PathVariable Long id,Model model){
		PortalDefaultInformation portalDefaultInformation  = portalDefaultInfomationService.findById(id);
		if(checkEntityEmpty(portalDefaultInformation)){
			return "error/404";
		}
		model.addAttribute("portalDefaultInformation", portalDefaultInformation);
		return "portal/backstage/teachershow/update";
	}
	
	@RequiredPrivilege(value={Privilege.SYSTEM_ACCOUNT})
	@RequestMapping(value="/backstage/teachershow",method=RequestMethod.POST)
	public String teachershowSave(PortalDefaultInformation portalDefaultInformation
								,RedirectAttributes redirectAttributes
								,HttpServletRequest request
								,MultipartFile file
								,Model model){
		Long size=file.getSize();
		if(size<=0){
			sendErrorMessage(model, "upload.learnthesis.file.null");
			model.addAttribute("portalDefaultInformation", portalDefaultInformation);
			return "portal/backstage/teachershow/create";
		}
		if((size/1024/1024)>20){
			sendErrorMessage(model,"upload.size.outofrange");
			model.addAttribute("portalDefaultInformation", portalDefaultInformation);
			return "portal/backstage/teachershow/create";
		}
		//生成路径
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
				portalDefaultInformation.setPublishDate(new Date());
				portalDefaultInformation.setPublicPerson(getCurrentUser(request).getRealName());
				portalDefaultInformation.setImagePath(fileName);
				save(PortalDefaultType.TEACHERSHOW, portalDefaultInformation);
				sendNoticeWhenRedirect(redirectAttributes, "common.add.success");
			}
			catch (Exception e) {
				logger.error(e.getMessage());
				sendErrorMessage(model,"file.upload.faild");
				model.addAttribute("portalDefaultInformation", portalDefaultInformation);
				return "portal/backstage/teachershow/create";
			}
		}
		
		return "redirect:/portalinfo/backstage/teachershow";
	}
	
	@RequiredPrivilege(value={Privilege.SYSTEM_ACCOUNT})
	@RequestMapping(value="/backstage/teachershow/{id}",method=RequestMethod.POST)
	public String teachershowUpdate(PortalDefaultInformation portalDefaultInformation
								,RedirectAttributes redirectAttributes
								,@PathVariable Long id
								,MultipartFile file
								,Model model
								,HttpServletRequest request){
		PortalDefaultInformation old  = portalDefaultInfomationService.findById(id);
		if(checkEntityEmpty(old)){
			return "error/404";
		}
		Long size=file.getSize();
		if((size/1024/1024)>20){
			sendErrorMessage(model,"upload.size.outofrange");
			model.addAttribute("portalDefaultInformation", portalDefaultInformation);
			return "portal/backstage/teachershow/update";
		}
		if(size!=0){
			
			//生成新的图片文件
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
					//删除原有的图片
					String oldPath = old.getImagePath();
					File oldFile = new File(oldPath);
					oldFile.deleteOnExit();
					//设置新的图片路径
					old.setImagePath(fileName);
				}
				catch (Exception e) {
					sendErrorMessage(model,"file.upload.faild");
					model.addAttribute("portalDefaultInformation", portalDefaultInformation);
					return "portal/backstage/teachershow/update";
				}
			}
		}
		old.setContent(portalDefaultInformation.getContent());
		old.setTitle(portalDefaultInformation.getTitle());
		portalDefaultInfomationService.update(old);
		sendNoticeWhenRedirect(redirectAttributes, "common.update.success");
		return "redirect:/portalinfo/backstage/teachershow";
		
	}
	
	//###########################################教师风采管理END！##############################/

	
	//###########################################招生服务信息管理##############################/
	
	@RequiredPrivilege(value={Privilege.SYSTEM_ACCOUNT})
	@RequestMapping(value="/backstage/recruitinfo")
	public String recruitinfoIndex(Integer page,Model model,HttpServletRequest request){
		setSiteBarActive("mh", "recruitinfo",request);
		List<PortalDefaultInformation> list = portalDefaultInfomationService.listByPortalDefaultTypeWithPagination(PortalDefaultType.RECRUITINFO, page);
		model.addAttribute("list", list);
		return "portal/backstage/recruitinfo/index";
	}
	
	@RequiredPrivilege(value={Privilege.SYSTEM_ACCOUNT})
	@RequestMapping(value="/backstage/recruitinfo/create")
	public String recruitinfoCreate(){
		return "portal/backstage/recruitinfo/create";
	}
	
	@RequiredPrivilege(value={Privilege.SYSTEM_ACCOUNT})
	@RequestMapping(value="/backstage/recruitinfo/{id}/update")
	public String recruitinfoEdit(@PathVariable Long id,Model model){
		PortalDefaultInformation portalDefaultInformation  = portalDefaultInfomationService.findById(id);
		if(checkEntityEmpty(portalDefaultInformation)){
			return "error/404";
		}
		model.addAttribute("portalDefaultInformation", portalDefaultInformation);
		return "portal/backstage/recruitinfo/update";
	}
	
	@RequiredPrivilege(value={Privilege.SYSTEM_ACCOUNT})
	@RequestMapping(value="/backstage/recruitinfo",method=RequestMethod.POST)
	public String recruitinfoSave(PortalDefaultInformation portalDefaultInformation
								,RedirectAttributes redirectAttributes
								,HttpServletRequest request){
		portalDefaultInformation.setPublishDate(new Date());
		portalDefaultInformation.setPublicPerson(getCurrentUser(request).getRealName());
		save(PortalDefaultType.RECRUITINFO, portalDefaultInformation);
		sendNoticeWhenRedirect(redirectAttributes, "common.add.success");
		return "redirect:/portalinfo/backstage/recruitinfo";
	}
	
	@RequiredPrivilege(value={Privilege.SYSTEM_ACCOUNT})
	@RequestMapping(value="/backstage/recruitinfo/{id}",method=RequestMethod.PUT)
	public String recruitinfoUpdate(PortalDefaultInformation portalDefaultInformation
								,RedirectAttributes redirectAttributes
								,@PathVariable Long id){
		PortalDefaultInformation old  = portalDefaultInfomationService.findById(id);
		if(checkEntityEmpty(old)){
			return "error/404";
		}
		old.setContent(portalDefaultInformation.getContent());
		old.setTitle(portalDefaultInformation.getTitle());
		portalDefaultInfomationService.update(old);
		sendNoticeWhenRedirect(redirectAttributes, "common.update.success");
		return "redirect:/portalinfo/backstage/recruitinfo";
	}
	
	//###########################################招生服务信息管理END！##############################/

	
	//###########################################教学服务信息管理##############################/
	
	@RequiredPrivilege(value={Privilege.SYSTEM_ACCOUNT})
	@RequestMapping(value="/backstage/teachinfo")
	public String teachinfoIndex(Integer page,Model model,HttpServletRequest request){
		setSiteBarActive("mh", "teachinfo",request);
		List<PortalDefaultInformation> list = portalDefaultInfomationService.listByPortalDefaultTypeWithPagination(PortalDefaultType.TEACHINFO, page);
		model.addAttribute("list", list);
		return "portal/backstage/teachinfo/index";
	}
	
	@RequiredPrivilege(value={Privilege.SYSTEM_ACCOUNT})
	@RequestMapping(value="/backstage/teachinfo/create")
	public String teachinfoCreate(){
		return "portal/backstage/teachinfo/create";
	}
	
	@RequiredPrivilege(value={Privilege.SYSTEM_ACCOUNT})
	@RequestMapping(value="/backstage/teachinfo/{id}/update")
	public String teachinfoEdit(@PathVariable Long id,Model model){
		PortalDefaultInformation portalDefaultInformation  = portalDefaultInfomationService.findById(id);
		if(checkEntityEmpty(portalDefaultInformation)){
			return "error/404";
		}
		model.addAttribute("portalDefaultInformation", portalDefaultInformation);
		return "portal/backstage/teachinfo/update";
	}
	
	@RequiredPrivilege(value={Privilege.SYSTEM_ACCOUNT})
	@RequestMapping(value="/backstage/teachinfo",method=RequestMethod.POST)
	public String teachinfoSave(PortalDefaultInformation portalDefaultInformation
								,RedirectAttributes redirectAttributes
								,HttpServletRequest request){
		portalDefaultInformation.setPublishDate(new Date());
		portalDefaultInformation.setPublicPerson(getCurrentUser(request).getRealName());
		save(PortalDefaultType.TEACHINFO, portalDefaultInformation);
		sendNoticeWhenRedirect(redirectAttributes, "common.add.success");
		return "redirect:/portalinfo/backstage/teachinfo";
	}
	
	@RequiredPrivilege(value={Privilege.SYSTEM_ACCOUNT})
	@RequestMapping(value="/backstage/teachinfo/{id}",method=RequestMethod.PUT)
	public String teachinfoUpdate(PortalDefaultInformation portalDefaultInformation
								,RedirectAttributes redirectAttributes
								,@PathVariable Long id){
		PortalDefaultInformation old  = portalDefaultInfomationService.findById(id);
		if(checkEntityEmpty(old)){
			return "error/404";
		}
		old.setContent(portalDefaultInformation.getContent());
		old.setTitle(portalDefaultInformation.getTitle());
		portalDefaultInfomationService.update(old);
		sendNoticeWhenRedirect(redirectAttributes, "common.update.success");
		return "redirect:/portalinfo/backstage/teachinfo";
	}
	
	//###########################################教学服务信息管理END！##############################/

	
	//###########################################学务信息管理##############################/
	
	@RequiredPrivilege(value={Privilege.SYSTEM_ACCOUNT})
	@RequestMapping(value="/backstage/studyinfo")
	public String studyinfoIndex(Integer page,Model model,HttpServletRequest request){
		setSiteBarActive("mh", "studyinfo",request);
		List<PortalDefaultInformation> list = portalDefaultInfomationService.listByPortalDefaultTypeWithPagination(PortalDefaultType.STUDYINFO, page);
		model.addAttribute("list", list);
		return "portal/backstage/studyinfo/index";
	}
	
	@RequiredPrivilege(value={Privilege.SYSTEM_ACCOUNT})
	@RequestMapping(value="/backstage/studyinfo/create")
	public String studyinfoCreate(){
		return "portal/backstage/studyinfo/create";
	}
	
	@RequiredPrivilege(value={Privilege.SYSTEM_ACCOUNT})
	@RequestMapping(value="/backstage/studyinfo/{id}/update")
	public String studyinfoEdit(@PathVariable Long id,Model model){
		PortalDefaultInformation portalDefaultInformation  = portalDefaultInfomationService.findById(id);
		if(checkEntityEmpty(portalDefaultInformation)){
			return "error/404";
		}
		model.addAttribute("portalDefaultInformation", portalDefaultInformation);
		return "portal/backstage/studyinfo/update";
	}
	
	@RequiredPrivilege(value={Privilege.SYSTEM_ACCOUNT})
	@RequestMapping(value="/backstage/studyinfo",method=RequestMethod.POST)
	public String studyinfoSave(PortalDefaultInformation portalDefaultInformation
								,RedirectAttributes redirectAttributes
								,HttpServletRequest request){
		portalDefaultInformation.setPublishDate(new Date());
		portalDefaultInformation.setPublicPerson(getCurrentUser(request).getRealName());
		save(PortalDefaultType.STUDYINFO, portalDefaultInformation);
		sendNoticeWhenRedirect(redirectAttributes, "common.add.success");
		return "redirect:/portalinfo/backstage/studyinfo";
	}
	
	@RequiredPrivilege(value={Privilege.SYSTEM_ACCOUNT})
	@RequestMapping(value="/backstage/studyinfo/{id}",method=RequestMethod.PUT)
	public String studyinfoUpdate(PortalDefaultInformation portalDefaultInformation
								,RedirectAttributes redirectAttributes
								,@PathVariable Long id){
		PortalDefaultInformation old  = portalDefaultInfomationService.findById(id);
		if(checkEntityEmpty(old)){
			return "error/404";
		}
		old.setContent(portalDefaultInformation.getContent());
		old.setTitle(portalDefaultInformation.getTitle());
		portalDefaultInfomationService.update(old);
		sendNoticeWhenRedirect(redirectAttributes, "common.update.success");
		return "redirect:/portalinfo/backstage/studyinfo";
	}
	
	//###########################################学务信息管理END！##############################/

	//###########################################培训感言管理##############################/
	

	@RequiredPrivilege(value={Privilege.SYSTEM_ACCOUNT})
	@RequestMapping(value="/backstage/studythanks")
	public String studythanksIndex(Integer page,Model model,HttpServletRequest request){
		setSiteBarActive("mh", "studythanks",request);
		List<PortalDefaultInformation> list = portalDefaultInfomationService.listByPortalDefaultTypeWithPagination(PortalDefaultType.STUDYTHANKS, page);
		model.addAttribute("list", list);
		return "portal/backstage/studythanks/index";
	}
	
	@RequiredPrivilege(value={Privilege.SYSTEM_ACCOUNT})
	@RequestMapping(value="/backstage/studythanks/create")
	public String studythanksCreate(){
		return "portal/backstage/studythanks/create";
	}
	
	@RequiredPrivilege(value={Privilege.SYSTEM_ACCOUNT})
	@RequestMapping(value="/backstage/studythanks/{id}/update")
	public String studythanksEdit(@PathVariable Long id,Model model){
		PortalDefaultInformation portalDefaultInformation  = portalDefaultInfomationService.findById(id);
		if(checkEntityEmpty(portalDefaultInformation)){
			return "error/404";
		}
		model.addAttribute("portalDefaultInformation", portalDefaultInformation);
		return "portal/backstage/studythanks/update";
	}
	
	@RequiredPrivilege(value={Privilege.SYSTEM_ACCOUNT})
	@RequestMapping(value="/backstage/studythanks",method=RequestMethod.POST)
	public String studythanksSave(PortalDefaultInformation portalDefaultInformation
								,RedirectAttributes redirectAttributes
								,HttpServletRequest request){
		portalDefaultInformation.setPublishDate(new Date());
		portalDefaultInformation.setPublicPerson(getCurrentUser(request).getRealName());
		save(PortalDefaultType.STUDYTHANKS, portalDefaultInformation);
		sendNoticeWhenRedirect(redirectAttributes, "common.add.success");
		return "redirect:/portalinfo/backstage/studythanks";
	}
	
	@RequiredPrivilege(value={Privilege.SYSTEM_ACCOUNT})
	@RequestMapping(value="/backstage/studythanks/{id}",method=RequestMethod.PUT)
	public String studythanksUpdate(PortalDefaultInformation portalDefaultInformation
								,RedirectAttributes redirectAttributes
								,@PathVariable Long id){
		PortalDefaultInformation old  = portalDefaultInfomationService.findById(id);
		if(checkEntityEmpty(old)){
			return "error/404";
		}
		old.setContent(portalDefaultInformation.getContent());
		old.setTitle(portalDefaultInformation.getTitle());
		portalDefaultInfomationService.update(old);
		sendNoticeWhenRedirect(redirectAttributes, "common.update.success");
		return "redirect:/portalinfo/backstage/studythanks";
	}
	
	//###########################################培训感言管理END！##############################/

	//###########################################图文资讯管理##############################/
	

	@RequiredPrivilege(value={Privilege.SYSTEM_ACCOUNT})
	@RequestMapping(value="/backstage/imagecontent")
	public String imagecontentIndex(Integer page,Model model,HttpServletRequest request){
		setSiteBarActive("mh", "imagecontent",request);
		List<PortalDefaultInformation> list = portalDefaultInfomationService.listByPortalDefaultTypeWithPagination(PortalDefaultType.IMAGECONTENT, page);
		model.addAttribute("list", list);
		return "portal/backstage/imagecontent/index";
	}
	
	@RequiredPrivilege(value={Privilege.SYSTEM_ACCOUNT})
	@RequestMapping(value="/backstage/imagecontent/create")
	public String imagecontentCreate(){
		return "portal/backstage/imagecontent/create";
	}
	
	@RequiredPrivilege(value={Privilege.SYSTEM_ACCOUNT})
	@RequestMapping(value="/backstage/imagecontent/{id}/update")
	public String imagecontentEdit(@PathVariable Long id,Model model){
		PortalDefaultInformation portalDefaultInformation  = portalDefaultInfomationService.findById(id);
		if(checkEntityEmpty(portalDefaultInformation)){
			return "error/404";
		}
		model.addAttribute("portalDefaultInformation", portalDefaultInformation);
		return "portal/backstage/imagecontent/update";
	}
	
	@RequiredPrivilege(value={Privilege.SYSTEM_ACCOUNT})
	@RequestMapping(value="/backstage/imagecontent",method=RequestMethod.POST)
	public String imagecontentSave(PortalDefaultInformation portalDefaultInformation
								,RedirectAttributes redirectAttributes
								,HttpServletRequest request
								,MultipartFile file
								,Model model){
		Long size=file.getSize();
		if(size<=0){
			sendErrorMessage(model, "upload.learnthesis.file.null");
			model.addAttribute("portalDefaultInformation", portalDefaultInformation);
			return "portal/backstage/imagecontent/create";
		}
		if((size/1024/1024)>20){
			sendErrorMessage(model,"upload.size.outofrange");
			model.addAttribute("portalDefaultInformation", portalDefaultInformation);
			return "portal/backstage/imagecontent/create";
		}
		//生成路径
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
				portalDefaultInformation.setPublishDate(new Date());
				portalDefaultInformation.setPublicPerson(getCurrentUser(request).getRealName());
				portalDefaultInformation.setImagePath(fileName);
				save(PortalDefaultType.IMAGECONTENT, portalDefaultInformation);
				sendNoticeWhenRedirect(redirectAttributes, "common.add.success");
				
			}
			catch (Exception e) {
				logger.error(e.getMessage());
				sendErrorMessage(model,"file.upload.faild");
				model.addAttribute("portalDefaultInformation", portalDefaultInformation);
				return "portal/backstage/imagecontent/create";
			}
		}
		return "redirect:/portalinfo/backstage/imagecontent";
		
	}
	
	@RequiredPrivilege(value={Privilege.SYSTEM_ACCOUNT})
	@RequestMapping(value="/backstage/imagecontent/{id}",method=RequestMethod.POST)
	public String imagecontentUpdate(PortalDefaultInformation portalDefaultInformation
								,RedirectAttributes redirectAttributes
								,@PathVariable Long id
								,MultipartFile file
								,Model model
								,HttpServletRequest request){
		PortalDefaultInformation old  = portalDefaultInfomationService.findById(id);
		if(checkEntityEmpty(old)){
			return "error/404";
		}
		Long size=file.getSize();
		if((size/1024/1024)>20){
			sendErrorMessage(model,"upload.size.outofrange");
			model.addAttribute("portalDefaultInformation", portalDefaultInformation);
			return "portal/backstage/imagecontent/update";
		}
		if(size!=0){
			
			//生成新的图片文件
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
					//删除原有的图片
					String oldPath = old.getImagePath();
					File oldFile = new File(oldPath);
					oldFile.deleteOnExit();
					//设置新的图片路径
					old.setImagePath(fileName);
				}
				catch (Exception e) {
					sendErrorMessage(model,"file.upload.faild");
					model.addAttribute("portalDefaultInformation", portalDefaultInformation);
					return "portal/backstage/imagecontent/update";
				}
			}
		}
		old.setContent(portalDefaultInformation.getContent());
		old.setTitle(portalDefaultInformation.getTitle());
		portalDefaultInfomationService.update(old);
		sendNoticeWhenRedirect(redirectAttributes, "common.update.success");
		
		return "redirect:/portalinfo/backstage/imagecontent";
		
	}
	//###########################################图文资讯管理END！##############################/

	
	
	
	
	
	
	/*****************************************前台页面控制器************************************************/
	
	@RequiredPrivilege(value={Privilege.SYSTEM_ACCOUNT})
	@RequestMapping(value="/{id}")
	public String show(@PathVariable Long id,Model model){
		PortalDefaultInformation portalDefaultInformation = portalDefaultInfomationService.findById(id);
		if(checkEntityEmpty(portalDefaultInformation)){
			return "error/404";
		}
		model.addAttribute("portalDefaultInformation", portalDefaultInformation);
		return "portal/backstage/show";
	}
	
	@RequiredPrivilege(value={Privilege.SYSTEM_ACCOUNT})
	@RequestMapping(value="/{id}",method=RequestMethod.DELETE)
	public String delete(@PathVariable Long id){
		PortalDefaultInformation portalDefaultInformation = portalDefaultInfomationService.findById(id);
		portalDefaultInfomationService.delete(id);
		return "redirect:/portalinfo/backstage/"+getFromFolderByPortalDefaultType(portalDefaultInformation.getProNoticeType());
	}
	
	
	private String getFromFolderByPortalDefaultType(PortalDefaultType portalDefaultType){
		if(portalDefaultType.equals(PortalDefaultType.GPPLAN)){
			return "gp";
		}
		if(portalDefaultType.equals(PortalDefaultType.NOTICE)){
			return "noticeinfo";
		}
		return portalDefaultType.toString().toLowerCase();
	}
	
	
	
	//########################################## COMMON ##############################/
	private void save(PortalDefaultType portalDefaultType,PortalDefaultInformation portalDefaultInformation){
		portalDefaultInformation.setProNoticeType(portalDefaultType);
		portalDefaultInfomationService.save(portalDefaultInformation);
	}
	
	
	
	
}
