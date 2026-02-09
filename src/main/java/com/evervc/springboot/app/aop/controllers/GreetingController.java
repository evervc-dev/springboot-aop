package com.evervc.springboot.app.aop.controllers;

import com.evervc.springboot.app.aop.services.IGreetingService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;

@RestController
@RequestMapping("/api/aop")
@RequiredArgsConstructor
public class GreetingController {

    private final IGreetingService greetingService;

    @GetMapping("/greeting")
    public ResponseEntity<?> greeting() {
        return ResponseEntity.ok(Collections.singletonMap("message", greetingService.sayHello("Ever", "Hola ")));
    }
}
