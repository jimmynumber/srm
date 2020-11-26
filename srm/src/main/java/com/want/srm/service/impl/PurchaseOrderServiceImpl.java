package com.want.srm.service.impl;

import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletResponse;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.Holder;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFHeader;
import org.apache.poi.hssf.usermodel.HSSFPalette;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import com.want.srm.dao.AccountDao;
import com.want.srm.dao.PurchaseOrderMapper;
import com.want.srm.entity.Account;
import com.want.srm.service.IPurchaseOrderService;
import com.want.srm.utils.BigDecimalUtil;
import com.want.srm.utils.ValidateHelper;
import com.want.srm.vo.CommonReturnType;
import com.want.srm.vo.EkpoVO;
import com.want.srm.vo.Pagination;
import com.want.srm.webservice.zrfcqqt003.ITEBELNType;
import com.want.srm.webservice.zrfcqqt003.ITSYDATType;
import com.want.srm.webservice.zrfcqqt003.ZRFCQQT003;
import com.want.srm.webservice.zrfcqqt003.ZRFCQQT003_Service;
import com.want.srm.webservice.zrfcqqt005.ItemType;
import com.want.srm.webservice.zrfcqqt005.ZRFCQQT005;
import com.want.srm.webservice.zrfcqqt005.ZRFCQQT005_Service;
import com.want.srm.webservice.zrfcqqt006.OTHEADType;
import com.want.srm.webservice.zrfcqqt006.OTITEMType;
import com.want.srm.webservice.zrfcqqt006.ZRFCQQT006;
import com.want.srm.webservice.zrfcqqt006.ZRFCQQT006_Service;

@Service
public class PurchaseOrderServiceImpl implements IPurchaseOrderService {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	 
	@Autowired
	private PurchaseOrderMapper mapper;

	@Value("${zrfcqqt.username}")
	private String username;

	@Value("${zrfcqqt.password}")
	private String password;

	@Value("${wangwang.loginUrl}")
	private String loginUrl;
	
	@Value("${export.execl}")
	private String excelName;
	
	@Value("${export.excel.backgroundcolor}")
	private String bgColor;
	
    @Autowired
    private AccountDao accountDao;
  
    @Autowired
    private MailServiceImpl mailSevcie;
  
	@Autowired
	private ZRFCQQT003_Service zrfcqqt003_service;
	
	@Autowired
	private ZRFCQQT005_Service zrfcqqt005_service;
	
	@Autowired
	private ZRFCQQT006_Service zrfcqqt006_service;
	
	@Autowired
	private HttpServletResponse response;

	@Override
	public CommonReturnType queryPurchaseOrderByCondition(Long pageNum, Long pageSize, Map<String, String> map) {
		Pagination<EkpoVO> pagination = new Pagination<>();

		pagination.setPageNum(pageNum);
		pagination.setPageSize(pageSize);

		// 分页条件
		pagination.setBeginRow((pageNum - 1) * pageSize);
		pagination.setEndRow(pageNum * pageSize + 1);

		pagination.setParameter(map);
		
		//供应商编号是否为空的判断
        if(Integer.valueOf(map.get("isSupplier"))  == 1) {
			if(map.get("lifnr").equals("")) {
				return CommonReturnType.create(pagination, null);
			}
		}

		pagination.setTotalCount(mapper.queryPurchaseOrderCount(pagination), (long) 5);
		List<EkpoVO> resultList = mapper.queryPurchaseOrder(pagination);
		pagination.setResultList(resultList);

		return CommonReturnType.create(pagination, null);
	}

	@Override
	@Transactional
	public CommonReturnType insertPurchaseBatch(List<EkpoVO> list) {
		try {
			Long num = mapper.insertPurchaseBatch(list);
			return CommonReturnType.create(null, "成功操作" + num + "笔数据");
		} catch (Exception e) {
			logger.info("---insertPurchaseBatch---e:" + e);
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			return CommonReturnType.create(e.getCause(), "操作失败", null);
		}
	}

	@Override
	@Transactional
	public CommonReturnType modifyPurchaseBatch(EkpoVO ekpoVO) {
		try {
			Long num = mapper.modifyPurchaseBatch(ekpoVO);
			// 回写到SAp
			this.confirmzrfcqqt005(ekpoVO);
			return CommonReturnType.create(null, "成功操作" + num + "笔数据");
		} catch (Exception e) {
			logger.info("---modifyPurchaseBatch---e:" + e);
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			return CommonReturnType.create(e.getCause(), "操作失败", null);
		}
	}

