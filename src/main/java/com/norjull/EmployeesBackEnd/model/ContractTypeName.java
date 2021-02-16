package com.norjull.EmployeesBackEnd.model;

public enum ContractTypeName {
	HOURLY("HourlySalaryEmployee"), MONTHLY("MonthlySalaryEmployee");
	
	private String description;
	
	ContractTypeName(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

}
