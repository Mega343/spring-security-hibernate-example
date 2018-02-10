package com.developerstack.service.impl;

import com.developerstack.dao.EmployeeDao;
import com.developerstack.model.Employee;
import com.developerstack.service.EmployeeService;
import org.apache.commons.lang3.math.NumberUtils;
import org.hibernate.ObjectNotFoundException;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Component(value = "userDetailService")
//@Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = {ObjectNotFoundException.class,
//		ConstraintViolationException.class})
public class UserDetailServiceImpl implements UserDetailsService, EmployeeService {
	
	@Autowired
	private EmployeeDao employeeDao;

	public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
		com.developerstack.model.Employee employee = employeeDao.findEmployeeByLogin(login);
		if(employee == null){
			throw new UsernameNotFoundException("Invalid username or password.");
		}
		return new org.springframework.security.core.userdetails.User(String.valueOf(employee.getEmployeeId()), employee.getPassword(), getAuthority());
	}

	private List<SimpleGrantedAuthority> getAuthority() {
		return Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"));
	}

	@Override
	public boolean add(Employee employee) {
		employeeDao.add(employee);
		return true;
	}

	@Override
	public boolean edit(Employee employee) {
		employeeDao.edit(employee);
		return true;
	}

	@Override
	public boolean delete(int id) {
		employeeDao.delete(id);
		return true;
	}

	@Override
	public Employee getEmployee(int id) {
		return employeeDao.getEmployee(id);
	}

	@Override
	public List<Employee> searchEmployee(String input) {
		List<Employee> result = new ArrayList<>();
		if (input.isEmpty()) {
			return result;
		}
		if (input.contains("@")) {
			Employee employee = employeeDao.searchByEmail(input);
			result.add(employee);
		}
		if (NumberUtils.isDigits(input)) {
			result = employeeDao.searchByPhoneNumber(input);
		} else {
			String[] searchCriteria = input.split(" ");
			if (searchCriteria.length == 1) {
				result = employeeDao.searchByLastName(searchCriteria[0]);
			} else if (searchCriteria.length == 2) {
				result = employeeDao.searchByLastNameAndFirstName(searchCriteria[0], searchCriteria[1]);
			} else if (searchCriteria.length == 3) {
				result = employeeDao.searchByFullName(searchCriteria[0], searchCriteria[1], searchCriteria[2]);
			}
		}
		return result;
	}

	public List<com.developerstack.model.Employee> getEmployees() {
		return employeeDao.getAllEmployees();
	}

}
