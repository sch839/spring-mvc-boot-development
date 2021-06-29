package com.acme.dbo.service;

import com.acme.dbo.dao.ClientRepository;
import com.acme.dbo.domain.Client;

import java.util.Collection;

public class ClientService {
    private ClientRepository clients;

    public ClientService(ClientRepository clients) {
        this.clients = clients;
    }

    public Collection<Client> getAll() {
        return clients.findAll();
    }
}
