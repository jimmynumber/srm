package com.want.srm.dao;

import org.apache.ibatis.annotations.Mapper;

import com.want.srm.entity.LoginToken;

@Mapper
public interface LoginTokenDao {
    int deleteByPrimaryKey(String accountId);

    int insert(LoginToken record);

    int insertSelective(LoginToken record);

    LoginToken selectByPrimaryKey(String accountId);

    int updateByPrimaryKeySelective(LoginToken record);

    int updateByPrimaryKey(LoginToken record);
}