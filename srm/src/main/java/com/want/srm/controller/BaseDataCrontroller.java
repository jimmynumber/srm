package com.want.srm.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.want.srm.service.IBaseDataService;
import com.want.srm.service.UserService;
import com.want.srm.vo.AttributeInfoVO;
import com.want.srm.vo.CommonReturnList;
import com.want.srm.vo.FactoryVo;
import com.want.srm.vo.PurchaseVO;
import com.want.srm.vo.SupplierVO;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("/basedata")
@Api(tags = "基本信息")
@CrossOrigin
public class BaseDataCrontroller {

	@Autowired
	private IBaseDataService baseDataService;
	
	@Autowired
	private UserService userService;
	
    // 获取配置属性
    @PostMapping(value = "/getAttributeInfo") 
    public List<AttributeInfoVO> getAttributeInfo(@RequestBody(required = false) Map<String, String> map) {
    	return baseDataService.getAttributeInfo(map);
    }  
	
    @PostMapping(value = "/getFactoryByCondition") 
    public CommonReturnList<FactoryVo> getFactoryByCondition(@RequestBody(required = false) Map<String, String> map,@RequestHeader(value="userId",required = false) String userId) {
    	map.put("userId", userId);
    	return baseDataService.getFactoryByCondition(map);
    }  
    
    @PostMapping(value = "/getSupplierByCondition") 
    public List<SupplierVO> getSupplierByCondition(@RequestBody(required = false) Map<String, String> map) {
    	return baseDataService.getSupplierByCondition(map);
    }  

    // 获取采购组织下拉框
	@PostMapping(value = "/getPurchaseByCondition")
	public CommonReturnList<PurchaseVO> getPurchaseByCondition(@RequestBody(required = false) Map<String, String> map,@RequestHeader(value="userId",required = false) String userId){
		map.put("userId", userId);
		return baseDataService.getPurchaseByCondition(map);
	}
    
	
    
    
}
