package com.developerstack.service.impl;

import com.developerstack.dao.RoleDao;
import com.developerstack.model.Role;
import com.developerstack.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleDao roleDao;

    @Override
    public boolean add(Role role) {
        roleDao.add(role);
        return true;
    }

    @Override
    public boolean edit(Role role) {
        roleDao.edit(role);
        return true;
    }

    @Override
    public boolean delete(Integer id) {
        roleDao.delete(id);
        return true;
    }

    @Override
    public Role getRole(Integer id) {
        return roleDao.getRole(id);
    }

    @Override
    public Role getRoleByName(String name) {
        return roleDao.getRoleByName(name);
    }

    @Override
    public List<Role> getAllRoles() {
        return roleDao.getAllRoles();
    }
}
