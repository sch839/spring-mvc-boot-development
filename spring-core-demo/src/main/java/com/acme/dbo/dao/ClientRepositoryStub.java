package com.acme.dbo.dao;

import com.acme.dbo.domain.Client;
import com.sun.tools.javac.util.List;

import java.util.Collection;

public class ClientRepositoryStub implements ClientRepository {
    private String clientsName;

    public ClientRepositoryStub(String clientsName) {
        this.clientsName = clientsName;
    }

    @Override
    public Client findById(long id) {
        return new Client(clientsName);
    }

    @Override
    public Collection<Client> findAll() {
        return List.of(new Client(clientsName + " 1"), new Client(clientsName + " 2"));
    }
}
