package com.developerstack.dao;

import com.developerstack.model.Role;

import java.util.List;

public interface RoleDao {

    boolean add(Role role);

    boolean edit(Role role);

    boolean delete(Integer id);

    Role getRole(Integer id);

    Role getRoleByName(String name);

    List<Role> getAllRoles();
}
