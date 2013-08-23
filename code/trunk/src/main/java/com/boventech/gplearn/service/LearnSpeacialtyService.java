package com.boventech.gplearn.service;

import java.util.List;

import com.boventech.gplearn.entity.LearnSpeacialty;

public interface LearnSpeacialtyService extends BaseService<LearnSpeacialty, Long> {

	List<LearnSpeacialty> listAll();
	
	List<LearnSpeacialty> listActive();
	
	List<LearnSpeacialty> listWithPagination(Integer page);
	
	boolean checkExsit(String learnSpeacialtyName);
	
	boolean checkExsitWithOutCurrent(LearnSpeacialty learnSpeacialty);

}
