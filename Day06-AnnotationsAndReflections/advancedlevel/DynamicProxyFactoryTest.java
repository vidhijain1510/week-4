package com.capgeminitraining.week4.day6annotationsreflection.reflections.advancedlevel;

import org.junit.jupiter.api.Test;
import java.lang.reflect.Proxy;
import static org.junit.jupiter.api.Assertions.*;

class DynamicProxyFactoryTest {
    @Test
    void testMethodInvocationLogging() {

        Greeting realGreeting = new GreetingImpl();
        LoggingProxyHandler handler = new LoggingProxyHandler(realGreeting);

        Greeting proxy = (Greeting) Proxy.newProxyInstance(
                Greeting.class.getClassLoader(),
                new Class[]{Greeting.class},
                handler
        );

        proxy.sayHello();
        assertEquals("sayHello", handler.getLastInvokedMethod());
    }

}