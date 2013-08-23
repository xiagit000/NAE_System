package com.boventech.gplearn.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.boventech.gplearn.dao.PortalDefaultInformationDao;
import com.boventech.gplearn.entity.PortalDefaultInformation;
import com.boventech.gplearn.entity.PortalDefaultType;

@Repository
public class PortalDefaultInformationDaoImpl extends BaseDaoImpl<PortalDefaultInformation, Long>
		implements PortalDefaultInformationDao {

	private static final String DEFAULT_ORDER=" ORDER BY pdi.publishDate DESC";
	
	@Override
	public List<PortalDefaultInformation> listByPortalDefaultTypeWithPagination(
			PortalDefaultType portalDefaultType, Integer page) {
		String queryString = "FROM PortalDefaultInformation pdi WHERE pdi.proNoticeType=?1";
		return executeQueryWithPagination(queryString, DEFAULT_ORDER, page,portalDefaultType);
	}

	@Override
	public List<PortalDefaultInformation> listByNavigationIdWithPagination(
			Long id, Integer page) {
		String queryString = "FROM PortalDefaultInformation pdi WHERE pdi.navigation.id=?1";
		return executeQueryWithPagination(queryString, DEFAULT_ORDER, page, id);
	}

	
}
