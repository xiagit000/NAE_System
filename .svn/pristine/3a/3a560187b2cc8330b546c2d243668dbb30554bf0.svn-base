package com.boventech.gplearn.dao.impl;


import java.util.List;

import com.boventech.gplearn.dao.LearnResourceDao;
import com.boventech.gplearn.entity.LearnResource;
import com.boventech.gplearn.entity.User;

public class LearnResourceDaoImpl extends BaseDaoImpl<LearnResource, Long> implements
		LearnResourceDao {

	private static final String DEFAULT_ORDER=" ORDER BY lr.id DESC";
	
	@Override
	public List<LearnResource> listByUser(User disciplineUser,Integer page) {
		String queryString = "FROM LearnResource lr WHERE lr.uploader=?1";
		return executeQueryWithPagination(queryString, DEFAULT_ORDER, page, disciplineUser);
	}

	
}
