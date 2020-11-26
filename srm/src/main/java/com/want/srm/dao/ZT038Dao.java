package com.want.srm.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.want.srm.entity.ZT038;

@Mapper
public interface ZT038Dao {
    int deleteByPrimaryKey(String dzbdh);

    int insert(ZT038 record);

    int insertSelective(ZT038 record);

    ZT038 selectByPrimaryKey(String dzbdh);

    int updateByPrimaryKeySelective(ZT038 record);

    int updateByPrimaryKey(ZT038 record);
    
    List<ZT038> selectListByCode(String statementCode);
    
    List<ZT038> selectZT038ListBydzbdh(String dzbdh);
    
    int insertList(List<ZT038> list);
    
    String selectNextId();
}