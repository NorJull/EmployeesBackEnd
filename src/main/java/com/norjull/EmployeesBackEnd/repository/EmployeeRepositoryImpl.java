package com.norjull.EmployeesBackEnd.repository;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import com.norjull.EmployeesBackEnd.dto.EmployeeDTO;

import io.vavr.collection.List;
import io.vavr.control.Option;

@Repository
public class EmployeeRepositoryImpl implements EmployeeRespository {

	@Autowired
	RestTemplate restTemplate;

	public final static String EMPLOYEES_URL = "http://masglobaltestapi.azurewebsites.net/api/employees";

	@Override
	public EmployeeDTO getEmployeeDTO(final Integer id) {

		ResponseEntity<EmployeeDTO[]> response = restTemplate.getForEntity(EMPLOYEES_URL, EmployeeDTO[].class);

		EmployeeDTO[] employeeDTOs = response.getBody();

		List<EmployeeDTO> vrvaEmployessDTOs = List.ofAll(Arrays.asList(employeeDTOs));

		return vrvaEmployessDTOs.find(empl -> empl.getId() == id).get();
	}

	@Override
	public List<EmployeeDTO> getEmployeeDTOs() {

		ResponseEntity<EmployeeDTO[]> response = restTemplate.getForEntity(EMPLOYEES_URL, EmployeeDTO[].class);

		EmployeeDTO[] employeeDTOs = response.getBody();

		return List.ofAll(Arrays.asList(employeeDTOs));
	}

}
