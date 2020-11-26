package com.want.srm.vo;

import java.math.BigDecimal;
import java.util.List;

import javax.validation.constraints.NotBlank;

import com.want.srm.entity.ZT009;
import com.want.srm.entity.ZT034;
import com.want.srm.entity.ZT038;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "保存对账单参数")
public class StatementInfoVo {
	@ApiModelProperty(value = "对账表单号")
	private String dzbdh; //对账表单号
	
	@ApiModelProperty(value = "单位币别")
	private String waers; //单位币别
	
	@ApiModelProperty(value = "收货方")
	private String werks; //收货方
	
	@ApiModelProperty(value = "收货方名称")
	private String name1; //收货方名称
	
	@ApiModelProperty(value = "付款条件")
	private String text1; //付款条件
	
	@ApiModelProperty(value = "供应商代码")
	private String lifnr; //供应商代码
	
	@ApiModelProperty(value = "供应商名称	")
	private String name; //供应商名称	
	
	@ApiModelProperty(value = "价税合计总价")
	private BigDecimal ttlam;  //价税合计总价	
	
	@ApiModelProperty(value = "过账日期起")
	private String bedat; //过账日期起	
	
	@ApiModelProperty(value = "过账日期至")
	private String endat; //过账日期至	
	
	@ApiModelProperty(value = "未税合计总价")
	private BigDecimal ttlam2; //未税合计总价	
	
	@ApiModelProperty(value = "进料异常处理完成日期起	")
	private String ycsdat; //进料异常处理完成日期起	
	
	@ApiModelProperty(value = "进料异常处理完成日期至")
	private String ycedat; //进料异常处理完成日期至	
	
	@ApiModelProperty(value = "异常处理未完成项目价税合计")
	private BigDecimal ttlmi; //异常处理未完成项目价税合计	
	
	@ApiModelProperty(value = "制程异常处理完成日期起")
	private String cycsdat; //制程异常处理完成日期起	
	
	@ApiModelProperty(value = "制程异常处理完成日期至")
	private String cycedat; //制程异常处理完成日期至
	
	@ApiModelProperty(value = "本期可开票价税合计总价")
	private BigDecimal ttleq; //本期可开票价税合计总价	
	
	@ApiModelProperty(value = "UD过账日期起")
	private String udbdate; //UD过账日期起	
	
	@ApiModelProperty(value = "UD过账日期至")
	private String udedate; //UD过账日期至	
	
	@ApiModelProperty(value = "对账表状态")
	private String confs; //对账表状态
	
	@NotBlank(message="扣款方式不能为空")
	@ApiModelProperty(value = "扣款方式")
	private String zzgbz; //扣款方式	
	
	@ApiModelProperty(value = "实际收货方")
	private String zsjwerksDesc; //实际收货方	
	
	@ApiModelProperty(value = "本期扣款金额	")
	private BigDecimal ttlfi; //本期扣款金额	
	
	@ApiModelProperty(value = "凭证录入日期起")
	private String bcdat; //凭证录入日期起	
	
	@ApiModelProperty(value = "凭证录入日期至")
	private String ecdat; //凭证录入日期至
	
	@ApiModelProperty(value = "创建者")
	private String ernam; //创建者
	
	@ApiModelProperty(value = "创建日期")
	private String erdat;         
	
	@ApiModelProperty(value = "发送日期")
	private String sedat;          
	
	@ApiModelProperty(value = "确认日期")
	private String cfdat;    
	
	@ApiModelProperty(value = "删除日期")
	private String dedat;   
	
	@ApiModelProperty(value = "实际工厂")
	private String zsjwerks;     
	
	private String userId;
	
	private List<ZT009> zT009List;
	
	private List<ZT034> zT034List;
	
	private List<ZT038> zT038List;
}
