package com.want.srm.service;

import java.util.List;
import java.util.Map;

import com.want.srm.po.FileInofPO;
import com.want.srm.vo.AttributeInfoVO;
import com.want.srm.vo.CommonReturnList;
import com.want.srm.vo.FactoryVo;
import com.want.srm.vo.PurchaseVO;
import com.want.srm.vo.SupplierVO;

public interface IBaseDataService {

	List<AttributeInfoVO> getAttributeInfo(Map<String, String> map);

	CommonReturnList<FactoryVo> getFactoryByCondition(Map<String, String> map);

	List<SupplierVO> getSupplierByCondition(Map<String, String> map);
	
	CommonReturnList<PurchaseVO> getPurchaseByCondition(Map<String, String> map);

	void uploadFile(FileInofPO fileInfo);
	
	String checkFile(String qmnum);
	
	List<Map<String, String>> checkFileName(String qmnum);
}
