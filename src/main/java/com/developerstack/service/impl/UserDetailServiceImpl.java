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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Component(value = "userDetailService")
public class UserDetailServiceImpl implements UserDetailsService {
	
	@Autowired
	private EmployeeDao employeeDao;

	public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
		com.developerstack.model.Employee employee = employeeDao.findEmployeeByLogin(login);
		if(employee == null){
			throw new UsernameNotFoundException("Invalid username or password.");
		}
		return new org.springframework.security.core.userdetails.User(employee.getLogin(), employee.getPassword(), getAuthority(employee));
	}

	private List<SimpleGrantedAuthority> getAuthority(Employee employee) {
		return Arrays.asList(new SimpleGrantedAuthority("ROLE_" + employee.getRole().getUserRole()));
	}

}
