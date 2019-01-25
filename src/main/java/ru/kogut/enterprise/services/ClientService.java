package ru.kogut.enterprise.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kogut.enterprise.models.Client;
import ru.kogut.enterprise.repository.ClientRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public void saveClient(Client client){
        if (client == null) return;
        clientRepository.save(client);
    }

    public Client getClientById(String id){
        if (id.isEmpty() || id == null) return null;
        Optional<Client> clientOptional = clientRepository.findById(id);
        return clientOptional.get();
    }

    public List<Client> getAllClients(){
        return (List<Client>) clientRepository.findAll();
    }

    public void updateClient(Client client){
        saveClient(client);
    }

    public void deleteClient(Client client){
        if (client == null) return;
        deleteClient(client);
    }

}
