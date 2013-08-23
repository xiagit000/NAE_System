package com.boventech.gplearn.dao;

import java.util.List;

import com.boventech.gplearn.entity.SmallTopic;

public interface SmallTopicDao extends BaseDao<SmallTopic, Long> {

	List<SmallTopic> listByBigSubjectIdWithPagination(Long bigSubJectId,Integer page);

	boolean isEmptyWithBigSubjectId(Long bigSubjectId);

	boolean isEmptyByTitleAndSubjectId(Long bigSubjectId, String title);

	boolean isEmptyByTitleAndSubjectIdWithoutCurrent(SmallTopic smallTopic);

	SmallTopic findByBigSubjectIdAndId(Long bigSubjectId, Long id);

	List<SmallTopic> listAll();
}
