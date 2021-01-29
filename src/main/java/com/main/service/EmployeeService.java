package com.main.service;

import java.util.List;

import com.main.dto.EmployeeDTO;

public interface EmployeeService {

	EmployeeDTO authenticate(String emailId, String password);

	List<EmployeeDTO> findAllEmployees();

	EmployeeDTO forget(String emailId);

	List<EmployeeDTO> search(String employeeName);

	boolean register(EmployeeDTO employeeDto);

	EmployeeDTO show(int employee_id);

	boolean update(int employeeId, String empName, String emailId, String password, int salary);

	void delete(int employee_id);

	List<EmployeeDTO> sortAsc();

	List<EmployeeDTO> sortDesc();

	List<EmployeeDTO> sortEmailAsc();

	List<EmployeeDTO> sortEmailDesc();

}
