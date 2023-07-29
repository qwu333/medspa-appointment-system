package org.medspa.training;

import org.medspa.training.model.Appointments;
import org.medspa.training.model.Treatments;
import org.medspa.training.model.Clients;
import org.medspa.training.repository.exception.AppointmentsJDBCDaoImpl;
import org.medspa.training.repository.exception.ClientsJDBCDaoImpl;
import org.medspa.training.repository.exception.TreatmentsJDBCDaoImpl;

import java.util.List;
import java.util.Set;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        AppointmentsJDBCDaoImpl appointmentsJDBCDao = new AppointmentsJDBCDaoImpl();
        List<Appointments> appointments = appointmentsJDBCDao.getAppointments();
        System.out.format("List of Appointment %s", appointments.size());

        TreatmentsJDBCDaoImpl treatmentsJDBCDao = new TreatmentsJDBCDaoImpl();
        List<Treatments> treatments = treatmentsJDBCDao.getTreatments();
        System.out.format("List of Treatments %s", treatments.size());

        ClientsJDBCDaoImpl clientsJDBCDao =  new ClientsJDBCDaoImpl();
        List<Clients> clients = clientsJDBCDao.getClients();
        System.out.format("List of Clients %s", clients.size());
    }
}
