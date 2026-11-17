package com.sterling.employee.controller;

import java.net.URI;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;

import com.sterling.employee.dto.EmployeeRequest;
import com.sterling.employee.dto.EmployeeResponse;
import com.sterling.employee.service.EmployeeService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    private final EmployeeService service;

    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

	@PostMapping
	public Mono<ResponseEntity<EmployeeResponse>> addEmployee(
	        @RequestBody EmployeeRequest request) {

	    return service.createEmployee(request)
	            .map(employee -> ResponseEntity
	                    .created(URI.create("/employees/" + employee.id()))
	                    .body(employee));
	}	    

	@GetMapping
	public ResponseEntity<Flux<EmployeeResponse>> getEmployees() {

	    Flux<EmployeeResponse> response =
	            service.getAllEmployees();

	    return ResponseEntity
	            .ok()
	            .body(response);
	}
	// getById()
	// auto build
	@GetMapping("/{id}")
	public Mono<ResponseEntity<EmployeeResponse>> getById(
        @PathVariable Long id) {

    	return service.getById(id)
            .map(ResponseEntity::ok)
            .defaultIfEmpty(ResponseEntity.notFound().build());
	}
	
}
