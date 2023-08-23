package org.medspa.training.controller;

import org.medspa.training.model.Appointments;
import org.medspa.training.model.Clients;
import org.medspa.training.service.AppointmentsService;
import org.medspa.training.service.ClientsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

@RestController
@RequestMapping(value = "appointments")
public class AppointmentsController {
    private final Logger logger = LoggerFactory.getLogger(AppointmentsController.class);

    @Autowired
    private AppointmentsService appointmentsService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<Appointments> getAppointments(){
        // logger.info("This is Appointments Controller");
        List<Appointments> appointments = appointmentsService.getAppointments();
        return appointments;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Appointments getByDate(@PathVariable(name = "id") Long id){
        logger.info("This is Appointments controller, get by{} ", id);
        return appointmentsService.getBy(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PATCH, params = {"time"})
    public Appointments updateAppointmentTime(@PathVariable("id") Long id, @RequestParam("time") Time time){
        logger.info("pass in variable id: {} and time: {}", id.toString(), time);
        Appointments a = appointmentsService.getBy(id);
        a.setTime(time);
        a = appointmentsService.update(a);
        return a;
    }


    @RequestMapping(value = "", method = RequestMethod.POST)
    public void create(@RequestBody Appointments appointment){
        logger.info("Post a new object {}", appointment.getDate());

        appointmentsService.save(appointment);
    }
}
