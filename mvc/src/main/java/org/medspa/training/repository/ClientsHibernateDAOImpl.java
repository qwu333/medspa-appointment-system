package org.medspa.training.repository;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.medspa.training.model.Clients;
import org.medspa.training.model.Treatments;
import org.medspa.training.util.HibernateUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ClientsHibernateDAOImpl implements iClientsDao {
    //logger
    Logger logger = LoggerFactory.getLogger(ClientsHibernateDAOImpl.class);

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void save(Clients clients) {
        //SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Transaction transaction = null;
        Session session = sessionFactory.openSession();
        try{
            transaction = session.beginTransaction();
            session.save(clients);

            transaction.commit();
            session.close();
        }catch (HibernateException e){
            if(transaction != null){
                logger.error("SAVE transaction failed. Rollback.", e);
                transaction.rollback();
            }
            logger.error("unable to save or close Clients", e);
        }

    }

    @Override
    public List<Clients> getClients() {

        List<Clients> clients;

        Session session = sessionFactory.openSession();
        try {

            String hql = "FROM Clients";
            Query<Clients> query = session.createQuery(hql);
            clients = query.list();

            session.close();
        } catch (HibernateException e) {
            logger.error("Connection or execution of query failed", e);
            throw e;
        }
        logger.info("get Clients {}", clients);
        return clients;

    }

    @Override
    public Clients getById(Long id) {
        Session session = sessionFactory.openSession();
        try {

            String hql = "FROM Clients c where id = :id";
            Query<Clients> query = session.createQuery(hql);
            query.setParameter("id", id );
            Clients result = query.uniqueResult();

            session.close();
            return result;

        } catch (HibernateException e) {
            logger.error("Open session exception of lose session exception", e);
            session.close();
            return null;

        }
    }



    @Override
    public boolean delete(Clients clients) {
        Transaction transaction = null;
        Session session = sessionFactory.openSession();
        try{
            transaction = session.beginTransaction();

            session.delete(clients);

            transaction.commit();
            session.close();
        }catch (HibernateException e){
            if(transaction != null){
                logger.error("DELETE transaction failed. Rollback.",e);
                transaction.rollback();
            }
            logger.error("unable to delete Clients or close session", e);
        }
        return false;
    }

    @Override
    public Clients getClientsEagerBy(Long id) {
        String hql = "FROM Clients d LEFT JOIN FETCH d.appointments where d.id = :Id";
        Session session = HibernateUtil.getSessionFactory().openSession();
        try{
            Query<Clients> query = session.createQuery(hql);
            query.setParameter("Id",id);
            Clients result = query.uniqueResult();
            session.close();
            return result;
        }catch(HibernateException e){
            logger.error("failed to retrieve data record", e);
            session.close();
            return null;
        }
    }

    @Override
    public Clients update(Clients clients) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;

        try{
            transaction = session.beginTransaction();
            session.update(clients);
            transaction.commit();
            Clients c = getById(clients.getId());
            session.close();
            return c;
        } catch (HibernateException e){
            if(transaction !=null) {
                transaction.rollback();
            }
            logger.error("failed to insert record" , e);
            session.close();
            return null;
        }
    }
    }

