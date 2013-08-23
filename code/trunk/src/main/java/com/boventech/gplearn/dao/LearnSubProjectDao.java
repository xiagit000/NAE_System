package com.boventech.gplearn.dao;

import java.util.List;

import com.boventech.gplearn.entity.Discipline;
import com.boventech.gplearn.entity.LearnProject;
import com.boventech.gplearn.entity.LearnSubProject;
import com.boventech.gplearn.entity.User;

public interface LearnSubProjectDao extends BaseDao<LearnSubProject,Long> {
	

	boolean checkExsitByDiscplineIdAndLearnProjectId(Long discipline,
			Long learnProjectId);

	List<LearnSubProject> listWithPaginationByLearnProjectId(Integer page,
			Long learnProjectId);

	LearnSubProject findByIdAndLearnProject(LearnProject learnProject,
			Long learnSubProjectId);

	boolean checkExsitByDiscplineIdAndLearnProjectIdWithOutCurrent(
			LearnSubProject learnSubProject, Long learnProjectId);

	List<LearnSubProject> listAll();


	List<LearnSubProject> listWithBatchId(Long batchId);

	boolean checkExsit();

	LearnSubProject findByPersonIncharge(User currentUser);

	List<LearnSubProject> listByDiscipline(Discipline discipline);

}
