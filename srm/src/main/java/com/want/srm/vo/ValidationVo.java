package com.want.srm.vo;

import lombok.Data;

@Data
public class ValidationVo {
	
	private String werks;    //收货方
	private String zsjwerks; //实际收货方
	private String bcdat;   //凭证录入日期起 
	private String ecdat;   //凭证录入日期至
	private String cycsdat; //制程异常处理完成日期起   
	private String cycedat; //制程异常处理完成日期至
	private String bedat;   //过账日期起   
	private String endat;   //过账日期至   	
}
