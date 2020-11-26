package com.want.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/helloworld")
public class HelloWorldController {
	//http://localhost:8081/helloworld/hello
	@RequestMapping("/hello")
	public String hello(String name) throws Exception {
		return "hello"+name;
	}
}
