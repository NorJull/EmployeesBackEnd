package com.norjull.EmployeesBackEnd.service;

import com.norjull.EmployeesBackEnd.model.Employee;

import io.vavr.collection.List;
import io.vavr.control.Either;


public interface EmployeeService {

	public Either<String, Employee> getEmployee(Integer id);
	
	public Either<String, List<Employee>> getEmployees();
}
