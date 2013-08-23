package com.boventech.gplearn.dao;

import java.util.List;

import com.boventech.gplearn.entity.LearnSpeacialty;

public interface LearnSpeacialtyDao extends BaseDao<LearnSpeacialty, Long> {
	
	List<LearnSpeacialty> listAll();
	
	List<LearnSpeacialty> listActive();
	
	List<LearnSpeacialty> listWithPagination(Integer page);

	boolean checkExsit(String learnSpeacialtyName);
	
	boolean checkExsitWithOutCurrent(LearnSpeacialty learnSpeacialty);
}
