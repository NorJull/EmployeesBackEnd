package com.norjull.EmployeesBackEnd.model;

import java.math.BigDecimal;

public class HourlySalaryContractEmployee extends Employee {

	private ContractTypeName contractTypeName = ContractTypeName.HOURLY;

	public HourlySalaryContractEmployee() {
		super();
	}

	public HourlySalaryContractEmployee(Integer id, String name, Integer roleId, String roleName,
			String roleDescription, BigDecimal hourlySalary, BigDecimal monthlySalary) {
		super(id, name, roleId, roleName, roleDescription, hourlySalary, monthlySalary);
		this.calculateAnualSalary();
	}

	public ContractTypeName getContractTypeName() {
		return contractTypeName;
	}

	@Override
	public void calculateAnualSalary() {
		this.setAnualSalary(this.getHourlySalary().multiply(BigDecimal.valueOf(120 * 12)));
	}

	
}
