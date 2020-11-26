package com.want.srm.service.impl;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.itextpdf.text.pdf.PdfStructTreeController.returnType;
import com.want.srm.dao.AbnormalOrderMapper;
import com.want.srm.dao.AccountDao;
import com.want.srm.dao.ZT008Dao;
import com.want.srm.dao.ZT009Dao;
import com.want.srm.dao.ZT034Dao;
import com.want.srm.dao.ZT038Dao;
import com.want.srm.dao.ZT042Dao;
import com.want.srm.entity.Account;
import com.want.srm.entity.ZT008;
import com.want.srm.entity.ZT009;
import com.want.srm.entity.ZT034;
import com.want.srm.entity.ZT038;
import com.want.srm.entity.ZT042;
import com.want.srm.po.CreateStatementPO;
import com.want.srm.service.StatementService;
import com.want.srm.utils.BigDecimalUtil;
import com.want.srm.utils.ValidateHelper;
import com.want.srm.vo.CommonReturnType;
import com.want.srm.vo.FromVo;
import com.want.srm.vo.Pagination;
import com.want.srm.vo.RfccatchaccinfResVO;
import com.want.srm.vo.StatementDto;
import com.want.srm.vo.StatementInfoVo;
import com.want.srm.vo.StatementVo;
import com.want.srm.vo.UpdateStatementVo;
import com.want.srm.vo.ValidationVo;
import com.want.srm.vo.ZT003VO;
import com.want.srm.webservice.si_o_zrfc_catch_acc_inf.DTZRFCCATCHACCINFREQ;
import com.want.srm.webservice.si_o_zrfc_catch_acc_inf.DTZRFCCATCHACCINFRES;
import com.want.srm.webservice.si_o_zrfc_catch_acc_inf.SIOZRFCCATCHACCINFService;
import com.want.srm.webservice.si_o_zrfcsrm017.DTZRFCSRM017REQ;
import com.want.srm.webservice.si_o_zrfcsrm017.DTZRFCSRM017RES;
import com.want.srm.webservice.si_o_zrfcsrm017.SIOZRFCSRM017Service;

@Service
public class StatementServiceImpl implements StatementService {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private ZT008Dao zT008Dao;

	@Autowired
	private ZT009Dao zT009Dao;

	@Autowired
	private ZT034Dao zT034Dao;

	@Autowired
	private ZT038Dao zT038Dao;

	@Autowired
	private AbnormalOrderMapper abnormalOrderMapper;

	@Autowired
	private ZT042Dao zT042Dao;

	@Autowired
	private MailServiceImpl mailServcie;

	@Autowired
	private AccountDao accountDao;
	
	@Autowired
	private SIOZRFCSRM017Service sio17service;
	
	@Autowired
	private SIOZRFCCATCHACCINFService sioaccinfservice;

	@Value("${RealUrl}")
	private String sysUrl;

	@Override
	public List<StatementVo> selectStatementBycond(StatementDto statementDto) {
		return zT008Dao.selectStatementByCondition(statementDto);
	}

	@Override
	public StatementInfoVo getStatementInfo(FromVo fromvo) {
		StatementInfoVo result = new StatementInfoVo();
		result = zT008Dao.selectStatementInfoByCode(fromvo.getFromCode());
		if (result != null) {
			List<ZT009> zT009List = zT009Dao.selectListByCode(fromvo.getFromCode());
			result.setZT009List(zT009List);
			List<ZT034> zT034List = zT034Dao.selectListByCode(fromvo.getFromCode());
			result.setZT034List(zT034List);
			List<ZT038> zT038List = zT038Dao.selectListByCode(fromvo.getFromCode());
			result.setZT038List(zT038List);
		}
		return result;
	}

	public ZT008 queryZT008(String DZBDH) {
		return zT008Dao.selectZT008(DZBDH);
	}

	public List<ZT009> queryZT009(String DZBDH) {
		return zT009Dao.selectZT009ListBydzbdh(DZBDH);
	}

	public List<ZT034> queryZT034(String DZBDH) {
		return zT034Dao.selectZT034ListBydzbdh(DZBDH);
	}

	public List<ZT038> queryZT038(String DZBDH) {
		return zT038Dao.selectZT038ListBydzbdh(DZBDH);
	}

	public List<ZT003VO> queryZT003(String DZBDH) {
		return zT034Dao.selectZT003ListBydzbdh(DZBDH);
	}

