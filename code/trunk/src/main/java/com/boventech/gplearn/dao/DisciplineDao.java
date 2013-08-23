package com.boventech.gplearn.dao;

import java.util.List;

import com.boventech.gplearn.entity.Discipline;
import com.boventech.gplearn.entity.User;

public interface DisciplineDao extends BaseDao<Discipline, Long> {

	List<Discipline> listAll();
	
	List<Discipline> listWithPagination(Integer page);

	boolean checkExsitByLearnLevelId(Long learnLevelId);

	boolean checkExsitByLearnSpeacialtyId(Long learnSpeacialtyId);
	
	boolean checkExsitByLearnSpeacialtyIdAndLearnLevelId(Long LearnLevelId,Long learnSpeacialtyId);

	boolean checkExitBylearnSpeacialtyIdAndLearnLevelIdWithoutCurrent(
			Discipline discipline);

	boolean checkExsitCode(String code);

	boolean checkExsitCodeWithOutCurrent(Discipline discipline,String code);

	Discipline findByLearnLevelIdAndLearnSpeacialtyId(Long learnLevelId,
			Long learnSpeacialtyId);

	Discipline findByPersonIncharge(User user);



}
