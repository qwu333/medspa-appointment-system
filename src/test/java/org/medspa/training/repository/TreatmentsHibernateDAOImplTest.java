package org.medspa.training.repository;

import junit.framework.TestCase;

import org.medspa.training.model.Treatments;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

import static junit.framework.Assert.assertEquals;


public class TreatmentsHibernateDAOImplTest {
    private TreatmentsHibernateDAOImpl treatmentsHibernateDAO;
    private Treatments t1;

    @Before
    public void setup() {
        treatmentsHibernateDAO = new TreatmentsHibernateDAOImpl();
        t1 = new Treatments();
        t1.setId(1);
        t1.setName("m22 ipl");
        t1.setCost(BigDecimal.valueOf(33.99));
        t1.setPrice(BigDecimal.valueOf(99.00));
        t1.setLength(45);
        t1.setTarget("skin redness, scars");
        t1.setNurses("lora, stanley, timo");
        treatmentsHibernateDAO.save(t1);

    }

    @After
    public void tearDown() {
        treatmentsHibernateDAO.delete(t1);
    }

    @Test
    public void getTreatmentsTest() {
        assertEquals(1, treatmentsHibernateDAO.getTreatments().size());
    }
}