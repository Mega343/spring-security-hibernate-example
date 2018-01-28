package com.developerstack.service;

import com.developerstack.model.Role;

public interface RoleService {

    boolean add(Role role);

    boolean edit(Role role);

    boolean delete(Integer id);

    Role getRole(Integer id);

    Role getRoleByName(String name);
}