	private void confirmzrfcqqt005(EkpoVO ekpoVO) {
		
		Pagination<EkpoVO> pagination = new Pagination<>();
		Map<String, String> map=new HashMap<String, String>();
		map.put("ebeln_s", ekpoVO.getEbeln());
		map.put("ebelp", ekpoVO.getEbelp());
		map.put("isPage", "0");
		pagination.setParameter(map);
		List<EkpoVO> ekpovoList = mapper.queryPurchaseOrder(pagination);
		logger.info("ekpovoList.size="+ekpovoList.size());
		 
		// 抛回SAP 
		ZRFCQQT005 zrfcqqt005 =zrfcqqt005_service.getZRFCQQT005SOAP();
		BindingProvider bp = (BindingProvider) zrfcqqt005;
		bp.getRequestContext().put(BindingProvider.USERNAME_PROPERTY, username);
		bp.getRequestContext().put(BindingProvider.PASSWORD_PROPERTY, password);
		
		List<ItemType> ItemTypeList=ekpovoList.stream().map(it->{
			ItemType ItemType=new ItemType();
			ItemType.setEBELP(it.getEbelp());
			ItemType.setEINDT(this.stringToGregorian(it.getEeind()));
			ItemType.setMENGE(BigDecimalUtil.stringToBigDecimal(it.getMenge()));
			return ItemType;
		}).collect(Collectors.toList());
		zrfcqqt005.zrfcqqt005(ekpoVO.getEbeln(), new Holder<List<ItemType>>(ItemTypeList));
		
	}

