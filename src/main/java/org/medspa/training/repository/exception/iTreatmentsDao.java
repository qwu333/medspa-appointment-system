package org.medspa.training.repository.exception;

import org.medspa.training.model.Treatments;

import java.util.List;

public interface iTreatmentsDao {

    //create
    void save(Treatments treatments);
    List<Treatments> getTreatments();// retrieve

    //update = get + save
    Treatments getByTreatmentName(String treatmentName);

    //delete
    void delete(Treatments treatments);

    Treatments getTreatmentsEagerBy(Long id);
}
