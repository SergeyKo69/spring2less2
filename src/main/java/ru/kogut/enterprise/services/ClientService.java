package ru.kogut.enterprise.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kogut.enterprise.models.Client;
import ru.kogut.enterprise.repository.ClientRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Transactional
    public void saveClient(Client client){
        if (client == null) return;
        clientRepository.save(client);
    }

    @Transactional
    public Client getClientById(String id){
        if (id.isEmpty() || id == null) return null;
        Optional<Client> clientOptional = clientRepository.findById(id);
        if (clientOptional.orElse(null) == null) return null;
        return clientOptional.get();
    }

    @Transactional
    public List<Client> getAllClients(){
        return (List<Client>) clientRepository.findAll();
    }

    @Transactional
    public void updateClient(Client client){
        saveClient(client);
    }

    @Transactional
    public void deleteClient(Client client){
        if (client == null) return;
        clientRepository.delete(client);
    }

}
