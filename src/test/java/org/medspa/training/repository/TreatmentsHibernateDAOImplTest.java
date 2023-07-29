package org.medspa.training.repository;

import org.junit.After;
import org.medspa.training.model.Appointments;
import org.medspa.training.model.Clients;
import org.medspa.training.model.Treatments;
import org.junit.Before;
import org.junit.Test;
import org.medspa.training.repository.exception.*;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Time;

import static junit.framework.Assert.*;


public class TreatmentsHibernateDAOImplTest {
    private iTreatmentsDao treatmentsHibernateDAO;
    private iAppointmentsDao appointmentsHibernateDAO;
    private iClientsDao clientsHibernateDAO;
    private Treatments t1;
    private Appointments a1;
    private Clients c1;


    @Before
    public void setup() {
        treatmentsHibernateDAO = new TreatmentsHibernateDAOImpl();
        t1 = new Treatments();
        t1.setId(1);
        t1.setTreatmentName("m22 ipl");
        t1.setCost(BigDecimal.valueOf(33.99));
        t1.setPrice(BigDecimal.valueOf(99.00));
        t1.setLength(45);
        t1.setTarget("skin redness, scars");
        t1.setNurses("lora, stanley, timo");
        treatmentsHibernateDAO.save(t1);

        clientsHibernateDAO = new ClientsHibernateDAOImpl();
        c1 = new Clients();
        c1.setTargets("pimpo");
        c1.setAllergies("na");
        c1.setEmailAddress("jdks");
        c1.setLastName("mm");
        c1.setPhoneNumber("2029383765");
        c1.setFirstName("jj");
        clientsHibernateDAO.save(c1);

        appointmentsHibernateDAO = new AppointmentsHibernateDAOImpl();
        a1 = new Appointments();
        a1.setDate(new Date((2023-1900),(12-1),23));
        a1.setTime(new Time(16,30,00));
        a1.setClient(c1);
        a1.setTreatment(t1);
        appointmentsHibernateDAO.save(a1);


    }

    @After
    public void tearDown() {
        appointmentsHibernateDAO.delete(a1);
        treatmentsHibernateDAO.delete(t1);
        clientsHibernateDAO.delete(c1);

    }

    @Test
    public void getTreatmentsTest() {
        assertEquals(1, treatmentsHibernateDAO.getTreatments().size());
    }

    @Test
    public void getTreatmentsEagerByTest(){
        Treatments treatments = treatmentsHibernateDAO.getTreatmentsEagerBy(t1.getId());
        assertNotNull(treatments);
        assertEquals(treatments.getTreatmentName(),t1.getTreatmentName());
        assertTrue(treatments.getAppointments().size()>0);
    }
}