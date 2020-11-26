package com.want.srm.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.want.srm.po.AbnormalOrderModifyPO;
import com.want.srm.po.AbnormalOrderPO;
import com.want.srm.po.FileInofPO;
import com.want.srm.vo.Pagination;
import com.want.srm.vo.RfccatchaccinfResVO;
import com.want.srm.vo.ZT001VO.ZT001;
import com.want.srm.vo.ZT003VO;

@Mapper
public interface AbnormalOrderMapper {
	
	List<ZT003VO> queryAbnormalOrderByCondition(AbnormalOrderPO model) ;

	List<ZT001> queryAbnormalOrderByQmnum(@Param("qmnum")String qmnum);

	Integer modifyAbnormalOrderByKey(AbnormalOrderModifyPO model);
	
	List<ZT003VO> queryAbnormalOrderByParam(Map<String,String> map);
	
	//检查附件是否存在
	FileInofPO findZT005ByCondition(String qmnum, String gysfkxm);
	
	//附件删除
	Integer deleteZT005(String qmnum, String gysfkxm);
	
	List<FileInofPO> queryZT005ByParams(Map<String,String> map);

	long queryAbnormalOrderCount(Pagination<Map<String, Object>> pagination);

	List<Map<String, Object>> queryAbnormalOrder(Pagination<Map<String, Object>> pagination);

	List<ZT003VO> queryAbnormalOrderByRfc(List<RfccatchaccinfResVO> list);
}