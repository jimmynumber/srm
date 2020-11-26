package com.want.srm.service.impl;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.want.srm.dao.AbnormalOrderMapper;
import com.want.srm.dao.AccountDao;
import com.want.srm.entity.Account;
import com.want.srm.po.AbnormalOrderModifyPO;
import com.want.srm.po.AbnormalOrderPO;
import com.want.srm.po.FileInofPO;
import com.want.srm.service.IAbnormalOrderService;
import com.want.srm.utils.AbnormalorderPdf;
import com.want.srm.utils.ValidateHelper;
import com.want.srm.vo.CommonReturnType;
import com.want.srm.vo.Pagination;
import com.want.srm.vo.ZT001VO;
import com.want.srm.vo.ZT001VO.ZT001;
import com.want.srm.vo.ZT003VO;
import com.want.srm.webservice.zrfc_get_notification_longtext.DTZRFCGETNOTIFICATIONLONGTEXT;
import com.want.srm.webservice.zrfc_get_notification_longtext.DTZRFCGETNOTIFICATIONLONGTEXTRES;
import com.want.srm.webservice.zrfc_get_notification_longtext.SIOZRFCGETNOTIFICATIONLONGTEXTService;
import com.want.srm.webservice.zrfcsrm016.DTZRFCSRM016REQ;
import com.want.srm.webservice.zrfcsrm016.DTZRFCSRM016RES;
import com.want.srm.webservice.zrfcsrm016.SIOZRFCSRM016Service;

@Service
public class AbnormalOrderServiceImpl implements IAbnormalOrderService {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private AbnormalOrderMapper mapper;

	@Autowired
	private MailServiceImpl mailSevcie;

	@Value("${wangwang.loginUrl}")
	private String loginUrl;

	@Value("${RealUrl}")
	private String RealUrl;

	@Autowired
	private AccountDao accountDao;

	@Autowired
	private SIOZRFCGETNOTIFICATIONLONGTEXTService siotextservice;

	@Autowired
	private SIOZRFCSRM016Service sio16service;

	@Override
	public Pagination<Map<String, Object>> queryAbnormalOrderByCondition(Long pageNumber, Long pageSize, AbnormalOrderPO model) {
		Pagination<Map<String, Object>> pagination = new Pagination<>();

		pagination.setPageNum(pageNumber);
		pagination.setPageSize(pageSize);

		// 分页条件
		pagination.setBeginRow((pageNumber - 1) * pageSize);
		pagination.setEndRow(pageNumber * pageSize + 1);

        pagination.setParameter(model);
        
        //供应商编号是否为空的判断
        if(model.getIsSupplier() == 1) {
			if(model.getSupplierIds().equals("")) {
				return pagination;
			}
		}

        // 查询总条数
        pagination.setTotalCount(mapper.queryAbnormalOrderCount(pagination), (long) 5);
        List<Map<String, Object>> resultList = mapper.queryAbnormalOrder(pagination);
        pagination.setResultList(resultList);
		return pagination;
	}

	@Override
	public CommonReturnType queryAbnormalOrderByQmnum(String qmnum) {
		ZT001VO result = new ZT001VO();
		try {
			DTZRFCGETNOTIFICATIONLONGTEXT ext = new DTZRFCGETNOTIFICATIONLONGTEXT();
			ext.setQMNUM(qmnum);
			ext.setLINES(new DTZRFCGETNOTIFICATIONLONGTEXT.LINES());
			DTZRFCGETNOTIFICATIONLONGTEXTRES res = siotextservice.getHTTPPort().siOZRFCGETNOTIFICATIONLONGTEXT(ext);
			// DTZRFCGETNOTIFICATIONLONGTEXTRES.HEADER header=res.getHEADER();
			List<DTZRFCGETNOTIFICATIONLONGTEXTRES.LINES.ITEM> itemList = res.getLINES().getITEM();
			String tdline = itemList.parallelStream().map(it -> {
				String temp = it.getTDFORMAT() + it.getTDLINE();
				return temp.replaceAll("\\*", "");
			}).collect(Collectors.joining(","));
			List<ZT001> zt001vo = mapper.queryAbnormalOrderByQmnum(qmnum);
			// Optional.ofNullable(zt001vo).orElse(new
			// ArrayList<>()).stream().forEach(it->it.setTdline(tdline));
			// tdline 质量通知单的长文本
			result.setTdline(tdline);
			// 详情表数据
			result.setZt001List(zt001vo);
			// 附件数据
			Map<String, String> map = new HashMap<>();
			map.put("qmnum", qmnum);
			List<FileInofPO> fileinofpoList = mapper.queryZT005ByParams(map);
			Optional.ofNullable(fileinofpoList).orElse(new ArrayList<>()).stream()
					.forEach(it -> it.setFilePath(RealUrl + it.getFilePath()));
			result.setFileinoList(fileinofpoList);
		} catch (Exception e) {
			e.printStackTrace();
			return CommonReturnType.create(e.getCause(), "操作失败", null);
		}
		return CommonReturnType.create(result, null);
	}

