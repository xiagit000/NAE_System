package com.boventech.gplearn.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.boventech.gplearn.dao.VideoInfoDao;
import com.boventech.gplearn.entity.Batch;
import com.boventech.gplearn.entity.Discipline;
import com.boventech.gplearn.entity.VideoInfo;
import com.boventech.gplearn.service.VideoService;

@Service
@Transactional
public class VideoInfoServiceImpl implements VideoService {

	@Autowired
	private VideoInfoDao videoInfoDao;
	
	@Override
	public void delete(VideoInfo t) {
		videoInfoDao.delete(t);
	}

	@Override
	public void delete(Long id) {
		videoInfoDao.deleteById(id);
	}

	@Override
	public VideoInfo findById(Long id) {
		return videoInfoDao.findByID(id);
	}

	@Override
	public void save(VideoInfo t) {
		videoInfoDao.save(t);
	}

	@Override
	public void update(VideoInfo t) {
		videoInfoDao.update(t);
	}

	@Override
	public boolean checkVideoExsit(VideoInfo videoInfo) {
		if(null!=videoInfo.getDiscipline()){
			return videoInfoDao.checkDisciplineVideoExsit(videoInfo);
		}
		else if(null!=videoInfo.getSchoolSpace()){
			return videoInfoDao.checkSchooSpaceVideoExsit(videoInfo);
		}
		return false;
	}

	@Override
	public VideoInfo findByVideoIdAndSiteId(VideoInfo videoInfo) {
		if(null!=videoInfo.getDiscipline()){
			return videoInfoDao.findByVideoIdAndDiscipline(videoInfo.getVideoId(),videoInfo.getDiscipline());
		}
		else if(null!=videoInfo.getSchoolSpace()){
			return videoInfoDao.findByVideoIdAndSchoolSpace(videoInfo.getVideoId(),videoInfo.getSchoolSpace());
		}
		else{
			return null;
		}
	}

	@Override
	public List<VideoInfo> listByDiscipline(Discipline discipline,Batch batch) {
		return videoInfoDao.listByDiscipline(discipline,batch);
	}

}
