package com.evervc.springboot.app.aop.services;

import org.springframework.stereotype.Service;

@Service
public class GreetingService implements IGreetingService {
    @Override
    public String sayHello(String name, String phrase) {
        return phrase + name;
    }

    @Override
    public String sayHelloWithError(String name, String phrase) {
        throw new RuntimeException("Excepcion generada :(") ;
    }
}
