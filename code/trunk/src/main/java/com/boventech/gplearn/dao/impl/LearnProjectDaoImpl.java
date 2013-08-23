package com.boventech.gplearn.dao.impl;

import java.util.List;

import com.boventech.gplearn.dao.LearnProjectDao;
import com.boventech.gplearn.entity.LearnProject;

public class LearnProjectDaoImpl extends BaseDaoImpl<LearnProject, Long> implements
		LearnProjectDao {

	private static final String DEFAULT_ORDER=" ORDER BY lp.id DESC";
	
	@Override
	public List<LearnProject> listWithPagination(Integer page) {
		String queryString = "FROM LearnProject lp";
		return executeQueryWithPagination(queryString, DEFAULT_ORDER, page);
	}

	@Override
	public List<LearnProject> listAll() {
		String queryString = "FROM LearnProject lp";
		return executeQueryWithoutPaging(queryString);
	}

	@Override
	public boolean isExsitByName(String name) {
		String queryString = "FROM LearnProject lp WHERE lp.name=?1";
		return !executeQueryWithoutPaging(queryString, name).isEmpty();
	}

	@Override
	public boolean isExsitByNameWithOutCurrent(LearnProject learnProject) {
		String queryString = "FROM LearnProject lp WHERE lp.name=?1 AND lp.id<>?2";
		return !executeQueryWithoutPaging(queryString,learnProject.getName(),learnProject.getId()).isEmpty();
	}

	@Override
	public boolean isExsitByCode(String code) {
		String queryString = "FROM LearnProject lp WHERE lp.code = ?1";
		return !executeQueryWithoutPaging(queryString, code).isEmpty();
	}

	@Override
	public boolean isExsitByCodeWithOutCurrent(LearnProject learnProject) {
		String queryString = "FROM LearnProject lp WHERE lp.code= ?1 AND lp.id<>?2";
		return !executeQueryWithoutPaging(queryString, learnProject.getCode(),learnProject.getId()).isEmpty();
	}

}
