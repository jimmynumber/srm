package com.want.srm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.want.srm.dao.FactoryMapper;
import com.want.srm.entity.Factory;
import com.want.srm.service.IFactoryService;

@Service
public class FactoryServiceImpl implements IFactoryService {

	@Autowired
	private FactoryMapper mapper;

	@Override
	public List<Factory> getAllFactory() {
		return mapper.getAllFactory();
	}
	
	
}
