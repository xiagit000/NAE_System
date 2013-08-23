package com.boventech.gplearn.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.boventech.gplearn.dao.NavigationDao;
import com.boventech.gplearn.entity.Navigation;

@Repository
public class NavigationDaoImpl extends BaseDaoImpl<Navigation,Long> implements
		NavigationDao {

	@Override
	public List<Navigation> listParents() {
		String queryString = "FROM Navigation WHERE regexp(elCode,'^[0-9]*$')=1";
		return executeQueryWithoutPaging(queryString);
	}

	@Override
	public boolean isNameExsit(String name) {	
		String queryString = "FROM Navigation n WHERE n.name = ?1";
		return !executeQueryWithoutPaging(queryString, name).isEmpty();
	}

	@Override
	public Navigation findByName(String name) {
		String queryString =  "FROM Navigation n WHERE n.name=?1";
		List<Navigation> list = executeQueryWithoutPaging(queryString, name);
		return list.isEmpty()?null:list.get(0);
	}

	@Override
	public boolean isNameExsitWithoutCurrentId(String name,Long id) {
		String queryString = "FROM Navigation n WHERE n.name=?1 AND n.id <> ?2";
		return !executeQueryWithoutPaging(queryString, name,id).isEmpty();
	}

	@Override
	public void deleteChildren(Long id) {
		String queryString = "DELETE FROM Navigation WHERE regexp(elCode,'^"+id+"-[0-9]*$')=1";
		executeUpdateOrDelete(queryString);
	}

	@Override
	public List<Navigation> listChildren(Long parentId) {
		String regexpStr = "^"+parentId+"-[0-9]*$";
		String queryString = "FROM Navigation WHERE regexp(elCode,?1)=1";
		return executeQueryWithoutPaging(queryString,regexpStr);
	}

	

}
