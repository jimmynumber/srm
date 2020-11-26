package com.want.srm.vo;

import java.io.Serializable;

import lombok.Data;

@Data
public class CommonReturnType implements Serializable{
	private String status; //  success:"成功",fail,"失败"
	private String message;
	private Object data;
	private static final long serialVersionUID = 1L;
	
	public static CommonReturnType create(Object data,String msg) {
		return CommonReturnType.create(data,msg,"S");
	}
	public static CommonReturnType create(Object data,String msg,String status) {
		CommonReturnType crt= new CommonReturnType();
		crt.setStatus(( status==null || status.trim().length()<=0 )?"E":status);
		crt.setData(data);
		crt.setMessage(msg);
		return crt;
	}
}
