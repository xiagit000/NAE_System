package com.boventech.gplearn.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.boventech.gplearn.dao.BigSubjectDao;
import com.boventech.gplearn.entity.Batch;
import com.boventech.gplearn.entity.BigSubject;
import com.boventech.gplearn.entity.Discipline;
import com.boventech.gplearn.service.BatchService;
import com.boventech.gplearn.service.BigSubjectService;

@Service
@Transactional
public class BigSubjectServiceImpl implements BigSubjectService {

	@Autowired
	private BigSubjectDao bigSubjectDao;
	
	@Autowired
	private BatchService batchService;
	
	@Override
	public List<BigSubject> listWithPagination(Integer page) {
		return bigSubjectDao.listWithPagination(page);
	}

	@Override
	public void delete(BigSubject t) {
		bigSubjectDao.delete(t);
	}

	@Override
	public void delete(Long id) {
		bigSubjectDao.deleteById(id);
	}

	@Override
	public BigSubject findById(Long id) {
		return bigSubjectDao.findByID(id);
	}

	@Override
	public void save(BigSubject t) {
		bigSubjectDao.save(t);
	}

	@Override
	public void update(BigSubject t) {
		bigSubjectDao.update(t);
	}

	@Override
	public boolean isAlreadyExsitByTitle(String title) {
		return bigSubjectDao.isAlreadyExsitByTitle(title);
	}

	@Override
	public boolean isAlradyExsitByTitleWithOutCurrent(BigSubject bigSubject) {
		return bigSubjectDao.isAlradyExsitByTitleWithOutCurrent(bigSubject);
	}

	@Override
	public List<BigSubject> listWithBatch(Batch currentBatch) {
		return bigSubjectDao.listWithBatch(currentBatch);
	}

	@Override
	public List<BigSubject> listWithDisciplineInCurrentBatch(
			Discipline discipline) {
		Batch currentBatch = batchService.getCurrentBatch();
		return bigSubjectDao.listWithDisciplineInCurrentBatch(discipline,currentBatch);
	}

	@Override
	public List<BigSubject> listAll() {
		return bigSubjectDao.listAll();
	}

}
