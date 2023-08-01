package org.medspa.training.service;

import org.medspa.training.model.User;
import org.medspa.training.repository.iUserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private iUserDao userDao;

    public User getUserByCredentials(String email, String password) throws Exception{
        return userDao.getUserByCredentials(email, password);
    }
}
