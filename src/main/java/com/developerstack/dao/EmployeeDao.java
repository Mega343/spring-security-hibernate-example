package com.developerstack.dao;

import com.developerstack.model.Employee;

import java.util.List;

public interface EmployeeDao {
	
	List<Employee> getAllEmployees();

	Employee findEmployeeByLogin(String login);

	boolean add(Employee employee);

	boolean edit(Employee employee);

	boolean delete(int id);

	Employee getEmployee(int id);

	List<Employee> searchByLastName(String lastName);

	List<Employee> searchByLastNameAndFirstName(String lastName, String firstName);

	List<Employee> searchByFullName(String lastName, String firstName, String patronymic);

	Employee searchByEmail(String email);

	List<Employee> searchByPhoneNumber(String phoneNumber);

}
