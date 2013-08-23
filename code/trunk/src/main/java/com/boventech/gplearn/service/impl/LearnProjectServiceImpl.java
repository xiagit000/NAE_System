package com.boventech.gplearn.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.boventech.gplearn.dao.LearnProjectDao;
import com.boventech.gplearn.entity.LearnProject;
import com.boventech.gplearn.service.LearnProjectService;

@Service
@Transactional
public class LearnProjectServiceImpl implements LearnProjectService {

	@Autowired
	private LearnProjectDao learnProjectDao;
	
	@Override
	public List<LearnProject> listWithPagination(Integer page) {
		return learnProjectDao.listWithPagination(page);
	}

	@Override
	public void delete(LearnProject t) {
		learnProjectDao.delete(t);
	}

	@Override
	public void delete(Long id) {
		learnProjectDao.deleteById(id);
	}

	@Override
	public LearnProject findById(Long id) {
		return learnProjectDao.findByID(id);
	}

	@Override
	public void save(LearnProject t) {
		learnProjectDao.save(t);
	}

	@Override
	public void update(LearnProject t) {
		learnProjectDao.update(t);
	}

	@Override
	public List<LearnProject> listAll() {
		return learnProjectDao.listAll();
	}

	@Override
	public boolean isExsitByName(String name) {
		
		return learnProjectDao.isExsitByName(name);
	}

	@Override
	public boolean isExsitByNameWithOutCurrent(LearnProject learnProject) {
		return learnProjectDao.isExsitByNameWithOutCurrent(learnProject);
	}

	@Override
	public boolean isExsitByCode(String code) {
		return learnProjectDao.isExsitByCode(code);
	}

	@Override
	public boolean isExsitByCodeWithOutCurrent(LearnProject learnProject) {
		return learnProjectDao.isExsitByCodeWithOutCurrent(learnProject);
	}

}
