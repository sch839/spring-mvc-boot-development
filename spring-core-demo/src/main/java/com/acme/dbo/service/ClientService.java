package com.acme.dbo.service;

import com.acme.dbo.dao.ClientRepository;
import com.acme.dbo.domain.Client;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class ClientService {
    private ClientRepository clients;

    public ClientService(ClientRepository clients) {
        this.clients = clients;
    }

    public Collection<Client> getAll() {
        return clients.findAll();
    }
}
