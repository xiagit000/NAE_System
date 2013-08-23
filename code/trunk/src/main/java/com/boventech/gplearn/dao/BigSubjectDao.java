package com.boventech.gplearn.dao;

import java.util.List;

import com.boventech.gplearn.entity.Batch;
import com.boventech.gplearn.entity.BigSubject;
import com.boventech.gplearn.entity.Discipline;

public interface BigSubjectDao extends BaseDao<BigSubject, Long> {

	List<BigSubject> listWithPagination(Integer page);

	boolean isAlreadyExsitByTitle(String title);

	boolean isAlradyExsitByTitleWithOutCurrent(BigSubject bigSubject);

	List<BigSubject> listWithBatch(Batch currentBatch);

	List<BigSubject> listWithDisciplineInCurrentBatch(Discipline discipline,
			Batch currentBatch);

	List<BigSubject> listAll();
}
