package com.boventech.gplearn.dao.impl;


import java.util.List;

import com.boventech.gplearn.dao.VideoStatisticsDao;
import com.boventech.gplearn.entity.VideoStatistics;


public class VideoStatisticsDaoImpl extends BaseDaoImpl<VideoStatistics, Long> implements
		VideoStatisticsDao {

	@Override
	public VideoStatistics findByLoginNameAndDisciplineIdAndVideoId(
			VideoStatistics videoStatistics) {
		String queryString = "FROM VideoStatistics vs WHERE vs.disciplineId=?1 AND vs.userLoginName=?2 AND vs.videoId=?3";
		List<VideoStatistics> list = executeQueryWithoutPaging(queryString, videoStatistics.getDisciplineId(),
																	videoStatistics.getUserLoginName(),
																	videoStatistics.getVideoId());	
		return list.isEmpty()?null:list.get(0);
	}

	@Override
	public VideoStatistics findByLoginNameAndSchoolSpaceIdAndVideonId(
			VideoStatistics videoStatistics) {
		String queryString = "FROM VideoStatistics vs WHERE vs.schooSpaceId=?1 AND vs.userLoginName=?2 AND vs.videoId=?3";
		List<VideoStatistics> list = executeQueryWithoutPaging(queryString, videoStatistics.getSchoolSpaceId(),
																	videoStatistics.getUserLoginName(),
																	videoStatistics.getVideoId());	
		return list.isEmpty()?null:list.get(0);
	}



}
