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

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class ExcelExporter {
    
    private Logger logger = Logger.getLogger(ExcelExporter.class);
    
    private static final String DEFAULT_SHEET_NAME = "sheet1";

    private static final String DEFALUT_CONTENT_TYPE = "application/vnd.ms-excel";

    public void exportXLS(HttpServletResponse response, List<String> heads, String fileName,String description,ObjectFiller filler) {

        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet worksheet = workbook.createSheet(DEFAULT_SHEET_NAME);

        int startRowIndex = 0;
        int startColIndex = 0;

        Layouter.buildReport(worksheet, startRowIndex, startColIndex,heads,description);
        filler.fillReport(worksheet, startRowIndex,startColIndex);
        
        try {
            response.setHeader("Content-Disposition", "inline; filename=" + new String(fileName.getBytes("utf-8"), "iso-8859-1"));
            response.setContentType(DEFALUT_CONTENT_TYPE);
            FileWriter.write(response, worksheet);
        } catch (Exception e) {
            e.printStackTrace();
            logger.info(e.getMessage());
        }
    }
}
