package org.medspa.training.repository;

import org.medspa.training.model.Appointments;
import java.util.List;

public interface iAppointmentsDao {
    public List<Appointments> getAppointments();
}
