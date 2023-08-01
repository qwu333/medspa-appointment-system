package org.medspa.training.repository;
import org.medspa.training.model.Appointments;
import org.medspa.training.model.Clients;
import org.medspa.training.model.Treatments;
import org.medspa.training.util.HibernateUtil;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.HibernateException;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;


@Repository
public class AppointmentsHibernateDAOImpl implements iAppointmentsDao {
    //logger
    Logger logger = LoggerFactory.getLogger(AppointmentsHibernateDAOImpl.class);

    @Autowired
    private SessionFactory sessionFactory;
    @Override
    public void save(Appointments appointments) {
     //   SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Transaction transaction = null;

        try{
            Session session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.save(appointments);

            transaction.commit();
            session.close();
        }catch (HibernateException e){
            if(transaction != null){
                logger.error("SAVE transaction failed, rollback", e);
                transaction.rollback();
                }
            logger.error("unable to save or close Appointments", e);
            }
        }


    @Override
    public List<Appointments> getAppointments() {
        List<Appointments> appointments = new ArrayList<>();

       // SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();

        try {
            String hql = "FROM Appointments";
            Query<Appointments> query = session.createQuery((hql));
            appointments = query.list();

            session.close();
        } catch (HibernateException e) {
            logger.error("Connection or execution of query failed", e);
            throw e;
        }

        logger.info("get Appointments", appointments);
        return appointments;
    }

    @Override
    public Appointments getById(Long id) {
        Session session = sessionFactory.openSession();
        try {

            //execute query
            String hql = "FROM Appointments a where id = :id";
            Query<Appointments> query = session.createQuery(hql);
            query.setParameter("id", id );
            Appointments result = query.uniqueResult();
            //close

            session.close();
            return result;

        } catch (HibernateException e) {
            logger.error("Open session exception of lose session exception", e);
            session.close();
            return null;

        }
    }


    @Override
    public boolean delete(Appointments appointments) {
        //SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Transaction transaction = null;
        Session session = sessionFactory.openSession();
        try{

            transaction = session.beginTransaction();

            session.delete(appointments);

            transaction.commit();

            session.close();
        }catch (HibernateException e){
            if(transaction != null){
                logger.error("DELETE transaction failed. Rollback", e);
                transaction.rollback();
            }
            logger.error("Unable to delete Appointments or close session", e);
        }
        return false;
    }

    @Override
    public Appointments update(Appointments appointments) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;

        try{
            transaction = session.beginTransaction();
            session.update(appointments);
            transaction.commit();
            Appointments a = getById(appointments.getId());
            session.close();
            return a;
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
