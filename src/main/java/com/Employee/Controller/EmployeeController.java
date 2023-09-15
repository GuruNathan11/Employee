package com.Employee.Controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Employee.Model.Employee;
import com.Employee.Repository.EmployeeRepository;
import com.Employee.Service.EmployeeService;

import jakarta.mail.internet.MimeMessage;


@RestController
@RequestMapping("api/employee")
public class EmployeeController {
	
	
//	private final EmployeeService service;
//	public EmployeeController(EmployeeService service)
//	{
//		this.service=service;
//	}
	
	@Autowired
	EmployeeService service;
	
	@Autowired
	JavaMailSender mailSender;
	
	@Autowired
	EmployeeRepository repository;
	
	
	
	@PostMapping("/register")
	public ResponseEntity<?> EmpRegistration (@RequestBody Employee employee)
	{
		confirmationMail(employee.getEmail(), employee.getName());
		
		return ResponseEntity.ok().body(service.registerEmployee(employee));
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<?> updateDetails(@PathVariable String id, @RequestBody Employee employee){
		

		Optional<Employee> empDetails= repository.findById(id);
		if(empDetails.isPresent()) {
			Employee updateEmployee= empDetails.get();
			employee.update(updateEmployee);
			Employee updatedDetails=repository.save(employee);
			return ResponseEntity.ok().body(updatedDetails);
		}else {
			return ResponseEntity.ok().body("Employee id not found");
		}
		
//		return ResponseEntity.ok().body(service.updateDetails(id,employee));
	}

	private void confirmationMail(String email, String name) {
		// TODO Auto-generated method stub
		try {
		
			String subject="Employee Registration";
			String content= "Dear "+name+",<br>"+ "Your Employee Details Registered Successfully";
			
			
			MimeMessage message= mailSender.createMimeMessage();
			MimeMessageHelper helper= new MimeMessageHelper(message,true);
		
			helper.setTo(email);
			helper.setSubject(subject);
			helper.setText(content,true);
			mailSender.send(message);
		
		}catch(Exception e){
			System.out.println("Invalid Mail");
			e.printStackTrace();
		}
		
	}

}
