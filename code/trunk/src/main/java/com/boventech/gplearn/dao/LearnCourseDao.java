package com.boventech.gplearn.dao;

import java.util.List;

import com.boventech.gplearn.entity.LearnCourse;
import com.boventech.gplearn.entity.Discipline.LearnRange;

public interface LearnCourseDao extends BaseDao<LearnCourse, Long> {

	List<LearnCourse> listWithPagination(Integer page);

	boolean checkExsitByname(String learnCourseName);

	boolean checkExsitByCode(String code);

	boolean checkExsitByCodeWithOutCurrent(LearnCourse learnCourse);

	boolean checkExsitBynameWithOutCurrent(LearnCourse learnCourse);

	List<LearnCourse> listWithLearnRange(LearnRange gp);

	List<LearnCourse> listAll();

}
