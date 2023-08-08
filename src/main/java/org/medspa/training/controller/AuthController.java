package org.medspa.training.controller;


import org.apache.commons.codec.digest.DigestUtils;
import org.medspa.training.model.User;
import org.medspa.training.service.JWTService;
import org.medspa.training.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/auth")
public class AuthController {

    @Autowired
    private JWTService jwtService;
    @Autowired
    private UserService userService;

    @RequestMapping(value = "", method = RequestMethod.POST)
    public String userLogin(@RequestParam("email") String email, @RequestParam("password") String password) throws Exception {
        try {
            String digestPassword = DigestUtils.md5Hex(password.trim());
            User user = userService.getUserByCredentials(email, password);
            return jwtService.generateToken(user);
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
