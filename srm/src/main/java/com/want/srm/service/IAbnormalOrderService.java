package com.want.srm.service;

import java.util.Map;

import org.springframework.web.servlet.ModelAndView;

import com.want.srm.po.AbnormalOrderModifyPO;
import com.want.srm.po.AbnormalOrderPO;
import com.want.srm.vo.CommonReturnType;
import com.want.srm.vo.Pagination;

public interface IAbnormalOrderService {

	Pagination<Map<String, Object>> queryAbnormalOrderByCondition(Long pageNumber, Long pageSize,AbnormalOrderPO model);

	CommonReturnType queryAbnormalOrderByQmnum(String qmnum);

	CommonReturnType modifyAbnormalOrderByKey(AbnormalOrderModifyPO model);
	
	//附件删除功能
	CommonReturnType deleteZT005(String qmnum, String gysfkxm);

	ModelAndView printAbnormalorderPdf(String qmnum);
	
}
