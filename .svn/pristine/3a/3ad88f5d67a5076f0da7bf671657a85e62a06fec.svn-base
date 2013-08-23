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

package com.boventech.gplearn.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.boventech.gplearn.entity.City;
import com.boventech.gplearn.service.CityService;

@Controller
@RequestMapping("/city")
public class CityController extends ApplicationController{
    
    @Autowired
    private CityService cityService;
    
    @RequestMapping(value="/changecity",method=RequestMethod.POST)
    @ResponseBody
    public List<City> changeCityByProcince(String elcode){
        return this.cityService.getCitiesByProvince(elcode);
    }
}
