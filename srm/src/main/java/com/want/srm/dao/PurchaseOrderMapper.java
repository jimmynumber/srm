package com.want.srm.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.want.srm.vo.EkpoVO;
import com.want.srm.vo.Pagination;

@Mapper
public interface PurchaseOrderMapper {

	long queryPurchaseOrderCount(Pagination<EkpoVO> pagination);

	List<EkpoVO> queryPurchaseOrder(Pagination<EkpoVO> pagination);

	long insertPurchaseBatch(List<EkpoVO> list);
	
	long modifyPurchaseBatch(EkpoVO ekpoVO);

	List<EkpoVO> queryExistsPurchaseOrder(List<EkpoVO> list);
}
