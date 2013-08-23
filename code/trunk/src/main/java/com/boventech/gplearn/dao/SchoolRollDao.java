package com.boventech.gplearn.dao;

import java.util.List;

import com.boventech.gplearn.entity.Discipline;
import com.boventech.gplearn.entity.LearnClass;
import com.boventech.gplearn.entity.SchoolRoll;
import com.boventech.gplearn.entity.User;

public interface SchoolRollDao extends BaseDao<SchoolRoll, Long> {
	
	boolean checkExistByUser(User user);

	List<SchoolRoll> listActiveSchoolRoll(Integer page);

	List<SchoolRoll> listAllInformationByUserId(Long userId);
	
	void save(List<SchoolRoll> schoolRolls);
	
	Integer countByLearnClass(LearnClass learnClass);
	
	List<SchoolRoll> findByUser(User user);

	SchoolRoll findByUserNewest(User user);
	
	Integer getUserNumberByLearnClass(LearnClass learnClass);

	List<SchoolRoll> findUsersByClass(LearnClass learnClass);

	void deleteByUser(User user);

	List<SchoolRoll> listActiveByLearnClass(LearnClass learnClass);

	List<SchoolRoll> listActiveByClassWithPagination(LearnClass learnClass,
			Integer page);

    List<SchoolRoll> findSchoolRollsByDiscipline(Discipline discipline);
}
