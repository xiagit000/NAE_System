package com.boventech.gplearn.service;

import java.util.List;

import com.boventech.gplearn.entity.LearnResource;
import com.boventech.gplearn.entity.User;

public interface LearnResourceService extends BaseService<LearnResource,Long> {

	List<LearnResource> listByUser(User disciplineUser, Integer page);

	void saveLearnResource(User user, LearnResource learnResource,
			String fileName);

}
