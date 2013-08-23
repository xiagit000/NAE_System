package com.boventech.gplearn.service;

import com.boventech.gplearn.entity.VideoStatistics;


public interface VideoStatisticsService extends BaseService<VideoStatistics, Long> {

	VideoStatistics findByLoginNameAndDisciplineIdAndSchoolSpaceIdAndVideoId(VideoStatistics videoStatistics);
}
