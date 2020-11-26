package com.want.redis.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/redissessioncontroller")
public class RedisSessionController {

	//http://localhost:8081/redissessioncontroller/first
	@RequestMapping(value = "/first", method = RequestMethod.GET)
	public Map<String, Object> firstResp(HttpServletRequest request) {
		Map<String, Object> map = new HashMap<>();
		request.getSession().setAttribute("request Url", request.getRequestURL());
		map.put("request Url", request.getRequestURL());

		return map;
	}
 
	//http://localhost:8081/redissessioncontroller/sessions
	@RequestMapping(value = "/sessions", method = RequestMethod.GET)
	public Object sessions(HttpServletRequest request) {
		Map<String, Object> map = new HashMap<>();
		map.put("sessionId", request.getSession().getId());
		// map.put("message", request.getSession().getAttribute("map"));
		map.put("message", request.getSession().getAttribute("request Url"));

		return map;
	}

}
