package com.norjull.EmployeesBackEnd.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.norjull.EmployeesBackEnd.dto.EmployeeDTOFactory;
import com.norjull.EmployeesBackEnd.model.Employee;
import com.norjull.EmployeesBackEnd.repository.EmployeeRespository;

import io.vavr.collection.List;
import io.vavr.control.Either;
import io.vavr.control.Try;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRespository employeeRespository;

	@Autowired
	private EmployeeDTOFactory employeeDTOFactory;

	/**
	 * Retrieve an employee given a id. The employee is wrapped in an Either, where the Right result is
	 * Employee and the Left is a String with the error message. This method perform in O(n).
	 * @param Integer      employee Id.
     * @return A Either where the right is an Employee and the left is an String with a error message.
	 */
	@Override
	public Either<String, Employee> getEmployee(Integer id) {
		return Try.of(() -> employeeDTOFactory.createEmployee(employeeRespository.getEmployeeDTO(id)))		
		.toEither().mapLeft(throwable -> "Failed to get employee with id  " + id + " :" + throwable.getMessage());
	}

	/**
	 * Retrieve a List of employees. The employees list is wrapped in an Either, where the Right result is
	 * a List<Employee> and the Left is a String with the error message. This method perform in O(n).
	 * @param Integer      employee Id.
     * @return A Either where the right is an Employee and the left is an String with a error message.
	 */
	@Override
	public Either<String, List<Employee>> getEmployees() {
		return Try.of(() -> employeeRespository.getEmployeeDTOs()
				.map(emplDTO -> employeeDTOFactory.createEmployee(emplDTO))).
				toEither().
				mapLeft(throwable -> "Failed to get employee lists: " + throwable.getMessage());
	}

}
