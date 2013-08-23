package com.boventech.gplearn.service.impl;

import java.io.IOException;
import java.util.List;

import org.apache.http.client.ClientProtocolException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.boventech.gplearn.dao.DisciplineDao;
import com.boventech.gplearn.entity.Discipline;
import com.boventech.gplearn.entity.User;
import com.boventech.gplearn.exception.StudySpaceCreateFaildException;
import com.boventech.gplearn.service.DisciplineService;
import com.boventech.gplearn.util.StudyPlatformHttpClient;

@Service
@Transactional
public class DisciplineServiceImpl implements DisciplineService {

	
	@Autowired
	private DisciplineDao disciplineDao;
	
	@Override
	public List<Discipline> listAll() {
		return disciplineDao.listAll();
	}

	@Override
	public List<Discipline> listWithPagination(Integer page) {
		return disciplineDao.listWithPagination(page);
	}

	@Override
	public void delete(Discipline t) {
		disciplineDao.delete(t);
	}

	@Override
	public void delete(Long id) {
		disciplineDao.deleteById(id);
	}

	@Override
	public Discipline findById(Long id) {
		return disciplineDao.findByID(id);
	}

	@Override
	public void save(Discipline t) {
		disciplineDao.save(t);
	}

	@Override
	public void update(Discipline t) {
		disciplineDao.update(t);
	}

	@Override
	public boolean checkExsitByLearnLevelId(Long learnLevelId) {
		return disciplineDao.checkExsitByLearnLevelId(learnLevelId);
	}

	@Override
	public boolean checkExsitByLearnSpeacialtyId(Long learnSpeacialtyId) {
		return disciplineDao.checkExsitByLearnSpeacialtyId(learnSpeacialtyId);
	}

	@Override
	public boolean checkExsitByLearnSpeacialtyIdAndLearnLevelId(
			Long learnSpeacialtyId, Long learnLevelId) {
		return disciplineDao.checkExsitByLearnSpeacialtyIdAndLearnLevelId(learnLevelId, learnSpeacialtyId);
	}

	@Override
	public boolean checkExsitBylearnSpeacialtyIdAndLearnLevelIdWithoutCurrent(
			Discipline discipline) {
		return disciplineDao.checkExitBylearnSpeacialtyIdAndLearnLevelIdWithoutCurrent(discipline);
	}

	@Override
	public boolean checkExsitCode(String code) {
		return disciplineDao.checkExsitCode(code);
	}

	@Override
	public boolean checkExsitCodeWithOutCurrent(Discipline discipline,String code) {
		return disciplineDao.checkExsitCodeWithOutCurrent(discipline,code);
	}

	@Override
	public boolean checkExsit() {
		return !disciplineDao.listAll().isEmpty();
	}

	@Override
	public Discipline findByLearnLevelIdAndLearnSpeacialtyId(Long learnLevelId,
			Long learnSpeacialtyId) {
		return disciplineDao.findByLearnLevelIdAndLearnSpeacialtyId(learnLevelId, learnSpeacialtyId);
	}

	@Transactional(rollbackFor=StudySpaceCreateFaildException.class)
	@Override
	public void saveDiscipline(Discipline discipline) throws StudySpaceCreateFaildException {
		save(discipline);
		// 推送信息到学习平台
		Discipline savedDiscipline=findByLearnLevelIdAndLearnSpeacialtyId(discipline
					.getLearnLevel().getId(), discipline.getLearnSpeacialty()
					.getId());
		sendDisciplineInfoToStudyPlatForm(savedDiscipline);
		sendDisciplineInfoToXBYXPlatForm(savedDiscipline);
	}
	
	/**
	 * TODO 1添加学科大空间的数据推送功能 （学习空间）[集成完成]
	 * @throws StudySpaceCreateFaildException 
	 * @throws IOException 
	 * @throws ClientProtocolException 
	 * 
	 */
	private void sendDisciplineInfoToStudyPlatForm(Discipline discipline) throws StudySpaceCreateFaildException{
		StudyPlatformHttpClient client = new StudyPlatformHttpClient();
		//声明创建的学科空间的ID，为区分唯一性，需要拼接
		//课程空间的标题就以层次+主题的形式拼接
		String title = discipline.getLearnLevel().getName()+discipline.getLearnSpeacialty().getName();
		Integer statusCode=client.createStudySpace(discipline.getId().toString(), title);
		if(statusCode != 200 && statusCode!=409){
			throw new StudySpaceCreateFaildException();
		}
	}

	/**
	 * TODO 10添加学科大空间的数据推送功能 （学习空间）[集成完成]
	 * @throws StudySpaceCreateFaildException 
	 * @throws IOException 
	 * @throws ClientProtocolException 
	 * 
	 */
	private void sendDisciplineInfoToXBYXPlatForm(Discipline discipline) throws StudySpaceCreateFaildException{
		StudyPlatformHttpClient client = new StudyPlatformHttpClient();
		//声明创建的学科空间的ID，为区分唯一性，需要拼接
		//课程空间的标题就以层次+主题的形式拼接
		String title = discipline.getLearnLevel().getName()+discipline.getLearnSpeacialty().getName();
		Integer statusCode=client.createXBYXSpace(discipline.getId().toString(), title);
		if(statusCode != 200 && statusCode!=409){
			throw new StudySpaceCreateFaildException();
		}
	}

	@Override
	public Discipline findByPersonIncharge(User user) {
		return disciplineDao.findByPersonIncharge(user);
	}

}
