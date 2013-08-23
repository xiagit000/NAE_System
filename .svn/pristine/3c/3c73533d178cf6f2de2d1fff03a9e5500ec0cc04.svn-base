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

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sun.misc.BASE64Encoder;

import com.boventech.gplearn.dao.UserDao;
import com.boventech.gplearn.entity.Account;
import com.boventech.gplearn.entity.Batch;
import com.boventech.gplearn.entity.Discipline;
import com.boventech.gplearn.entity.EnrollmentPlan;
import com.boventech.gplearn.entity.Grade;
import com.boventech.gplearn.entity.Graduate;
import com.boventech.gplearn.entity.LearnArea;
import com.boventech.gplearn.entity.LearnClass;
import com.boventech.gplearn.entity.LearnSubProject;
import com.boventech.gplearn.entity.SchoolRoll;
import com.boventech.gplearn.entity.SchoolSpace;
import com.boventech.gplearn.entity.SpaceType;
import com.boventech.gplearn.entity.User;
import com.boventech.gplearn.entity.User.UserType;
import com.boventech.gplearn.exception.StudySpaceCreateFaildException;
import com.boventech.gplearn.exception.UserDestroyInCASFaildException;
import com.boventech.gplearn.exception.UserDestroyInStudySpaceFaildException;
import com.boventech.gplearn.exception.UserInfoPushToStudySpaceClassRoomFaildException;
import com.boventech.gplearn.exception.UserInfoPushToStudySpaceFaildException;
import com.boventech.gplearn.exception.UserInfoSendCASFaildException;
import com.boventech.gplearn.exception.UserUpdateToCASFaildException;
import com.boventech.gplearn.service.AccountService;
import com.boventech.gplearn.service.BatchService;
import com.boventech.gplearn.service.DisciplineService;
import com.boventech.gplearn.service.EnrollmentPlanService;
import com.boventech.gplearn.service.GradeService;
import com.boventech.gplearn.service.GraduateService;
import com.boventech.gplearn.service.LearnAreaService;
import com.boventech.gplearn.service.LearnClassService;
import com.boventech.gplearn.service.LearnSubProjectService;
import com.boventech.gplearn.service.LearnThesisSubmitInfomationService;
import com.boventech.gplearn.service.QuestionService;
import com.boventech.gplearn.service.ReceiverNotificationService;
import com.boventech.gplearn.service.SchoolRollService;
import com.boventech.gplearn.service.SchoolSpaceService;
import com.boventech.gplearn.service.SenderNotificationService;
import com.boventech.gplearn.service.UserService;
import com.boventech.gplearn.util.CASPlatformHttpClient;
import com.boventech.gplearn.util.StudyPlatformHttpClient;
import com.google.common.collect.Lists;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private AccountService accountService;

    @Autowired
    private SchoolSpaceService schoolSpaceService;

    @Autowired
    private SchoolRollService schoolRollService;

    @Autowired
    private GradeService gradeService;

    @Autowired
    private GraduateService graduateService;

    @Autowired
    private DisciplineService disciplineService;

    @Autowired
    private LearnSubProjectService learnSubProjectService;

    @Autowired
    private LearnAreaService learnAreaService;

    @Autowired
    private LearnClassService learnClassService;

    @Autowired
    private EnrollmentPlanService enrollmentPlanService;
    
    @Autowired
    private BatchService batchService;

    @Autowired
    private LearnThesisSubmitInfomationService learnThesisSubmitService;
    
    @Autowired
    private QuestionService questionService;
    
    @Autowired
    private SenderNotificationService senderNotificationService;
    
    @Autowired
    private ReceiverNotificationService receiverNotificationService;
    
    
    @Override
    public void save(User t) {
        this.userDao.save(t);
    }

    @Override
    public void save(List<User> users) {
        this.userDao.save(users);
    }

    @Override
    public void delete(User t) {
        this.userDao.delete(t);
    }

    @Override
    public void delete(Long id) {
        this.userDao.deleteById(id);
    }

    @Override
    public void update(User t) {
        this.userDao.update(t);
    }

    @Override
    public User findById(Long id) {
        return this.userDao.findByID(id);
    }

    @Override
    public Long getMaxIndex() {
        return this.userDao.getMaxIndex();
    }

    @Override
    public List<User> generateUsers(List<Account> accounts, EnrollmentPlan enrollmentPlan) {
        List<User> users = new ArrayList<User>();
        for (Account account : accounts) {
            User user = new User();
            user.setUserType(UserType.Student);
            user.setLoginName(getLoginName(enrollmentPlan));
            user.setPassword((new BASE64Encoder()).encode(account.getIdNumber().getBytes()));
            user.setAccount(account);
            user.setBatch(enrollmentPlan.getBatch());
            user.setActive(false);
            user.setRealName(account.getName());
            users.add(user);
        }
        return users;
    }

    private String getLoginName(EnrollmentPlan enrollmentPlan) {
        String name = "gp";
        name += getYear();
        name += getAreaCode(enrollmentPlan);
        name += getDisciplineCode(enrollmentPlan);
        return name;
    }

    private String getYear() {
        @SuppressWarnings("deprecation")
        String year = String.valueOf(new Date().getYear() % 100);
        return year;
    }

    private String getAreaCode(EnrollmentPlan enrollmentPlan) {
        return enrollmentPlan.getLearnClass().getLearnArea().getElCode().split("-")[0];
    }

    private String getDisciplineCode(EnrollmentPlan enrollmentPlan) {
        return enrollmentPlan.getLearnClass().getLearnProject().getDiscipline().getCode();
    }

    @Override
    public List<User> listAllWithPagnate(Integer page) {
        return this.userDao.listAllWithPagnate(page);
    }

    @Override
    public List<User> listAllWithoutPagnate() {
        return this.userDao.listAllWithoutPagnate();
    }

    @Override
    public boolean checkEntityExsitByLoginName(String loginName) {
        return userDao.checkEntityExsitByLoginName(loginName);
    }

    @Override
    public User findByLoginName(String loginName) {
        return userDao.findByLoginName(loginName);
    }

    @Override
    public List<User> listSearchWithPagnate(Integer page, User user, Account account, Batch batch,
            LearnClass learnClass) {
        return userDao.listSerchWithPagnate(page, user, account, batch, learnClass);
    }

    @Override
    public List<User> listSearchWithoutPagnate(User user, Account account, Batch batch, LearnClass learnClass) {
        return userDao.listSerchWithoutPagnate(user, account, batch, learnClass);
    }

    @Transactional(rollbackFor = { UserInfoSendCASFaildException.class,
            UserInfoPushToStudySpaceFaildException.class,
            UserInfoPushToStudySpaceClassRoomFaildException.class })
    @Override
    public void saveAllAccountInformation(List<Account> accounts, EnrollmentPlan enrollmentPlan)
            throws UserInfoSendCASFaildException, UserInfoPushToStudySpaceFaildException,
            UserInfoPushToStudySpaceClassRoomFaildException, StudySpaceCreateFaildException {
        this.accountService.save(accounts);

        // 批量生成学校空间和账号
        List<User> users = generateUsers(accounts, enrollmentPlan);
        List<SchoolSpace> schoolSpaces = this.schoolSpaceService.generateSchoolSpaces(accounts,
                enrollmentPlan);
        this.schoolSpaceService.save(schoolSpaces);
        save(users);

        // 批量生成成绩和学籍
        List<SchoolRoll> schoolRolls = this.schoolRollService.generateSchoolRolls(users, enrollmentPlan);
        List<Grade> grades = this.gradeService.generateGrades(users,enrollmentPlan);
        this.schoolRollService.save(schoolRolls);
        this.gradeService.save(grades);

        // 批量生成结业信息
        List<Graduate> graduates = this.graduateService.generateGraduates(grades);
        this.graduateService.save(graduates);

        // 2013.5.16 si.li
        // 将用户信息推送到CAS
        pushUserToTheCAS(users);

        // 将用户推送到学科空间
        String disciplineId = enrollmentPlan.getLearnClass().getLearnProject().getDiscipline().getId()
                .toString();
        pushUserToTheStudySpace(users, disciplineId);

        // 将用户推送到校本研修空间
        pushUserToTheXBYXSpace(users, disciplineId);

        List<SchoolSpace> savedSchoolSpaces = schoolSpaceService.listByUncreate();
        // 生成学校空间
        pushShoolSpace(savedSchoolSpaces);

        // 将学生放入学校空间
        List<SchoolSpace> allSchoolSpace = schoolSpaceService.listWithCurrentBatch(batchService.getCurrentBatch());
        pushUserToTheSchoolSpace(users, allSchoolSpace);

        // 将用户推送到学科空间的班级小组
        pushUserToTheStudySpaceClassRoom(users, disciplineId, enrollmentPlan.getLearnClass()
                .getLearnClassStudySpaceId());

    }

    private void pushUserToTheSchoolSpace(List<User> users, List<SchoolSpace> schoolSpaces)
            throws UserInfoPushToStudySpaceFaildException {
        Integer statuCode = null;
        StudyPlatformHttpClient client = new StudyPlatformHttpClient();
        for (User user : users) {
            for (SchoolSpace schoolSpace : schoolSpaces) {
                if (user.getAccount().getSchool().equals(schoolSpace.getSchoolName())) {
                    statuCode = client.createUserToSchoolpace(user, schoolSpace);
                    if (statuCode != 200 && statuCode!=409) {
                        throw new UserInfoPushToStudySpaceFaildException();
                    }
                }
            }
        }
    }

    /**
     * TODO 13 设置学校空间
     * 
     * @param schoolSpaces
     * @throws StudySpaceCreateFaildException
     */
    private void pushShoolSpace(List<SchoolSpace> schoolSpaces) throws StudySpaceCreateFaildException {
        Integer statusCode = null;
        StudyPlatformHttpClient client = new StudyPlatformHttpClient();
        for (SchoolSpace schoolspace : schoolSpaces) {
            schoolspace.setCreted(true);
            schoolSpaceService.update(schoolspace);
            statusCode = client.createSchoolSpace(schoolspace);
            if (statusCode != 200 && statusCode!=409) {
                throw new StudySpaceCreateFaildException();
            }
        }

    }

    /**
     * TODO 12将用户推送到校本研修空间[集成完成]
     * 
     * @param user
     * @param disciplineId
     * @param learnClassAccessSpaceId
     * @return
     * @throws UserInfoPushToStudySpaceFaildException
     */
    private void pushUserToTheXBYXSpace(List<User> users, String disciplineId)
            throws UserInfoPushToStudySpaceFaildException {
        StudyPlatformHttpClient client = new StudyPlatformHttpClient();
        Integer statusCode = 0;
        for (User user : users) {
            statusCode = client.createUserToXBYXSpace(user, disciplineId);
            if (statusCode != 200 && statusCode!=409) {
                throw new UserInfoPushToStudySpaceFaildException();
            }
        }

    }

    /**
     * TODO 4将账号推送到CAS平台[集成完成] (List)
     * 
     * @throws UserInfoSendCASFaildException
     */
    private void pushUserToTheCAS(List<User> users) throws UserInfoSendCASFaildException {
        CASPlatformHttpClient client = new CASPlatformHttpClient();
        Integer statusCode = 0;
        for (User user : users) {
            statusCode = client.createUserToCAS(user);
            if (statusCode != 200 && statusCode!=409) {
                throw new UserInfoSendCASFaildException();
            }
        }
    }

    /**
     * TODO 5将学科用户推送到班级小组[集成完成]
     * 
     * @param user
     * @param disciplineId
     * @param learnClassAccessSpaceId
     * @return
     * @throws UserInfoPushToStudySpaceClassRoomFaildException
     */
    private void pushUserToTheStudySpaceClassRoom(List<User> users, String disciplineId,
            String learnClassAccessSpaceId) throws UserInfoPushToStudySpaceClassRoomFaildException {
        StudyPlatformHttpClient client = new StudyPlatformHttpClient();
        Integer statusCode = 0;
        for (User user : users) {
            statusCode = client.createUserToStudySpaceClassRoom(user, learnClassAccessSpaceId, disciplineId);
            if (statusCode != 200 && statusCode!=409) {
                throw new UserInfoPushToStudySpaceClassRoomFaildException();
            }
        }
    }

    /**
     * TODO 6将用户推送到学科空间[集成完成]
     * 
     * @param user
     * @param disciplineId
     * @param learnClassAccessSpaceId
     * @return
     * @throws UserInfoPushToStudySpaceFaildException
     */
    private void pushUserToTheStudySpace(List<User> users, String disciplineId)
            throws UserInfoPushToStudySpaceFaildException {
        StudyPlatformHttpClient client = new StudyPlatformHttpClient();
        Integer statusCode = 0;
        for (User user : users) {
            statusCode = client.createUserToStudySpace(user, disciplineId);
            if (statusCode != 200 && statusCode!=409) {
                throw new UserInfoPushToStudySpaceFaildException();
            }
        }

    }

    /**
     * 设置学科专家到学科空间
     */
    @Transactional(rollbackFor = { UserInfoSendCASFaildException.class,
            UserInfoPushToStudySpaceFaildException.class })
    @Override
    public void pushDisciplinePersonInChargeToTheStudySpace(User user, Discipline discipline)
            throws UserInfoSendCASFaildException, UserInfoPushToStudySpaceFaildException {
        save(user);
        User savedUser = findByLoginName(user.getLoginName());
        discipline.setPersonInCharge(savedUser);
        this.disciplineService.update(discipline);
        // 将学科专家信息存入CAS
        sendExpertToTheCAS(user);
        // 将学科专家信息存入学习平台空间
        sendDisciplineExpertToTheStudySpace(user, discipline.getId());
        // 将学科专家信息存入相对的校本研修空间
        sendDisciplineExpertToTheXBYXSpace(user, discipline.getId());
    }

    /**
     * TODO 11设置学科专家到校本研修空间
     * 
     * @param user
     * @param disciplineId
     * @throws UserInfoPushToStudySpaceFaildException
     */
    private void sendDisciplineExpertToTheXBYXSpace(User user, Long disciplineId)
            throws UserInfoPushToStudySpaceFaildException {
        StudyPlatformHttpClient client = new StudyPlatformHttpClient();
        Integer statusCode = client.createUserToXBYXSpace(user, disciplineId.toString());
        if (statusCode != 200 && statusCode!=409) {
            throw new UserInfoPushToStudySpaceFaildException();
        }
    }

    /**
     * TODO 7设置学科专家到CAS
     * 
     * @throws UserInfoSendCASFaildException
     */
    private void sendExpertToTheCAS(User user) throws UserInfoSendCASFaildException {
        CASPlatformHttpClient client = new CASPlatformHttpClient();
        Integer statusCode = client.createUserToCAS(user);
        if (statusCode != 200 && statusCode!=409) {
            throw new UserInfoSendCASFaildException();
        }
    }

    /**
     * TODO 8设置学科专家到学习空间
     * 
     * @param user
     * @param disciplineId
     * @throws UserInfoPushToStudySpaceFaildException
     */
    private void sendDisciplineExpertToTheStudySpace(User user, Long disciplineId)
            throws UserInfoPushToStudySpaceFaildException {
        StudyPlatformHttpClient client = new StudyPlatformHttpClient();
        Integer statusCode = client.createUserToStudySpace(user, disciplineId.toString());
        if (statusCode != 200 && statusCode!=409) {
            throw new UserInfoPushToStudySpaceFaildException();
        }
    }

    /**
     * TODO 9 从学习平台和CAS中删除用户
     * 
     * @throws UserDestroyInStudySpaceFaildException
     * @throws UserDestroyInCASFaildException
     */
    private void destroyUserAllInformation(User user) throws UserDestroyInStudySpaceFaildException,
            UserDestroyInCASFaildException {
        Integer statusCode = null;
        if (user.getUserType().equals(UserType.Teacher) || user.getUserType().equals(UserType.Student)
                || user.getUserType().equals(UserType.Subject_Specialists)) {

        	Discipline discipline=null;
        	if(user.getUserType().equals(UserType.Student)){
	            SchoolRoll schoolRoll = schoolRollService.findByUserNewest(user);
	            discipline = schoolRoll.getLearnClass().getLearnProject().getDiscipline();
        	}
        	if(user.getUserType().equals(UserType.Teacher)){
        		LearnClass learnClass = learnClassService.findByTeacher(user);
        		learnClass.setTeacher(null);
        		learnClassService.update(learnClass);
        		discipline=learnClass.getLearnProject().getDiscipline();
        	}
        	if(user.getUserType().equals(UserType.Subject_Specialists)){
        		discipline = disciplineService.findByPersonIncharge(user);
        		discipline.setPersonInCharge(null);
        		disciplineService.update(discipline);
        	}
            // 删除用户在学科的记录
            StudyPlatformHttpClient client = new StudyPlatformHttpClient();
            statusCode = client.detroyUserFromStudySpace(user.getLoginName(), discipline.getId().toString(),
                    SpaceType.STUDY);
            if (statusCode != 200 && statusCode!=409) {
                throw new UserDestroyInStudySpaceFaildException();
            }
            // 删除用户在校本研修空间的记录
            statusCode = client.detroyUserFromStudySpace(user.getLoginName(), discipline.getId().toString(),
                    SpaceType.XBYX);
            if (statusCode != 200 && statusCode!=409) {
                throw new UserDestroyInStudySpaceFaildException();
            }
            // 删除用户在学校空间的记录
            if(null!=user.getAccount()){
            	 SchoolSpace schoolSpace = schoolSpaceService.findBySchoolNameAndBatch(user.getAccount().getSchool(),batchService.getCurrentBatch());
                 if (null != schoolSpace) {
                     statusCode = client.detroyUserFromStudySpace(user.getLoginName(), schoolSpace.getId()
                             .toString(), SpaceType.SCHOOL);
                     if (statusCode != 200 && statusCode!=409) {
                         throw new UserDestroyInStudySpaceFaildException();
                     }
                 }
            }
           
        }
        // 删除用户在CAS的记录
        CASPlatformHttpClient casClient = new CASPlatformHttpClient();
        statusCode = casClient.destroyUserFromCAS(user.getLoginName());
        if (statusCode != 200 && statusCode!=409) {
            throw new UserDestroyInCASFaildException();
        }
    }

    private void sendUserToTheCAS(User user) throws UserInfoSendCASFaildException {
        CASPlatformHttpClient client = new CASPlatformHttpClient();
        Integer statusCode = client.createUserToCAS(user);
        if (statusCode != 200 && statusCode != 409) {
            throw new UserInfoSendCASFaildException();
        }
        if (statusCode == 409 && statusCode!=409) {
            client.updateUserFromCAS(user);
        }
    }

    @Transactional(rollbackFor = { UserDestroyInCASFaildException.class,
            UserDestroyInStudySpaceFaildException.class })
    @Override
    public void destroyUser(User user, List<SchoolRoll> schoolRolls)
            throws UserDestroyInStudySpaceFaildException, UserDestroyInCASFaildException {
    	destroyUserAllInformation(user);
        Grade grade = this.gradeService.findByUser(user);
        if(null!=grade){
        	Graduate graduate = this.graduateService.findByGrade(grade);
        	this.graduateService.delete(graduate);
            this.gradeService.delete(grade);
        }
        //删除学生提交的论文、问题、站内信
        this.learnThesisSubmitService.delete(user);
        this.questionService.delete(user);
        this.senderNotificationService.delete(user);
        this.senderNotificationService.deleteByRecervers(user);
        this.receiverNotificationService.delete(user);
        
        // 更新招生计划已招生人数
        SchoolRoll schoolRoll = schoolRollService.findByUserNewest(user);
        if(null!=schoolRoll){
	        EnrollmentPlan enrollmentPlan = enrollmentPlanService.findEnrollmentPlanByLearnClass(schoolRoll
	                .getLearnClass());
	        enrollmentPlan.setExistedUserNumber(enrollmentPlan.getExistedUserNumber() - 1);
	        enrollmentPlanService.update(enrollmentPlan);
	    }
        this.schoolRollService.delete(schoolRolls);
        delete(user.getId());
        if(null !=user.getAccount())
        this.accountService.delete(user.getAccount());
    }

    @Transactional(rollbackFor = UserInfoSendCASFaildException.class)
    @Override
    public void saveUser(User user) throws UserInfoSendCASFaildException {
        save(user);
        sendUserToTheCAS(user);
    }

    @Transactional(rollbackFor = UserInfoSendCASFaildException.class)
    @Override
    public void saveProjectUser(User user, LearnSubProject lsp) throws UserInfoSendCASFaildException {
        save(user);
        User savedUser = findByLoginName(user.getLoginName());
        lsp.setPersonInCharge(savedUser);
        this.learnSubProjectService.update(lsp);
        // 将项目专家信息存入CAS
        sendExpertToTheCAS(user);
    }

    @Transactional(rollbackFor = UserInfoSendCASFaildException.class)
    @Override
    public void saveProvinceUser(List<LearnArea> areas, User user) throws UserInfoSendCASFaildException {
        save(user);
        User savedUser = findByLoginName(user.getLoginName());
        for (LearnArea learnArea : areas) {
            learnArea.setUser(savedUser);
            learnAreaService.update(learnArea);
        }
        sendExpertToTheCAS(user);
    }

    @Transactional(rollbackFor = { UserDestroyInStudySpaceFaildException.class,
            UserInfoPushToStudySpaceClassRoomFaildException.class })
    @Override
    public void saveTeacher(LearnClass learnClass, User user) throws UserDestroyInStudySpaceFaildException,
            UserInfoPushToStudySpaceClassRoomFaildException {
        user.setUserType(UserType.Teacher);
        update(user);
        learnClass.setTeacher(user);
        learnClassService.update(learnClass);
        // 将学生变成老师
        updateStudentChangeBeTeacherToStudySpaceClassRoom(user, learnClass);
        // 删除该学生的学籍记录
        schoolRollService.deleteByUser(user);
        //删除该学生的结业记录
        graduateService.delete(graduateService.findByGrade(gradeService.findByUser(user)).getId());
        //删除该学生的成绩记录
        gradeService.delete(gradeService.findByUser(user).getId());
       
    }

	private void updateStudentChangeBeTeacherToStudySpaceClassRoom(User user,LearnClass learnClass) throws UserDestroyInStudySpaceFaildException, UserInfoPushToStudySpaceClassRoomFaildException {
		StudyPlatformHttpClient client = new StudyPlatformHttpClient();
		//先删除原有记录
		String learnClassStudySpaceId=learnClass.getLearnClassStudySpaceId();
		String disciplineId=learnClass.getLearnProject().getDiscipline().getId().toString();
		Integer statusCode = client.detroyUserFromStudySpace(user.getLoginName(),disciplineId,SpaceType.STUDY);
		if(statusCode!=200  && statusCode!=409){
			throw new UserDestroyInStudySpaceFaildException();
		}
		else{
			
			//添加新记录
			statusCode=client.createUserToStudySpace(user, disciplineId);
			statusCode=client.createUserToStudySpaceClassRoom(user, learnClassStudySpaceId, disciplineId);
			if(statusCode!=200  && statusCode!=409){
				throw new UserInfoPushToStudySpaceClassRoomFaildException();
			}
		}
	}

	@Override
	public User findByUserType(UserType userType) {
		return userDao.findByUserType(userType);
	}

	@Transactional(rollbackFor=UserUpdateToCASFaildException.class)
	@Override
	public void changePassword(User currentUser) throws UserUpdateToCASFaildException {
		//更新本地
		update(currentUser);
		//更新CAS
		CASPlatformHttpClient client = new CASPlatformHttpClient();
		Integer status = client.updateUserFromCAS(currentUser);
		if(status!=200 && status!=409){
			throw new UserUpdateToCASFaildException();
		}
	}
	@Override
	public List<User> listBySchoolIncurrentBatch(String school,
			Batch currentBatch) {
		List<User> result  =Lists.newArrayList();
		List<Account> accounts = accountService.listBySchool(school);
		for(int i =0;i<accounts.size();i++){
			User temp=userDao.findbyAccount(accounts.get(i));
			if(null!=temp && temp.getUserType().equals(UserType.Student)){
				result.add(temp);
			}
		}
		return result;
	}

	@Override
	public List<User> findByUserTypeAndBatch(UserType userType) {
		return this.userDao.findByUserTypeAndBatch(userType, this.batchService.getNowBatch());
	}

	@Override
	public Integer getStudentCount() {
		return this.userDao.getStudentCount();
	}

	@Override
	public Integer getActiveStudentCount() {
		return userDao.getActiveStudentCount();
	}

	

}
