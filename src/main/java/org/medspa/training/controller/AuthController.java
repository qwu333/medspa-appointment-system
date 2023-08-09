package org.medspa.training.controller;

import org.medspa.training.model.User;
import org.medspa.training.service.JWTService;
import org.medspa.training.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/auth")
public class AuthController {

    @Autowired
    private JWTService jwtService;
    @Autowired
    private UserService userService;

    @RequestMapping(value = "", method = RequestMethod.POST)
    public String userLogin(@RequestBody User user) throws Exception {
        try {
            User u = userService.getUserByCredentials(user.getEmail(),user.getPassword());
            return jwtService.generateToken(user);
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping(value="", method = RequestMethod.GET)
    public List<User> getUser(){
        List<User> user = UserService.getUser();
        return user;
    }
}