	@Override
	public CommonReturnType createStatement(CreateStatementPO model) {
		logger.info("---------createStatement----------");
		DTZRFCCATCHACCINFREQ req = new DTZRFCCATCHACCINFREQ();
		DTZRFCCATCHACCINFREQ.OTDATA ot = new DTZRFCCATCHACCINFREQ.OTDATA();
		req.setOTDATA(ot);
		DTZRFCCATCHACCINFREQ.SWERKS swerks = new DTZRFCCATCHACCINFREQ.SWERKS();
		DTZRFCCATCHACCINFREQ.SWERKS.Item it = new DTZRFCCATCHACCINFREQ.SWERKS.Item();
		it.setSIGN("I");
		it.setOPTION("EQ");
		it.setLOW(model.getWerks());
		swerks.getItem().add(it);
		req.setSWERKS(swerks); // 工厂 输入 SRM必输

		DTZRFCCATCHACCINFREQ.SLIFNR slifnr = new DTZRFCCATCHACCINFREQ.SLIFNR();
		DTZRFCCATCHACCINFREQ.SLIFNR.Item slifnrit = new DTZRFCCATCHACCINFREQ.SLIFNR.Item();
		slifnrit.setSIGN("I");
		slifnrit.setOPTION("EQ");
		slifnrit.setLOW(model.getLifnr());
		slifnr.getItem().add(slifnrit);
		req.setSLIFNR(slifnr); // 供应商 输入 SRM必输

		String ekorg_s = model.getEkorg_s();
		DTZRFCCATCHACCINFREQ.SEKORG sekorg = new DTZRFCCATCHACCINFREQ.SEKORG();
		DTZRFCCATCHACCINFREQ.SEKORG.Item sekorgIt = new DTZRFCCATCHACCINFREQ.SEKORG.Item();
		if(StringUtils.isBlank(ekorg_s)) {
            sekorgIt.setSIGN("I");
            sekorgIt.setOPTION("CP");
            sekorgIt.setLOW("*");
            sekorg.getItem().add(sekorgIt);
        }else {
            String[] ekorgArray=ekorg_s.split(",");
            if (ValidateHelper.isNotEmpty(ekorgArray)) {
                for (String item : ekorgArray) {
                    sekorgIt = new DTZRFCCATCHACCINFREQ.SEKORG.Item();
                    sekorgIt.setSIGN("I");
                    sekorgIt.setOPTION("EQ");
                    sekorgIt.setLOW(item);
                    sekorg.getItem().add(sekorgIt);
                }
            }
        }
		req.setSEKORG(sekorg); // 采购组织 输入 SRM必输

		String ekor_s = model.getEkor_s(); // 采购组（起）
		String ekor_e = model.getEkor_e(); // 采购组（止）
		DTZRFCCATCHACCINFREQ.SEKGRP sekgrp = new DTZRFCCATCHACCINFREQ.SEKGRP();
		DTZRFCCATCHACCINFREQ.SEKGRP.Item sekgrpitem = new DTZRFCCATCHACCINFREQ.SEKGRP.Item();
		if (ValidateHelper.isNotEmpty(ekor_s) && ValidateHelper.isNotEmpty(ekor_e)) {
			sekgrpitem.setSIGN("I");
			sekgrpitem.setOPTION("BT");
			sekgrpitem.setLOW(ekor_s);
			sekgrpitem.setHIGH(ekor_e);
			sekgrp.getItem().add(sekgrpitem);
		}
		if (ValidateHelper.isNotEmpty(ekor_s) && ValidateHelper.isEmpty(ekor_e)) {
			String[] array=ekor_s.split(",");
            if (ValidateHelper.isNotEmpty(array)) {
                for (String item : array) {
                	sekgrpitem = new DTZRFCCATCHACCINFREQ.SEKGRP.Item();
        			sekgrpitem.setSIGN("I");
        			sekgrpitem.setOPTION("EQ");
        			sekgrpitem.setLOW(item);
        			sekgrp.getItem().add(sekgrpitem);
                }
            }
		}
		req.setSEKGRP(sekgrp); // 采购组 输入 SRM可输

		String cpudt_s = model.getCpudt_s(); // 凭证录入日期（起）
		String cpudt_e = model.getCpudt_e(); // 凭证录入日期（止）
		DTZRFCCATCHACCINFREQ.SCPUDT scpudt = new DTZRFCCATCHACCINFREQ.SCPUDT();
		DTZRFCCATCHACCINFREQ.SCPUDT.Item scpudtItem = new DTZRFCCATCHACCINFREQ.SCPUDT.Item();
		scpudtItem.setSIGN("I");
		scpudtItem.setOPTION("BT");
		scpudtItem.setLOW(cpudt_s);
		scpudtItem.setHIGH(cpudt_e);
		scpudt.getItem().add(scpudtItem);
		req.setSCPUDT(scpudt); // 凭证录入日期 输入 SRM必输
		
		String matnr_s = model.getMatnr_s(); // 料号（起）
		String matnr_e = model.getMatnr_e(); // 料号（止）
		DTZRFCCATCHACCINFREQ.SMATNR smatnr = new DTZRFCCATCHACCINFREQ.SMATNR();
		DTZRFCCATCHACCINFREQ.SMATNR.Item SMATNRitem = new DTZRFCCATCHACCINFREQ.SMATNR.Item();
		if (ValidateHelper.isNotEmpty(matnr_s) && ValidateHelper.isNotEmpty(matnr_e)) {
			SMATNRitem.setSIGN("I");
			SMATNRitem.setOPTION("BT");
			SMATNRitem.setLOW(matnr_s);
			SMATNRitem.setHIGH(matnr_e);
			smatnr.getItem().add(SMATNRitem);
		}
		if (ValidateHelper.isNotEmpty(matnr_s) && ValidateHelper.isEmpty(matnr_e)) {
			String[] array=matnr_s.split(",");
            if (ValidateHelper.isNotEmpty(array)) {
                for (String item : array) {
                	SMATNRitem = new DTZRFCCATCHACCINFREQ.SMATNR.Item();
        			SMATNRitem.setSIGN("I");
        			SMATNRitem.setOPTION("EQ");
        			SMATNRitem.setLOW(item);
        			smatnr.getItem().add(SMATNRitem);
                }
            }
		}
		req.setSMATNR(smatnr); // 物料 输入 SRM可输

		String proof_type_s = model.getProof_type_s(); // 凭证类型（起）
		String proof_type_e = model.getProof_type_e(); // 凭证类型（止）
		DTZRFCCATCHACCINFREQ.SBSART sbsart = new DTZRFCCATCHACCINFREQ.SBSART();
		DTZRFCCATCHACCINFREQ.SBSART.Item sbsartIt = new DTZRFCCATCHACCINFREQ.SBSART.Item();
		if (ValidateHelper.isNotEmpty(proof_type_s) && ValidateHelper.isNotEmpty(proof_type_e)) {
			sbsartIt.setSIGN("I");
			sbsartIt.setOPTION("BT");
			sbsartIt.setLOW(proof_type_s);
			sbsartIt.setHIGH(proof_type_e);
			sbsart.getItem().add(sbsartIt);
		}
		if (ValidateHelper.isNotEmpty(proof_type_s) && ValidateHelper.isEmpty(proof_type_e)) {
			String[] array=proof_type_s.split(",");
            if (ValidateHelper.isNotEmpty(array)) {
                for (String item : array) {
                	sbsartIt = new DTZRFCCATCHACCINFREQ.SBSART.Item();
        			sbsartIt.setSIGN("I");
        			sbsartIt.setOPTION("EQ");
        			sbsartIt.setLOW(item);
        			sbsart.getItem().add(sbsartIt);
                }
            }
		}
		req.setSBSART(sbsart); // 凭证类型 输入 SRM可输

		String bedat = model.getBedat(); // 过账日期（起）
		String endat = model.getEndat(); // 过账日期（止）
		DTZRFCCATCHACCINFREQ.SBUDAT sbudat = new DTZRFCCATCHACCINFREQ.SBUDAT();
		DTZRFCCATCHACCINFREQ.SBUDAT.Item sbudatIt = new DTZRFCCATCHACCINFREQ.SBUDAT.Item();
		if (ValidateHelper.isNotEmpty(bedat) && ValidateHelper.isNotEmpty(endat)) {
			sbudatIt.setSIGN("I");
			sbudatIt.setOPTION("BT");
			sbudatIt.setLOW(bedat);
			sbudatIt.setHIGH(endat);
			sbudat.getItem().add(sbudatIt);
		}
		if (ValidateHelper.isNotEmpty(bedat) && ValidateHelper.isEmpty(endat)) {
			sbudatIt.setSIGN("I");
			sbudatIt.setOPTION("EQ");
			sbudatIt.setLOW(bedat);
			sbudat.getItem().add(sbudatIt);
		} 
		req.setSBUDAT(sbudat); // 过帐日期 输入 SRM可输

		String btext_s = model.getBtext_s(); // 移动类型（起）
		String btext_e = model.getBtext_e(); // 移动类型（止）
		DTZRFCCATCHACCINFREQ.SBWART sbwart = new DTZRFCCATCHACCINFREQ.SBWART();
		DTZRFCCATCHACCINFREQ.SBWART.Item sbwartIt = new DTZRFCCATCHACCINFREQ.SBWART.Item();
		if (ValidateHelper.isNotEmpty(btext_s) && ValidateHelper.isNotEmpty(btext_e)) {
			sbwartIt.setSIGN("I");
			sbwartIt.setOPTION("BT");
			sbwartIt.setLOW(btext_s);
			sbwartIt.setHIGH(btext_e);
			sbwart.getItem().add(sbwartIt);
		}
		if (ValidateHelper.isNotEmpty(btext_s) && ValidateHelper.isEmpty(btext_e)) {
			String[] array=btext_s.split(",");
            if (ValidateHelper.isNotEmpty(array)) {
                for (String item : array) {
                	sbwartIt = new DTZRFCCATCHACCINFREQ.SBWART.Item();
        			sbwartIt.setSIGN("I");
        			sbwartIt.setOPTION("EQ");
        			sbwartIt.setLOW(item);
        			sbwart.getItem().add(sbwartIt);
                }
            }
		}
		req.setSBWART(sbwart); // 移动类型 输入 SRM可输

		String matnr_type_s = model.getMatnr_type_s(); // 物料类型（起）
		String matnr_type_e = model.getMatnr_type_e(); // 物料类型（止）
		DTZRFCCATCHACCINFREQ.SMTART.Item smtartIt = new DTZRFCCATCHACCINFREQ.SMTART.Item();
		DTZRFCCATCHACCINFREQ.SMTART smtart = new DTZRFCCATCHACCINFREQ.SMTART();
		if (ValidateHelper.isNotEmpty(matnr_type_s) && ValidateHelper.isNotEmpty(matnr_type_e)) {
			smtartIt.setSIGN("I");
			smtartIt.setOPTION("BT");
			smtartIt.setLOW(matnr_type_s);
			smtartIt.setHIGH(matnr_type_e);
			smtart.getItem().add(smtartIt);
		}
		if (ValidateHelper.isNotEmpty(matnr_type_s) && ValidateHelper.isEmpty(matnr_type_e)) {
			String[] array=matnr_type_s.split(",");
            if (ValidateHelper.isNotEmpty(array)) {
                for (String item : array) {
                	smtartIt = new DTZRFCCATCHACCINFREQ.SMTART.Item();
        			smtartIt.setSIGN("I");
        			smtartIt.setOPTION("EQ");
        			smtartIt.setLOW(item);
        			smtart.getItem().add(smtartIt);
                }
            }
		}
		req.setSMTART(smtart); // 物料类型 输入 SRM可输

		String ebeln_s = model.getEbeln_s(); // 采购凭证（起）
		String ebeln_e = model.getEbeln_e(); // 采购凭证（止）
		DTZRFCCATCHACCINFREQ.SEBELN.Item sebelnIt = new DTZRFCCATCHACCINFREQ.SEBELN.Item();
		DTZRFCCATCHACCINFREQ.SEBELN sebeln = new DTZRFCCATCHACCINFREQ.SEBELN();
		if (ValidateHelper.isNotEmpty(ebeln_s) && ValidateHelper.isNotEmpty(ebeln_e)) {
			sebelnIt.setSIGN("I");
			sebelnIt.setOPTION("BT");
			sebelnIt.setLOW(ebeln_s);
			sebelnIt.setHIGH(ebeln_e);
			sebeln.getItem().add(sebelnIt);
		}
		if (ValidateHelper.isNotEmpty(ebeln_s) && ValidateHelper.isEmpty(ebeln_e)) {
			String[] array=ebeln_s.split(",");
            if (ValidateHelper.isNotEmpty(array)) {
                for (String item : array) {
                	sebelnIt = new DTZRFCCATCHACCINFREQ.SEBELN.Item();
        			sebelnIt.setSIGN("I");
        			sebelnIt.setOPTION("EQ");
        			sebelnIt.setLOW(item);
        			sebeln.getItem().add(sebelnIt);
                }
            }
		}
		req.setSEBELN(sebeln); // 采购凭证 输入 SRM可输

		DTZRFCCATCHACCINFRES res = sioaccinfservice.getHTTPPort().siOZRFCCATCHACCINF(req);
		DTZRFCCATCHACCINFRES.OTDATA otdata = res.getOTDATA();
		List<DTZRFCCATCHACCINFRES.OTDATA.Item> otdataItem = otdata.getItem();
		List<RfccatchaccinfResVO> rfccatchaccinfResList = otdataItem.stream().map(i -> {
			RfccatchaccinfResVO vo = new RfccatchaccinfResVO(i.getWERKS(), i.getNAME1(), i.getLIFNR(), i.getNAME(),
					i.getEBELN(), i.getEBELP(), i.getBUDAT(), i.getMBLNR(), i.getBUZEL(), i.getMJAHR(), i.getMATNR(),
					i.getMAKTX(), i.getBPMNG(), i.getMSEHL(), i.getMSEJS(), i.getMENGE(), i.getNETPR(), i.getPEINH(),
					i.getWAERS(), i.getDMBTR(), i.getKBETR(), i.getTEXT1(), i.getBTEXT(), i.getEKORG(), i.getVAEDATUM(),
					i.getLSMNG(), i.getZSJDHJE(), i.getZCYL(), i.getMWSKZ(), i.getZSJWERKS(), i.getZSJWERKSDESC(),
					i.getCPUDT());
			//logger.info(vo+"");
			return vo;
		}).collect(Collectors.toList());
		System.out.println("rfccatchaccinfResList 过滤前数据量=" + rfccatchaccinfResList.size());

		rfccatchaccinfResList = rfccatchaccinfResList.stream().filter(filter -> {
			// UD过账日期UDDATE对于函数（ZMMACC_INFO-VAEDATUM）字段值检查，
			// 没在范围内删除SAP返回的值
			String udbdate = model.getUdbdate();
			String udedate = model.getUdedate();
			String vaedatum = filter.getVaedatum();
			if (ValidateHelper.isEmpty(udbdate) && ValidateHelper.isEmpty(udedate)) {
				return true;
			}
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			if (ValidateHelper.isNotEmpty(udbdate)) {
				try {
					Date vaedatumDate = sdf.parse(vaedatum);
					Date udbdateDate = sdf.parse(udbdate);
					if (!ValidateHelper.compare_str_date(vaedatumDate, udbdateDate)) {
						return false;
					}
				} catch (ParseException e) {
					logger.error("UD过账日期udbdate 数据格式异常 "+e);
					e.printStackTrace();
				}
			}
			if (ValidateHelper.isNotEmpty(udedate)) {
				try {
					Date vaedatumDate = sdf.parse(vaedatum);
					Date udedateDate = sdf.parse(udedate);
					if (!ValidateHelper.compare_str_date(udedateDate, vaedatumDate)) {
						return false;
					}
				} catch (ParseException e) {
					logger.error("UD过账日期udedate 数据格式异常 "+e);
					e.printStackTrace();
				}
			}
			return true;
		}).filter(filter -> {
			// 实际工厂ZSJWERKS对于函数（ZMMACC_INFO-ZSJWERKS）
			// 字段值检查，没在范围内删除SAP返回的值
			String zsjwerks = filter.getZsjwerks();// 实际工厂
			String zsjwerks_modle = model.getZsjwerks();
			if (ValidateHelper.isEmpty(zsjwerks_modle)) {
				return true;
			}
			return zsjwerks_modle.equals(zsjwerks);
		}).collect(Collectors.toList());

		// 依据物料凭证mblnr，物料凭证项目buzel，年度进行关联mjahr，限定状态A、B、C（CRQ000000051611），
		// 如果找不到往下进行，如果找到了则删除SAP返回的值
		if (ValidateHelper.isEmpty(rfccatchaccinfResList)) {
			 return CommonReturnType.create(null, "查无数据");
		}
		List<RfccatchaccinfResVO> rfccatchaccinfresvoList=zT008Dao.queryExistsStatement(rfccatchaccinfResList);
		logger.info("---pi接口---创建对账单数据 在zt008 中已存在数据量 = "+rfccatchaccinfresvoList.size());
		if (ValidateHelper.isNotEmpty(rfccatchaccinfresvoList)) {
			rfccatchaccinfResList=rfccatchaccinfResList.stream()
			.filter(os->! rfccatchaccinfresvoList
					.stream()
					.anyMatch(ns->(
									ns.getMblnr().equals(os.getMblnr()) 
									&& ns.getBuzel().equals(os.getBuzel()) 
									&& ns.getMjahr().equals(os.getMjahr()) 
								)
							)
			).collect(Collectors.toList());
		}
		logger.info("=======创建对账单过滤后数据量======="+rfccatchaccinfResList.size());
		
		RfccatchaccinfResVO rfccatchaccinfResVO = null;
		if (ValidateHelper.isNotEmpty(rfccatchaccinfResList)) {
			rfccatchaccinfResVO = rfccatchaccinfResList.get(0);
		} else {
			return CommonReturnType.create(null, "查无数据");
		}

		List<ZT009> zt009List = new ArrayList<ZT009>();
		List<ZT009> zt009ListResult = new ArrayList<ZT009>();
		List<ZT034> zt034List = new ArrayList<ZT034>();
		List<ZT038> zt038List = new ArrayList<ZT038>();
		rfccatchaccinfResList.stream().forEach(item -> {
			// 对账单行项目
			ZT009 zt009 = new ZT009();
			zt009.setDzbdh(null); // //对账表单号 EBELN ZT009_DZBDH
			zt009.setDzbms(null); // 对账表项目 ZDE_DZBXM ZT009_DZBMS 接口返回未保存是为空，保存后是页面的自动生成的序号
			zt009.setEkorg(item.getEkorg()); // 采购组织
			zt009.setEbeln(item.getEbeln()); // 采购凭证号
			zt009.setEbelp(item.getEbelp()); // 采购凭证的项目编号
			zt009.setBudat(item.getBudat()); // 凭证中的过帐日期 过帐日期 BUDAT ZT009_BUDAT
			zt009.setBtext(item.getBtext()); // 移动类型文本(库存)
			zt009.setMatnr(item.getMatnr()); // 物料编号 ZDE_MATNR ZT009_MATNR
			zt009.setMaktx(item.getMaktx()); // 物料描述 ZDE_MAKTX ZT009_MAKTX
			zt009.setBpmng(BigDecimalUtil.stringToBigDecimal(item.getBpmng()));// 本期到货数量 ZDE_BPMNG ZT009_BPMNG
			zt009.setMsehl(item.getMsehl());  // 度量单位文本 MSEHL ZT009_MSEHL
			zt009.setMsehs(item.getMsejs());  // 辅助计量单位 ZDE_Msejs ZT009_MSEHS
			zt009.setMenge(item.getMenge());  // 换算实收数量 ZDE_MENGE ZT009_MENGE
			zt009.setNetpr(BigDecimalUtil.stringToBigDecimal(item.getNetpr()));// 未税单价 NETPR ZT009_NETPR
			zt009.setPeinh(Integer.valueOf(item.getPeinh())); // 价格单位 PEINH ZT009_PEINH
			zt009.setDmbtr1(BigDecimalUtil.stringToBigDecimal(item.getDmbtr())); // 本期到货金额 (未税合计) DMBTR1 ZT009_DMBTR1
			zt009.setDmbtr(BigDecimalUtil.stringToBigDecimal(item.getKbetr()).add(BigDecimalUtil.stringToBigDecimal(item.getDmbtr())));// 本期到货金额（价税合计） DMBTR ZT009_DMBTR
			// zt009.setQmnum(null);   //通知单号
			// zt009.setMgeig(null);   //异常数量
			// zt009.setPcje(null);    //扣款金额
			// zt009.setGysfkzt(null); //缺陷反馈单状态
			zt009.setWerks(item.getWerks());  // 工厂
			zt009.setName1(item.getName1());  // 名称
			zt009.setLifnr(item.getLifnr());  // 供应商或债权人的帐号
			zt009.setName(item.getName());    // 名称
			zt009.setWaers(item.getWaers());  // 货币码
			zt009.setUnit(null);              // 计量单位
			zt009.setMblnr(item.getMblnr());  // number of material document
			zt009.setMjahr(item.getMjahr());  // 物料凭证年度
			zt009.setBuzei(item.getBuzel());  // 物料凭证中的项目
			zt009.setText1(null);            // 付款条件
			zt009.setVaedatum(item.getVaedatum());// UD过账日期 VAEDATUM ZT009_VAEDATUM
			zt009.setLsmng(BigDecimalUtil.stringToBigDecimal(item.getLsmng()));    // 交货注释中的数量 LSMNG ZT009_LSMNG
			zt009.setZsjdhje(BigDecimalUtil.stringToBigDecimal(item.getZsjdhje()));// 实际金额（价税合计） ZSJDHJE ZT009_ZSJDHJE
			zt009.setZcyl(BigDecimalUtil.stringToBigDecimal(item.getZcyl()));      // 差异率 ZCYL ZT009_ZCY L
			zt009.setMwskz(item.getMwskz()); // 销售/购买税代码 MWSKZ ZT009_MWSKZ
			zt009.setCpudt(item.getCpudt()); // 凭证录入日期 CPUDT ZT009_CPUDT
			zt009List.add(zt009);
		});
        //通过接口返回ZMMACC_INFO的 物料凭证编号MBLNR、 物料凭证项目BUZEI、 物料凭证年度MJAHR， 仅抓取异常单ZT003中
        //物料凭证编号MBLNR、 物料凭证项目 BUZEI 会计年度 GJAHR 与接口匹配， 且异常类别2 QMART为F2
        //且异常单的缺陷反馈单状态GYSFKZT不等于S 已删除的异常单号
		if (ValidateHelper.isNotEmpty(rfccatchaccinfResList)) {
			List<ZT003VO> zt003List =abnormalOrderMapper.queryAbnormalOrderByRfc(rfccatchaccinfResList);		
			logger.info("----zt003List--异常数据--="+zt003List.size());
			List<ZT009> zt009List_1 = new ArrayList<ZT009>();
			if (ValidateHelper.isNotEmpty(zt003List)) {
				zt009List_1=zt009List.stream().map(zt009->{
					ZT003VO zt003vo=zt003List.stream()
					         .filter(zt003->{
					        	 return (zt009.getMblnr().equals(zt003.getMblnr()) && zt009.getBuzei().equals(zt003.getBuzei()) && zt009.getMjahr().equals(zt003.getGjahr()));
					         }).findFirst().orElse(null);
					Optional.ofNullable(zt003vo).ifPresent(item->{
						zt009.setQmnum(item.getQmnum());     // 异常单号 ZT003_QMNUM ZT009_QMNUM
						zt009.setMgeig(BigDecimalUtil.stringToBigDecimal(item.getMgeig())); // 异常数量 ZT003_MGEIG ZT009_MGEIG
						zt009.setPcje(BigDecimalUtil.stringToBigDecimal(item.getPcje()));   // 扣款金额 ZT003_PCJE ZT009_PCJE
						zt009.setGysfkzt(item.getGysfkzt()); // 异常处理状态 ZT003_GYSFKZT ZT009_GYSFKZT
						zt009.setErdat(LocalDate.now()+"");  // 记录建立日期 SYSDATE ZT009_ERDAT
						zt009.setBdwcdat(item.getBdwcdat()); // 异常表单完成日期
					});
					return zt009;
				}).collect(Collectors.toList());
				// 若有异常单 则走 赋值后数据
				if (zt009List_1 !=null && zt009List_1.size() > 0) {
					zt009ListResult.addAll(zt009List_1);
				}
			}
		}
		
		// 防止 无异常单信息报空指针异常
		if (ValidateHelper.isEmpty(zt009ListResult)) {
			zt009ListResult.addAll(zt009List);
		}
		
		Map<String, String> map = new HashMap<>();
		map.put("qmart", "F4,F5");  // 异常类别2 QMART为F4,F5
		map.put("gysfkzt_ne", "S"); // GYSFKZT不等于S 已删除的异常单号
		map.put("werks", model.getWerks()); // 工厂
		map.put("lifnr", model.getLifnr()); // 供应商代码
		map.put("matnr_s", model.getMatnr_s()); // 物料（起）
		map.put("matnr_e", model.getMatnr_e()); // 物料（止）
		map.put("cycsdat", model.getCycsdat()); // 制程异常处理完成日期（起）
		map.put("cycedat", model.getCycedat()); // 制程异常处理完成日期（止）
		map.put("zsjwerks", model.getZsjwerks()); // 实际工厂
		List<ZT003VO> zt003voList = abnormalOrderMapper.queryAbnormalOrderByParam(map);
		if (ValidateHelper.isNotEmpty(zt003voList)) {
			zt003voList.stream().forEach(o -> {
				ZT034 zt034 = new ZT034();
				zt034.setDzbdh(null); // 对账表单号
				zt034.setDzbmq(null); // 制程异常项目
				zt034.setQmnum(o.getQmnum()); // 通知单号 ZT003_QMNUM ZT034_QMNUM
				zt034.setErdat(o.getErdat()); // 异常日期 SYSDATE ZT034_ERDAT
				zt034.setBdwcdat(o.getBdwcdat()); // 表单完成日期 ZT003_BDWCDAT ZT034_BDWCDAT
				zt034.setMgeig(BigDecimalUtil.stringToBigDecimal(o.getMgeig())); // 异常数量 ZT003_MGEIG ZT034_MGEIG
				zt034.setPcje(BigDecimalUtil.stringToBigDecimal(o.getPcje())); // 扣款金额 ZT003_PCJE ZT034_PCJE
				zt034List.add(zt034);
			});
		}
		
		// 对账单基础信息
		StatementInfoVo statementInfoVo = new StatementInfoVo();
		if (ValidateHelper.isNotEmpty(zt009ListResult)) {
			Map<String, BigDecimal[]> groupMap = new LinkedHashMap<String, BigDecimal[]>();
			List<ZT009> zt009DisList = new ArrayList<>();
			System.out.println("zt009ListResult="+zt009ListResult.toString());
			zt009ListResult.forEach(o -> {
				// 依据相同料号matnr、物料描述maktx、计量单位描述msehl、辅助计量单位msehs对对账单行项目中的本期到货金额（价税合计）dmbtr进行合计
				String key = o.getMatnr() + o.getMaktx() + o.getMsehl() + o.getMsehs();
				BigDecimal[] TotalArray = groupMap.get(key);
				if (TotalArray != null) {
					TotalArray[0] = o.getBpmng().add(TotalArray[0]); // 本期到货数量
					TotalArray[1] = BigDecimalUtil.stringToBigDecimal(o.getMenge()).add(TotalArray[1]); // 交货注释中的数量
					TotalArray[2] = o.getDmbtr1().add(TotalArray[2]); // 本期到货金额 (未税合计)
					TotalArray[3] = o.getDmbtr().add(TotalArray[3]); // 本期到货金额 (价税合计)
					groupMap.put(key, TotalArray);
				} else {
					zt009DisList.add(o);
					TotalArray = new BigDecimal[] { o.getBpmng(), BigDecimalUtil.stringToBigDecimal(o.getMenge()),
							o.getDmbtr1(), o.getDmbtr() };
				}
				groupMap.put(key, TotalArray);
			});
			
			// 
			BigDecimal dmbtrSum = zt009ListResult.stream().map(ZT009::getDmbtr)
					.reduce(BigDecimal.ZERO, BigDecimal::add);
			//
			BigDecimal dmbtrSum1 = zt009ListResult.stream().map(ZT009::getDmbtr1)
					.reduce(BigDecimal.ZERO, BigDecimal::add);

			//
			BigDecimal dmbtrS = zt009ListResult.stream().filter(filter -> {
				String gysfkzt = filter.getGysfkzt(); // 缺陷反馈单状态
				BigDecimal dmbtr = filter.getDmbtr(); // 本期到货金额（价税合计）
				if ((gysfkzt != null && !"Z".equals(gysfkzt)) && (dmbtr != null) && StringUtils.isNotBlank(filter.getQmnum())) {
					return true;
				}
				return false;
			}).map(ZT009::getDmbtr).reduce(BigDecimal.ZERO, BigDecimal::add);
			
			//
			BigDecimal pcjeSum=BigDecimal.ZERO;
			if (ValidateHelper.isNotEmpty(zt034List)) {
				pcjeSum = zt034List.stream().map(ZT034::getPcje)
						.reduce(BigDecimal.ZERO, BigDecimal::add);
			}

			//
			BigDecimal pcjeS = zt009ListResult.stream().filter(filter -> {
				String gysfkzt = filter.getGysfkzt(); // 缺陷反馈单状态
				if ((gysfkzt != null && "Z".equals(gysfkzt))) {
					return true;
				}
				return false;
			}).map(ZT009::getPcje).reduce(BigDecimal.ZERO, BigDecimal::add);
			
			//
			statementInfoVo.setTtlam(dmbtrSum); // 价税合计总价 TTLAM ZT008_TTLAM
			statementInfoVo.setTtlmi(dmbtrS);   // 异常处理未完成项目价税合计 TTLMI ZT008_TTLMI
			statementInfoVo.setTtleq(dmbtrSum.subtract(dmbtrS));// 本期可开票价税合计总价 TTLEQ ZT008_TTLEQ
			statementInfoVo.setTtlfi(pcjeSum.add(pcjeS));  // 本期扣款金额 TTLFI ZT008_TTLFI
			statementInfoVo.setTtlam2(dmbtrSum1);        // 未税合计总价 TTLAM2 ZT008_TTLAM2 CURR
			
			// 对帐表到货数量汇总
			if(ValidateHelper.isNotEmpty(zt009DisList)) {
				zt009DisList.stream().forEach(item -> {
					String key = item.getMatnr() + item.getMaktx() + item.getMsehl() + item.getMsehs();
					BigDecimal[] TotalArray = groupMap.get(key);
					ZT038 zt038 = new ZT038();
					zt038.setDzbdh(null); // 对账表单号
					zt038.setDzbms2(null);// 对账表项目 空 ZT038_DZBMS2
					zt038.setMatnr(item.getMatnr());// 物料号码 MATNR ZT038_MATNR
					zt038.setMaktx(item.getMaktx());// 物料描述 MAKTX ZT038_MAKTX
					zt038.setMsehl(item.getMsehl());// 计量单位描述 MSEHL ZT038_MSEHL
					zt038.setMsehs(item.getMsehs());// 辅助计量单位 MSEHS ZT038_MSEHS
					zt038.setBpmng(TotalArray[0]);// 本期到货数量
					zt038.setMenge(TotalArray[1]);// 交货注释中的数量
					zt038.setDmbtr1(TotalArray[2]);// 本期到货金额 (未税合计) DMBTR1 ZT038_DMBTR1
					zt038.setDmbtr(TotalArray[3]);// 本期到货金额 (价税合计) DMBTR ZT038_DMBTR
					zt038List.add(zt038);
				});
			}
			
		}
		
		statementInfoVo.setDzbdh(null);// 对账表单号 DZBDH ZT008_DZBDH
		statementInfoVo.setWerks(rfccatchaccinfResVO.getWerks());// 收货方 WERKS ZT008_WERKS
		statementInfoVo.setName1(rfccatchaccinfResVO.getName1());// 收货方名称 NAME1 ZT008_NAME1
		statementInfoVo.setLifnr(rfccatchaccinfResVO.getLifnr());// 供应商代码 LIFNR ZT008_LIFNR
		statementInfoVo.setName(rfccatchaccinfResVO.getName());// 供应商名称 NAME ZT008_NAME
		statementInfoVo.setBedat(model.getBedat());// 过账日期起自 页面输入Bedat
		statementInfoVo.setEndat(model.getEndat());// 过账日期终至 页面输入的endat
//		statementInfoVo.setConfs(null); // 对账表状态 CONFS ZT008_CONFS
//		statementInfoVo.setErnam(null); // 创建者
//		statementInfoVo.setErdat(null); // 创建日期
//		statementInfoVo.setSedat(null); // 发送日期
//		statementInfoVo.setCfdat(null); // 确认日期
//		statementInfoVo.setDedat(null); // 删除日期
		statementInfoVo.setWaers(rfccatchaccinfResVO.getWaers());// 单价币别 WAERS ZT008_WAERS
		statementInfoVo.setText1(rfccatchaccinfResVO.getText1());// 付款条件 TEXT1 ZT008_TEXT1
		statementInfoVo.setYcsdat(model.getYcsdat());  // 进料异常处理完成日期起自 创建对账单页面录入
		statementInfoVo.setYcedat(model.getYcedat());  // 进料异常处理完成日期终至 创建对账单页面录入
		statementInfoVo.setZzgbz(null);                // 扣款方式 ZZGBZ ZT008_ZZGBZ
		statementInfoVo.setCycsdat(model.getCycsdat());// 制程异常处理完成日期自 创建对账单页面录入
		statementInfoVo.setCycedat(model.getCycedat());// 制程异常处理完成日期至 创建对账单页面录入
		statementInfoVo.setUdbdate(model.getUdbdate());// UD过账日期 创建对账单页面录入
		statementInfoVo.setUdedate(model.getUdedate());// UD过账日期 创建对账单页面录入
		statementInfoVo.setZsjwerks(rfccatchaccinfResVO.getZsjwerks()); // 实际工厂 ZSJWERKS ZT008_ZSJWERKS
		statementInfoVo.setZsjwerksDesc(rfccatchaccinfResVO.getZsjwerksdesc()); // 实际工厂描述
		statementInfoVo.setBcdat(model.getCpudt_s());// 凭证录入日期起自 ZRFC_CATCH_ACC_INF-S_BWART ZT008_BCDAT
		statementInfoVo.setEcdat(model.getCpudt_e());// 凭证录入日期终至 ZRFC_CATCH_ACC_INF-S_BWART ZT008_ECDAT
		statementInfoVo.setZT009List(zt009ListResult);
		statementInfoVo.setZT034List(zt034List);
//		if (ValidateHelper.isNotEmpty(zt038List)) {
//			zt038List.stream().sorted(Comparator.comparing(ZT038::getMatnr).thenComparing(ZT038::getMaktx));
//		}
		statementInfoVo.setZT038List(zt038List);
		return CommonReturnType.create(statementInfoVo, null);
	}

