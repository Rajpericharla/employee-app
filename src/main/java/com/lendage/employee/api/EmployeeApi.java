package com.lendage.employee.api;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lendage.employee.model.Employee;
import com.lendage.employee.service.EmployeeService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping(value = "api/v1/employee", produces = { MediaType.APPLICATION_JSON_VALUE })
@Slf4j
public class EmployeeApi {
	
	@Autowired
	private EmployeeService employeeService;

	@PostMapping
	public ResponseEntity<Employee> insertEmployee(@Valid @RequestBody Employee employee) {
		log.info("START");
		
		employeeService.insertEmployee(employee);
		
		// https://beeceptor.com 
		// testnotify
		
		//https://testnotify.free.beeceptor.com
		
		// EmployeesTestnotifyClient -> EMPLOYEE_ADDED (Enum)
		
		log.info("END");
		return new ResponseEntity<>(new Employee(), HttpStatus.OK);
	}
}
