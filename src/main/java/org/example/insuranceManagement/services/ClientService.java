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


        if(client.getName() == null || client.getName().isEmpty()){
            throw new IllegalStateException("Client name is required");
        }

        if(client.getEmail() == null || client.getEmail().isEmpty()){
            throw new IllegalStateException("Client email is required");
        }

        if(clientEmailOptional.isPresent()){
            throw new IllegalStateException("Client with this email already exists");
        }

    
        if(!client.getEmail().matches("^[A-Za-z0-9+_.-]+@(.+)$")){
            throw new IllegalStateException("Client email is not in correct format");
        }

        if(client.getPhone() == null || client.getPhone().isEmpty()){
            throw new IllegalStateException("Client phone is required");
        }

        if(!client.getPhone().matches("^[0-9]{10}$")){
            throw new IllegalStateException("Client phone is not in correct format");
        }

        if (clientPhoneOptional.isPresent()){
            throw new IllegalStateException("Client with this phone already exists");
        }

        Client addedClient= clientRepository.save(client);

        return addedClient;
    }
}
