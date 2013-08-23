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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**培训区域分类
 * @author peng.xia
 * 
 */
@Entity
@Table(name = "learnarea")
public class LearnArea implements Serializable{

    /**
	 * 
	 */
	private static final long serialVersionUID = 5316789627885496324L;

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(length = 255, nullable = false)
    private String name;

    @Column(length = 255, nullable = false)
    private String code;

    // 区域级别（省/市/县）
    @Column(length = 255, nullable = false)
    private String elCode;

    @Column(length = 2000)
    private String address;

    // 负责人
    @Column(length = 255, nullable = false)
    private String personIncharge;

    @Column(length = 255, nullable = false)
    private String tel;

    @Column(length = 255, nullable = false)
    private String zipCode;

    @Column(length = 255, nullable = false)
    private String email;

    // 是否开启
    private boolean status;
    
    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;

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
     * @return the code
     */
    public String getCode() {
        return code;
    }

    /**
     * @param code
     *            the code to set
     */
    public void setCode(String code) {
        this.code = code;
    }

    
    public String getElCode() {
		return elCode;
	}

	public void setElCode(String elCode) {
		this.elCode = elCode;
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
     * @return the status
     */
    public boolean isStatus() {
        return status;
    }

    /**
     * @param status
     *            the status to set
     */
    public void setStatus(boolean status) {
        this.status = status;
    }

    /**
     * @return the personIncharge
     */
    public String getPersonIncharge() {
        return personIncharge;
    }

    /**
     * @param personIncharge
     *            the personIncharge to set
     */
    public void setPersonIncharge(String personIncharge) {
        this.personIncharge = personIncharge;
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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
    
}
