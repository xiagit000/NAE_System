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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.MessageSource;
import org.springframework.context.event.ContextRefreshedEvent;

public class MessageTool implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private MessageSource messageSource;

    private static MessageSource source;

    public static String getMessage(String key) {
        return source.getMessage(key, null, null);
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent arg0) {
        source = messageSource;
    }
}
