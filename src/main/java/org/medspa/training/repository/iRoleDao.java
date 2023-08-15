package org.medspa.training.repository;

import org.medspa.training.model.Role;

import java.util.List;

public interface iRoleDao {
    void save(Role role);

    List<Role> getRole();

    boolean delete(Role role);

    Role update(Role role);

    Role getById(Long Id);

    Role getRoleByName(String name);

}
