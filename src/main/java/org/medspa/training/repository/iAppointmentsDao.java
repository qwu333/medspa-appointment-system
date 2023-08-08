package org.medspa.training.repository;

import org.medspa.training.model.Appointments;
import java.util.List;

public interface iAppointmentsDao {
    void save(Appointments appointments);

    List<Appointments> getAppointments();

    Appointments getById(Long id);

    boolean delete(Appointments appointments);

    Appointments update(Appointments appointments);
}
