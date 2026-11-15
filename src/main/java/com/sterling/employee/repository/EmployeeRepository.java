package com.sterling.employee.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import com.sterling.employee.entity.Employee;

public interface EmployeeRepository extends ReactiveCrudRepository<Employee, Long> {

}