	@Override
	@Transactional
	public CommonReturnType getPurchaseByZrfcqqt003(Map<String, String> map) {
		logger.info("---getPurchaseByZrfcqqt003---"+map);
		if (map == null || StringUtils.isBlank(map.get("bedat_s"))) {
			return CommonReturnType.create(null, "参数不可为空", null);
		}
		String ebeln_s=map.get("ebeln_s");
		String ebeln_e=map.get("ebeln_e");
		String bedat_s=map.get("bedat_s");
		String bedat_e=map.get("bedat_e");
		ITSYDATType itSYDAT = new ITSYDATType();
		itSYDAT.setSIGN("I");
		itSYDAT.setOPTION("BT");
		itSYDAT.setLOW(this.stringToGregorian(bedat_s));
		itSYDAT.setHIGH(this.stringToGregorian(bedat_e));
		
		List<ITEBELNType> itEBELN=new ArrayList<ITEBELNType>();
		if (StringUtils.isNotBlank(ebeln_s) && StringUtils.isNotBlank(ebeln_e)) {
			ITEBELNType  itebelntype =new ITEBELNType();
			itebelntype.setSIGN("I");
			itebelntype.setOPTION("BT");
			itebelntype.setLOW(ebeln_s);
			itebelntype.setHIGH(ebeln_e);
			itEBELN.add(itebelntype);
		}
		if (StringUtils.isNotBlank(ebeln_s) && StringUtils.isBlank(ebeln_e)) {
			String[] array=ebeln_s.split(",");
            if (ValidateHelper.isNotEmpty(array)) {
                for (String item : array) {
                	ITEBELNType  itebelntype =new ITEBELNType();
                	itebelntype.setSIGN("I");
                	itebelntype.setOPTION("EQ");
                	itebelntype.setLOW(item);
                	itEBELN.add(itebelntype);
                }
            }
		}
			
		ZRFCQQT003 zrfcqqt003 = zrfcqqt003_service.getZRFCQQT003SOAP();
		BindingProvider bp = (BindingProvider) zrfcqqt003;
		bp.getRequestContext().put(BindingProvider.USERNAME_PROPERTY, username);
		bp.getRequestContext().put(BindingProvider.PASSWORD_PROPERTY, password);
		List<com.want.srm.webservice.zrfcqqt003.ItemType> ItemType = zrfcqqt003.zrcqqt003(itEBELN, Arrays.asList(itSYDAT));
		logger.info(ItemType.size()+"");
		List<EkpoVO> ekpolist=ItemType.stream().filter(it->StringUtils.isNotBlank(it.getEBELN())).map(it ->{ 
			EkpoVO ekpoVO=new EkpoVO();
			ekpoVO.setEbeln(it.getEBELN());
			ekpoVO.setEbelp(it.getEBELP());
			ekpoVO.setLifnr(it.getLIFNR());
			ekpoVO.setBedat(it.getBEDAT()+"");
			ekpoVO.setEeind(it.getEEIND()+"");
			ekpoVO.setMatnr(it.getMATNR());
			ekpoVO.setTxz01(it.getTXZ01());
			ekpoVO.setMenge((it.getMENGE())+"");
			ekpoVO.setMeins(it.getMEINS());
			ekpoVO.setNetpr(it.getNETPR()+"");
			ekpoVO.setWkurs(it.getWKURS());
			ekpoVO.setPeinh(it.getPEINH()+"");
			ekpoVO.setBprme(it.getBPRME());
			ekpoVO.setValue(it.getVALUE()+"");
			ekpoVO.setZterm(it.getZTERM());
			ekpoVO.setMwskz(it.getMWSKZ());
			ekpoVO.setKbetr(it.getKBETR()+"");
			ekpoVO.setWerks(it.getWERKS());
			ekpoVO.setName(it.getNAME());
			ekpoVO.setWerks1(it.getWERKS1());
			ekpoVO.setName1(it.getNAME1());
			ekpoVO.setLoekz(it.getLOEKZ());
			ekpoVO.setDatvr(it.getDATVR()+"");
			ekpoVO.setUhrvr(it.getUHRVR()+"");
			if ("L".equals(it.getLOEKZ())) {
				ekpoVO.setConfirmStatus("C");
			}else {
				ekpoVO.setConfirmStatus("A");
			}
			return ekpoVO;
		}).collect(Collectors.toList());
		//
		if (ekpolist == null || ekpolist.size() <= 0) {
			return CommonReturnType.create(null, "采购订单操作成功:"+0);
		}
		
		// 查询库中 存在 采购订单编号EBELN+采购订单行项目EBELP 且未确认 A 或者确认日期晚于 处理时间数据
		List<EkpoVO> ekpoExistslist=mapper.queryExistsPurchaseOrder(ekpolist);
		ekpoExistslist.stream().forEach(it->{
			logger.info("ekpoExistslist----"+it);
		});
		
		// 排除 不需要写入db数据
		List<EkpoVO> ekpoSavetlist=ekpolist.stream().filter(it->{
			return StringUtils.isNotBlank(it.getEbeln()) && !ekpoExistslist.stream().anyMatch( oit->oit.getEbeln().equals(it.getEbeln()) && oit.getEbelp().equals(it.getEbelp()) );
		}).collect(Collectors.toList());
		
		// 将数据写入到DB
		Long num=0L;
		if (ekpoSavetlist !=null && ekpoSavetlist.size()>0 ) {
			num=mapper.insertPurchaseBatch(ekpoSavetlist);
			// 给经销商 发送确认提示邮件
			try {
				new Thread(() -> {
					// 排除掉已删除状态，余下的都要发送邮件通知
					ekpoSavetlist.stream()
					.filter(it-> !"L".equals(it.getLoekz()))
					.map(it->it.getLifnr()+","+it.getEbeln())
					.distinct()
					.collect(Collectors.toList())
					.forEach(it->{
						 String lifnr=it.split(",")[0];
						 String ebeln=it.split(",")[1];
						 String subject = String.format("【%s】的采购订单<%s>尚未确认，请确认！", lifnr.substring(2), ebeln);
						 String content = "<p style='text-indent:2em'>请及时登录系统确认采购订单<%s></p>\r\n"
						 + "<p style='text-indent:2em'>a)旺旺供应商管理系统登录链接：<a href='%s'> %s</a></p>\r\n"
						 + "<p style='text-indent:2em'>b)此为提醒邮件，请不要直接回复此邮件，谢谢配合</p>";
				          content = String.format(content, ebeln, loginUrl, loginUrl);
				          Map<String, String> paramMap = new HashMap<>();
				          paramMap.put("lifnr", lifnr);
						  List<Account> Account = accountDao.getAccountByParams(paramMap);
						  if (ValidateHelper.isNotEmpty(Account)) {
//								 String to = "00320558" + "@want-want.com";
//								  mailSevcie.sendHtmlMail(to, subject, content);
								 // 批量的发送邮件				
								 String contentS=content;
								 Optional.ofNullable(Account).orElse(new ArrayList<>()).forEach(its->{
								 mailSevcie.sendHtmlMail(its.getEmail(),subject,contentS); });
								 
							}
					});
				}).start();
			} catch (Exception e) {
				logger.error("---PurchaseOrderServiceImpl--getPurchaseByZrfcqqt003--:"+e);
			}
		}

		return CommonReturnType.create(null, "采购订单操作成功:"+num);
	}

