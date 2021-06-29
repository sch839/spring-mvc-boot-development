package com.acme.dbo;

import com.acme.dbo.service.ClientService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {
    public static void main( String[] args ) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("application-config.xml");
        ClientService clientService = context.getBean(ClientService.class);

        clientService.getAll().forEach(System.out::println);

        context.close();
    }
}
