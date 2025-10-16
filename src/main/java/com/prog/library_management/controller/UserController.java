package com.prog.library_management.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RequestMapping("/auth")
@RestController
public class UserController {
	@GetMapping("/user")
	public String showUser() {
		return "Hi I am user";
	}
	@GetMapping("/admin")
	public String showAdmin() {
		return "Hi I am admin";
	}

}
