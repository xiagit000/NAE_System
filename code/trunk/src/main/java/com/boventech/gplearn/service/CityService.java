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

public interface CityService extends BaseService<City, Long> {
    List<City> getAllCities();

    List<City> getProvinces();

    City getCity(String elCode);

    City getProvince(String elCode);

    List<City> getCitiesByProvince(String elCode);
}
