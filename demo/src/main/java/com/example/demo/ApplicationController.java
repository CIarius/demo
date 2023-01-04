package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ApplicationController {
	
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
	
	@GetMapping("/customers")
	public ModelAndView Customers(Model model, Pageable pageable){		
		ModelAndView mav = new ModelAndView("customers");
		mav.addObject("customers", customerRepository.findAll(pageable));
		return mav;
	}

}
