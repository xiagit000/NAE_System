package com.boventech.gplearn.service.impl;

import java.io.File;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.boventech.gplearn.dao.LearnThesisSubmitInformationDao;
import com.boventech.gplearn.entity.Attachment;
import com.boventech.gplearn.entity.Constants;
import com.boventech.gplearn.entity.Grade;
import com.boventech.gplearn.entity.LearnThesis;
import com.boventech.gplearn.entity.LearnThesisSubmit;
import com.boventech.gplearn.entity.SchoolRoll;
import com.boventech.gplearn.entity.User;
import com.boventech.gplearn.service.AttachmentService;
import com.boventech.gplearn.service.GradeService;
import com.boventech.gplearn.service.LearnThesisSubmitInfomationService;
import com.boventech.gplearn.service.SchoolRollService;
import com.google.common.collect.Lists;

@Service
@Transactional
public class LearnThesisSubmitInformationServiceImpl implements
		LearnThesisSubmitInfomationService {
	
	@Autowired
	private LearnThesisSubmitInformationDao learnThesisSubmitInformationDao;
	
	@Autowired
	private AttachmentService attachmentService;
	
	@Autowired
	private GradeService gradeService;

	@Autowired
	private SchoolRollService schoolRollService;
	
	@Override
	public void delete(LearnThesisSubmit t) {
		learnThesisSubmitInformationDao.delete(t);
	}

	@Override
	public void delete(Long id) {
		learnThesisSubmitInformationDao.deleteById(id);
	}

	@Override
	public LearnThesisSubmit findById(Long id) {
		return learnThesisSubmitInformationDao.findByID(id);
	}

	@Override
	public void save(LearnThesisSubmit t) {
		learnThesisSubmitInformationDao.save(t);
	}

	@Override
	public void update(LearnThesisSubmit t) {
		learnThesisSubmitInformationDao.update(t);
	}

	@Override
	public LearnThesisSubmit findByStudentUserAndLearnThesis(User currentStudent,
			LearnThesis learnThesis) {
		return learnThesisSubmitInformationDao.findByStudentUserAndLearnThesis(currentStudent, learnThesis);
		
	}

	@Override
	public List<LearnThesisSubmit> listActiveInfoByStudentUser(User currentStudent) {
		return learnThesisSubmitInformationDao.listActiveInfoByStudentUser(currentStudent);
	}

	@Override
	public List<LearnThesisSubmit> listActiveInfoByTeacherUser(User currentTeacher, Integer page) {
		return learnThesisSubmitInformationDao.listActiveInfoByTeacherUser(currentTeacher,page);
	}
	
	

	@Override
	public void saveLearnThesisSubmitInformation(LearnThesis learnThesis,
			User currentStudent,String fileName) {
		//判断是否已经提交过论文了
		LearnThesisSubmit lt = learnThesisSubmitInformationDao.findByStudentUserAndLearnThesis(currentStudent, learnThesis);
		if(lt!=null){
			//清除已加的得分
			Grade grade=gradeService.findByUser(lt.getUser());
			grade.setLearnThesisScore(grade.getLearnThesisScore()-lt.getScore());
			gradeService.update(grade);
			//将已有的记录设置为非最新作业
			lt.setNewest(false);
			update(lt);
		}
		LearnThesisSubmit lts = new LearnThesisSubmit();
		lts.setLearnThesis(learnThesis);
		lts.setUser(currentStudent);
		lts.setSubmitDate(new Date());
		//获取当前学生的班级
		SchoolRoll schoolRoll = schoolRollService.findByUserNewest(currentStudent);
		lts.setLearnClassId(schoolRoll.getLearnClass().getId());
		Attachment attchment = new Attachment();
		attchment.setFileName(fileName);
		attchment.setFilePath(File.separator+Constants.DEFAULT_UPLOAD_PATH+File.separator+fileName);
		attachmentService.save(attchment);
		Attachment savedAttachment=attachmentService.findByfileName(fileName);
		lts.setAttachment(savedAttachment);
		save(lts);
	}

	@Override
	public List<LearnThesisSubmit> listByStudent(User student, Integer page) {
		return learnThesisSubmitInformationDao.listByStudent(student,page);
	}

	@Override
	public List<LearnThesisSubmit> listNewestByLearnThesis(
			LearnThesis learnThesis,List<User> users) {
		List<LearnThesisSubmit> all=learnThesisSubmitInformationDao.listNewestByLearnThesis(learnThesis);
		List<LearnThesisSubmit> result = Lists.newArrayList();
		for(User user : users){
			for(LearnThesisSubmit lts : all){
				if(user.getId()==lts.getUser().getId()){
					result.add(lts);
				}
			}
		}
		return result;
	}

	@Override
	public List<LearnThesisSubmit> listActiveInfoByTeacherUser(
			User currentTeacher) {
		return learnThesisSubmitInformationDao.listActiveInfoByTeacherUser(currentTeacher);
	}

	@Override
	public void delete(User user) {
		
		learnThesisSubmitInformationDao.delete(user);
	}

	@Override
	public List<LearnThesisSubmit> listByLearnClassId(Long id) {
		return learnThesisSubmitInformationDao.listByLearnClassId(id);
	}

	@Override
	public Integer getLearnThesisSubmitCount() {
		return learnThesisSubmitInformationDao.getLearnThesisSubmitCount();
	}

	@Override
	public Integer getLearnThesisSubmitGoodCount() {
		return learnThesisSubmitInformationDao.getLearnThesisSubmitGoodCount();
	}

	@Override
	public Integer getCountByLearnClassId(Long learnClassId) {
		return learnThesisSubmitInformationDao.getCountByLearnClassId(learnClassId);
	}

}
