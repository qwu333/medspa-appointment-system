package org.medspa.training.repository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;
public class TreatmentsJDBCDaoImplTest {
    TreatmentsJDBCDaoImpl treatmentsJDBCDao;
    @Before
    public void setup(){
        treatmentsJDBCDao = new TreatmentsJDBCDaoImpl();
    }
    @After
    public void teardown(){
        treatmentsJDBCDao = null;
    }
    //CRUD
    @Test
    public void getTreatmentsTest() {
        //TreatmentsJDBCDaoImpl treatmentsJDBCDao = new TreatmentsJDBCDaoImpl();
        assertEquals(0, treatmentsJDBCDao.getTreatments().size());
    }

    @Test
    public void createTreatmentsTest(){
        assertTrue(treatmentsJDBCDao.getTreatments().isEmpty());
    }

    @Test
    public void updateTreatmentsTest(){}

    @Test
    public void deleteTreatmentsTest(){}
}
