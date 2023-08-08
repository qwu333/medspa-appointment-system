package org.medspa.training.service;

import org.medspa.training.model.Treatments;
import org.medspa.training.repository.iTreatmentsDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TreatmentsService {

    @Autowired
    private iTreatmentsDao treatmentsDao;
    public void save(Treatments treatment){
        treatmentsDao.save(treatment);
    }
    public List<Treatments> getTreatments(){
        return treatmentsDao.getTreatments();
    }

    public Treatments update(Treatments treatment){
        return treatmentsDao.update(treatment);
    }
    public boolean delete(Treatments treatment){
        return treatmentsDao.delete(treatment);
    }
    public Treatments getTreatmentsEager(long id){
        return treatmentsDao.getTreatmentsEagerBy(id);
    }
    public Treatments getBy(String treatmentName) {return treatmentsDao.getByTreatmentName(treatmentName);
    }


}
