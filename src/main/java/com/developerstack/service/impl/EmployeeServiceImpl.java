package com.developerstack.service.impl;

import com.developerstack.dao.EmployeeDao;
import com.developerstack.model.Employee;
import com.developerstack.service.EmployeeService;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {


    @Autowired
    private EmployeeDao employeeDao;

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

    @Override
    public Employee findEmployeeByLogin(String login) {
        return employeeDao.findEmployeeByLogin(login);
    }

    @Override
    public List<Employee> getEmployees() {
        return employeeDao.getAllEmployees();
    }

}
