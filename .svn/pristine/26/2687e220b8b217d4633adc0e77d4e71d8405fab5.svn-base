package com.boventech.gplearn.service.impl;

import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.boventech.gplearn.dao.LearnResourceDao;
import com.boventech.gplearn.entity.Attachment;
import com.boventech.gplearn.entity.Constants;
import com.boventech.gplearn.entity.LearnResource;
import com.boventech.gplearn.entity.User;
import com.boventech.gplearn.service.AttachmentService;
import com.boventech.gplearn.service.LearnResourceService;

@Service
@Transactional
public class LearnResourceServiceImpl implements LearnResourceService {

	@Autowired
	private LearnResourceDao learnResourceDao;
	
	@Autowired
	private AttachmentService attachmentService;
	
	@Override
	public void delete(LearnResource t) {
		learnResourceDao.delete(t);
	}

	@Override
	public void delete(Long id) {
		learnResourceDao.deleteById(id);
	}

	@Override
	public LearnResource findById(Long id) {
		return learnResourceDao.findByID(id);
	}

	@Override
	public void save(LearnResource t) {
		learnResourceDao.save(t);
	}

	@Override
	public void update(LearnResource t) {
		learnResourceDao.update(t);
	}

	@Override
	public List<LearnResource> listByUser(User disciplineUser,Integer page) {
		return learnResourceDao.listByUser(disciplineUser,page);
	}

	@Override
	public void saveLearnResource(User user, LearnResource learnResource,
			String fileName) {
		Attachment attachment = new Attachment();
		attachment.setFileName(fileName);
		attachment.setFilePath(File.separator+Constants.DEFAULT_UPLOAD_PATH+File.separator+fileName);
		attachmentService.save(attachment);
		Attachment savedAttachment = attachmentService.findByfileName(fileName);
		learnResource.setAttachment(savedAttachment);
		learnResource.setUploader(user);
		learnResourceDao.save(learnResource);
	}

}
