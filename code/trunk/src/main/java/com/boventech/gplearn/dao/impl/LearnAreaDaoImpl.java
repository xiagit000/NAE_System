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

import com.boventech.gplearn.dao.LearnAreaDao;
import com.boventech.gplearn.entity.City;
import com.boventech.gplearn.entity.LearnArea;
import com.boventech.gplearn.entity.User;

@Repository
public class LearnAreaDaoImpl extends BaseDaoImpl<LearnArea, Long> implements LearnAreaDao{

    @Override
    public List<LearnArea> listAll() {
        return executeQueryWithoutPaging("From LearnArea");
    }

    @Override
    public boolean isExistByCode(String code) {
        String queryString="From LearnArea where code=?1";
        return !executeQueryWithoutPaging(queryString,code).isEmpty();
    }

    @Override
    public boolean isExistByCodeWithoutCurrent(LearnArea learnArea) {
        String queryString="From LearnArea where code=?1 and id<>?2";
        return !executeQueryWithoutPaging(queryString,learnArea.getCode(),learnArea.getId()).isEmpty();
    }
    
    @Override
    public boolean isExistByName(String name) {
        String queryString="From LearnArea where name=?1";
        return !executeQueryWithoutPaging(queryString,name).isEmpty();
    }

    @Override
    public boolean isExistByNameWithoutCurrent(LearnArea learnArea) {
        String queryString="From LearnArea where name=?1 and id<>?2";
        return !executeQueryWithoutPaging(queryString,learnArea.getName(),learnArea.getId()).isEmpty();
    }

    @Override
    public List<LearnArea> listEnable() {
        return executeQueryWithoutPaging("From LearnArea where status=1");
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<String> getAllElCodes() {
        return (List<String>) executeQuery("select elCode from LearnArea");
    }

	@Override
	public List<LearnArea> listWithProvinceCity(City city) {
		String queryString =  "FROM LearnArea WHERE regexp(elCode,'^"+city.getElCode()+"-[0-9]*$')=1";
		return executeQueryWithoutPaging(queryString);
	}
	
	@Override
	public List<LearnArea> findByPersonIncharge(User currentUser) {
		String queryString  = "FROM LearnArea WHERE user=?1";
		List<LearnArea> list  = executeQueryWithoutPaging(queryString, currentUser);
		return list;
	}
}
