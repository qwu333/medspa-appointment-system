package org.medspa.training.repository;

import org.medspa.training.model.Appointments;
import java.util.List;

public interface iAppointmentsDao {
    //create/save
    void save(Appointments appointments);

    //retrieve
    List<Appointments> getAppointments();

    Appointments getByClient(long clientId);

    void delete(Appointments appointments);
}
