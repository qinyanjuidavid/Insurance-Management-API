package org.example.insuranceManagement.controller;

import java.util.List;

import org.example.insuranceManagement.entity.Client;
import org.example.insuranceManagement.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="api/v1/clients")
public class ClientController {
    private final ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService){
        this.clientService=clientService;
    }

    @GetMapping
    public List<Client> getClients(){
        return clientService.getClients();
    }

    @PostMapping("/")
    public ResponseEntity<Client> addClient(@RequestBody Client client){
        Client newClient= clientService.addClient(client);

        return ResponseEntity.ok(newClient);
    }
    
}
