package com.developerstack.service;

import com.developerstack.model.Role;

import java.util.List;

public interface RoleService {

    boolean add(Role role);

    boolean edit(Role role);

    boolean delete(Integer id);

    Role getRole(Integer id);

    Role getRoleByName(String name);

    List<Role> getAllRoles();
}
