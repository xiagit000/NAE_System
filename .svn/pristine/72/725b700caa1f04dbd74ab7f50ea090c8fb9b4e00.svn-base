package com.boventech.gplearn.service;

import java.util.List;

import com.boventech.gplearn.entity.LearnCourse;
import com.boventech.gplearn.entity.Discipline.LearnRange;

public interface LearnCourseService extends BaseService<LearnCourse, Long> {

	List<LearnCourse> listWithPagination(Integer page);
	
	boolean checkExsitByname(String learnCourseName);

	boolean checkExsitByCode(String code);
	
	boolean checkExsitBynameWithOutCurrent(LearnCourse learnCourse);

	boolean checkExsitByCodeWithOutCurrent(LearnCourse learnCourse);

	List<LearnCourse> listWithLearnRange(LearnRange gp);

	List<LearnCourse> listAll();

	boolean isExsit();
	
}
