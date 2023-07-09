package org.medspa.training.repository;
import org.medspa.training.model.Appointments;
import org.medspa.training.util.HibernateUtil;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.HibernateException;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.ArrayList;

public class AppointmentsHibernateDAOImpl implements iAppointmentsDao{
    //logger
    Logger logger = LoggerFactory.getLogger(AppointmentsHibernateDAOImpl.class);

    @Override
    public void save(Appointments appointments) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
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

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

        try{
            Session session = sessionFactory.openSession();

            String hql = "FROM Appointments";
            Query<Appointments> query = session.createQuery((hql));
            appointments = query.list();

            session.close();
        }catch(HibernateException e){
            logger.error("Connection or execution of query failed", e);
        }

        logger.info("get Appointments", appointments);
        return appointments;
    }

    @Override
    public Appointments getByClient(long clientId) {
        return null;
    }

    @Override
    public void delete(Appointments appointments) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Transaction transaction = null;
        try{
            Session session = sessionFactory.openSession();
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
    }
}
