package com.want.srm.dao;

import org.apache.ibatis.annotations.Mapper;

import com.want.srm.entity.ZT042;

@Mapper
public interface ZT042Dao {
    int deleteByPrimaryKey(String zguid);

    int insert(ZT042 record);

    int insertSelective(ZT042 record);

    ZT042 selectByPrimaryKey(String zguid);

    int updateByPrimaryKeySelective(ZT042 record);

    int updateByPrimaryKey(ZT042 record);
}