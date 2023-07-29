package org.medspa.training.repository.exception;

import org.medspa.training.model.Appointments;

import java.sql.Date;
import java.util.List;
import java.util.Set;

public interface iAppointmentsDao {
    //create/save
    void save(Appointments appointments);

    //retrieve
    List<Appointments> getAppointments();

    Appointments getByDate(Date date);

    void delete(Appointments appointments);
}
