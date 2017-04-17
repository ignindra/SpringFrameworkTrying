package com.example;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	
	@RequestMapping(value="/hello", method=RequestMethod.GET)
    public String greeting1(@RequestParam(value="input", defaultValue="default value") String message) {
        return "Your message: "+message;
    }
	
	@RequestMapping(value="/hello", method=RequestMethod.POST)
    public String greeting2(@RequestBody String message) {
        return "Your message: "+message;
    }
	
	@RequestMapping(value="/hello/{message}", method=RequestMethod.PUT)
    public String greeting3(@PathVariable String message) {
        return "Your message: "+message;
    }
}