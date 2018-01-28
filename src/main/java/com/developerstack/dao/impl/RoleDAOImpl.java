package com.developerstack.dao.impl;

import com.developerstack.dao.RoleDao;
import com.developerstack.model.Role;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RoleDAOImpl implements RoleDao {

    @Autowired
    private SessionFactory session;

    @Override
    public boolean add(Role role) {
        session.getCurrentSession().save(role);
        return true;
    }

    @Override
    public boolean edit(Role role) {
        session.getCurrentSession().saveOrUpdate(role);
        return true;
    }

    @Override
    public boolean delete(Integer id) {
        Query query = session.getCurrentSession().createQuery("delete Role where roleID = :id");
        query.setParameter("id", id);
        query.executeUpdate();
        return true;
    }

    @Override
    public Role getRole(Integer id) {
        Role role = (Role) session.getCurrentSession().get(Role.class, id);
        return role;
    }

    @Override
    public Role getRoleByName(String userRole) {
        Role role = (Role) session.getCurrentSession().createQuery("from Role where userRole = :name")
                .setParameter("name", userRole)
                .uniqueResult();
        return role;
    }
}
