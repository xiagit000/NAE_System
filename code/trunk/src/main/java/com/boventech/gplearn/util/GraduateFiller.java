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

import com.boventech.gplearn.entity.Graduate;

public class GraduateFiller extends ObjectFiller {

    private List<Graduate> graduatesgrades;

    public GraduateFiller() {
        super();
    }
    
    public GraduateFiller(List<Graduate> graduates) {
        super();
        this.graduatesgrades = graduates;
    }

    public void fillReport(HSSFSheet worksheet, int startRowIndex, int startColIndex) {

        startRowIndex += 1;

        HSSFCellStyle bodyCellStyle = getCellStyle(worksheet);

        for (int i = 0; i < graduatesgrades.size(); i++) {
            HSSFRow row = worksheet.createRow((short) i + 2);

            HSSFCell cell1 = row.createCell(startColIndex + 0);
            cell1.setCellValue(String.valueOf(i));
            cell1.setCellStyle(bodyCellStyle);

            HSSFCell cell2 = row.createCell(startColIndex + 1);
            cell2.setCellValue(graduatesgrades.get(i).getGrade().getUser().getBatch().getCode() + "-"
                    + graduatesgrades.get(i).getGrade().getUser().getBatch().getName());
            cell2.setCellStyle(bodyCellStyle);

            HSSFCell cell3 = row.createCell(startColIndex + 2);
            cell3.setCellValue(graduatesgrades.get(i).getGrade().getUser().getLoginName());
            cell3.setCellStyle(bodyCellStyle);

            HSSFCell cell4 = row.createCell(startColIndex + 3);
            cell4.setCellValue(graduatesgrades.get(i).getGrade().getUser().getRealName());
            cell4.setCellStyle(bodyCellStyle);

            HSSFCell cell5 = row.createCell(startColIndex + 4);
            cell5.setCellValue(MessageTool.getMessage(graduatesgrades.get(i).getGraduateStatus().toString()));
            cell5.setCellStyle(bodyCellStyle);
        }
    }
}
