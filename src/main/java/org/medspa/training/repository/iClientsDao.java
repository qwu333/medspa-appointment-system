package org.medspa.training.repository;
import org.medspa.training.model.Clients;
import java.util.List;


public interface iClientsDao {
    //get/save
    void save(Clients clients);

    //retrieve
     List<Clients> getClients();

    //update =retrieve + save
    Clients getById(Long Id);

    Clients update(Clients clients);

    //delete
    boolean delete(Clients clients);

    Clients getClientsEagerBy(Long id);
}
