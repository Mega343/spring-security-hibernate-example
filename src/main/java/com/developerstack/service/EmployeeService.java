package com.developerstack.service;

import com.developerstack.model.Employee;

import java.util.List;

public interface EmployeeService {

	boolean add(Employee employee);

	boolean edit(Employee employee);

	boolean delete(int id);

	Employee getEmployee(int id);

	List<Employee> searchEmployee(String inputData);
	
	List<Employee> getEmployees();

}
