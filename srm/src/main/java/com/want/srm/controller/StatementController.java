package com.want.srm.controller;

import java.util.HashMap;
import java.util.Map;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import com.want.srm.po.CreateStatementPO;
import com.want.srm.service.StatementService;
import com.want.srm.utils.StatementPDF;
import com.want.srm.vo.CommonReturnType;
import com.want.srm.vo.FromVo;
import com.want.srm.vo.Pagination;
import com.want.srm.vo.StatementDto;
import com.want.srm.vo.StatementInfoVo;
import com.want.srm.vo.StatementVo;
import com.want.srm.vo.UpdateStatementVo;
import com.want.srm.vo.ValidationVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = "对账单")
@CrossOrigin
@RestController
@RequestMapping("/statement")
public class StatementController {
	
	@Autowired
	private StatementService statementService;

	@ApiOperation(value = "对账单列表", nickname="getStatementListByCondition", notes = "post获取")
	@PostMapping("/getStatementListByCondition")
	public Pagination<StatementVo> getList(@RequestParam(value = "pageNum", defaultValue = "1") Long pageNum,
	        @RequestParam(value = "pageSize", defaultValue = "15") Long pageSize,
			@RequestBody StatementDto statementDto){
		return statementService.selectStatementBycondPage(pageNum, pageSize,statementDto);
	}
	
	@ApiOperation(value = "获取对账单信息", nickname="getStatementInfo", notes = "get获取")
	@PostMapping("/info")
	public StatementInfoVo getInfo(@RequestBody FromVo fromVo){
		return statementService.getStatementInfo(fromVo);
	}
	
	@ApiOperation(value = "对账单导出pdf", nickname="printPdf", notes = "post获取")
	@RequestMapping("/printPdf")
    public ModelAndView printPdf(String DZBDH){
        Map<String, Object> model = new HashMap<>();
        model.put("DZBDH", DZBDH);
        model.put("ZT008", statementService.queryZT008(DZBDH));
        model.put("ZT009", statementService.queryZT009(DZBDH));
        model.put("ZT034", statementService.queryZT034(DZBDH));
        model.put("ZT038", statementService.queryZT038(DZBDH));
        model.put("ZT003", statementService.queryZT003(DZBDH));
        return new ModelAndView(new StatementPDF(), model);
    }
	
	@ApiOperation(value = "保存对账单信息", nickname="saveStatementInfo", notes = "post获取")
	@PostMapping("/save")
	public CommonReturnType saveInfo(@Valid @RequestBody StatementInfoVo statementInfoVo,@RequestHeader(value="userId",required = false) String userId){
		statementInfoVo.setUserId(userId);
		return statementService.saveStatementInfo(statementInfoVo);
	}
	
	@ApiOperation(value = "更新对账单信息", nickname="updateStatementInfo", notes = "post获取")
	@PostMapping("/update")
	public CommonReturnType updateInfo(@Valid @RequestBody UpdateStatementVo updateStatementVo,@RequestHeader(value="userId",required = false) String userId){
		updateStatementVo.setUserId(userId);
		return statementService.updateStatementInfo(updateStatementVo);
	}
	
	@ApiOperation(value = "验证实际收货方是否必输", nickname="validation", notes = "post获取")
	@PostMapping("/validation")
	public Map<String, String> validation(@Valid @RequestBody ValidationVo vo){
		return statementService.validation(vo);
	}
	
	@PostMapping("createStatement")
	public CommonReturnType createStatement(@RequestBody(required = false)CreateStatementPO model){
		return statementService.createStatement(model);
	}
}
