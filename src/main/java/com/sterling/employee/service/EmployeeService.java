package com.sterling.employee.service;

import org.springframework.stereotype.Service;

import com.sterling.employee.dto.EmployeeRequest;
import com.sterling.employee.dto.EmployeeResponse;
import com.sterling.employee.entity.Employee;
import com.sterling.employee.repository.EmployeeRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class EmployeeService {

    private final EmployeeRepository repository;

    public EmployeeService(EmployeeRepository repository) {
        this.repository = repository;
    }

    public Mono<EmployeeResponse> createEmployee(EmployeeRequest dto) {

        Employee employee = new Employee();

        employee.setEmployeeName(dto.employeeName());
        employee.setSalary(dto.salary());

        return repository.save(employee)
                .map(this::convertToDTO);
    }

    public Flux<EmployeeResponse> getAllEmployees() {

        return repository.findAll()
                .map(this::convertToDTO);
    }
// getById
    public Mono<EmployeeResponse> getById(Long id) {

        return repository.findById(id)
                .map(this::convertToDTO);
    }

    private EmployeeResponse convertToDTO(Employee employee) {
        return new EmployeeResponse(
                employee.getId(),
                employee.getEmployeeName(),
                employee.getSalary()
        );
    }
}