package com.want.srm.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "对账单查询参数")
public class StatementDto {
	
	@ApiModelProperty(value = "工厂")
	private String factoryIds;//工厂
	
	@ApiModelProperty(value = "供应商编号")
	private String supplierCodes;//供应商编号
	
	@ApiModelProperty(value = "对账单状态")
	private String stateIds;//对账单状态
	
	@ApiModelProperty(value = "对账单创建日期(开始)")
	private String createDate_s;//对账单创建日期(开始)
	
	@ApiModelProperty(value = "对账单创建日期(结束)")
	private String createDate_e;//对账单创建日期(结束)
	
	@ApiModelProperty(value = "对帐单号起")
	private String reconCode_s;//对帐单号起
	
	@ApiModelProperty(value = "对帐单号止")
	private String reconCode_e;//对帐单号止
	
	@ApiModelProperty(value = "实际工厂")
	private String realFactoryIds;//实际工厂
	
	private int isSupplier;
}
