package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.example.demo.entities.Employee;
import com.example.demo.repositories.DepartmentRepository;
import com.example.demo.repositories.EmployeeRepository;
import com.example.demo.repositories.GenderRepository;
import com.example.demo.repositories.TitleRepository;

@Controller
public class EmployeesController {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private TitleRepository titleRepository;
	
	@Autowired
	private GenderRepository genderRepository;

	@Autowired
	private DepartmentRepository departmentRepository;

	@GetMapping("/employees")
	public Iterable<Employee> employees() {
		return employeeRepository.findAll();
	}

	@GetMapping("/employees/list")
	public ModelAndView employeeList(Pageable pageable) {
		ModelAndView modelAndView = new ModelAndView("employees");
		modelAndView.addObject("employees", employeeRepository.findAll(pageable));
		return modelAndView;
	}
	
	@GetMapping({"/employee/form/{id}", "/employee/form"})
	public ModelAndView employeeUpdate(@PathVariable(required=false) Integer id) {
		
		ModelAndView modelAndView = new ModelAndView("employee");
		
		// populate drop downs in form: title, gender, department, role, shift
		
		modelAndView.addObject("titles", titleRepository.findAll());

		modelAndView.addObject("genders", genderRepository.findAll());
		
		modelAndView.addObject("departments", departmentRepository.findAll());

		if ( id == null ) {
			modelAndView.addObject("employee", new Employee());			
		}else {
			modelAndView.addObject("employee", employeeRepository.findById(id));
		}
		
		return modelAndView;
		
	}

	@PostMapping("/employee/update")
	public RedirectView employeeUpdate(Employee employee) {
		employeeRepository.save(employee);
		return new RedirectView("/employee/list");		
	}

	@GetMapping("/employee/delete/{id}")
	public RedirectView employeeDelete(@PathVariable Integer id) {
		//employeeRepository.deleteById(id);
		System.out.println("deleting id = " + id);
		return new RedirectView("/employee/list");				
	}

}
