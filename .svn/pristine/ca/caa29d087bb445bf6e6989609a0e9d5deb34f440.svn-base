package com.boventech.gplearn.service;

import java.util.List;

import com.boventech.gplearn.entity.LearnProject;

public interface LearnProjectService extends BaseService<LearnProject, Long> {

	List<LearnProject> listWithPagination(Integer page);
	
	List<LearnProject> listAll();
	
	boolean isExsitByName(String name);
	
	boolean isExsitByCode(String code);
	
	boolean isExsitByNameWithOutCurrent(LearnProject learnProject);
	
	boolean isExsitByCodeWithOutCurrent(LearnProject learnProject);
}