	/**
	 * 字符型日期 转 XMLGregorianCalendar
	 */
	public  XMLGregorianCalendar stringToGregorian(String dateStr) {
		if (dateStr == null || dateStr.trim().length() <= 0) {
			return null;
		}
		XMLGregorianCalendar gc = null;
		try {
			Date date = new SimpleDateFormat("yyyy-MM-dd").parse(dateStr);
			GregorianCalendar cal = new GregorianCalendar();
			cal.setTime(date);
			gc = DatatypeFactory.newInstance().newXMLGregorianCalendar(cal);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return gc;
	}
	
	/**
	 * XMLGregorianCalendar转字符型日期
	 */
	public  String gregoriantosToStr(XMLGregorianCalendar gr) {
		try {
			Calendar calendar = gr.toGregorianCalendar();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			sdf.setTimeZone(calendar.getTimeZone());
			return sdf.format(calendar.getTime());
		} catch (Exception e) {
			return "";
		}
	}
	
	@Override
	@Transactional
	public Map<String, Object> getPurchaseByZrfcqqt006(String EBELN) {
		Map<String, Object> model = new HashMap<>();
		List<OTHEADType> otHEAD = new ArrayList<OTHEADType>();
		List<OTITEMType> otITEM = new ArrayList<OTITEMType>();
		Holder<List<OTHEADType>> otHEAD1 = new Holder<List<OTHEADType>>(otHEAD);
		Holder<List<OTITEMType>> otITEM1 = new Holder<List<OTITEMType>>(otITEM);
		
		ZRFCQQT006 zrfcqqt006 = zrfcqqt006_service.getZRFCQQT006SOAP();
		BindingProvider bp = (BindingProvider) zrfcqqt006;
		bp.getRequestContext().put(BindingProvider.USERNAME_PROPERTY, username);
		bp.getRequestContext().put(BindingProvider.PASSWORD_PROPERTY, password);
		
		zrfcqqt006.zrfcqqt006(EBELN,otHEAD1,otITEM1);
		
		model.put("otHEAD", otHEAD1.value);
		model.put("otITEM", otITEM1.value);
		model.put("EBELN", EBELN);
		return model;
	}

	private final String reg = "-";
	@Override
	public void exportPurchaseOrderExcelByCondition(Map<String, String> map) {
		Pagination<EkpoVO> pagination = new Pagination<>();

		pagination.setParameter(map);

		List<EkpoVO> resultList = mapper.queryPurchaseOrder(pagination);
		pagination.setResultList(resultList);
		
		String [] tableHeader={"序号","采购订单状态","采购订单编号","供应商全称","行项目","凭证日期","要求到货日期","物料描述","订单数量","订单单位","到货工厂编号","到货工厂描述","实际工厂编号","实际工厂描述"};
		short [] colwidth = {37,92,95,177,50,90,92,111,88,63,92,177,92,148};
		
        short cellNumber=(short)tableHeader.length;//表的列数 
        HSSFWorkbook workbook = new HSSFWorkbook(); //创建一个Excel 
        //XSSFWorkbook workbook = new XSSFWorkbook();
        HSSFCellStyle style = workbook.createCellStyle(); //设置表头的类型 
        style.setAlignment(HorizontalAlignment.LEFT);
        
        HSSFCellStyle style1 = workbook.createCellStyle(); //设置数据类型 
        HSSFPalette palette = workbook.getCustomPalette();
        //自定义颜色（背景色）
        //String Color = bgColor;
        String r = bgColor.substring(1, 3);
        String g = bgColor.substring(3, 5);
        String b = bgColor.substring(5, 7);
        int r2 = Integer.parseInt(r, 16);
        int g2 = Integer.parseInt(g, 16);
        int b2 = Integer.parseInt(b, 16);
        HSSFColor hssfColor = palette.findSimilarColor(r2, g2, b2);

        //设置单元格背景颜色
        style1.setFillPattern(FillPatternType.FINE_DOTS);
        style1.setFillForegroundColor(hssfColor.getIndex());
        style1.setFillBackgroundColor(hssfColor.getIndex());
        //设置边框宽度和颜色
        style1.setBorderBottom(BorderStyle.THIN);
        style1.setBottomBorderColor(IndexedColors.BLACK.getIndex());
        style1.setBorderLeft(BorderStyle.THIN);
        style1.setLeftBorderColor(IndexedColors.BLACK.getIndex());
        style1.setBorderRight(BorderStyle.THIN);
        style1.setRightBorderColor(IndexedColors.BLACK.getIndex());
        style1.setBorderTop(BorderStyle.THIN);
        style1.setTopBorderColor(IndexedColors.BLACK.getIndex());
        //style1.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);    
        //style1.setFillForegroundColor(IndexedColors.BLUE_GREY.getIndex());// 设置背景色
        //设置居中
        style1.setAlignment(HorizontalAlignment.CENTER); 
        
        HSSFCellStyle numberStyle = workbook.createCellStyle(); //设置数字数据样式 
        numberStyle.setAlignment(HorizontalAlignment.RIGHT);
        
        HSSFCellStyle wordStyle = workbook.createCellStyle(); //设置内容数据样式 
        wordStyle.setAlignment(HorizontalAlignment.LEFT);
        
        HSSFFont font = workbook.createFont(); //设置字体 
        HSSFSheet sheet = workbook.createSheet("sheet1"); //创建一个sheet 
        HSSFHeader header = sheet.getHeader();//设置sheet的头 
        try {              
            //根据是否取出数据，设置header信息 
            if(resultList.size() < 1 ){ 
                header.setCenter("查无资料"); 
            }else{ 
                header.setCenter("采购订单表"); 
                HSSFRow row = sheet.createRow(0); 
                row.setHeight((short)400);
                //表头
                for(int k = 0;k < cellNumber;k++){
                    HSSFCell cell = row.createCell((short) k);//创建第0行第k列 
                    cell.setCellValue(tableHeader[k]);//设置第0行第k列的值 
                    logger.info("---colwidth:---"+colwidth[k]);
                    sheet.setColumnWidth((short)k,43*colwidth[k]);//设置列的宽度 
                     
                    //font.setFontHeight((short)350); //设置单元字体高度 
                    font.setFontHeightInPoints((short)12);
                    font.setFontName("Calibri");
                    font.setColor(IndexedColors.WHITE.getIndex()); // 设置单元格字体的颜色
                    //font.setColor(Font.SS_NONE);
                    //font.setBoldweight(Font.BOLDWEIGHT_BOLD);
                    font.setBold(true);
                    //font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);//粗体显示
                    //style1.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);  //填充单元格
                    
                    style1.setFont(font);//设置字体风格
                    
                    cell.setCellStyle(style1); 
                } 
                HSSFFont contextFont = workbook.createFont(); //设置字体
                contextFont.setFontHeightInPoints((short)12);
                contextFont.setFontName("Calibri");
                //contextFont.setBoldweight(Font.BOLDWEIGHT_NORMAL);
                contextFont.setBold(false);
                // 给Excel填充数据                         
                for(int i = 0 ;i < resultList.size() ;i++){    
                    //获取InternationalStudent对象
                	EkpoVO ekpoVO = (EkpoVO)resultList.get(i); 
                    row = sheet.createRow((short) (i + 1));//创建第i+1行 
                    row.setHeight((short)400);//设置行高 
                    
                    if(ekpoVO.getConfirmStatus() != null && ekpoVO.getConfirmStatusDesc() != null){ //序号
                    	HSSFCell cell = row.createCell((short) 0);//创建第i+1行第0列 
                        cell.setCellValue(i+1);//序号
                        numberStyle.setFont(contextFont);
                        cell.setCellStyle(numberStyle);//设置风格 
                    } 
                    
                    if(ekpoVO.getConfirmStatus() != null && ekpoVO.getConfirmStatusDesc() != null){ //采购订单状态
                    	HSSFCell cell = row.createCell((short) 1);//创建第i+1行第0列 
                        cell.setCellValue(ekpoVO.getConfirmStatus() +reg+ekpoVO.getConfirmStatusDesc());//采购订单状态
                        style.setFont(contextFont);
                        cell.setCellStyle(style);//设置风格 
                    } 
                    if(ekpoVO.getEbeln() != null){ //采购订单编号
                    	HSSFCell cell = row.createCell((short) 2); //创建第i+1行第1列 
                        cell.setCellValue(ekpoVO.getEbeln());//设置第i+1行第1列的值 
                        cell.setCellStyle(numberStyle); //设置风格 
                    } 
                    if(ekpoVO.getLifnrName() != null){ //供应商全称
                    	HSSFCell cell = row.createCell((short) 3); 
                        cell.setCellValue(ekpoVO.getLifnrName()); 
                        cell.setCellStyle(style); 
                    } 
                    if(ekpoVO.getEbelp()!= null){ //行项目
                    	HSSFCell cell = row.createCell((short) 4); 
                        cell.setCellValue(ekpoVO.getEbelp().toString().substring(3,5)); 
                        cell.setCellStyle(numberStyle); 
                    }
                    if(ekpoVO.getBedat()!= null){ //凭证日期
                    	HSSFCell cell = row.createCell((short) 5); 
                        cell.setCellValue(ekpoVO.getBedat()); 
                        cell.setCellStyle(numberStyle); 
                    }
                    if(ekpoVO.getEeind() != null){ //要求到货日期
                    	HSSFCell cell = row.createCell((short) 6); 
                        cell.setCellValue(ekpoVO.getEeind()); 
                        cell.setCellStyle(numberStyle); 
                    }
                    if(ekpoVO.getTxz01() != null){ //物料描述
                    	HSSFCell cell = row.createCell((short) 7); 
                        cell.setCellValue(ekpoVO.getTxz01()); 
                        cell.setCellStyle(style); 
                    } 
                    if(ekpoVO.getMenge() != null){ //订单数量
                    	HSSFCell cell = row.createCell((short) 8); 
                        cell.setCellValue(ekpoVO.getMenge()); 
                        cell.setCellStyle(numberStyle); 
                    } 
                    if(ekpoVO.getMeins() != null){ //订单单位
                    	HSSFCell cell = row.createCell((short) 9); 
                        cell.setCellValue(ekpoVO.getMeins()); 
                        cell.setCellStyle(style); 
                    } 
                    if(ekpoVO.getWerks() != null){ //到货工厂编号
                    	HSSFCell cell = row.createCell((short) 10); 
                        cell.setCellValue(ekpoVO.getWerks()); 
                        cell.setCellStyle(style); 
                    } 
                    if(ekpoVO.getName() != null){ //到货工厂描述
                    	HSSFCell cell = row.createCell((short) 11); 
                        cell.setCellValue(ekpoVO.getName()); 
                        cell.setCellStyle(style); 
                    } 
                    if(ekpoVO.getWerks1() != null){ //实际工厂编号
                    	HSSFCell cell = row.createCell((short) 12); 
                        cell.setCellValue(ekpoVO.getWerks1()); 
                        cell.setCellStyle(style); 
                    } 
                    if(ekpoVO.getName1() != null){ //实际工厂描述
                    	HSSFCell cell = row.createCell((short) 13); 
                        cell.setCellValue(ekpoVO.getName1()); 
                        cell.setCellStyle(style); 
                    } 
                } 
            } 
        } catch (Exception e) { 
            e.printStackTrace(); 
        } 
        outputSetting(excelName,workbook);
		

	}
	
	public void outputSetting(String fileName,HSSFWorkbook workbook) {
        OutputStream out = null;//创建一个输出流对象 
        try { 
            out = response.getOutputStream();// 得到输出流
            response.setHeader("Content-disposition","attachment; filename="+new String(fileName.getBytes(),"ISO-8859-1"));//filename是下载的xls的名 
            response.setContentType("application/vnd.ms-excel;charset=UTF-8");//设置类型 
            response.setHeader("Pragma","No-cache");//设置头 
            response.setHeader("Cache-Control","no-cache");//设置头 
            response.setDateHeader("Expires", 0);//设置日期头 
            workbook.write(out); 
            out.flush(); 
            workbook.write(out); 
        } catch (IOException e) { 
            e.printStackTrace(); 
        }finally{ 
            try{ 
                if(out!=null){ 
                    out.close(); 
                } 
            }catch(IOException e){ 
                e.printStackTrace(); 
            } 
        } 
    }
	
}
