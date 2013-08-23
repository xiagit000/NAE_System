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

import java.io.InputStream;
import java.util.List;

import com.boventech.gplearn.entity.Account;
import com.boventech.gplearn.entity.EnrollmentPlan;

public interface AccountService extends BaseService<Account, Long> {
    List<Account> readXls(InputStream inputStream);
    
    void save(List<Account> accounts);
    
    int validateAccounts(List<Account> accounts,EnrollmentPlan enrollmentPlan);
    
    boolean isExistByIdNumber(String number);
    
    boolean isExistByIdNumberWithoutCurrent(Account account);
    

	List<Account> listBySchool(String school);

	List<Account> listWithPagination(Integer page);
}
