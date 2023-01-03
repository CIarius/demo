package com.example.demo;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
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
	public ModelAndView Customers(Model model, 
	@RequestParam("page") Optional<Integer> page, 
	@RequestParam("size") Optional<Integer> size,
	@RequestParam("sort") Optional<String> sort,
	@RequestParam("dir") Optional<Sort.Direction> dir){
		int currentPage = page.orElse(0);
		int pageSize = size.orElse(10);
		String sortColumn = sort.orElse("customerId");
		Sort.Direction sortDirection = dir.orElse(Sort.Direction.ASC);
		ModelAndView mav = new ModelAndView("customers");
		mav.addObject("customers", customerRepository.findAll(PageRequest.of(currentPage, pageSize).withSort(Sort.by(sortDirection, sortColumn))));
		return mav;
	}

}
