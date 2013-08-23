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

package com.boventech.gplearn.util;

import org.hibernate.Hibernate;
import org.hibernate.dialect.MySQL5InnoDBDialect;
import org.hibernate.dialect.function.SQLFunctionTemplate;

/**
 * 
 */
public class MySQLDialect extends MySQL5InnoDBDialect {

    @SuppressWarnings("deprecation")
    public MySQLDialect() {
        super();
        registerFunction("regexp", new SQLFunctionTemplate(Hibernate.BOOLEAN, "?1 REGEXP ?2"));
    }
}