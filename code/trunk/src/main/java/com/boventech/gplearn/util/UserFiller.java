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

import com.boventech.gplearn.entity.User;


public class UserFiller extends ObjectFiller{
    
    private List<User> users;
    
    public UserFiller(List<User> users) {
        super();
        this.users=users;
    }

    public void fillReport(HSSFSheet worksheet,int startRowIndex, 
            int startColIndex){ 
        
        startRowIndex += 1; 
        
        HSSFCellStyle bodyCellStyle = getCellStyle(worksheet); 
        
        for (int i=0; i< users.size(); i++) {   
            HSSFRow row = worksheet.createRow((short) i+2);   
  
            HSSFCell cell1 = row.createCell(startColIndex+0);   
            cell1.setCellValue(String.valueOf(i));   
            cell1.setCellStyle(bodyCellStyle);   
  
            HSSFCell cell2 = row.createCell(startColIndex+1);   
            cell2.setCellValue(users.get(i).getLoginName());   
            cell2.setCellStyle(bodyCellStyle);   
            
            
            HSSFCell cell3 = row.createCell(startColIndex+2);   
            cell3.setCellValue(users.get(i).getRealName());   
            cell3.setCellStyle(bodyCellStyle);
            
            if(users.get(i).getAccount()!=null){
            HSSFCell cell4 = row.createCell(startColIndex+3);   
            cell4.setCellValue(users.get(i).getAccount().getIdType().toString());   
            cell4.setCellStyle(bodyCellStyle);  
            
            HSSFCell cell5 = row.createCell(startColIndex+4);   
            cell5.setCellValue(users.get(i).getAccount().getIdNumber());   
            cell5.setCellStyle(bodyCellStyle);  
            }
            
            if(users.get(i).getBatch()!=null){
            HSSFCell cell6 = row.createCell(startColIndex+5);   
            cell6.setCellValue(users.get(i).getBatch().getName());   
            cell6.setCellStyle(bodyCellStyle);  
            }
        }

    }
}
