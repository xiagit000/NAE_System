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
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;

public abstract class Layouter {
    public static void buildReport(HSSFSheet worksheet, int startRowIndex, int startColIndex,
            List<String> heads) {
        buildHeaders(worksheet, startRowIndex, startColIndex, heads);
    }

    public static void buildReport(HSSFSheet worksheet, int startRowIndex, int startColIndex,
            List<String> heads,String description) {
        buildHeaders(worksheet, startRowIndex, startColIndex, heads);
        buildDescription(worksheet, startRowIndex, startColIndex,description);
    }

    private static void buildHeaders(HSSFSheet worksheet, int startRowIndex, int startColIndex,
            List<String> heads) {
        // Header字体
        Font font = worksheet.getWorkbook().createFont();
        font.setBoldweight((short) Font.BOLDWEIGHT_BOLD);
        font.setColor(HSSFColor.WHITE.index);

        // 单元格样式
        HSSFCellStyle headerCellStyle = worksheet.getWorkbook().createCellStyle();
        headerCellStyle.setFillForegroundColor(HSSFColor.GREEN.index);
        headerCellStyle.setFillBackgroundColor(HSSFColor.GREEN.index);
        headerCellStyle.setFillPattern(CellStyle.FINE_DOTS);

        headerCellStyle.setAlignment(CellStyle.ALIGN_CENTER);
        headerCellStyle.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
        headerCellStyle.setWrapText(true);
        headerCellStyle.setFont(font);
        headerCellStyle.setBorderBottom(CellStyle.BORDER_THIN);
        headerCellStyle.setBorderLeft(CellStyle.BORDER_THIN);
        headerCellStyle.setBorderRight(CellStyle.BORDER_THIN);
        headerCellStyle.setBorderTop(CellStyle.BORDER_THIN);

        // 创建字段标题
        HSSFRow rowHeader = worksheet.createRow((short) startRowIndex + 1);
        rowHeader.setHeight((short) 500);

        for (String head : heads) {
            worksheet.setColumnWidth(startColIndex, 5200);
            HSSFCell cell = rowHeader.createCell(startColIndex);
            cell.setCellValue(head);
            cell.setCellStyle(headerCellStyle);
            startColIndex++;
        }
    }

    private static void buildDescription(HSSFSheet worksheet, int startRowIndex, int startColIndex,
            String description) {
        HSSFRow rowHeader = worksheet.createRow((short) startRowIndex);
        HSSFCell cell = rowHeader.createCell(startColIndex);
        cell.setCellValue(description);
    }

    // private void buildTitle(HSSFSheet worksheet, int startRowIndex, int
    // startColIndex) {
    // // 报表标题字体
    // Font fontTitle = worksheet.getWorkbook().createFont();
    // fontTitle.setBoldweight((short) Font.BOLDWEIGHT_BOLD);
    // fontTitle.setFontHeight((short) 280);
    //
    // // 标题单元格格式
    // HSSFCellStyle cellStyleTitle = worksheet.getWorkbook().createCellStyle();
    // cellStyleTitle.setAlignment(CellStyle.ALIGN_CENTER);
    // cellStyleTitle.setWrapText(true);
    // cellStyleTitle.setFont(fontTitle);
    //
    // HSSFRow rowTitle = worksheet.createRow((short) startRowIndex);
    // rowTitle.setHeight((short) 500);
    // HSSFCell cellTitle = rowTitle.createCell(startColIndex);
    // cellTitle.setCellValue("院系列表");
    // cellTitle.setCellStyle(cellStyleTitle);
    //
    // worksheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 1));// 标题合并列
    //
    // Date date = new Date();
    // SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    // HSSFRow dateTitle = worksheet.createRow((short) startRowIndex + 1);
    // HSSFCell cellDate = dateTitle.createCell(startColIndex);
    // cellDate.setCellValue("这个报表创建于: " + dateFormat.format(date));
    // }
}
