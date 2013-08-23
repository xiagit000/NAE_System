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

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.boventech.gplearn.entity.User;
import com.boventech.gplearn.entity.User.UserType;

public class UserServiceTest extends JunitServiceBase {

    @Autowired
    private UserService userService;

    @Test
    public void savaBatch() {
        User user = new User();
        user.setLoginName("xp");
        user.setPassword("123");
        user.setUserType(UserType.Project_Specialists);
        this.userService.save(user);
    }

    @Test
    public void updateBatch() {
        User user = this.userService.findById((long) 1);
        this.userService.update(user);
    }

    @Test
    public void deleteBatch() {
        User user = this.userService.findById((long) 1);
        this.userService.delete(user);
        this.userService.delete(user.getId());
    }
}
