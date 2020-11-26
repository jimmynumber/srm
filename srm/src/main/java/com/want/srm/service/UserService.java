package com.want.srm.service;

import com.want.srm.entity.RoleUserKey;
import com.want.srm.vo.WResult;

public interface UserService {
	
	WResult<?> getPurchaseByCondition(RoleUserKey roleUserKey);
}