	@Override
	public CommonReturnType modifyAbnormalOrderByKey(AbnormalOrderModifyPO model) {
		try {
			String qmnum = model.getQmnum();
			String qmart = model.getQmart(); // 异常类别2 F2, F4, F5
			String gysfkz = model.getGysfkzt(); // 缺陷反馈单状态 A,B,C,D,S,Z
			String gysfkz_b = model.getGysfkzt_b(); // 缺陷反馈单状态 A,B,C,D,S,Z(修改前)
			if (ValidateHelper.isEmpty(qmnum)) {
				return CommonReturnType.create(null, "没有通知单号:" + qmnum);
			}
			List<ZT003VO> list =mapper.queryAbnormalOrderByCondition(new AbnormalOrderPO(qmnum));
			if (ValidateHelper.isEmpty(list)) {
				return CommonReturnType.create(null, "没有通知单号:" + qmnum);
			}

			ZT003VO zt003vo = list.get(0);
			String gysfkz_sys = zt003vo.getGysfkzt();
			String senam = zt003vo.getSenam(); // 'R/3 系统, 用户登录名',
			String lifnr = zt003vo.getLifnr(); // 供应商或债权人的帐号
			String bycd = zt003vo.getBycd(); // 'BPM异常单号'

			// mailSevcie.sendHtmlMail("1597480015@qq.com",subject,content);

			if (ValidateHelper.isEmpty(gysfkz_b)) {
				return CommonReturnType.create(null, "通知单号:" + qmnum + "缺陷反馈单状态不可为空");
			}
			if (ValidateHelper.isEmpty(gysfkz_sys)) {
				return CommonReturnType.create(null, "通知单号:" + qmnum + "缺陷反馈单系统状态不可为空");
			}
			if (!gysfkz_sys.equals(gysfkz_b)) {
				return CommonReturnType.create(null, "通知单号:" + qmnum + "缺陷反馈单系统状态已修改");
			}
			try {
				new Thread(() -> {
					String subject = String.format("【%s】的异常单<%s>已经发送，请确认！", lifnr.substring(2), qmnum);
					String content = "<p style='text-indent:2em'>请及时登录系统查看异常单<%s></p>\r\n"
							+ "<p style='text-indent:2em'>a)旺旺供应商管理系统登录链接：<a href='%s'> %s</a></p>\r\n"
							+ "<p style='text-indent:2em'>b)此为提醒邮件，请不要直接回复此邮件，谢谢配合</p>";
					content = String.format(content, qmnum, loginUrl, loginUrl);
					if ("B".equals(gysfkz)) {
						Map<String, String> map = new HashMap<>();
						map.put("lifnr", lifnr);
						List<Account> Account = accountDao.getAccountByParams(map);
						if (ValidateHelper.isNotEmpty(Account)) {
							// String to=Account.get(0).getEmail();
							//String to = "00403441" + "@want-want.com";
							//mailSevcie.sendHtmlMail(to, subject, content);
							// 批量的发送邮件							
							 String subjects=subject; 
							 String contentS=content;
							 Optional.ofNullable(Account).orElse(new ArrayList<>()).forEach(it->{
							 mailSevcie.sendHtmlMail(it.getEmail(),subjects,contentS); });
							 
						}
					}
					if ("C".equals(gysfkz)) {
						subject = String.format("【%s】的异常单<%s>已经确认，请确认！", lifnr.substring(2), qmnum);
						//String to = "00403441" + "@want-want.com";
						String to = senam + "@want-want.com";
						mailSevcie.sendHtmlMail(to, subject, content);
					}
				}).start();
			} catch (Exception e) {
				System.out.println(e.getCause());
			}

			if ((qmart != null && ("F4".equals(qmart) || "F5".equals(qmart)))
					&& (gysfkz != null && ("B".equals(gysfkz)))) {
				DTZRFCSRM016REQ req = new DTZRFCSRM016REQ();
				req.setQMNUMI(qmnum);
				// req.setTQMELE(null);
				DTZRFCSRM016RES res = sio16service.getHTTPPort().siOZRFCSRM016(req);
				String messagee = res.getMESSAGEE();
				String typee = res.getTYPEE();
				logger.info("typee=" + typee + ",messagee=" + messagee);
				List<DTZRFCSRM016RES.TQMELE.Item> ItemList = res.getTQMELE().getItem();
				if (ValidateHelper.isEmpty(ItemList) || StringUtils.isBlank(ItemList.get(0).getEBELN())) {
					return CommonReturnType.create(null, "SAP中没有维护关联PO订单!", null);
				}
			}
			Integer result = mapper.modifyAbnormalOrderByKey(model);
			if (result > 0) {
				return CommonReturnType.create(null, "操作成功");
			} else {
				return CommonReturnType.create(null, "操作失败", "E");
			}
		} catch (Exception e) {
			e.printStackTrace();
			return CommonReturnType.create(e.getClass(), "操作失败", "E");
		}

	}

