package com.boventech.gplearn.service;

import java.util.List;

import com.boventech.gplearn.entity.BigSubject;
import com.boventech.gplearn.entity.LearnThesis;

public interface LearnThesisService extends BaseService<LearnThesis, Long> {

	List<LearnThesis> listWithPagination(Integer page);

	List<LearnThesis> listEnableThesisWithBigSubjects(
			List<BigSubject> bigsubjects);

	List<LearnThesis> lisOverThesisWithBigSubjects(List<BigSubject> bigsubjects);

	List<LearnThesis> listThesisWithBigSubjects(List<BigSubject> bigSubject);
}
