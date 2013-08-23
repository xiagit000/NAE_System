package com.boventech.gplearn.dao;

import java.util.List;

import com.boventech.gplearn.entity.Discipline;
import com.boventech.gplearn.entity.LearnClass;
import com.boventech.gplearn.entity.Question;
import com.boventech.gplearn.entity.User;

public interface QuestionDao extends BaseDao<Question,Long> {

	List<Question> listByAsker(User user,Integer page);

	List<Question> listByAsker(User user);

	List<Question> listWithPaginationBylearnClass(LearnClass learnClass,
			Integer page);

	List<Question> listwithPaginationByDiscipline(Discipline discipline,
			Integer page);

	Integer countByLearnClass(LearnClass learnClass);

	List<Question> listByLearnClass(LearnClass learnClass);

	void delete(User user);

	Integer getQuestionCount();

	Integer getQuestionResolvedCount();

}
