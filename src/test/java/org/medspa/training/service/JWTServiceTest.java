package org.medspa.training.service;

import io.jsonwebtoken.Claims;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.medspa.training.ApplicationBootstrap;
import org.medspa.training.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ApplicationBootstrap.class)
public class JWTServiceTest {

    @Autowired
    private JWTService jwtService;

    @Test
    public void generateTokenTest(){
        User u = new User();
        u.setId(1);
        u.setName("Amy");
        String token = jwtService.generateToken(u);
        String[] array = token.split("\\.");
        boolean bool = array.length == 3 ? true: false;
        assertTrue(bool);
    }

    @Test
    public void decryptTokenTest(){
        User u = new User();
        u.setId(1);
        u.setName("Amy");
        String token = jwtService.generateToken(u);
        Claims c = jwtService.decryptToken(token);
        String userName = c.getSubject();
        String userId = c.getId();

        assertEquals(u.getName(),userName);
        assertEquals(String.valueOf(u.getId()),userId);
    }


}
