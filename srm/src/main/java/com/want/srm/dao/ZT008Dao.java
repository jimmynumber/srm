package com.want.srm.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.want.srm.entity.ZT008;
import com.want.srm.vo.Pagination;
import com.want.srm.vo.RfccatchaccinfResVO;
import com.want.srm.vo.StatementDto;
import com.want.srm.vo.StatementInfoVo;
import com.want.srm.vo.StatementVo;

@Mapper
public interface ZT008Dao {
    int deleteByPrimaryKey(String dzbdh);

    int insert(ZT008 record);

    int insertSelective(ZT008 record);

    ZT008 selectByPrimaryKey(String dzbdh);

    int updateByPrimaryKeySelective(ZT008 record);

    int updateByPrimaryKey(ZT008 record);
    
    List<StatementVo> selectStatementByCondition(StatementDto statementDto);
    
    StatementInfoVo selectStatementInfoByCode(String code);
    
    ZT008 selectZT008ByPrimaryKey(String dzbdh);
    
    ZT008 selectZT008(String dzbdh);
    
    String selectNextId();
    
    boolean isExistsStatement(Map<String,String> map);
    
    boolean isExistsRecord();


	long selcectStatementCount(Pagination<StatementVo> pagination);

	List<StatementVo> selcectStatementListByPage(Pagination<StatementVo> pagination);
	
	String selcectNewData();
	
	List<RfccatchaccinfResVO> queryExistsStatement(List<RfccatchaccinfResVO> list);
}