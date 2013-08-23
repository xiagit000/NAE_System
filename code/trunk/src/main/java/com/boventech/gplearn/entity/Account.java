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

package com.boventech.gplearn.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 注册用户（非登录） 模型
 * 
 */
@Entity
@Table(name = "account")
public class Account implements Serializable {

    /**
	 * 
	 */
    private static final long serialVersionUID = -6979831207994338519L;

    // 证件类型（身份证，护照，军官证，港澳台通行证）
    public enum IdType {
        ID_Cards, Passport, Certificate_Of_Officers, Valid_Exit_Entry_Permit_To_HK_Macau, Other
    }

    // 政治面貌（共产党，共青团，群众）
    public enum Politicallandscape {
        Communist_Party, Communist_Youth_League, Masses
    }

    // 最高学位（学士，硕士，博士）
    public enum HighestDegree {
        Bachelor, Master, Doctor
    }

    // 最高学历（高中，技校，中专，大专，本科，研究生）
    public enum HighestEducationalBackground {
        High_School, Technician_Training_School, Trade_School, Junior_College, Undergraduate_College, Graduate_Student, Other
    }

    // 单位性质（外企，合资企业，私企，军队，国企，事业单位，政府机构）
    public enum WorkNature {
        Foreign_Funded_Enterprises, Joint_Venture, Private_Enterprise, Army, StateOwned_Enterprise, Institution, Government_Agency
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(length = 20, nullable = false)
    private String name;

    @Column(length = 10, nullable = false)
    private String sex;

    // 民族
    @Column(length = 10, nullable = false)
    private String ethnic;

    // 证件类型
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private IdType idType;

    // 目前所在院校
    @Column(nullable = false)
    private String school;

    // 证件号码
    @Column(length = 40, nullable = false)
    private String idNumber;

    // 政治面貌
    @Enumerated(EnumType.STRING)
    private Politicallandscape politicallandscape;

    // 居住地
    @Column(length = 2000, nullable = false)
    private String address;

    // 联系地址
    @Column(length = 2000, nullable = false)
    private String contactAddr;

    @Column(length = 255)
    private String zipCode;

    @Column(length = 255, nullable = false)
    private String email;

    @Column(length = 255, nullable = false)
    private String tel;

    // 最高学位
    @Enumerated(EnumType.STRING)
    private HighestDegree hignestDegree;

    // 最高学历
    @Enumerated(EnumType.STRING)
    private HighestEducationalBackground highestEducationalBackground;

    // 毕业院校
    @Column(length = 255)
    private String graduatedSchool;

    // 毕业专业
    @Column(length = 255)
    private String graduatedSpecialty;

    // 工作单位
    @Column(length = 255, nullable = false)
    private String workPlace;

    // 工作性质
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private WorkNature workNature;

    // 工作职位
    @Column(length = 255, nullable = false)
    private String position;

    // 工作职称
    @Column(length = 255)
    private String workTitles;

    // 工作年限
    @Column(length = 10, nullable = false)
    private int workYear;

    // 工作简历
    @Column(length = 2555)
    private String workDescription;

    // 培训和获奖信息
    @Column(length = 255)
    private String learnAndRewardInfo;

    // 备注
    @Column(length = 1500)
    private String description;
    
    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id
     *            the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     *            the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the sex
     */
    public String getSex() {
        return sex;
    }

    /**
     * @param sex
     *            the sex to set
     */
    public void setSex(String sex) {
        this.sex = sex;
    }

    /**
     * @return the ethnic
     */
    public String getEthnic() {
        return ethnic;
    }

    /**
     * @param ethnic
     *            the ethnic to set
     */
    public void setEthnic(String ethnic) {
        this.ethnic = ethnic;
    }

    /**
     * @return the idType
     */
    public IdType getIdType() {
        return idType;
    }

    /**
     * @param idType
     *            the idType to set
     */
    public void setIdType(IdType idType) {
        this.idType = idType;
    }

    /**
     * @return the idNumber
     */
    public String getIdNumber() {
        return idNumber;
    }

    /**
     * @param idNumber
     *            the idNumber to set
     */
    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    /**
     * @return the politicallandscape
     */
    public Politicallandscape getPoliticallandscape() {
        return politicallandscape;
    }

