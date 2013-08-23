package com.boventech.gplearn.service;

import java.util.List;

import com.boventech.gplearn.entity.Discipline;
import com.boventech.gplearn.entity.User;
import com.boventech.gplearn.exception.StudySpaceCreateFaildException;

public interface DisciplineService extends BaseService<Discipline,Long> {

	List<Discipline> listAll();
	
	List<Discipline> listWithPagination(Integer page);
	
	boolean checkExsitByLearnLevelId(Long learnLevelId);
	
	boolean checkExsitByLearnSpeacialtyId(Long learnSpeacialtyId);
	
	boolean checkExsitByLearnSpeacialtyIdAndLearnLevelId(Long learnSpeacialtyId,Long learnLevelId);
	
	boolean checkExsitBylearnSpeacialtyIdAndLearnLevelIdWithoutCurrent(Discipline discipline);

	boolean checkExsitCode(String code);
	
	boolean checkExsitCodeWithOutCurrent(Discipline discipline,String code);
	
	boolean checkExsit();

	Discipline findByLearnLevelIdAndLearnSpeacialtyId(Long learnLevelId, Long learnSpeacialtyId);

	void saveDiscipline(Discipline discipline)throws StudySpaceCreateFaildException;

	Discipline findByPersonIncharge(User user);
	
}
