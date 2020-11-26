package com.want.srm.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "对账单修改操作参数")
public class UpdateStatementVo {
	
	@ApiModelProperty(value = "对账单单号")
	private String zvoucherno; //对账单单号
	
	@ApiModelProperty(value = "状态")
	private String confs; //状态	--ZT008.CONFS
	
	@ApiModelProperty(value = "全球唯一标识")
	private String zguid; //全球唯一标识	--ZT042.ZGUID
	
	@ApiModelProperty(value = "操作类型 B-发送 ,C-确认 ,D- 删除")
	private String ztype; //操作类型 --ZT042.ZTYPE
	
	@ApiModelProperty(value = "操作结果")
	private String zresult; //操作结果 --ZT042.ZRESULT
	
	@ApiModelProperty(value = "删除类型")//1- 外面删除(状态是C才可以删除), 2-里面删除（状态是A、B才可以删除）
	private String deleteType; //
	
	private String userId;

}
