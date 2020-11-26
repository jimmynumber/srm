package com.want.srm.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import com.want.srm.entity.Account;
import com.want.srm.vo.AccountDto;
import com.want.srm.vo.CommonReturnType;
import com.want.srm.vo.LoginVo;

public interface AccountService {

	Map<String,Object> login(LoginVo loginVo);

	Map<String,Object> updatePassword(@Valid AccountDto accountDto);

	Account getAccountByToken(String token);

	Map<String, Object> isDelete(String account);

	CommonReturnType resetPassword(Map<String, String> map);
	
	Map<String,Object> ecologyLogin(HttpServletRequest request);
	
}
