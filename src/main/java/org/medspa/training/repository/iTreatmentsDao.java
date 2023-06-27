package org.medspa.training.repository;

import org.medspa.training.model.Treatments;

import java.util.List;

public interface iTreatmentsDao {
    public List<Treatments> getTreatments();
}
