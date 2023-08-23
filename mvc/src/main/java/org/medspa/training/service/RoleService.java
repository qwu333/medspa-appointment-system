package org.medspa.training.service;

import org.medspa.training.model.Role;
import org.medspa.training.repository.iRoleDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {
    @Autowired
    private iRoleDao roleDao;

    public List<Role> getRole(){
        return roleDao.getRole();
    }

    public Role getRoleByName(String name)throws Exception{
        return roleDao.getRoleByName(name);
    }

    public void save(Role role) {
        roleDao.save(role);
    }
}
