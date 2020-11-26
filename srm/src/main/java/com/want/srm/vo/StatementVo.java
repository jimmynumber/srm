package com.want.srm.vo;

import lombok.Data;

@Data
public class StatementVo {
	
	private String dzbdh;	//对账表单号
	private String confs;	//对账表状态
	private String name;	//供应商
	private String name1;	//收货方
	private String bcdat;	//录入日期起自
	private String ecdat;	//录入日期终止	
	private String bedat;	//过账日期起自	
	private String endat;	//过账日期终至
	private String erdat;	//创建日期
	private String sedat;	//发送日期
	private String cfdat;	//确认日期
	
}
