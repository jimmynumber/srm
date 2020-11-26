package com.want.srm.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.want.srm.entity.ZT009;

@Mapper
public interface ZT009Dao {
    int deleteByPrimaryKey(String dzbdh);

    int insert(ZT009 record);

    int insertSelective(ZT009 record);

    ZT009 selectByPrimaryKey(String dzbdh);

    int updateByPrimaryKeySelective(ZT009 record);

    int updateByPrimaryKey(ZT009 record);
    
    List<ZT009> selectListByCode(String statementCode);
    
    List<ZT009> selectZT009ListBydzbdh(String dzbdh);

    int insertList(List<ZT009> list);
    
    String selectNextId();
}