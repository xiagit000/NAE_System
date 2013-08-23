package com.boventech.gplearn.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.boventech.gplearn.dao.LearnLevelDao;
import com.boventech.gplearn.entity.LearnLevel;
import com.boventech.gplearn.service.LearnLevelService;

@Service
@Transactional
public class LearnLevelServiceImpl implements LearnLevelService {

	@Autowired
	private LearnLevelDao learnLevelDao;
	
	
	@Override
	public void delete(LearnLevel t) {
		learnLevelDao.delete(t);
	}

	@Override
	public void delete(Long id) {
		learnLevelDao.deleteById(id);
	}

	@Override
	public LearnLevel findById(Long id) {
		return learnLevelDao.findByID(id);
	}

	@Override
	public List<LearnLevel> listAll() {
		return learnLevelDao.listAll();
	}

	@Override
	public void save(LearnLevel t) {
		learnLevelDao.save(t);
	}

	@Override
	public void update(LearnLevel t) {
		learnLevelDao.update(t);
	}

	@Override
	public List<LearnLevel> listActive() {
		return learnLevelDao.listActive();
	}

	@Override
	public boolean checkExsit(String learnLevelName) {
		return learnLevelDao.checkExsit(learnLevelName);
	}

	@Override
	public boolean checkExsitWithOutCurrent(LearnLevel learnLevel) {
		return learnLevelDao.checkExsitWithoutCurrent(learnLevel);
	}

}
