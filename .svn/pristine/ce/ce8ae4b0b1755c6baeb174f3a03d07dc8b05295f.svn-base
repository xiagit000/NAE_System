package com.boventech.gplearn.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.boventech.gplearn.dao.LearnCourseDao;
import com.boventech.gplearn.entity.LearnCourse;
import com.boventech.gplearn.entity.Discipline.LearnRange;
import com.boventech.gplearn.service.LearnCourseService;

@Service
@Transactional
public class LearnCourseServiceImpl implements LearnCourseService {

	@Autowired
	private LearnCourseDao learnCourseDao;
	
	@Override
	public void delete(LearnCourse t) {
		learnCourseDao.delete(t);
	}

	@Override
	public void delete(Long id) {
		learnCourseDao.deleteById(id);
	}

	@Override
	public LearnCourse findById(Long id) {
		return learnCourseDao.findByID(id);
	}

	@Override
	public void save(LearnCourse t) {
		learnCourseDao.save(t);
	}

	@Override
	public void update(LearnCourse t) {
		learnCourseDao.update(t);
	}

	@Override
	public List<LearnCourse> listWithPagination(Integer page) {
		return learnCourseDao.listWithPagination(page);
	}

	@Override
	public boolean checkExsitByname(String learnCourseName) {
		return learnCourseDao.checkExsitByname(learnCourseName);
	}

	@Override
	public boolean checkExsitByCode(String code) {
		return learnCourseDao.checkExsitByCode(code);
	}

	@Override
	public boolean checkExsitByCodeWithOutCurrent(LearnCourse learnCourse) {
		return learnCourseDao.checkExsitByCodeWithOutCurrent(learnCourse);
	}

	@Override
	public boolean checkExsitBynameWithOutCurrent(LearnCourse learnCourse) {
		return learnCourseDao.checkExsitBynameWithOutCurrent(learnCourse);
	}

	@Override
	public List<LearnCourse> listWithLearnRange(LearnRange gp) {
		return learnCourseDao.listWithLearnRange(gp);
	}

	@Override
	public List<LearnCourse> listAll() {
		return learnCourseDao.listAll();
	}

	@Override
	public boolean isExsit() {
		return !listAll().isEmpty();
	}

}
