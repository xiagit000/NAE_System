/*
 * Copyright 2010. 
 * 
 * This document may not be reproduced, distributed or used 
 * in any manner whatsoever without the expressed written 
 * permission of Boventech Corp. 
 * 
 * $Rev: 1 $
 * $Author: dongming.xie $
 * $LastChangedDate: 2012-07-03 14:26:35 +0800 (二, 2012-07-03) $
 *
 */

package com.boventech.gplearn.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 日期相关处理工具类
 *
 */
public final class DateUtil {
    public static final String COMMON_DATE_FORMAT = "yyyy-MM-dd";
    
    private DateUtil() {
    };

    /**
     * 本月最初时间
     * @return
     */
    public static Date firstDateTimeOfCurrentMonth() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMinimum(Calendar.DAY_OF_MONTH));
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        Date begin = calendar.getTime();
        return begin;
    }

    /**
     * 本月最后时间
     * 
     * @return
     */
    public static Date lastDateTimeOfCurrentMonth() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        calendar.set(Calendar.MILLISECOND, 999);
        Date end = calendar.getTime();
        return end;
    }
    
    /**
     * yyyy-MM-dd
     * @param dateString
     * @return
     * @throws ParseException 
     */
    public static Date lastDateTimeOfDay(String dateString) throws ParseException{
        Calendar calendar = Calendar.getInstance();
        
        Pattern p = Pattern.compile("^(\\d{1,4})[\\-]{1}(\\d{1,2})[\\-]{1}(\\d{1,2})$");
        Matcher m = p.matcher(dateString);

        if(m.matches()){
            int year = Integer.parseInt(m.group(1));
            int month = Integer.parseInt(m.group(2));
            int day = Integer.parseInt(m.group(3));
            calendar.set(Calendar.YEAR, year);
            calendar.set(Calendar.MONDAY, month - 1);
            calendar.set(Calendar.DAY_OF_MONTH, day);
            calendar.set(Calendar.HOUR_OF_DAY, 23);
            calendar.set(Calendar.MINUTE, 59);
            calendar.set(Calendar.SECOND, 59);
            calendar.set(Calendar.MILLISECOND, 999);
            Date end = calendar.getTime();
            return end;
        }else{
            throw new ParseException(dateString, 0);
        }
    }
    
    public static boolean dateValidation(String date){
    	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
    	sdf.setLenient(false);
    	try {
			sdf.parse(date);
			return true;
		} catch (ParseException e) {
			return false;
		}
    }
    
    public static String formatByPattern(Date date,String pattern){
        SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
        dateFormat.setLenient(false);
        return dateFormat.format(date);
    }
}
