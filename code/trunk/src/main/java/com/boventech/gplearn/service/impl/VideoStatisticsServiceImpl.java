package com.boventech.gplearn.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.boventech.gplearn.dao.VideoStatisticsDao;
import com.boventech.gplearn.entity.VideoStatistics;
import com.boventech.gplearn.service.VideoStatisticsService;

@Service
@Transactional
public class VideoStatisticsServiceImpl implements VideoStatisticsService {

	@Autowired
	private VideoStatisticsDao videoStatisticsDao;
	
	@Override
	public void delete(VideoStatistics t) {
		videoStatisticsDao.delete(t);
	}

	@Override
	public void delete(Long id) {
		videoStatisticsDao.deleteById(id);
	}

	@Override
	public VideoStatistics findById(Long id) {
		return videoStatisticsDao.findByID(id);
	}

	@Override
	public void save(VideoStatistics t) {
		videoStatisticsDao.save(t);
	}

	@Override
	public void update(VideoStatistics t) {
		videoStatisticsDao.update(t);
	}

	@Override
	public VideoStatistics findByLoginNameAndDisciplineIdAndSchoolSpaceIdAndVideoId(
			VideoStatistics videoStatistics) {
		if(videoStatistics.getDisciplineId()!=null){
			return videoStatisticsDao.findByLoginNameAndDisciplineIdAndVideoId(videoStatistics);
		}
		if(videoStatistics.getSchoolSpaceId()!=null){
			return videoStatisticsDao.findByLoginNameAndSchoolSpaceIdAndVideonId(videoStatistics);
		}
		return null;
	}

}
