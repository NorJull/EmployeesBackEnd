package com.norjull.EmployeesBackEnd.dto;

import java.math.BigDecimal;

public class EmployeeDTO {

	private Integer id;
	
	private String name;
	
	private String contractTypeName;
	
	private Integer roleId; 
	
	private String roleName;
	
	private String roleDescription;
	
	private BigDecimal  hourlySalary;
	
	private BigDecimal monthlySalary;

	public EmployeeDTO() {
		super();
	}

	public EmployeeDTO(Integer id, String name, String contractTypeName, Integer roleId, String roleName,
			String roleDescription, BigDecimal hourlySalary, BigDecimal monthlySalary) {
		super();
		this.id = id;
		this.name = name;
		this.contractTypeName = contractTypeName;
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

	public String getContractTypeName() {
		return contractTypeName;
	}

	public void setContractTypeName(String contractTypeName) {
		this.contractTypeName = contractTypeName;
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

	@Override
	public String toString() {
		return "EmployeeDTO [id=" + id + ", name=" + name + ", contractTypeName=" + contractTypeName + ", roleId="
				+ roleId + ", roleName=" + roleName + ", roleDescription=" + roleDescription + ", hourlySalary="
				+ hourlySalary + ", monthlySalary=" + monthlySalary + "]";
	}
	
	
}
