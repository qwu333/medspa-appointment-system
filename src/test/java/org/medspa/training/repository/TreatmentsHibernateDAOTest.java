package org.medspa.training.repository;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.medspa.training.model.Treatments;
import org.medspa.training.util.HibernateUtil;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.junit.MockitoJUnitRunner;

import java.math.BigDecimal;
import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.mockito.MockitoAnnotations.initMocks;

@RunWith(MockitoJUnitRunner.class)
public class TreatmentsHibernateDAOTest {
    @Mock
    private SessionFactory mockSessionFactory;

    @Mock
    private Session mockSession;

    @Mock
    private Query mockQuery;

    private iTreatmentsDao treatmentsDao;
    @Before
    public void setup(){
        initMocks(this);
        treatmentsDao = new TreatmentsHibernateDAOImpl();
    }

    @Test
    public void getTreatmentsTest_happyPath(){
        //TreatmentsHibernateDAOImpl treatmentsDao = new TreatmentsHibernateDAOImpl();
        //create a treatment object
        Treatments treatment = new Treatments(1, "m22", BigDecimal.valueOf(33.99), BigDecimal.valueOf(299.99),45,"sensitivity","maria, spongebob");
        List<Treatments> result = List.of(treatment);
        //mock
        try(MockedStatic mockedStatic = mockStatic(HibernateUtil.class)){
            mockedStatic.when(HibernateUtil::getSessionFactory).thenReturn(mockSessionFactory);

            when(mockSessionFactory.openSession()).thenReturn(mockSession);
            when(mockSession.createQuery(any(String.class))).thenReturn(mockQuery);
            when(mockQuery.list()).thenReturn(result);
            doNothing().when(mockSession).close();

            List<Treatments> actualResult = treatmentsDao.getTreatments();
            assertEquals(result, actualResult);
        }
    }

    @Test
    public void getTreatmentsTest_getHibernateException(){
        Treatments treatment = new Treatments(1, "m22", BigDecimal.valueOf(33.99), BigDecimal.valueOf(299.99),45,"sensitivity","maria, spongebob");
        List<Treatments> result = List.of(treatment);
        //mock
        try(MockedStatic mockedStatic = mockStatic(HibernateUtil.class)) {
            mockedStatic.when(HibernateUtil::getSessionFactory).thenReturn(mockSessionFactory);

            when(mockSessionFactory.openSession()).thenReturn(mockSession);
            when(mockSession.createQuery(any(String.class))).thenReturn(mockQuery);
            when(mockQuery.list()).thenReturn(result);
            doThrow(HibernateException.class).when(mockSession).close();

            assertThrows(HibernateException.class,() -> treatmentsDao.getTreatments());

        }
    }
}
