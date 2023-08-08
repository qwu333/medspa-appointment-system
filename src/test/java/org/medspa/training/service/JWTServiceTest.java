package org.medspa.training.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.medspa.training.ApplicationBootstrap;
import org.medspa.training.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ApplicationBootstrap.class)
public class JWTServiceTest {

    @Autowired
    private JWTService jwtService;

    @Test
    public void generateTokenTest(){
        User u = new User(roles);
        u.setId(1);
        u.setName("Amy");
        String token = jwtService.generateToken(u);
        String[] array = token.split("\\.");
        boolean bool = array.length == 3 ? true: false;
        assertTrue(bool);
    }
}
