package com.boventech.gplearn.service;

import java.util.List;


import com.boventech.gplearn.entity.LearnLevel;


public interface LearnLevelService extends BaseService<LearnLevel, Long> {

	List<LearnLevel> listAll();
	
	List<LearnLevel> listActive();
	
	boolean checkExsit(String learnLevelName);
	
	boolean checkExsitWithOutCurrent(LearnLevel learnLevel);
}