	@Override
	@Transactional
	public CommonReturnType saveStatementInfo(StatementInfoVo statementInfoVo) {
		String statemenNO = "";
		if(zT008Dao.isExistsRecord()) {
			statemenNO = zT008Dao.selectNextId();// 对账单号
		}else {
			statemenNO = replenish(1,10);// 对账单号
		}
		
		statementInfoVo.setDzbdh(statemenNO);
		//
		ZT008 zt008Param = new ZT008();
		BeanUtils.copyProperties(statementInfoVo, zt008Param);
		zt008Param.setTtlam2(statementInfoVo.getTtlam2());

		zt008Param.setDzbdh(statemenNO);// 状态
		zt008Param.setConfs("A");// 状态

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date();
		String dateStr = sdf.format(date);

		zt008Param.setErdat(dateStr);// 系统日期-设置当前时间

		zt008Param.setErnam(statementInfoVo.getUserId());// 系统账号

//		try {
			zT008Dao.insertSelective(zt008Param);// 插入ZT008
			statementInfoVo.setConfs("A");
			List<ZT009> zT009List = statementInfoVo.getZT009List();
			for (int i=0; i<zT009List.size(); i++) {
				zT009List.get(i).setDzbdh(statemenNO);// 对账单号
				String dzbms = replenish(i+1,5);
				zT009List.get(i).setDzbms(dzbms);// 递增1
				zT009Dao.insert(zT009List.get(i));
			}

			List<ZT034> zT034List = statementInfoVo.getZT034List();
			for (int k=0; k< zT034List.size(); k++) {
				zT034List.get(k).setDzbdh(statemenNO);// 对账单号
				String dzbmq = Integer.toString((k+1)*10);
				zT034List.get(k).setDzbmq(dzbmq);// 递增10
				zT034Dao.insert(zT034List.get(k));
			}
			//throw new RuntimeException();

			List<ZT038> zT038List = statementInfoVo.getZT038List();
			for (int j=0; j < zT038List.size(); j++) {
				zT038List.get(j).setDzbdh(statemenNO);// 对账单号
				String dzbms2 = replenish(j+1,5);
				zT038List.get(j).setDzbms2(dzbms2);// 递增1
				zT038Dao.insert(zT038List.get(j));
			}
//		} catch (Exception e) {
//			e.printStackTrace();
//			logger.error("对账单信息保存失败" + e.getMessage());
//			return CommonReturnType.create(statementInfoVo, "保存失败", "E");
//		}
		return CommonReturnType.create(statementInfoVo, "保存成功");
	}

