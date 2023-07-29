package org.medspa.training.repository.exception;
import org.medspa.training.model.Clients;
import java.util.List;


public interface iClientsDao {
    //get/save
    void save(Clients clients);

    //retrieve
     List<Clients> getClients();

    //update =retrieve + save
    Clients getById(long Id);


    //delete
    void delete(Clients clients);

    Clients getClientsEagerBy(Long id);
}
