package com.boventech.gplearn.dao;

import java.util.List;

import com.boventech.gplearn.entity.LearnResource;
import com.boventech.gplearn.entity.User;

public interface LearnResourceDao extends BaseDao<LearnResource,Long>{

	List<LearnResource> listByUser(User disciplineUser,Integer page);

}
