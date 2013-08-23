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

import org.junit.Assert;
import org.junit.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.web.servlet.ModelAndView;

public class AccountControllerTest extends JUnitControllerBase {

    @Test
    public void index() throws Exception {
        MockHttpServletRequest request = new MockHttpServletRequest();
        MockHttpServletResponse response = new MockHttpServletResponse();
        request.setServletPath("/account");
        request.setMethod("GET");
        final ModelAndView mav = this.excuteAction(request, response);
        Assert.assertEquals(null, mav.getViewName());
    }

    @Test
    public void update() throws Exception {
        MockHttpServletRequest request = new MockHttpServletRequest();
        MockHttpServletResponse response = new MockHttpServletResponse();
        request.setServletPath("/account/2");
        request.setMethod("PUT");
        final ModelAndView mav = this.excuteAction(request, response);
        Assert.assertEquals(null, mav.getViewName());
    }
}
