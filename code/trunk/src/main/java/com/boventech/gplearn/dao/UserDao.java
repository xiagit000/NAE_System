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

package com.boventech.gplearn.dao;

import java.util.List;


import com.boventech.gplearn.entity.Account;
import com.boventech.gplearn.entity.Batch;
import com.boventech.gplearn.entity.LearnClass;
import com.boventech.gplearn.entity.User;
import com.boventech.gplearn.entity.User.UserType;

public interface UserDao extends BaseDao<User, Long> {
    Long getMaxIndex();
    
    void save(List<User> users);
    
    List<User> listAllWithPagnate(Integer page);
    
    List<User> listAllWithoutPagnate();
    
    boolean isExistByIdNumberAndBatch(String idNumber,Batch batch);

	boolean checkEntityExsitByLoginName(String loginName);

	User findByLoginName(String loginName);
	
	List<User> listSerchWithPagnate(Integer page,User user,Account account, Batch batch,LearnClass learnClass);
	
	List<User> listSerchWithoutPagnate(User user,Account account, Batch batch,LearnClass learnClass);

	User findByUserType(UserType userType);

	User findbyAccount(Account account);

	List<User> findByUserTypeAndBatch(UserType userType,Batch batch);

	Integer getStudentCount();

	Integer getActiveStudentCount();
}
