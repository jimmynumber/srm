package com.want.srm.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.want.srm.dao.RoleUserDao;
import com.want.srm.entity.RoleUserKey;
import com.want.srm.service.UserService;
import com.want.srm.utils.WResultUtil;
import com.want.srm.vo.WResult;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private RoleUserDao roleUserDao;
	
	@Override
	public WResult<?> getPurchaseByCondition(RoleUserKey key) {
		return WResultUtil.ok(roleUserDao.selectRoleInfoById(key));
	}

}
