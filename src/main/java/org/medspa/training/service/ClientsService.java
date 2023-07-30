package org.medspa.training.service;

import org.medspa.training.model.Clients;
import org.medspa.training.model.Treatments;
import org.medspa.training.repository.iClientsDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientsService {

    @Autowired
    private iClientsDao clientsDao;

    public void save(Clients client){
        clientsDao.save(client);
    }

    public List<Clients> getClients(){
        return clientsDao.getClients();
    }

    public Clients update(Clients client){
        return clientsDao.getById(client.getId());
    }

    public boolean delete(Clients client){
        return clientsDao.delete(client);
    }

    public Clients getClientsEager(long id){
        return clientsDao.getClientsEagerBy(id);
    }
}
