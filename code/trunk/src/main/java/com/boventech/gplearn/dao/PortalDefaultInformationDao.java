package com.boventech.gplearn.dao;

import java.util.List;

import com.boventech.gplearn.entity.PortalDefaultInformation;
import com.boventech.gplearn.entity.PortalDefaultType;

public interface PortalDefaultInformationDao extends BaseDao<PortalDefaultInformation, Long> {

	List<PortalDefaultInformation> listByPortalDefaultTypeWithPagination(
			PortalDefaultType portalDefaultType, Integer page);

	List<PortalDefaultInformation> listByNavigationIdWithPagination(Long id,
			Integer page);

}
