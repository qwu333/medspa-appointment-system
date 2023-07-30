package org.medspa.training.repository;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.medspa.training.model.Appointments;
import org.medspa.training.model.Clients;
import org.medspa.training.repository.exception.AppointmentsHibernateDAOImpl;
import org.medspa.training.repository.exception.ClientsHibernateDAOImpl;
import org.medspa.training.repository.exception.iAppointmentsDao;
import org.medspa.training.repository.exception.iClientsDao;
import org.medspa.training.util.HibernateUtil;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.junit.MockitoJUnitRunner;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.mockito.MockitoAnnotations.initMocks;

@RunWith(MockitoJUnitRunner.class)
public class AppointmentsHibernateDAOTest {
    @Mock
    private SessionFactory mockSessionFactory;

    @Mock
    private Session mockSession;

    @Mock
    private Query mockQuery;

    private iAppointmentsDao appointmentsDao;
    @Before
    public void setup(){
        initMocks(this);
        appointmentsDao = new AppointmentsHibernateDAOImpl();
    }

    @Test
    public void getAppointmentTest_happyPath(){
        //create a treatment object
        Appointments appointment = new Appointments(new Date(123,11,9), new Time(16,22,00));
        List<Appointments> result = List.of(appointment);
        //mock
        try(MockedStatic mockedStatic = mockStatic(HibernateUtil.class)){
            mockedStatic.when(HibernateUtil::getSessionFactory).thenReturn(mockSessionFactory);

            when(mockSessionFactory.openSession()).thenReturn(mockSession);
            when(mockSession.createQuery(any(String.class))).thenReturn(mockQuery);
            when(mockQuery.list()).thenReturn(result);
            doNothing().when(mockSession).close();

            List<Appointments> actualResult = appointmentsDao.getAppointments();
            assertEquals(result, actualResult);
        }
    }

    @Test
    public void getAppointmentsTest_getHibernateException(){
        Appointments appointment = new Appointments(new Date(123,11,9), new Time(16,22,00));
        List<Appointments> result = List.of(appointment);
        //mock
        try(MockedStatic mockedStatic = mockStatic(HibernateUtil.class)){
            mockedStatic.when(HibernateUtil::getSessionFactory).thenReturn(mockSessionFactory);

            when(mockSessionFactory.openSession()).thenReturn(mockSession);
            when(mockSession.createQuery(any(String.class))).thenReturn(mockQuery);
            when(mockQuery.list()).thenReturn(result);
            doThrow(HibernateException.class).when(mockSession).close();

            assertThrows(HibernateException.class,() -> appointmentsDao.getAppointments());

        }
    }
}
