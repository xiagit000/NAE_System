package com.boventech.gplearn.dao.impl;

import java.util.Date;
import java.util.List;

import com.boventech.gplearn.dao.LearnThesisDao;
import com.boventech.gplearn.entity.BigSubject;
import com.boventech.gplearn.entity.LearnThesis;

public class LearnThesisDaoImpl extends BaseDaoImpl<LearnThesis,Long> implements
		LearnThesisDao {

	private static final String DEFAULT_ORDER= " ORDER BY lt.id DESC";
	
	@Override
	public List<LearnThesis> listWithPagination(Integer page) {
		String queryString = "FROM LearnThesis lt";
		return executeQueryWithPagination(queryString, DEFAULT_ORDER, page);
	}

	@Override
	public List<LearnThesis> listEnableThesisByBigSubject(BigSubject bigSubject,Date date) {
		String queryString = "FROM LearnThesis lt WHERE lt.bigSubject=?1 AND lt.beginTime<=?2 AND lt.submitTime>=?3";
		return executeQueryWithoutPaging(queryString, bigSubject,date,date);
	}

	@Override
	public List<LearnThesis> listOverThesisByBigSubject(BigSubject bigsubject,
			Date date) {
		String queryString = "FROM LearnThesis lt WHERE lt.bigSubject=?1 AND lt.submitTime<?2";
		return executeQueryWithoutPaging(queryString, bigsubject,date);
	}

	@Override
	public List<LearnThesis> listByBigSubjet(BigSubject bigsubject) {
		String queryString = "FROM LearnThesis lt WHERE lt.bigSubject=?1";
		return executeQueryWithoutPaging(queryString, bigsubject);
	}


}
