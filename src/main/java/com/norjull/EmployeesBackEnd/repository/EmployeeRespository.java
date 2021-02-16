package com.norjull.EmployeesBackEnd.repository;



import com.norjull.EmployeesBackEnd.dto.EmployeeDTO;

import io.vavr.collection.List;
import io.vavr.control.Option;

public interface EmployeeRespository {
	
	public EmployeeDTO getEmployeeDTO(Integer id);
	
	public List<EmployeeDTO> getEmployeeDTOs();

}
