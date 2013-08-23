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

public interface AccountDao extends BaseDao<Account, Long> {
    List<Account> listAll();

    Account getAccountByIdNumber(String idNumber);

    boolean isExistByIdNumber(String number);
    
    boolean isExistByIdNumberWithoutCurrent(Account account);

	List<Account> listBySchool(String school);

	List<Account> listWithPagination(Integer page);
}
