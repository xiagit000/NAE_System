package com.boventech.gplearn.dao;

import java.util.List;

import com.boventech.gplearn.entity.Navigation;

public interface NavigationDao extends BaseDao<Navigation, Long> {

	List<Navigation> listParents();

	boolean isNameExsit(String name);

	Navigation findByName(String name);

	boolean isNameExsitWithoutCurrentId(String name,Long id);

	void deleteChildren(Long id);

	List<Navigation> listChildren(Long parentId);

}
