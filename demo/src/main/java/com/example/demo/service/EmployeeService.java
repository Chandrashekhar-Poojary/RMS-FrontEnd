package com.example.demo.service;

import java.lang.reflect.Field;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;

@Service
public class EmployeeService {
	@Autowired
    private EmployeeRepository employeeRepository;
	
    public void updateEmployeeDetails(Integer employeeId, Employee updatedEmployee) {
        Optional<Employee> optionalEmployee = employeeRepository.findById(employeeId);
        if (optionalEmployee.isPresent()) {
            Employee existingEmployee = optionalEmployee.get();
            //this method is optional
            updateFields(existingEmployee, updatedEmployee);
            // Compare existing employee details with updated employee details
//            if (!existingEmployee.getFirstName().equals(updatedEmployee.getFirstName())) {
//                existingEmployee.setFirstName(updatedEmployee.getFirstName());
//            }
            existingEmployee.setFirstName(updatedEmployee.getFirstName());
            existingEmployee.setLastName(updatedEmployee.getLastName());
            existingEmployee.setEmail(updatedEmployee.getEmail());
            existingEmployee.setPhoneNumber(updatedEmployee.getPhoneNumber());
            existingEmployee.setAddress(updatedEmployee.getAddress());
            existingEmployee.setCity(updatedEmployee.getCity());
            existingEmployee.setState(updatedEmployee.getState());
            existingEmployee.setZipcode(updatedEmployee.getZipcode());
            existingEmployee.setCountry(updatedEmployee.getCountry());
            existingEmployee.setPan_no(updatedEmployee.getPan_no());
            existingEmployee.setPassword(updatedEmployee.getPassword());
            
            
            // Update the employee details in the database
            employeeRepository.save(existingEmployee);
        } else {
            throw new RuntimeException("Employee not found with ID: " + employeeId);
        }
    }
        private void updateFields(Employee existingEmployee, Employee updatedEmployee) {
            Class<? extends Employee> employeeClass = updatedEmployee.getClass();
            Field[] fields = employeeClass.getDeclaredFields();
            for (Field field : fields) {
                field.setAccessible(true);
                try {
                    Object newValue = field.get(updatedEmployee);
                    if (newValue != null) {
                        field.set(existingEmployee, newValue);
                    }
                } catch (IllegalAccessException e) {
                    e.printStackTrace(); // Handle the exception as needed
                }
            }
    }
}
