package com.boventech.gplearn.dao.impl;

import java.util.List;

import com.boventech.gplearn.dao.LearnSpeacialtyDao;
import com.boventech.gplearn.entity.LearnSpeacialty;

public class LearnSpeacialtyDaoImpl extends BaseDaoImpl<LearnSpeacialty, Long> implements
		LearnSpeacialtyDao {
	
	private static final String DEFAULT_ORDER=" ORDER BY ls.id DESC";

	@Override
	public List<LearnSpeacialty> listAll() {
		String queryString = "FROM LearnSpeacialty ls";
		return executeQueryWithoutPaging(queryString);
	}

	@Override
	public List<LearnSpeacialty> listActive() {
		String queryString = "FROM LearnSpeacialty ls WHERE ls.active=?1";
		return executeQueryWithoutPaging(queryString, true);
	}

	@Override
	public List<LearnSpeacialty> listWithPagination(Integer page) {
		String queryString = "FROM LearnSpeacialty ls";
		return executeQueryWithPagination(queryString, DEFAULT_ORDER, page);
	}

	@Override
	public boolean checkExsit(String learnSpeacialtyName) {
		String queryString = "FROM LearnSpeacialty ls WHERE ls.name=?1";
		return !executeQueryWithoutPaging(queryString, learnSpeacialtyName).isEmpty();
	}

	@Override
	public boolean checkExsitWithOutCurrent(LearnSpeacialty learnSpeacialty) {
		String queryString = "FROM LearnSpeacialty ls WHERE ls.name=?1 AND ls.id<>?2";
		return !executeQueryWithoutPaging(queryString, learnSpeacialty.getName(),learnSpeacialty.getId()).isEmpty();
	}

}
