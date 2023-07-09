package org.medspa.training.repository;
import org.checkerframework.checker.units.qual.A;
import org.medspa.training.model.Appointments;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.sql.Date;
import java.sql.Time;

import static junit.framework.Assert.assertEquals;
public class AppointmentsHibernateDAOImplTest {

    private AppointmentsHibernateDAOImpl appointmentsHibernateDAO;
    private Appointments a1;

    @Before
    public void setup(){
        appointmentsHibernateDAO = new AppointmentsHibernateDAOImpl();
        a1 = new Appointments();
        a1.setId(1);
        a1.setTreatment(14);
        a1.setClientId(10);
        a1.setDate(new Date(1688874279));
        a1.setTime(new Time(16,30,00));
        appointmentsHibernateDAO.save(a1);
    }

    @After
    public void tearDown(){
        appointmentsHibernateDAO.delete(a1);
    }

    @Test
    public void getAppointmentsTest(){
        assertEquals(1, appointmentsHibernateDAO.getAppointments().size());
    }
}
