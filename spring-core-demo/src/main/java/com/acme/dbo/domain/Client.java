package com.acme.dbo.domain;

public class Client {
    private long id;
    private String name;

    public Client(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Client: { " + id + ", " + name + " }";
    }
}
