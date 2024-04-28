package com.example.demo.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.service.EmployeeService;


@RestController
@RequestMapping("/employee")
public class EmployeeController {
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping
	public Iterable<Employee> getEmployees()
	{
		return employeeRepository.findAll();
	}
	
	@PostMapping
	public Employee createRecord(@RequestBody Employee employee)
	{
		return employeeRepository.save(employee);
	}
	
	@DeleteMapping("/{employeeId}")
	public String deleteRecord(@PathVariable("employeeId") Integer employeeId)
	{
		Optional<Employee>  employeeOptional=employeeRepository.findById(employeeId);
		Employee result=employeeOptional.get();
		employeeRepository.deleteById(employeeId);
		return "The employee data deleted successfully.\nName: "+result.getFirstName()+" "+result.getLastName();
		
	}
	@GetMapping("/{employeeId}")
	public Optional<Employee> fetchEditRecord(@PathVariable("employeeId") Integer employeeId)
	{
		return employeeRepository.findById(employeeId);
	}
//	@PutMapping("/{id}")
//	public Employee editRecord(@PathVariable("id") int id, @RequestBody Employee employee)
//	{
////		int id1=employee.getEmployeeId();
////				fetchEditRecord(id)
//		deleteRecord(id);
//		
//		return repository.save(employee);
//	}
	@PutMapping("/{employeeId}")
    public ResponseEntity<Void> updateEmployeeDetails(@PathVariable Integer employeeId, @RequestBody Employee updatedEmployee) {
        try {
            employeeService.updateEmployeeDetails(employeeId, updatedEmployee);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
	}
}
