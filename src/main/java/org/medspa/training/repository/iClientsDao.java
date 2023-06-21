package org.medspa.training.repository;
import org.medspa.training.model.Clients;
import java.util.List;
import com.sun.security.ntlm.Client;

public interface iClientsDao {
    public List<Clients> getClients();
}
