package org.medspa.training.repository;
import org.medspa.training.model.Clients;
import java.util.List;


public interface iClientsDao {
    void save(Clients clients);

     List<Clients> getClients();

    Clients getById(Long Id);

    Clients update(Clients clients);

    boolean delete(Clients clients);

    Clients getClientsEagerBy(Long id);
}
