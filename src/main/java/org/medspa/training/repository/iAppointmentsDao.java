package org.medspa.training.repository;

import org.medspa.training.model.Appointments;

import java.sql.Date;
import java.util.List;

public interface iAppointmentsDao {
    //create/save
    void save(Appointments appointments);

    //retrieve
    List<Appointments> getAppointments();

    Appointments getById(Long id);

    boolean delete(Appointments appointments);

    Appointments update(Appointments appointments);
}
