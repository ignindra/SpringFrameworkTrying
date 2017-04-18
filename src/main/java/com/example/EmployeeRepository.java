package com.example;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

@RestResource(exported=true)
public interface EmployeeRepository extends PagingAndSortingRepository<Employee,Long> {
    public List<Employee> findByLastName(@Param("lastName") String lastName);
}