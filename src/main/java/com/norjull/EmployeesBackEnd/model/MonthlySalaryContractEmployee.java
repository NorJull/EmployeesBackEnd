package com.norjull.EmployeesBackEnd.model;

import java.math.BigDecimal;

public class MonthlySalaryContractEmployee extends Employee {

	private ContractTypeName contractTypeName = ContractTypeName.MONTHLY;

	public MonthlySalaryContractEmployee() {
		super();
	}

	public MonthlySalaryContractEmployee(Integer id, String name, Integer roleId, String roleName,
			String roleDescription, BigDecimal hourlySalary, BigDecimal monthlySalary) {
		super(id, name, roleId, roleName, roleDescription, hourlySalary, monthlySalary);
		this.calculateAnualSalary();
	}

	public ContractTypeName getContractTypeName() {
		return contractTypeName;
	}

	@Override
	public void calculateAnualSalary() {
		this.setAnualSalary(this.getMonthlySalary().multiply(BigDecimal.valueOf(12)));		
	}

}
