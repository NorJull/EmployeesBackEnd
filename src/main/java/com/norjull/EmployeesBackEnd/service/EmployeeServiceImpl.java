package com.norjull.EmployeesBackEnd.service;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.norjull.EmployeesBackEnd.dto.EmployeeDTO;
import com.norjull.EmployeesBackEnd.dto.EmployeeDTOFactory;
import com.norjull.EmployeesBackEnd.model.Employee;
import com.norjull.EmployeesBackEnd.model.HourlySalaryContractEmployee;
import com.norjull.EmployeesBackEnd.model.MonthlySalaryContractEmployee;
import com.norjull.EmployeesBackEnd.repository.EmployeeRespository;

import io.vavr.collection.List;
import io.vavr.control.Either;
import io.vavr.control.Option;
import io.vavr.control.Try;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRespository employeeRespository;

	@Autowired
	private EmployeeDTOFactory employeeDTOFactory;

	@Override
	public Either<String, Employee> getEmployee(Integer id) {
		return Try.of(() -> {
			Employee employee = employeeDTOFactory.createEmployee(employeeRespository.getEmployeeDTO(id));
			calculateAnualSalary(employee);
			return employee;
		}).toEither().mapLeft(throwable -> "Failed to get employee with id  " + id + " :" + throwable.getMessage());
	}

	@Override
	public Either<String, List<Employee>> getEmployees() {
		return Try.of(() -> employeeRespository.getEmployeeDTOs()
				.map(emplDTO -> employeeDTOFactory.createEmployee(emplDTO)).map(empl -> {
					calculateAnualSalary(empl);
					return empl;
				})).toEither().mapLeft(throwable -> "Failed to get employee lists: " + throwable.getMessage());
	}

	private void calculateAnualSalary(Employee empl) {
		BigDecimal anualSalary = BigDecimal.ZERO;

		if (empl instanceof HourlySalaryContractEmployee) {
			anualSalary = empl.getHourlySalary().multiply(BigDecimal.valueOf(120 * 12));
		} else if (empl instanceof MonthlySalaryContractEmployee) {
			anualSalary = empl.getMonthlySalary().multiply(BigDecimal.valueOf(12));
		}

		empl.setAnualSalary(anualSalary);
	}

}
