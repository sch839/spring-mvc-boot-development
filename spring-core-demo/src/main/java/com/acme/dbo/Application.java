package com.acme.dbo;

import com.acme.dbo.dao.ClientRepositoryStub;
import com.acme.dbo.service.ClientService;

public class Application {
    public static void main( String[] args ) {
        ClientService clientService = new ClientService(new ClientRepositoryStub("client"));
        clientService.getAll().forEach(System.out::println);
    }
}
