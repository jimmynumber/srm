package com.want.srm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.want.srm.entity.RoleUserKey;
import com.want.srm.service.UserService;
import com.want.srm.vo.WResult;

import io.swagger.annotations.Api;

@Api(tags = "用户信息")
@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {
	
	@Autowired
	private UserService userService;

	@PostMapping("/orgs")
	public WResult<?> getRoleList(@RequestBody RoleUserKey roleUserKey){
		return userService.getPurchaseByCondition(roleUserKey);
	}
}
