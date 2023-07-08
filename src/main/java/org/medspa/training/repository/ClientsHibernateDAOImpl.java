package org.medspa.training.repository;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.medspa.training.model.Clients;
import org.medspa.training.util.HibernateUtil;
import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class ClientsHibernateDAOImpl implements iClientsDao{
    //logger
    Logger logger = LoggerFactory.getLogger(ClientsHibernateDAOImpl.class);


    @Override
    public void save(Clients clients) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Transaction transaction = null;
        try{
            Session session = sessionFactory.openSession();
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
        //prepare data model
        List<Clients> clients = new ArrayList<>();
        //connection to DB
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

        try{
            Session session = sessionFactory.openSession();
            //execute query
            String hql = "FROM Clients";
            Query<Clients> query = session.createQuery(hql);
            clients = query.list();
            // close
            session.close();
        }catch(HibernateException e){
            logger.error("Connection or execution of query failed",e);
        }
        logger.info("get Clients {}",clients);
        return clients;

    }

    @Override
    public Clients getById(Long Id) {
//        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
//        String hql = "FROM Clients ";
//        int deletedCount = 0;
//        try{
//            Session session = sessionFactory.openSession();
//
//            Query<Clients> query = session.createQuery(hql);
//
//        }
    return null;
    }

    @Override
    public void delete(Clients clients) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Transaction transaction = null;

        try{
            Session session = sessionFactory.openSession();
            transaction = session.beginTransaction();

            session.delete(clients);

            transaction.commit();
            session.close();
        }catch (HibernateException e){
            if(transaction != null){
                logger.error("DELETE transaction failed. Rollback.",e);
                transaction.rollback();
            }
            logger.error("unable to save Clients or close session", e);
        }
    }

}
