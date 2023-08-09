package org.medspa.training.service;

import org.medspa.training.model.Treatments;
import org.medspa.training.model.User;
import org.medspa.training.repository.iUserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private iUserDao userDao;

    public List<User> getUser() { return userDao.getUser();}


    public User getUserByCredentials(String email, String password) throws Exception{
        return userDao.getUserByCredentials(email, password);
    }

}
