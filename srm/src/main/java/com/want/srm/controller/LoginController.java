package com.want.srm.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.want.srm.service.AccountService;
import com.want.srm.vo.AccountDto;
import com.want.srm.vo.CommonReturnType;
import com.want.srm.vo.LoginVo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = "登录")
@RestController
@CrossOrigin
public class LoginController {

	@Autowired
	private AccountService accountService;
	
	@PostMapping("/login")
	public Map<String, Object> lgoin(@Valid @RequestBody LoginVo loginVo){
		return accountService.login(loginVo);
	}
	
	@PostMapping("/updatePasord")
	public Map<String,Object> updatePassword(@Valid @RequestBody AccountDto accountDto){
		return accountService.updatePassword(accountDto);
	}
	
	@GetMapping("/isDelete")
	public Map<String,Object> isDelete(String userId){
		return accountService.isDelete(userId);
	}
	
	@PostMapping("/resetPassword")
	public CommonReturnType resetPassword(@RequestBody(required = false) Map<String, String> map){
		return accountService.resetPassword(map);
	}
	
	@ApiOperation(value = "oa系统登录", nickname="oaLogin", notes = "post获取")
	@PostMapping("/oaLogin")
	public Map<String,Object> oaLogin(HttpServletRequest request) {
		return accountService.ecologyLogin(request);
	}
}
