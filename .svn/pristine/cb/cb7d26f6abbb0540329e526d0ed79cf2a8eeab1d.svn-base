package com.boventech.gplearn.service;

import java.util.List;

import com.boventech.gplearn.entity.Navigation;

public interface NavigationService extends BaseService<Navigation,Long> {

	List<Navigation> listParents();

	boolean isNameExsit(String name);

	void saveParent(Navigation navigation);

	boolean isNameExsitWithoutCurrentId(String name,Long id);

	void deleteParent(Long id);

	List<Navigation> listChildren(Long parentId);

	void saveChild(Navigation navigation, Navigation parent);

}
