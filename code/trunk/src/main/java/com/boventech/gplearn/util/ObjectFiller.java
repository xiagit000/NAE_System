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

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.ss.usermodel.CellStyle;


public abstract class ObjectFiller {
    
    public void fillReport(HSSFSheet worksheet,int startRowIndex, 
            int startColIndex){ 
    }

    protected static HSSFCellStyle getCellStyle(HSSFSheet worksheet) {
        HSSFCellStyle bodyCellStyle = worksheet.getWorkbook().createCellStyle();   
        bodyCellStyle.setAlignment(CellStyle.ALIGN_CENTER);   
        bodyCellStyle.setWrapText(false);
        bodyCellStyle.setBorderBottom(CellStyle.BORDER_THIN); 
        bodyCellStyle.setBorderLeft(CellStyle.BORDER_THIN); 
        bodyCellStyle.setBorderRight(CellStyle.BORDER_THIN); 
        bodyCellStyle.setBorderTop(CellStyle.BORDER_THIN);
        return bodyCellStyle;
    } 
}
