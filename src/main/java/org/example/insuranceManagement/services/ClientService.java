package org.example.insuranceManagement.services;

import java.util.List;
import java.util.Optional;

import org.example.insuranceManagement.entity.Client;
import org.example.insuranceManagement.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientService {
    private final ClientRepository clientRepository;

    @Autowired
    public ClientService(ClientRepository clientRepository){
        this.clientRepository=clientRepository;
    }

    public List<Client> getClients(){
        return clientRepository.findAll();
    }

    public Client addClient(Client client){
        Optional<Client> clientEmailOptional=clientRepository.findByEmail(client.getEmail());
        Optional<Client> clientPhoneOptional=clientRepository.findByPhone(client.getPhone());

        if(clientEmailOptional.isPresent()){
            throw new IllegalStateException("Client with this email already exists");
        }

        if (clientPhoneOptional.isPresent()){
            throw new IllegalStateException("Client with this phone already exists");
        }

        Client addedClient= clientRepository.save(client);

        return addedClient;
    }
}
