package com.main.service;

import java.util.List;

import com.main.dto.EmployeeDTO;

public interface EmployeeService {

	EmployeeDTO authenticate(String emailId, String password);

	List<EmployeeDTO> findAllEmployees();

	EmployeeDTO forget(String emailId);

}
