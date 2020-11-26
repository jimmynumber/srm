package com.want.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/userSecurity")
public class Security {

	// http://localhost:8081/userSecurity/addUser
	@GetMapping("/addUser")
	public void addUser() {
		System.out.println("---addUser---");
	}

	// http://localhost:8081/userSecurity/updateUser
	@GetMapping("/updateUser")
	public void updateUser() {
		System.out.println("---updateUser---");
	}

	// http://localhost:8081/userSecurity/delete
	@GetMapping("/delete")
	public void delete() {
		System.out.println("---delete---");

	}
}