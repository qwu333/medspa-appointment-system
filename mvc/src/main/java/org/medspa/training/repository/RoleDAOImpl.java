package org.medspa.training.repository;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.medspa.training.model.Role;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RoleDAOImpl implements iRoleDao{
    Logger logger = LoggerFactory.getLogger(RoleDAOImpl.class);
    @Autowired
    private SessionFactory sessionFactory;
    @Override
    public void save(Role role) {
        Transaction transaction = null;
        Session session = sessionFactory.openSession();

        try{
            transaction = session.beginTransaction();
            session.save(role);
            transaction.commit();
            session.close();
        }catch(HibernateException e){
            if(transaction != null){
                logger.error("SAVE transaction failed. Rollback.");
                transaction.rollback();
            }
            logger.error("Unable to save or unable to close SAVE",e);
        }
    }

    @Override
    public List<Role> getRole() {
        List<Role> role;
        Session session = sessionFactory.openSession();
        try{
            String hql = "FROM Role";
            Query<Role> query = session.createQuery(hql);
            role = query.list();
            session.close();
        }catch (HibernateException e){
            logger.error("Open session exception of lose session exception", e);
            throw e;
        }
        logger.info("Get role {}", role);
        return role;
    }

    @Override
    public boolean delete(Role role) {
        return false;
    }

    @Override
    public Role update(Role role) {
        return null;
    }

    @Override
    public Role getById(Long Id) {
        return null;
    }

    @Override
    public Role getRoleByName(String name) {
        Session session = sessionFactory.openSession();
        try{
            String hql = "From Role r where name = :name";
            Query<Role> query = session.createQuery(hql);
            query.setParameter("name", name);
            Role result = query.uniqueResult();
            session.close();
            return result;
        }catch(HibernateException e){
            logger.error("Open session exception of lose session exception", e);
            session.close();
            return null;
        }
    }
}
