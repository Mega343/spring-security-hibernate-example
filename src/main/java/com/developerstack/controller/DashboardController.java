package com.developerstack.controller;

import com.developerstack.model.Employee;
import com.developerstack.model.Role;
import com.developerstack.service.EmployeeService;
import com.developerstack.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


import java.util.List;

import static com.developerstack.Constants.*;

@Controller
public class DashboardController {

	@Autowired
	private EmployeeService employeeService;
	@Autowired
	private RoleService roleService;


    @RequestMapping(value = "/dashboard", method = RequestMethod.GET)
    public ModelAndView dashboard() throws Exception {
    	ModelAndView model = new ModelAndView();
//    	model.addObject(EMPLOYEES, employeeService.getEmployees());
    	model.setViewName(DASHBOARD);
    	return model;
    }

	@RequestMapping(value = "/office", method = RequestMethod.GET)
	public ModelAndView officeView() {
		ModelAndView model = new ModelAndView();
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String username;
		if (principal instanceof UserDetails) {
			username = ((UserDetails)principal).getUsername();
		} else {
			username = principal.toString();
		}
		Employee employee = employeeService.findEmployeeByLogin(username);
		List<Role> roles = roleService.getAllRoles();
		model.addObject(ROLES, roles);
		model.addObject("selectedRoleId", employee.getRole().getRoleID());
		model.addObject(EMPLOYEE, employee);
		model.setViewName("office");
		return model;
	}

}
