package com.main.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.main.dto.EmployeeDTO;
import com.main.service.EmployeeService;

@Controller
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;

	@GetMapping("/login")
	String showLoginPage() {
		return "login";
	}

	@PostMapping("/authenticate")
	String authenticateEmployee(@RequestParam String emailId, @RequestParam String password, Model model,
			HttpSession session) {
		EmployeeDTO employeeDTO = employeeService.authenticate(emailId, password);
		if (employeeDTO != null) {

			session.setAttribute("emp", employeeDTO);
			System.out.println(session.getAttribute("emp"));
			model.addAttribute("employee", employeeDTO);
			return "showEmployee";

		} else {
			model.addAttribute("msg", "Wrong credential..");
			return "login";
		}
	}

	@GetMapping("/showEmployees")
	String showAllEmployess(Model model, HttpSession session) {
//		if (session.getAttribute("emp") == null) {
//			return "login";
//		}
		List<EmployeeDTO> employeesList = employeeService.findAllEmployees();
		model.addAttribute("employeesList", employeesList);

		return "showAllEmployees";
	}

	@GetMapping("/forgotpassword")
	String forgotpassword() {
		return "forgetPassword";
	}

	@PostMapping("/forget")
	String forgetEmail(@RequestParam String emailId, Model model) {
		EmployeeDTO employeeDTO = employeeService.forget(emailId);
		if (employeeDTO != null) {
			model.addAttribute("password", employeeDTO.getPassword());
		} else {
			model.addAttribute("Wrong", "This email does not exist");
		}
		return "forgetPassword";

	}

	@GetMapping("/register")
	String register(HttpSession session) {
		return "register";
	}

}
