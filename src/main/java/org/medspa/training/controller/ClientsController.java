package org.medspa.training.controller;

import org.medspa.training.model.Clients;
import org.medspa.training.service.ClientsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/clients")
public class ClientsController {

    private final Logger logger = LoggerFactory.getLogger(ClientsController.class);

    @Autowired
    private ClientsService clientsService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<Clients> getClients(){
        // logger.info("This is Clients Controller");
        List<Clients> clients = clientsService.getClients();
        return clients;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Clients getById(@PathVariable(name = "id") long id){
        logger.info("This is Clients controller, get by{} ", id);
        return clientsService.getBy(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PATCH, params = {"firstName"})
    public Clients updateClientFirstName(@PathVariable("id") Long id, @RequestParam("firstName") String firstName){
        logger.info("pass in variable client: {} and firstName: {}", id.toString(), firstName);
        Clients c = clientsService.getBy(id);
        c.setFirstName(firstName);
        c = clientsService.update(c);
        return c;
    }


    @RequestMapping(value = "", method = RequestMethod.POST)
    public void create(@RequestBody Clients client){
        logger.info("Post a new object {}", client.getFirstName());

        clientsService.save(client);
    }
}
