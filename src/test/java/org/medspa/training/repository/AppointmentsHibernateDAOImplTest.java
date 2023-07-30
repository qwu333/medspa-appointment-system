package org.medspa.training.repository;
import org.junit.runner.RunWith;
import org.medspa.training.ApplicationBootstrap;
import org.medspa.training.model.Appointments;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.medspa.training.model.Clients;
import org.medspa.training.model.Treatments;
import org.medspa.training.repository.exception.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Time;

import static junit.framework.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ApplicationBootstrap.class)
public class AppointmentsHibernateDAOImplTest {

    @Autowired
    private iAppointmentsDao appointmentsHibernateDAO;

    @Autowired
    private iClientsDao clientsHibernateDAO;

    @Autowired
    private iTreatmentsDao treatmentsHibernateDAO;
    private Appointments a1;
    private Appointments a2;
    private Appointments a3;
    private Clients c1;
    private Clients c2;
    private Treatments t1;
    private Treatments t2;

    @Before
    public void setup(){

      //  clientsHibernateDAO = new ClientsHibernateDAOImpl();
        c1 = new Clients();
        c1.setTargets("pimpo");
        c1.setAllergies("na");
        c1.setEmailAddress("jdks");
        c1.setLastName("mm");
        c1.setPhoneNumber("2029383765");
        c1.setFirstName("jj");
        clientsHibernateDAO.save(c1);


        c2 = new Clients();
        c2.setTargets("ss");
        c2.setAllergies("er");
        c2.setEmailAddress("oooo");
        c2.setLastName("maa");
        c2.setPhoneNumber("2156231565");
        c2.setFirstName("qq");
        clientsHibernateDAO.save(c2);

      //  treatmentsHibernateDAO = new TreatmentsHibernateDAOImpl();
        t1= new Treatments();
        t1.setTreatmentName("skin");
        t1.setCost(BigDecimal.valueOf(99.00));
        t1.setPrice(BigDecimal.valueOf(100));
        t1.setLength(35);
        t1.setTarget("sssss");
        t1.setNurses("l222");
        treatmentsHibernateDAO.save(t1);


        t2= new Treatments();
        t2.setTreatmentName("m22 ipl");
        t2.setCost(BigDecimal.valueOf(33.99));
        t2.setPrice(BigDecimal.valueOf(99.00));
        t2.setLength(45);
        t2.setTarget("skin redness, scars");
        t2.setNurses("lora, stanley, timo");
        treatmentsHibernateDAO.save(t2);

      //  appointmentsHibernateDAO = new AppointmentsHibernateDAOImpl();
        a1 = new Appointments();
        a1.setDate(new Date((2023-1900),(12-1),23));
        a1.setTime(new Time(16,30,00));
        a1.setClient(c1);
        a1.setTreatment(t1);
        appointmentsHibernateDAO.save(a1);


        a2 = new Appointments();
        a2.setDate(new Date((2023-1900),(12-1),24));
        a2.setTime(new Time(16,30,00));
        a2.setClient(c1);
        a2.setTreatment(t2);
        appointmentsHibernateDAO.save(a2);

        a3 = new Appointments();
        a3.setDate(new Date((2023-1900),(12-1),25));
        a3.setTime(new Time(16,30,00));
        a3.setClient(c2);
        a3.setTreatment(t1);
        appointmentsHibernateDAO.save(a3);
    }

   @After
   public void tearDown(){
       appointmentsHibernateDAO.delete(a1);
       appointmentsHibernateDAO.delete(a2);
       appointmentsHibernateDAO.delete(a3);
        treatmentsHibernateDAO.delete(t1);
       treatmentsHibernateDAO.delete(t2);
        clientsHibernateDAO.delete(c1);
       clientsHibernateDAO.delete(c2);
    }

    @Test
    public void getAppointmentsTest(){
        assertEquals(3, appointmentsHibernateDAO.getAppointments().size());
    }


}
