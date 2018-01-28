package com.developerstack.dao;

import com.developerstack.model.Role;

public interface RoleDao {

    boolean add(Role role);

    boolean edit(Role role);

    boolean delete(Integer id);

    Role getRole(Integer id);

    Role getRoleByName(String name);

}
