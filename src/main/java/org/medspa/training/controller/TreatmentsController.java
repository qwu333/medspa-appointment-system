package org.medspa.training.controller;

import org.medspa.training.model.Treatments;
import org.medspa.training.service.TreatmentsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/treatments")
public class TreatmentsController {

    private final Logger logger = LoggerFactory.getLogger(TreatmentsController.class);

    @Autowired
    private TreatmentsService treatmentsService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<Treatments> getTreatments(){
        List<Treatments> treatments = treatmentsService.getTreatments();
        return treatments;
    }

    @RequestMapping(value = "/{treatmentName}", method = RequestMethod.GET)
    public Treatments getByTreatmentName(@PathVariable(name = "treatmentName") String treatmentName){
        logger.info("This is Treatment controller, get by{} ", treatmentName);
        return treatmentsService.getBy(treatmentName);
    }

    @RequestMapping(value = "/{treatmentName}", method = RequestMethod.PATCH, params = {"target"})
    public Treatments updateTreatmentTarget(@PathVariable("treatmentName") String treatmentName, @RequestParam("target") String target){
        logger.info("pass in variable treatment: {} and target: {}", treatmentName, target);
        Treatments t = treatmentsService.getBy(treatmentName);
        t.setTarget(target);
        t = treatmentsService.update(t);
        return t;
    }


    @RequestMapping(value = "", method = RequestMethod.POST)
    public void create(@RequestBody Treatments treatment){
        logger.info("Post a new object {}", treatment.getTreatmentName());

        treatmentsService.save(treatment);
    }
}
