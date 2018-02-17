package com.developerstack.dao.impl;

import com.developerstack.dao.EmployeeDao;
import com.developerstack.model.Employee;
import org.hibernate.*;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {

    @Autowired
    private SessionFactory sessionFactory;

    public List<Employee> getAllEmployees() {
        Session session = null;
        List<Employee> employees = new ArrayList<>();
        try {
            session = sessionFactory.openSession();
            employees = session.createCriteria(Employee.class).list();
        } catch (Exception e) {

        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return employees;
    }

    public Employee findEmployeeByLogin(String login) {
        List<Employee> employees;
        Employee employee = new Employee();
        Session session = null;
        try {
            session = sessionFactory.openSession();
            Query query = session.createQuery("from Employee where login = :login");
            query.setParameter("login", login);
            employees = query.list();
            if (!employees.isEmpty()) {
                employee = employees.get(0);
            }
        } catch (Exception e) {

        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }

        return employee;
    }

    @Override
    public boolean add(Employee employee) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.save(employee);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null)
            transaction.rollback();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return true;
    }

    @Override
    public boolean edit(Employee employee) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.merge(employee);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new RuntimeException(e);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return false;
    }

    @Override
    public boolean delete(int id) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            Query query = session.createQuery("delete Employee where employeeId = :id");
            query.setParameter("id", id);
            query.executeUpdate();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null)
            transaction.rollback();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return true;
    }

    @Override
    public Employee getEmployee(int id) {
        Session session = null;
        Employee employee = new Employee();
        try {
            session = sessionFactory.openSession();
            employee = (Employee) session.get(Employee.class, id);
        } catch (Exception e) {

        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return employee;
    }

    @Override
    public List<Employee> searchByLastName(String lastName) {
        List<Employee> employees = new ArrayList<>();
        Session session = null;
        try {
            session = sessionFactory.openSession();

            Query query = session.createQuery("from Employee where lastName = :lastName");
            query.setParameter("lastName", lastName);
            employees = query.list();
        } catch (Exception e) {

        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return employees;
    }

    @Override
    public List<Employee> searchByLastNameAndFirstName(String lastName, String firstName) {
        List<Employee> employees = new ArrayList<>();
        Session session = null;
        try {
            session = sessionFactory.openSession();
            Query query = session.createQuery("from Employee where lastName = :lastName and firstName = :firstName");
            query.setParameter("lastName", lastName);
            query.setParameter("firstName", firstName);
            employees = query.list();
        } catch (Exception e) {

        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return employees;
    }

    @Override
    public List<Employee> searchByFullName(String lastName, String firstName, String patronymic) {
        List<Employee> employees = new ArrayList<>();
        Session session = null;
        try {
            session = sessionFactory.openSession();
            Query query = session.createQuery("from Employee where lastName = :lastName and firstName = :firstName and patronymic = :patronymic");
            query.setParameter("lastName", lastName);
            query.setParameter("firstName", firstName);
            query.setParameter("patronymic", patronymic);
            employees = query.list();
        } catch (Exception e) {

        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return employees;
    }

    @Override
    public Employee searchByEmail(String email) {
        Session session = null;
        Employee employee = new Employee();
        try {
            session = sessionFactory.openSession();
            Criteria criteria = session.createCriteria(Employee.class);
            criteria.add(Restrictions.eq("email", email));
            List<Employee> list = criteria.list();
            if (!list.isEmpty()) {
                employee = list.get(0);
            }
        } catch (Exception e) {

        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return employee;
    }

    @Override
    public List<Employee> searchByPhoneNumber(String phoneNumber) {
        List<Employee> employees = new ArrayList<>();
        Session session = null;
        try {
            session = sessionFactory.openSession();
            Criteria criteria = session.createCriteria(Employee.class);
            criteria.add(Restrictions.eq("phoneNumber", phoneNumber));
            employees = criteria.list();
            if (employees.isEmpty()) {
                return null;
            }
        } catch (Exception e) {

        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return employees;
    }
}
