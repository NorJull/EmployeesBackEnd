package com.norjull.EmployeesBackEnd.service;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.norjull.EmployeesBackEnd.dto.EmployeeDTO;
import com.norjull.EmployeesBackEnd.model.ContractTypeName;
import com.norjull.EmployeesBackEnd.model.Employee;
import com.norjull.EmployeesBackEnd.repository.EmployeeRespository;
import com.norjull.EmployeesBackEnd.testUtil.EmployeeDTOBuilder;

import io.vavr.collection.List;
import io.vavr.control.Either;

@SpringBootTest
@RunWith(SpringRunner.class)
public class EmployeeServiceImplTest {

	@Autowired
	private EmployeeService employeeService;

	@MockBean
	private EmployeeRespository employeeRespository;

	@Test
	public void getEmployeesTest() {
		EmployeeDTO employeeDTO1 = new EmployeeDTOBuilder().build();
		EmployeeDTO employeeDTO2 = new EmployeeDTOBuilder().build();
		EmployeeDTO employeeDTO3 = new EmployeeDTOBuilder().build();

		List<EmployeeDTO> employeeDTOs = List.of(employeeDTO1, employeeDTO2, employeeDTO3);
		when(employeeRespository.getEmployeeDTOs()).thenReturn(employeeDTOs);

		Either<String, List<Employee>> eitherEmployees = employeeService.getEmployees();

		assertTrue(eitherEmployees.isRight());
		assertEquals(3, eitherEmployees.get().size());
	}

	@Test
	public void getEmployee_with_MonthlySalary_Test() {
		EmployeeDTO employeeDTO1 = new EmployeeDTOBuilder()
				.setContractTypeName(ContractTypeName.MONTHLY.getDescription()).setMonthlySalary(BigDecimal.TEN)
				.build();

		when(employeeRespository.getEmployeeDTO(any())).thenReturn(employeeDTO1);

		Either<String, Employee> eitherEmployee = employeeService.getEmployee(employeeDTO1.getId());

		BigDecimal expectedAnualSalary = BigDecimal.valueOf(120);

		assertTrue(eitherEmployee.isRight());
		assertEquals(employeeDTO1.getId(), eitherEmployee.get().getId());
		assertTrue(expectedAnualSalary.equals(eitherEmployee.get().getAnualSalary()));
	}

	@Test
	public void getEmployee_with_HourlySalary_Test() {
		EmployeeDTO employeeDTO1 = new EmployeeDTOBuilder()
				.setContractTypeName(ContractTypeName.HOURLY.getDescription()).setHourlySalary(BigDecimal.TEN).build();

		when(employeeRespository.getEmployeeDTO(any())).thenReturn(employeeDTO1);

		Either<String, Employee> eitherEmployee = employeeService.getEmployee(employeeDTO1.getId());

		BigDecimal expectedAnualSalary = BigDecimal.valueOf(14400);

		assertTrue(eitherEmployee.isRight());
		assertEquals(employeeDTO1.getId(), eitherEmployee.get().getId());
		assertTrue(expectedAnualSalary.equals(eitherEmployee.get().getAnualSalary()));
	}
}
