package com.krsna.hrm.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.krsna.hrm.dao.jpa.EmployeeRespository;
import com.krsna.hrm.domain.Employee;

@Service
public class EmployeeServiceImpl {
	
	@Autowired
	EmployeeRespository employeeRespository;

	
	public Optional<Employee> getEmployeeById(Integer employeeId) {
		Optional<Employee> employee = employeeRespository.findById(employeeId);
		return employee;
	}
	
	public Iterable<Employee> getAllEmployees() {
		return employeeRespository.findAll();
	}

	
	public Employee createEmployee(Employee employee) {
		return employeeRespository.save(employee);
	}
	
	public Employee updateEmployee(Employee employee) {
		return employeeRespository.save(employee);
	}
	
	public void deleteEmployee(Integer employeeId) {
		employeeRespository.deleteById(employeeId);
	}
}
