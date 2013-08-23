package com.boventech.gplearn.service;

import java.util.List;

import com.boventech.gplearn.entity.SmallTopic;

public interface SmallTopicService extends BaseService<SmallTopic, Long> {

	List<SmallTopic> listByBigSubjectIdWithPagination(Long bigSubJectId,Integer page);
	
	SmallTopic findByBigSubjectIdAndId(Long bigSubjectId,Long id);

	boolean isEmptyWithBigSubjectId(Long bigSubjectId);
	
	boolean isEmptyByTitleAndSubjectId(Long bigSubjectId,String title);
	
	boolean isEmptyByTitleAndSubjectIdWithoutCurrent(SmallTopic smallTopic);

	List<SmallTopic> listAll();
}
