package org.medspa.training.controller;

import org.medspa.training.model.Role;
import org.medspa.training.model.User;
import org.medspa.training.service.JWTService;
import org.medspa.training.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;


@RestController
@RequestMapping(value = "/auth")
public class AuthController {
    private final Logger logger = LoggerFactory.getLogger(AuthController.class);
    @Autowired
    private JWTService jwtService;
    @Autowired
    private UserService userService;

    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity userLogin(@RequestBody User user){
        try {
            User u = userService.getUserByCredentials(user.getEmail(),user.getPassword());
            if(u == null){
                return ResponseEntity.status(HttpServletResponse.SC_UNAUTHORIZED).build();
            }
            return ResponseEntity.ok().body(jwtService.generateToken(u));
        }catch(Exception e){
            e.printStackTrace();
        }
        return ResponseEntity.badRequest().build();
    }

    @RequestMapping(value="", method = RequestMethod.GET)
    public ResponseEntity<List<User>> getUser(){
        List<User> user = userService.getUser();
        return new ResponseEntity<>(user,HttpStatus.OK);
    }


    }



