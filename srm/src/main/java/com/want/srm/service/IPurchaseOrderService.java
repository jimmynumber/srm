package com.want.srm.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import com.want.srm.vo.CommonReturnType;
import com.want.srm.vo.EkpoVO;

public interface IPurchaseOrderService {

	CommonReturnType queryPurchaseOrderByCondition(Long pageNum, Long pageSize, Map<String, String> map);

	CommonReturnType insertPurchaseBatch(List<EkpoVO> list);
	
	CommonReturnType modifyPurchaseBatch(EkpoVO ekpoVO);
	
	CommonReturnType getPurchaseByZrfcqqt003(Map<String, String> map);
	
	public Map<String, Object> getPurchaseByZrfcqqt006(String EBELN);
	
	void exportPurchaseOrderExcelByCondition(Map<String, String> map);
}
