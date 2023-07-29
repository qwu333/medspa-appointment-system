package org.medspa.training.repository;

import org.medspa.training.model.Appointments;
import org.medspa.training.model.Clients;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.medspa.training.model.Treatments;
import org.medspa.training.repository.exception.*;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Time;

import static junit.framework.Assert.*;


public class ClientsHibernateDAOImplTest {
    private iClientsDao clientsHibernateDAO;
    private iTreatmentsDao treatmentsHibernateDAO;
    private iAppointmentsDao appointmentsHibernateDAO;
    private Clients c1;
    private Treatments t1;
    private Appointments a1;

    @Before
    public void setup() {
        clientsHibernateDAO = new ClientsHibernateDAOImpl();
        c1 = new Clients();
        c1.setId(1);
        c1.setFirstName("Lora");
        c1.setLastName("Jo");
        c1.setPhoneNumber("4839048765");
        c1.setEmailAddress("jo@gmail.com");
        c1.setAllergies("NA");
        c1.setTargets("acne");
        clientsHibernateDAO.save(c1);

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

        appointmentsHibernateDAO = new AppointmentsHibernateDAOImpl();
        a1 = new Appointments();
        a1.setDate(new Date((2023-1900),(12-1),23));
        a1.setTime(new Time(16,30,00));
        a1.setClient(c1);
        a1.setTreatment(t1);
        appointmentsHibernateDAO.save(a1);

    }

    @After
    public void tearDown(){
      appointmentsHibernateDAO.delete(a1);
      treatmentsHibernateDAO.delete(t1);
      clientsHibernateDAO.delete(c1);
            }

    @Test
    public void getClientsTest(){

        assertEquals(1, clientsHibernateDAO.getClients().size());
    }

    @Test
    public void getClientsEagerByTest(){
        Clients clients = clientsHibernateDAO.getClientsEagerBy(c1.getId());
        assertNotNull(clients);
        assertEquals(clients.getFirstName(),c1.getFirstName());
        assertTrue(clients.getAppointments().size()>0);
    }
}