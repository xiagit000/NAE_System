package com.boventech.gplearn.dao.impl;

import java.util.List;

import com.boventech.gplearn.dao.LearnCourseDao;
import com.boventech.gplearn.entity.LearnCourse;
import com.boventech.gplearn.entity.Discipline.LearnRange;

public class LearnCourseDaoImpl extends BaseDaoImpl<LearnCourse,Long> implements
		LearnCourseDao {
	
	private static final String DEFAULT_ORDER=" ORDER BY lc.id DESC";

	@Override
	public List<LearnCourse> listWithPagination(Integer page) {
		String queryString = "FROM LearnCourse lc";
		return executeQueryWithPagination(queryString, DEFAULT_ORDER, page);
	}

	@Override
	public boolean checkExsitByname(String learnCourseName) {
		String queryString = "FROM LearnCourse lc WHERE lc.name = ?1";
		return !executeQueryWithoutPaging(queryString, learnCourseName).isEmpty();
	}

	@Override
	public boolean checkExsitByCode(String code) {
		String queryString = "FROM LearnCourse lc WHERE lc.code = ?1";
		return !executeQueryWithoutPaging(queryString, code).isEmpty();
	}

	@Override
	public boolean checkExsitByCodeWithOutCurrent(LearnCourse learnCourse) {
		String queryString = "FROM LearnCourse lc WHERE lc.code = ?1 AND lc.id <> ?2";
		return !executeQueryWithoutPaging(queryString, learnCourse.getCode(),learnCourse.getId()).isEmpty();
	}

	@Override
	public boolean checkExsitBynameWithOutCurrent(LearnCourse learnCourse) {
		String queryString = "FROM LearnCourse lc WHERE lc.name = ?1 AND lc.id <>?2";
		return !executeQueryWithoutPaging(queryString, learnCourse.getName(),learnCourse.getId()).isEmpty();
	}

	@Override
	public List<LearnCourse> listWithLearnRange(LearnRange gp) {
		String queryString = "FROM LearnCourse lc WHERE lc.learnRange=?1";
		return executeQueryWithoutPaging(queryString, gp);
	}

	@Override
	public List<LearnCourse> listAll() {
		String queryString = "FROM LearnCourse lc";
		return executeQueryWithoutPaging(queryString);
	}

	
}
