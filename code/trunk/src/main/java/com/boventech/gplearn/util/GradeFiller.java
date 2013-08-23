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

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;

import com.boventech.gplearn.entity.Grade;


public class GradeFiller extends ObjectFiller{
    
    private List<Grade> grades;

    public GradeFiller(List<Grade> grades) {
        super();
        this.grades=grades;
    }
    
    public void fillReport(HSSFSheet worksheet,int startRowIndex, 
            int startColIndex){ 
        
        startRowIndex += 1; 
        
        HSSFCellStyle bodyCellStyle = getCellStyle(worksheet); 
        
        for (int i=0; i< grades.size(); i++) {   
            HSSFRow row = worksheet.createRow((short) i+2);   
  
            HSSFCell cell1 = row.createCell(startColIndex+0);   
            cell1.setCellValue(String.valueOf(i));   
            cell1.setCellStyle(bodyCellStyle);   
  
            HSSFCell cell2 = row.createCell(startColIndex+1);   
            cell2.setCellValue(grades.get(i).getUser().getBatch().getCode()+"-"+grades.get(i).getUser().getBatch().getName());   
            cell2.setCellStyle(bodyCellStyle);   
            
            
            HSSFCell cell3 = row.createCell(startColIndex+2);   
            cell3.setCellValue(grades.get(i).getUser().getLoginName());   
            cell3.setCellStyle(bodyCellStyle);
            
            HSSFCell cell4 = row.createCell(startColIndex+3);   
            cell4.setCellValue(grades.get(i).getUser().getRealName());   
            cell4.setCellStyle(bodyCellStyle);  
            
            HSSFCell cell5 = row.createCell(startColIndex+4);   
            cell5.setCellValue(grades.get(i).getLearnVideoScore());   
            cell5.setCellStyle(bodyCellStyle);  
            
            HSSFCell cell6 = row.createCell(startColIndex+5);   
            cell6.setCellValue(grades.get(i).getLearnThesisScore());   
            cell6.setCellStyle(bodyCellStyle); 
            
            HSSFCell cell7 = row.createCell(startColIndex+6);   
            cell7.setCellValue(grades.get(i).getLearnDiscussScore());   
            cell7.setCellStyle(bodyCellStyle);  
            
            HSSFCell cell8 = row.createCell(startColIndex+7);   
            cell8.setCellValue(grades.get(i).getUsuallyScore());   
            cell8.setCellStyle(bodyCellStyle);  
        }

    }
}
