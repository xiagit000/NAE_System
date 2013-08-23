package com.boventech.gplearn.dao.impl;

import java.util.List;

import com.boventech.gplearn.dao.LearnSubProjectDao;
import com.boventech.gplearn.entity.Discipline;
import com.boventech.gplearn.entity.LearnProject;
import com.boventech.gplearn.entity.LearnSubProject;
import com.boventech.gplearn.entity.User;

public class LearnSubProjectDaoImpl extends BaseDaoImpl<LearnSubProject,Long> implements
		LearnSubProjectDao {

	private static final String DEFAULT_ORDER=" ORDER BY lsp.id DESC";
	
	

	@Override
	public boolean checkExsitByDiscplineIdAndLearnProjectId(Long discipline,
			Long learnProjectId) {
		String queryString = "FROM LearnSubProject lsp WHERE lsp.discipline.id=?1 AND lsp.learnProject.id=?2";
		return !executeQueryWithoutPaging(queryString, discipline,learnProjectId).isEmpty();
	}



	@Override
	public List<LearnSubProject> listWithPaginationByLearnProjectId(
			Integer page, Long learnProjectId) {
		String queryString  = "FROM LearnSubProject lsp WHERE lsp.learnProject.id=?1";
		return executeQueryWithPagination(queryString, DEFAULT_ORDER, page, learnProjectId);
	}



	@Override
	public LearnSubProject findByIdAndLearnProject(LearnProject learnProject,
			Long learnSubProjectId) {
		String queryString  = "FROM LearnSubProject lsp WHERE lsp.learnProject.id=?1 AND lsp.id=?2";
		LearnSubProject lsp=executeQueryWithoutPaging(queryString, learnProject.getId(),learnSubProjectId).get(0);
		return lsp;
	}



	@Override
	public boolean checkExsitByDiscplineIdAndLearnProjectIdWithOutCurrent(
			LearnSubProject learnSubProject, Long learnProjectId) {
		String queryString = "FROM LearnSubProject lsp WHERE lsp.learnProject.id=?1 AND lsp.discipline.id=?2 AND lsp.id<>?3";
		return !executeQueryWithoutPaging(queryString,learnProjectId,learnSubProject.getDiscipline().getId(),learnSubProject.getId()).isEmpty();
	}



	@Override
	public List<LearnSubProject> listAll() {
		String queryString = "FROM LearnSubProject lsp";
		return executeQueryWithoutPaging(queryString);
	}



	@Override
	public List<LearnSubProject> listWithBatchId(Long batchId) {
		String queryString = "FROM LearnSubProject lsp WHERE lsp.learnProject.batch.id = ?1";
		return executeQueryWithoutPaging(queryString, batchId);
	}



	@Override
	public boolean checkExsit() {
		String queryString = "FROM LearnSubProject lsp";
		return !executeQueryWithoutPaging(queryString).isEmpty();
	}



	@Override
	public LearnSubProject findByPersonIncharge(User currentUser) {
		String queryString = "FROM LearnSubProject lsp WHERE lsp.personInCharge=?1";
		List<LearnSubProject> list= executeQueryWithoutPaging(queryString, currentUser);
		return list.isEmpty()?null:list.get(0);
	}



	@Override
	public List<LearnSubProject> listByDiscipline(Discipline discipline) {
		String queryString = "FROM LearnSubProject lsp WHERE lsp.discipline = ?1";
		return executeQueryWithoutPaging(queryString, discipline);
	}



}
