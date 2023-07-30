package org.medspa.training.repository;

import org.medspa.training.model.Treatments;

import java.util.List;

public interface iTreatmentsDao {

    //create
    void save(Treatments treatments);
    List<Treatments> getTreatments();// retrieve

    //update = get + save
    Treatments getByTreatmentName(String treatmentName);

    //delete
    boolean delete(Treatments treatments);

    Treatments getTreatmentsEagerBy(Long id);
}
