package com.evervc.springboot.app.aop.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class GreetingServicePointcuts {
    // Doc: https://docs.spring.io/spring-framework/reference/core/aop/ataspectj/pointcuts.html
    // https://docs.spring.io/spring-framework/reference/core/aop/ataspectj/advice.html
    @Pointcut("execution(String com.evervc.springboot.app.aop.services.IGreetingService.sayHello(..))")
    private void greetingMethods(){} // Puede ser privado o público, Spring siempre lo alcanza y simplemente de indica la ruta

    @Pointcut("execution(String com.evervc.springboot.app.aop.services.IGreetingService.sayHello(..))")
    protected void greetingFooMethods(){} // Puede tener cualquier modificador de acceso ya que se usa en una clase hija
}
