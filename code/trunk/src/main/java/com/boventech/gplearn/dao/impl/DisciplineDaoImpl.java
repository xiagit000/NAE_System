package com.boventech.gplearn.dao.impl;

import java.util.List;

import com.boventech.gplearn.dao.DisciplineDao;
import com.boventech.gplearn.entity.Discipline;
import com.boventech.gplearn.entity.User;

public class DisciplineDaoImpl extends BaseDaoImpl<Discipline,Long> implements
		DisciplineDao {

	private static final String DEFAULT_ORDER=" ORDER BY dl.id DESC";
	
	@Override
	public List<Discipline> listAll() {
		String queryString = "FROM Discipline dl";
		return executeQueryWithoutPaging(queryString);
	}

	@Override
	public List<Discipline> listWithPagination(Integer page) {
		String queryString = "FROM Discipline dl";
		return executeQueryWithPagination(queryString, DEFAULT_ORDER, page);
	}

	@Override
	public boolean checkExsitByLearnLevelId(Long learnLevelId) {
		String queryString = "FROM Discipline dl WHERE dl.learnLevel.id=?1";
		return !executeQueryWithoutPaging(queryString, learnLevelId).isEmpty();
	}

	@Override
	public boolean checkExsitByLearnSpeacialtyId(Long learnSpeacialtyId) {
		String queryString  = "FROM Discipline dl WHERE dl.learnSpeacialty.id = ?1";
		return !executeQueryWithoutPaging(queryString, learnSpeacialtyId).isEmpty();
	}

	@Override
	public boolean checkExsitByLearnSpeacialtyIdAndLearnLevelId(
			Long LearnLevelId, Long learnSpeacialtyId) {
		String queryString  = "FROM Discipline dl WHERE dl.learnSpeacialty.id = ?1 AND dl.learnLevel.id=?2";
		return !executeQueryWithoutPaging(queryString, learnSpeacialtyId,LearnLevelId).isEmpty();
	}

	@Override
	public boolean checkExitBylearnSpeacialtyIdAndLearnLevelIdWithoutCurrent(
			Discipline discipline) {
		String queryString  = "FROM Discipline dl WHERE dl.learnSpeacialty.id = ?1 AND dl.learnLevel.id=?2 AND dl.id<>?3";
		return !executeQueryWithoutPaging(queryString, discipline.getLearnSpeacialty().getId()
									,discipline.getLearnLevel().getId(),discipline.getId()).isEmpty();
	}

	@Override
	public boolean checkExsitCode(String code) {
		String queryString ="FROM Discipline dl WHERE dl.code=?1";
		return !executeQueryWithoutPaging(queryString, code).isEmpty();
	}

	@Override
	public boolean checkExsitCodeWithOutCurrent(Discipline discipline,String code) {
		String queryString = "FROM Discipline dl WHERE dl.code=?1 AND dl.id<>?2";
		return !executeQueryWithoutPaging(queryString,code,discipline.getId()).isEmpty();
	}

	@Override
	public Discipline findByLearnLevelIdAndLearnSpeacialtyId(Long learnLevelId,
			Long learnSpeacialtyId) {
		String queryStrng  ="FROM Discipline dl WHERE dl.learnLevel.id=?1 AND dl.learnSpeacialty.id=?2";
		List<Discipline> list=executeQueryWithoutPaging(queryStrng, learnLevelId,learnSpeacialtyId);
		return list.isEmpty()?null:list.get(0);
	}

	@Override
	public Discipline findByPersonIncharge(User user) {
		String queryString = "FROM Discipline dl WHERE dl.personInCharge=?1";
		List<Discipline> list = executeQueryWithoutPaging(queryString, user);
		return list.isEmpty()?null:list.get(0);
	}

	

	

	
}
