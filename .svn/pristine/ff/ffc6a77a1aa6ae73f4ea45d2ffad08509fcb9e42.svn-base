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

package com.boventech.gplearn.service.impl;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.boventech.gplearn.dao.AccountDao;
import com.boventech.gplearn.dao.UserDao;
import com.boventech.gplearn.entity.Account;
import com.boventech.gplearn.entity.Account.HighestDegree;
import com.boventech.gplearn.entity.Account.HighestEducationalBackground;
import com.boventech.gplearn.entity.Account.IdType;
import com.boventech.gplearn.entity.Account.Politicallandscape;
import com.boventech.gplearn.entity.Account.WorkNature;
import com.boventech.gplearn.entity.EnrollmentPlan;
import com.boventech.gplearn.service.AccountService;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountDao accountDao;
    
    @Autowired
    private UserDao userDao;

    @Autowired
    private MessageSource messageSource;

    @Override
    public void save(Account t) {
        this.accountDao.save(t);
    }

    @Override
    public void delete(Account t) {
        this.accountDao.delete(t);
    }

    @Override
    public void delete(Long id) {
        this.accountDao.deleteById(id);
    }

    @Override
    public void update(Account t) {
        this.accountDao.update(t);
    }

    @Override
    public Account findById(Long id) {
        return this.accountDao.findByID(id);
    }

    @Override
    public void save(List<Account> accounts) {
        this.accountDao.save(accounts);
    }


    @Override
    public boolean isExistByIdNumber(String number) {
        return this.accountDao.isExistByIdNumber(number);
    }
    
    @Override
    public boolean isExistByIdNumberWithoutCurrent(Account account){
        return this.accountDao.isExistByIdNumberWithoutCurrent(account);
    }

    @Override
    public List<Account> readXls(InputStream inputStream) {
        List<Account> accounts = new ArrayList<Account>();
        try {
            String cellStr = null;
            Workbook wb = WorkbookFactory.create(inputStream);
            Sheet sheet = wb.getSheetAt(0);
            for (int i = 1; i <= sheet.getLastRowNum(); i++) {
                Account account = new Account();
                Account addAccount = new Account();
                Row row = sheet.getRow(i);
                if (row == null) {
                	continue;
                }
                for (int j = 0; j < row.getLastCellNum(); j++) {
                    Cell cell = row.getCell(j);
                    cellStr = ConvertCellStr(cell, cellStr);
                    addAccount = addingAccout(j, account, cellStr);
                }
                accounts.add(addAccount);
            }
        } catch (InvalidFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }

        return accounts;
    }

    @Override
    public int validateAccounts(List<Account> accounts,EnrollmentPlan enrollmentPlan) {
        List<String> idNums = new ArrayList<String>();
        for (int i = 0; i < accounts.size(); i++) {
            Account account = accounts.get(i);
            boolean existInExcel = idNums.contains(account.getIdNumber());
            boolean existInDateBase = this.userDao.isExistByIdNumberAndBatch(account.getIdNumber(),enrollmentPlan.getBatch());
            if (existInExcel || existInDateBase) {
                return i + 1;
            } else {
                idNums.add(account.getIdNumber());
            }
        }
        return 0;
    }

    private String ConvertCellStr(Cell cell, String cellStr) {
        switch (cell.getCellType()) {
        case Cell.CELL_TYPE_STRING:
            cellStr = cell.getStringCellValue().toString();
            break;
        case Cell.CELL_TYPE_BOOLEAN:
            cellStr = String.valueOf(cell.getBooleanCellValue());
            break;
        case Cell.CELL_TYPE_NUMERIC:
            if (DateUtil.isCellDateFormatted(cell)) {
                cellStr = cell.getDateCellValue().toString();
            } else {
                cellStr = String.valueOf(cell.getNumericCellValue());
            }
            break;
        case Cell.CELL_TYPE_FORMULA:
            cellStr = cell.getCellFormula().toString();
            break;
        }
        return cellStr;
    }

    private Account addingAccout(int j, Account account, String cellStr) {
        switch (j) {
        case 0:
            account.setIdNumber(cellStr);
            break;
        case 1:
            account.setName(cellStr);
            break;
        case 2:
            account.setSex(cellStr);
            break;
        case 3:
            account.setEthnic(cellStr);
            break;
        case 4:
            account.setIdType(getIdType(cellStr));
            break;
        case 5:
            account.setSchool(cellStr);
            break;
        case 6:
            account.setPoliticallandscape(getPoliticallandscape(cellStr));
            break;
        case 7:
            account.setAddress(cellStr);
            break;
        case 8:
            account.setContactAddr(cellStr);
            break;
        case 9:
            account.setZipCode(cellStr);
            break;
        case 10:
            account.setEmail(cellStr);
            break;
        case 11:
            account.setTel(cellStr);
            break;
        case 12:
            account.setHignestDegree(getHighestDegree(cellStr));
            break;
        case 13:
            account.setHighestEducationalBackground(getHighestEducationalBackground(cellStr));
            break;
        case 14:
            account.setGraduatedSchool(cellStr);
            break;
        case 15:
            account.setGraduatedSpecialty(cellStr);
            break;
        case 16:
            account.setWorkPlace(cellStr);
            break;
        case 17:
            account.setWorkNature(getWorkNature(cellStr));
            break;
        case 18:
            account.setWorkTitles(cellStr);
            break;
        case 19:
            account.setPosition(cellStr);
            break;
        case 20:
            account.setWorkYear(Integer.parseInt(cellStr));
            break;
        case 21:
            account.setWorkDescription(cellStr);
            break;
        case 22:
            account.setLearnAndRewardInfo(cellStr);
            break;
        case 23:
            account.setDescription(cellStr);
            break;
        }
        return account;
    }

    private String getMessage(String key) {
        return messageSource.getMessage(key, null, null);
    }

    private IdType getIdType(String msg) {
        IdType idType = null;
        if (getMessage("ID_Cards").equals(msg)) {
            idType = IdType.ID_Cards;
        }
        if (getMessage("Passport").equals(msg)) {
            idType = IdType.Passport;
        }
        if (getMessage("Certificate_Of_Officers").equals(msg)) {
            idType = IdType.Certificate_Of_Officers;
        }
        if (getMessage("Valid_Exit_Entry_Permit_To_HK_Macau").equals(msg)) {
            idType = IdType.Valid_Exit_Entry_Permit_To_HK_Macau;
        }
        if (getMessage("Other").equals(msg)) {
            idType = IdType.Other;
        }
        return idType;
    }

    private Politicallandscape getPoliticallandscape(String msg) {
        Politicallandscape politicallandscape = null;
        if (getMessage("Communist_Party").equals(msg)) {
            politicallandscape = Politicallandscape.Communist_Party;
        }
        if (getMessage("Communist_Youth_League").equals(msg)) {
            politicallandscape = Politicallandscape.Communist_Youth_League;
        }
        if (getMessage("Masses").equals(msg)) {
            politicallandscape = Politicallandscape.Masses;
        }
        return politicallandscape;
    }

    private HighestDegree getHighestDegree(String msg) {
        HighestDegree degree = null;
        if (getMessage("Bachelor").equals(msg)) {
            degree = HighestDegree.Bachelor;
        }
        if (getMessage("Master").equals(msg)) {
            degree = HighestDegree.Master;
        }
        if (getMessage("Doctor").equals(msg)) {
            degree = HighestDegree.Doctor;
        }
        return degree;
    }

    private HighestEducationalBackground getHighestEducationalBackground(String msg) {
        HighestEducationalBackground background = null;
        if (getMessage("High_School").equals(msg)) {
            background = HighestEducationalBackground.High_School;
        }
        if (getMessage("Technician_Training_School").equals(msg)) {
            background = HighestEducationalBackground.Technician_Training_School;
        }
        if (getMessage("Trade_School").equals(msg)) {
            background = HighestEducationalBackground.Trade_School;
        }
        if (getMessage("Junior_College").equals(msg)) {
            background = HighestEducationalBackground.Junior_College;
        }
        if (getMessage("Undergraduate_College").equals(msg)) {
            background = HighestEducationalBackground.Undergraduate_College;
        }
        if (getMessage("Graduate_Student").equals(msg)) {
            background = HighestEducationalBackground.Graduate_Student;
        }
        if (getMessage("Other").equals(msg)) {
            background = HighestEducationalBackground.Other;
        }
        return background;
    }

    private WorkNature getWorkNature(String msg) {
        WorkNature workNature = null;
        if (getMessage("Foreign_Funded_Enterprises").equals(msg)) {
            workNature = WorkNature.Foreign_Funded_Enterprises;
        }
        if (getMessage("Joint_Venture").equals(msg)) {
            workNature = WorkNature.Joint_Venture;
        }
        if (getMessage("Private_Enterprise").equals(msg)) {
            workNature = WorkNature.Private_Enterprise;
        }
        if (getMessage("Army").equals(msg)) {
            workNature = WorkNature.Army;
        }
        if (getMessage("StateOwned_Enterprise").equals(msg)) {
            workNature = WorkNature.StateOwned_Enterprise;
        }
        if (getMessage("Institution").equals(msg)) {
            workNature = WorkNature.Institution;
        }
        if (getMessage("Government_Agency").equals(msg)) {
            workNature = WorkNature.Government_Agency;
        }
        return workNature;
    }

	@Override
	public List<Account> listBySchool(String school) {
		return accountDao.listBySchool(school);
	}

	@Override
	public List<Account> listWithPagination(Integer page) {
		return accountDao.listWithPagination(page);
	}
}
