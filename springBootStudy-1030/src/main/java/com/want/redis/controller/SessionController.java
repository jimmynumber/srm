package com.want.redis.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sessioncontroller")
public class SessionController {

	//http://localhost:8081/SessionController/session
	//@GetMapping("/session")
	@RequestMapping(value = "/session", method = RequestMethod.GET)
	public Map<String, Object> sessionTest(HttpServletRequest request) {
		Map<String, Object> map = new HashMap<>();
		request.getSession().setAttribute("request Url", request.getRequestURL());
		map.put("request Url", request.getRequestURL());
		map.put("sessionId", request.getSession().getId());
		map.put("message", request.getSession().getAttribute("request Url"));
		return map;
	}

}
