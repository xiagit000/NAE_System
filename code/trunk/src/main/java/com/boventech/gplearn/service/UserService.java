/*
 * Copyright 2010. 
 * 
 * This document may not be reproduced, distributed or used 
 * in any manner whatsoever without the expressed written 
 * permission of Boventech Corp. 
 * 
 * $Rev: Rev $
 * $Author: Author $
 * $LastChangedDate: LastChangedDate $
 *
 */

package com.boventech.gplearn.service;

import java.util.List;

import com.boventech.gplearn.entity.Account;
import com.boventech.gplearn.entity.Batch;
import com.boventech.gplearn.entity.Discipline;
import com.boventech.gplearn.entity.EnrollmentPlan;
import com.boventech.gplearn.entity.LearnArea;
import com.boventech.gplearn.entity.LearnClass;
import com.boventech.gplearn.entity.LearnSubProject;
import com.boventech.gplearn.entity.SchoolRoll;
import com.boventech.gplearn.entity.User;
import com.boventech.gplearn.entity.User.UserType;
import com.boventech.gplearn.exception.StudySpaceCreateFaildException;
import com.boventech.gplearn.exception.UserDestroyInCASFaildException;
import com.boventech.gplearn.exception.UserDestroyInStudySpaceFaildException;
import com.boventech.gplearn.exception.UserInfoPushToStudySpaceClassRoomFaildException;
import com.boventech.gplearn.exception.UserInfoPushToStudySpaceFaildException;
import com.boventech.gplearn.exception.UserInfoSendCASFaildException;
import com.boventech.gplearn.exception.UserUpdateToCASFaildException;

public interface UserService extends BaseService<User, Long> {
    Long getMaxIndex();

    void save(List<User> users);

    List<User> generateUsers(List<Account> accounts, EnrollmentPlan enrollmentPlan);

    List<User> listAllWithPagnate(Integer page);
    
    List<User> listAllWithoutPagnate();

	boolean checkEntityExsitByLoginName(String loginName);

	User findByLoginName(String loginName);

	
	List<User> listSearchWithPagnate(Integer page,User user,Account account,Batch batch,LearnClass learnClass);
	
	List<User> listSearchWithoutPagnate(User user,Account account,Batch batch,LearnClass learnClass);


	void saveAllAccountInformation(List<Account> accounts,
			EnrollmentPlan enrollmentPlan)throws UserInfoSendCASFaildException , UserInfoPushToStudySpaceFaildException, UserInfoPushToStudySpaceClassRoomFaildException, StudySpaceCreateFaildException ;

	void pushDisciplinePersonInChargeToTheStudySpace(User user,Discipline discipline)throws UserInfoSendCASFaildException, UserInfoPushToStudySpaceFaildException ;

	void destroyUser(User user, List<SchoolRoll> schoolRolls)throws UserDestroyInStudySpaceFaildException, UserDestroyInCASFaildException ;

	/**
	 * Save User To CAS AND LocalDataBase
	 * @param user
	 * @throws UserInfoSendCASFaildException
	 */
	void saveUser(User user) throws UserInfoSendCASFaildException;

	void saveProjectUser(User user, LearnSubProject lsp) throws UserInfoSendCASFaildException ;

	void saveProvinceUser(List<LearnArea> areas, User user) throws UserInfoSendCASFaildException ;

	void saveTeacher(LearnClass learnClass, User user) throws UserDestroyInStudySpaceFaildException, UserInfoPushToStudySpaceClassRoomFaildException;

	User findByUserType(UserType userType);
	
	void changePassword(User currentUser) throws UserUpdateToCASFaildException ;
	
	List<User> findByUserTypeAndBatch(UserType userType);

	List<User> listBySchoolIncurrentBatch(String school, Batch currentBatch);

	Integer getStudentCount();

	Integer getActiveStudentCount();

}
