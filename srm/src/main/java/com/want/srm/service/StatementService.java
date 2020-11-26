package com.want.srm.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.web.bind.annotation.RequestBody;

import com.want.srm.entity.ZT008;
import com.want.srm.entity.ZT009;
import com.want.srm.entity.ZT034;
import com.want.srm.entity.ZT038;
import com.want.srm.po.CreateStatementPO;
import com.want.srm.vo.CommonReturnType;
import com.want.srm.vo.FromVo;
import com.want.srm.vo.Pagination;
import com.want.srm.vo.StatementDto;
import com.want.srm.vo.StatementInfoVo;
import com.want.srm.vo.StatementVo;
import com.want.srm.vo.UpdateStatementVo;
import com.want.srm.vo.ValidationVo;
import com.want.srm.vo.ZT003VO;

public interface StatementService {

	List<StatementVo> selectStatementBycond(StatementDto statementDto);


	StatementInfoVo getStatementInfo(FromVo fromVo);

	public ZT008 queryZT008(String DZBDH);
	public List<ZT009> queryZT009(String DZBDH);
	public List<ZT034> queryZT034(String DZBDH);
	public List<ZT038> queryZT038(String DZBDH);
	public List<ZT003VO> queryZT003(String DZBDH);
	CommonReturnType saveStatementInfo(StatementInfoVo statementInfoVo);	


	CommonReturnType updateStatementInfo(@Valid UpdateStatementVo updateStatementVo);
	
	public Map<String, String> validation(ValidationVo vo);
	
	CommonReturnType createStatement(CreateStatementPO model);
	
	Pagination<StatementVo> selectStatementBycondPage(Long pageNumber, Long pageSize, StatementDto statementDto);
}
