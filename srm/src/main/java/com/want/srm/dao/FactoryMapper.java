package com.want.srm.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.want.srm.entity.Factory;

@Mapper
public interface FactoryMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Factory record);

    int insertSelective(Factory record);

    Factory selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Factory record);

    int updateByPrimaryKey(Factory record);
    
    List<Factory> getAllFactory();
}