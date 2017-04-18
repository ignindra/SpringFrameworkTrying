package com.example;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.ArrayList;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
public class EmployeeController {
	
	public List<Employee> employees = new ArrayList<>();	
	
	public EmployeeController() {
		this.employees.add(new Employee("U001", "Joko", "male"));
		this.employees.add(new Employee("U002", "Jiki", "female"));
		this.employees.add(new Employee("U003", "Jaka", "male"));
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
	
	@RequestMapping(value="/employees/{id}", method=RequestMethod.GET)
	public Employee getSpecificEmployee(@PathVariable String id)  {
		if (employees.stream().filter(e -> e.getId().equals(id)).count() > 0) {
			return employees.stream().filter(e -> e.getId().equals(id)).findAny().get();
		} else {
			throw new EmployeeNotFoundException();
		}
	}
}