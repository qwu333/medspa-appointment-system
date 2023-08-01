package org.medspa.training.repository;

import org.medspa.training.model.User;

public interface iUserDao {
    boolean save(User user);
    User getUserByEmail(String email);
    User getUserById(Long id);
    User getUserByCredentials(String email, String password) throws Exception;
}
