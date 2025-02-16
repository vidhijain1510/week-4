/*Dependency Injection using Reflection: Implement a simple DI container that scans classes with @Inject annotation and injects dependencies dynamically.*/
package com.capgeminitraining.week4.day6annotationsreflection.reflections.advancedlevel;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface Inject {
}

interface Service {
    void serve();
}

class ServiceImpl implements Service {
    @Override
    public void serve() {
        System.out.println("Service is serving...");
    }
}
class Client {
    @Inject
    private Service service;

    public void doSomething() {
        service.serve();
    }
}

class DIContainer {
    private final Map<Class<?>, Object> instances = new HashMap<>();

    public <T> void register(Class<T> interfaceType, T implementation) {
        instances.put(interfaceType, implementation);
    }

    public void injectDependencies(Object obj) {
        Field[] fields = obj.getClass().getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(Inject.class)) {
                Class<?> fieldType = field.getType();
                Object dependency = instances.get(fieldType);

                if (dependency != null) {
                    field.setAccessible(true);
                    try {
                        field.set(obj, dependency);
                    } catch (IllegalAccessException e) {
                        throw new RuntimeException("Failed to inject dependency: " + fieldType.getName(), e);
                    }
                } else {
                    throw new RuntimeException("No registered implementation found for " + fieldType.getName());
                }
            }
        }
    }
}
public class InjectionReflection {
    public static void main(String[] args) {
        DIContainer diContainer = new DIContainer();
        diContainer.register(Service.class, new ServiceImpl());
        Client client = new Client();
        diContainer.injectDependencies(client);
        client.doSomething();
    }
}



