package com.want.srm.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateStatementPO {
	private String werks; // 收货方
	private String lifnr; // 供应商
	private String matnr_s; // 料号（起）
	private String matnr_e; // 料号（止）
	private String ekorg_s; // 采购组织（起）
	private String ekorg_e; // 采购组织（止）
	private String ekor_s; // 采购组（起）
	private String ekor_e; // 采购组（止）
	private String proof_type_s; // 凭证类型（起）
	private String proof_type_e; // 凭证类型（止）
	private String bedat; // 过账日期（起）
	private String endat; // 过账日期（止）
	private String cpudt_s; // 凭证录入日期（起）
	private String cpudt_e; // 凭证录入日期（止）
	private String cycsdat; // 制程异常处理完成日期（起）
	private String cycedat; // 制程异常处理完成日期（止）
	private String ebeln_s; // 采购凭证（起）
	private String ebeln_e; // 采购凭证（止）
	private String btext_s; // 移动类型（起）
	private String btext_e; // 移动类型（止）
	private String matnr_type_s; // 物料类型（起）
	private String matnr_type_e; // 物料类型（止）
	private String ycsdat; // 进料异常处理完成日期（起）
	private String ycedat; // 进料异常处理完成日期（止）
	private String udbdate; // UD过账日期（起）
	private String udedate; // UD过账日期（止）
	private String zsjwerks; // 实际收货方

}
