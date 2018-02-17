package com.developerstack.controller;

import com.developerstack.model.Ads;
import com.developerstack.model.Employee;
import com.developerstack.service.AdsService;
import com.developerstack.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


import java.util.Collections;
import java.util.List;

import static com.developerstack.Constants.*;

@Controller
public class DashboardController {

	@Autowired
	private EmployeeService employeeService;
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	private AdsService adsService;


    @RequestMapping(value = "/dashboard", method = RequestMethod.GET)
    public ModelAndView dashboard() throws Exception {
    	ModelAndView model = new ModelAndView();
		List<Ads> adsList = adsService.findAllAds();
		Collections.reverse(adsList);
		model.addObject("adsList", adsList);
		model.setViewName(DASHBOARD);

    	return model;
    }

    @RequestMapping(value = "/activate_user", method = RequestMethod.GET)
    public ModelAndView activateUser() throws Exception {
    	ModelAndView model = new ModelAndView();
		model.setViewName("activate_user");
    	return model;
    }

    @RequestMapping(value = "/activate_user", method = RequestMethod.POST)
    public ModelAndView verifyIsUserExistInSystem(@RequestParam("lastName") String lastName,
												  @RequestParam("firstName") String firstName)  {
		ModelAndView model = new ModelAndView();
		List<Employee> employees = employeeService.searchEmployee(lastName + " " + firstName);
		if (employees.isEmpty()) {
			model.addObject(ERROR, "В системе нет пользователя с такой фамилией и именем. Проверьте свой ввод или обратитесь к администратору.");
			model.setViewName("activate_user");
			return model;
		}
		if (employees.get(0).isActivated()) {
			model.addObject(ERROR, "Пользователь уже активирован. Войдите в систему используя свой логин и пароль.");
			model.setViewName("activate_user");
			return model;
		}

		else {
			model.addObject("firstName", firstName);
			model.addObject("lastName", lastName);
			model.addObject("employeeId", employees.get(0).getEmployeeId());
			model.setViewName("activate_user_step_2");

			return model;
		}

    }

    @RequestMapping(value = "/activate_user_full_data", method = RequestMethod.POST)
    public ModelAndView verifyIsUserExistInSystem(@RequestParam("phoneNumber") String phoneNumber,
												  @RequestParam("dateOfBirth") String dateOfBirth,
												  @RequestParam("employeeId") String employeeId)
	{
		ModelAndView model = new ModelAndView();
		Employee employee = employeeService.getEmployee(Integer.parseInt(employeeId));
		if (employee.getPhoneNumber().equals(phoneNumber) && employee.getDateOfBirth().equals(dateOfBirth) ) {
			model.addObject(EMPLOYEE, employee);
			model.setViewName("registration");
			return model;
		} else {
			model.addObject("firstName", employee.getFirstName());
			model.addObject("lastName", employee.getLastName());
			model.addObject("employeeId", employee.getEmployeeId());
			model.addObject(ERROR, "Неверно введены телефон и/или дата рождения. Проверьте Ваш ввод или обратитесь к администратору");
			model.setViewName("activate_user_step_2");

			return model;
		}
    }

    @RequestMapping(value = "/activate", method = RequestMethod.POST)
    public ModelAndView activateUserInSystem(@RequestParam("login") String login,
											 @RequestParam("password") String password,
											 @RequestParam("confirmPassword") String confirmPassword,
											 @RequestParam("employeeId") String employeeId)
	{
		ModelAndView model = new ModelAndView();
		Employee employee = employeeService.getEmployee(Integer.parseInt(employeeId));
		if (!password.equals(confirmPassword)) {
			model.addObject(ERROR, "Пароли не совпадают!");
			model.addObject(EMPLOYEE, employee);
			model.setViewName("registration");
			return model;
		}

		if (password.length() < 5) {
			model.addObject(ERROR, "Пароль доджен содержать минимум 5 символов!");
			model.addObject(EMPLOYEE, employee);
			model.setViewName("registration");
			return model;
		}

		try {
			employee.setLogin(login);
			employee.setPassword(passwordEncoder.encode(password));
			employee.setActivated(true);
			employeeService.edit(employee);
			model.addObject(INFORMATION_MESSAGE, "Вы успешно активированы в системе. Теперь Вы можете зайти используя логин и пароль");
			model.setViewName("login");

			return model;
		} catch (Exception e) {
			model.addObject(ERROR, "Логин уже занят, попробуйте другой!");
			model.addObject(EMPLOYEE, employee);
			model.setViewName("registration");
			return model;
		}

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
		model.addObject(EMPLOYEE, employee);
		model.setViewName(OFFICE);
		return model;
	}

	@RequestMapping(value = "/update_employee", method = RequestMethod.POST)
	public ModelAndView updatePatient(@ModelAttribute(EMPLOYEE) Employee employee,
									  @RequestParam("oldPassword") String oldPassword,
									  @RequestParam("newPassword") String newPassword,
									  @RequestParam("confirmPassword") String confirmPassword) {
		ModelAndView model = new ModelAndView();
		Employee currentEmployee = employeeService.getEmployee(employee.getEmployeeId());
    	if (!newPassword.equals(confirmPassword)) {
			model.addObject(ERROR, "Новый пароль и пароль подтверждения не совпадают!");
			model.addObject(EMPLOYEE, currentEmployee);
			model.setViewName(OFFICE);
			return model;
		}
		if (!passwordEncoder.matches(oldPassword, currentEmployee.getPassword())) {
			model.addObject(ERROR, "Текущий пароль введен не верно!");
			model.addObject(EMPLOYEE, currentEmployee);
			model.setViewName(OFFICE);
			return model;
		}
		if (newPassword.length() < 5) {
			model.addObject(ERROR, "Пароль доджен содержать минимум 5 символов!");
			model.addObject(EMPLOYEE, currentEmployee);
			model.setViewName(OFFICE);
			return model;
		}

		try {
			employee.setRole(currentEmployee.getRole());
			employee.setPassword(passwordEncoder.encode(newPassword));
			employee.setActivated(currentEmployee.isActivated());
			employeeService.edit(employee);
			model.addObject(INFORMATION_MESSAGE, "Персональная информация успешно обновлена");
			model.setViewName(DASHBOARD);
		} catch (Exception e) {
			model.setViewName(DASHBOARD);
		}

		return model;
	}
}
