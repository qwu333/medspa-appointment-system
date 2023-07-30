package org.medspa.training.service;

import org.medspa.training.model.Appointments;
import org.medspa.training.model.Clients;
import org.medspa.training.repository.iAppointmentsDao;
import org.medspa.training.repository.iClientsDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentsService {
    @Autowired
    private iAppointmentsDao appointmentsDao;

    public void save(Appointments appointment){
        appointmentsDao.save(appointment);
    }

    public List<Appointments> getAppointments(){
        return appointmentsDao.getAppointments();
    }

    public Appointments update(Appointments appointment){
        return appointmentsDao.getByDate(appointment.getDate());
    }

    public boolean delete(Appointments appointment){
        return appointmentsDao.delete(appointment);
    }

}
