package com.boventech.gplearn.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.boventech.gplearn.dao.NavigationDao;
import com.boventech.gplearn.entity.Navigation;
import com.boventech.gplearn.service.NavigationService;

@Service
@Transactional
public class NavigationServiceImpl implements NavigationService {

	@Autowired
	private NavigationDao navigationDao;
	
	@Override
	public void delete(Navigation t) {
		navigationDao.delete(t);
	}

	@Override
	public void delete(Long id) {
		
		navigationDao.deleteById(id);
	}

	@Override
	public Navigation findById(Long id) {
		return navigationDao.findByID(id);
	}

	@Override
	public void save(Navigation t) {
		navigationDao.save(t);
	}

	@Override
	public void update(Navigation t) {
		navigationDao.update(t);
	}

	@Override
	public List<Navigation> listParents() {
		return navigationDao.listParents();
	}

	@Override
	public boolean isNameExsit(String name) {
		return navigationDao.isNameExsit(name);
	}

	@Override
	public void saveParent(Navigation navigation) {
		save(navigation);
		Navigation savedNavigation = navigationDao.findByName(navigation.getName());
		savedNavigation.setElCode(savedNavigation.getId().toString());
		update(savedNavigation);
	}

	@Override
	public boolean isNameExsitWithoutCurrentId(String name,Long id) {
		return navigationDao.isNameExsitWithoutCurrentId(name,id);
	}

	@Override
	public void deleteParent(Long id) {
		//删除所有所属的2级导航
		navigationDao.deleteChildren(id);
		delete(id);
	}

	@Override
	public List<Navigation> listChildren(Long parentId) {
		return navigationDao.listChildren(parentId);
	}

	@Override
	public void saveChild(Navigation navigation, Navigation parent) {
		save(navigation);
		Navigation saveNavigation = navigationDao.findByName(navigation.getName());
		saveNavigation.setElCode(parent.getId()+"-"+saveNavigation.getId());
		parent.setChildCount(parent.getChildCount()+1);
		update(saveNavigation);
		update(parent);
	}

}
