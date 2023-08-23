package org.medspa.training.service;

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

    public User getUserById(Long id) throws Exception{
        return userDao.getUserById(id);
    }

    public User getBy(long id) { return userDao.getUserById(id);}

    public void create(User user) {
        userDao.save(user);
    }
}
