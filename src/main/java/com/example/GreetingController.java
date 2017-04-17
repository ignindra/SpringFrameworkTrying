package com.example;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;

@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();
    
//    @RequestMapping(value="/greeting", method=RequestMethod.POST)
//    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
//        return new Greeting(counter.incrementAndGet(), String.format(template, name));
//    }
    
//    @RequestMapping(value="/{greeting}", method=RequestMethod.POST)
//    public Greeting greeting(@PathVariable String greeting) {
//        return new Greeting(counter.incrementAndGet(), String.format(template, greeting));
//    }
    
//    @RequestMapping(value="/lala")
//    public Greeting lala(@RequestParam(value="names", defaultValue="cobacoba") String name) {
//    	return new Greeting(counter.incrementAndGet(), String.format(template, name));
//    }
}