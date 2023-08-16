package org.medspa.training.controller;

import org.medspa.training.model.User;
import org.medspa.training.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/user")
public class UserController {
    private final Logger logger = LoggerFactory.getLogger(UserController.class);
    @Autowired
    private UserService userService;

    @RequestMapping(value = "", method = RequestMethod.POST)
    public void create(@RequestBody User user) {
        logger.info("New User Registered {}", user.getEmail());
        userService.save(user);
    }
    @RequestMapping(value="", method = RequestMethod.GET)
    public List<User> getUser(){
        List<User> user = userService.getUser();
        return user;
    }

}
