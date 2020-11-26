package com.want.srm.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "采购单信息")
public class EkpoVO {
	
    @ApiModelProperty(value = "采购凭证号")
	private String ebeln;
	
    @ApiModelProperty(value = "采购凭证的项目编号")
	private String ebelp;
	
    @ApiModelProperty(value = "采购凭证日期")
	private String bedat;
	
    @ApiModelProperty(value = "项目交货日期")
	private String eeind;
	
    @ApiModelProperty(value = "物料号")
	private String matnr;
	
    @ApiModelProperty(value = "供应商编号")
	private String lifnr;
    
    @ApiModelProperty(value = "供应商名称")
	private String lifnrName;
	
    @ApiModelProperty(value = "物料描述（短文本）")
	private String txz01;
	
    @ApiModelProperty(value = "采购订单数量")
	private String menge;
	
    @ApiModelProperty(value = "订单单位")
	private String meins;
	
    @ApiModelProperty(value = "以凭证货币计)")
	private String netpr;
	
    @ApiModelProperty(value = "货币码")
	private String wkurs;
	
    @ApiModelProperty(value = "价格单位")
	private String peinh;
	
    @ApiModelProperty(value = "采购)")
	private String bprme;
	
    @ApiModelProperty(value = "PO货币的净定单价值")
	private String value;
	
    @ApiModelProperty(value = "付款条件代码")
	private String zterm;
	
    @ApiModelProperty(value = "购买税代码")
	private String mwskz;
	
    @ApiModelProperty(value = "无等级存在")
	private String kbetr;
	
    @ApiModelProperty(value = "工厂")
	private String werks;
	
    @ApiModelProperty(value = "名称")
	private String name;
	
    @ApiModelProperty(value = "实际工厂")
	private String werks1;
	
    @ApiModelProperty(value = "名称")
	private String name1;
	
    @ApiModelProperty(value = "采购凭证中的删除标识")
	private String loekz;
	
    @ApiModelProperty(value = "处理日期")
	private String datvr;
	
    @ApiModelProperty(value = "处理时间")
	private String uhrvr;
    
    @ApiModelProperty(value = "确认标识{A:未确认,B:已确认,C:已删除}")
    private String confirmStatus;
	
    @ApiModelProperty(value = "确认标识描述{A:未确认,B:已确认,C:已删除}")
    private String confirmStatusDesc;
    
    @ApiModelProperty(value = "确认人编号")
    private String confirmUser;

    @ApiModelProperty(value = "确认时间")
    private String confirmDate;

    @ApiModelProperty(value = "创建人编号")
    private String createUser;

    @ApiModelProperty(value = "创建时间")
    private String createDate;

    @ApiModelProperty(value = "修改人编号")
    private String updateUser;

    @ApiModelProperty(value = "修改时间")
    private String updateDate;
}
