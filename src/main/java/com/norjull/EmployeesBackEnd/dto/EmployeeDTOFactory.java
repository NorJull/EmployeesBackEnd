package com.norjull.EmployeesBackEnd.dto;

import org.springframework.stereotype.Component;

import com.norjull.EmployeesBackEnd.model.ContractTypeName;
import com.norjull.EmployeesBackEnd.model.Employee;
import com.norjull.EmployeesBackEnd.model.HourlySalaryContractEmployee;
import com.norjull.EmployeesBackEnd.model.MonthlySalaryContractEmployee;
@Component
public class EmployeeDTOFactory {
	
	public Employee createEmployee(EmployeeDTO employeeDTO) {
		
		if(ContractTypeName.HOURLY.getDescription().equals(employeeDTO.getContractTypeName())) {
			HourlySalaryContractEmployee hourlySalaryContractEmployee = new HourlySalaryContractEmployee(employeeDTO.getId(), employeeDTO.getName(), 
					employeeDTO.getRoleId(), employeeDTO.getRoleName(), employeeDTO.getRoleDescription(), employeeDTO.getHourlySalary(), employeeDTO.getMonthlySalary());
			hourlySalaryContractEmployee.calculateAnualSalary();
			return hourlySalaryContractEmployee;		
			
		}else if(ContractTypeName.MONTHLY.getDescription().equals(employeeDTO.getContractTypeName())){
			MonthlySalaryContractEmployee monthlySalaryContractEmployee = new MonthlySalaryContractEmployee(employeeDTO.getId(), employeeDTO.getName(), 
					employeeDTO.getRoleId(), employeeDTO.getRoleName(), employeeDTO.getRoleDescription(), employeeDTO.getHourlySalary(), employeeDTO.getMonthlySalary());
			monthlySalaryContractEmployee .calculateAnualSalary();
			return monthlySalaryContractEmployee;
		} 
		
		return null;
	
	}

}
