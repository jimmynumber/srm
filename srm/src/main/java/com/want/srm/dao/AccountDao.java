package com.want.srm.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.want.srm.entity.Account;
import com.want.srm.vo.AccountVo;

@Mapper
public interface AccountDao {
    int deleteByPrimaryKey(Integer id);

    int insert(Account record);

    int insertSelective(Account record);

    Account selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Account record);

    int updateByPrimaryKey(Account record);
    
    List<AccountVo> findByAccount(String accout);

	int updatePassword(Account accoutParam);
	
	Account getOneByAccountId(String accountId);

	Account getAccountByToken(String token);
	
	List<String> getRolesByAccountId(String accountId);
	
	List<Account> getAccountByParams(Map<String,String> map);
	
	Account selectAccountAndRoleById(String account);

	
}