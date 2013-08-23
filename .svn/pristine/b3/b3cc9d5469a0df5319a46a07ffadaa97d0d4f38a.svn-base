package com.boventech.gplearn.service;

import java.util.List;

import com.boventech.gplearn.entity.LearnThesis;
import com.boventech.gplearn.entity.LearnThesisSubmit;
import com.boventech.gplearn.entity.User;

public interface LearnThesisSubmitInfomationService extends BaseService<LearnThesisSubmit, Long>{

	LearnThesisSubmit findByStudentUserAndLearnThesis(User currentStudent, LearnThesis learnThesis);

	List<LearnThesisSubmit> listActiveInfoByStudentUser(User currentStudent);
	
	List<LearnThesisSubmit> listByStudent(User student, Integer page);
	
	List<LearnThesisSubmit> listActiveInfoByTeacherUser(User currentTeacher, Integer page);

	List<LearnThesisSubmit> listActiveInfoByTeacherUser(User currentTeacher);
	
	void saveLearnThesisSubmitInformation(LearnThesis learnThesis,
			User currentStudent,  String fileName);

	List<LearnThesisSubmit> listNewestByLearnThesis(LearnThesis learnThesis,List<User> user);

	void delete(User user);

	List<LearnThesisSubmit> listByLearnClassId(Long id);

	Integer getLearnThesisSubmitCount();

	Integer getLearnThesisSubmitGoodCount();

	Integer getCountByLearnClassId(Long learnClassId);
}
