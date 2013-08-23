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

import com.boventech.gplearn.entity.City;
import com.boventech.gplearn.entity.LearnArea;
import com.boventech.gplearn.entity.User;

public interface LearnAreaService extends BaseService<LearnArea, Long> {
    List<LearnArea> listAll();
    
    List<LearnArea> listEnable();
    
    boolean checkExist();
    
    boolean isExistByCode(String code);
    
    boolean isExistByName(String name);
    
    boolean isExistByCodeWithoutCurrent(LearnArea learnArea);
    
    boolean isExistByNameWithoutCurrent(LearnArea learnArea);
    
    List<City> getExistProvince();

	List<LearnArea> listWithProvinceCity(City city);

	List<LearnArea> listByPersonIncharge(User currentUser);
}
