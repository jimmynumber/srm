package com.want.srm.controller;

import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import com.want.srm.po.EkpoPO;
import com.want.srm.service.IPurchaseOrderService;
import com.want.srm.utils.PurchaseOrderPDF;
import com.want.srm.vo.CommonReturnType;
import com.want.srm.vo.EkpoVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = "采购订单")
@RestController
@RequestMapping("/purchase")
@CrossOrigin
public class PurchaseOrderController {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private IPurchaseOrderService service;

	@ApiOperation(value = "采购订单查询", nickname="queryPurchaseOrderByCondition", notes = "post获取")
	@PostMapping("/queryPurchaseOrderByCondition") 
	public CommonReturnType queryPurchaseOrderByCondition(@RequestBody(required = false) Map<String, String> map,
			@RequestParam(value = "pageNum", defaultValue = "1") Long pageNum,
	        @RequestParam(value = "pageSize", defaultValue = "15") Long pageSize){
		return service.queryPurchaseOrderByCondition(pageNum, pageSize,map);
	}
	
	
	@ApiOperation(value = "批量写入采购订单", nickname="insertPurchaseBatch", notes = "post提交")
	@PostMapping("/insertPurchaseBatch") 
	public CommonReturnType insertPurchaseBatch(@RequestBody(required = true) EkpoPO ekpoPO){
		if (ekpoPO ==null || ekpoPO.getEkpoList().isEmpty()) {
			return CommonReturnType.create(null, "参数不可为空", null);
		}
		return service.insertPurchaseBatch(ekpoPO.getEkpoList());
	}
	
	@ApiOperation(value = "批量写入采购订单", nickname="modifyPurchaseBatch", notes = "post提交")
	@PostMapping("/modifyPurchaseBatch") 
	public CommonReturnType modifyPurchaseBatch(@RequestBody(required = true)EkpoVO ekpoVO){
		if (ekpoVO ==null) {
			return CommonReturnType.create(null, "参数不可为空", null);
		}
		return service.modifyPurchaseBatch(ekpoVO);
	}
	
	@ApiOperation(value = "调pi接口获取采购订单", nickname="getPurchaseByZrfcqqt003", notes = "post提交")
	@PostMapping("/getPurchaseByZrfcqqt003") 
	public CommonReturnType getPurchaseByZrfcqqt003(@RequestBody(required = false) Map<String, String> map){
		return service.getPurchaseByZrfcqqt003(map);
	}
	
	@ApiOperation(value = "采购单导出pdf", nickname="printPurchaseOrderPdf", notes = "post获取")
	@RequestMapping("/printPurchaseOrderPdf")
    public ModelAndView printPurchaseOrderPdf(String EBELN){
		logger.info("采购单号："+EBELN);
		if(EBELN.matches("[0-9]+")) {
			return new ModelAndView(new PurchaseOrderPDF(), service.getPurchaseByZrfcqqt006(EBELN));
		}else {
			return null;
		}
    }
	
	@ApiOperation(value = "采购单导出excel", nickname="exportPurchaseOrderExcel", notes = "post获取")
	@RequestMapping("/exportPurchaseOrderExcel")
    public void printPurchaseOrderExcel(@RequestBody(required = false) Map<String, String> map){
		
		service.exportPurchaseOrderExcelByCondition(map);
    }
	
	
}
