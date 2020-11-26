package com.want.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("tttt")
public class ServletTestController {
	
    // http://localhost:8081/tttt/get?userName=111
	@RequestMapping(value="get",method = RequestMethod.GET)
	public String testGet(String userName){
		System.out.println("get使用参数："+userName);
		return userName;
	}
	
	//http://localhost:8081/tttt/post?userName=111
	@RequestMapping(value="post",method = RequestMethod.POST)
	public String testPost(String userName){
		System.out.println("post使用参数："+userName);
		return userName;
	}
}