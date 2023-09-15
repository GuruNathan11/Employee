package com.Employee.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.Employee.Model.Employee;
import com.Employee.Repository.EmployeeRepository;


@Service
public class EmployeeService {
	
	@Autowired
	EmployeeRepository repository;

	public Employee registerEmployee(Employee employee) {

		return repository.save(employee);
	}

//	public Employee updateDetails(String id, Employee employee) {
//		// TODO Auto-generated method stub
//		
//		return null;
//	}

	

}
