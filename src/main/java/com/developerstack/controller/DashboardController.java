package com.developerstack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.developerstack.service.EmployeeService;

@Controller
public class DashboardController {
	
	@Autowired
	private EmployeeService userService;

    @RequestMapping(value = "/dashboard", method = RequestMethod.GET)
    public ModelAndView dashboard() throws Exception {
    	ModelAndView model = new ModelAndView();
    	model.addObject("employees", userService.getEmployees());
    	model.setViewName("dashboard");
    	return model;
    }

}
