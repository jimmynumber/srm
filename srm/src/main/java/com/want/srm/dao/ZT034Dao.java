package com.want.srm.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.want.srm.entity.ZT034;
import com.want.srm.vo.ZT003VO;

@Mapper
public interface ZT034Dao {
    int deleteByPrimaryKey(String dzbdh);

    int insert(ZT034 record);

    int insertSelective(ZT034 record);

    ZT034 selectByPrimaryKey(String dzbdh);

    int updateByPrimaryKeySelective(ZT034 record);

    int updateByPrimaryKey(ZT034 record);
    
    List<ZT034> selectListByCode(String statementCode);
    
    List<ZT034> selectZT034ListBydzbdh(String dzbdh);
    
    List<ZT003VO> selectZT003ListBydzbdh(String dzbdh);

    int insertList(List<ZT034> list);
    
    String selectNextId();
}