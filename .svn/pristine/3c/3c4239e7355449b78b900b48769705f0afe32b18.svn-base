package com.boventech.gplearn.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.boventech.gplearn.dao.LearnSubProjectDao;
import com.boventech.gplearn.entity.Batch;
import com.boventech.gplearn.entity.Discipline;
import com.boventech.gplearn.entity.LearnProject;
import com.boventech.gplearn.entity.LearnSubProject;
import com.boventech.gplearn.entity.User;
import com.boventech.gplearn.service.LearnSubProjectService;
import com.google.common.collect.Lists;

@Service
@Transactional
public class LearnSubProjectServiceImpl implements LearnSubProjectService {

    @Autowired
    private LearnSubProjectDao learnSubProjectDao;

    @Override
    public List<LearnSubProject> listWithPaginationByLearnProjectId(Integer page, Long learnProjectId) {
        return learnSubProjectDao.listWithPaginationByLearnProjectId(page, learnProjectId);
    }

    @Override
    public void delete(LearnSubProject t) {
        learnSubProjectDao.delete(t);
    }

    @Override
    public void delete(Long id) {
        learnSubProjectDao.deleteById(id);
    }

    @Override
    public LearnSubProject findById(Long id) {
        return learnSubProjectDao.findByID(id);
    }

    @Override
    public void save(LearnSubProject t) {
        learnSubProjectDao.save(t);

    }

    @Override
    public void update(LearnSubProject t) {
        learnSubProjectDao.update(t);
    }

    @Override
    public boolean checkExsitByDiscplineIdAndLearnProjectId(Long discipline, Long learnProjectId) {
        return learnSubProjectDao.checkExsitByDiscplineIdAndLearnProjectId(discipline, learnProjectId);
    }

    @Override
    public LearnSubProject findByIdAndLearnProject(LearnProject learnProject, Long learnSubProjectId) {
        return learnSubProjectDao.findByIdAndLearnProject(learnProject, learnSubProjectId);
    }

    @Override
    public boolean checkExsitByDiscplineIdAndLearnProjectIdWithOutCurrent(LearnSubProject learnSubProject,
            Long learnProjectId) {
        return learnSubProjectDao.checkExsitByDiscplineIdAndLearnProjectIdWithOutCurrent(learnSubProject,
                learnProjectId);
    }

    @Override
    public List<LearnSubProject> listAll() {
        return learnSubProjectDao.listAll();
    }

    @Override
    public List<LearnSubProject> listWithBatchId(Long batchId) {
        return learnSubProjectDao.listWithBatchId(batchId);
    }

    @Override
    public boolean isExsitByBatchId(Long id) {
        return !learnSubProjectDao.listWithBatchId(id).isEmpty();
    }

    @Override
    public boolean checkExist() {
        return learnSubProjectDao.checkExsit();
    }

	@Override
	public LearnSubProject findByPersonIncharge(User currentUser) {
		return learnSubProjectDao.findByPersonIncharge(currentUser);
	}

	@Override
	public List<LearnSubProject> listByDiscipline(Discipline discipline,
			Batch currentBatch) {
		List<LearnSubProject> result = Lists.newArrayList();
		List<LearnSubProject> lspList = learnSubProjectDao.listByDiscipline(discipline);
		for(int i =0;i<lspList.size();i++){
			LearnSubProject temp = lspList.get(i);
			if(temp.getLearnProject().getBatch().getId()==currentBatch.getId()){
				result.add(temp);
			}
		}
		return result;
	}
}
