package com.want.srm.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.want.srm.po.FileInofPO;
import com.want.srm.vo.AttributeInfoVO;
import com.want.srm.vo.FactoryVo;
import com.want.srm.vo.PurchaseVO;
import com.want.srm.vo.SupplierVO;

@Mapper
public interface BaseDataMapper {
	
	List<AttributeInfoVO> getAttributeInfo(Map<String, String> map);

	List<FactoryVo> getFactoryByCondition(Map<String, String> map);
	
	List<PurchaseVO> getPurchaseByCondition(Map<String, String> map);
	
	List<SupplierVO> getSupplierByCondition(Map<String, String> map);

	void uploadFile(FileInofPO fileInfo);
	
	String checkFile(String qmnum);
	
	List<Map<String, String>> checkFileName(String qmnum);
    
}