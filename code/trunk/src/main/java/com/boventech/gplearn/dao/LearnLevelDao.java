package com.boventech.gplearn.dao;

import java.util.List;

import com.boventech.gplearn.entity.LearnLevel;

public interface LearnLevelDao extends BaseDao<LearnLevel, Long> {

	List<LearnLevel> listAll();
	
	List<LearnLevel> listActive();
	
	boolean checkExsit(String learnLevelName);
	
	boolean checkExsitWithoutCurrent(LearnLevel learnLevel);
}
