package com.boventech.gplearn.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.boventech.gplearn.dao.PortalDefaultInformationDao;
import com.boventech.gplearn.entity.PortalDefaultInformation;
import com.boventech.gplearn.entity.PortalDefaultType;
import com.boventech.gplearn.service.PortalDefaultInfomationService;
import com.google.common.collect.Lists;

@Service
@Transactional
public class PortalDefaultInformationServiceImpl implements
		PortalDefaultInfomationService {

	@Autowired
	private PortalDefaultInformationDao portalDefaultInformationDao;
	
	@Override
	public void delete(PortalDefaultInformation t) {
		portalDefaultInformationDao.delete(t);
	}

	@Override
	public void delete(Long id) {
		portalDefaultInformationDao.deleteById(id);
	}

	@Override
	public PortalDefaultInformation findById(Long id) {
		return portalDefaultInformationDao.findByID(id);
	}

	@Override
	public void save(PortalDefaultInformation t) {
		portalDefaultInformationDao.save(t);
	}

	@Override
	public void update(PortalDefaultInformation t) {
		portalDefaultInformationDao.update(t);
	}

	@Override
	public List<PortalDefaultInformation> listByPortalDefaultTypeWithPagination(
			PortalDefaultType portalDefaultType, Integer page) {
		return portalDefaultInformationDao.listByPortalDefaultTypeWithPagination(portalDefaultType, page);
	}

	@Override
	public List<PortalDefaultInformation> listByNavigationIdWithPagination(
			Long id, Integer page) {
		return portalDefaultInformationDao.listByNavigationIdWithPagination(id, page);
	}

	@Override
	public List<PortalDefaultInformation> listByPortalDefaultTypeUseForPortal(
			PortalDefaultType notice,Integer total) {
		List<PortalDefaultInformation> list=listByPortalDefaultTypeWithPagination(notice, null);
		return controlRebackCount(list,total);
	}
	
	
	private List<PortalDefaultInformation> controlRebackCount(List<PortalDefaultInformation> list,Integer total){
		if(list.size()<=total){
			return list;
		}
		else{
			List<PortalDefaultInformation> result=Lists.newArrayList();
			for(int i =0;i<total;i++){
				result.add(list.get(i));
			}
			return result;
		}
	}

}
