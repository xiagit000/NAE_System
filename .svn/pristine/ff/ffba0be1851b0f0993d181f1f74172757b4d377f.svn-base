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
import com.boventech.gplearn.entity.BigSubject;
import com.boventech.gplearn.entity.Grade;
import com.boventech.gplearn.entity.LearnClass;
import com.boventech.gplearn.entity.LearnThesis;
import com.boventech.gplearn.entity.LearnThesisSubmit;
import com.boventech.gplearn.entity.Privilege;
import com.boventech.gplearn.entity.SchoolRoll;
import com.boventech.gplearn.entity.User;
import com.boventech.gplearn.entity.LearnThesisSubmit.LearnThesisRating;
import com.boventech.gplearn.entity.User.UserType;
import com.boventech.gplearn.service.BigSubjectService;
import com.boventech.gplearn.service.GradeService;
import com.boventech.gplearn.service.LearnClassService;
import com.boventech.gplearn.service.LearnThesisService;
import com.boventech.gplearn.service.LearnThesisSubmitInfomationService;
import com.boventech.gplearn.service.SchoolRollService;
import com.google.common.collect.Lists;

@Controller
@RequestMapping(value = "/learnthesissubmit")
public class LearnThesisSubmitController extends ApplicationController {

	@Autowired
	private LearnThesisSubmitInfomationService learnThesisSubmitInfomationService;

	@Autowired
	private LearnThesisService learnThesisService;

	@Autowired
	private LearnClassService learnClassService;

	@Autowired
	private SchoolRollService schoolRollService;
	
	@Autowired
	private GradeService gradeService;
	
	@Autowired
	private BigSubjectService bigSubjectService;

	@RequiredPrivilege(value = { Privilege.STUDENT_LEARNTHSIS_SUBMIT,
			Privilege.TEACHER_LEARNTHESIS })
	@RequestMapping(value = "/show")
	public String show(HttpServletRequest request, Model model, Integer page) {
		User user = (User) request.getSession().getAttribute("currentUser");
		List<LearnThesisSubmit> learnThesisSubmitList = Lists.newArrayList();
		if (user.getUserType().equals(UserType.Student)) {
			learnThesisSubmitList = learnThesisSubmitInfomationService
					.listByStudent(user, page);
		} else {
			learnThesisSubmitList = learnThesisSubmitInfomationService
					.listActiveInfoByTeacherUser(user, page);
		}
		model.addAttribute("learnThesisSubmitList", learnThesisSubmitList);
		return "/role/" + backFolderNameByUserType(user.getUserType())
				+ "/listsubmitlearnthesis";
	}

	@RequiredPrivilege(value = { Privilege.TEACHER_LEARNTHESIS })
	@RequestMapping(value = "/learnthesis/{id}/update")
	public String editforward(@PathVariable Long id, HttpServletRequest request,Integer page,Model model) {
		// 获取当前班级的学员列表
		User user = (User) request.getSession().getAttribute("currentUser");
		LearnClass learnClass = learnClassService.findByTeacher(user);
		List<SchoolRoll> rolls = schoolRollService.listActiveByClassWithPagination(learnClass, page);
		LearnThesis learnThesis = learnThesisService.findById(id);
		if (checkEntityEmpty(learnThesis)) {
			return "error/404";
		}
		List<LearnThesisSubmit> result = Lists.newArrayList();
		for(SchoolRoll schoolRoll : rolls){
			result.add(learnThesisSubmitInfomationService.findByStudentUserAndLearnThesis(schoolRoll.getUser(), learnThesis));
		}
		model.addAttribute("learnThesis", learnThesis);
		model.addAttribute("result",result);
		model.addAttribute("rolls", rolls);
		return "role/teacher/listunsubmitlearnthesis";
	}
	
	@RequiredPrivilege(value = { Privilege.TEACHER_LEARNTHESIS })
	@RequestMapping(value = "/{id}/update")
	public String editUserLearnThesis(@PathVariable Long id,Model model){
		LearnThesisSubmit lts = learnThesisSubmitInfomationService.findById(id);
		if(checkEntityEmpty(lts)){
			return "error/404";
		}
		model.addAttribute("learnThesisSubmit", lts);
		LearnThesisRating[] ratings = LearnThesisRating.values();
		model.addAttribute("ratings", ratings);
		return "role/teacher/updatelearnthesis";
	}
	
	@RequiredPrivilege(value = { Privilege.TEACHER_LEARNTHESIS })
	@RequestMapping(value = "/{id}",method=RequestMethod.POST)
	public String update(@PathVariable Long id,LearnThesisRating learnThesisRating,Double score,HttpServletRequest request,RedirectAttributes redirectAttr){
		User user = (User) request.getSession().getAttribute("currentUser");
		LearnThesisSubmit lts=learnThesisSubmitInfomationService.findById(id);
		if(checkEntityEmpty(lts)){
			return "error/404";
		}
		Grade grade = gradeService.findByUser(lts.getUser());
		//如果不是新添加的分数，而是重新设置的分数，删除上次的评分
		if(lts.getMakingDate()!=null){
			grade.setLearnThesisScore(grade.getLearnThesisScore()-lts.getScore());
		}
		//设置score的准确性
		//1.取出当前研修论文的标准
		Double standard=grade.getScoringStandard().getLearnThesisProportion()*100;
		//2.取出当前班级所属学科班级
		LearnClass learnClass = learnClassService.findByTeacher(user);
		//3.取出当前学科所包含的大主题
		List<BigSubject> bigSubject = bigSubjectService.listWithDisciplineInCurrentBatch(learnClass.getLearnProject().getDiscipline());
		//4.取出大主题下所有研修论文
		List<LearnThesis> learnThesis = learnThesisService.listThesisWithBigSubjects(bigSubject);
		//5.当前研修论文的最大分值
		Double maxSocre=standard/learnThesis.size();
		
		if(score>maxSocre){
			score=maxSocre;
		}
		//更新研修论文提交统计
		lts.setLearnThesisRating(learnThesisRating);
		lts.setScore(score);
		lts.setMakingDate(new Date());
		lts.setTeacher((User)request.getSession().getAttribute("currentUser"));
		learnThesisSubmitInfomationService.update(lts);
		//更新学生的研修成绩
		grade.setLearnThesisScore(grade.getLearnThesisScore()+score);
		gradeService.update(grade);
		sendNoticeWhenRedirect(redirectAttr, "common.update.success");
		return "redirect:/learnthesissubmit/learnthesis/"+lts.getLearnThesis().getId()+"/update";
	}

}
