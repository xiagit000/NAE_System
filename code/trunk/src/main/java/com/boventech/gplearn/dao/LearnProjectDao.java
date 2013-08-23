package com.boventech.gplearn.dao;

import java.util.List;

import com.boventech.gplearn.entity.LearnProject;

public interface LearnProjectDao extends BaseDao<LearnProject,Long> {

	List<LearnProject> listWithPagination(Integer page);

	List<LearnProject> listAll();

	boolean isExsitByName(String name);

	boolean isExsitByNameWithOutCurrent(LearnProject learnProject);

	boolean isExsitByCode(String code);

	boolean isExsitByCodeWithOutCurrent(LearnProject learnProject);
}
