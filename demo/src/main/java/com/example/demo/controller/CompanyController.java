package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Company;
import com.example.demo.repository.CompanyRepository;
import com.example.demo.service.CompanyService;

@RestController
public class CompanyController {

	@Autowired
	private CompanyService companyService;
	
	@Autowired
	CompanyRepository companyRepository;
//	
//	@GetMapping("/company")
//	public Company getDetails() {
//		return company;
//	}

	@PostMapping("/addCompany")
	public Company addEmp(@RequestBody Company company) {
//		Company comp= company;
		companyService.addEmp(company);
		return company;
	}
	
	
}
