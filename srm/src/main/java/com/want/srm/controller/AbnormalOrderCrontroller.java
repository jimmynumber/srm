package com.want.srm.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.want.srm.po.AbnormalOrderModifyPO;
import com.want.srm.po.AbnormalOrderPO;
import com.want.srm.service.IAbnormalOrderService;
import com.want.srm.vo.CommonReturnType;
import com.want.srm.vo.Pagination;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/abnormalorder")
@Api(tags = "异常单协同")
@CrossOrigin
public class AbnormalOrderCrontroller {
	@Autowired
	private IAbnormalOrderService Service;
	
	@ApiOperation(value = "缺陷单查询", nickname="queryAbnormalOrderByCondition", notes = "post获取")
	@PostMapping("/queryAbnormalOrderByCondition") 
	public Mono<Pagination<Map<String, Object>>> queryAbnormalOrderByCondition(@RequestBody(required=false) AbnormalOrderPO model,
			@RequestParam(value = "pageNum", defaultValue = "1") Long pageNum,
	        @RequestParam(value = "pageSize", defaultValue = "15") Long pageSize) {
		return Mono.justOrEmpty((Service.queryAbnormalOrderByCondition(pageNum, pageSize,model)));
	}
	
	@ApiOperation(value = "缺陷单查询详情", nickname="queryAbnormalOrderByQmnum", notes = "post获取")
	@PostMapping("/queryAbnormalOrderByQmnum") 
	public CommonReturnType queryAbnormalOrderByQmnum(String qmnum) {
		return Service.queryAbnormalOrderByQmnum(qmnum);
	}
	
	@ApiOperation(value = "修改缺陷单", nickname="modifyAbnormalOrderByKey", notes = "post修改")
	@PostMapping("/modifyAbnormalOrderByKey") 
	public CommonReturnType  modifyAbnormalOrderByKey(@RequestBody(required=false) AbnormalOrderModifyPO model) {
		return Service.modifyAbnormalOrderByKey(model);
	}
	
	@ApiOperation(value = "异常单导出pdf", nickname="printAbnormalorderPdf", notes = "post获取")
	@RequestMapping("/printAbnormalorderPdf")
    public ModelAndView printAbnormalorderPdf(String qmnum){
		  return Service.printAbnormalorderPdf(qmnum);
    }
}
