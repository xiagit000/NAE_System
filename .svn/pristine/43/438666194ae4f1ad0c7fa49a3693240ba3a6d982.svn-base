package com.boventech.gplearn.service;

import java.util.List;

import com.boventech.gplearn.entity.PortalDefaultInformation;
import com.boventech.gplearn.entity.PortalDefaultType;

public interface PortalDefaultInfomationService extends BaseService<PortalDefaultInformation, Long> {

	List<PortalDefaultInformation> listByPortalDefaultTypeWithPagination(PortalDefaultType portalDefaultType,Integer page);

	List<PortalDefaultInformation> listByNavigationIdWithPagination(Long id,
			Integer page);

	List<PortalDefaultInformation> listByPortalDefaultTypeUseForPortal(
			PortalDefaultType notice,Integer total);
}
