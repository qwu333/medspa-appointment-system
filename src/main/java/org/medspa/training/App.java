package org.example;

import org.medspa.training.model.Appointments;
import org.medspa.training.repository.AppointmentsJDBCDaoImpl;

import java.util.List;
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
        System.out.format("List of Appointment %s", appointments);

    }
}
