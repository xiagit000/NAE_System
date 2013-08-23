package com.boventech.gplearn.dao.impl;


import java.util.List;

import com.boventech.gplearn.dao.VideoInfoDao;
import com.boventech.gplearn.entity.Batch;
import com.boventech.gplearn.entity.Discipline;
import com.boventech.gplearn.entity.SchoolSpace;
import com.boventech.gplearn.entity.VideoInfo;

public class VideoInfoDaoImpl extends BaseDaoImpl<VideoInfo, Long> implements
		VideoInfoDao {

	@Override
	public boolean checkDisciplineVideoExsit(VideoInfo videoInfo) {
		String queryString = "FROM VideoInfo vi WHERE vi.discipline=?1 AND vi.videoId=?2";
		return !executeQueryWithoutPaging(queryString, videoInfo.getDiscipline(),videoInfo.getVideoId()).isEmpty();
	}

	@Override
	public boolean checkSchooSpaceVideoExsit(VideoInfo videoInfo) {
		String queryString = "FROM VideoInfo vi WHERE vi.schoolSpace=?1 AND vi.videoId=?2";
		return !executeQueryWithoutPaging(queryString, videoInfo.getSchoolSpace(),videoInfo.getVideoId()).isEmpty();
	}

	@Override
	public VideoInfo findByVideoIdAndDiscipline(String videoId,
			Discipline discipline) {
		String queryString = "FROM VideoInfo vi WHERE vi.discipline=?1 AND vi.videoId=?2";
		List<VideoInfo> list = executeQueryWithoutPaging(queryString, discipline,videoId);
		return list.isEmpty()?null:list.get(0);
	}

	@Override
	public VideoInfo findByVideoIdAndSchoolSpace(String videoId,
			SchoolSpace schoolSpace) {
		String queryString = "FROM VideoInfo vi WHERE vi.schoolSpace=?1 AND vi.videoId=?2";
		List<VideoInfo> list = executeQueryWithoutPaging(queryString,schoolSpace,videoId);
		return list.isEmpty()?null:list.get(0);
	}

	@Override
	public List<VideoInfo> listByDiscipline(Discipline discipline,Batch batch) {
		String queryString = "FROM VideoInfo vi WHERE vi.discipline=?1 AND vi.batch=?2";
		return executeQueryWithoutPaging(queryString, discipline,batch);
	}

	

	

}
