package com.developerstack.controller;


import com.developerstack.model.*;
import com.developerstack.service.EmployeeService;
import com.developerstack.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.stream.Collectors;

import static com.developerstack.Constants.*;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private RoleService roleService;

    @RequestMapping(value = "/employees", method = RequestMethod.GET)
    public ModelAndView dashboard() throws Exception {
        ModelAndView model = new ModelAndView();
        model.addObject(EMPLOYEES, employeeService.getEmployees());
        model.setViewName("employees");
        return model;
    }

    @RequestMapping(value = "/remove_employee", method = RequestMethod.GET)
    public ModelAndView removeEmployee(@RequestParam("employee_id") String employeeId) {
        ModelAndView model = new ModelAndView();
        try {
            int employeeID = Integer.parseInt(employeeId);
            Employee employee = employeeService.getEmployee(employeeID);
            if (!ADMIN_ROLE.equals(employee.getRole().getUserRole())) {
                employeeService.delete(employeeID);
            }
        } catch (Exception e) {
            model.addObject(ERROR, "Что-то сломалось. Попробуйте чуть позже");
        }
        model.setViewName("redirect:" + "/employees");
        return model;
    }

    @RequestMapping(value = "/edit_employee", method = RequestMethod.GET)
    public ModelAndView editEmployee(@RequestParam("employee_id") String employeeId) {
        ModelAndView model = new ModelAndView();
        try {
            int employeeID = Integer.parseInt(employeeId);
            Employee employee = employeeService.getEmployee(employeeID);
            model.addObject(EMPLOYEE, employee);
            model.addObject(ROLES, roleService.getAllRoles());
            model.addObject("selectedRoleId", employee.getRole().getRoleID());
            model.setViewName("editEmployee");
        } catch (Exception e) {
            model.addObject(ERROR, "Что-то сломалось. Попробуйте чуть позже");
        }

        return model;
    }

    @RequestMapping(value = "/update_employee", method = RequestMethod.POST)
    public ModelAndView updatePatient(@ModelAttribute(EMPLOYEE) Employee employee) {
        ModelAndView model = new ModelAndView();
        try {
            Employee oldEmployeeData = employeeService.getEmployee(employee.getEmployeeId());
            employee.setActivated(oldEmployeeData.isActivated());
            employee.setPassword(oldEmployeeData.getPassword());
            employeeService.edit(employee);
        } catch (Exception e) {
            model.setViewName(DASHBOARD);
        }
        model.setViewName("redirect:" + "/employees");
        return model;
    }

    @RequestMapping(value = "/add_employee", method = RequestMethod.GET)
    public ModelAndView employeeAddView() {
        ModelAndView model = new ModelAndView();
        List<Role> roles = roleService.getAllRoles();
        model.addObject(ROLES, roles);
        model.setViewName("addEmployee");
        return model;
    }

    @RequestMapping(value = "/add_employee", method = RequestMethod.POST)
    public ModelAndView employeeAdd(@ModelAttribute(EMPLOYEE) Employee employee) {
        ModelAndView model = new ModelAndView();
        try {
            employeeService.add(employee);
        } catch (Exception e) {
            model.setViewName(DASHBOARD);
        }
        model.setViewName("redirect:" + "/employees");
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