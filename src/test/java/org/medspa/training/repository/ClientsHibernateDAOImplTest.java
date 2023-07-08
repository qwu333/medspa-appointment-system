package org.medspa.training.repository;

import junit.framework.TestCase;

import org.medspa.training.model.Clients;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;


public class ClientsHibernateDAOImplTest {
    private ClientsHibernateDAOImpl clientsHibernateDAO;
    private Clients c1;

    @Before
    public void setup() {
        clientsHibernateDAO = new ClientsHibernateDAOImpl();
        c1 = new Clients();
        c1.setId(1);
        c1.setFirstName("Lora");
        c1.setLastName("Jo");
        c1.setPhoneNumber(839048765);
        c1.setEmailAddress("jo@gmail.com");
        c1.setAllergies("NA");
        c1.setTargets("acne");
        clientsHibernateDAO.save(c1);

    }

    @After
    public void tearDown(){
      clientsHibernateDAO.delete(c1);
  }

    @Test
    public void getClientsTest(){

        assertEquals(1, clientsHibernateDAO.getClients().size());
    }
}