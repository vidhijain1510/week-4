/*Custom Logging Proxy Using Reflection:
Implement a Dynamic Proxy that intercepts method calls on an interface (e.g., Greeting.sayHello())
and logs the method name before executing it.*/
package com.capgeminitraining.week4.day6annotationsreflection.reflections.advancedlevel;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

interface Greeting {
    void sayHello();
}

class GreetingImpl implements Greeting {
    @Override
    public void sayHello() {
        System.out.println("Hello, World!");
    }
}

class LoggingProxyHandler implements InvocationHandler {
    private final Object target;
    private String lastInvokedMethod;

    public LoggingProxyHandler(Object target) {
        this.target = target;
    }

    public String getLastInvokedMethod() {
        return lastInvokedMethod;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        lastInvokedMethod = method.getName();
        System.out.println("Invoking method: " + method.getName());
        return method.invoke(target, args);
    }
}

class ProxyFactory {
    @SuppressWarnings("unchecked")
    public static <T> T createProxy(T target, Class<T> interfaceType) {
        LoggingProxyHandler handler = new LoggingProxyHandler(target);
        return (T) Proxy.newProxyInstance(
                interfaceType.getClassLoader(),
                new Class[]{interfaceType},
                handler
        );
    }
}

public class DynamicProxyFactory {
    public static void main(String[] args) {
        Greeting realGreeting = new GreetingImpl();

        Greeting proxy = ProxyFactory.createProxy(realGreeting, Greeting.class);

        proxy.sayHello();
    }
}
