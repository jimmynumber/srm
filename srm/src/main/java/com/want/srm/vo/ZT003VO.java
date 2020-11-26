package com.want.srm.vo;

import java.io.Serializable;
import java.math.BigDecimal;

import lombok.Data;

@Data
public class ZT003VO implements Serializable{
	private static final long serialVersionUID = 1L;
	private String qmnum;          //通知单号                      
    private String prueflos;       //检验批编号                         
    private String art;            //检验类型                    
    private String matnr;          //物料编号                      
    private String werks;          //工厂                      
    private String lifnr;          //供应商或债权人的帐号                      
    private String mgein;          //计量单位                      
    private String ebeln;          //采购凭证号                      
    private String ebelp;          //采购凭证的项目编号                      
    private String charg;          //批次                      
    private String mblnr;          //number of material document                      
    private String buzei;          //物料凭证中的项目                      
    private String budat;          //收货过账日期                      
    private String rkmng;      //意见数量                      
    private String menge;      //数量                      
    private String lichn;          //原厂批号                      
    private String mgeig;      //异常数量                      
    private String groes;          //大小/量纲                      
    private String qmart;          //异常类别2                      
    private String qmartDesc;      //异常类别2描述                     
    private String qmtxt;          //异常描述                      
    private String maktx;          //物料描述                      
    private String werksName;      //名称                           
    private String lifnrName;      //名称1                           
    private String gysfkzt;        //缺陷反馈单状态                        
    private String gysfkztDesc;    //缺陷反馈单状态描述                        
    private String erdat;          //创建日期                      
    private String gysdat;         //发送供应商日期                       
    private String gysfkdat;       //供应商最后反馈日期                         
    private String ycfx;           //异常分析                     
    private String yccl;           //处理意见                     
    private String gsfs;           //改善措施                     
    private String clfs;           //最终处理结果                     
    private String pcje;       //扣款金额                     
    private String bz;             //备注                   
    private String waers;          //货币码                      
    private String bdwcdat;        //表单完成日期                        
    private String phyy;           //驳回原因                     
    private String gjahr;          //会计年度                      
    private String aedat;          //更改日期                      
    private String aedat1;         //erp异常单更改日期                       
    private String aezeit;         //erp异常单修改时间                       
    private String bycd;           //bpm异常单号                     
    private String senam;          //r/3 系统, 用户登录名                      
    private String zsjwerks;       //实际工厂                         
    private String zsjwerksDesc;  //实际工厂描述                              
    private String ebeln1;         //采购凭证号                       
    private String ebelp1;         //采购凭证的项目编号                       
    private String mblnr1;         //收货物料凭证                       
    private String mblpo1;         //物料凭证中的项目    
    private String clfsDesName;    //最终处理结果备注(配置表信息)    
    private String clfsDes;       //最终处理结果备注    
                     
}