	@Override
	public CommonReturnType updateStatementInfo(@Valid UpdateStatementVo updateStatementVo) {
		ZT042 param = new ZT042();
		String statementCode = updateStatementVo.getZvoucherno();
		ZT008 zt008Param = zT008Dao.selectByPrimaryKey(statementCode);
		String zType = updateStatementVo.getZtype();// 操作类型
		String message = "对账单信息更新成功";// 成功
		BeanUtils.copyProperties(updateStatementVo, param);
		//SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateStr = zT008Dao.selcectNewData();

		String userId = updateStatementVo.getUserId();// 获取用户名称
		param.setZaccount(userId);//操作用户

		updateStatementVo.getZvoucherno();

		// Account account = accountDao.getOneByAccountId(userId);
		String emailStr = "";//userId + "@want-want.com";

		String lifnr = zt008Param.getLifnr();//供应商账号
		if (zType.equals("B")) {// 发送对账单
			if(zt008Param.getConfs().equals("A")) {
				zt008Param.setConfs("B");
				zt008Param.setSedat(dateStr);
				
				// 发送邮件给供应商
				//sendEmailSupplier("Wang_YouShen@want-want.com",userId,statementCode,sysUrl);
				//sendEmailCreater("Wang_YouShen@want-want.com",userId,statementCode,sysUrl);
				Map<String, String> params = new HashMap<String, String>();
				params.put("lifnr", zt008Param.getLifnr());
				List<Account> accountList = accountDao.getAccountByParams(params);
				for(Account account:accountList) {
					sendEmailSupplier(account.getEmail(),userId,statementCode,sysUrl);
					//sendEmailSupplier("Wang_YouShen@want-want.com",lifnr.substring(2),statementCode,sysUrl);
				}
			}else {
				return CommonReturnType.create(updateStatementVo, "对账单状态不是初始A状态或已被处理", "S");
			}
		} else if (zType.equals("C")) {// 确认对账单
			if(zt008Param.getConfs().equals("B")) {
				zt008Param.setConfs("C");
				zt008Param.setCfdat(dateStr);
				emailStr = zt008Param.getErnam()+"@want-want.com";//创建人邮箱
				param.setZtype("对账表确认");
				param.setZresult("成功");
				zT042Dao.insertSelective(param);
				param.setZtype("C");
				// 发送邮件给创建者
				sendEmailCreater(emailStr,lifnr.substring(2),statementCode,sysUrl);
				//sendEmailCreater("Wang_YouShen@want-want.com",lifnr.substring(2),statementCode,sysUrl);
			}else {
				return CommonReturnType.create(updateStatementVo, "对账单状态不是发送B状态或已被处理", "S");
			}
		} else if (zType.equals("D")) {// 删除对账单
			if(updateStatementVo.getDeleteType().equals("1")) {
				if(zt008Param.getConfs().equals("C")) {
					zt008Param.setConfs("D");
					zt008Param.setDedat(dateStr);
				}else {
					return CommonReturnType.create(updateStatementVo, "对账单状态不是已确认C状态或已被处理", "S");
				}
			}else if(updateStatementVo.getDeleteType().equals("2")){
				if(zt008Param.getConfs().equals("A") || zt008Param.getConfs().equals("B")) {
					zt008Param.setConfs("D");
					zt008Param.setDedat(dateStr);
				}
			}
			
		}
		try {
			zT008Dao.updateByPrimaryKeySelective(zt008Param);
			
			// zT042Dao.updateByPrimaryKeySelective(param);

		} catch (RuntimeException e) {
			param = null;
			e.printStackTrace();
			logger.error("对账单信息更新失败" + e.getMessage());
			return CommonReturnType.create(updateStatementVo, "对账单信息更新失败", "E");
		}
		return CommonReturnType.create(param, message);
	}

