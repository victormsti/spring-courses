package com.luv2code.springboot.thymeleafdemo.controller;

import java.util.Date;

import org.apache.naming.java.javaURLContextFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("")
public class DemoController {

	// create a mapping for "/hello"
	@GetMapping("/hello")
	public String sayHello(Model theModel) {
		
		theModel.addAttribute("theDate", new Date());
		
		return "helloworld";
	}
}
