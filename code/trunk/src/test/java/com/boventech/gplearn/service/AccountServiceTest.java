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

import com.boventech.gplearn.entity.Account;

public class AccountServiceTest extends JunitServiceBase {

    @Autowired
    private AccountService accountService;

    @Test
    public void savaBatch() {
        Account account = new Account();
        account.setName("aa");
        this.accountService.save(account);
    }

    @Test
    public void updateBatch() {
        Account account = this.accountService.findById((long) 1);
        this.accountService.update(account);
    }

    @Test
    public void deleteBatch() {
        Account account = this.accountService.findById((long) 1);
        this.accountService.delete(account);
        this.accountService.delete(account.getId());
    }
}
