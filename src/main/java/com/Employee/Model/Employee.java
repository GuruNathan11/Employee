package com.Employee.Model;

import org.springframework.data.annotation.Id;

public class Employee {
	
	@Id
	private String id;
	private String name;
	private String empId;
	private String role;
	private String email;
	private String mobileNo;
	private String address;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmpId() {
		return empId;
	}
	public void setEmpId(String empId) {
		this.empId = empId;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Employee(String id,String name, String empId, String role, String email, String mobileNo, String address) {
		super();
		this.id=id;
		this.name = name;
		this.empId = empId;
		this.role = role;
		this.email = email;
		this.mobileNo = mobileNo;
		this.address = address;
	}
	public void update(Employee employee) {
		this.setId(employee.getId());
		this.setEmpId(employee.getEmpId());
		this.setName(employee.getName());
		this.setEmail(employee.getEmail());
		this.setMobileNo(employee.getMobileNo());
		this.setRole(employee.getRole());
		this.setAddress(employee.getAddress());
	}
	public static Employee build(String id,String name, String empId, String role, String email, String mobileNo, String address) {
		
		return new Employee(id,name, empId, role, email, mobileNo, address);
	}
	
}
