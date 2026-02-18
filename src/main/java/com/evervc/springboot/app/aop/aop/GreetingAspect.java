package com.evervc.springboot.app.aop.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Order(2)
@Aspect
@Component
public class GreetingAspect {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Before("GreetingServicePointcuts.greetingMethods()")
    public void loggerBefore(JoinPoint joinPoint) {
        String method = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());
        logger.info("Antes de [" + method + "] con {" + args + "} como argumentos.");
    }

    @After("within(com.evervc.springboot.app.aop..*)")
    public void loggerAfter(JoinPoint joinPoint) {
        String method = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());
        logger.info("Después de [" + method + "] con {" + args + "} como argumentos.");
    }

    @AfterReturning("within(com.evervc.springboot.app.aop..*)")
    public void loggerAfterRetorning(JoinPoint joinPoint) {
        String method = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());
        logger.info("Después de retornar desde [" + method + "] con {" + args + "} como argumentos.");
    }

    @AfterThrowing("within(com.evervc.springboot.app.aop..*)")
    public void loggerAfterThrowing(JoinPoint joinPoint) {
        String method = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());
        logger.error("Después de lanzar la excepcion en [" + method + "] con {" + args + "} como argumentos.");
    }

    @Around("GreetingServicePointcuts.greetingMethods()")
    public Object loggerAround(ProceedingJoinPoint proceedingJoinPoint) {
        String method = proceedingJoinPoint.getSignature().getName();
        String args = Arrays.toString(proceedingJoinPoint.getArgs());

        Object response = null;
        try {
            logger.info("------> AL REDEDOR DEL METODO <------");
            logger.info("El método [" + method + "()] con los parametros {" + args + "}");
            response = proceedingJoinPoint.proceed(); // Ejecución del método
            logger.info("La respuesta del  método " + method + "() -> {" + response + "}");
            logger.info("------> FIN AL REDEDOR DEL METODO <------");
            return  response;
        } catch (Throwable e) {
            // Manda al error
            throw new RuntimeException(e);
        }
    }
}
