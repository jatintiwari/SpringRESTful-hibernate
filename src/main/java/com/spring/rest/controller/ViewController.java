package com.spring.rest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ViewController {

	@RequestMapping("/select/{type}")
	public String index(@PathVariable("type") String type) {
		System.out.println(type);
		if (type.equalsIgnoreCase("post")) {
			return "postit";
		} else if (type.equalsIgnoreCase("get")) {
			return "get";
		} else if (type.equalsIgnoreCase("delete")) {
			return "delete";
		}return "happy";
	}
}