	@SuppressWarnings("finally")
	public Map<String, String> validation(ValidationVo vo) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("状态", "S");
		map.put("信息描述", "验证成功");
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		String ZSMYW = "";
		try {
			DTZRFCSRM017REQ req = new DTZRFCSRM017REQ();
			req.setIWERKS(vo.getWerks());

			DTZRFCSRM017RES res = sio17service.getHTTPPort().siOZRFCSRM017(req);
			List<DTZRFCSRM017RES.TTAB.Item> ttab = res.getTTAB().getItem();
			if(ttab != null && ttab.size()>0) {
				ZSMYW = res.getTTAB().getItem().get(0).getZSMYW();
			}

			if ("X".equals(ZSMYW) && "".equals(vo.getZsjwerks())) {
				map.put("状态", "E");
				map.put("信息描述", "必输条件不能为空！");
				return map;
			}
			if (vo.getBcdat().compareTo(dateFormat.format(date)) > 0) {
				map.put("状态", "E");
				map.put("信息描述", "凭证录入日期起不能大于当前日期！");
				return map;
			}
			if (vo.getEcdat().compareTo(dateFormat.format(date)) > 0) {
				map.put("状态", "E");
				map.put("信息描述", "凭证录入日期至不能大于当前日期！");
				return map;
			}
			if (vo.getCycsdat().compareTo(dateFormat.format(date)) > 0) {
				map.put("状态", "E");
				map.put("信息描述", "制程异常处理完成日期起不能大于当前日期！");
				return map;
			}
			if (vo.getCycedat().compareTo(dateFormat.format(date)) > 0) {
				map.put("状态", "E");
				map.put("信息描述", "制程异常处理完成日期至不能大于当前日期！");
				return map;
			}
			if (vo.getBedat().compareTo(dateFormat.format(date)) > 0) {
				map.put("状态", "E");
				map.put("信息描述", "过账日期起不能大于当前日期！");
				return map;
			}
			if (vo.getEndat().compareTo(dateFormat.format(date)) > 0) {
				map.put("状态", "E");
				map.put("信息描述", "过账日期至不能大于当前日期！");
				return map;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			return map;
		}
	}
	/**
	 * 
	 * @Title: replenish
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param @param number 数字
	 * @param @param digit 位数
	 * @param @return 参数
	 * @return String 返回类型
	 * @throws
	 */
	public String replenish(int number, int digit) {
		StringBuffer sb = new StringBuffer(); 
		int b = Integer.toString(number).length();//数字的位数
		int l = digit - b;//补0的位数
		for(int i = 0; i< l;i++) {
			sb.append("0");
		}
		sb.append(number+"");
		return sb.toString();
	}
	

