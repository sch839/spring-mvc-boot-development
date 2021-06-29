package com.acme.dbo.dao;

import com.acme.dbo.domain.Client;

import java.util.Collection;

public interface ClientRepository {
    Client findById(long id);
    Collection<Client> findAll();
}
