package com.want.srm.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.want.srm.dao.BaseDataMapper;
import com.want.srm.po.FileInofPO;
import com.want.srm.service.IBaseDataService;
import com.want.srm.vo.AttributeInfoVO;
import com.want.srm.vo.CommonReturnList;
import com.want.srm.vo.FactoryVo;
import com.want.srm.vo.PurchaseVO;
import com.want.srm.vo.SupplierVO;

@Service
public class BaseDataServiceImpl implements IBaseDataService {

	@Autowired
	private BaseDataMapper mapper;
	
	@Override
	public List<AttributeInfoVO> getAttributeInfo(Map<String, String> map) {
		return mapper.getAttributeInfo(map);
	}

	@Override
	public CommonReturnList<FactoryVo> getFactoryByCondition(Map<String, String> map) {
		List<FactoryVo> list=mapper.getFactoryByCondition(map);
		CommonReturnList<FactoryVo> result=null;
		if (list !=null && list.size()>0 ) {
			result=CommonReturnList.create(list, "");
		}else {
			result=CommonReturnList.create(list, "查无数据");
		}
		return result;
	}

	@Override
	public CommonReturnList<PurchaseVO> getPurchaseByCondition(Map<String, String> map) {
		List<PurchaseVO> list=mapper.getPurchaseByCondition(map);
		CommonReturnList<PurchaseVO> result=null;
		if (list !=null && list.size()>0 ) {
			result=CommonReturnList.create(list, "");
		}else {
			result=CommonReturnList.create(list, "查无数据");
		}
		return result;
	}

	@Override
	public List<SupplierVO> getSupplierByCondition(Map<String, String> map) {
		return mapper.getSupplierByCondition(map);
	}

	@Override
	public void uploadFile(FileInofPO fileInfo) {
		mapper.uploadFile(fileInfo);
	}
	
	@Override
	public String checkFile(String qmnum) {
		return mapper.checkFile(qmnum);
	}
	
	@Override
	public List<Map<String, String>> checkFileName(String qmnum) {
		return mapper.checkFileName(qmnum);
	}
	
}
