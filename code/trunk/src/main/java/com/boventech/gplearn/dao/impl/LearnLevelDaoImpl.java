package com.boventech.gplearn.dao.impl;

import java.util.List;


import com.boventech.gplearn.dao.LearnLevelDao;
import com.boventech.gplearn.entity.LearnLevel;

public class LearnLevelDaoImpl extends BaseDaoImpl<LearnLevel,Long> implements LearnLevelDao {

	@Override
	public List<LearnLevel> listAll() {
		String queryString = "FROM LearnLevel ll ";
		return executeQueryWithoutPaging(queryString);
	}

	@Override
	public List<LearnLevel> listActive() {
		String queryString = "FROM LearnLevel ll WHERE ll.active=?1";
		return executeQueryWithoutPaging(queryString, true);
	}

	@Override
	public boolean checkExsit(String learnLevelName) {
		String queryString ="FROM LearnLevel ll WHERE ll.name = ?1";
		return !executeQueryWithoutPaging(queryString, learnLevelName).isEmpty();
	}

	@Override
	public boolean checkExsitWithoutCurrent(LearnLevel learnLevel) {
		String queryString ="FROM LearnLevel ll WHERE ll.name= ?1 ANd ll.id<>?2";
		return !executeQueryWithoutPaging(queryString, learnLevel.getName(),learnLevel.getId()).isEmpty();
	}

	
}
