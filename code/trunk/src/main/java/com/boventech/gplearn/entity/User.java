package com.boventech.gplearn.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User implements Serializable {

    private static final long serialVersionUID = -8943523480516453566L;

    // 用户级别（系统管理员，省督导员，校督导员，学科专家，项目专家，老师，学生）
    public enum UserType {
        System_Administrator, Province_Supervisor, School_Supervisor, Subject_Specialists, Project_Specialists, Teacher, Student
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    // 用户类型
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private UserType userType;

    // 登录名
    @Column(length = 255, nullable = false)
    private String loginName;

    // 密码
    @Column(length = 255, nullable = false)
    private String password;

    @OneToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name="account_id")
    private Account account;

    // 批次
    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "batch_id")
    private Batch batch;

    @Enumerated(EnumType.STRING)
    private boolean active;
    
    private String realName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Batch getBatch() {
        return batch;
    }

    public void setBatch(Batch batch) {
        this.batch = batch;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}
    
}
