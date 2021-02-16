package com.norjull.EmployeesBackEnd.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.norjull.EmployeesBackEnd.model.Employee;
import com.norjull.EmployeesBackEnd.service.EmployeeService;

import io.vavr.collection.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@GetMapping("/employees")
	public ResponseEntity<List<Employee>> getEmployees() {
		return employeeService.getEmployees().fold(
				left -> ResponseEntity.status(HttpStatus.NOT_FOUND).body(List.empty()),
				right -> ResponseEntity.ok().body(right));
	}

	@GetMapping("/employees/{id}")
	public ResponseEntity<Employee> getEmployee(@PathVariable int id) {
		return employeeService.getEmployee(id).fold(left -> ResponseEntity.status(HttpStatus.NOT_FOUND).body(null),
				right -> ResponseEntity.ok().body(right));
	}
}
