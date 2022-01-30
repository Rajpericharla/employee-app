package com.lendage.employee.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lendage.employee.model.Employee;
import com.lendage.employee.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public void insertEmployee(Employee employee) {
		Employee employee1 = employeeRepository.save(employee);
		System.out.println(employee1);
	}

}
