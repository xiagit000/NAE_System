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
import com.boventech.gplearn.entity.Discipline;
import com.boventech.gplearn.entity.LearnClass;
import com.boventech.gplearn.entity.Privilege;
import com.boventech.gplearn.entity.Question;
import com.boventech.gplearn.entity.SchoolRoll;
import com.boventech.gplearn.entity.User;
import com.boventech.gplearn.entity.User.UserType;
import com.boventech.gplearn.service.DisciplineService;
import com.boventech.gplearn.service.LearnClassService;
import com.boventech.gplearn.service.QuestionService;
import com.boventech.gplearn.service.SchoolRollService;

@Controller
@RequestMapping(value="/question")
public class QuestionController extends ApplicationController {

	@Autowired
	private QuestionService questionService;
	
	@Autowired
	private LearnClassService learnClassService;
	
	@Autowired
	private SchoolRollService schoolRollService;
	
	@Autowired
	private DisciplineService disciplineService;
	
	/**
	 * 我的提问列表
	 * @param request
	 * @param model
	 * @param page
	 * @return
	 */
	@RequiredPrivilege(value={Privilege.STUDENT_USER_ACCOUNT,Privilege.TEACHER_USER_ACCOUNT})
	@RequestMapping(value="/mine")
	public String showMine(HttpServletRequest request,Model model,Integer page){
		User user = (User)request.getSession().getAttribute("currentUser");
		List<Question> questionList = questionService.listByAskerWithPagination(user,page);
		model.addAttribute("questionList", questionList);
		return "role/"+backFolderNameByUserType(user.getUserType())+"/questionlist";
	}
	
	/**
	 * 跳转到提问创建页面
	 * @param request
	 * @return
	 */
	@RequiredPrivilege(value={Privilege.STUDENT_USER_ACCOUNT,Privilege.TEACHER_USER_ACCOUNT})
	@RequestMapping(value="/create")
	public String create(HttpServletRequest request){
		User user = (User)request.getSession().getAttribute("currentUser");
		return "role/"+backFolderNameByUserType(user.getUserType())+"/addquestion";
	}
	
	/**
	 * 保存提问
	 * @param question
	 * @param request
	 * @return
	 */
	@RequiredPrivilege(value={Privilege.STUDENT_USER_ACCOUNT,Privilege.TEACHER_USER_ACCOUNT})
	@RequestMapping(method=RequestMethod.POST)
	public String save(Question question,HttpServletRequest request){
		User user = (User)request.getSession().getAttribute("currentUser");
		question.setAsker(user);
		if(user.getUserType().equals(UserType.Teacher)){
			LearnClass  learnClass = learnClassService.findByTeacher(user);
			question.setDiscipline(learnClass.getLearnProject().getDiscipline());
		}
		else{
			SchoolRoll schoolRoll = schoolRollService.findByUserNewest(user);
			question.setLearnClass(schoolRoll.getLearnClass());
		}
		questionService.save(question);
		return "redirect:/question/mine";
	}
	
	/**
	 * 查看我的提问
	 * @param id
	 * @param model
	 * @param request
	 * @return
	 */
	@RequiredPrivilege(value={Privilege.STUDENT_USER_ACCOUNT,Privilege.TEACHER_USER_ACCOUNT})
	@RequestMapping(value="/{id}")
	public String show(@PathVariable Long id,Model model,HttpServletRequest request){
		User user = (User)request.getSession().getAttribute("currentUser");
		Question quesion = questionService.findById(id);
		if(checkEntityEmpty(quesion)){
			return "error/404";
		}
		model.addAttribute("question",quesion);
		return "role/"+backFolderNameByUserType(user.getUserType())+"/showquestion";
	}
	
	/**
	 * 老师查看学生的提问列表
	 * @param request
	 * @param model
	 * @param page
	 * @return
	 */
	@RequiredPrivilege(value={Privilege.TEACHER_USER_ACCOUNT,Privilege.SUBJECT_USER_ACCOUNT})
	@RequestMapping
	public String showStudentQuestion(HttpServletRequest request,Model model,Integer page){
		User user = (User)request.getSession().getAttribute("currentUser");
		List<Question> questions=null;
		//如果是老师
		if(user.getUserType().equals(UserType.Teacher)){
			LearnClass learnClass = learnClassService.findByTeacher(user);
			questions = questionService.listWithPaginationBylearnClass(learnClass,page);
		}
		//如果是学科专家
		else{
			Discipline discipline  = disciplineService.findByPersonIncharge(user);
			questions= questionService.listwithPaginationByDiscipline(discipline,page);
		}
		model.addAttribute("questions", questions);
		return "role/"+backFolderNameByUserType(user.getUserType())+"/studentquestionlist";
	}
	
	/**
	 * 跳转到解答问题的页面
	 * @param id
	 * @param request
	 * @param model
	 * @return
	 */
	@RequiredPrivilege(value={Privilege.TEACHER_USER_ACCOUNT,Privilege.SUBJECT_USER_ACCOUNT})
	@RequestMapping(value="/{id}/resolve")
	public String resolveForwardQuestion(@PathVariable Long id,HttpServletRequest request,Model model){
		User user = (User)request.getSession().getAttribute("currentUser");
		Question question = questionService.findById(id);
		if(checkEntityEmpty(question)){
			return "error/404";
		}
		model.addAttribute("question", question);
		return "role/"+backFolderNameByUserType(user.getUserType())+"/answerstudentquestions";
	}
	
	/**
	 * 解答问题
	 * @param question
	 * @param request
	 * @param redirect
	 * @return
	 */
	@RequiredPrivilege(value={Privilege.TEACHER_USER_ACCOUNT,Privilege.SUBJECT_USER_ACCOUNT})
	@RequestMapping(value="/{id}/resolve",method=RequestMethod.POST)
	public String resolveQuestion(@PathVariable Long id,Question question,HttpServletRequest request,RedirectAttributes redirect){
		User user  = (User)request.getSession().getAttribute("currentUser");
		Question oldQuestion =questionService.findById(id);
		if(checkEntityEmpty(oldQuestion)){
			return "error/404";
		}
		oldQuestion.setAnswerContent(question.getAnswerContent());
		oldQuestion.setResolver(user);
		oldQuestion.setResolved(true);
		questionService.update(oldQuestion);
		return "redirect:/question";
	}
	
	/**
	 * 查看我的提问
	 * @param id
	 * @param model
	 * @param request
	 * @return
	 */
	@RequiredPrivilege(value={Privilege.STUDENT_USER_ACCOUNT,Privilege.TEACHER_USER_ACCOUNT})
	@RequestMapping(value="/{id}/resolved")
	public String showResolved(@PathVariable Long id,Model model,HttpServletRequest request){
		User user = (User)request.getSession().getAttribute("currentUser");
		Question quesion = questionService.findById(id);
		if(checkEntityEmpty(quesion)){
			return "error/404";
		}
		model.addAttribute("question",quesion);
		return "role/"+backFolderNameByUserType(user.getUserType())+"/showstudentquestion";
	}
	
	
}
