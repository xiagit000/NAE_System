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

package com.boventech.gplearn.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.boventech.gplearn.dao.AccountDao;
import com.boventech.gplearn.entity.Account;

@Repository
public class AccountDaoImpl extends BaseDaoImpl<Account, Long> implements AccountDao {
    
    @Override
    public boolean isExistByIdNumber(String number) {
        String queryString = "From Account where idNumber=?1";
        return !executeQueryWithoutPaging(queryString, number).isEmpty();
    }
    
    @Override
    public List<Account> listAll() {
        return executeQueryWithoutPaging("From Account");
    }

    @Override
    public boolean isExistByIdNumberWithoutCurrent(Account account) {
        String queryString = "From Account where idNumber=?1 and id<>?2";
        return !executeQueryWithoutPaging(queryString, account.getIdNumber(),account.getId()).isEmpty();
    }

    @Override
    public Account getAccountByIdNumber(String idNumber) {
        String queryString="from Account where idNumber=?1";
        return executeQueryWithoutPaging(queryString, idNumber).get(0);
    }

	@Override
	public List<Account> listBySchool(String school) {
		String queryString = "FROM Account WHERE school = ?1";
		return executeQueryWithoutPaging(queryString, school);
	}

	@Override
	public List<Account> listWithPagination(Integer page) {
		String queryString = "FROM Account a";
		return executeQueryWithPagination(queryString, " ORDER BY a.id", page);
	}

}
