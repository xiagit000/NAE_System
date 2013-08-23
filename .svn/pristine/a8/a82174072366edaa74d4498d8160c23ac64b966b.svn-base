package com.boventech.gplearn.dao;

import java.util.List;

import com.boventech.gplearn.entity.LearnPlan;
import com.boventech.gplearn.entity.LearnSubProject;

public interface LearnPlanDao extends BaseDao<LearnPlan, Long> {

	List<LearnPlan> listWithPagination(Integer page);

	boolean isExsitByBatchAndLearnCourseAndLearnSubProjectAndLearnRange(
			LearnPlan learnPlan);

	boolean isExsitByBatchAndLearnCourseAndLearnSubProjectAndLearnRangeWithOutCurrent(
			LearnPlan learnPlan);

	boolean isExsitByCode(String code);

	boolean isExsitByName(String name);

	boolean isExsitByCodeWithOutCurrent(LearnPlan learnPlan);

	boolean isExsitByNameWithOutCurrent(LearnPlan learnPlan);

	List<LearnPlan> listLearnCourseBylearnSubProject(
			LearnSubProject learnSubProject);

	List<LearnPlan> listAll();
}
