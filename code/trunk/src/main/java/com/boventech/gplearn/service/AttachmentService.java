/*
 * Copyright 2010. 
 * 
 * This document may not be reproduced, distributed or used 
 * in any manner whatsoever without the expressed written 
 * permission of Boventech Corp. 
 * 
 * $Rev: Rev $
 * $Author: Author $
 * $LastChangedDate: LastChangedDate $
 *
 */

package com.boventech.gplearn.service;

import com.boventech.gplearn.entity.Attachment;

public interface AttachmentService extends BaseService<Attachment,Long>{

	Attachment findByfileName(String fileName);

}
