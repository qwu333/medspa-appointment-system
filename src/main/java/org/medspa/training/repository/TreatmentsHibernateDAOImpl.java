package org.medspa.training.repository;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.medspa.training.model.Treatments;
import org.medspa.training.util.HibernateUtil;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;


@Repository
public class TreatmentsHibernateDAOImpl implements iTreatmentsDao {
    Logger logger = LoggerFactory.getLogger(TreatmentsHibernateDAOImpl.class);


    @Override
    public void save(Treatments treatments) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Transaction transaction = null;
        try {
            Session session = sessionFactory.openSession();
            transaction = session.beginTransaction();

            session.save(treatments);

            transaction.commit();
            session.close();
        } catch (HibernateException e) {
            if (transaction != null) {
                logger.error("SAVE transaction failed. Rollback");
                transaction.rollback();
            }
            logger.error("Unable to save or unable to close SAVE", e);
        }
    }


    @Override
    public List<Treatments> getTreatments() {


        //prepare data model
        List<Treatments> treatments = new ArrayList<>();

        // create connection
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();


        Session session = null;
        try {
            session = sessionFactory.openSession();

            //execute query
            String hql = "FROM Treatments";
            Query<Treatments> query = session.createQuery(hql);
            treatments = query.list();

            //close

            session.close();


        } catch (HibernateException e) {
            logger.error("Open session exception of lose session exception", e);
            throw e;

        }
        logger.info("Get treatments {}", treatments);
        return treatments;


    }

    @Override
    public Treatments getByTreatmentName(String treatmentName) {
        return null;
    }


    @Override
    public boolean delete(Treatments treatments) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Transaction transaction = null;


        try {
            Session session = sessionFactory.openSession();
            transaction = session.beginTransaction();

            session.delete(treatments);

            transaction.commit();
            session.close();
        } catch (HibernateException e) {
            if (transaction != null) {
                logger.error("Delete transaction failed.Rollback");
                transaction.rollback();
            }
            logger.error("Unable to save or unable to close DELETE", e);
        }
        return false;
    }

    public Treatments getTreatmentsEagerBy(Long id) {
        String hql = "FROM Treatments d LEFT JOIN FETCH d.appointments where d.id = :Id";
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            Query<Treatments> query = session.createQuery(hql);
            query.setParameter("Id", id);
            Treatments result = query.uniqueResult();
            session.close();
            return result;
        } catch (HibernateException e) {
            logger.error("failed to retrieve data record", e);
            session.close();
            return null;
        }
    }
}