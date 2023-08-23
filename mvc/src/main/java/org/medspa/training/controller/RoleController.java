package org.medspa.training.controller;

import org.medspa.training.model.Role;
import org.medspa.training.service.RoleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/role")
public class RoleController {
    private final Logger logger = LoggerFactory.getLogger(RoleController.class);

    @Autowired
    private RoleService roleService;
    @RequestMapping(value="", method= RequestMethod.POST)
    public void create(@RequestBody Role role){
        logger.info("Post a new role {}", role.getName());
        roleService.save(role);

    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<Role> getRole(){
        List<Role> role = roleService.getRole();
        return role;
    }
}
