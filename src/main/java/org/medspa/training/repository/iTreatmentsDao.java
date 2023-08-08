package org.medspa.training.repository;

import org.medspa.training.model.Treatments;

import java.util.List;

public interface iTreatmentsDao {

    void save(Treatments treatments);
    List<Treatments> getTreatments();// retrieve

    Treatments getByTreatmentName(String treatmentName);

    boolean delete(Treatments treatments);

    Treatments update(Treatments treatments);

    Treatments getTreatmentsEagerBy(Long id);
}
