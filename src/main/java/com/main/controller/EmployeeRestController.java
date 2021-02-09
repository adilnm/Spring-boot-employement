package com.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

	@GetMapping("/employee/{id}")
	EmployeeDTO showEmployee(@PathVariable("id") int employeeId) {
		return employeeService.show(employeeId);
	}

	@DeleteMapping("/employee/{id}")
	String deleteEmployee(@PathVariable("id") int employeeId) {
		employeeService.delete(employeeId);
		return "Your employee got deleted";
	}

	@PostMapping("/employee")
	void register(@RequestBody EmployeeDTO employee) {

		employeeService.register(employee);

	}

}
