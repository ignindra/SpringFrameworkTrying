package com.example;

import java.util.List;
import java.util.stream.Collectors;
import java.util.ArrayList;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {
	
	public List<Employee> employees = new ArrayList<>();	
	
	public EmployeeController() {
		this.employees.add(new Employee("Joko", "male"));
		this.employees.add(new Employee("Jiki", "female"));
		this.employees.add(new Employee("Jaka", "male"));
	}
	
	@RequestMapping(value="/employees", method=RequestMethod.GET)
	public List<Employee> getEmployee(@RequestParam(value="gender", defaultValue="Unknown") String gender) {
		if (gender.equals("male")) {
			return employees.stream().filter(o -> o.getGender().equals("male")).collect(Collectors.toList());
		} else {
			return employees;
		}
	}
	
	@RequestMapping(value="/employees", method=RequestMethod.POST)
	public Employee makeEmployee(@RequestBody(required=true) Employee employee) {
		this.employees.add(employee);
		return employee;
	}
}