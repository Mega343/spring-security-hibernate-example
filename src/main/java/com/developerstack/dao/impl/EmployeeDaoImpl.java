package com.developerstack.dao.impl;

import com.developerstack.dao.EmployeeDao;
import com.developerstack.model.Employee;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EmployeeDaoImpl implements EmployeeDao {

	@Autowired
	private SessionFactory session;

	public List<Employee> getAllEmployees() {
		Criteria criteria = session.openSession().createCriteria(Employee.class);
		return criteria.list();
	}

	public Employee findEmployeeByLogin(String login) {
		Employee employee = null;
		Criteria criteria = session.openSession().createCriteria(Employee.class);
		criteria.add(Restrictions.eq("login", login));
		List<Employee> entityList = criteria.list();
		if(!entityList.isEmpty()) {
			employee = entityList.get(0);
		}
		return employee;
	}

	@Override
	public boolean add(Employee employee) {
		session.getCurrentSession().save(employee);
		return true;
	}

	@Override
	public boolean edit(Employee employee) {
		session.getCurrentSession().merge(employee);
		return false;
	}

	@Override
	public boolean delete(int id) {
		Query query = session.getCurrentSession().createQuery("delete Employee where employeeId = :id");
		query.setParameter("id", id);
		query.executeUpdate();
		return true;
	}

	@Override
	public Employee getEmployee(int id) {
		Employee employee = (Employee) session.getCurrentSession().get(Employee.class, id);
		return employee;
	}

	@Override
	public List<Employee> searchByLastName(String lastName) {
		Query query = session.getCurrentSession().createQuery("from Employee where lastName = :lastName");
		query.setParameter("lastName", lastName);
		List<Employee> employees = query.list();
		return employees;
	}

	@Override
	public List<Employee> searchByLastNameAndFirstName(String lastName, String firstName) {
		Query query = session.getCurrentSession().createQuery("from Employee where lastName = :lastName and firstName = :=firstName");
		query.setParameter("lastName", lastName);
		query.setParameter("firstName", firstName);
		List<Employee> employees = query.list();
		return employees;
	}

	@Override
	public List<Employee> searchByFullName(String lastName, String firstName, String patronymic) {
		Query query = session.getCurrentSession().createQuery("from Employee where lastName = :lastName and firstName = :=firstName and patronymic :=patronymic");
		query.setParameter("lastName", lastName);
		query.setParameter("firstName", firstName);
		query.setParameter("patronymic", patronymic);
		List<Employee> employees = query.list();
		return employees;
	}

	@Override
	public Employee searchByEmail(String email) {
		Criteria criteria = session.getCurrentSession().createCriteria(Employee.class);
		criteria.add(Restrictions.eq("email", email));
		List<Employee> list = criteria.list();
		if (list.isEmpty()) {
			return null;
		}
		return list.get(0);
	}

	@Override
	public List<Employee> searchByPhoneNumber(String phoneNumber) {
		Criteria criteria = session.getCurrentSession().createCriteria(Employee.class);
		criteria.add(Restrictions.eq("phoneNumber", phoneNumber));
		List<Employee> list = criteria.list();
		if (list.isEmpty()) {
			return null;
		}
		return list;
	}
}
