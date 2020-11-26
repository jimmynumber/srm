package com.want.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.want.entity.User;

@Controller
@RequestMapping("thymeleaf")
public class ThymeleafController {
	
	//http://localhost:8081/thymeleaf/variable
	@GetMapping("/variable")
	public ModelAndView variable() {
		ModelAndView modelAndView = new ModelAndView("hh/thymeleaf");
		String name = "longzhonghua";
		Integer age = 8;
		modelAndView.addObject("name", name);
		modelAndView.addObject("age", age);

		return modelAndView;
	}

	// http://localhost:8081/thymeleaf/index
	@GetMapping("/index")
	public ModelAndView index() {
		ModelAndView modelAndView = new ModelAndView("hh/index");
		return modelAndView;
	}

	//http://localhost:8081/thymeleaf/list
	@GetMapping("/list")
	public ModelAndView list() {
		List<Object> list = new ArrayList<Object>();
		list.add("北京");
		list.add("上海");
		list.add("深圳");
		ModelAndView modelAndView = new ModelAndView("hh/list");
		modelAndView.addObject("list", list);
		return modelAndView;
	}

	//http://localhost:8081/thymeleaf/list2
	@GetMapping("/list2")
	public ModelAndView list2() {
		List<User> list = new ArrayList<>();
		list.add(new User(1, "long"));
		list.add(new User(2, "zhiran"));
		list.add(new User(3, "zhiran"));
		ModelAndView modelAndView = new ModelAndView("hh/list2");
		modelAndView.addObject("list", list);
		return modelAndView;
	}

	//http://localhost:8081/thymeleaf/map
	@GetMapping("/map")
	public ModelAndView map() {
		Map<String, String> user = new HashMap<String, String>();
		user.put("name", "姓名");
		user.put("sex", "male");
		ModelAndView modelAndView = new ModelAndView("hh/map");
		modelAndView.addObject("map", user);
		return modelAndView;
	}
}
