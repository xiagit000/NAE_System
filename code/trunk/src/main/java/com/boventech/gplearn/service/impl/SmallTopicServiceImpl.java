package com.boventech.gplearn.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.boventech.gplearn.dao.SmallTopicDao;
import com.boventech.gplearn.entity.SmallTopic;
import com.boventech.gplearn.service.SmallTopicService;

@Service
@Transactional
public class SmallTopicServiceImpl implements SmallTopicService {

	@Autowired
	private SmallTopicDao smallTopicDao;
	
	@Override
	public List<SmallTopic> listByBigSubjectIdWithPagination(Long bigSubJectId,
			Integer page) {
		return smallTopicDao.listByBigSubjectIdWithPagination(bigSubJectId, page);
	}

	@Override
	public void delete(SmallTopic t) {
		smallTopicDao.delete(t);
	}

	@Override
	public void delete(Long id) {
		smallTopicDao.deleteById(id);
	}

	@Override
	public SmallTopic findById(Long id) {
		return smallTopicDao.findByID(id);
	}

	@Override
	public void save(SmallTopic t) {
		smallTopicDao.save(t);
	}

	@Override
	public void update(SmallTopic t) {
		smallTopicDao.update(t);
	}

	@Override
	public boolean isEmptyWithBigSubjectId(Long bigSubjectId) {
		return smallTopicDao.isEmptyWithBigSubjectId(bigSubjectId);
	}

	@Override
	public boolean isEmptyByTitleAndSubjectId(Long bigSubjectId, String title) {
		return smallTopicDao.isEmptyByTitleAndSubjectId(bigSubjectId,title);
	}

	@Override
	public boolean isEmptyByTitleAndSubjectIdWithoutCurrent(
			SmallTopic smallTopic) {
		return smallTopicDao.isEmptyByTitleAndSubjectIdWithoutCurrent(smallTopic);
	}

	@Override
	public SmallTopic findByBigSubjectIdAndId(Long bigSubjectId, Long id) {
		return smallTopicDao.findByBigSubjectIdAndId(bigSubjectId,id);
	}

	@Override
	public List<SmallTopic> listAll() {
		return smallTopicDao.listAll();
	}

}
