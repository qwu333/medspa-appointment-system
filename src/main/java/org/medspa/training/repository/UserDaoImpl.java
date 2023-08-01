package org.medspa.training.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.medspa.training.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;


@Repository
public class UserDaoImpl implements iUserDao{
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public boolean save(User user){
        return false;
    }

    @Override
    public User getUserByEmail(String email) {
        return null;
    }


    @Override
    public User getUserById(Long id){
        return null;
    }

    @Override
    public User getUserByCredentials(String email, String password) throws Exception{
        String hql = "FROM User as u where lower(u.email) = :email and u.password = :password";
        logger.info(String.format("User email: %s, password: %s", email, password));

        try {
            Session session = sessionFactory.openSession();
            Query<User> query = session.createQuery(hql);
            query.setParameter("email", email.toLowerCase().trim());
            query.setParameter("password", password);
            return query.uniqueResult();
        } catch (Exception e) {
            logger.error("error: {}", e.getMessage());
            throw new Exception("can't find user record with email="+email + ", password="+password);
        }
    }
}
