package com.boventech.gplearn.dao.impl;

import java.util.List;

import com.boventech.gplearn.dao.SmallTopicDao;
import com.boventech.gplearn.entity.SmallTopic;

public class SmallTopicDaoImpl extends BaseDaoImpl<SmallTopic, Long> implements
		SmallTopicDao {

	private static final String DEFAUT_ORDER = " ORDER BY st.id DESC";

	@Override
	public List<SmallTopic> listByBigSubjectIdWithPagination(Long bigSubJectId,
			Integer page) {
		String queryString = "FROM SmallTopic st WHERE st.belongBigSubject.id=?1";
		return executeQueryWithPagination(queryString, DEFAUT_ORDER, page,
				bigSubJectId);
	}

	@Override
	public boolean isEmptyWithBigSubjectId(Long bigSubjectId) {
		String queryString = "FROM SmallTopic st WHERE st.belongBigSubject.id=?1";
		return executeQueryWithoutPaging(queryString, bigSubjectId).isEmpty();
	}

	@Override
	public boolean isEmptyByTitleAndSubjectId(Long bigSubjectId, String title) {
		String queryString = "FROM SmallTopic st WHERE st.belongBigSubject.id=?1 AND st.title=?2";
		return executeQueryWithoutPaging(queryString, bigSubjectId, title)
				.isEmpty();
	}

	@Override
	public boolean isEmptyByTitleAndSubjectIdWithoutCurrent(
			SmallTopic smallTopic) {
		String queryString = "FROM SmallTopic st WHERE st.belongBigSubject.id=?1 AND st.title=?2 AND st.id <> ?3";
		return executeQueryWithoutPaging(queryString,
				smallTopic.getBelongBigSubject().getId(),
				smallTopic.getTitle(), smallTopic.getId()).isEmpty();
	}

	@Override
	public SmallTopic findByBigSubjectIdAndId(Long bigSubjectId, Long id) {
		String queryString = "FROM SmallTopic st WHERE st.belongBigSubject.id=?1 AND st.id = ?2";
		List<SmallTopic> list = executeQueryWithoutPaging(queryString, bigSubjectId,id);
		return list.isEmpty()?null:list.get(0);
	}

	@Override
	public List<SmallTopic> listAll() {
		String queryString = "FROM SmallTopic st ";
		return executeQueryWithoutPaging(queryString);
	}

}
