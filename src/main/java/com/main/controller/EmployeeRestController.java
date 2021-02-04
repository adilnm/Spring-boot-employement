package com.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.main.dto.EmployeeDTO;
import com.main.service.EmployeeService;

@RestController
@RequestMapping("/v4")
public class EmployeeRestController {

	@Autowired
	private EmployeeService employeeService;

	@GetMapping("/allemployees")
	List<EmployeeDTO> showAllEmployess() {
		return employeeService.findAllEmployees();
	}
}