	@Async
	private void sendEmailSupplier(String addressee, String userId, String statementCode, String sysUrl) {// 发送邮件给供应商
		String title = "【" + userId + "】的对账单<" + statementCode + ">已经发送，请确认！";
		String content = "请及时登录系统确认对账单<" + statementCode + ">\n" + "\n" + "a)旺旺供应商管理系统登录链接：" + sysUrl + "\n"
				+ "b)此为提醒邮件，请不要直接回复此邮件，谢谢配合";
		//new Thread(() ->mailServcie.sendSimpleMail(addressee, title, content)).start();
		//SendEmailUtils.sendMail(mailServcie, addressee, title, content);
		try {
			mailServcie.sendSimpleMail(addressee, title, content);
		}catch (Exception e) {
			e.getCause();
		}
	}

	@Async
	private void sendEmailCreater(String addressee, String userId, String statementCode, String sysUrl) {// 发送邮件给供应商
		String title = "【" + userId + "】的对账单<" + statementCode + ">已经确认，请查看！";
		String content = "请及时登录系统确认对账单<" + statementCode + ">\n" + "\n" + "a)旺旺供应商管理系统登录链接：" + sysUrl + "\n"
				+ "b)此为提醒邮件，请不要直接回复此邮件，谢谢配合";
		//new Thread(() ->mailServcie.sendSimpleMail(addressee, title, content)).start();
		//SendEmailUtils.sendMail(mailServcie, addressee, title, content);
		try {
			mailServcie.sendSimpleMail(addressee, title, content);
		}catch (Exception e) {
			e.getCause();
		}
		
	}

	@Override
	public Pagination<StatementVo> selectStatementBycondPage(Long pageNumber, Long pageSize,
			StatementDto statementDto) {
		Pagination<StatementVo> pagination = new Pagination<>();
		
		pagination.setPageNum(pageNumber);
		pagination.setPageSize(pageSize);

		// 分页条件
		pagination.setBeginRow((pageNumber - 1) * pageSize);
		pagination.setEndRow(pageNumber * pageSize + 1);

        pagination.setParameter(statementDto);
        
        //供应商编号是否为空的判断
        if(statementDto.getIsSupplier() == 1) {
			if(statementDto.getSupplierCodes().equals("")) {
				return pagination;
			}
		}
        // 查询总条数
        pagination.setTotalCount(zT008Dao.selcectStatementCount(pagination), (long) 5);
        List<StatementVo> resultList = zT008Dao.selcectStatementListByPage(pagination);
        pagination.setResultList(resultList);
		return pagination;
	}
	
}
