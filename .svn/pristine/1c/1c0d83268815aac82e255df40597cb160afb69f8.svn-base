package com.boventech.gplearn.service;

import java.util.List;

import com.boventech.gplearn.entity.Batch;
import com.boventech.gplearn.entity.Discipline;
import com.boventech.gplearn.entity.VideoInfo;

public interface VideoService extends BaseService<VideoInfo, Long> {

	boolean checkVideoExsit(VideoInfo videoInfo);

	VideoInfo findByVideoIdAndSiteId(VideoInfo videoInfo);

	List<VideoInfo> listByDiscipline(Discipline discipline, Batch batch);

}
