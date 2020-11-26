package com.want.srm.po;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AbnormalOrderPO implements Serializable {
 
	private static final long serialVersionUID = 1L;
	private String qmnum;            //通知单号
	private String factoryIds;       //工厂
	private String createDate_s;     //通知单创建日期(开始)
	private String createDate_e;     //通知单创建日期(结束)
	private String finishDate_s;     //表单完成日期（开始）
	private String finishDate_e;     //表单完成日期（结束）
	private String noticeCode_s;     //通知单号（开始）
	private String noticeCode_e;     //通知单号（结束）
	private String stateIds;         //缺陷反馈单状态接口
	private String typeIds;          //异常类别
	private String orderCode_s;      //采购订单号（开始）
	private String orderCode_e;      //采购订单号（结束）
	private String orderCodeLineId;  //采购订单行项目
	private String materialDes;      //物料描述
	private String supplierIds;      //供应商代码
	private String supplierName;     //供应商名称
	private String actualFactoryIds; //实际工厂
	private String sendDate_s;       //发送供应商日期（开始）
	private String sendDate_e;       //发送供应商日期（结束）
	private int isSupplier;
	public AbnormalOrderPO(String qmnum) {
		super();
		this.qmnum = qmnum;
	}
}
