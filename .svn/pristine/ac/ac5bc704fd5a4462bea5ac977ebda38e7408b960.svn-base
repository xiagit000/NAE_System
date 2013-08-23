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

/**
 * @author peng.xia
 *
 */
public class BatchControllerTest extends JUnitControllerBase{
    
  @Test
  public void index() throws Exception{
      MockHttpServletRequest request = new MockHttpServletRequest();  
      MockHttpServletResponse response = new MockHttpServletResponse();  
      request.setServletPath("/batch");
      request.setMethod("GET"); 
      final ModelAndView mav = this.excuteAction(request, response);  
      Assert.assertEquals("/batch/index", mav.getViewName());  
  }
  
}
