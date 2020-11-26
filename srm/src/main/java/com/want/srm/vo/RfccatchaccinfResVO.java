package com.want.srm.vo;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
//@AllArgsConstructor
public class RfccatchaccinfResVO {
	private String werks;   //工厂
	private String name1;   //名称
	private String lifnr;   //供应商或债权人的帐号
	private String name;    //名称
	private String ebeln;   //采购凭证号
	private String ebelp;   //采购凭证的项目编号
	private String budat;   //凭证中的过帐日期
	private String mblnr;   //物料凭证编号
	private String buzel;   //物料凭证中的项目
	private String mjahr;   //物料凭证年度
	private String matnr;   //物料号
	private String maktx;   //物料描述（短文本）
	private String bpmng;   //采购订单价格单位的数量
	private String msehl;   //计量单位描述
	private String msejs;   //辅助计量单位
	private String menge;   //数量
	private String netpr;   //净价
	private String peinh;   //价格单位
	private String waers;   //货币码
	private String dmbtr;   //按本位币计的金额
	private String kbetr;    //价格( 条件金额或百分数 )
	private String text1;    //付款条件
	private String btext;    //移动类型文本(库存管理)
	private String ekorg;    //采购组织
	private String vaedatum; //使用决定的更改日期
	private String lsmng;    //交货单的计量单位数量
	private String zsjdhje;  //实际到货金额（价税合计）
	private String zcyl;     //差异率
	private String mwskz;    //销售/购买税代码
	private String zsjwerks; //实际工厂
	private String zsjwerksdesc; //实际工厂描述
	private String cpudt;        //会计凭证录入日期
	public RfccatchaccinfResVO(String werks, String name1, String lifnr, String name, String ebeln, String ebelp,
			String budat, String mblnr, String buzel, String mjahr, String matnr, String maktx, String bpmng,
			String msehl, String msejs, String menge, String netpr, String peinh, String waers, String dmbtr,
			String kbetr, String text1, String btext, String ekorg, String vaedatum, String lsmng, String zsjdhje,
			String zcyl, String mwskz, String zsjwerks, String zsjwerksdesc, String cpudt) {
		super();
		this.werks = werks;
		this.name1 = name1;
		this.lifnr = lifnr;
		this.name = name;
		this.ebeln = ebeln;
		this.ebelp = ebelp;
		this.budat = budat;
		this.mblnr = mblnr;
		this.buzel = buzel;
		this.mjahr = mjahr;
		this.matnr = matnr;
		this.maktx = maktx;
		this.bpmng = bpmng;
		this.msehl = msehl;
		this.msejs = msejs;
		this.menge = menge;
		this.netpr = netpr;
		this.peinh = peinh;
		this.waers = waers;
		this.dmbtr = dmbtr;
		this.kbetr = kbetr;
		this.text1 = text1;
		this.btext = btext;
		this.ekorg = ekorg;
		this.vaedatum = vaedatum;
		this.lsmng = lsmng;
		this.zsjdhje = zsjdhje;
		this.zcyl = zcyl;
		this.mwskz = mwskz;
		this.zsjwerks = zsjwerks;
		this.zsjwerksdesc = zsjwerksdesc;
		this.cpudt = cpudt;
	}
	
}
