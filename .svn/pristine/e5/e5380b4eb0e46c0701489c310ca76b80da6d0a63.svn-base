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

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFSheet;

public class FileWriter {
    
    private static Logger logger = Logger.getLogger("FileWrite");
    
    public static void write(HttpServletResponse response, HSSFSheet worksheet) {

        logger.debug("Writing report to the stream");
        try {
            // Retrieve the output stream
            ServletOutputStream outputStream = response.getOutputStream();
            // Write to the output stream
            worksheet.getWorkbook().write(outputStream);
            // 清除缓存
            outputStream.flush();

        } catch (Exception e) {
            logger.error("报表输入失败!");
        }
    }
}