    /**
     * @param politicallandscape
     *            the politicallandscape to set
     */
    public void setPoliticallandscape(Politicallandscape politicallandscape) {
        this.politicallandscape = politicallandscape;
    }

    /**
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address
     *            the address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * @return the contactAddr
     */
    public String getContactAddr() {
        return contactAddr;
    }

    /**
     * @param contactAddr
     *            the contactAddr to set
     */
    public void setContactAddr(String contactAddr) {
        this.contactAddr = contactAddr;
    }

    /**
     * @return the zipCode
     */
    public String getZipCode() {
        return zipCode;
    }

    /**
     * @param zipCode
     *            the zipCode to set
     */
    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email
     *            the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the tel
     */
    public String getTel() {
        return tel;
    }

    /**
     * @param tel
     *            the tel to set
     */
    public void setTel(String tel) {
        this.tel = tel;
    }

    /**
     * @return the hignestDegree
     */
    public HighestDegree getHignestDegree() {
        return hignestDegree;
    }

    /**
     * @param hignestDegree
     *            the hignestDegree to set
     */
    public void setHignestDegree(HighestDegree hignestDegree) {
        this.hignestDegree = hignestDegree;
    }

    /**
     * @return the highestEducationalBackground
     */
    public HighestEducationalBackground getHighestEducationalBackground() {
        return highestEducationalBackground;
    }

    /**
     * @param highestEducationalBackground
     *            the highestEducationalBackground to set
     */
    public void setHighestEducationalBackground(HighestEducationalBackground highestEducationalBackground) {
        this.highestEducationalBackground = highestEducationalBackground;
    }

    /**
     * @return the graduatedSchool
     */
    public String getGraduatedSchool() {
        return graduatedSchool;
    }

    /**
     * @param graduatedSchool
     *            the graduatedSchool to set
     */
    public void setGraduatedSchool(String graduatedSchool) {
        this.graduatedSchool = graduatedSchool;
    }

    /**
     * @return the graduatedSpecialty
     */
    public String getGraduatedSpecialty() {
        return graduatedSpecialty;
    }

    /**
     * @param graduatedSpecialty
     *            the graduatedSpecialty to set
     */
    public void setGraduatedSpecialty(String graduatedSpecialty) {
        this.graduatedSpecialty = graduatedSpecialty;
    }

    /**
     * @return the workPlace
     */
    public String getWorkPlace() {
        return workPlace;
    }

    /**
     * @param workPlace
     *            the workPlace to set
     */
    public void setWorkPlace(String workPlace) {
        this.workPlace = workPlace;
    }

    /**
     * @return the workNature
     */
    public WorkNature getWorkNature() {
        return workNature;
    }

    /**
     * @param workNature
     *            the workNature to set
     */
    public void setWorkNature(WorkNature workNature) {
        this.workNature = workNature;
    }

    /**
     * @return the position
     */
    public String getPosition() {
        return position;
    }

    /**
     * @param position
     *            the position to set
     */
    public void setPosition(String position) {
        this.position = position;
    }

    /**
     * @return the workTitles
     */
    public String getWorkTitles() {
        return workTitles;
    }

    /**
     * @param workTitles
     *            the workTitles to set
     */
    public void setWorkTitles(String workTitles) {
        this.workTitles = workTitles;
    }

    /**
     * @return the workYear
     */
    public int getWorkYear() {
        return workYear;
    }

    /**
     * @param workYear
     *            the workYear to set
     */
    public void setWorkYear(int workYear) {
        this.workYear = workYear;
    }

    /**
     * @return the workDescription
     */
    public String getWorkDescription() {
        return workDescription;
    }

    /**
     * @param workDescription
     *            the workDescription to set
     */
    public void setWorkDescription(String workDescription) {
        this.workDescription = workDescription;
    }

    /**
     * @return the learnAndRewardInfo
     */
    public String getLearnAndRewardInfo() {
        return learnAndRewardInfo;
    }

    /**
     * @param learnAndRewardInfo
     *            the learnAndRewardInfo to set
     */
    public void setLearnAndRewardInfo(String learnAndRewardInfo) {
        this.learnAndRewardInfo = learnAndRewardInfo;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description
     *            the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }
    
}
