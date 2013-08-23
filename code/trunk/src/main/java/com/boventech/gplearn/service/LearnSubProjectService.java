package com.boventech.gplearn.service;

import java.util.List;

import com.boventech.gplearn.entity.Batch;
import com.boventech.gplearn.entity.Discipline;
import com.boventech.gplearn.entity.LearnProject;
import com.boventech.gplearn.entity.LearnSubProject;
import com.boventech.gplearn.entity.User;

public interface LearnSubProjectService extends BaseService<LearnSubProject,Long> {
	
	List<LearnSubProject> listAll();
	
	List<LearnSubProject> listWithBatchId(Long batchId);

	List<LearnSubProject> listWithPaginationByLearnProjectId(Integer page,Long learnProjectId);
	
	boolean checkExsitByDiscplineIdAndLearnProjectId(Long disciplineId,Long learnProjectId);
	
	boolean checkExsitByDiscplineIdAndLearnProjectIdWithOutCurrent(LearnSubProject learnSubProject,Long learnProjectId);
	
	LearnSubProject findByIdAndLearnProject(LearnProject learnProject,Long learnSubProjectId);

	boolean isExsitByBatchId(Long id);

	boolean checkExist();

	LearnSubProject findByPersonIncharge(User currentUser);

	List<LearnSubProject> listByDiscipline(Discipline discipline,
			Batch currentBatch);
}
