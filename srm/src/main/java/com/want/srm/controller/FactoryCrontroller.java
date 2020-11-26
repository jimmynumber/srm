package com.want.srm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.want.srm.entity.Factory;
import com.want.srm.service.IFactoryService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/factory")
@Api(tags = "工厂信息")
@CrossOrigin
public class FactoryCrontroller {
	@Autowired
	private IFactoryService Service;
	
	@ApiOperation(value = "获取工厂信息", nickname="getAllFactory", notes = "get获取")
	@GetMapping("/getAllFactory") 
	public List<Factory> getAllFactory() {
		return Service.getAllFactory();
	}
}
