package com.example;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DemoController {

//    @RequestMapping("/hello")
//    @ResponseBody
//    public String hello() {
//        return "Greetings from Spring Boot!";
//    }
	
	@RequestMapping("/jspdemo")
	public String hello(ModelMap modelMap) {
	    modelMap.addAttribute("message", "Hello Spring from JSP");
	    return "hello";
	}
}