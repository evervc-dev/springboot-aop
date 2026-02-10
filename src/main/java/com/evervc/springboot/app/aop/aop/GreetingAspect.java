package com.evervc.springboot.app.aop.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class GreetingAspect {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    // Doc: https://docs.spring.io/spring-framework/reference/core/aop/ataspectj/pointcuts.html
    // https://docs.spring.io/spring-framework/reference/core/aop/ataspectj/advice.html
    @Pointcut("execution(String com.evervc.springboot.app.aop.services.IGreetingService.sayHello(..))")
    public void greetingMethods(){}

    @Before("greetingMethods()")
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
}
