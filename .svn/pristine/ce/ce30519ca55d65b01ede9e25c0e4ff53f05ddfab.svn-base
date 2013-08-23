package com.boventech.gplearn.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.boventech.gplearn.dao.LearnSpeacialtyDao;
import com.boventech.gplearn.entity.LearnSpeacialty;
import com.boventech.gplearn.service.LearnSpeacialtyService;

@Service
@Transactional
public class LearnSpeacialtyServiceImpl implements LearnSpeacialtyService {

	@Autowired
	private LearnSpeacialtyDao learnSpeacialtyDao;
	
	@Override
	public List<LearnSpeacialty> listAll() {
		return learnSpeacialtyDao.listAll();
	}

	@Override
	public void delete(LearnSpeacialty t) {
		learnSpeacialtyDao.delete(t);
	}

	@Override
	public void delete(Long id) {
		learnSpeacialtyDao.deleteById(id);
	}

	@Override
	public LearnSpeacialty findById(Long id) {
		return learnSpeacialtyDao.findByID(id);
	}

	@Override
	public void save(LearnSpeacialty t) {
		learnSpeacialtyDao.save(t);
	}

	@Override
	public void update(LearnSpeacialty t) {
		learnSpeacialtyDao.update(t);
	}

	@Override
	public List<LearnSpeacialty> listActive() {
		return learnSpeacialtyDao.listActive();
	}

	@Override
	public List<LearnSpeacialty> listWithPagination(Integer page) {
		return learnSpeacialtyDao.listWithPagination(page);
	}

	@Override
	public boolean checkExsit(String learnSpeacialtyName) {
		return learnSpeacialtyDao.checkExsit(learnSpeacialtyName);
	}

	@Override
	public boolean checkExsitWithOutCurrent(LearnSpeacialty learnSpeacialty) {
		return learnSpeacialtyDao.checkExsitWithOutCurrent(learnSpeacialty);
	}

}
