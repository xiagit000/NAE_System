package com.boventech.gplearn.dao.impl;


import java.util.List;

import com.boventech.gplearn.dao.LearnThesisSubmitInformationDao;
import com.boventech.gplearn.entity.LearnThesis;
import com.boventech.gplearn.entity.LearnThesisSubmit;
import com.boventech.gplearn.entity.User;
import com.boventech.gplearn.entity.LearnThesisSubmit.LearnThesisRating;

public class LearnThesisSubmitInformationDaoImpl extends BaseDaoImpl<LearnThesisSubmit, Long>
		implements LearnThesisSubmitInformationDao {

	@Override
	public LearnThesisSubmit findByStudentUserAndLearnThesis(User currentStudent,
			LearnThesis learnThesis) {
		String queryString  = "FROM LearnThesisSubmit ls WHERE ls.user=?1 AND ls.learnThesis=?2 AND newest=?3";
		List<LearnThesisSubmit> list = executeQueryWithoutPaging(queryString, currentStudent,learnThesis,true);
		return list.isEmpty()?null:list.get(0);
	}

	@Override
	public List<LearnThesisSubmit> listActiveInfoByStudentUser(User currentStudent) {
		String queryString  = "FROM LearnThesisSubmit ls WHERE ls.user = ?1 AND ls.newest=?2  ORDER BY ls.id DESC";
		return executeQueryWithoutPaging(queryString, currentStudent,true);
	}

	@Override
	public List<LearnThesisSubmit> listActiveInfoByTeacherUser(User currentTeacher,Integer page) {
		String queryString = "FROM LearnThesisSubmit ls WHERE ls.teacher=?1 AND ls.newest=?2";
		return executeQueryWithPagination(queryString, "  ORDER BY ls.id DESC", page, currentTeacher,true);
	}

	@Override
	public List<LearnThesisSubmit> listByStudent(User student, Integer page) {
		String queryString  ="FROM LearnThesisSubmit ls WHERE ls.user=?1 ORDER BY ls.id DESC";
		return executeQueryWithPagination(queryString, " ORDER BY ls.id DESC", page, student);
	}

	@Override
	public List<LearnThesisSubmit> listNewestByLearnThesis(
			LearnThesis learnThesis) {
		String queryString = "FROM LearnThesisSubmit ls WHERE ls.learnThesis=?1 AND ls.newest=?2";
		return executeQueryWithoutPaging(queryString, learnThesis,true);
	}

	@Override
	public List<LearnThesisSubmit> listActiveInfoByTeacherUser(
			User currentTeacher) {
		String queryString = "FROM LearnThesisSubmit ls WHERE ls.teacher=?1 AND ls.newest=?2 ORDER BY ls.id DESC";
		return executeQueryWithoutPaging(queryString, currentTeacher,true);
	}

	@Override
	public void delete(User user) {
		String queryString = "DELETE FROM LearnThesisSubmit ls WHERE ls.user=?1";
		executeUpdateOrDelete(queryString, user);
	}

	@Override
	public List<LearnThesisSubmit> listByLearnClassId(Long id) {
		String queryString = "FROM LearnThesisSubmit ls WHERE ls.learnClassId=?1";
		return executeQueryWithoutPaging(queryString, id);
	}

	@Override
	public Integer getLearnThesisSubmitCount() {
		String queryString = "select count(*) FROM LearnThesisSubmit ls WHERE ls.newest=?1";
		return executeCountQuery(queryString, true);
	}

	@Override
	public Integer getLearnThesisSubmitGoodCount() {
		String queryString = "select count(*) FROM LearnThesisSubmit ls WHERE ls.newest=?1 AND ls.learnThesisRating=?2";
		return executeCountQuery(queryString, true,LearnThesisRating.VERYGOOD);
	}

	@Override
	public Integer getCountByLearnClassId(Long id) {
		String queryString = "select count(*) FROM LearnThesisSubmit ls WHERE ls.learnClassId=?1";
		return executeCountQuery(queryString, id);
	}
	


}
