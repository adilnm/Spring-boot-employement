package com.main.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
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

	@GetMapping("/logout")
	String logout(HttpSession session) {

		if (session.getAttribute("emp") != null) {
			session.invalidate();
		}
		return "login";
	}

	@GetMapping("/showEmployees")
	String showAllEmployess(Model model, HttpSession session) {
		if (session.getAttribute("emp") == null) {
			return "login";
		}
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

	@PostMapping("/registerEmployee")
	// @ModelAttribute create an object and assign its attributes based on the
	// registration form and then save it in the model
	String employeeRegistration(@ModelAttribute("employee") EmployeeDTO employee, Model model, HttpSession session) {

		boolean success = employeeService.register(employee);
		if (success) {
			return "redirect:/showEmployees";

		} else {
			model.addAttribute("msg", "Wrong credential..");
			return "register";
		}
	}

	@PostMapping("/search")
	String searchEmployee(@RequestParam String searchKey, Model model, HttpSession session) {
		if (session.getAttribute("emp") == null) {
			return "login";
		}
		System.out.println(searchKey);
		List<EmployeeDTO> employeeList = employeeService.search(searchKey);
		model.addAttribute("employeesList", employeeList);

		return "showAllEmployees";
	}

	@GetMapping("/edit")
	String edit(@RequestParam int employee_id, Model model, HttpSession session) {
		if (session.getAttribute("emp") == null) {
			return "login";
		}
		EmployeeDTO employeeDTO = employeeService.show(employee_id);
		model.addAttribute("employee", employeeDTO);
		return "edit";
	}

	@PostMapping("/update")
	String employeeUpdate(@RequestParam int employeeId, @RequestParam String empName, @RequestParam String emailId,
			@RequestParam String password, @RequestParam int salary, Model model, HttpSession session) {

		boolean success = employeeService.update(employeeId, empName, emailId, password, salary);

		if (success) {
			return "redirect:/showEmployees";
		}
		model.addAttribute("msg", "Wrong credential..");
		return "edit";

	}

	@GetMapping("/delete")
	String employeeDelete(@RequestParam int employee_id, Model model, HttpSession session) {
		if (session.getAttribute("emp") == null) {
			return "login";
		}
		employeeService.delete(employee_id);
		return "redirect:/showEmployees";

	}

	@GetMapping("/nameasc")
	String nameAsc(Model model, HttpSession session) {
		if (session.getAttribute("emp") == null) {
			return "login";
		}
		List<EmployeeDTO> employeesList = employeeService.sortAsc();
		model.addAttribute("employeesList", employeesList);

		return "showAllEmployees";
	}

	@GetMapping("/namedesc")
	String nameDesc(Model model, HttpSession session) {
		if (session.getAttribute("emp") == null) {
			return "login";
		}
		List<EmployeeDTO> employeesList = employeeService.sortDesc();
		model.addAttribute("employeesList", employeesList);

		return "showAllEmployees";
	}

	@GetMapping("/emailasc")
	String emailAsc(Model model, HttpSession session) {
		if (session.getAttribute("emp") == null) {
			return "login";
		}
		List<EmployeeDTO> employeesList = employeeService.sortEmailAsc();
		model.addAttribute("employeesList", employeesList);

		return "showAllEmployees";
	}

	@GetMapping("/emaildesc")
	String emailDesc(Model model, HttpSession session) {
		if (session.getAttribute("emp") == null) {
			return "login";
		}
		List<EmployeeDTO> employeesList = employeeService.sortEmailDesc();
		model.addAttribute("employeesList", employeesList);

		return "showAllEmployees";
	}

}
