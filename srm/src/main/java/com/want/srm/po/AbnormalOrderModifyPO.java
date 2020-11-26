package com.want.srm.po;

import java.io.Serializable;
import lombok.Data;

@Data
public class AbnormalOrderModifyPO implements Serializable {
 
	private static final long serialVersionUID = 1L;
	private String qmnum;          //通知单号   
    private String qmart;          //异常类别2 
    private String gysfkzt_b;      //缺陷反馈单状态  
	private String gysfkzt;        //缺陷反馈单状态  
	private String gysdat;         //发送供应商日期
	private String gysfkdat;       //供应商最后反馈日期     
	private String ycfx;           //异常分析                     
	private String yccl;           //处理意见 
	private String gsfs;           //改善措施                     
	private String clfs;           //最终处理结果                     
	private String pcje;           //扣款金额  
	private String bz;             //备注
	private String bdwcdat;        //表单完成日期  
	private String phyy;           //驳回原因  
	private String aedat;          //更改日期  
	private String bycd;           //bpm异常单号                     
	private String senam;          //r/3 系统, 用户登录名  
	private String clfsDes;        //最终处理结果备注   
	
}
