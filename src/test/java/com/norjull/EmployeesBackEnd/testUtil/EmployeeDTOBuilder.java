package com.norjull.EmployeesBackEnd.testUtil;

import java.math.BigDecimal;

import com.github.javafaker.Faker;
import com.norjull.EmployeesBackEnd.dto.EmployeeDTO;
import com.norjull.EmployeesBackEnd.model.ContractTypeName;

public class EmployeeDTOBuilder {
	
	private Integer id;
	
	private String name;
	
	private String contractTypeName;
	
	private Integer roleId; 
	
	private String roleName;
	
	private String roleDescription;
	
	private BigDecimal  hourlySalary;
	
	private BigDecimal monthlySalary;
	
	Faker faker = new Faker();
	
	public EmployeeDTOBuilder() {
		this.id = faker.number().randomDigit();
		this.name = faker.name().firstName();
		this.contractTypeName = ContractTypeName.HOURLY.getDescription();
		this.roleId = faker.number().randomDigit();
		this.roleDescription = faker.job().position();
		this.hourlySalary = BigDecimal.ONE;
		this.monthlySalary = BigDecimal.TEN;
	}

	public EmployeeDTOBuilder setId(Integer id) {
		this.id = id;
		return this;
	}

	public EmployeeDTOBuilder setName(String name) {
		this.name = name;
		return this;
	}

	public EmployeeDTOBuilder setContractTypeName(String contractTypeName) {
		this.contractTypeName = contractTypeName;
		return this;
	}

	public EmployeeDTOBuilder setRoleId(Integer roleId) {
		this.roleId = roleId;
		return this;
	}

	public EmployeeDTOBuilder setRoleName(String roleName) {
		this.roleName = roleName;
		return this;
	}

	public EmployeeDTOBuilder setRoleDescription(String roleDescription) {
		this.roleDescription = roleDescription;
		return this;
	}

	public EmployeeDTOBuilder setHourlySalary(BigDecimal hourlySalary) {
		this.hourlySalary = hourlySalary;
		return this;
	}

	public EmployeeDTOBuilder setMonthlySalary(BigDecimal monthlySalary) {
		this.monthlySalary = monthlySalary;
		return this;
	}
	
	public EmployeeDTO build() {
		return new EmployeeDTO(id, name, contractTypeName, roleId, roleName, roleDescription, hourlySalary, monthlySalary);
	}
	
}
