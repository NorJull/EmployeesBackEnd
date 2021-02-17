package com.norjull.EmployeesBackEnd.model;

import java.math.BigDecimal;

public abstract class Employee {

	private Integer id;
	
	private String name;
	
	private Integer roleId; 
	
	private String roleName;
	
	private String roleDescription;
	
	private BigDecimal  hourlySalary;
	
	private BigDecimal monthlySalary;

	private BigDecimal anualSalary;
	
	public Employee() {
		super();
	}
	
	public Employee(Integer id, String name, Integer roleId, String roleName, String roleDescription,
			BigDecimal hourlySalary, BigDecimal monthlySalary) {
		super();
		this.id = id;
		this.name = name;
		this.roleId = roleId;
		this.roleName = roleName;
		this.roleDescription = roleDescription;
		this.hourlySalary = hourlySalary;
		this.monthlySalary = monthlySalary;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getRoleDescription() {
		return roleDescription;
	}

	public void setRoleDescription(String roleDescription) {
		this.roleDescription = roleDescription;
	}

	public BigDecimal getHourlySalary() {
		return hourlySalary;
	}

	public void setHourlySalary(BigDecimal hourlySalary) {
		this.hourlySalary = hourlySalary;
	}

	public BigDecimal getMonthlySalary() {
		return monthlySalary;
	}

	public void setMonthlySalary(BigDecimal monthlySalary) {
		this.monthlySalary = monthlySalary;
	}

	public BigDecimal getAnualSalary() {
		return anualSalary;
	}

	public void setAnualSalary(BigDecimal anualSalary) {
		this.anualSalary = anualSalary;
	}

	/**
	 * This method calculates the salary of the employee depending on the type of contract.
	 * This operation perform in O(1).
	 */
	public abstract void calculateAnualSalary();
	
}
