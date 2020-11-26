package com.want.srm.dao;

import org.apache.ibatis.annotations.Mapper;

import com.want.srm.entity.IsDelete;

@Mapper
public interface IsDeleteDao {
    int deleteByPrimaryKey(Integer id);

    int insert(IsDelete record);

    int insertSelective(IsDelete record);

    IsDelete selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(IsDelete record);

    int updateByPrimaryKey(IsDelete record);
    
    IsDelete selectByAccount(String account);
}