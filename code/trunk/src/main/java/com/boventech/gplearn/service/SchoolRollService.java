package com.boventech.gplearn.service;

import java.util.List;

import com.boventech.gplearn.entity.Discipline;
import com.boventech.gplearn.entity.EnrollmentPlan;
import com.boventech.gplearn.entity.LearnClass;
import com.boventech.gplearn.entity.SchoolRoll;
import com.boventech.gplearn.entity.User;

public interface SchoolRollService extends BaseService<SchoolRoll,Long> {
	
	boolean checkExistByUser(User user);

	List<SchoolRoll> listActiveSchoolRoll(Integer page);

	List<SchoolRoll> listAllInformationByUserId(Long userId);
	
	List<SchoolRoll> generateSchoolRolls(List<User> users,EnrollmentPlan enrollmentPlan);
	
	void save(List<SchoolRoll> schoolRolls);
	
	void delete(List<SchoolRoll> schoolRolls);
	
	Integer countByLearnClass(LearnClass learnClass);
	
	List<SchoolRoll> findSchoolRollsByUser(User user);
	
	SchoolRoll findSchoolRollByUser(User user);

	SchoolRoll findByUserNewest(User user);

	List<User> findUsersByClass(LearnClass learnClass);

	List<User> findUsersByDiscipline(Discipline discipline);

	void deleteByUser(User user);

	List<User> listActiveByLearnClass(LearnClass learnClass);

	List<SchoolRoll> listActiveByClassWithPagination(LearnClass learnClass,
			Integer page);

}