	public static void main(String[] args) {
		String str = "**123,**123,**1243,**134";
		System.out.println(str.replaceAll("\\*", ""));
	}

	@Override
	public CommonReturnType deleteZT005(String qmnum, String gysfkxm) {
		FileInofPO fileInfo = mapper.findZT005ByCondition(qmnum, gysfkxm);

		if (fileInfo != null && !"".equals(fileInfo.getFilePath()) && !"".equals(fileInfo.getFileName())) {
			// 3、如果照片文件存在则删除
			File file = new File(fileInfo.getFilePath(), fileInfo.getFileName());
			if (file.exists()) {
				file.delete();
			}

			Integer result = mapper.deleteZT005(qmnum, gysfkxm);
			if (result > 0) {
				return CommonReturnType.create(null, "删除成功！");
			} else {
				return CommonReturnType.create(null, "删除失败！", "E");
			}
		} else {
			return CommonReturnType.create(null, "文件不存在！");
		}
	}

	@Override
	public ModelAndView printAbnormalorderPdf(String qmnum) {
      AbnormalOrderPO abnormalOrderPo=new AbnormalOrderPO();
      abnormalOrderPo.setQmnum(qmnum);
      List<ZT003VO> zt003VOList=mapper.queryAbnormalOrderByCondition(abnormalOrderPo);
      ZT003VO zt003VO=new ZT003VO();
      if (zt003VOList !=null && zt003VOList.size() >0) {
     	  zt003VO=zt003VOList.get(0);
	  }
      Map<String, Object> model = new HashMap<>(); 
      model.put("zt003VO", zt003VO);
      // 通过通知单号ZT003-QMNUM，调用接口ZRFC_GET_NOTIFICATION_LONGTEXT 获取意见组进行拼接
      model.put("tdline", this.zrfc_get_notification_longtext(qmnum));
      String feqklas="";
      List<ZT001> zt001vo = mapper.queryAbnormalOrderByQmnum(qmnum);
      if (zt001vo !=null && zt001vo.size() >0 ) {
    	  feqklas=zt001vo.stream().map(ZT001::getFeqklas).distinct().collect(Collectors.joining(","));
	  }
      model.put("feqklas", feqklas);//缺陷类别
      return new ModelAndView(new AbnormalorderPdf(), model);
	}
	public  String zrfc_get_notification_longtext(String qmnum) {
		DTZRFCGETNOTIFICATIONLONGTEXT ext = new DTZRFCGETNOTIFICATIONLONGTEXT();
		ext.setQMNUM(qmnum);
		ext.setLINES(new DTZRFCGETNOTIFICATIONLONGTEXT.LINES());
		DTZRFCGETNOTIFICATIONLONGTEXTRES res = siotextservice.getHTTPPort().siOZRFCGETNOTIFICATIONLONGTEXT(ext);
		List<DTZRFCGETNOTIFICATIONLONGTEXTRES.LINES.ITEM> itemList = res.getLINES().getITEM();
		String tdline = itemList.parallelStream().map(it -> {
			String temp = it.getTDFORMAT() + it.getTDLINE();
			return temp.replaceAll("\\*", "");
		}).collect(Collectors.joining(","));
		return tdline;
	}
}
