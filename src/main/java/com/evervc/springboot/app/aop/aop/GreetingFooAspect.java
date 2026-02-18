package com.evervc.springboot.app.aop.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Order(1)
@Component
@Aspect
public class GreetingFooAspect extends GreetingServicePointcuts {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Before("greetingFooMethods()")
    public void loggerBefore(JoinPoint joinPoint) {
        String method = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());
        logger.info("Método:: [" + method + "] invocado con los parametros:: {" + args + "}");
    }

    // Este método se invoca al final de todos, al tener el valor de la notación @Order en 1
    // es como si envolviera la ejecución de el que tiene el valor 2
    @After("greetingFooMethods()")
    public void loggerAfter(JoinPoint joinPoint) {
        String method = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());
        logger.info("Después del método:: [" + method + "] invocado con los parametros:: {" + args + "}");
    }
}
