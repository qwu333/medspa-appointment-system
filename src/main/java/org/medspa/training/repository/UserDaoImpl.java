package org.medspa.training.repository;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.medspa.training.model.Treatments;
import org.medspa.training.model.User;
import org.medspa.training.repository.exception.UserNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;


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
    public User getUserById(Long id) {
        Session s = sessionFactory.openSession();
        String hql = "FROM User d where id= :Id";
        try {
            Query<User> query = s.createQuery(hql);
            query.setParameter("Id", id);
            User result = query.uniqueResult();
            s.close();
            return result;
        } catch (HibernateException e) {
            logger.error("Session close exception try again", e);
            s.close();
            return null;
        }
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
            throw new UserNotFoundException("can't find user record with email="+email + ", password="+password);
        }
    }

    @Override
    public List<User> getUser() {
        List<User> user;
        Session session = sessionFactory.openSession();
        try {
            String hql = "FROM User";
            Query<User> query = session.createQuery(hql);
            user = query.list();

            session.close();
        } catch (HibernateException e) {
            logger.error("Open session exception of lose session exception", e);
            throw e;
        }
        logger.info("Get user {}", user);
        return user;
    }
}
