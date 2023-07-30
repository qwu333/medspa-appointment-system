package org.medspa.training.repository;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.medspa.training.model.Clients;
import org.medspa.training.model.Treatments;
import org.medspa.training.repository.exception.ClientsHibernateDAOImpl;
import org.medspa.training.repository.exception.TreatmentsHibernateDAOImpl;
import org.medspa.training.repository.exception.iClientsDao;
import org.medspa.training.repository.exception.iTreatmentsDao;
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
public class ClientsHibernateDAOTest {
    @Mock
    private SessionFactory mockSessionFactory;

    @Mock
    private Session mockSession;

    @Mock
    private Query mockQuery;

    private iClientsDao clientsDao;
    @Before
    public void setup(){
        initMocks(this);
        clientsDao = new ClientsHibernateDAOImpl();
    }

    @Test
    public void getClientsTest_happyPath(){
        //create a treatment object
        Clients client = new Clients(1, "m22", "ff2", "5421365474","2154.35434","na","nose,eye");
        List<Clients> result = List.of(client);
        //mock
        try(MockedStatic mockedStatic = mockStatic(HibernateUtil.class)){
            mockedStatic.when(HibernateUtil::getSessionFactory).thenReturn(mockSessionFactory);

            when(mockSessionFactory.openSession()).thenReturn(mockSession);
            when(mockSession.createQuery(any(String.class))).thenReturn(mockQuery);
            when(mockQuery.list()).thenReturn(result);
            doNothing().when(mockSession).close();

            List<Clients> actualResult = clientsDao.getClients();
            assertEquals(result, actualResult);
        }
    }

    @Test
    public void getClientsTest_getHibernateException(){
        Clients client = new Clients(1, "m22", "ff2", "5421365474","2154.35434","na","nose,eye");
        List<Clients> result = List.of(client);
        //mock
        try(MockedStatic mockedStatic = mockStatic(HibernateUtil.class)){
            mockedStatic.when(HibernateUtil::getSessionFactory).thenReturn(mockSessionFactory);

            when(mockSessionFactory.openSession()).thenReturn(mockSession);
            when(mockSession.createQuery(any(String.class))).thenReturn(mockQuery);
            when(mockQuery.list()).thenReturn(result);
            doThrow(HibernateException.class).when(mockSession).close();

            assertThrows(HibernateException.class,() -> clientsDao.getClients());

        }
    }
}
