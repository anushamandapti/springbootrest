package com.krsna.hrm.api.rest;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.krsna.hrm.domain.Employee;
import com.krsna.hrm.service.EmployeeServiceImpl;

@RestController
@RequestMapping(value = "/hrm/rest/v1")
public class EmployeeController {
	
	@Autowired
	EmployeeServiceImpl employeeServiceImpl;
	
	/**
	 * Get a single employee data
	 * @param employeeId
	 * @return
	 */
	@GetMapping(path = "/employee/{id}")
	public Optional<Employee> getEmployeeById(@PathVariable("id") Integer employeeId) {
		System.out.println("EmployeeController.getEmployee()- getting employee with id "+employeeId);
		//Avoid Null check
		Optional<Employee> employee = employeeServiceImpl.getEmployeeById(employeeId);
		
		if(employee.isPresent()) {
			Employee emp = employee.get();
			String firstName = emp.getFirstName();
			String lastName = emp.getLastName();
			String email = emp.getEmail();
			System.out.println("firstName = "+firstName+ "lastName = "+lastName + "email = "+email);
			return employee;
		}
		
		return null;
	}
	
	
	@GetMapping(path = "/employee") 
	public Iterable<Employee> getAllEmployees() {
		return employeeServiceImpl.getAllEmployees();
	}
	
	/**
	 * Create new record in database
	 * @param employee
	 * @return
	 */
	@PostMapping(path = "/employee")
	public Employee createEmployee(@RequestBody Employee employee) {
		System.out.println("EmployeeController.createEmployee()"+employee.toString());
		return employeeServiceImpl.createEmployee(employee);
	}

	
	@PutMapping(path = "/employee")
	public Employee updateEmployee(@RequestBody Employee employee) {
		System.out.println("EmployeeController.updateEmployee()"+employee.toString());
		return employeeServiceImpl.updateEmployee(employee);
	}

	/**
	 * Delete an employee record
	 * @param employeeId
	 */
	@DeleteMapping(path = "/employee/{id}")
	public void deleteEmployee(@PathVariable("id") Integer employeeId) {
		System.out.println("EmployeeController.deleteEmployee()"+employeeId);
		employeeServiceImpl.deleteEmployee(employeeId);
	}

}
