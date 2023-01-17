package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.entities.Customer;
import com.example.demo.repositories.CustomerRepository;

@Controller
public class CustomersController {
	
	@Autowired
	private CustomerRepository customerRepository;

	@GetMapping("/home")
	public String getHome() {
		return "index";
	}

	@GetMapping("/login")
	public String getLogin() {
		return "login";
	}

	@GetMapping("/hello")
	public String getHello() {
		return "hello";
	}

	@GetMapping("/customers/list")
	public ModelAndView CustomersList(Model model, Pageable pageable){		
		ModelAndView mav = new ModelAndView("customers");
		mav.addObject("customers", customerRepository.findAll(pageable));
		return mav;
	}

	@GetMapping({"/customer/form", "/customer/form/{id}"})
	public ModelAndView updateCustomer(@PathVariable(required=false) Integer id) {
		ModelAndView mav = new ModelAndView("customer");
		if ( id == null ) {
			mav.addObject("customer", new Customer());			
		}else {
			mav.addObject("customer", customerRepository.findById(id));
		}
		return mav;
	}
	
	@GetMapping("/customer/delete/{id}")
	public String deleteCustomer(@RequestParam Integer id) {
		customerRepository.deleteById(id);
		return "redirect:/customers";
	}

}
