package com.want.srm.vo;

import java.io.Serializable;
import java.util.Collection;

import lombok.Data;

@Data
public class CommonReturnList<T> implements Serializable{
	private String status; //  success:"成功",fail,"失败"
	private String message;
	private Collection<T>  data;
	private static final long serialVersionUID = 1L;
	
	public static <T> CommonReturnList<T> create(Collection<T> data,String msg) {
		return CommonReturnList.create(data,msg,"S");
	}
	public static <T> CommonReturnList<T> create(Collection<T> data,String msg,String status) {
		CommonReturnList<T> crt= new CommonReturnList<T>();
		crt.setStatus(( status==null || status.trim().length()<=0 )?"E":status);
		crt.setData(data);
		crt.setMessage(msg);
		return crt;
	}
}
