package com.evervc.springboot.app.aop.services;

public interface IGreetingService {
    String sayHello(String name, String phrase);
    String sayHelloWithError(String name, String phrase);
}
