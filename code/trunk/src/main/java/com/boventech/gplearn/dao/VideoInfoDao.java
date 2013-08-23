package com.boventech.gplearn.dao;

import java.util.List;

import com.boventech.gplearn.entity.Batch;
import com.boventech.gplearn.entity.Discipline;
import com.boventech.gplearn.entity.SchoolSpace;
import com.boventech.gplearn.entity.VideoInfo;

public interface VideoInfoDao extends BaseDao<VideoInfo, Long> {


	boolean checkDisciplineVideoExsit(VideoInfo videoInfo);

	boolean checkSchooSpaceVideoExsit(VideoInfo videoInfo);


	VideoInfo findByVideoIdAndDiscipline(String videoId, Discipline discipline);

	VideoInfo findByVideoIdAndSchoolSpace(String videoId,
			SchoolSpace schoolSpace);

	List<VideoInfo> listByDiscipline(Discipline discipline, Batch batch);
}
